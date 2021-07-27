package test;

import static org.junit.Assert.*;

import graph.CapGraph;
import graph.Edge;
import graph.Graph;
import graph.Node;
import org.junit.Before;
import org.junit.Test;
import util.GraphLoader;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Jose Maria
 */
public class MyGraphTest {

    private CapGraph graph = new CapGraph();
    private CapGraph graphSCC = new CapGraph();

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{

        GraphLoader.loadGraph(graph, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/my_data.txt");
        GraphLoader.loadGraph(graphSCC, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/my_data_scc.txt");
    }

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

    @Test
    public void testEgonet() {
        CapGraph egonet = (CapGraph) graph.getEgonet(5);
        assertEquals("Test getEgonet method",true, egonet.getNumVertices() == 4 && egonet.getNumEdges() == 5);
        assertEquals("Test getEgonet method",true, egonet.getAllEdges().contains(new Edge(1, 5)));
        assertEquals("Test getEgonet method",true, egonet.getAllEdges().contains(new Edge(4, 5)));
        System.out.println(egonet.toString());
    }

    @Test
    public void testGetSCCs() {
        System.out.println("Printing the graphSCC");
        System.out.println(graphSCC.toString());
        System.out.println("");

        System.out.println("Test method depthFirstSearch");
        Deque<Node> stackVertices = new ArrayDeque<>(graphSCC.getAllVertices());
        Deque<Node> stackVerticesFinished = graphSCC.depthFirstSearch(graphSCC, new ArrayDeque<Node>(graphSCC.getAllVertices()));
        assertEquals("Test depthFirstSearch method",true, stackVertices.size() == stackVerticesFinished.size());
        assertEquals("Test depthFirstSearch method",true, stackVertices.containsAll(stackVerticesFinished));

        System.out.println(stackVerticesFinished.toString());
        System.out.println("");
        System.out.println(stackVertices.toString());
        System.out.println("");

        System.out.println("Test method transposeGraph");
        CapGraph transpose = (CapGraph) graphSCC.transposeGraph(graphSCC.getAllVertices(), graphSCC.getAllEdges());
        assertEquals("Test transposeGraph method",true, transpose.getAllVertices().size() == graphSCC.getAllVertices().size());
        assertEquals("Test transposeGraph method",true, transpose.getAllEdges().size() == graphSCC.getAllEdges().size());
        assertEquals("Test transposeGraph method",true, transpose.getAllVertices().containsAll(graphSCC.getAllVertices()) );
        assertEquals("Test transposeGraph method",true, graphSCC.getAllEdges().contains(new Edge(transpose.getAllEdges().get(0).getEnd(),transpose.getAllEdges().get(0).getStart())) );
        assertEquals("Test transposeGraph method",true, graphSCC.getAllEdges().contains(new Edge(transpose.getAllEdges().get(1).getEnd(),transpose.getAllEdges().get(1).getStart())) );
        System.out.println("");

        System.out.println("Printing the transpose graph");
        System.out.println(transpose.toString());
        System.out.println("");

        System.out.println("Testing the list of SCCs. Method getSCCs");
        List<Graph> lstgraphSCC = graphSCC.getSCCs();
        System.out.println("Number of graphs: " + lstgraphSCC.size());
        lstgraphSCC.forEach(graph1 -> {
            System.out.println("New Graph: " + graph1.toString());
        });
        assertEquals("Test getSCCs method",true, lstgraphSCC.size() == 4);
    }
}
