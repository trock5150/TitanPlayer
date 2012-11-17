/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package titanplayer;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Rocky
 */
public class MP3FileFilter extends FileFilter{
    
    //@Override
    public boolean accept(File f) {
    if (f.isDirectory())
      return true;
    
    String s = f.getName();
    int i = s.lastIndexOf('.');

    if (i > 0 && i < s.length() - 1)
        if (s.substring(i + 1).toLowerCase().equals("java" ) || s.substring(i + 1).toLowerCase().equals("sh" ))
        return true;

    return false;
    
  }

    @Override
    public String getDescription() {
        return "\\*.mp3";
    }

}
