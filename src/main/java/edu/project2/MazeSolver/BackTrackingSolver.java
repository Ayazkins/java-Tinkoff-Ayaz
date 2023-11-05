package edu.project2.MazeSolver;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.Entities.Type;
import edu.project2.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BackTrackingSolver extends SolverBase {
    public final List<Coordinate> coordinates;
    public final List<Coordinate> cells;

    public BackTrackingSolver() {
        coordinates = new ArrayList<>();
        cells = new ArrayList<>();
    }

    public Result solve(Maze maze, Coordinate start, Coordinate end) {
        if (maze.getCell(start.row(), start.col()).getType() == Type.WALL) {
            return Result.StartInWall;
        }
        if (maze.getCell(end.row(), end.col()).getType() == Type.WALL) {
            return Result.EndInWall;
        }

        coordinates.clear();
        cells.clear();
        Stack<Cell> stack = new Stack<>();
        Set<Cell> visited = new HashSet<>();
        Cell currentCell = maze.getCell(start.row(), start.row());
        stack.add(currentCell);
        Map<Cell, Cell> parents = new HashMap<>();
        List<Cell> neighbours = new ArrayList<>();
        while (!stack.isEmpty()) {
            currentCell = stack.pop();
            cells.add(new Coordinate(currentCell.getRow(), currentCell.getCol()));
            if (!visited.contains(currentCell)) {
                visited.add(currentCell);
                if (currentCell.getCol() == end.col() && currentCell.getRow() == end.row()) {
                    while (currentCell != null) {
                        coordinates.add(new Coordinate(currentCell.getRow(), currentCell.getCol()));
                        currentCell = parents.get(currentCell);
                    }
                    return Result.Success;
                }
                getNeighbours(maze, currentCell, neighbours);
                for (var a : neighbours) {
                    if (!visited.contains(a) && !(a.getType() == Type.WALL)) {
                        parents.put(a, currentCell);
                        stack.push(a);
                    }
                }
            }
        }
        return Result.CanNotFindWay;
    }

    public Result isValidMaze(Maze maze) {
        Set<Cell> allCells = new HashSet<>();
        for (int i = 0; i < maze.getHeight(); ++i) {
            for (int j = 0; j < maze.getWidth(); ++j) {
                if (maze.getCell(i, j).getType() == Type.PASSAGE) {
                    allCells.add(maze.getCell(i, j));
                }
            }
        }
        coordinates.clear();
        cells.clear();
        Stack<Cell> stack = new Stack<>();
        Set<Cell> visited = new HashSet<>();
        Cell currentCell = maze.getCell(1, 1);
        stack.add(currentCell);
        allCells.remove(currentCell);
        Map<Cell, Cell> parents = new HashMap<>();
        List<Cell> neighbours = new ArrayList<>();
        while (!stack.isEmpty()) {
            currentCell = stack.pop();
            allCells.remove(currentCell);
            cells.add(new Coordinate(currentCell.getRow(), currentCell.getCol()));
            if (!visited.contains(currentCell)) {
                visited.add(currentCell);
                getNeighbours(maze, currentCell, neighbours);
                for (var a : neighbours) {
                    if (!visited.contains(a) && !(a.getType() == Type.WALL)) {
                        parents.put(a, currentCell);
                        stack.push(a);
                    }
                }
            }
        }
        if (allCells.isEmpty()) {
            return Result.ValidMaze;
        }
        return Result.InvalidMaze;
    }
}
