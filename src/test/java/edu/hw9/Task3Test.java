package edu.hw9;

import edu.hw9.Task2.DirectorySearchTask;
import edu.hw9.Task3.MultiThreadDFS;
import edu.hw9.Task3.Node;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    public void multiThreadDFSTest() {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");
        Node node8 = new Node("8");

        node1.addNeighbour(node2);
        node1.addNeighbour(node7);
        node2.addNeighbour(node4);
        node2.addNeighbour(node5);
        node3.addNeighbour(node8);
        node4.addNeighbour(node6);
        node5.addNeighbour(node6);
        node7.addNeighbour(node8);
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            MultiThreadDFS task = new MultiThreadDFS(node1);
            forkJoinPool.invoke(task);
        }
        Node[] test = new Node[] {node1, node2, node3, node4, node5, node6, node7, node8};
        for (var a : test) {
            assertTrue(a.isVisited());
        }
    }

}
