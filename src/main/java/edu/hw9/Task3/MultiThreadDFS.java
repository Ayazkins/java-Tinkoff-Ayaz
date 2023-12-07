package edu.hw9.Task3;

import java.util.concurrent.RecursiveAction;

public class MultiThreadDFS extends RecursiveAction {
    private final Node curNode;

    public MultiThreadDFS(Node node) {
        curNode = node;
    }

    @Override
    protected void compute() {
        if (curNode.isVisited()) {
            return;
        }
        curNode.visit();
        for (Node node : curNode.getNeighbours()) {
            if (!node.isVisited()) {
                MultiThreadDFS multiThreadDFS = new MultiThreadDFS(node);
                multiThreadDFS.fork();
            }
        }
    }
}
