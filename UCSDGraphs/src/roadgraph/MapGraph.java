/**
 * @author UCSD MOOC development team and YOU
 * 
 * A class which reprsents a graph of geographic locations
 * Nodes in the graph are intersections between 
 *
 */
package roadgraph;


import java.util.*;
import java.util.function.Consumer;

import util.GraphLoader;
import geography.GeographicPoint;

/**
 * @author UCSD MOOC development team and YOU
 * 
 * A class which represents a graph of geographic locations
 * Nodes in the graph are intersections between 
 *
 */
public class MapGraph {
	//TODO: Add your member variables here in WEEK 3

	// HashMap that represents the Map. It stores the nodes
	// and for each node his neighbors or adjacent vertices
	private HashMap<GraphNode, List<GraphEdge>> vertices;

	// number of edges of this Graph
	private int numEdges;

	private int countNodes = 0;

	// Project: Week 6 -- REQUIRED EXTENSION
	// private variable for to not recalculate routes if we already did
	private CacheRoutes routesStored;
	
	/** 
	 * Create a new empty MapGraph 
	 */
	public MapGraph() {
		// TODO: Implement in this constructor in WEEK 3
		vertices = new HashMap<GraphNode, List<GraphEdge>>();
		numEdges = 0;

		// Project: Week 6 -- REQUIRED EXTENSION
		routesStored = new CacheRoutes();
	}

	/**
	 * Project: Week 6 -- REQUIRED EXTENSION
	 *
	 * Method that recieves a start and goal GeographicPoint
	 * and returns a path between start and goal or null if path doesn't exist.
	 * @param start
	 * @param goal
	 * @return a path ArrayList<GeographicPoint> or null
	 * @throws IllegalArgumentException
	 */
	private List<GeographicPoint> getRoute (GeographicPoint start, GeographicPoint goal) throws IllegalArgumentException{
		if(start == null || goal == null) throw  new IllegalArgumentException("Some of the arguments are null");

		return this.routesStored.getRoute(start, goal);
	}
	
	/**
	 * Get the number of vertices (road intersections) in the graph
	 * @return The number of vertices in the graph.
	 */
	public int getNumVertices() {
		//TODO: Implement this method in WEEK 3
		return vertices.size();
	}
	
	/**
	 * Return the intersections, which are the vertices in this graph.
	 * @return The vertices in this graph as GeographicPoints
	 */
	public Set<GeographicPoint> getVertices() {
		//TODO: Implement this method in WEEK 3
		Set<GraphNode> nodes = vertices.keySet();
		Set<GeographicPoint> n = new HashSet<>();
		nodes.forEach(node -> n.add(node.getLocation()));
		return n;
	}
	
	/**
	 * Get the number of road segments in the graph
	 * @return The number of edges in the graph.
	 */
	public int getNumEdges() {
		//TODO: Implement this method in WEEK 3
		return numEdges;
	}

	
	
	/** Add a node corresponding to an intersection at a Geographic Point
	 * If the location is already in the graph or null, this method does 
	 * not change the graph.
	 * @param location  The location of the intersection
	 * @return true if a node was added, false if it was not (the node
	 * was already in the graph, or the parameter is null).
	 */
	public boolean addVertex(GeographicPoint location) {
		// TODO: Implement this method in WEEK 3
		if(location != null && !this.vertices.containsKey(location)) {
			GraphNode node = new GraphNode(location);
			this.vertices.put(node, node.getNeighbors());
			return true;
		} else return false;
	}
	
	/**
	 * Adds a directed edge to the graph from pt1 to pt2.  
	 * Precondition: Both GeographicPoints have already been added to the graph
	 * @param from The starting point of the edge
	 * @param to The ending point of the edge
	 * @param roadName The name of the road
	 * @param roadType The type of the road
	 * @param length The length of the road, in km
	 * @throws IllegalArgumentException If the points have not already been
	 *   added as nodes to the graph, if any of the arguments is null,
	 *   or if the length is less than 0.
	 */
	public void addEdge(GeographicPoint from, GeographicPoint to, String roadName, String roadType, double length) throws IllegalArgumentException {
		//TODO: Implement this method in WEEK 3
		if(from != null && to != null && roadName != null && roadType != null && length >= 0) {
			GraphNode nodeFrom = new GraphNode(from);
			GraphNode nodeTo = new GraphNode(to);
			if(this.vertices.containsKey(nodeFrom) && this.vertices.containsKey(nodeTo)) {
				GraphEdge edge = new GraphEdge(from, to, roadName, roadType, length);
				List<GraphEdge> lstG = vertices.get(nodeFrom);
				lstG.add(edge);
				nodeFrom.setNeighbors(lstG);
				vertices.replace(nodeFrom, lstG);
				numEdges++;
			} else {
				throw new IllegalArgumentException("Failed addEdge. A vertice doesn't exist.");
			}
		} else {
			throw  new IllegalArgumentException("Failed addEdge. Some arguments are null.");
		}
	}
	

	/** Find the path from start to goal using breadth first search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest (unweighted)
	 *   path from start to goal (including both start and goal).
	 */
	public List<GeographicPoint> bfs(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {};
        return bfs(start, goal, temp);
	}
	
	/** Find the path from start to goal using breadth first search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest (unweighted)
	 *   path from start to goal (including both start and goal).
	 *
	 *   BFS(S, G):
	 * Initialize: queue, visited HashSet and parent HashMap
	 * Enqueue S onto the queue and add to visited
	 * while queue is not empty:
	 * 		dequeue node curr from top of queue
	 * 		if curr == G return parent map
	 * 		for each of curr's neighbors, n, not in visited set:
	 * 			add n to visited set
	 * 			add curr as n's parent in parent map
	 * 			enqueue n onto the queue
	 * // If we get here then there's no path
	 */
	public List<GeographicPoint> bfs(GeographicPoint start, GeographicPoint goal, Consumer<GeographicPoint> nodeSearched) {
		// Week 6 -- REQUIRED EXTENSION
		// If the route already exists, return pathStored
		List<GeographicPoint> pathStored = getRoute(start, goal);
		if(pathStored != null) {
			pathStored.forEach(p -> nodeSearched.accept(p));
			return pathStored;
		}

		// TODO: Implement this method in WEEK 3
		GraphNode startNode = new GraphNode(start);
		GraphNode goalNode = new GraphNode(goal);

		if(vertices.containsKey(startNode) && vertices.containsKey(goalNode)) {
			HashMap<GraphNode, GraphNode> parent = new HashMap<>();
			Queue<GeographicPoint> q = new LinkedList<>();
			q.add(start);
			HashSet<GeographicPoint> visited = new HashSet<>();
			visited.add(start);
			List<GeographicPoint> path = bfsAux(goal, parent, q, visited, nodeSearched);

			// Week 6 -- REQUIRED EXTENSION
			// Saving in cache the new calculated route
			this.routesStored.storeRoute(start, goal, path);

			return path;
		} else return new ArrayList<>();
	}

	/**
	 * Recursive auxiliary private method that implements bsf algorithm
	 * @param goal
	 * @param parent
	 * @param q
	 * @param visited
	 * @return
	 */
	private List<GeographicPoint> bfsAux(GeographicPoint goal,
										 HashMap<GraphNode, GraphNode> parent,
										 Queue<GeographicPoint> q,
										 HashSet<GeographicPoint> visited,
										 Consumer<GeographicPoint> nodeSearched) {
		if(!q.isEmpty()) {
			GeographicPoint curr = q.remove();
			nodeSearched.accept(curr);
			if(curr.equals(goal)) {
				LinkedList<GeographicPoint> auxPath = new LinkedList<>();
				auxPath.add(goal);
				List<GeographicPoint> path = findPath(parent, new GraphNode(goal), auxPath);
				return path;
			} else {
				GraphNode currNode = new GraphNode(curr);
				List<GraphEdge> edges = this.vertices.get(currNode);
				edges.forEach(edge ->{
					GeographicPoint endGP = edge.getEnd();
					if(!visited.contains(endGP)){
						q.add(endGP);
						visited.add(endGP);
						parent.put(new GraphNode(endGP),currNode);
					}
				} );
				return bfsAux(goal, parent, q, visited, nodeSearched);
			}
		}
		return new ArrayList<>();
	}

	/**
	 * Private method that returns a List of GeographicPoint with the path which was found by bfs algorithm
	 * @param parent
	 * @param goal
	 * @param auxPath
	 * @return
	 */
	private List<GeographicPoint> findPath(HashMap<GraphNode, GraphNode> parent, GraphNode goal, LinkedList<GeographicPoint> auxPath) {
		if(parent.get(goal) == null) return auxPath;
		else {
			GraphNode p = parent.get(goal);
			auxPath.addFirst(p.getLocation());
			return findPath(parent, p, auxPath);
		}
	}

	/** Find the path from start to goal using Dijkstra's algorithm
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> dijkstra(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
		// You do not need to change this method.
        Consumer<GeographicPoint> temp = (x) -> {};
        return dijkstra(start, goal, temp);
	}
	
	/** Find the path from start to goal using Dijkstra's algorithm
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 *
	 *   Dijkstra(S, G):
	 * Initialize: Priority queue (PQ), visited HashSet, parent HashMap, and distances to infinity
	 * Enqueue {S, 0} onto the PQ
	 * while PQ is not empty:
	 * 	dequeue node curr from front of queue
	 * 	if(curr is not visited)
	 * 		add curr to visited set
	 * 		If curr == G return parent map
	 * 			for each of curr's neighbors, n, not in visited set:
	 * 				if path through curr to n is shorter
	 * 					update curr as n's parent in parent map
	 * 					enqueue {n, distance} into the PQ
	 * // If we get here then there's no path
	 */
	public List<GeographicPoint> dijkstra(GeographicPoint start, GeographicPoint goal, Consumer<GeographicPoint> nodeSearched) {
		// Week 6 -- REQUIRED EXTENSION
		// If the route already exists, return pathStored
		List<GeographicPoint> pathStored = getRoute(start, goal);
		if(pathStored != null) {
			pathStored.forEach(p -> nodeSearched.accept(p));
			return pathStored;
		}

		// TODO: Implement this method in WEEK 4
		// Hook for visualization.  See writeup.
		//nodeSearched.accept(next.getLocation());
		GraphNode startNode = new GraphNode(start);
		GraphNode goalNode = new GraphNode(goal);
		if(vertices.containsKey(startNode) && vertices.containsKey(goalNode)) {
			PriorityQueue<GraphNode> pq = new PriorityQueue<>();
			HashSet<GeographicPoint> visited = new HashSet<>();
			HashMap<GraphNode, GraphNode> parent = new HashMap<>();
			startNode.setToGoal(0);
			pq.add(startNode);
			List<GeographicPoint> path = dijkstraAux(goal, parent, pq, visited, nodeSearched);

			// Week 6 -- REQUIRED EXTENSION
			// Saving in cache the new calculated route
			this.routesStored.storeRoute(start, goal, path);

			return path;
		} else return new ArrayList<>();
	}

	private List<GeographicPoint> dijkstraAux(GeographicPoint goal,
											  HashMap<GraphNode, GraphNode> parent,
											  PriorityQueue<GraphNode> pq,
											  HashSet<GeographicPoint> visited,
											  Consumer<GeographicPoint> nodeSearched) {
		if(!pq.isEmpty()) {
			GraphNode current = pq.poll();
			if(!visited.contains(current.getLocation())) {
				visited.add(current.getLocation());
				nodeSearched.accept(current.getLocation());
				System.out.println("DIJKSTRA visiting NODE at location: " + current.toString());
				countNodes++;
				if(current.getLocation().equals(goal)) {
					LinkedList<GeographicPoint> auxPath = new LinkedList<>();
					auxPath.add(goal);
					List<GeographicPoint> path = findPath(parent, new GraphNode(goal), auxPath);
					System.out.println("Nodes visited in search: " + countNodes);
					System.out.println();
					countNodes = 0;
					return path;
				} else {
					List<GraphEdge> edges = this.vertices.get(current);
					edges.forEach(edge -> {
						GraphNode node = new GraphNode(edge.getEnd());
						if(!visited.contains(node.getLocation())) {
							node.setToGoal(current.getToGoal() + edge.getDistance());
							pq.add(node);
							if(!parent.containsKey(node)) parent.put(node, current);
							else {
								GraphNode auxKey = findKeyAndUpdate(parent,node);
								if(auxKey.getToGoal() < Double.POSITIVE_INFINITY) {
									parent.remove(node);
									parent.put(auxKey, current);
								}
							}
						}
					});
				}
			}
			return dijkstraAux(goal, parent, pq, visited, nodeSearched);
		}
		return new ArrayList<>();
	}

	private GraphNode findKeyAndUpdate(HashMap<GraphNode, GraphNode> parent, GraphNode key) {
		GraphNode auxKey = new GraphNode(key.getLocation());
		auxKey.setToGoal(key.getToGoal());
		parent.forEach( (k, v) -> {
			if(k.getLocation().equals(key.getLocation())){
				if(k.getToGoal() < key.getToGoal()) auxKey.setToGoal(Double.POSITIVE_INFINITY);
				return;
			}
		});
		return auxKey;
	}

	/** Find the path from start to goal using A-Star search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 */
	public List<GeographicPoint> aStarSearch(GeographicPoint start, GeographicPoint goal) {
		// Dummy variable for calling the search algorithms
        Consumer<GeographicPoint> temp = (x) -> {};
        return aStarSearch(start, goal, temp);
	}
	
	/** Find the path from start to goal using A-Star search
	 * 
	 * @param start The starting location
	 * @param goal The goal location
	 * @param nodeSearched A hook for visualization.  See assignment instructions for how to use it.
	 * @return The list of intersections that form the shortest path from 
	 *   start to goal (including both start and goal).
	 *
	 *   * A-Star(S, G):
	 * 	 * Initialize: Priority queue (PQ), visited HashSet, parent HashMap, and distances to infinity and stimated distances to the goal
	 * 	 * Enqueue {S, 0} onto the PQ
	 * 	 * while PQ is not empty:
	 * 	 * 	dequeue node curr from front of queue
	 * 	 * 	if(curr is not visited)
	 * 	 * 		add curr to visited set
	 * 	 * 		If curr == G return parent map
	 * 	 * 			for each of curr's neighbors, n, not in visited set:
	 * 	 * 				if path through curr to n is shorter
	 * 	 * 					update curr as n's parent in parent map
	 * 	 * 					enqueue {n, distance} into the PQ
	 * 	 * // If we get here then there's no path
	 */
	public List<GeographicPoint> aStarSearch(GeographicPoint start, GeographicPoint goal, Consumer<GeographicPoint> nodeSearched) {
		// Week 6 -- REQUIRED EXTENSION
		// If the route already exists, return pathStored
		List<GeographicPoint> pathStored = getRoute(start, goal);
		if(pathStored != null) {
			pathStored.forEach(p -> nodeSearched.accept(p));
			return pathStored;
		}

		// TODO: Implement this method in WEEK 4
		GraphNode startNode = new GraphNode(start);
		GraphNode goalNode = new GraphNode(goal);
		startNode.setStimatedDistance(goal);
		goalNode.setStimatedDistance(goal);
		if(vertices.containsKey(startNode) && vertices.containsKey(goalNode)) {
			PriorityQueue<GraphNode> pq = new PriorityQueue<>();
			HashSet<GeographicPoint> visited = new HashSet<>();
			HashMap<GraphNode, GraphNode> parent = new HashMap<>();
			startNode.setToGoal(0);
			pq.add(startNode);
			List<GeographicPoint> path = aStarSearchAux(goal, parent, pq, visited, nodeSearched);

			// Week 6 -- REQUIRED EXTENSION
			// Saving in cache the new calculated route
			this.routesStored.storeRoute(start, goal, path);

			return path;
		} else return new ArrayList<>();
	}

	private List<GeographicPoint> aStarSearchAux(GeographicPoint goal,
											  HashMap<GraphNode, GraphNode> parent,
											  PriorityQueue<GraphNode> pq,
											  HashSet<GeographicPoint> visited,
											  Consumer<GeographicPoint> nodeSearched) {
		if(!pq.isEmpty()) {
			GraphNode current = pq.poll();
			if(!visited.contains(current.getLocation())) {
				visited.add(current.getLocation());
				nodeSearched.accept(current.getLocation());
				System.out.println("A* visiting NODE at location: " + current.toString());
				countNodes++;
				if(current.getLocation().equals(goal)) {
					LinkedList<GeographicPoint> auxPath = new LinkedList<>();
					auxPath.add(goal);
					List<GeographicPoint> path = findPath(parent, new GraphNode(goal), auxPath);
					System.out.println("Nodes visited in search: " + countNodes);
					System.out.println();
					countNodes = 0;
					return path;
				} else {
					List<GraphEdge> edges = this.vertices.get(current);
					edges.forEach(edge -> {
						GraphNode node = new GraphNode(edge.getEnd());
						node.setStimatedDistance(goal);
						if(!visited.contains(node.getLocation())) {
							node.setToGoal(current.getToGoal() + edge.getDistance());
							pq.add(node);
							if(!parent.containsKey(node)) parent.put(node, current);
							else {
								GraphNode auxKey = findKeyAndUpdateAStart(parent,node);
								if(auxKey.getToGoal() < Double.POSITIVE_INFINITY) {
									parent.remove(node);
									parent.put(auxKey, current);
								}
							}
						}
					});
				}
			}
			return aStarSearchAux(goal, parent, pq, visited, nodeSearched);
		}
		return new ArrayList<>();
	}

	private GraphNode findKeyAndUpdateAStart(HashMap<GraphNode, GraphNode> parent, GraphNode key) {
		GraphNode auxKey = new GraphNode(key.getLocation());
		auxKey.setToGoal(key.getToGoal());
		parent.forEach( (k, v) -> {
			if(k.getLocation().equals(key.getLocation())){
				if( (k.getToGoal() + k.getStimatedDistance()) < (key.getToGoal()) + key.getStimatedDistance()) auxKey.setToGoal(Double.POSITIVE_INFINITY);
				return;
			}
		});
		return auxKey;
	}

	/************************************************
	 * Project: Week 6 -- REQUIRED EXTENSION        *
	 * @param args                                  *
	 ************************************************/



	public static void main(String[] args) {
//		System.out.print("Making a new map...");
//		MapGraph firstMap = new MapGraph();
//		System.out.print("DONE. \nLoading the map...");
//		GraphLoader.loadRoadMap("data/testdata/simpletest.map", firstMap);
//		System.out.println("DONE.");
		
		// You can use this method for testing.  
		
		
		/* Here are some test cases you should try before you attempt 
		 * the Week 3 End of Week Quiz, EVEN IF you score 100% on the 
		 * programming assignment.
		 */

//		MapGraph simpleTestMap = new MapGraph();
//		GraphLoader.loadRoadMap("data/testdata/simpletest.map", simpleTestMap);
//
//		GeographicPoint testStart = new GeographicPoint(1.0, 1.0);
//		GeographicPoint testEnd = new GeographicPoint(8.0, -1.0);
//
//		System.out.println("Test 1 using simpletest: Dijkstra should be 9 and AStar should be 5");
//		List<GeographicPoint> testroute = simpleTestMap.dijkstra(testStart,testEnd);
//		List<GeographicPoint> testroute2 = simpleTestMap.aStarSearch(testStart,testEnd);
//
//
//		MapGraph testMap = new MapGraph();
//		GraphLoader.loadRoadMap("data/maps/utc.map", testMap);
//
//		// A very simple test using real data
//		testStart = new GeographicPoint(32.869423, -117.220917);
//		testEnd = new GeographicPoint(32.869255, -117.216927);
//		System.out.println("Test 2 using utc: Dijkstra should be 13 and AStar should be 5");
//		testroute = testMap.dijkstra(testStart,testEnd);
//		testroute2 = testMap.aStarSearch(testStart,testEnd);
//
//
//		// A slightly more complex test using real data
//		testStart = new GeographicPoint(32.8674388, -117.2190213);
//		testEnd = new GeographicPoint(32.8697828, -117.2244506);
//		System.out.println("Test 3 using utc: Dijkstra should be 37 and AStar should be 10");
//		testroute = testMap.dijkstra(testStart,testEnd);
//		testroute2 = testMap.aStarSearch(testStart,testEnd);
		MapGraph theMap = new MapGraph();
		System.out.print("DONE. \nLoading the map...");
		GraphLoader.loadRoadMap("data/maps/utc.map", theMap);
		System.out.println("DONE.");

		GeographicPoint start = new GeographicPoint(32.8648772, -117.2254046);
		GeographicPoint end = new GeographicPoint(32.8660691, -117.217393);

		List<GeographicPoint> route = theMap.dijkstra(start,end);
		List<GeographicPoint> route2 = theMap.aStarSearch(start,end);
	}
}
