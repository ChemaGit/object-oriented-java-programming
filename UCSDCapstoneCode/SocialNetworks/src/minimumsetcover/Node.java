package minimumsetcover;

import java.util.Objects;

/**
 * Class Node that represents an user in
 * the Social Media Net
 */
public class Node {
    // id user
    private int idNode;
    // if this node is already covered or not by the greedy algorithm
    private boolean covered;

    public Node(int n) {
        this.idNode = n;
        this.covered = false;
    }

    public int getIdNode() {
        return idNode;
    }

    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
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
