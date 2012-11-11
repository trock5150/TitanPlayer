/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanplayer.bll;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rocky
 */
public class PlayASong extends Thread{

    public void run(){
            System.out.println("Playing the song in a new thread");
            try {
                //built in 2 minute sleep period to simulate a short song
                Thread.sleep(200000);
            } catch (InterruptedException ex) {
                System.out.println("Interrupt was encountered!");

            }
    }
}
