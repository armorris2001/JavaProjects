/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs277lab21multithreading;
import java.util.Scanner;
/**
 *
 * @author Adam
 */
public class CECS277Lab21Multithreading {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int threadCount;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter number of threads you wish to make: ");
        threadCount = in.nextInt();
        
        for(int i = 0; i < threadCount; i++){
            Runnable r = new MyRunnable(i);
            Thread t = new Thread(r);
            t.start();
        }
    }
    
}
