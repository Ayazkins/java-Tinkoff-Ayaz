package edu.project2.MazeGenerator;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Maze;
import java.util.List;

public abstract class GeneratorBase implements Generator {
    private final static int NEIGHBOURS_THROUGH_WALL = 2;
    private final static int NEIGHBOURS_NEAR = 1;

    public abstract Maze generate(int height, int width);

    protected void getNeighbours(Maze maze, Cell cell, List<Cell> neighbours) {
        neighbours.clear();
        Cell curCell = maze.getUpCell(cell, NEIGHBOURS_THROUGH_WALL);
        if (curCell != null) {
            neighbours.add(curCell);
        }
        curCell = maze.getDownCell(cell, NEIGHBOURS_THROUGH_WALL);
        if (curCell != null) {
            neighbours.add(curCell);
        }
        curCell = maze.getLeftCell(cell, NEIGHBOURS_THROUGH_WALL);
        if (curCell != null) {
            neighbours.add(curCell);
        }
        curCell = maze.getRightCell(cell, NEIGHBOURS_THROUGH_WALL);
        if (curCell != null) {
            neighbours.add(curCell);
        }
    }

    protected Cell getRandomNeighbour(List<Cell> neighbours) {

        return neighbours.get((int) (Math.random() * neighbours.size()));
    }

    protected void removeWall(Maze maze, Cell cell1, Cell cell2) {
        if (cell1 == null || cell2 == null) {
            return;
        }
        if (cell1.getCol() > cell2.getCol()) {
            maze.getRightCell(cell2, NEIGHBOURS_NEAR).toPassage();
        }
        if (cell1.getCol() < cell2.getCol()) {
            maze.getLeftCell(cell2, NEIGHBOURS_NEAR).toPassage();
        }
        if (cell1.getRow() < cell2.getRow()) {
            maze.getDownCell(cell2, NEIGHBOURS_NEAR).toPassage();
        }
        if (cell1.getRow() > cell2.getRow()) {
            maze.getUpCell(cell2, NEIGHBOURS_NEAR).toPassage();
        }
    }
}
