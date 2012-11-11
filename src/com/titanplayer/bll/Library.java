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

    public void sortByTitle() {
        
        SortedSet<String> sortSongs = new TreeSet<String>();//(new SongTitleComparator());
        String songStringByTitle = null;
        
        for(Song librarySong : mySongLibrary){
            songStringByTitle = librarySong.showTitle(librarySong)+","+librarySong.showArtist(librarySong)+
                    ","+librarySong.showAlbum(librarySong)+","+librarySong.showPath(librarySong);
            sortSongs.add(songStringByTitle);
        }
        
        for(String songInfo : sortSongs){
            System.out.println(songInfo);
        }
        
    }
    
    public void sortByArtist() {
        
        SortedSet<String> sortSongs = new TreeSet<String>();//(new SongTitleComparator());
        String songStringByArtist = null;
        
        for(Song librarySong : mySongLibrary){
            songStringByArtist = librarySong.showArtist(librarySong)+","+librarySong.showTitle(librarySong)+
                    ","+librarySong.showAlbum(librarySong)+","+librarySong.showPath(librarySong);
            sortSongs.add(songStringByArtist);
        }
        
        for(String songInfo : sortSongs){
            String[] displaySongInfo = songInfo.split(",");
            
            System.out.println(displaySongInfo[1]+","+displaySongInfo[0]+","+displaySongInfo[2]+displaySongInfo[3]);
        }
        
    }
}
