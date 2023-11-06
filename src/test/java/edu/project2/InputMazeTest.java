package edu.project2;

import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.Entities.Type;
import edu.project2.MazeSolver.BackTrackingSolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputMazeTest {
    private final int[][] maze = { {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,0,0,1,1,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}

    };
    private final int[][] invalidMaze = { {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,0,0,1,1,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,1,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}

    };
    @Test
    public void isValidMazeTest() {
        BackTrackingSolver backTrackingSolver = new BackTrackingSolver();
        assertEquals(Result.VALID_MAZE, backTrackingSolver.isValidMaze(new Maze(maze)));
    }

    @Test
    public void findWayInValidMazeTest() {
        Maze readyMaze = new Maze(maze);
        BackTrackingSolver backTrackingSolver = new BackTrackingSolver();
        Coordinate start = new Coordinate(1, 1);
        for (int i = 0; i < maze.length; ++i) {
            for (int j = 0; j < maze[0].length; ++j) {
                if (readyMaze.getCell(i, j).getType() == Type.PASSAGE)
                    assertEquals(Result.SUCCESS, backTrackingSolver.solve(new Maze(maze), start, new Coordinate(i, j)));
            }
        }
    }

    @Test
    public void isInvalidMazeTest() {
        BackTrackingSolver backTrackingSolver = new BackTrackingSolver();
        assertEquals(Result.INVALID_MAZE, backTrackingSolver.isValidMaze(new Maze(invalidMaze)));
    }

    @Test
    public void findWayInInvalidValidMazeTest() {
        BackTrackingSolver backTrackingSolver = new BackTrackingSolver();
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(8, 11);
        assertEquals(Result.CAN_NOT_FIND_WAY, backTrackingSolver.solve(new Maze(invalidMaze), start, end));
    }
}
