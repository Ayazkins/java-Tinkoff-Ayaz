package edu.project2.Render;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.Entities.Type;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;


public class MazeVisualizer extends JPanel {
    private Maze maze;
    private List<Coordinate> coordinateList;
    private List<Coordinate> cells;

    public MazeVisualizer(Maze maze, List<Coordinate> list, List<Coordinate> cells) {
        this.maze = maze;
        coordinateList = list;
        this.cells = cells;
    }

    public MazeVisualizer(Maze maze) {
        this.maze = maze;
        coordinateList = null;
        this.cells = null;
    }

    public void update(Maze maze) {
        this.maze = maze;
    }

    public void update(Maze maze, List<Coordinate> coordinates, List<Coordinate> cells) {
        this.maze = maze;
        this.coordinateList = coordinates;
        this.cells = cells;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = Math.min(getWidth() / maze.getWidth(), getHeight() / maze.getHeight());
        for (int row = 0; row < maze.getHeight(); row++) {
            for (int col = 0; col < maze.getWidth(); col++) {
                Cell cell = maze.getCell(row, col);
                int x = col * cellSize;
                int y = row * cellSize;

                if (cell.getType() == Type.WALL) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(x, y, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellSize, cellSize);
            }
        }
        if (!(cells == null) && !cells.isEmpty()) {
            for (var coordinate : cells) {
                int row = coordinate.row();
                int col = coordinate.col();
                int x = col * cellSize;
                int y = row * cellSize;

                g.setColor(Color.RED);

                g.fillRect(x, y, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellSize, cellSize);
            }
        }
        if (!(coordinateList == null) && !coordinateList.isEmpty()) {
            for (var coordinate : coordinateList) {
                int row = coordinate.row();
                int col = coordinate.col();
                int x = col * cellSize;
                int y = row * cellSize;

                g.setColor(Color.GREEN);

                g.fillRect(x, y, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellSize, cellSize);
            }
        }
    }
}
