package setcover;

import java.util.*;

public interface Graph {
    /** Creates a vertex with the given number. */
    void addVertex(int num);

    /** Creates an edge from the first vertex to the second. */
    void addEdge(int from, int to);

    /** Finds the egonet centered at a given node. */
    Graph getEgonet(int center);

    /** Returns all SCCs in a directed graph. Recall that the warm up
     * assignment assumes all Graphs are directed, and we will only
     * test on directed graphs. */
    List<Graph> getSCCs();

    /** Return the graph's connections in a readable format.
     * The keys in this HashMap are the vertices in the graph.
     * The values are the nodes that are reachable via a directed
     * edge from the corresponding key.
     * The returned representation ignores edge weights and
     * multi-edges.  */
    HashMap<Integer, HashSet<Integer>> exportGraph();

    /**
     * Method that returns all the vertices in this Graph
     * @return
     */
    HashSet<Node> getAllVertices();

    /**
     * Method that returns all edges in this graph
     * @return
     */
    ArrayList<Edge> getAllEdges();

    /**
     * Return a copy of an ArrayList of edges for node
     * @param node
     * @return
     */
    ArrayList<Edge> getNeighbors(Node node);

    /**
     * Return the number of edges in the graph
     * @return
     */
    int getNumEdges();

    /**
     * Return the number of vertices in the graph
     * @return
     */
    int getNumVertices();

    /**
     * Method to find the dominant set in a Graph
     * It returns a set of nodes which are a dominant set in the graph
     *
     * Step one:
     * @return
     */
    Set<Node> findDominantSet();

    /**
     * Method that finds all the uncovered neighbors from a node
     * @param node
     * @param coveredVertices
     * @return
     */
    Set<Node> numUncoveredVertices(Node node, HashSet<Node> coveredVertices);


    /**
     * Method to find the Minimum dominant set in a Graph
     * Returns a set of Nodes that represents The Minimum set
     * @return
     */
    Set<Node> bigStepGreedyAlgorithm();

    /**
     * Method that looks for the union of two vertices with the greatest number
     * of uncovered nodes. Returns a Set with these two nodes.
     * @return
     */
    Set<Node> getUnionTwoNodesMaximized(List<Node> vertices, HashSet<Node> coveredVertices, HashSet<Node> union, int[] max);
} 
