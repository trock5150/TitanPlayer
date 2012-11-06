/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanplayer.bll;

/**
 *
 * @author Rocky
 * insert comment to allow push
 */
public class Song {
    
    private String songTitle;
    private String songArtist;
    private String songAlbum;
    private String songPath;
    
    public Song (String songTitle, String songArtist, String songAlbum, String songPath){
        this.songTitle = songTitle;
        this.songArtist = songArtist;
        this.songAlbum = songAlbum;
        this.songPath = songPath;
    }
    
    public String showTitle(Song selectedSong){
        return songTitle = selectedSong.songTitle;
    }
    
    public String showArtist(Song selectedSong){
        return songArtist = selectedSong.songArtist;
    }
    
    public String showAlbum(Song selectedSong){
        return songAlbum = selectedSong.songAlbum;
    }
    
    public String showPath(Song selectedSong){
        return songPath = selectedSong.songPath;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Song other = (Song) obj;
        if ((this.songTitle == null) ? (other.songTitle != null) : !this.songTitle.equals(other.songTitle)) {
            return false;
        }
        if ((this.songArtist == null) ? (other.songArtist != null) : !this.songArtist.equals(other.songArtist)) {
            return false;
        }
        if ((this.songAlbum == null) ? (other.songAlbum != null) : !this.songAlbum.equals(other.songAlbum)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.songTitle != null ? this.songTitle.hashCode() : 0);
        hash = 43 * hash + (this.songArtist != null ? this.songArtist.hashCode() : 0);
        hash = 43 * hash + (this.songAlbum != null ? this.songAlbum.hashCode() : 0);
        return hash;
    }

}
