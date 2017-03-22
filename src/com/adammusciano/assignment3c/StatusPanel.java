/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adammusciano.assignment3c;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;

import javax.swing.JPanel;

public class StatusPanel extends JPanel
{	
    private FlowLayout flow;
    private OptionPanel options;
    
    private JLabel labelMousePos;
    private JLabel labelColorChoice;
    private JLabel labelShapeChoice;
    private JLabel labelPixelSize;

    public StatusPanel()
    {
        super();
        setBackground(Color.lightGray);
        setVisible(true);
        initComponents();

    }
    
    public void updatePositionStatus(Point p){
        this.labelMousePos.setText("Position:"+p.x+"x"+p.y);
    }
    public void updateShapeStatus(){
        this.labelShapeChoice.setText("Shape: "+options.getShapeChoice());
    }
    public void updateColorStatus(){
        this.labelColorChoice.setText("Color: rgb("+options.getColorChoice().getRed()+","+options.getColorChoice().getGreen()+","+options.getColorChoice().getBlue()+") ");
  
    }
    public void updatePixelSizeStatus(){
        this.labelPixelSize.setText("Size: "+options.getPixelSize());
    }

    private void initComponents() {
      
        flow= new FlowLayout();
        this.labelMousePos= new JLabel("Position:");
        this.labelColorChoice= new JLabel("Color: ");
        this.labelPixelSize= new JLabel("Size: ");
        this.labelShapeChoice= new JLabel("Shape: ");
        
        add(labelMousePos);
        add(labelColorChoice);
        add(labelPixelSize);
        add(labelShapeChoice);
    }

    public void setOptions(OptionPanel options) {
        this.options = options;
    }
    

}