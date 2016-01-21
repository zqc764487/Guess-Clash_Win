/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessandclash_aisetplane;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sheng Li
 */
public class GuessAndClash_AISetPlane{

    /**
     * @return 
     */
    
    public static int squareNumber(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the size you want your battlefield is:");
        int size = reader.nextInt();
        return size;
    }
    
    public static int[][] initBattlefield(int row_column){
        int[][] btlField = new int[row_column][row_column];
        for(int initRow = 0; initRow < row_column; initRow++)
            for(int initColumn = 0; initColumn < row_column; initColumn++){
                btlField[initRow][initColumn] = 0;
        }
        return btlField;
    }
    
    public static boolean checkOccupied(int spot){
        if(spot != 0){
            return false;//false means occupied already
        }
        else return true;//true means not occupied
    }
    
    public static int[][] setCraft(int row,int column, int direction, int[][] battleField, int battleFieldSz){
            
        Random randomNumber = new Random();
        int numOfCrafts = 0;
        
        while(numOfCrafts < 3){
            int[][] record = new int [10][2];//"10" here means how many components in one craft
            int[][] headPosition = new int [3][2];//store heads' position for three crafts
            int i = 0;
            
            switch(direction){
                case 1: //up
                        if((row>=0&&row<=battleFieldSz-1-3)&&(column>=2&&column<=battleFieldSz-1-2)){
                    //head
                    if(checkOccupied(battleField[row][column])){
                        record[i][0] = row;
                        record[i][1] = column;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //body1
                    if(checkOccupied(battleField[row+1][column])){
                        record[i][0] = row+1;
                        record[i][1] = column;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //left wing root
                    if(checkOccupied(battleField[row+1][column-1])){
                        record[i][0] = row+1;
                        record[i][1] = column-1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //left wing rear
                    if(checkOccupied(battleField[row+1][column-2])){
                        record[i][0] = row+1;
                        record[i][1] = column-2;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //right wing root
                    if(checkOccupied(battleField[row+1][column+1])){
                        record[i][0] = row+1;
                        record[i][1] = column+1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                        }
                    //right wing rear
                    if(checkOccupied(battleField[row+1][column+2])){
                        record[i][0] = row+1;
                        record[i][1] = column+2;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //body2
                    if(checkOccupied(battleField[row+2][column])){
                        record[i][0] = row+2;
                        record[i][1] = column;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear center
                    if(checkOccupied(battleField[row+3][column])){
                        record[i][0] = row+3;
                        record[i][1] = column;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear left
                    if(checkOccupied(battleField[row+3][column-1])){
                        record[i][0] = row+3;
                        record[i][1] = column-1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear right
                    if(checkOccupied(battleField[row+3][column+1])){
                        record[i][0] = row+3;
                        record[i][1] = column+1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    for(int j=0 ;j<i;j++)
                    {
                        //System.out.println(record[j][0] +" "+ record[j][1]);
                        if(j==0)
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1 + 6;
                        else
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1;
                    }
                    
                    headPosition[numOfCrafts][0] = row;
                    headPosition[numOfCrafts][1] = column;
                    numOfCrafts++;
                    
                    }
                    else{
                        //System.out.println("need to reset the plane.");
                    }
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                    
                    break;
                case 2: //down
                    //head
                    if((row>=3&&row<=battleFieldSz-1)&&(column>=2&&column<=battleFieldSz-1-2)){
                    if(checkOccupied(battleField[row][column])){
                        record[i][0] = row;
                        record[i][1] = column;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //body1
                    if(checkOccupied(battleField[row-1][column])){
                        record[i][0] = row-1;
                        record[i][1] = column;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //left wing root
                    if(checkOccupied(battleField[row-1][column-1])){
                        record[i][0] = row-1;
                        record[i][1] = column-1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //left wing rear
                    if(checkOccupied(battleField[row-1][column-2])){
                        record[i][0] = row-1;
                        record[i][1] = column-2;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //right wing root
                    if(checkOccupied(battleField[row-1][column+1])){
                        record[i][0] = row-1;
                        record[i][1] = column+1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                        }
                    //right wing rear
                    if(checkOccupied(battleField[row-1][column+2])){
                        record[i][0] = row-1;
                        record[i][1] = column+2;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //body2
                    if(checkOccupied(battleField[row-2][column])){
                        record[i][0] = row-2;
                        record[i][1] = column;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear center
                    if(checkOccupied(battleField[row-3][column])){
                        record[i][0] = row-3;
                        record[i][1] = column;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear left
                    if(checkOccupied(battleField[row-3][column-1])){
                        record[i][0] = row-3;
                        record[i][1] = column-1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear right
                    if(checkOccupied(battleField[row-3][column+1])){
                        record[i][0] = row-3;
                        record[i][1] = column+1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    for(int j=0 ;j<i;j++)
                    {
                        //System.out.println(record[j][0] +" "+ record[j][1]);
                        if(j==0)
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1 + 6;
                        else
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1;
                    }
                    
                    headPosition[numOfCrafts][0] = row;
                    headPosition[numOfCrafts][1] = column;
                    numOfCrafts++;
                    
                    }
                    else{
                        //System.out.println("need to reset the plane");
                    }
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                    
                    break;
                case 3: //left
                    //head
                    if((row>=2&&row<=battleFieldSz-1-2)&&(column>=0&&column<=battleFieldSz-1-3)){
                    if(checkOccupied(battleField[row][column])){
                        record[i][0] = row;
                        record[i][1] = column;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //body1
                    if(checkOccupied(battleField[row][column+1])){
                        record[i][0] = row;
                        record[i][1] = column+1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //left wing root
                    if(checkOccupied(battleField[row-1][column+1])){
                        record[i][0] = row-1;
                        record[i][1] = column+1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //left wing rear
                    if(checkOccupied(battleField[row-2][column+1])){
                        record[i][0] = row-2;
                        record[i][1] = column+1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //right wing root
                    if(checkOccupied(battleField[row+1][column+1])){
                        record[i][0] = row+1;
                        record[i][1] = column+1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                        }
                    //right wing rear
                    if(checkOccupied(battleField[row+2][column+1])){
                        record[i][0] = row+2;
                        record[i][1] = column+1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //body2
                    if(checkOccupied(battleField[row][column+2])){
                        record[i][0] = row;
                        record[i][1] = column+2;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear center
                    if(checkOccupied(battleField[row][column+3])){
                        record[i][0] = row;
                        record[i][1] = column+3;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear left
                    if(checkOccupied(battleField[row-1][column+3])){
                        record[i][0] = row-1;
                        record[i][1] = column+3;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear right
                    if(checkOccupied(battleField[row+1][column+3])){
                        record[i][0] = row+1;
                        record[i][1] = column+3;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    for(int j=0 ;j<i;j++)
                    {
                        //System.out.println(record[j][0] +" "+ record[j][1]);
                        if(j==0)
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1 + 6;
                        else
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1;
                    }
                    
                    headPosition[numOfCrafts][0] = row;
                    headPosition[numOfCrafts][1] = column;
                    numOfCrafts++;
                    
                    }
                    else{
                        //System.out.println("need to reset the plane");
                    }
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                    
                    break;
                case 4: //right
                    //head
                    if((row>=2&&row<=battleFieldSz-1-2)&&(column>=3&&column<=battleFieldSz-1)){
                    if(checkOccupied(battleField[row][column])){
                        record[i][0] = row;
                        record[i][1] = column;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //body1
                    if(checkOccupied(battleField[row][column-1])){
                        record[i][0] = row;
                        record[i][1] = column-1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //left wing root
                    if(checkOccupied(battleField[row-1][column-1])){
                        record[i][0] = row-1;
                        record[i][1] = column-1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //left wing rear
                    if(checkOccupied(battleField[row-2][column-1])){
                        record[i][0] = row-2;
                        record[i][1] = column-1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //right wing root
                    if(checkOccupied(battleField[row+1][column-1])){
                        record[i][0] = row+1;
                        record[i][1] = column-1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                        }
                    //right wing rear
                    if(checkOccupied(battleField[row+2][column-1])){
                        record[i][0] = row+2;
                        record[i][1] = column-1;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //body2
                    if(checkOccupied(battleField[row][column-2])){
                        record[i][0] = row;
                        record[i][1] = column-2;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear center
                    if(checkOccupied(battleField[row][column-3])){
                        record[i][0] = row;
                        record[i][1] = column-3;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear left
                    if(checkOccupied(battleField[row-1][column-3])){
                        record[i][0] = row-1;
                        record[i][1] = column-3;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    //rear right
                    if(checkOccupied(battleField[row+1][column-3])){
                        record[i][0] = row+1;
                        record[i][1] = column-3;
                        i++;
                    }
                    else{
                        //System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    for(int j=0 ;j<i;j++)
                    {
                        //System.out.println(record[j][0] +" "+ record[j][1]);
                        if(j==0)
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1 + 6;
                        else
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1;
                    }
                    
                    headPosition[numOfCrafts][0] = row;
                    headPosition[numOfCrafts][1] = column;
                    numOfCrafts++;
                    
                    }
                    else{
                        //System.out.println("need to reset the plane");
                    }
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                    
                    break;
                default:
                    System.out.println("Sorry, can't understand you direction!");
                    break;
            }
        }
            return battleField;
    }
    
    public static void interact(int[][] battleField){
       
       
       int numOfPlayerKilled = 0, numOfAIKilled = 0;
       int[] craftsHP = new int[3];
       craftsHP[0] = 0;
       craftsHP[1] = 0;
       craftsHP[2] = 0;
       
       Scanner input1 = new Scanner(System.in);
       Scanner input2 = new Scanner(System.in);
       while(numOfPlayerKilled < 3 && numOfAIKilled < 3){
           
           //AI under attack
           
           System.out.print("Where you wanna hit this time: ");
           String d = input1.nextLine();
       
           int row = 0, column = 0;

           Pattern p1 = Pattern.compile("[A-Za-z]+");
           Pattern p2 = Pattern.compile("[0-9]+");
           Matcher m1 = p1.matcher(d);
           Matcher m2 = p2.matcher(d);
           while (m1.find()) {
               row = m1.group().charAt(0) - 'a' + 1;
               System.out.println(row);
           }
           while (m2.find()) {
               column = Integer.parseInt(m2.group());
               System.out.println(column);
           }   
           
           
       if(battleField[row-1][column-1] == 0){
       
           System.out.println("Woohoo, you didn't get me!");
           
       }
       else if(battleField[row-1][column-1] > 3)
        //component greater than 3 means this is one of the heads
       {
           System.out.println("Holy crap! One down!");
           numOfPlayerKilled++;
       }
       else if(battleField[row-1][column-1] == 1)//the first craft is hit
       {
           if(craftsHP[0] < 3){//1st craft still got more than 1 hp
               System.out.println("You got one hit...");
               craftsHP[0]++;
           }
           else{//1st craft crashes
               System.out.println("Holy crap! One down!");
               numOfPlayerKilled++;
           }
       }
       else if(battleField[row-1][column-1] == 2)//the second craft is hit
       {
           if(craftsHP[1] < 3){//2nd craft still got more than 1 hp
               System.out.println("You got one hit...");
               craftsHP[1]++;
           }
           else{//2nd craft crashes
               System.out.println("Holy crap! One down!");
               numOfPlayerKilled++;
           }
       }
       else if(battleField[row-1][column-1] == 3)//the third craft is hit
       {
           if(craftsHP[2] < 3){//3rd craft still got more than 1 hp
               System.out.println("You got one hit...");
               craftsHP[2]++;
           }
           else{//3rd craft crashes
               System.out.println("Holy crap! One down!");
               numOfPlayerKilled++;
           }
       }
       
       //AI attacks player
       
       int attackRow = 0, attackColumn = 0;
       
       int respond = 4;
       
       while(respond == 4){
           
       //Step 1: randomize a row and a column to attack
       Random randomRow = new Random();
       Random randomColumn = new Random();
       attackRow = randomRow.nextInt(10/*the battle field size*/) + 1;
       attackColumn = randomColumn.nextInt(10/*the battle field size*/) + 1;
       char attackColumnChar = (char) ('a'+ attackColumn);
       System.out.println("My choice is "+attackColumnChar + attackRow);
       
       //Step 2: player respond
       System.out.print("Type in the number (1.Miss 2.Hit 3.One down 4.Duplicate): ");
       respond = input2.nextInt();
       
       if(respond == 1){//miss
           System.out.println("Ohh.. What a pity..");
       }
       else if(respond == 2){//hit
           System.out.println("I'm gonna find your head!");
       }
       else if(respond == 3){//dead
           System.out.println("Yes!");
           numOfAIKilled++;
       }
       else
           System.out.println("Sorry, I'm a stupid bot...");
       
       
       }
   }
   }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //step 1: use the input as the size of battle field and initialize the battle field
        int btlFieldSz = squareNumber();
        int[][] aiBattleField = initBattlefield(btlFieldSz);
        
        //step 2: get the random position and direction for the head of the craft
        Random randomNumber = new Random();
        int aiRow = randomNumber.nextInt(btlFieldSz)+1;
        int aiColumn = randomNumber.nextInt(btlFieldSz)+1;
        int aiDirection = randomNumber.nextInt(4) + 1;
        
        //just for debugging, can be commentted later
        //for(int i = 0; i < btlFieldSz; i++){
        //    for(int j = 0; j < btlFieldSz; j++){
        //        System.out.print(aiBattleField[i][j] + " ");
        //    }
        //    System.out.println();
        //}
        //System.out.println();
        
        //step 3: set up three crafts
        aiBattleField = setCraft(aiRow,aiColumn,aiDirection,aiBattleField,btlFieldSz);
        
        //step 4: print out the battle field with crafts settled
        for(int i = 0; i < btlFieldSz; i++){
            for(int j = 0; j < btlFieldSz; j++)
            {
                System.out.print(aiBattleField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        //step 5: interact
        interact(aiBattleField);
    }
    
}
