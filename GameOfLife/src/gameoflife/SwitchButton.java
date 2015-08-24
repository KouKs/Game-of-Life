/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pavel
 */
public class SwitchButton implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( e.getActionCommand( ).equals( "Start" ) )
        {
             Logic lgc = new Logic( );
             lgc.run( );
        }
        
           
    }
    
}
