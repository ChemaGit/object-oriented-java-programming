package com.week_5;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class MyApplet extends PApplet {
    private UnfoldingMap map;

    public void setup() {
        size(600,600, OPENGL);
        map = new UnfoldingMap(this, 50, 50, 700, 500, new Microsoft.HybridProvider());
        MapUtils.createDefaultEventDispatcher(this, map);
    }

    public void draw(){
        map.draw();
        drawButtons();
    }

    public void drawButtons() {
        fill(255,255,255);
        rect(100,100,25,25);
        fill(100,100,100);
        rect(100,150,25,25);
    }

    public void mouseReleased() {
        if(mouseX > 100 && mouseX < 125 && mouseY > 100 && mouseY < 125) { // button coordinates
            background(255, 255, 255);
        } else if(mouseX > 100 && mouseX < 125 && mouseY > 150 && mouseY < 175) { // button coordinates
            background(100,100,100);
        }
    }

    public void mousePressed() {

    }

    public void mouseClicked() {

    }

    public void keyPressed() {

    }

    public void keyTyped() {

    }

    public void keyReleased() {

    }

//    public void keyPressed(){
//        if(key == 'w') {
//            background(255, 255, 0);
//        }
//    }

    public static void main(String[] args) {
        MyApplet pt = new MyApplet();
        PApplet.runSketch(new String[]{"Processing Maps"}, pt);
    }
}
