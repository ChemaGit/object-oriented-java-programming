# BASIC GRAPH SEARCH  
```text
This document provide documentation that describes each of the classes I implemented(creation or modification) for 
the Programming Assignment: Class Design and Graph Search: MapGraph.java, GraphNode.java, GraphEdge.java
```

## OVERALL DESIGN JUSTIFICATION
```text
A graph is shaped for nodes or vertices and edges so I have created a GraphNode class
in order to represent all nodes for the graph and a GraphEdge that represents an edge
that connects two nodes with the information about the edge(start point, end point, 
the distance between the points and street and type of the street that is needed for
the map representation).
MapGraph is the representation of the map that contains the graph with all the nodes and edges, 
and the algorithms in order to calculate the routes between two points in the map.
```

## CLASS NAME: GraphNode.java
### Purpose and description of class:
```text
A GraphNode represents a node in the graph.
A GraphNode contains his [location GeographicPoint] and his [neighbors List<GraphEdge> (a list
that contains the intersections from this particular node)].
I have included in this class getters and setters in order to set and retrieve the fields and
an equal and hashCode with the purpose of comparing two GraphNode objects for their locations.
And a toString method for debugging.
```

## CLASS NAME: GraphEdge.java
### Purpose and description of class:
```text
A GraphEdge represents a connection between two nodes with all the information tha is needed.
It contains a [start GeographicPoint], [end GeographicPoint], [streetName String], [streetType String],
and the distance between the start and the end of the edge [distance double]
I have included in this class getters and setters in order to set and retrieve the fields, and 
a toString method for debugging
```

## CLASS NAME: MapGraph
### Modifications made to MapGraph (what and why)
```text
I made the following changes in this class:
    1. Creation of member variables
        HashMap<GraphNode, List<GraphEdge>> vertices -> HashMap that represents the Map. 
        It stores the nodes and for each node his neighbors or adjacent vertices.
    2. int numEdges -> represent the number of edges of this Graph.
    3. Initialize member variables into the constructor.
    4. Implement method getNumVertices() that returns the number of vertices of this graph.
    5. Implement method getVertices() that returns the vertices in this graph as GeographicPoints.
    6. Implement method getNumEdges() that returns the number of edges in the graph.
    7. Implement method addVertex(GeographicPoint location) that adds a node corresponding 
       to an intersection at a Geographic Point. Returns true if a node was added, false if it was not 
       (the node was already in the graph, or the parameter is null).
    8. Implement method 
       addEdge(GeographicPoint from, GeographicPoint to, String roadName, String roadType, double length) throws IllegalArgumentException
       Adds a directed edge to the graph from pt1 to pt2 with the precondition: Both GeographicPoints have already been added to the graph.
    9. Implement method public List<GeographicPoint> bfs(GeographicPoint start, GeographicPoint goal, Consumer<GeographicPoint> nodeSearched)
        that find the path from start to goal using breadth first search.
        It returns the list of intersections that form the shortest (unweighted) path from start to goal (including both start and goal).
    10. Implement auxiliary method 
        	private List<GeographicPoint> bfsAux(GeographicPoint goal,
        										 HashMap<GeographicPoint, GeographicPoint> parent,
        										 Queue<GeographicPoint> q,
        										 HashSet<GeographicPoint> visited)
        Recursive auxiliary private method that implements bsf algorithm.
        I have implemented this method recursively for simplicity and clarity, and I think is easier implementing this method recursive
        than iterative.
    11. Implement auxiliary method private Consumer<GeographicPoint> setNodeSearched(List<GeographicPoint> path, Consumer<GeographicPoint>nodeSearched)
        Private method for set a hook that will allow the search process to be visualized in the front-end application.
    12. Implement auxiliary method
        private List<GeographicPoint> findPath(HashMap<GeographicPoint, GeographicPoint> parent, GeographicPoint goal, LinkedList<GeographicPoint> auxPath)
        Recursive auxiliary private method that returns a List of GeographicPoint which is the path that was found by bfs algorithm.
```