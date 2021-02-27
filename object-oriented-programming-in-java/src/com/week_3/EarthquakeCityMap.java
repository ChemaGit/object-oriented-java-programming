package com.week_3;

import com.parsing.ParseFeed;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EarthquakeCityMap extends PApplet {
    // Less than this threshold is a light earthquake
    public static final float THRESHOLD_MODERATE = 5;
    // Less than this threshold is a minor earthquake
    public static final float THRESHOLD_LIGHT = 4;

    private UnfoldingMap map;
    private String earthquakesURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

    private SimplePointMarker addColorByMagnitude(SimplePointMarker mk) {
        int yellow = color(255, 255, 0);
        int red = color(255,0,0);
        int green = color(0,255,0);
        float magnitude = (float)mk.getProperty("magnitude");
        if(magnitude > THRESHOLD_MODERATE) {
            mk.setColor(red);
        } else if(magnitude <= THRESHOLD_MODERATE && magnitude > THRESHOLD_LIGHT){
            mk.setColor(yellow);
        } else {
            mk.setColor(green);
        }
        return mk;
    }

    public void setup() {
        size(950,600,OPENGL);
        map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
        // map = new UnfoldingMap(this, 200, 50, 700, 500, new Microsoft.RoadProvider());
        map.zoomLevel(1);
        MapUtils.createDefaultEventDispatcher(this, map);

        // The List you will populate with new SimplePointMarkers
        List<Marker> markers = new ArrayList<Marker>();

        //Use provided parser to collect properties for each earthquake
        //PointFeatures have a getLocation method
        List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
        earthquakes
                .stream()
                .forEach(eq -> markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties())));

        ArrayList<Marker> mkrs = (ArrayList)markers.stream()
                .map(mk -> addColorByMagnitude((SimplePointMarker) mk))
                .collect(Collectors.toList());
        map.addMarkers(mkrs);
    }

    public void draw() {
        background(181, 181, 181);
        map.draw();

    }

    public static void main(String[] args) {
        EarthquakeCityMap pt = new EarthquakeCityMap();
        PApplet.runSketch(new String[]{"Processing Maps"}, pt);
        // addKey();
    }
}
