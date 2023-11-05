package edu.project2.MazeSolver;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import java.util.List;
import java.util.Stack;

public abstract class SolverBase implements Solver {
    public abstract List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);

    protected void getNeighbours(Maze maze, Cell cell, List<Cell> neighbours) {
        neighbours.clear();
        Cell curCell = maze.getUpCell(cell, 1);
        if (curCell != null) {
            neighbours.add(curCell);
        }
        curCell = maze.getDownCell(cell, 1);
        if (curCell != null) {
            neighbours.add(curCell);
        }
        curCell = maze.getLeftCell(cell, 1);
        if (curCell != null) {
            neighbours.add(curCell);
        }
        curCell = maze.getRightCell(cell, 1);
        if (curCell != null) {
            neighbours.add(curCell);
        }
    }

    protected Cell getRandomNeighbour(List<Cell> neighbours) {

        return neighbours.get((int) (Math.random() * neighbours.size()));
    }
}
