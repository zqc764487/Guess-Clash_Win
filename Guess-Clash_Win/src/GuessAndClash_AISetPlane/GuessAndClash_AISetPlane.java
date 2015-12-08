/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessandclash_aisetplane;

import java.util.*;

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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    for(int j=0 ;j<i;j++)
                    {
                        System.out.println(record[j][0] +" "+ record[j][1]);
                        if(j==0)
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1 + 9;
                        else
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1;
                    }
                    
                    headPosition[numOfCrafts][0] = row;
                    headPosition[numOfCrafts][1] = column;
                    numOfCrafts++;
                    
                    }
                    else
                        System.out.println("need to reset the plane.");
                    
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    for(int j=0 ;j<i;j++)
                    {
                        System.out.println(record[j][0] +" "+ record[j][1]);
                        if(j==0)
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1 + 9;
                        else
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1;
                    }
                    
                    headPosition[numOfCrafts][0] = row;
                    headPosition[numOfCrafts][1] = column;
                    numOfCrafts++;
                    
                    }
                    else
                        System.out.println("need to reset the plane");
                    
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    for(int j=0 ;j<i;j++)
                    {
                        System.out.println(record[j][0] +" "+ record[j][1]);
                        if(j==0)
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1 + 9;
                        else
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1;
                    }
                    
                    headPosition[numOfCrafts][0] = row;
                    headPosition[numOfCrafts][1] = column;
                    numOfCrafts++;
                    
                    }
                    else
                        System.out.println("need to reset the plane");
                    
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
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
                        System.out.println("Spot already occupied!");
                        
                        row = randomNumber.nextInt(battleFieldSz)+1;
                        column = randomNumber.nextInt(battleFieldSz)+1;
                        direction = randomNumber.nextInt(4) + 1;
                        
                        break;
                    }
                    for(int j=0 ;j<i;j++)
                    {
                        System.out.println(record[j][0] +" "+ record[j][1]);
                        if(j==0)
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1 + 9;
                        else
                        battleField[record[j][0]][record[j][1]] = numOfCrafts + 1;
                    }
                    
                    headPosition[numOfCrafts][0] = row;
                    headPosition[numOfCrafts][1] = column;
                    numOfCrafts++;
                    
                    }
                    else
                        System.out.println("need to reset the plane");
                    
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
        for(int i = 0; i < btlFieldSz; i++){
            for(int j = 0; j < btlFieldSz; j++){
                System.out.print(aiBattleField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
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
        
    }
    
}