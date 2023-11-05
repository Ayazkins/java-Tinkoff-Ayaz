package edu.project2.Entities;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int height, int width) {
        this.height = height + 1;
        this.width = width + 1;
        grid = new Cell[this.height][this.width];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j <this.width; j++) {
                if ((i % 2 != 0 && j % 2 != 0) && i < this.height - 1 && j < this.width - 1) {
                    grid[i][j] = new Cell(i, j, Type.PASSAGE);
                } else {
                    grid[i][j] = new Cell(i, j, Type.WALL);
                }
            }
        }
    }

    public void Print() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (grid[i][j].getType() == Type.PASSAGE) {
                    System.out.print(0);
                } else {
                    System.out.print(1);
                }
            }
            System.out.print("\n");
        }
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public Cell getUpCell(Cell curCell, int distance) {
        return (curCell.getRow() + distance < height - 1) ? grid[curCell.getRow() + distance][curCell.getCol()] : null;
    }

    public Cell getRightCell(Cell curCell, int distance) {
        return (curCell.getCol() + distance < width - 1) ? grid[curCell.getRow()][curCell.getCol() + distance] : null;
    }

    public Cell getLeftCell(Cell curCell, int distance) {
        return (curCell.getCol() - distance > 0) ? grid[curCell.getRow()][curCell.getCol() - distance] : null;
    }

    public Cell getDownCell(Cell curCell, int distance) {
        return (curCell.getRow() - distance > 0) ? grid[curCell.getRow() - distance][curCell.getCol()] : null;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell[][] getGrid() {
        return grid;
    }
}
