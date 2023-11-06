package edu.project2;

import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.MazeGenerator.BacktrackingGenerator;
import edu.project2.MazeSolver.BackTrackingSolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WrongInputsTest {
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
    @Test
    public void wrongStartEndPointsTest() {
        Maze mazeReady = new Maze(maze);
        BackTrackingSolver backTrackingSolver = new BackTrackingSolver();
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(1, 2);
        assertEquals(Result.END_IN_WALL, backTrackingSolver.solve(mazeReady, start, end));
        end = new Coordinate(1, 1);
        start = new Coordinate(1, 2);
        assertEquals(Result.START_IN_WALL, backTrackingSolver.solve(mazeReady, start, end));
    }

    @Test
    public void wrongMazeInputsTest() {
        BacktrackingGenerator backtrackingGenerator = new BacktrackingGenerator();
        try {
            backtrackingGenerator.generate(2, 1);
        }
        catch (IllegalArgumentException e){
            assertEquals("maze can not be so small", e.getMessage());
        }
    }
}
