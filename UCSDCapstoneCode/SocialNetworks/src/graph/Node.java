package graph;

import java.util.Objects;

public class Node {
    private int idNode;

    public Node(int n) {
        this.idNode = n;
    }

    public int getIdNode() {
        return idNode;
    }

    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getIdNode() == node.getIdNode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNode());
    }

    @Override
    public String toString() {
        return "Node{" +
                "idNode=" + idNode +
                '}';
    }
}
