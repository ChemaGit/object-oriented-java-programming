package roadgraph;

import geography.GeographicPoint;

public class GraphEdge {

    private GeographicPoint start;
    private GeographicPoint end;
    private String streetName;
    private String streetType;
    private double distance;

    static final double DEFAULT_LENGTH = 0.01;

    public GraphEdge(String sName, GeographicPoint s, GeographicPoint e) {
        this(s, e, sName, "", DEFAULT_LENGTH);
    }

    public GraphEdge(String sName, String sType, GeographicPoint s, GeographicPoint e) {
        this(s, e, sName, sType, DEFAULT_LENGTH);
    }

    public GraphEdge(GeographicPoint s, GeographicPoint e, String sName, String sType, double d) {
        this.start = s;
        this.end = e;
        this.streetName = sName;
        this.streetType = sType;
        this.distance = d;
    }

    @Override
    public String toString() {
        return "GraphEdge{" +
                "start=" + start +
                ", end=" + end +
                ", streetName='" + streetName + '\'' +
                ", streetType='" + streetType + '\'' +
                ", distance=" + distance +
                '}';
    }

    public GeographicPoint getStart() {
        return start;
    }

    public void setStart(GeographicPoint start) {
        this.start = start;
    }

    public GeographicPoint getEnd() {
        return end;
    }

    public void setEnd(GeographicPoint end) {
        this.end = end;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
