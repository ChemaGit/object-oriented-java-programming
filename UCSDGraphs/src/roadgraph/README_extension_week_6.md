# Project: Week 6 Description -- REQUIRED EXTENSION
```text
In this lines I will introduce the REQUIRED EXTENSION assignment for this week.
I have chosen an extension of my own taste rather than a guided extension.
I will explain the motivation of the extension, my belief that it has value and 
why, the technical details, and I hope you like it.
```
## CACHING USER ROUTES PROJECT EXTENSION

#### MOTIVATION
```text
In the real world when a mobile phone, laptop or pc users are looking for route
in google maps or another map application, they would probably like that 
their devices are be able to remember the routes they already did at any moment.

This behavior of their devices is indeed very good for them and very good for 
all the systems involve in the calculation of the routes.
Good for them because is faster and they don't have to remember the details of
that particular route, and good for the infrastructure that gives life to the
map application in order to no recalculate that particular route if it already did,
because of it comes with a high cost.
```

#### EXTENSION
```text
I did an extension that remembers user routes.
In real applications it can be done with databases. You can query the database looking
for a route if it exists in the database for that particular user or calculate the 
route if it doesn't exist and store it in the database.

I won't raise a database in order to implement this extension, instead I will use
HashMap to reproduce this behavior.

I implemented the extension with a HashMap because HashMap are faster than other 
collections in order to insert or retrieve elements as we already 
have learnt from the course.

When a user is going to look for a route,
first the algorithm (BFS, DIJKSTRA OR A*) looks for the route into the HashMap, if
the path already exists the algorithm returns the path, if not calculates the path and
stores it in the HashMap.
```

#### CACHING USER ROUTES IMPLEMENTATION
```text
I have created a new class called CacheRoutes that has two methods getRoute that 
returns a route or null and storeRoute to save a route. 
This class maintains a HashMap with a startPoint as a key and a HashMap
as a value. The HashMap value has an endPoint as a key and an ArrayList as a value
with a route. In this way a startPoint can have multiple routes with different endPoints.

In MapGraph.java I declare the variable: 

	routesStored - line 38

In MapGraph constructor I initialize routesStored - line 49

I've created a private method getRoute that recieves a start and goal GeographicPoint
and returns a path between start and goal or null if path doesn't exist. line - 60.

At the beginning of (BFS, DIJKSTRA OR A*) algorithms I check if a route exists, 
if not I have to save the new calculated route.

BFS line - 182
DIJKSTRA line - 301
A* line - 422
```