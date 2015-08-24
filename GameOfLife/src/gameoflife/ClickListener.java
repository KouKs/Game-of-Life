/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;

/**
 *
 * @author Pavel
 */
public final class ClickListener implements ActionListener {
    
    private final HashMap<String,JButton> buttons;
    
    public ClickListener( HashMap<String,JButton> buttons )
    {
        this.buttons = buttons;
    }
    
    @Override
    public void actionPerformed( ActionEvent e )
    {
        String command = e.getActionCommand();
        System.out.print( command );
        String[] coords = command.split(":");
        JButton clicked = null;
        try {
            clicked = this.buttons.get(command);   
        } catch( NullPointerException ex ) { }
        
        if( clicked.getBackground() == Color.black )
            clicked.setBackground( Color.white );
        else
            clicked.setBackground( Color.black );
            
    }
}
