/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adammusciano.assignment3c;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author atm5343
 */
public class PaintEntity {
    private Color color;
    private Point position;
    private String type;
    private int width,height;
    public PaintEntity(Color c, Point p, int w, int h, String type){
        this.color=c;
        this.position=p;
        this.width=w;
        this.height=h;
        this.type=type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
