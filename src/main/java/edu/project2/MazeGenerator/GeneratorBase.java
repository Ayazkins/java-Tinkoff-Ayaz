package edu.project2.MazeGenerator;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Maze;
import java.util.List;

public abstract class GeneratorBase implements Generator {
    public abstract Maze generate(int height, int width);

    public void getNeighbours(Maze maze, Cell cell, List<Cell> neighbours) {
        neighbours.clear();
        Cell curCell = maze.getUpCell(cell, 2);
        if (curCell != null) {
            neighbours.add(curCell);
        }
        curCell = maze.getDownCell(cell, 2);
        if (curCell != null) {
            neighbours.add(curCell);
        }
        curCell = maze.getLeftCell(cell, 2);
        if (curCell != null) {
            neighbours.add(curCell);
        }
        curCell = maze.getRightCell(cell, 2);
        if (curCell != null) {
            neighbours.add(curCell);
        }
    }

    protected Cell getRandomNeighbour(List<Cell> neighbours) {

        return neighbours.get((int) (Math.random() * neighbours.size()));
    }

    protected void removeWall(Maze maze, Cell cell1, Cell cell2) {
        if (cell1.getCol() > cell2.getCol()) {
            maze.getRightCell(cell2, 1).toPassage();
        }
        if (cell1.getCol() < cell2.getCol()) {
            maze.getLeftCell(cell2, 1).toPassage();
        }
        if (cell1.getRow() < cell2.getRow()) {
            maze.getDownCell(cell2, 1).toPassage();
        }
        if (cell1.getRow() > cell2.getRow()) {
            maze.getUpCell(cell2, 1).toPassage();
        }
    }
}
