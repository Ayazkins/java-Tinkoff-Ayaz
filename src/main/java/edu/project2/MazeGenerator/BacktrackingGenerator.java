package edu.project2.MazeGenerator;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Maze;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BacktrackingGenerator extends GeneratorBase {
    private final static int MIN_RANGE = 3;

    @Override
    public Maze generate(int height, int width) {
        if (height < MIN_RANGE && width < MIN_RANGE) {
            throw new IllegalArgumentException("maze can not be so small");
        }
        Maze maze = new Maze(height, width);
        Stack<Cell> stack = new Stack<>();
        List<Cell> neighbours = new ArrayList<>();
        Cell currentTile = maze.getCell(1, 1);
        Set<Cell> visited = new HashSet<>();
        visited.add(currentTile);
        stack.push(currentTile);
        while (!stack.isEmpty()) {
            getNeighbours(maze, currentTile, neighbours);
            for (Iterator<Cell> iter = neighbours.iterator(); iter.hasNext();) {
                if (visited.contains(iter.next())) {
                    iter.remove();
                }
            }

            if (neighbours.isEmpty()) {
                currentTile = stack.pop();
                continue;
            }

            Cell randomNeighbor = getRandomNeighbour(neighbours);

            removeWall(maze, currentTile, randomNeighbor);

            currentTile = randomNeighbor;
            visited.add(randomNeighbor);
            stack.push(randomNeighbor);
        }
        return maze;
    }
}
