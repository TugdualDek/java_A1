import static java.lang.Math.abs;

public class Rook extends Piece {
    private Position position;
    private int color;

    public Rook(Position position, int color) {
        this.initPosition(position);
        this.color = color;
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board){
        boolean valid = false;
        int compt=0;
        if (newPosition.getRow()==this.getPosition().getRow() && abs(newPosition.getIntColumn()-this.getPosition().getIntColumn())<8){
            if (newPosition.getIntColumn()>this.getPosition().getIntColumn()){
                for(int i=this.getPosition().getIntColumn()+1;i<newPosition.getIntColumn();i++){
                    if (!board[this.getPosition().getRow() - 1][i].isEmpty()){
                        compt++;
                    }

                }
                if (compt==0 && (board[newPosition.getRow() - 1][newPosition.getIntColumn()].isEmpty() || board[newPosition.getRow()-1][newPosition.getIntColumn()].getPiece().getColour() != this.getColour())){
                    valid=true;
                }
            }

            else if (newPosition.getIntColumn()<this.getPosition().getIntColumn()){
                for(int i=this.getPosition().getIntColumn()-1;i>newPosition.getIntColumn();i--){
                    if (!board[newPosition.getRow() - 1][i].isEmpty()){
                        compt++;
                    }

                }
                if (compt==0 && (board[newPosition.getRow() - 1][newPosition.getIntColumn()].isEmpty() || board[newPosition.getRow()-1][newPosition.getIntColumn()].getPiece().getColour() != this.getColour())){
                    valid=true;
                }
            }
        }


        else if (newPosition.getIntColumn()==this.getPosition().getIntColumn() && abs(newPosition.getRow()-this.getPosition().getRow())<8){
            if (newPosition.getRow()>this.getPosition().getRow()){
                for(int i=this.getPosition().getRow()+1;i<newPosition.getRow();i++){
                    if (!board[i - 1][newPosition.getIntColumn()].isEmpty()){
                        compt++;
                    }

                }
                if (compt==0 && (board[newPosition.getRow() - 1][newPosition.getIntColumn()].isEmpty() || board[newPosition.getRow()-1][newPosition.getIntColumn()].getPiece().getColour() != this.getColour())){
                    valid=true;
                }
            }

            else if (newPosition.getRow()<this.getPosition().getRow()){
                for(int i=this.getPosition().getRow()-1;i>newPosition.getRow();i--){
                    if (!board[i - 1][newPosition.getIntColumn()].isEmpty()){
                        compt++;
                    }

                }
                if (compt==0 && (board[newPosition.getRow() - 1][newPosition.getIntColumn()].isEmpty() || board[newPosition.getRow()-1][newPosition.getIntColumn()].getPiece().getColour() != this.getColour())){
                    valid=true;
                }
            }
        }
        return valid;

    }

    @Override
    public String toString() {
        return "R";
    }
}
