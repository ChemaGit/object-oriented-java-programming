Hello my name is Jose Maria and I am going to give you a presentation of my Capstone Project 
"Broadcasting a message within a Social Network"

This project investigates the problem of making an announcement
I want to reach everybody within a social network.
How many people do I need to announce that?
I just want to find a set of people to essentially announce to the social network that something's true, 
and everyone will hear it. 
Ideally I would like to find the minimum set of people.

In order to test my solution
First I will use some tiny data sample and check if it will be working fine, 
afterward I will test the algorithm with a huge data sample, the provided Facebook data. 
The Facebook data represents friendships between students at University of California San Diego in 2005.
Every line in the file specifies a particular friendship relationship between two users, just
numbers, which are the user IDs.
So, for example, the first line in this file says that user 0 is friends with user 22. It would be an
undirected graph, because the friendship has to exist in both directions, but the algorithm will
create a directed graph.

For the easy part of the project
I want to find the group of people highly connected, so with this group I can reach everyone in the network. 
This will be the dominating set. 

Related with the data structures
The network has been laid out as a classic graph using an adjacency list.
Each individual in the graph is a vertex and an edge between vertices represents a relationship.
In order to represent the Graph I use a map, each entry in the map is a vertex(key) and the
value is a list with its neighbors.

I tried a greedy algorithm that is described in (Johnson, 1973) in order to find a dominating set. Basically,
at each stage, the greedy algorithm chooses the set which contains the largest number of
uncovered elements. Starting from an empty set, if the current sub-set of vertices is not the
dominating set, a new vertex which has the most number of the ad-jacent vertices that are not
adjacent to any vertex in the current set will be added. 

In relation with the time complexity
The algorithm iterates over the set of vértices. In the first iteration it takes the node that has
more neighbors, adds this node to the dominant set, and delete from the set of vértices the
node and its neighbors. The algorithm repeats the process until the set of vértices is empty.
The algorithm takes O(Log(n)) time complexity.   

Now I want to know if the group of people I found in the easier question is the minimum group of people 
    in order to reach the whole network.
    This will be the mínimum dominating set and my answer to the hard question.   
    
Formalizing the problem I can say, given a graph, find the smallest set
of vertices S, such that every vertex not in S is adjacent to at least one vertex in S. This problem
is actually hard and is related to the minimum dominating set problem, that is an NP hard
problem taking no polynomial time.

I tried for this part the Big step greedy set cover algorithm that is an improvement of the
classic Greedy algorithm. Finding a minimum set seems like it might be problematic. The
algorithm depicted in the easier question is an approximation algorithm for the Set Cover
problem. We will always find out the dominating set and sometimes the mínimum dominating
set, but not always. 

The Big step greedy set cover algorithm starts with empty set cover, in each step selects
two sets of vertices such that the union of selected sets contains
greatest number of uncovered elements and adds the selected sets to partial set cover.
The process of adding two sets is repeated until all elements of the graph are covered by partial set
cover. In the last step it may add less than two sets to avoid redundant sets .

if step size (the number of sets, in my case 2) is small enough
Bigstep greedy set cover algorithm runs in polynomial time. With (number of sets) bigger than 2 can lead to
a no polynomial time due to combinatorial explosion.

To summarize
The Greedy algorithm worked in each case as I expected, it is a very well known and tested
algorithm. In some cases it found out the mínimum dominant set, but in other cases only a
dominant set.
Experimental results show that proposed Big step greedy set cover algorithm with
number of sets=2 computes smaller 'set cover' than the 'set cover' computed by the classical
greedy algorithm in many cases. When 'number of sets' is small enough Bigstep greedy set cover
algorithm runs in polynomial time. 
Big step greedy set cover algorithm is preferable
than the classical greedy algorithm in scenarios where small improvement in the solution
is valuable and some increment in running time is acceptable. The proposed Big step greedy
method can be used for other combinatorial optimization problems.