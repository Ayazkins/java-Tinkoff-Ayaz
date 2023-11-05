package edu.project2.MazeGenerator;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Maze;
import edu.project2.Entities.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class KruskalGenerator extends GeneratorBase {
    private final static int MIN_RANGE = 3;

    @Override

    public Maze generate(int height, int width) {
        if (height < MIN_RANGE && width < MIN_RANGE) {
            throw new IllegalArgumentException("maze can not be so small");
        }
        Maze maze = new Maze(height, width);
        Map<Cell, Integer> cells = new HashMap<>();
        List<Cell> walls = new ArrayList<>();
        int id = 0;
        for (int i = 1; i < maze.getHeight() - 1; ++i) {
            for (int j = 1; j < maze.getWidth() - 1; ++j) {
                if (maze.getCell(i, j).getType() == Type.PASSAGE) {
                    cells.put(maze.getCell(i, j), id++);
                } else {
                    if (i == j) {
                        continue;
                    }
                    walls.add(maze.getCell(i, j));
                }
            }
        }
        while (!walls.isEmpty()) {
            Cell wall = walls.get((int) (Math.random() * walls.size()));
            walls.remove(wall);
            if (wall.getRow() % 2 == 0) {
                removeWalls(wall, maze.getDownCell(wall, 1), maze.getUpCell(wall, 1), cells);
            } else if (wall.getCol() % 2 == 0) {
                removeWalls(wall, maze.getRightCell(wall, 1), maze.getLeftCell(wall, 1), cells);
            }
        }
        return maze;
    }

    private void removeWalls(Cell wall, Cell cell1, Cell cell2, Map<Cell, Integer> cells) {
        if (Objects.equals(cells.get(cell1), cells.get(cell2)) || (cell1 == null && cell2 == null)) {
            return;
        }
        wall.toPassage();
        Integer id = cells.get(cell2);
        List<Cell> change = new ArrayList<>();
        Iterator iter = cells.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry a = (Map.Entry) iter.next();
            if (a.getValue() == id) {
                iter.remove();
                change.add((Cell) a.getKey());
            }
        }
        for (Cell cell : change) {
            cells.put(cell, cells.get(cell1));
        }

    }

}
