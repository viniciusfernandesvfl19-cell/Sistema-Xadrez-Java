package application;

import chess.ChessMatch;
import chess.ChessPosition;
import chess.Color;
import chess.chessPiece;

import java.util.*;
import java.util.stream.Collectors;

public class UI {

    public static ChessPosition readChessPosition(Scanner sc) {
        try {

            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, (char) row);

        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading chess position");
        }
    }

    public static void printMatch(ChessMatch chessMatch, List<chessPiece> captured) {
        printBoard(chessMatch.getPieces());
        System.out.println();
        printCapturePieces(captured);
        System.out.println();
        System.out.println("Turn: " + chessMatch.getTurn());
        if (!chessMatch.getCheckmate()) {
            System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
            if (chessMatch.getCheck()) {
                System.out.println("CHECK!");
            }
        } else {
            System.out.println("CHECKMATE!");
            System.out.println("Winner: " + chessMatch.getCurrentPlayer());
        }
    }

    public static void printBoard(chessPiece[][] pieces) {
        for (int i=0; i<pieces.length; i++) {
            System.out.print((8-i) + " ");
            for (int j=0; j<pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void printBoard(chessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i=0; i<pieces.length; i++) {
            System.out.print((8-i) + " ");
            for (int j=0; j<pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(chessPiece piece, boolean background) {
        if (background) {
            System.out.print("*");
        }
        else if (piece == null) {
            System.out.print("-");
        }
        else {
            System.out.print(piece);
        }
        System.out.print(" ");
    }

    private static void printCapturePieces(List<chessPiece> captured) {
        List<chessPiece> white = captured.stream()
                                            .filter(x -> x
                                            .getColor() == Color.WHITE)
                                            .collect(Collectors.toList());
        List<chessPiece> black = captured.stream()
                                            .filter(x -> x
                                            .getColor() == Color.BLACK)
                                            .collect(Collectors.toList());
        System.out.println("Captured pieces:");
        System.out.print("White ");
        System.out.println(Arrays.deepToString(white.toArray()));

        System.out.println("Captured pieces:");
        System.out.print("black ");
        System.out.println(Arrays.deepToString(black.toArray()));
    }
}
