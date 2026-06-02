package chess;

import boardgame.Board;
import boardgame.Position;
import chess.chessPieces.King;
import chess.chessPieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public chessPiece[][] getPieces() {
        chessPiece[][] mat = new chessPiece[board.getRows()][board.getColumns()];
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getColumns(); c++) {
                mat[r][c] = (chessPiece) board.piece(r, c);
            }
        }
        return mat;
    }

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE),new Position(2, 1));
        board.placePiece(new King(board, Color.WHITE),new Position(0, 4));
        board.placePiece(new King(board, Color.WHITE),new Position(7, 4));
    }
}
