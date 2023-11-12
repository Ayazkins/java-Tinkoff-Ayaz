package edu.project2.MazeSolver;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class SolverBase implements Solver {
    public abstract Result solve(Maze maze, Coordinate start, Coordinate end);

    protected List<Cell> getNeighbours(Maze maze, Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        List<Cell> all = new ArrayList<>();
        Collections.addAll(all,
            maze.getUpCell(cell, 1),
            maze.getDownCell(cell, 1),
            maze.getLeftCell(cell, 1),
            maze.getRightCell(cell, 1));
        for (Cell curCell : all) {
            if (curCell != null) {
                neighbours.add(curCell);
            }
        }
        return neighbours;
    }
}
