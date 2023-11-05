package edu.project2.MazeSolver;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.Result;
import java.util.List;

public abstract class SolverBase implements Solver {
    public abstract Result solve(Maze maze, Coordinate start, Coordinate end);

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
}
