package edu.project2.MazeGenerator;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Maze;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class PrimGenerator extends GeneratorBase {
    private final static int MIN_RANGE = 3;

    @Override
    public Maze generate(int height, int width) {
        if (height < MIN_RANGE && width < MIN_RANGE) {
            throw new IllegalArgumentException("maze can not be so small");
        }
        Maze maze = new Maze(height, width);
        List<Cell> neighbours = new ArrayList<>();
        List<AbstractMap.SimpleImmutableEntry<Cell, Cell>> visited = new ArrayList<>();
        List<AbstractMap.SimpleImmutableEntry<Cell, Cell>> toVisit = new ArrayList<>();
        visited.add(new AbstractMap.SimpleImmutableEntry<>(maze.getCell(1, 1), null));
        getNeighbours(maze, maze.getCell(1, 1), neighbours);

        for (Cell cell : neighbours) {
            toVisit.add(new AbstractMap.SimpleImmutableEntry<>(cell, maze.getCell(1, 1)));
        }
        while (!toVisit.isEmpty()) {
            var randomCell = toVisit.get((int) (Math.random() * toVisit.size()));
            toVisit.remove(randomCell);
            visited.add(randomCell);
            Cell current = randomCell.getKey();
            Cell parent = randomCell.getValue();
            removeWall(maze, current, parent);
            getNeighbours(maze, current, neighbours);
            for (Cell a : neighbours) {
                if (!pairContains(toVisit, a) && !pairContains(visited, a) && a != null) {
                    toVisit.add(new AbstractMap.SimpleImmutableEntry<>(a, current));
                }
            }
        }

        return maze;
    }

    private boolean pairContains(List<AbstractMap.SimpleImmutableEntry<Cell, Cell>> cells, Cell cell) {
        for (var pair : cells) {
            if (pair.getKey() == cell) {
                return true;
            }
        }
        return false;
    }
}
