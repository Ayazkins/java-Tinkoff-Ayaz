package edu.project2.Entities;

public final class Maze {
    private final static int WALL = 1;

    private final static int PASSAGE = 0;
    private final static int MIN_RANGE = 3;
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(int height, int width) {
        if (height < MIN_RANGE && width < MIN_RANGE) {
            throw new IllegalArgumentException("maze can not be so small");
        }
        this.height = height + 1;
        this.width = width + 1;
        grid = new Cell[this.height][this.width];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if ((i % 2 != 0 && j % 2 != 0) && i < this.height - 1 && j < this.width - 1) {
                    grid[i][j] = new Cell(i, j, Type.PASSAGE);
                } else {
                    grid[i][j] = new Cell(i, j, Type.WALL);
                }
            }
        }
    }

    public Maze(int[][] inputGrid) {
        if (inputGrid == null) {
            throw new IllegalArgumentException();
        }
        width = inputGrid[0].length;
        height = inputGrid.length;
        if (height < MIN_RANGE || width < MIN_RANGE) {
            throw new IllegalArgumentException();
        }
        grid = new Cell[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (inputGrid[i][j] == WALL) {
                    grid[i][j] = new Cell(i, j, Type.WALL);
                } else if (inputGrid[i][j] == PASSAGE) {
                    grid[i][j] = new Cell(i, j, Type.PASSAGE);
                } else {
                    throw new IllegalArgumentException();
                }
            }
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
}
