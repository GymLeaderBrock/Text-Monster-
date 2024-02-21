import java.util.ArrayList;
import java.util.Arrays;

public class Player 
{
    
    private int[] playerPosition;
    private int[] previousPlayerPosition;
    private ArrayList<String> inventory;
    
    public Player()
    {
        // floor, room
        playerPosition = new int[2];
        playerPosition[0] = 0;
        playerPosition[1] = 0; // floor, room
        previousPlayerPosition = new int[2];
        previousPlayerPosition[0] = 0;
        previousPlayerPosition[1] = 0; // floor, room
        inventory = new ArrayList<String>();
        inventory.add("empty");
        inventory.add("empty");
        inventory.add("empty");  
    }
    
    public boolean right(){
        if (playerPosition[1] < 4){
            previousPlayerPosition[1] = playerPosition[1];
            playerPosition[1]++;
            return true;
        } else {
            System.out.println();
            System.out.println("There is no room to your right.");
            return false;
        }
    }
    
    public boolean left(){
        if (playerPosition[1] > 0){
            previousPlayerPosition[1] = playerPosition[1];
            playerPosition[1]--;
            return true;
        } else{
            System.out.println();
            System.out.println("There is no room to your left.");
            return false;
        }
        
    }
    
    public void up(int[][] board){
        if (board[playerPosition[0]][playerPosition[1]] == 3){
            playerPosition[0]++;
            previousPlayerPosition[0] = playerPosition[0];
        } else {
            System.out.println();
            System.out.println("There are no stairs going up in this room");
        }
    }
    
    public void down(int[][] board){
       if (board[playerPosition[0]][playerPosition[1]] == 4){
           playerPosition[0]--;
           previousPlayerPosition[0] = playerPosition[0];
       }else{
           System.out.println();
           System.out.println("There are no stairs going down in this room");
       }
    }
    
    
    public void inventory(){
        System.out.println();
        System.out.println("Items in your inventory:");
        for (int i = 0; i < inventory.size(); i++){
            System.out.println();
            System.out.println(inventory.get(i));
        }
    }
    
    public boolean grab(int[][] board){
        if (board[playerPosition[0]][playerPosition[1]] == 5){
            System.out.println();
            System.out.println("You reach out to the monster in hopes of forming a friendship. The monster bites your hand off and you die.");
            return false;
        }
        else if (board[playerPosition[0]][playerPosition[1]] == 6){
            System.out.println();
            System.out.println("You grab the bosses hand, y'all make eye contact and realize the monsters eyes are tearing up. . . he has never has a friend before. He shares his story of how when he was a young monster he was always teased and never fit in, so he resorted to a life of fighting humans. But now with your help he is free from his lonely battle. YOU WIN!");
            return true;
        }    
        boolean emptySlots = false;
        for (int i = 0; i < 3; i++){
            if (inventory.get(i).equals("empty")){
                emptySlots = true;
            }
        }
        if (!emptySlots){
            System.out.println();
            System.out.println("You do not have space in your inventory.");
            return false;
        }
        int openSlot = 0;
        if (board[playerPosition[0]][playerPosition[1]] == 2){
            for (int findOpenSlot = 0; findOpenSlot < inventory.size(); findOpenSlot++){
                if (inventory.get(findOpenSlot).equals("empty")){
                    openSlot = findOpenSlot;
                }
            }
            inventory.set(openSlot, "a radicative raccon");
            return true;
        }
        else if (board[playerPosition[0]][playerPosition[1]] == 1){
            for (int findOpenSlot = 0; findOpenSlot < inventory.size(); findOpenSlot++){
                if (inventory.get(findOpenSlot).equals("empty")){
                    openSlot = findOpenSlot;
                }
            }
            inventory.set(openSlot, "Penne Pasta");
            return true;
        } else{
            System.out.println();
            System.out.println("You cannot grab anything in this room.");
            return false;
        }
       
    }
    
    public boolean fight(int[][] board){
        if (board[playerPosition[0]][playerPosition[1]] == 5){
            for (int i = 0; i < 3; i++){
                if (inventory.get(i).equals("Penne Pasta")){
                    inventory.set(i, "empty");
                    return true;
                }
            }
            for (int i = 0; i < 3; i++){
                if (inventory.get(i).equals("a radicative raccon")){
                    return true;
                }
            }
            return false;
        }
        else if (board[playerPosition[0]][playerPosition[1]] == 6){
            for (int i = 0; i < 3; i++){
                if (inventory.get(i).equals("a radicative raccon")){
                    for (int x = 0; x < 3; x++){
                        if (inventory.get(x).equals("Penne Pasta")){
                            inventory.set(x, "empty");
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }
    public void retreat(int[][] board){
        playerPosition[1] = previousPlayerPosition[1];
    }
    public int getFloor()
    {
        return playerPosition[0];
    }
    
    public int getRoom()
    {
        return playerPosition[1];
    }
}
