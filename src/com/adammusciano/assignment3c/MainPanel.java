/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adammusciano.assignment3c;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author atm5343
 */
class MainPanel extends JPanel {

    private OptionPanel optionPanel;
    private StatusPanel statusPanel;
    private DrawingPanel drawingPanel;
    private BorderLayout border;
    public MainPanel(){
        initComponents();
        setVisible(true);

    }

    private void initComponents() {
        border=new BorderLayout();
        setLayout(border);
        
        optionPanel= new OptionPanel();
        this.add(optionPanel, border.NORTH);
        
        drawingPanel= new DrawingPanel();
        this.add(drawingPanel, border.CENTER);
        
        statusPanel= new StatusPanel();
        this.add(statusPanel, border.SOUTH);
        
        drawingPanel.setOptions(optionPanel);
        drawingPanel.setStatusPanel(statusPanel);
        
        statusPanel.setOptions(optionPanel);
        optionPanel.setStatusPanel(statusPanel);
        
        optionPanel.setDrawingPanel(drawingPanel);
    }
    
    

 
    
    
}
