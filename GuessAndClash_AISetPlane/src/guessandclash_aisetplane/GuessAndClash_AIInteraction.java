/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessandclash_aisetplane;
/**
 *
 * @author Sheng Li
 */ 
import java.util.*;
import java.util.regex.*;
import javax.swing.*;
import java.awt.*;

public class GuessAndClash_AIInteraction extends GuessAndClash_AISetPlane{
    
   
   public static void main(String[] args) {
       
        GuessAndClash_btlFldFrame mainFrame = new GuessAndClash_btlFldFrame();
        GuessAndClash_AISetPlane play = new GuessAndClash_AISetPlane();


        //gui frame
        mainFrame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        mainFrame.show(true);
        mainFrame.setTitle("Guess and Clash");

       
        //battlefield intials
        int btlFieldSz = play.squareNumber();
        int[][] aiBattleField = play.initBattlefield(btlFieldSz);
        
        
        
        
        //battlefield frame initials
        /*JToggleButton[][] fld = new JToggleButton[btlFieldSz][btlFieldSz];
        int[][] fld0 = new int[btlFieldSz][btlFieldSz];
        for(int i = 0;i<btlFieldSz;i++){
            for(int j = 0;j<btlFieldSz;j++){
                fld[j][i] = new JToggleButton();
                fld[j][i].setSize(jPanel1.getWidth()/btlFieldSz, btlFldPnl.getHeight()/btlFieldSz);
                btlFldPnl.add(fld[j][i]);
                fld[j][i].setLocation(j*btlFldPnl.getWidth()/btlFieldSz, i*btlFldPnl.getHeight()/btlFieldSz);
            }
        }
        */
        
        Random randomNumber = new Random();
        int aiRow = randomNumber.nextInt(btlFieldSz)+1;
        int aiColumn = randomNumber.nextInt(btlFieldSz)+1;
        int aiDirection = randomNumber.nextInt(4) + 1;
        
        aiBattleField = play.setCraft(aiRow,aiColumn,aiDirection,aiBattleField,btlFieldSz);
        
        for(int i = 0; i < btlFieldSz; i++){
            for(int j = 0; j < btlFieldSz; j++)
            {
                System.out.print(aiBattleField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        //ai interaction part
        play.interact(aiBattleField);
   }
}
