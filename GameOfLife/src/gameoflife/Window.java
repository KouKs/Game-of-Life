/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

/**
 *
 * @author Pavel
 */
public final class Window {
    
    private final JFrame frame;
    
    public Window( )
    {
        this.frame = new JFrame("Game of life"); 
        
        this.buildWindow( );
        this.buildField( );        
    }
    
    public void buildWindow( )
    { 
        this.frame.setSize(1000,1000);
        this.frame.setLocation( 0,0 );
        this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.frame.setVisible( true );
    }
    
    public void buildField( )
    {
        HashMap<String,JButton> buttons = null;
        for( int y = 0 ; y < 10 ; y++ )
        {
            for( int x = 0 ; x < 10 ; x++ )
            {
                String coords = x + ":" + y;
                JButton b = new JButton();
                b.setBounds(x*10,y*10,10,10);
                b.setMargin( new Insets( 0,0,0,0 ) );
                b.setBackground(Color.white);
                b.setActionCommand( coords );
                b.setBorder( new LineBorder(Color.darkGray) );
                try {
                    buttons.put(coords, b);
                } catch( NullPointerException e ){ }
                b.addActionListener( new ClickListener( buttons ) );
                this.frame.add(b);
            }
        }
    }
}
