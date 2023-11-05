package edu.project2;

import edu.project2.Entities.Cell;
import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.Entities.Type;
import edu.project2.MazeGenerator.BacktrackingGenerator;
import edu.project2.MazeSolver.BackTrackingSolver;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MazeVisualizer extends JPanel {
    private Maze maze;
    private List<Coordinate> coordinateList;

    public MazeVisualizer(Maze maze, List<Coordinate> list) {
        this.maze = maze;
        coordinateList = list;
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//
//        int cellSize = Math.min(getWidth() / maze.getWidth(), getHeight() / maze.getHeight());
//
//        for (int row = 0; row < maze.getHeight(); row++) {
//            for (int col = 0; col < maze.getWidth(); col++) {
//                Cell cell = maze.getCell(row, col);
//                int x = col * cellSize;
//                int y = row * cellSize;
//
//                if (cell.getType() == Type.WALL) {
//                    g.setColor(Color.BLACK);
//                } else {
//                    g.setColor(Color.WHITE);
//                }
//
//                g.fillRect(x, y, cellSize, cellSize);
//                g.setColor(Color.BLACK);
//                g.drawRect(x, y, cellSize, cellSize);
//            }
//        }
//    }

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
        if (coordinateList == null) {
            return;
        }
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
