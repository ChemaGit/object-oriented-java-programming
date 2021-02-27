package com.week_3;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;
import com.parsing.ParseFeed;

import java.util.List;
import java.util.Map;

public class LifeExpectancy extends PApplet {
    private final String filePath = "data/LifeExpectancyWorldBankModule3.csv";
    private final String fileGeoJson = "data/countries.geo.json";

    UnfoldingMap map;
    Map<String, Float> lifeExpByCountry;
    List<Feature> countries;
    List<Marker> countryMarkers;

    private void shadeCountries() {
        for(Marker marker : countryMarkers) {
            String countryID = marker.getId();
            if(lifeExpByCountry.containsKey(countryID)) {
                float lifeExp = lifeExpByCountry.get(countryID);
                int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
                marker.setColor(color(255 - colorLevel, 100, colorLevel));
            } else {
                marker.setColor(color(150, 150, 150));
            }
        }
    }

    public void setup() {
        lifeExpByCountry = ParseFeed.loadLifeExpectancyFromCSV(this, filePath);
        countries = GeoJSONReader.loadData(this, fileGeoJson);
        countryMarkers = MapUtils.createSimpleMarkers(countries);

        size(1400, 1000, OPENGL);
        // map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
        map = new UnfoldingMap(this, 50, 50, 1400, 900, new Microsoft.HybridProvider());

        map.addMarkers(countryMarkers);
        shadeCountries();

        MapUtils.createDefaultEventDispatcher(this, map);

    }

    public void draw() {
        map.draw();
    }

    public static void main(String[] args) {
        LifeExpectancy pt = new LifeExpectancy();
        PApplet.runSketch(new String[]{"Life Expectancy Maps"}, pt);
    }
}
