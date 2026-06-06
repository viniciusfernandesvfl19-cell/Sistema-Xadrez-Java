package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.chessPieces.King;
import chess.chessPieces.Rook;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private Board board;

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<chessPiece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
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

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public chessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (chessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        if (capturedPiece != null) {
           piecesOnTheBoard.remove(capturedPiece);
           capturedPieces.add((chessPiece) capturedPiece);
        }
        return capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereISAPiece(position)) {
            throw new chessException("There is no piece on source position");
        }
        if (currentPlayer != ((chessPiece)board.piece(position)).getColor()) {
            throw new chessException("The chosen piece is not yours");
        }

        if (!board.piece(position).isTheAnyPossibleMoves()) {
            throw new chessException("There is no possible moves for the chosen piece");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new chessException("The chosen piece can't move to target position");
        }
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void placeNewPiece(char column, int row, chessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, (char) row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
