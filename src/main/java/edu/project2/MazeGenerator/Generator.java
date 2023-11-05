package edu.project2.MazeGenerator;

import edu.project2.Entities.Maze;

public interface Generator {
    Maze generate(int height, int width);
}
