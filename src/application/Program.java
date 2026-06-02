package application;

import chess.ChessMatch;
import chess.ChessPosition;
import chess.chessException;
import chess.chessPiece;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    static void main() {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {

            try {
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("source: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                chessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (chessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
