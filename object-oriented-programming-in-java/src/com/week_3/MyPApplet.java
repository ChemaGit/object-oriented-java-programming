package com.week_3;

import processing.core.*;

import java.sql.Timestamp;

public class MyPApplet extends PApplet {
    private String URL = "https://i.pinimg.com/originals/96/5c/41/965c419f82aa9b8b40e10b308f7a54c0.jpg";
    private PImage backgroundImg;
    private int hour;

    public void setup() {
        size(600,600);
        backgroundImg = loadImage(URL,"jpg");
    }
    public void draw() {
        Timestamp tm = new Timestamp(System.currentTimeMillis());
        // backgroundImg.resize(400,600); // resizing the image
        backgroundImg.resize(0,600); // resizing the image dinamically
        image(backgroundImg, 0, 0);
        hour = tm.toLocalDateTime().getHour();
        if(hour >= 7 && hour < 12) fill(0,255,247); // dawn blue
        else if(hour >= 12 && hour < 18) fill(255,255,0); // noon yellow
        else if(hour >= 18 && hour < 24) fill(137,0,255); // sunset violet
        else fill(0,0,0); // black nigth

        ellipse(width / 9, height / 10, width / 7, height / 7);
    }
    public static void main(String[] args) {
        MyPApplet pt = new MyPApplet();
        PApplet.runSketch(new String[]{"Processing Image"}, pt);
    }
}
