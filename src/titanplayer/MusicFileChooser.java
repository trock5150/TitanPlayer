/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package titanplayer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author Rocky
 */
public class MusicFileChooser extends JFrame {

    public MusicFileChooser() {
	
        JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new MP3FileFilter());
        int returnVal = fc.showOpenDialog(this);
        
        File selectedFile = null;
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            selectedFile = fc.getSelectedFile();
        }  
    }
}
