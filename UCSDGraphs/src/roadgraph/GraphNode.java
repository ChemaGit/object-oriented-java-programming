package roadgraph;

import geography.GeographicPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode implements Comparable {
    private GeographicPoint location;
    private List<GraphEdge> neighbors;

    private double toGoal;

    private double stimatedDistance;

    private static final double DEFAULT_DISTANCE = Double.POSITIVE_INFINITY;
    private static final double DEFAULT_STIMATED_DISTANCE = -1;

    public GraphNode(GeographicPoint loc) {
        location = loc;
        neighbors = new ArrayList<>();
        toGoal = DEFAULT_DISTANCE;
        stimatedDistance = DEFAULT_STIMATED_DISTANCE;
    }

    /**
     * Method equals to compare two object for his values
     * In this particular case for his location field
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GraphNode)) return false;
        GraphNode graphNode = (GraphNode) o;
        return Objects.equals(getLocation(), graphNode.getLocation());
    }

    @Override
    public String toString() {
        return location.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    public GeographicPoint getLocation() {
        return location;
    }

    public void setLocation(GeographicPoint location) {
        this.location = location;
    }

    public List<GraphEdge> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<GraphEdge> neighbors) {
        this.neighbors = neighbors;
    }

    public double getToGoal() {
        return toGoal;
    }

    public void setToGoal(double toGoal) {
        this.toGoal = toGoal;
    }

    public double getStimatedDistance() {
        return stimatedDistance;
    }

    public void setStimatedDistance(GeographicPoint point) {
        this.stimatedDistance = this.getLocation().distance(point);
    }

    @Override
    public int compareTo(Object o) {
        if(stimatedDistance == DEFAULT_STIMATED_DISTANCE) {
            if(this.getToGoal() > ((GraphNode)o).getToGoal()) return 1;
            else return -1;
        } else {
            if( (this.getToGoal() + this.getStimatedDistance()) > ( ((GraphNode)o).getToGoal() + ((GraphNode)o).getStimatedDistance()) )  return 1;
            else return -1;
        }
    }
}
