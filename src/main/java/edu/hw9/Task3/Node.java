package edu.hw9.Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Node {
    private final String name;

    private final List<Node> neighbours = new ArrayList<>();

    private final AtomicBoolean isVisited = new AtomicBoolean(false);

    public Node(String name) {
        this.name = name;
    }

    public void addNeighbour(Node node) {
        neighbours.add(node);
        node.getNeighbours().add(this);
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return isVisited.get();
    }

    public void visit() {
        isVisited.set(true);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }
}
