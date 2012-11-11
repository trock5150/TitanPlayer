/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanplayer.bll;

import java.util.Comparator;

/**
 *
 * @author Rocky
 */
public class SongArtistComparator implements Comparator<Song>{
    @Override
    public int compare(Song o1, Song o2) {
        String songArtist1 = o1.showArtist(o1);
    
        String songArtist2 = o2.showArtist(o2);
        
        if(o1.hashCode() < o2.hashCode())
            return -1;
        else if(o1.hashCode()== o2.hashCode())
            return 0;
        else
            return 1;
    }
}
