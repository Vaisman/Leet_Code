package Google;

public class BishopMove {
    class Cell{
        int r;
        int c;
        public Cell(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    public int getMinMoves(Cell start, Cell target){
        if(isSameDiagonal(start,target))
            return 1;
        if(isSameColorSquare(start,target))
            return 2;
        return -1;
    }

    public boolean isSameDiagonal(Cell source, Cell target){
        return Math.abs(source.r - target.r) == Math.abs(source.c - target.c);
    }

    public boolean isSameColorSquare(Cell source, Cell target){
        return (source.r + source.c)%2 == (target.r + target.c)%2;
    }
}
