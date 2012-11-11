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
        myLibrary.addNewSong(null);
        
        assertEquals(4,myLibrary.getSongCount());
                
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
        
        System.out.println("Playlist Test 1: Playlist \"" + myPlaylist.getPlaylistName() + "\" consists of the following songs:\n" );
        for(int i = 0;i < myPlaylist.getPlaylistSize();i++){
            searchIndex = myPlaylist.returnPlaylistEntry(i);
            songInfo = myLibrary.displayPlayListSong(searchIndex);
            System.out.print(songInfo + "\n");
        }
            
    }
    
    @Test
    public void skipASongTest() throws InterruptedException{
        //Build test library
        Library myLibrary = new Library();
        
        myLibrary.addNewSong(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        myLibrary.addNewSong(new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH","c:\\mymusic\\Poison\\OpenUp\\NothingButAGoodTime.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        myLibrary.addNewSong(null);
        
        //build test playlist
        PlayList myPlaylist = new PlayList();
        myPlaylist.setNewName("My Playlist");
        
        List<Song> selectedSongs = new ArrayList<Song>();
        
        selectedSongs.add(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        
        //Print out playlist for reference
        for(Song eachSong : selectedSongs){
            int libraryLocation = myLibrary.getSongLocation(eachSong);
            System.out.println("libraryLocation = " + libraryLocation);
            myPlaylist.setLibraryLocation(libraryLocation);
        }

        assertEquals(3,myPlaylist.getPlaylistSize());
        
        int searchIndex = 0;
        String songInfo = null;
        
        System.out.println("Playlist Test 2: Playlist \"" + myPlaylist.getPlaylistName() + "\" consists of the following songs:\n" );
        for(int i = 0;i < myPlaylist.getPlaylistSize();i++){
            searchIndex = myPlaylist.returnPlaylistEntry(i);
            songInfo = myLibrary.displayPlayListSong(searchIndex);
            System.out.print(songInfo + "\n");
        }
        
        System.out.println("\nFor this test, each song has a simulated 2 minute play time...");
        System.out.println("The loop below will send an interrupt to the \"PlayASong\" thread after 50 Seconds...");
        System.out.println("The display will show that the song was interrupted and the next song starts.\n");
        
        for(Song currentSong: selectedSongs){
            
            //Song must play in a new thread in order to allow main thread to interrupt it
            Thread t = new Thread(new PlayASong());
            t.start();
            
            int i=0;
            
            //this will simulate the 'Next Song button' being pressed to skip to the next song
            while(t.isAlive()){
                if (i > 0){
                    System.out.println(i*10 + " Seconds into playing song: "+currentSong.showPath(currentSong));
                }
                
                t.join(10000);
                i++;
                
                if(i == 5 && t.isAlive()){
                    t.interrupt();
                }
            }
        }
    }
        
}
