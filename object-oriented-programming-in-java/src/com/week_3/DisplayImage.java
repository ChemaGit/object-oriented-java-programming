package com.week_3;

import processing.core.PApplet;
import processing.core.PImage;

public class DisplayImage extends PApplet {

    private String URL = "https://i.imgur.com/tif10TKh.jpg";
    private PImage backgroundImg;

    public int[] sunColorSec(float second) {
        int[] rgb = new int[3];
        float diffFrom30 = Math.abs(30 - second);
        float ratio = diffFrom30 / 30;

        rgb[0] = (int)(255 * ratio);
        rgb[1] = (int)(255 * ratio);
        rgb[2] = 0;
        return rgb;
    }

    public void setup() {
        size(600,600);
        backgroundImg = loadImage(URL,"jpg");
    }

    public void draw() {
        // backgroundImg.resize(400,600); // resizing the image
        backgroundImg.resize(0,600); // resizing the image dinamically
        image(backgroundImg, 0, 0);

        int[] color = sunColorSec(second()); // calculate color code for sun
        fill(color[0], color[1], color[2]);
        ellipse(width / 9, height / 10, width / 7, height / 7);
    }

    public static void main(String[] args) {
        DisplayImage pt = new DisplayImage();
        PApplet.runSketch(new String[]{"Processing Image"}, pt);
    }
}
