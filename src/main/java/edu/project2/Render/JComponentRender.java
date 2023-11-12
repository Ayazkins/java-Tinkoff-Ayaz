package edu.project2.Render;

import edu.project2.Entities.Coordinate;
import edu.project2.Entities.Maze;
import java.util.List;
import javax.swing.JFrame;

public class JComponentRender implements Renderer {
    public void renderPath(Maze maze, List<Coordinate> path, List<Coordinate> visitedCells) {
        JFrame frame = new JFrame("Maze Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazeVisualizer visualizer = new MazeVisualizer(maze, path, visitedCells);
        frame.add(visualizer);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public void renderMaze(Maze maze) {
        renderPath(maze, null, null);
    }

}
