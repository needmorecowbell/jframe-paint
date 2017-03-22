/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adammusciano.assignment3c;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PainterFrame extends JFrame
{
	public PainterFrame ()
	{
            super ("Painter");
            LayoutSetupMAC();
            MainPanel  drawPanel= new MainPanel();
            add(drawPanel);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize (1200, 800);
            setVisible(true);
	}
    void LayoutSetupMAC()
    {
    // On some MACs it might be necessary to have the statement below 
    //for the background color of the button to appear    
       try 
        {
          UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
         } catch (Exception e) 
         {
                e.printStackTrace();
          }                
    //------------------------------------------------------           
    }

}