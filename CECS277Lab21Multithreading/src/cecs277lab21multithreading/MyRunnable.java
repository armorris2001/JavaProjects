/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs277lab21multithreading;

/**
 *
 * @author Adam
 */
public class MyRunnable implements Runnable {

    private int tNumber;
    //Constructor
    public MyRunnable(int number){
        tNumber = number;
    }
    
    @Override
    public void run() {
        System.out.println("Hello, I am Thread #" + (tNumber + 1));        
    }
    
}
