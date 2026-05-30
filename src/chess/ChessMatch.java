package chess;

import boardgame.Board;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
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
}
