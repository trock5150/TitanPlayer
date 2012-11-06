/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import com.titanplayer.bll.Library;
import com.titanplayer.bll.PlayList;
import com.titanplayer.bll.Song;

/**
 *
 * @author Rocky
 * insert comment to allow push
 */
public class LibraryTests {
    
    public LibraryTests() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void emptyLibTest(){
        Library myLibrary = new Library();
        assertEquals(0,myLibrary.getSongCount());
    }
    
    @Test
    public void addSongTest(){
        Library myLibrary = new Library();
        myLibrary.addNewSong(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        myLibrary.addNewSong(new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH"
                ,"c:\\mymusic\\Poison\\OpenUp\\NothingButAGoodTime.mp3"));
        
        /*myLibrary.displaySongs();
        System.out.println();
        * 
        */
        
        assertEquals(2,myLibrary.getSongCount());
        
    }
    
    @Test
    public void addDuplicateSongTest(){
        Library myLibrary = new Library();
        myLibrary.addNewSong(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        myLibrary.addNewSong(new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH","c:\\mymusic\\REO\\Tuna\\NothingButAGoodTime.mp3"));
        myLibrary.addNewSong(new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH","c:\\mymusic\\Poison\\OpenUp\\NothingButAGoodTime.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        
        /*myLibrary.displaySongs();
        System.out.println();
        * 
        */
        
        assertEquals(4,myLibrary.getSongCount());
    }
    
    @Test
    public void removeSongTest(){
        Library myLibrary = new Library();
        myLibrary.addNewSong(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        myLibrary.addNewSong(new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH","c:\\mymusic\\Poison\\OpenUp\\NothingButAGoodTime.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        
        /*System.out.println("Song list prior to removal:");
        myLibrary.displaySongs();
        System.out.println();
        * 
        */
        
        Song remSong = new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH","c:\\mymusic\\Poison\\OpenUp\\NothingButAGoodTime.mp3");
        myLibrary.removeSong(remSong);
        
        /*System.out.println("Song list after removal:");
        myLibrary.displaySongs();
        System.out.println();
        * 
        */
        
        assertEquals(3,myLibrary.getSongCount());
        
    }
    
    @Test
    public void setNewPlaylistNameTest(){
        PlayList myPlaylist = new PlayList();
        myPlaylist.setNewName("My Playlist");
        
        assertEquals("My Playlist",myPlaylist.getPlaylistName());
    }
    
    @Test
    public void addSongsToPlaylistTest(){
        Library myLibrary = new Library();
        
        myLibrary.addNewSong(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        myLibrary.addNewSong(new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH","c:\\mymusic\\Poison\\OpenUp\\NothingButAGoodTime.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
                
        PlayList myPlaylist = new PlayList();
        myPlaylist.setNewName("My Playlist");
        
        List<Song> selectedSongs = new ArrayList<Song>();
        
        selectedSongs.add(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        
        for(Song eachSong : selectedSongs){
            int libraryLocation = myLibrary.getSongLocation(eachSong);
            //System.out.println("libraryLocation = " + libraryLocation);
            myPlaylist.setLibraryLocation(libraryLocation);
        }

        assertEquals(2,myPlaylist.getPlaylistSize());
        
        int searchIndex = 0;
        String songInfo = null;
        
        System.out.println("Playlist \"" + myPlaylist.getPlaylistName() + "\" consists of the following songs:\n" );
        for(int i = 0;i < myPlaylist.getPlaylistSize();i++){
            searchIndex = myPlaylist.returnPlaylistEntry(i);
            songInfo = myLibrary.displayPlayListSong(searchIndex);
            System.out.print(songInfo + "\n");
        }
            
    }
}
