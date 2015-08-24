package gameoflife;

import javax.swing.SwingUtilities;

/**
 * @name Game of Life
 * @author Pavel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                Window w = new Window( );
            }
        });
    }    
}
