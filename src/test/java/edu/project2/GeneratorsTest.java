package edu.project2;

import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.Entities.Type;
import edu.project2.MazeGenerator.BacktrackingGenerator;
import edu.project2.MazeGenerator.KruskalGenerator;
import edu.project2.MazeGenerator.PrimGenerator;
import edu.project2.MazeSolver.BackTrackingSolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneratorsTest {
    @Test
    public void backtrackingGeneratorTest() {
        int height = 50;
        int width = 50;
        BacktrackingGenerator backtrackingGenerator = new BacktrackingGenerator();
        Maze maze = backtrackingGenerator.generate(height, width);
        BackTrackingSolver backTrackingSolver = new BackTrackingSolver();
        assertEquals(Result.ValidMaze, backTrackingSolver.isValidMaze(maze));

        Coordinate coordinate = new Coordinate(1, 1);
        for (int i = 0; i < maze.getHeight(); ++i) {
            for (int j = 0; j < maze.getWidth(); ++j) {
                if (maze.getCell(i, j).getType() == Type.PASSAGE)
                    assertEquals(Result.Success, backTrackingSolver.solve(maze, coordinate, new Coordinate(i, j)));
            }
        }
    }

    @Test
    public void kruskalGeneratorTest() {
        int height = 50;
        int width = 50;
        KruskalGenerator kruskalGenerator = new KruskalGenerator();
        Maze maze = kruskalGenerator.generate(height, width);
        BackTrackingSolver backTrackingSolver = new BackTrackingSolver();
        assertEquals(Result.ValidMaze, backTrackingSolver.isValidMaze(maze));

        Coordinate coordinate = new Coordinate(1, 1);
        for (int i = 0; i < maze.getHeight(); ++i) {
            for (int j = 0; j < maze.getWidth(); ++j) {
                if (maze.getCell(i, j).getType() == Type.PASSAGE)
                    assertEquals(Result.Success, backTrackingSolver.solve(maze, coordinate, new Coordinate(i, j)));
            }
        }
    }

    @Test
    public void primGeneratorTest() {
        int height = 50;
        int width = 50;
        PrimGenerator primGenerator = new PrimGenerator();
        Maze maze = primGenerator.generate(height, width);
        BackTrackingSolver backTrackingSolver = new BackTrackingSolver();
        assertEquals(Result.ValidMaze, backTrackingSolver.isValidMaze(maze));

        Coordinate coordinate = new Coordinate(1, 1);
        for (int i = 0; i < maze.getHeight(); ++i) {
            for (int j = 0; j < maze.getWidth(); ++j) {
                if (maze.getCell(i, j).getType() == Type.PASSAGE)
                    assertEquals(Result.Success, backTrackingSolver.solve(maze, coordinate, new Coordinate(i, j)));
            }
        }
    }


}
