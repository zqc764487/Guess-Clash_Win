/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess.clash_win;
import java.util.Random;

/**
 *
 * @author Qichang_Zheng
 */
public class Board {
    
    private Pixel[][] myPixel;
    
    private int numPixelX;
    private int numPixelY;
    
    public Board(){
        // Call the other constructor, defining one deck without shuffling           
        this(false);           
    }
    
    public Board(boolean shuffle){
        this.numPixelX=10;
        this.numPixelY=10;
        this.myPixel = new Pixel[this.numPixelX][this.numPixelY];
        
        // for each number
        for(int s = 0; s < numPixelX; s++){
            for(int p = 0; p < numPixelY; p++){
                 //add a new Pixel to the Board
                myPixel[s][p] = new Pixel(s, p, false, false);
               
            }
            
            
        }
        if(shuffle){
           this.shuffle();
        }
        
    }
    
     public void shuffle(){
         Random rng = new Random();
         
        //temporary Pixel
        // for each number
        for(int s = 0; s < numPixelX; s++){
            for(int p = 0; p < numPixelY; p++){
                 //add a new Pixel to the Board
                myPixel[s][p] = new Pixel(s, p, Math.random() < 0.5, Math.random() < 0.5);

            }
            
            
        }
         
     }
     
     
    public void printBoard(int numPixelX, int numPixelY){
        for(int c=0; c<numPixelX; c++){
            for(int s=0; s<numPixelY; s++){
                System.out.printf("% 3d/%d %s\n", c+1, s+1,
                    this.myPixel[c][s].toString());
            }
            
        }
//        System.out.printf("\t[%d others]\n", this.numCards-numToPrint);
    }
}
