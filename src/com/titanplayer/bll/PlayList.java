/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanplayer.bll;

import java.util.*;
import javax.management.BadStringOperationException;

/**
 *
 * @author Rocky
 * Insert comment to allow push
 */
public class PlayList{

    private String playlistName = null;
    private List<Integer> libraryLocation = new ArrayList<Integer>();

    public PlayList(String newPlaylistName) throws Exception {
        if(newPlaylistName.isEmpty())
            throw new BadStringOperationException("Play List Name cannot be NULL!");
        else
            playlistName = newPlaylistName;
    }
    
    /*public void setNewName(String myPlaylist) {
        playlistName = myPlaylist;
    }
    * 
    */
    
    public String getPlaylistName(){
        return playlistName;
    }
    
    public void setLibraryLocation(int locationOfSong){
        int arraySize = libraryLocation.size();
        //System.out.println("Playlist Array Size = " + arraySize);
        libraryLocation.add(arraySize, locationOfSong);
    }
    
    public int getPlaylistSize(){
        return libraryLocation.size();
    }
    
    public int returnPlaylistEntry(int playlistIndex){
        
        return libraryLocation.get(playlistIndex);
            
    }
    
}
