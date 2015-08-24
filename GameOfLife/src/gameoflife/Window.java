/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

/**
 *
 * @author Pavel
 */
public final class Window implements Runnable {
    
    private final JFrame frame;
    private String state = "Start";
    
    public Window( )
    {
        this.frame = new JFrame("Game of life"); 
        this.buildWindow( );        
        this.run( );
    }
    
    /**
     * run forrest run
     */
    @Override
    public void run( )
    {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(
            new TimerTask() {
                @Override
                public void run() {
                    buildField();
                }
            }, 100, 100);
    }
    
    private void buildWindow( )
    { 
        this.frame.setSize(506,579);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.frame.setVisible( true );
        

    }
    
    public void buildField( )
    {
        JButton bt = new JButton();
        bt.setBounds(0,500,500,50);
        bt.setMargin( new Insets( 0,0,0,0 ) );
        bt.setText( this.state );
        /*bt.setActionCommand( this.state );
        bt.addActionListener( new SwitchButton( ) );
        this.state = this.state.equals("Start") ? "Rebuild" : "Start";*/
        bt.setBackground(Color.lightGray);
        bt.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
        this.frame.add(bt);
        
        Map<String,JButton> buttons = new HashMap<>();
        for( int y = 0 ; y < 50 ; y++ )
        {
            for( int x = 0 ; x < 50 ; x++ )
            {
                String coords = x + ":" + y;
                JButton b = new JButton();
                b.setBounds(x*10,y*10,10,10);
                b.setMargin( new Insets( 0,0,0,0 ) );
                b.setBackground(Color.white);
                b.setActionCommand( coords );
                b.setBorder( new LineBorder(Color.darkGray) );
                buttons.put(coords, b);
                b.addActionListener( new ClickListener( buttons ) );
                this.frame.add(b);
            }
        }
    }
}
