/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adammusciano.assignment3c;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author atm5343
 */
public class OptionPanel extends JPanel implements ActionListener, ChangeListener{
    private JSlider sliderPixelSize;
    private JColorChooser colorChooser;
    private JRadioButton jrbCircle, jrbSquare;
    private JButton btnSaveImage;
    private ButtonGroup btnShapeGroup;
    private FlowLayout flow;
    private DrawingPanel drawingPanel;
    private Color colorChoice;
    private int pixelSize;
    private String shapeChoice;
    private BufferedImage background;
    private JButton btnLoadImage;
    
    private StatusPanel status;
    
    public OptionPanel(){
        flow= new FlowLayout();
        setLayout(flow);
        setVisible(true);
        this.setBackground(Color.LIGHT_GRAY);
        initComponents();
    
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        
        if(obj.equals(jrbCircle)){
            shapeChoice="Circle";
            status.updateShapeStatus();
        }else if(obj.equals(jrbSquare)){
            System.out.println("square");
            shapeChoice="Square";
            status.updateShapeStatus();
        }else if(obj.equals(btnSaveImage)){
            
          
            
            BufferedImage bi= drawingPanel.screenShot();
            
            JFileChooser jfc = new JFileChooser();
            
            File defaultFile = new File("painting.png");
            jfc.setSelectedFile(defaultFile);
            int retVal = jfc.showSaveDialog(null);
            if(retVal==JFileChooser.APPROVE_OPTION){
                File f = jfc.getSelectedFile();
                String filePath = f.getAbsolutePath();
                try {
                    ImageIO.write(bi,"png",new File(filePath));
                } catch (IOException ex) {
                    Logger.getLogger(OptionPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if(obj.equals(btnLoadImage)){
            JFileChooser jfc= new JFileChooser();
            
            File selectedFile;//needed*
           
            FileReader reader = null;//needed*,look these three up for further info

            //opens dialog if button clicked
            if (jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
            {
              //gets file from dialog
              selectedFile = jfc.getSelectedFile();
              //makes sure files can be processed before proceeding
              if (selectedFile.canRead() && selectedFile.exists())
              {
                  try {
                      background= ImageIO.read(selectedFile);
                  } catch (FileNotFoundException ex) {
                      Logger.getLogger(OptionPanel.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                      Logger.getLogger(OptionPanel.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
            }
            
            
            //set background of drawpanel to background
            this.drawingPanel.setBackground(background);
            

            
        
        }
    }

    private void initComponents() {
        colorChooser= new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(this);
        colorChooser.setColor(Color.BLACK);
        this.colorChoice=Color.BLACK;
        this.add(colorChooser);
        sliderPixelSize= new JSlider(0,150);
        sliderPixelSize.setValue(10);
        this.pixelSize=10;
        sliderPixelSize.setToolTipText("Pixel Size: "+sliderPixelSize.getValue());
        sliderPixelSize.addChangeListener(this);
        
        this.add(sliderPixelSize);
        
        btnShapeGroup = new ButtonGroup();
        jrbCircle= new JRadioButton("Circle");
        jrbSquare= new JRadioButton("Square");
        
        jrbCircle.setSelected(true);
        shapeChoice="Circle";
        
        
        
        btnShapeGroup.add(jrbCircle);
        btnShapeGroup.add(jrbSquare);
        
        jrbCircle.addActionListener(this);
        jrbSquare.addActionListener(this);
        this.add(jrbCircle);
        this.add(jrbSquare);
        
        btnSaveImage= new JButton("Save File");
        btnSaveImage.addActionListener(this);
        this.add(btnSaveImage);
        
        btnLoadImage= new JButton("Load Image");
        btnLoadImage.addActionListener(this);
        this.add(btnLoadImage);
        
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        Object obj = ce.getSource();
        
        if(obj.equals(sliderPixelSize)){
            sliderPixelSize.setToolTipText("Pixel Size: "+sliderPixelSize.getValue());
            this.pixelSize=sliderPixelSize.getValue();
            status.updatePixelSizeStatus();
        }else if(obj.equals(this.colorChooser.getSelectionModel())){
            this.colorChoice= colorChooser.getColor();

        
        }
    }

    public Color getColorChoice() {
        return colorChoice;
    }

    public int getPixelSize() {
        return pixelSize;
    }

    public String getShapeChoice() {
        return shapeChoice;
    }
    
    public void setStatusPanel(StatusPanel status){
        this.status= status;
    }
    
    public void setDrawingPanel(DrawingPanel draw){
        this.drawingPanel= draw;
    }


    
}
