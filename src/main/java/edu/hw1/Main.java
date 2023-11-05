package edu.hw1;

import edu.project2.MazeSolver.BackTrackingSolver;
import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import edu.project2.MazeGenerator.BacktrackingGenerator;
import edu.project2.MazeVisualizer;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.View;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.GridBagConstraints;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public final class Main {
    public static void main(String[] args) {
        BacktrackingGenerator backtrackingGenerator = new BacktrackingGenerator();

        Maze maze = backtrackingGenerator.generate(8, 8);
        maze.Print();
        Scanner in = new Scanner(System.in);
        int startRow = in.nextInt();
        int startCol = in.nextInt();
        int endRow = in.nextInt();
        int endCol = in.nextInt();
        Coordinate start = new Coordinate(startRow, startCol);
        Coordinate end = new Coordinate(endRow, endCol);
        // Создаем окно для отображения лабиринта
        JFrame frame = new JFrame("Maze Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazeVisualizer visualizer = new MazeVisualizer(maze, new BackTrackingSolver().solve(maze, start, end));
        frame.setLayout(new BorderLayout());
        frame.add(visualizer, BorderLayout.CENTER);
        frame.setSize(1920, 1280);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
