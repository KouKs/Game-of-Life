/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;

/**
 *
 * @author Pavel
 */
public final class ClickListener implements ActionListener {
    
    private final Map<String,JButton> buttons;
    
    public ClickListener( Map<String,JButton> buttons )
    {
        this.buttons = buttons;
    }
    
    @Override
    public void actionPerformed( ActionEvent e )
    {
        String command = e.getActionCommand();
        try {
            JButton clicked = this.buttons.get(command);   
            if( clicked.getBackground() == Color.black )
                clicked.setBackground( Color.white );
            else
                clicked.setBackground( Color.black );
        } catch( NullPointerException ex ) { }

    }
}
