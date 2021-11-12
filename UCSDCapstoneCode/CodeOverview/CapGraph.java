/**
 * The representation of a graph.
 */
package setcover;

import util.GraphLoader;

import java.util.*;

/**
 * @author Jose María.
 * 
 * For the warm up assignment, you must implement your Graph in a class
 * named CapGraph.  Here is the stub file.
 * In order to represent a Graph I used an adjacency list representation.
 */
public class CapGraph implements Graph {

	private HashMap<Node,List<Edge>> graph;
	private int numVertices;
	private int numEdges;

	public CapGraph() {
		graph = new HashMap();
		numEdges = 0;
		numVertices = 0;
	}

	/* (non-Javadoc)
	 * @see graph.Graph#addVertex(int)
	 */
	@Override
	public void addVertex(int num) {
		// TODO Auto-generated method stub
		Node node = new Node(num);
		if(!graph.containsKey(node)) {
			graph.put(node,new ArrayList<Edge>());
			numVertices++;
		}
	}

	/* (non-Javadoc)
	 * @see graph.Graph#addEdge(int, int)
	 */
	@Override
	public void addEdge(int from, int to) {
		// TODO Auto-generated method stub
		Node node = new Node(from);
		if(graph.containsKey(node)) {
			Edge edge = new Edge(from, to);
			if(graph.get(node).add(edge)) numEdges++;
		}
	}

	/** (non-Javadoc)
	 * @see Graph#getEgonet(int)
	 * This method takes an int which is the node/user at the center of the desired egonet,
	 * and returns that user's egonet as a graph.
	 * The returned graph should not share any objects with the original graph.
	 * E.g. if your vertices or edges are represented using objects,
	 * the returned graph should contain copies of all of the vertex and edge objects.
	 *
	 * An egonet is a subgraph that includes the vertex center and all of the vertices,
	 * v_i, that are directly connected by an edge from center to v_i
	 * and all of the edges between these vertices that are present in the original graph.
	 *
	 * If the vertex center is not present in the original graph,
	 * this method should return an empty Graph.
	 */
	@Override
	public Graph getEgonet(int center) {
		// TODO Auto-generated method stub
		CapGraph egonet = new CapGraph();
		Node nodeCenter = new Node(center);
		if(graph.containsKey(nodeCenter)) {
			// First the vertices
			egonet.addVertex(center);
			ArrayList<Edge> edges = getAllEdges();
			edges.forEach(edge -> {
				if(edge.getStart() == nodeCenter.getIdNode()) egonet.addVertex(edge.getEnd());
				if(edge.getEnd() == nodeCenter.getIdNode()) egonet.addVertex(edge.getStart());
			});
			// Then Edges
			Set<Node> nodes = egonet.getAllVertices();
			edges.forEach(edge -> {
				if(nodes.contains(new Node(edge.getStart())) && nodes.contains(new Node(edge.getEnd()))) {
					egonet.addEdge(edge.getStart(), edge.getEnd());
				}
			});
			return egonet;
		} else return egonet;
	}

	/** (non-Javadoc)
	 * @see Graph#getSCCs()
	 * This method returns all of the strongly connected components in the Graph as a list of subgraphs.
	 * As with getEgonet, the returned graphs should not share any objects with the original graph.
	 *
	 * Strongly connected component(SCC) in a directed Graph
	 *     A Graph in which for all pairs of nodes u and v, there is a path
	 *     in both directions between u and v.
	 *     Strongly connected component(SCC) in graphs are subgraphs, such
	 *     that the subgraph itself is a strongly connected graph and that
	 *     subgraph is maximal.
	 *     Maximal: There is no other nodes and edges that we could add
	 *     and still have a strongly connected graph.
	 *
	 * Algorithm: DFS(Depth First Search) on G and the transpose of G
	 *   (reverse all of the edges on the Graph) yields the SCCs
	 *     1. DFS(G) keeping track of the order in which vertices finish.
	 *     2. Compute the transpose of G, T(G).
	 *     3. DFS(T(G)) exploring in the reverse order of finish time from step 1.
	 *     4. GOAL: visit all vertices
	 */
	@Override
	public List<Graph> getSCCs() {
		// TODO Auto-generated method stub
		Deque<Node> stackVertices = new ArrayDeque<>(getAllVertices());
		Deque<Node> stackFinished = new ArrayDeque<Node>(depthFirstSearch(this, stackVertices));
		CapGraph transpose = (CapGraph) transposeGraph(getAllVertices(), getAllEdges());

		return depthFirstSearch(this,transpose,stackFinished);
	}

	/**
	 *  DFS(Depth First Search) algorithm
	 *     DFS(G, vertices):
	 *         Initialize set visited and Stack finished
	 *         while(vertices not empty):
	 *             v = vertices.pop()
	 *             if(v not in visited):
	 *                 DFS-VISIT(G, v, visited, finished)
	 *         return finished
	 *
	 * @return
	 */
	public Deque<Node> depthFirstSearch(CapGraph grp, Deque<Node> vertices) {
		HashSet<Node> visited = new HashSet<>();
		Deque<Node> stackFinished = new ArrayDeque<Node>();
		vertices.forEach(v -> {
			if(!visited.contains(v)) {
				depthFirstSearchVisit(grp, v, visited, stackFinished);
			}
		});
		return stackFinished;
	}

	/**
	 *     DFS-VISIT(G, v, visited, finished):
	 *         add v to visited
	 *         for(n  in getNeighbors(v)):
	 *             if(n not in visited):
	 *                 DFS-VISIT(G, n, visited, finished)
	 *         push v on finished
	 */
	private void depthFirstSearchVisit(CapGraph grp, Node v, HashSet<Node> visited, Deque<Node> stackfinished) {
		visited.add(v);
		ArrayList<Edge> neighbors = grp.getNeighbors(v);
		neighbors.forEach(n -> {
			if(!visited.contains(new Node(n.getEnd()))) {
				depthFirstSearchVisit(grp,new Node(n.getEnd()), visited, stackfinished);
			}
		});
		stackfinished.push(v);
	}

	/**
	 * Method to transpose the graph.
	 * In order to transpose the graph
	 * we have to reverse all the edges
	 * in that graph and return that
	 * new graph
	 * @return
	 */
	public Graph transposeGraph(HashSet<Node> vertices, ArrayList<Edge> edges) {
		CapGraph transpose = new CapGraph();
		vertices.forEach(v -> {
			transpose.addVertex(v.getIdNode());
		});
		edges.forEach(edge -> {
			transpose.addEdge(edge.getEnd(), edge.getStart());
		});
		return transpose;
	}

	/**
	 * depthFirstSearch in order to get the list of SCCs
	 * @param grp
	 * @param grpTranspose
	 * @param vertices
	 * @return
	 */
	public List<Graph> depthFirstSearch(CapGraph grp, CapGraph grpTranspose, Deque<Node> vertices) {
		HashSet<Node> visited = new HashSet<>();
		HashSet<Node> stackFinished = new HashSet<Node>();
		List<Graph> listSCC = new ArrayList<>();
		vertices.forEach(v -> {
			if(!visited.contains(v)) {
				depthFirstSearchVisit(grpTranspose, v, visited, stackFinished);
				Graph graph = new CapGraph();
				stackFinished.forEach(node -> {
					graph.addVertex(node.getIdNode());
					ArrayList<Edge> edges = grp.getNeighbors(node);
					edges.forEach(edge -> {
						graph.addEdge(edge.getStart(), edge.getEnd());
					});

				});
				listSCC.add(graph);
				stackFinished.clear();
			}
		});
		return listSCC;
	}

	private void depthFirstSearchVisit(CapGraph grp, Node v, HashSet<Node> visited, HashSet<Node> stackfinished) {
		visited.add(v);
		stackfinished.add(v);
		ArrayList<Edge> neighbors = grp.getNeighbors(v);
		neighbors.forEach(n -> {
			if(!visited.contains(new Node(n.getEnd()))) {
				depthFirstSearchVisit(grp,new Node(n.getEnd()), visited, stackfinished);
			}
		});
	}

	/**
	 * @see Graph#exportGraph()
	 * This method returns the nodes and edges in your graph in a format suitable for grading.
	 * It should return a HashMap where the keys in the HashMap are all the vertices in the graph,
	 * and the values are the Set of vertices that are reachable from the vertex key via a directed edge.
	 * The returned representation ignores edge weights and multi-edges,
	 * but it's sufficient for our grading of the two main methods on this assignment.
	 */
	@Override
	public HashMap<Integer, HashSet<Integer>> exportGraph() {
		// TODO Auto-generated method stub
		HashMap<Integer, HashSet<Integer>> graphToExport = new HashMap<>();
		graph.forEach( (k, v) -> {
			HashSet<Integer> edges = new HashSet<>();
			v.forEach(edge -> {
				edges.add(edge.getEnd());
			});
			graphToExport.put(k.getIdNode(),edges);
		});
		return graphToExport;
	}

	/**
	 * Return the number of edges in the graph
	 * @return
	 */
	public int getNumEdges() {
		return numEdges;
	}

	/**
	 * Return the number of vertices in the graph
	 * @return
	 */
	public int getNumVertices() {
		return numVertices;
	}

	/**
	 * Return a copy of an ArrayList of edges for node
	 * @param node
	 * @return
	 */
	public ArrayList<Edge> getNeighbors(Node node) {
		return new ArrayList<>(graph.get(node));
	}

	/**
	 * Method that returns all the vertices in this Graph
	 * @return
	 */
	public HashSet<Node> getAllVertices() {
		return new HashSet<>(graph.keySet());
	}

	/**
	 * Method that returns all edges in this graph
	 * @return
	 */
	public ArrayList<Edge> getAllEdges() {
		List<Edge> edges = new ArrayList<>();
		graph.forEach( (k, v) -> {
			edges.addAll(v);
		});
		return new ArrayList<>(edges);
	}

	/**
	 * To represent a graph on to the console
	 * @return
	 */
	public String toString() {
		HashMap<Integer, HashSet<Integer>> graphToExport = exportGraph();
		StringBuffer buffer = new StringBuffer();
		graphToExport.forEach( (k, v) -> {
			buffer.append("Node: " + k + "\nEdges: ");
			v.forEach(eg -> {
				buffer.append(eg + " ");
			});
			buffer.append("\n\n");
		});
		return buffer.toString();
	}

	/**
	 * CAPSTONE PROJECT
	 * Methods in order to resolver the easy question for the Capstone Project
	 * Find a dominant set in a Graph
	 *
	 * I implemented a greedy algorithm in order to resolve the set dominant problem,
	 * that is an approximation algorithm to resolve the SetCover problem.
	 */


	/**
	 * Method that finds all the uncovered neighbors from a node
	 * Complexity O(n)
	 * @param node
	 * @param coveredVertices
	 * @return
	 */
	public Set<Node> numUncoveredVertices(Node node, HashSet<Node> coveredVertices) {
		Set<Node> s = new HashSet();
		s.add(node);
		ArrayList<Edge> neighbors = getNeighbors(node);
		neighbors.forEach(edge -> {
			Node n = new Node(edge.getEnd());
			if(!coveredVertices.contains(n)) s.add(n);
		});
		return s;
	}

	/**
	 * Recursive method in order to build the dominant set
	 * This method iterates over the set of vertices. It stops when
	 * the set is empty, returning the dominant set in the graph
	 * Complexity Log(n)
	 * @param vertices
	 * @param dominantSet
	 * @return
	 */
	public Set<Node> buildDominantset(HashSet<Node> vertices, HashSet<Node> dominantSet, HashSet<Node> coveredVertices) {
		if(vertices.isEmpty()) return dominantSet;
		else {
			// Finding the greatest set of uncovered vertices
			Set<Node> nodes = new HashSet<>();
			Set<Node> n = new HashSet<>();
			vertices.forEach(node -> {
				Set<Node> ns = numUncoveredVertices(node, coveredVertices);
				if(ns.size() > nodes.size()) {
					nodes.clear();
					nodes.addAll(ns);
					n.clear();
					n.add(node);
				}
			});
			coveredVertices.addAll(nodes);
			dominantSet.addAll(n);
			vertices.removeAll(nodes);
			return buildDominantset(vertices, dominantSet, coveredVertices);
		}
	}


	/**
	 * Method to find the dominant set in a Graph
	 * It returns a set of nodes which are a dominant set in the graph
	 *
	 * Step one:
	 * @return
	 */
	public Set<Node> findDominantSet() {
		// First: we get all the graph vertices. Complexity O(1)
		HashSet<Node> vertices = getAllVertices();
		return buildDominantset(vertices, new HashSet<Node>(), new HashSet<Node>());
	}

	public static void main(String[] args) {
		Graph graphFacebook = new CapGraph();
		GraphLoader.loadGraph(graphFacebook, "/home/centos/eclipse-workspace/object-oriented-java-programming/UCSDCapstoneCode/SocialNetworks/data/facebook_1000.txt");
		System.out.println("Testing the number of Vertices and Edges in the Facebook Graph");
		int numVertices = graphFacebook.getNumVertices();
		int numEdges = graphFacebook.getNumEdges();
		System.out.println("Number of Vertices: " + numVertices);
		System.out.println("Number of Edges: " + numEdges);
		System.out.println();
		System.out.println("Finding the dominant set in the Facebook Graph");
		Set<Node> dominanSet = graphFacebook.findDominantSet();
		int size = dominanSet.size();
		System.out.println("The number of vertices in the dominant set is: " + size);
		dominanSet.forEach(node -> {
			System.out.print("Node:" + node.getIdNode() + " ");
		});
	}
}
