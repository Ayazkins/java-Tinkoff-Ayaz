package edu.project2.MazeGenerator;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BacktrackingGenerator extends GeneratorBase {
    private final static int MIN_RANGE = 3;

    @Override
    public Maze generate(int height, int width) {
        if (height < MIN_RANGE && width < MIN_RANGE) {
            throw new IllegalArgumentException("maze can not be so small");
        }
        Maze maze = new Maze(height, width);
        List<Cell> neighbours;
        Cell currentCell = maze.getCell(1, 1);
        Set<Cell> visited = new HashSet<>(Collections.singletonList(currentCell));
        Deque<Cell> stack = new LinkedList<>(Collections.singletonList(currentCell));
        while (!stack.isEmpty()) {
            neighbours = getNeighbours(maze, currentCell);
            List<Cell> toRemove = new ArrayList<>();
            for (var neighbour : neighbours) {
                if (visited.contains(neighbour)) {
                    toRemove.add(neighbour);
                }
            }
            neighbours.removeAll(toRemove);

            if (neighbours.isEmpty()) {
                currentCell = stack.pop();
                continue;
            }

            Cell randomNeighbor = getRandomNeighbour(neighbours);

            removeWall(maze, currentCell, randomNeighbor);

            currentCell = randomNeighbor;
            visited.add(randomNeighbor);
            stack.push(randomNeighbor);
        }
        return maze;
    }
}
