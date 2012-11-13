/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import com.titanplayer.bll.Library;
import com.titanplayer.bll.PlayList;
import com.titanplayer.bll.Song;
import com.titanplayer.bll.PlayASong;
import java.util.SortedSet;
import java.util.TreeSet;

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
    public void sortLibraryByTitleTest(){
        //Build test library
        Library myLibrary = new Library();
        
        myLibrary.addNewSong(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        myLibrary.addNewSong(new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH","c:\\mymusic\\Poison\\OpenUp\\NothingButAGoodTime.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        myLibrary.addNewSong(null);
        
        System.out.println("\nSort Library:  Songs prior to sort:");
        myLibrary.displaySongs();
        
        System.out.println("\nSort Library:  Songs sorted by Title:");
        myLibrary.sortByTitle();
        
        System.out.println("\nSort Library:  Songs sorted by Artist:");
        myLibrary.sortByArtist();
        
    }
    
    
}

