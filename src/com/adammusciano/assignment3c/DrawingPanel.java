/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adammusciano.assignment3c;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author atm5343
 */
public class DrawingPanel extends JPanel implements MouseMotionListener, MouseListener{
    private OptionPanel options;
    private StatusPanel status;
    private BufferedImage background;

    public void setBackground(BufferedImage background) {
        this.background = background;
        
        this.getGraphics().drawImage(background, 0, 0, this);
    }
    private ArrayList <PaintEntity> paintHistory;
    public DrawingPanel(){
        this.setSize(900,900);
        this.setBackground(Color.WHITE);
        setVisible(true);
        setLayout(null);
        initComponents();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        for(int x=0;x<paintHistory.size();x++){
            PaintEntity p = paintHistory.get(x);
            g.setColor(p.getColor());
            
            if(p.getType().equals("Square")){
                g.fillRect(p.getPosition().x, p.getPosition().y, p.getWidth(), p.getHeight());
            }else if(p.getType().equals("Circle")){
                g.fillOval(p.getPosition().x, p.getPosition().y, p.getWidth(), p.getHeight());
            }
            
        }
  
     
    }


    @Override
    public void mouseDragged(MouseEvent me) {
        Point p= me.getPoint();
        
        
        if(options.getShapeChoice().equals("Square")){
            paintHistory.add(new PaintEntity(options.getColorChoice(),p,options.getPixelSize(), options.getPixelSize(),"Square"));
        }else if(options.getShapeChoice().equals("Circle")){
            paintHistory.add(new PaintEntity(options.getColorChoice(),p,options.getPixelSize(), options.getPixelSize(),"Circle"));
            
            
        }
        
        this.repaint();
        

    }

    @Override
    public void mouseMoved(MouseEvent me) {
        Point p= me.getPoint();

                
        status.updatePositionStatus(p);
        status.updateColorStatus();
        status.updatePixelSizeStatus();
        status.updateShapeStatus();
        
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    private void initComponents() {
       paintHistory= new ArrayList<PaintEntity>();

    }
    public void setStatusPanel(StatusPanel status){
        this.status= status;
    }

    public void setOptions(OptionPanel options) {
        this.options = options;
    }

    public BufferedImage screenShot() {
        
        BufferedImage bi= new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_RGB);
        this.printAll(bi.getGraphics());
        
        
        return bi;
    }
    
}
