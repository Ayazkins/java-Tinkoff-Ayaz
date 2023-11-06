package edu.project2.MazeSolver;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.Entities.Type;
import edu.project2.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BackTrackingSolver extends SolverBase {
    public final List<Coordinate> coordinates;
    public final List<Coordinate> cells;

    public BackTrackingSolver() {
        coordinates = new ArrayList<>();
        cells = new ArrayList<>();
    }

    public Result solve(Maze maze, Coordinate start, Coordinate end) {
        if (maze.getCell(start.row(), start.col()).getType() == Type.WALL) {
            return Result.START_IN_WALL;
        }
        if (maze.getCell(end.row(), end.col()).getType() == Type.WALL) {
            return Result.END_IN_WALL;
        }

        Set<Cell> visited = new HashSet<>();
        Cell currentCell = maze.getCell(start.row(), start.col());
        Deque<Cell> stack = new LinkedList<>(Collections.synchronizedList(Arrays.asList(currentCell)));
        Map<Cell, Cell> parents = new HashMap<>();
        while (!stack.isEmpty()) {
            currentCell = stack.pop();
            if (currentCell.getCol() == end.col() && currentCell.getRow() == end.row()) {
                while (currentCell != null) {
                    coordinates.add(new Coordinate(currentCell.getRow(), currentCell.getCol()));
                    currentCell = parents.get(currentCell);
                }
                return Result.SUCCESS;
            }
            cells.add(new Coordinate(currentCell.getRow(), currentCell.getCol()));
            checkAndAddNeighbours(visited, currentCell, maze, parents, stack);

        }
        return Result.CAN_NOT_FIND_WAY;
    }

    public Result isValidMaze(Maze maze) {
        Set<Cell> allCells = initValidator(maze);
        Set<Cell> visited = new HashSet<>();
        Cell currentCell = maze.getCell(1, 1);
        Deque<Cell> stack = new LinkedList<>(Collections.synchronizedList(Arrays.asList(currentCell)));
        allCells.remove(currentCell);
        Map<Cell, Cell> parents = new HashMap<>();
        while (!stack.isEmpty()) {
            currentCell = stack.pop();
            allCells.remove(currentCell);
            cells.add(new Coordinate(currentCell.getRow(), currentCell.getCol()));
            checkAndAddNeighbours(visited, currentCell, maze, parents, stack);
        }
        if (allCells.isEmpty()) {
            return Result.VALID_MAZE;
        }
        return Result.INVALID_MAZE;
    }

    private Set<Cell> initValidator(Maze maze) {
        Set<Cell> allCells = new HashSet<>();
        for (int i = 0; i < maze.getHeight(); ++i) {
            for (int j = 0; j < maze.getWidth(); ++j) {
                if (maze.getCell(i, j).getType() == Type.PASSAGE) {
                    allCells.add(maze.getCell(i, j));
                }
            }
        }
        return allCells;
    }

    private void checkAndAddNeighbours(
        Set<Cell> visited,
        Cell currentCell,
        Maze maze,
        Map<Cell, Cell> parents,
        Deque<Cell> stack
    ) {
        List<Cell> neighbours = new ArrayList<>();
        if (!visited.contains(currentCell)) {
            visited.add(currentCell);
            neighbours = getNeighbours(maze, currentCell);
            for (var a : neighbours) {
                if (!visited.contains(a) && !(a.getType() == Type.WALL)) {
                    parents.put(a, currentCell);
                    stack.push(a);
                }
            }
        }
    }
}
