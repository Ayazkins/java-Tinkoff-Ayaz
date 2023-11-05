package edu.project2.MazeSolver;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.Entities.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BackTrackingSolver extends SolverBase {
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        Stack<Cell> stack = new Stack<>();
        List<Cell> neighbours = new ArrayList<>();
        Cell currentTile = maze.getCell(start.row(), start.row());
        Stack<Coordinate> coordinates = new Stack<>();
        Set<Cell> visited = new HashSet<>();
        visited.add(currentTile);
        stack.push(currentTile);
        coordinates.push(new Coordinate(currentTile.getRow(), currentTile.getCol()));
        while (!stack.isEmpty()) {
            getNeighbours(maze, currentTile, neighbours);
            for (Iterator<Cell> iter = neighbours.iterator(); iter.hasNext(); ) {
                Cell cell = iter.next();
                if (cell.getRow() == end.row() && cell.getCol() == end.col()) {
                    coordinates.push(new Coordinate(cell.getRow(), cell.getCol()));
                    System.out.println(coordinates);
                    return coordinates.stream().toList();
                }
                if (visited.contains(cell) || cell.getType() == Type.WALL) {
                    iter.remove();
                }
            }

            if (neighbours.isEmpty()) {
                currentTile = stack.pop();
                coordinates.pop();
                continue;
            }

            Cell randomNeighbor = getRandomNeighbour(neighbours);
            coordinates.push(new Coordinate(randomNeighbor.getRow(), randomNeighbor.getCol()));
            currentTile = randomNeighbor;
            visited.add(randomNeighbor);
            stack.push(randomNeighbor);
        }
        return null;
    }
}
