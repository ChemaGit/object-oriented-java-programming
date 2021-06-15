package maze2week;

import java.util.List;

public class MazeNode {
    private int row;
    private int column;
    private char dispChar;
    private List<MazeNode> neighbors;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getDispChar() {
        return dispChar;
    }

    public void setDispChar(char dispChar) {
        this.dispChar = dispChar;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public List<MazeNode> getNeighbors() {
        return neighbors;
    }

    public void addNeighbors(MazeNode node) {
        this.neighbors.add(node);
    }
}
