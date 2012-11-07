package com.titanplayer.bll;

import com.titanplayer.bll.Song;
import java.util.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Added Comment

/**
 *
 * @author Rocky
 */
public class Library {
    
    private Set<Song> mySongLibrary = new LinkedHashSet<Song>();
    
    public int getSongCount(){
        return mySongLibrary.size();
    }
    
    public void addNewSong(Song newSong){
        if(newSong != null){
            mySongLibrary.add(newSong);
        }
    }
    
    public void displaySongs(){
        
        for(Song thisSong : mySongLibrary){
            System.out.println(thisSong.showTitle(thisSong) + ", "
                    + thisSong.showArtist(thisSong) +", "
                    + thisSong.showAlbum(thisSong) + ", " 
                    + thisSong.showPath(thisSong));
        }
        
    }
    
    public void removeSong(Song songToRemove) {

        mySongLibrary.remove(songToRemove);
    }
    
    public int getSongLocation(Song playListSong){
        int songLocation = 0;
        List<Song> searchArray = new ArrayList<Song>(mySongLibrary);
        //for(int i=0;i<searchArray.size();i++){
            if(mySongLibrary.contains(playListSong)){
                songLocation = searchArray.indexOf(playListSong);
            //}     
            }
        return songLocation;
    }
    
    public String displayPlayListSong(int libraryLocation){
        String songInfo = "";
        
        List<Song> searchArray = new ArrayList<Song>(mySongLibrary);
        
        Song selectedSong = searchArray.get(libraryLocation);
        
        songInfo = selectedSong.showTitle(selectedSong) + ", "
                    + selectedSong.showArtist(selectedSong) +", "
                    + selectedSong.showAlbum(selectedSong) + ", " 
                    + selectedSong.showPath(selectedSong);
        
        return songInfo;
    }
}
