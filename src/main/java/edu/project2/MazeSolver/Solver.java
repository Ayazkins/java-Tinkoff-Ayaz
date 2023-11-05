package edu.project2.MazeSolver;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import java.util.List;
import java.util.Stack;

public interface Solver {
    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);
}
