package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;
import minimumsetcover.CapGraph;
import minimumsetcover.Edge;
import minimumsetcover.Graph;
import minimumsetcover.Node;
import util.GraphLoader;


/**
 * @Author Jose Maria
 */
public class TestMinimumSetCover {
    private Graph graph = new CapGraph();
    private Graph graph1 = new CapGraph();
    private Graph graph2 = new CapGraph();
    private Graph graph3 = new CapGraph();
    private Graph graph4 = new CapGraph();
    private Graph graph5 = new CapGraph();
    private Graph graphFacebook = new CapGraph();

    /**
     * Creating and loading the graphs
     * @throws Exception
     */
    @Before
    public void setup() throws Exception {
        GraphLoader.loadGraph(graph, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/my_data.txt");
        GraphLoader.loadGraph(graph1, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/data_set_cover.txt");
        GraphLoader.loadGraph(graph2, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/data_set_cover_b.txt");
        GraphLoader.loadGraph(graph3, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/data_set_cover_c.txt");
        GraphLoader.loadGraph(graph4, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/my_data_scc.txt");
        GraphLoader.loadGraph(graph5, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/my_data_scc_b.txt");
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
     * Test the method getUnionTwoNodesMaximized
     */
    @Test
    public void testGetUnionTwoNodesMaximized() {
        System.out.println("testGetUnionTwoNodesMaximized: my_data \n");
        HashSet<Node> coveredVertices = new HashSet<>();
        HashSet<Node> union = new HashSet<>();
        HashSet<Node> contains = new HashSet<>();
        contains.add(new Node(1));
        contains.add(new Node(3));
        int[] max = {0};
        Set<Node> un = graph.getUnionTwoNodesMaximized(new ArrayList<>(this.graph.getAllVertices()), coveredVertices,union, max);
        assertEquals("Test getUnionTwoNodesMaximized method: size",true, un.size() == 2);
        assertEquals("Test getUnionTwoNodesMaximized method: contains",true, un.containsAll(contains));

        System.out.println("testGetUnionTwoNodesMaximized: data_set_cover \n");
        max[0] = 0;
        coveredVertices.clear();
        union.clear();
        contains.clear();
        contains.add(new Node(3));
        contains.add(new Node(10));
        un.addAll(graph1.getUnionTwoNodesMaximized(new ArrayList<>(this.graph1.getAllVertices()), coveredVertices,union, max));
        assertEquals("Test getUnionTwoNodesMaximized method: size",true, un.size() == 2);
        assertEquals("Test getUnionTwoNodesMaximized method: contains",true, un.containsAll(contains));

        System.out.println("testGetUnionTwoNodesMaximized: data_set_cover_b \n");
        max[0] = 0;
        coveredVertices.clear();
        union.clear();
        contains.clear();
        contains.add(new Node(2));
        contains.add(new Node(8));
        un.addAll(graph2.getUnionTwoNodesMaximized(new ArrayList<>(this.graph2.getAllVertices()), coveredVertices,union, max));
        assertEquals("Test getUnionTwoNodesMaximized method: size",true, un.size() == 2);
        assertEquals("Test getUnionTwoNodesMaximized method: contains",true, un.containsAll(contains));

        System.out.println("testGetUnionTwoNodesMaximized: data_set_cover_c \n");
        max[0] = 0;
        coveredVertices.clear();
        union.clear();
        contains.clear();
        contains.add(new Node(2));
        contains.add(new Node(6));
        un.addAll(graph3.getUnionTwoNodesMaximized(new ArrayList<>(this.graph3.getAllVertices()), coveredVertices,union, max));
        assertEquals("Test getUnionTwoNodesMaximized method: size",true, un.size() == 2);
        assertEquals("Test getUnionTwoNodesMaximized method: contains",true, un.containsAll(contains));

        System.out.println("testGetUnionTwoNodesMaximized: my_data_scc \n");
        max[0] = 0;
        coveredVertices.clear();
        union.clear();
        contains.clear();
        contains.add(new Node(44));
        contains.add(new Node(65));
        un.addAll(graph4.getUnionTwoNodesMaximized(new ArrayList<>(this.graph4.getAllVertices()), coveredVertices,union, max));
        assertEquals("Test getUnionTwoNodesMaximized method: size",true, un.size() == 2);
        assertEquals("Test getUnionTwoNodesMaximized method: contains",true, un.containsAll(contains));

        System.out.println("testGetUnionTwoNodesMaximized: my_data_scc_b \n");
        max[0] = 0;
        coveredVertices.clear();
        union.clear();
        contains.clear();
        contains.add(new Node(44));
        contains.add(new Node(2));
        un.addAll(graph5.getUnionTwoNodesMaximized(new ArrayList<>(this.graph5.getAllVertices()), coveredVertices,union, max));
        assertEquals("Test getUnionTwoNodesMaximized method: size",true, un.size() == 2);
        assertEquals("Test getUnionTwoNodesMaximized method: contains",true, un.containsAll(contains));


        System.out.println("testGetUnionTwoNodesMaximized: my_data_scc_b \n");
        max[0] = 0;
        coveredVertices.clear();
        coveredVertices.add(new Node(44));
        coveredVertices.add(new Node(32));
        coveredVertices.add(new Node(50));
        coveredVertices.add(new Node(18));
        coveredVertices.add(new Node(2));
        coveredVertices.add(new Node(1));
        coveredVertices.add(new Node(3));
        coveredVertices.add(new Node(4));
        union.clear();
        contains.clear();
        contains.add(new Node(5));
        contains.add(new Node(65));
        Set<Node> nodes = this.graph5.getAllVertices();
        nodes.removeAll(coveredVertices);
        un.addAll(graph5.getUnionTwoNodesMaximized(new ArrayList<Node>(nodes), coveredVertices,union, max));
        assertEquals("Test getUnionTwoNodesMaximized method: size",true, un.size() == 2);
        assertEquals("Test getUnionTwoNodesMaximized method: contains",true, un.containsAll(contains));
    }

    /**
     * Test the method buildMinimumDominantSet
     */
    @Test
    public void buildMinimumDominantSet() {
        System.out.println("buildMinimumDominantSet: my_data_scc_b \n");
        HashSet<Node> minimumDominantSet = new HashSet<>();
        minimumDominantSet.add(new Node(5));
        minimumDominantSet.add(new Node(44));
        minimumDominantSet.add(new Node(65));
        minimumDominantSet.add(new Node(2));

    }
}
