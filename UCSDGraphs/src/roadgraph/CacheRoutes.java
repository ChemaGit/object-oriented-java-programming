package roadgraph;

import geography.GeographicPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project: Week 6 -- REQUIRED EXTENSION
 */
public class CacheRoutes {
    /**
     * HashMap routes to store multiple paths from a GeographicPoint
     */
    private HashMap<GeographicPoint, HashMap<GeographicPoint, List<GeographicPoint>>> routes;

    /**
     * Public constructor that initializes the HashMap
     */
    public CacheRoutes() {
        routes = new HashMap<>();
    }

    /**
     * Public method that returns a stored path if it is already cached or null
     * @param start GeographicPoint
     * @param goal GeographicPoint
     * @return ArrayList<GeographicPoint> with a route from start to goal or null if
     * the path doesn't exist
     * @throws IllegalArgumentException if start or goal were null
     */
    public List<GeographicPoint> getRoute(GeographicPoint start, GeographicPoint goal) throws IllegalArgumentException{

        if(start == null || goal == null) throw new IllegalArgumentException("Some of the arguments are null");

        HashMap<GeographicPoint, List<GeographicPoint>> paths = this.routes.get(start);
        if(paths != null) {
            List<GeographicPoint> path = paths.get(goal);
            if(path != null) return path;
            else return null;
        } else return null;
    }

    /**
     * Public method that saves a route from start to goal
     * @param start
     * @param goal
     * @param path
     * @throws IllegalArgumentException if start, goal or path were null
     */
    public void storeRoute(GeographicPoint start, GeographicPoint goal, List<GeographicPoint> path) throws IllegalArgumentException{

        if(start == null || goal == null || path == null) throw new IllegalArgumentException("Some of the arguments are null");

        HashMap<GeographicPoint, List<GeographicPoint>> paths = this.routes.get(start);
        if(paths != null) {
            paths.put(goal, path);
        } else {
            HashMap<GeographicPoint, List<GeographicPoint>> newPath = new HashMap<>();
            newPath.put(goal, path);
            this.routes.put(start, newPath);
        }
    }
}
