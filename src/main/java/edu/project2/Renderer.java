package edu.project2;

import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import java.util.List;

public interface Renderer {
    String render(Maze maze);
    String render(Maze maze, List<Coordinate> path);
}
