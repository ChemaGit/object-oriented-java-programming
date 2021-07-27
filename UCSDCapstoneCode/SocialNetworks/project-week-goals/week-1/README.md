# Warming up with social network data

#### Egonet
````text
- Describe an Egonet.
- How to extract it from a social network data.
- Egonet: a single user's network including their friends and
          friendships between them. That's essentially centered in
          one particular user.

- Subgraph that includes
    1. all of the central user's friends
    2. all edges between them
````

#### Strongly connected components
````text
- Define a Strongly connected component(SCC) in a directed Graph
    A Graph in which for all pairs of nodes u and v, there is a path
    in both directions between u and v.
    Strongly connected component(SCC) in graphs are subgraphs, such
    that the subgraph itself is a strongly connected graph and that
    subgraph is maximal.
    Maximal: There is no other nodes and edges that we could add
    and still have a strongly connected graph.
- Implement an algorithm for extracting SCCs from Graphs
- Finding SCCs algorithm: DFS(Depth First Search) on G and the transpose of G
  (reverse all of the edges on the Graph) yields the SCCs
    1. DFS(G) keeping track of the order in which vertices finish.
    2. Compute the transpose of G, T(G).
    3. DFS(T(G)) exploring in the reverse order of finish time from step 1.
    4. GOAL: visit all vertices

    DFS(G, vertices):
        Initialize set visited and Stack finished
        while(vertices not empty):
            v = vertices.pop()
            if(v not in visited):
                DFS-VISIT(G, v, visited, finished)
        return finished

    DFS-VISIT(G, v, visited, finished):
        add v to visited
        for(n  in getNeighbors(v)):
            if(n not in visited):
                DFS-VISIT(G, n, visited, finished)
        push v on finished
````

#### Warm Up Assignment Instructions
````text
In this first assignment, you'll be working with some social network data.  
We are providing you with two sets of data to start: 
social network data from Facebook and communication (tweet) data from Twitter.  
In this first assignment you will:

    - Design and implement a set of classes to store this data as a graph 
    (this graph must implement our provided interface, and the class that implements 
    this interface must be named CapGraph)

    - Use our provided files to load the data into your graph

    - Write a method that extracts a subgraph from the Facebook data called an “egonet”.  
    Egonets are explored in more detail below.

    - Write a method that finds the strongly connected components in a directed graph. 
````

**Part 1: Graph Representation**
````text
Design a graph representation in Java.
Implement at least the addVertex and addEdge methods in this part, 
and ensure that your graphs are being created correctly, using small, made-up data.   
You will also need to add some additional methods to your graph class 
(e.g. some print methods) and/or implement the exportGraph method 
to ensure that your graph was in fact loaded correctly.  
Alternatively, we encourage you create JUnit tests to ensure that your graph is being loaded correctly.

Once you are sure your methods are working, you can use the GraphLoader class we provide to load the Facebook and Twitter data we provide into your graph representation.  
````

**Part 2: Two graph algorithms**
````text
You will complete the implementation of the Graph interface by implementing 
the getEgonet and getSCC methods.  You will also need to have implemented the exportGraph 
method which returns the data in your graph in a format that we can grade it. 

- public Graph getEgonet(int center)
    This method takes an int which is the node/user at the center of the desired egonet, 
    and returns that user's egonet as a graph.  
    The returned graph should not share any objects with the original graph.  
    E.g. if your vertices or edges are represented using objects, 
    the returned graph should contain copies of all of the vertex and edge objects.  
    
    An egonet is a subgraph that includes the vertex center and all of the vertices, 
    v_i, that are directly connected by an edge from center to v_i and all of 
    the edges between these vertices that are present in the original graph.  
    Examples of egonets are given in the lectures in this module.  
    
    If the vertex center is not present in the original graph, 
    this method should return an empty Graph.

- public List<Graph> getSCC()
    This method returns all of the strongly connected components in the Graph as a list of subgraphs.  
    As with getEgonet, the returned graphs should not share any objects with the original graph.

- public HashMap<Integer, HashSet<Integer>> exportGraph()
    This method returns the nodes and edges in your graph in a format suitable for grading.  
    It should return a HashMap where the keys in the HashMap are all the vertices in the graph, 
    and the values are the Set of vertices that are reachable from the vertex key via a directed edge.  
    The returned representation ignores edge weights and multi-edges. 
````