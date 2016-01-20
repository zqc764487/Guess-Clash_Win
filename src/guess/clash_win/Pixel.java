/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess.clash_win;

import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author Qichang_Zheng
 */
public class Pixel {

    /**
     * The position which a certain Pixel locates.
     */
    private int coordinateX;
    private int coordinateY;
    
    
    /**
     * The mark status of this Pixel. (whether the opponent marks this pixel)
     */
    private boolean isMark;

    /**
     * Whether the opponent mark this pixel as main.
     */
    private boolean isMain;
    
    /**
     * Weather the face of Pixel is up.
     */
    private boolean isFaceUp;
    
    /**
     * Pixel constructor
     * 
     * @param aMark the suit of the card
     * @param aMain the value of the card
     * @param aFaceUp the value of the card
     */
    public Pixel(int acoordinateX, int acoordinateY, boolean aMark, boolean aMain){
        if(acoordinateX >=0 && acoordinateX <=9)this.coordinateX = acoordinateX;
        else{
            System.err.println(acoordinateX + "is not a valid Pixel Number");
            System.exit(1);
        }
        if(acoordinateY >=0 && acoordinateY <=9)this.coordinateY = acoordinateY;
        else{
            System.err.println(acoordinateY + "is not a valid Pixel Number");
            System.exit(1);
        }
        this.isMark = aMark;
        this.isMain = aMain;
        this.isFaceUp = false;
    }
    
    /**
     * Pixel constructor (default).
     */
    
    public Pixel(){
        this.coordinateX = 0;
        this.coordinateY = 0;
        this.isMark = false;
        this.isMain=false;
        this.isFaceUp = false;    
    }
    
    /**
     * Pixel return.
     */
    public int GetcoordinateX(){
        return coordinateX;
    }
    public int GetcoordinateY(){
        return coordinateY;
    }
    public boolean getisMark(){
        return isMark;
    }
    public boolean getisMain(){
        return isMain;
    }
    public boolean getisFaceUp(){
        return isFaceUp;
    }
    
    /**
     * Pixel set the Faceup
     */    
    
    public void setFaceUp(boolean on)  
    {  
        isFaceUp=on;  
    }
    
    public Icon getIcon() {
        if(isFaceUp){  
            return new ImageIcon(this.getClass().getResource("images/"+isMark+isMain+".png"));  
        } else {  
            return new ImageIcon(this.getClass().getResource("images/b2fv.png")); 
        }       
    }
    
    public String toString(){
        String str = "";
        str += "The Pixel in ["+ String.valueOf(coordinateX) +"] and [" + String.valueOf(coordinateY) +"] has"
            + "been set; \t";
        str += "IsMark: "+ String.valueOf(isMark) + "\t";
        str += "IsMain: "+ String.valueOf(isMain) + "\t";
        str += "FaceUp: "+ String.valueOf(isFaceUp) + ".";
        return str;
    }
    
    
    
}
