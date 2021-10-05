package test;

import static org.junit.Assert.*;

import setcover.CapGraph;
import setcover.Edge;
import setcover.Graph;
import setcover.Node;
import org.junit.Before;
import org.junit.Test;
import util.GraphLoader;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Author Jose Maria
 */
public class TestSetCover {

    private Graph graph = new CapGraph();
    private Graph graphSetCover = new CapGraph();
    private Graph graphSetCoverB = new CapGraph();
    private Graph graphSetCoverC = new CapGraph();
    private Graph graphFacebook = new CapGraph();

    /**
     * Creating and loading the graphs
     * @throws Exception
     */
    @Before
    public void setup() throws Exception {
        GraphLoader.loadGraph(graph, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/my_data.txt");
        GraphLoader.loadGraph(graphSetCover, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/data_set_cover.txt");
        GraphLoader.loadGraph(graphSetCoverB, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/data_set_cover_b.txt");
        GraphLoader.loadGraph(graphSetCoverC, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/data_set_cover_c.txt");
        GraphLoader.loadGraph(graphFacebook, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/facebook_1000.txt");
    }

    /**
     * Testing the creation of the graphs
     */
    @Test
    public void testGraph() {
        System.out.println("testGraph \n");
        System.out.println("Test number of vertices in the graph.");
        assertEquals("testGraph: test num of vertices in the graph",5,graph.getNumVertices());
        System.out.println("");

        System.out.println("Test number of edges in the graph.");
        assertEquals("testGraph: test num of edges in the graph",8,graph.getNumEdges());
        System.out.println("");

        System.out.println("Test number of edges in a particular vertice");
        assertEquals("testGraph: test num of edges in a vertex",2, graph.getNeighbors(new Node(5)).size());
        assertEquals("testGraph: test num of edges in a vertex",2, graph.getNeighbors(new Node(4)).size());
        System.out.println("");

        System.out.println("Test method exportGraph");
        HashMap<Integer, HashSet<Integer>> graphToExport = graph.exportGraph();
        int vertices = graphToExport.size();
        AtomicInteger edges = new AtomicInteger();
        graphToExport.forEach( (k, v) -> {
            edges.addAndGet(v.size());
        });
        assertEquals("Test exportGraph method",true, graph.getNumVertices() == vertices && graph.getNumEdges() == edges.get());
        System.out.println("");

        System.out.println("Test method getNeighbors");
        assertEquals("Test getNeighbors method",true, graph.getNeighbors(new Node(5)).size() == 2);
        System.out.println("");

        System.out.println("Test method getAllVertices");
        assertEquals("Test getAllVertices method",true, graph.getAllVertices().size() == 5);
        System.out.println("");

        System.out.println("Test method getAllEdges");
        assertEquals("Test getAllEdges method",true, graph.getAllEdges().size() == 8);
        assertEquals("Test getAllEdges method",true, graph.getAllEdges().contains(new Edge(5, 1)));
        assertEquals("Test getAllEdges method",false, graph.getAllEdges().contains(new Edge(2, 5)));
        System.out.println("");

        System.out.println("Printing the graph");
        System.out.println(graph.toString());
    }

    /**
     * Testing the creation of the graphs
     */
    @Test
    public void testGraphSetCover() {
        System.out.println("testGraphSetCover \n");
        System.out.println("Test number of vertices in the testGraphSetCover.");
        assertEquals("testGraphSetCover: test num of vertices in the testGraphSetCover",13,graphSetCover.getNumVertices());
        System.out.println("");

        System.out.println("Test number of edges in the testGraphSetCover.");
        assertEquals("testGraphSetCover: test num of edges in the testGraphSetCover",38,graphSetCover.getNumEdges());
        System.out.println("");

        System.out.println("Test number of edges in a particular vertice");
        assertEquals("testGraphSetCover: test num of edges in a vertex",7, graphSetCover.getNeighbors(new Node(3)).size());
        assertEquals("testGraphSetCover: test num of edges in a vertex",4, graphSetCover.getNeighbors(new Node(10)).size());
        assertEquals("testGraphSetCover: test num of edges in a vertex",1, graphSetCover.getNeighbors(new Node(4)).size());
        System.out.println("");
    }

    /**
     * Testing the creation of the graphs
     */
    @Test
    public void testGraphSetCoverB() {
        System.out.println("testGraphSetCoverB \n");
        System.out.println("Test number of vertices in the testGraphSetCoverB.");
        assertEquals("testGraphSetCoverB: test num of vertices in the testGraphSetCoverB",8,graphSetCoverB.getNumVertices());
        System.out.println("");

        System.out.println("Test number of edges in the testGraphSetCoverB.");
        assertEquals("testGraphSetCoverB: test num of edges in the testGraphSetCoverB",18,graphSetCoverB.getNumEdges());
        System.out.println("");

        System.out.println("Test number of edges in a particular vertice");
        assertEquals("testGraphSetCoverB: test num of edges in a vertex",2, graphSetCoverB.getNeighbors(new Node(3)).size());
        assertEquals("testGraphSetCoverB: test num of edges in a vertex",3, graphSetCoverB.getNeighbors(new Node(2)).size());
        assertEquals("testGraphSetCoverB: test num of edges in a vertex",3, graphSetCoverB.getNeighbors(new Node(8)).size());
    }

    /**
     * Testing the creation of the graphs
     */
    @Test
    public void testGraphSetCoverC() {
        System.out.println("testGraphSetCoverC \n");
        System.out.println("Test number of vertices in the testGraphSetCoverC.");
        assertEquals("testGraphSetCoverC: test num of vertices in the testGraphSetCoverC",8,graphSetCoverC.getNumVertices());
        System.out.println("");

        System.out.println("Test number of edges in the testGraphSetCoverC.");
        assertEquals("testGraphSetCoverC: test num of edges in the testGraphSetCoverC",20,graphSetCoverC.getNumEdges());
        System.out.println("");

        System.out.println("Test number of edges in a particular vertice");
        assertEquals("testGraphSetCoverC: test num of edges in a vertex",5, graphSetCoverC.getNeighbors(new Node(5)).size());
        assertEquals("testGraphSetCoverC: test num of edges in a vertex",4, graphSetCoverC.getNeighbors(new Node(2)).size());
        assertEquals("testGraphSetCoverC: test num of edges in a vertex",1, graphSetCoverC.getNeighbors(new Node(8)).size());
    }

    /**
     * Testing method numUncoveredVertices
     * Test that checks the uncovered neighbors from a Node.
     */
    @Test
    public void testNumUncoveredVertices() {
        System.out.println("testNumUncoveredVertices \n");
        System.out.println("Test that checks the uncovered neighbors from a Node.");
        Node n = new Node(3);
        HashSet<Node> covered = new HashSet<Node>();
        // covered.add(new Node(1));
        HashSet<Node> aux = new HashSet<>();
        aux.add(new Node(1));
        aux.add(new Node(2));
        aux.add(new Node(3));
        aux.add(new Node(4));
        aux.add(new Node(5));
        aux.add(new Node(6));
        aux.add(new Node(7));
        aux.add(new Node(8));
        Set<Node> nodes = graphSetCover.numUncoveredVertices(n, covered);
        assertEquals("testNumUncoveredVertices: checking the size of the set", true, nodes.size() == aux.size());
        assertEquals("testNumUncoveredVertices: data from graphSetCover", true, nodes.containsAll(aux));
    }

    /**
     * Test in order to check the main method of the first part of the project
     * Finding a dominant set in a graph
     */
    @Test
    public void testFindDominantSet() {
        /**
         * CHECKING GRAPH graphSetCover
         */
        System.out.println("testFindDominantSet \n");
        System.out.println("Test that checks the dominant set in a graph.");
        Set<Node> dominantSet = graphSetCover.findDominantSet();
        HashSet<Node> aux = new HashSet<>();
        aux.add(new Node(3));
        aux.add(new Node(10));
        assertEquals("testFindDominantSet: checking the size of the set on graphSetCover", true, dominantSet.size() == aux.size());
        assertEquals("testFindDominantSet: data from graphSetCover", true, dominantSet.containsAll(aux));

        /**
         * CHECKING A DIFFERENT GRAPH graphSetCoverB
         * */
        Set<Node> dominantSet2 = graphSetCoverB.findDominantSet();
        HashSet<Node> aux2 = new HashSet<>();
        aux2.add(new Node(2));
        aux2.add(new Node(8));
        assertEquals("testFindDominantSet: checking the size of the set on graphSetCoverB", true, dominantSet2.size() == aux2.size());
        assertEquals("testFindDominantSet: data from graphSetCoverB", true, dominantSet2.containsAll(aux2));

        /**
         * CHECKING A DIFFERENT GRAPH graphSetCoverC
         * */
        Set<Node> dominantSet3 = graphSetCoverC.findDominantSet();
        HashSet<Node> aux3 = new HashSet<>();
        aux3.add(new Node(5));
        aux3.add(new Node(1));
        aux3.add(new Node(8));
        assertEquals("testFindDominantSet: checking the size of the set on graphSetCoverC", true, dominantSet3.size() == aux3.size());
        assertEquals("testFindDominantSet: data from graphSetCoverC", true, dominantSet3.containsAll(aux3));
    }
}
