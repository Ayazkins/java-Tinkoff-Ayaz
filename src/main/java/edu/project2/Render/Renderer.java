package edu.project2.Render;

import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import java.util.List;

public interface Renderer {
    void renderPath(Maze maze, List<Coordinate> path, List<Coordinate> visitedCells);

     void renderMaze(Maze maze);
}
