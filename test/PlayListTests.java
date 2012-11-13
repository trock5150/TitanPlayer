/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.titanplayer.bll.Library;
import com.titanplayer.bll.PlayASong;
import com.titanplayer.bll.PlayList;
import com.titanplayer.bll.Song;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Rocky
 */
public class PlayListTests {
    
    public PlayListTests() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void createPlaylistNoNameTest() throws Exception{
        
        String playlistName = null;
        
        try {
            PlayList myPlaylist = new PlayList(playlistName);
            playlistName = myPlaylist.getPlaylistName();
        } catch (Exception ex) {
            System.out.println("A playlist MUST have a name... defaulting the name...");
            //Logger.getLogger(PlayListTests.class.getName()).log(Level.SEVERE, null, ex);
            PlayList myPlaylist = new PlayList("DefaultName");
            playlistName = myPlaylist.getPlaylistName();
        }
        
        assertEquals("DefaultName",playlistName);
    }
    
    /*@Test
    public void setNewPlaylistNameTest(){
        PlayList myPlaylist = new PlayList();
        myPlaylist.setNewName("My Playlist");
        
        assertEquals("My Playlist",myPlaylist.getPlaylistName());
    }
    * 
    */
    
    @Test
    public void addSongsToPlaylistTest() throws Exception{
        Library myLibrary = new Library();
        
        myLibrary.addNewSong(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        myLibrary.addNewSong(new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH","c:\\mymusic\\Poison\\OpenUp\\NothingButAGoodTime.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        myLibrary.addNewSong(null);
        
        assertEquals(4,myLibrary.getSongCount());
                
        //PlayList myPlaylist;
        try {
            PlayList myPlaylist = new PlayList("My Playlist");
            //myPlaylist.setNewName("My Playlist");
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
            } catch (Exception ex) {
            System.out.println("A playlist MUST have a name... defaulting the name...");
            //Logger.getLogger(PlayListTests.class.getName()).log(Level.SEVERE, null, ex);
            PlayList myPlaylist = new PlayList("DefaultName");
        }
        
        /*List<Song> selectedSongs = new ArrayList<Song>();
        
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
        * 
        */
            
    }
    
    @Test
    public void skipASongTest() throws InterruptedException, Exception{
        String keyHit = null;
        
        //Build test library
        Library myLibrary = new Library();
        
        myLibrary.addNewSong(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        myLibrary.addNewSong(new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH","c:\\mymusic\\Poison\\OpenUp\\NothingButAGoodTime.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        myLibrary.addNewSong(null);
        
        //build test playlist
        //PlayList myPlaylist;
        try {
            PlayList myPlaylist = new PlayList("My Playlist");
            //myPlaylist.setNewName("My Playlist");
            List<Song> selectedSongs = new ArrayList<Song>();
        
        selectedSongs.add(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        
        //Print out playlist for reference
        for(Song eachSong : selectedSongs){
            int libraryLocation = myLibrary.getSongLocation(eachSong);
            //System.out.println("libraryLocation = " + libraryLocation);
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
        System.out.println("The loop below will send an interrupt to the \"PlayASong\" thread after 20 Seconds...");
        System.out.println("The display will show that the song was interrupted and the next song starts.\n");
        
        int s = 0;
        do{
            if(s > selectedSongs.size()){
                    break;
            }
            for(Song currentSong: selectedSongs){
                keyHit = null;
                s++;
                
            //Song must play in a new thread in order to allow main thread to interrupt it
                Thread t = new Thread(new PlayASong());
                t.start();
            
                int i=0;
            
            //this will simulate the 'Next Song button' being pressed to skip to the next song
                while(t.isAlive() && s <= selectedSongs.size()){
                    if (i > 0){
                        System.out.println(i*10 + " Seconds into playing song: "+currentSong.showPath(currentSong));
                    }
                
                    t.join(10000);
                    i++;
                
                    if(i == 2 && t.isAlive()){
                        keyHit = "Skip";
                    }
                    
                    if(keyHit != null){
                        t.interrupt();
                        break;
                    }
                }
                if(keyHit == "Stop"){
                    break;
                }
            }
        }while(keyHit != "Stop");
        
        } catch (Exception ex) {
            System.out.println("A playlist MUST have a name... defaulting the name...");
            //Logger.getLogger(PlayListTests.class.getName()).log(Level.SEVERE, null, ex);
            PlayList myPlaylist = new PlayList("DefaultName");
        }
        
        /*List<Song> selectedSongs = new ArrayList<Song>();
        
        selectedSongs.add(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        
        //Print out playlist for reference
        for(Song eachSong : selectedSongs){
            int libraryLocation = myLibrary.getSongLocation(eachSong);
            //System.out.println("libraryLocation = " + libraryLocation);
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
        System.out.println("The loop below will send an interrupt to the \"PlayASong\" thread after 20 Seconds...");
        System.out.println("The display will show that the song was interrupted and the next song starts.\n");
        
        int s = 0;
        do{
            if(s > selectedSongs.size()){
                    break;
            }
            for(Song currentSong: selectedSongs){
                keyHit = null;
                s++;
                
            //Song must play in a new thread in order to allow main thread to interrupt it
                Thread t = new Thread(new PlayASong());
                t.start();
            
                int i=0;
            
            //this will simulate the 'Next Song button' being pressed to skip to the next song
                while(t.isAlive() && s <= selectedSongs.size()){
                    if (i > 0){
                        System.out.println(i*10 + " Seconds into playing song: "+currentSong.showPath(currentSong));
                    }
                
                    t.join(10000);
                    i++;
                
                    if(i == 2 && t.isAlive()){
                        keyHit = "Skip";
                    }
                    
                    if(keyHit != null){
                        t.interrupt();
                        break;
                    }
                }
                if(keyHit == "Stop"){
                    break;
                }
            }
        }while(keyHit != "Stop");
        * 
        */
    }
    
    
    @Test
    public void stopASongTest() throws InterruptedException, Exception{
        
        String keyHit = null;
        //Build test library
        Library myLibrary = new Library();
        
        myLibrary.addNewSong(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        myLibrary.addNewSong(new Song("Nothing But A Good Time", "Poison","Open Up And Say AHHH","c:\\mymusic\\Poison\\OpenUp\\NothingButAGoodTime.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        myLibrary.addNewSong(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        myLibrary.addNewSong(null);
        
        //build test playlist
        //PlayList myPlaylist;
        try {
            PlayList myPlaylist = new PlayList("My Playlist");
            //myPlaylist.setNewName("My Playlist");
            List<Song> selectedSongs = new ArrayList<Song>();
        
        selectedSongs.add(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        
        //Print out playlist for reference
        for(Song eachSong : selectedSongs){
            int libraryLocation = myLibrary.getSongLocation(eachSong);
            //System.out.println("libraryLocation = " + libraryLocation);
            myPlaylist.setLibraryLocation(libraryLocation);
        }

        assertEquals(3,myPlaylist.getPlaylistSize());
        
        int searchIndex = 0;
        String songInfo = null;
        
        System.out.println("Playlist Test 3: Playlist \"" + myPlaylist.getPlaylistName() + "\" consists of the following songs:\n" );
        for(int i = 0;i < myPlaylist.getPlaylistSize();i++){
            searchIndex = myPlaylist.returnPlaylistEntry(i);
            songInfo = myLibrary.displayPlayListSong(searchIndex);
            System.out.print(songInfo + "\n");
        }
        
        System.out.println("\nFor this test, each song has a simulated 2 minute play time...");
        System.out.println("The loop below will send an interrupt to the \"PlayASong\" thread after 20 Seconds...");
        System.out.println("The display will show that playing was stopped.\n");
        int s = 0;
        
        do{
            if(s > selectedSongs.size()){
                    break;
            }
            for(Song currentSong: selectedSongs){
                keyHit = null;
                s++;
                
            //Song must play in a new thread in order to allow main thread to interrupt it
                Thread t = new Thread(new PlayASong());
                t.start();
            
                int i=0;
            
            //this will simulate the 'Next Song button' being pressed to skip to the next song
                while(t.isAlive() && s <= selectedSongs.size()){
                    if (i > 0){
                        System.out.println(i*10 + " Seconds into playing song: "+currentSong.showPath(currentSong));
                    }
                
                    t.join(10000);
                    i++;
                
                    if(i == 2 && t.isAlive()){
                        keyHit = "Stop";
                    }
                    
                    if(keyHit != null){
                        t.interrupt();
                        break;
                    }
                }
                if(keyHit == "Stop"){
                    break;
                }
            }
        }while(keyHit != "Stop");
        } catch (Exception ex) {
            System.out.println("A playlist MUST have a name... defaulting the name...");
            //Logger.getLogger(PlayListTests.class.getName()).log(Level.SEVERE, null, ex);
            PlayList myPlaylist = new PlayList("DefaultName");
        }
        
        /*List<Song> selectedSongs = new ArrayList<Song>();
        
        selectedSongs.add(new Song("Roll With The Changes", "REO Speedwagon","You Can Tune A Piano But You Can't Tune A Fish"
                ,"c:\\mymusic\\REO\\Tuna\\RollWithTheChanges.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Caught In The Act","c:\\mymusic\\Styx\\CaughtInTheAct\\CrystalBall.mp3"));
        selectedSongs.add(new Song("Crystal Ball", "Styx","Crystal Ball","c:\\mymusic\\Styx\\CrystalBall\\CrystalBall.mp3"));
        
        //Print out playlist for reference
        for(Song eachSong : selectedSongs){
            int libraryLocation = myLibrary.getSongLocation(eachSong);
            //System.out.println("libraryLocation = " + libraryLocation);
            myPlaylist.setLibraryLocation(libraryLocation);
        }

        assertEquals(3,myPlaylist.getPlaylistSize());
        
        int searchIndex = 0;
        String songInfo = null;
        
        System.out.println("Playlist Test 3: Playlist \"" + myPlaylist.getPlaylistName() + "\" consists of the following songs:\n" );
        for(int i = 0;i < myPlaylist.getPlaylistSize();i++){
            searchIndex = myPlaylist.returnPlaylistEntry(i);
            songInfo = myLibrary.displayPlayListSong(searchIndex);
            System.out.print(songInfo + "\n");
        }
        
        System.out.println("\nFor this test, each song has a simulated 2 minute play time...");
        System.out.println("The loop below will send an interrupt to the \"PlayASong\" thread after 20 Seconds...");
        System.out.println("The display will show that playing was stopped.\n");
        int s = 0;
        
        do{
            if(s > selectedSongs.size()){
                    break;
            }
            for(Song currentSong: selectedSongs){
                keyHit = null;
                s++;
                
            //Song must play in a new thread in order to allow main thread to interrupt it
                Thread t = new Thread(new PlayASong());
                t.start();
            
                int i=0;
            
            //this will simulate the 'Next Song button' being pressed to skip to the next song
                while(t.isAlive() && s <= selectedSongs.size()){
                    if (i > 0){
                        System.out.println(i*10 + " Seconds into playing song: "+currentSong.showPath(currentSong));
                    }
                
                    t.join(10000);
                    i++;
                
                    if(i == 2 && t.isAlive()){
                        keyHit = "Stop";
                    }
                    
                    if(keyHit != null){
                        t.interrupt();
                        break;
                    }
                }
                if(keyHit == "Stop"){
                    break;
                }
            }
        }while(keyHit != "Stop");
        * 
        */
    }
    
    
}
