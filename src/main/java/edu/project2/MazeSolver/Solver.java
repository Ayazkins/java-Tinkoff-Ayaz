package edu.project2.MazeSolver;

import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.Result;


public interface Solver {
    Result solve(Maze maze, Coordinate start, Coordinate end);
}
