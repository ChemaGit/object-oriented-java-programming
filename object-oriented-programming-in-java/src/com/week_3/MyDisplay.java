package com.week_3;

import processing.core.PApplet;

public class MyDisplay extends PApplet {

    public void setup() {
        size(400, 400);
        background(0, 0 ,0);
    }

    public void draw() {
        fill(255,255,0);
        ellipse(200,200,350,350);
        fill(0,0,0);
        ellipse(120, 130,50,70);
        ellipse(280, 130,50,70);
        noFill();
        arc(200, 280, 150,50,0, PI);

    }

    public static void main(String[] args) {
        MyDisplay pt = new MyDisplay();
        PApplet.runSketch(new String[]{"Processing Image"}, pt);
    }
 }
