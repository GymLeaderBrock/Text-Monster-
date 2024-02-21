import java.util.ArrayList;
import java.util.Scanner;
public class MyProgram
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        // 0 = nothing
        // 1 = Penne Pasta
        // 2 = a radicative raccon
        // 3 = stairs up
        // 4 = stairs down
        // 5 = monster
        // 6 = boss/ prize
        int[][] board = {
            {1, 0, 3, 5, 2},
            {5, 1, 4, 3, 1},
            {6, 1, 5, 4, 5}};
        boolean alive = true;
        
        
        System.out.println("Welcome to the game. Have a good time . . . or not :D");
        
        Player player = new Player();
        
        while (alive){
            System.out.print("The room ");
            if (board[player.getFloor()][player.getRoom()] == 0){
                System.out.println("is empty.");
            } else if (board[player.getFloor()][player.getRoom()] == 1){
                System.out.println("has a piece of Penne Pasta in it.");
            } else if (board[player.getFloor()][player.getRoom()] == 2){
                System.out.println("has a radicative raccon item in it.");
            } else if (board[player.getFloor()][player.getRoom()] == 3){
                System.out.println("has stairs going up.");
            } else if (board[player.getFloor()][player.getRoom()] == 4){
                System.out.println("has stairs going down.");
            } else if (board[player.getFloor()][player.getRoom()] == 5){
                System.out.println("has a monster in it.");
            } else if (board[player.getFloor()][player.getRoom()] == 6){
                System.out.println("has a scary big monster in it.");
            }
            System.out.println("What would you like to do?");
            String answer = input.nextLine();
            if (answer.toLowerCase().equals("left")){
                if (board[player.getFloor()][player.getRoom()] == 5 || board[player.getFloor()][player.getRoom()] == 6){
                    System.out.println();
                    System.out.println("You attempt to retreat in terror but forget that the monster is much faster than you. The monster easily catches you and forces you to be it's personal pet for the rest of your life. maybe next time you could find a companion so your not all alone when you die.");
                    alive = false;
                } else {
                    if (player.left()){
                        System.out.println();
                        System.out.println("You gritty into the room to your left");
                    }else{
                        System.out.println();
                        continue;
                    }
                }
            }else if (answer.toLowerCase().equals("right")){
                if (board[player.getFloor()][player.getRoom()] == 5 || board[player.getFloor()][player.getRoom()] == 6){
                    System.out.println();
                    System.out.println("You attempt to retreat in terror but forget that the monster is much faster than you. The monster easily catches you and forces you to be it's personal chef. maybe you could find some Penne pasta lying around to cook them a meal.");
                    alive = false;
                } else {
                    if (player.right()){
                        System.out.println();
                        System.out.println("You trip and faceplant into the room to your right. how are you this clummsy learn to walk.");
                    }else{
                        System.out.println();
                        continue;
                    }
                }
            }else if (answer.toLowerCase().equals("up")){
                if (board[player.getFloor()][player.getRoom()] == 5 || board[player.getFloor()][player.getRoom()] == 6){
                    System.out.println();
                    System.out.println("You attempt to retreat in terror but forget that the monster is much faster than you. The monster easily catches you and forces you to be it's personal door mat for the rest of eternity maybe you should just uninstall.");
                    alive = false;
                } else {
                    System.out.println();
                    System.out.println("You go up the stairs skipping every other step");
                    player.up(board);
                }
            }else if (answer.toLowerCase().equals("down")){
                if (board[player.getFloor()][player.getRoom()] == 5 || board[player.getFloor()][player.getRoom()] == 6){
                    System.out.println();
                    System.out.println("You attempt to retreat in terror but forget that the monster is much faster than you. The monster easily catches you maybe you should go out side and touch some grass or go to the gym insted of playing this game you sweaty little gammer.");
                    alive = false;
                } else {
                    System.out.println();
                    System.out.println("You fall down the stairs very gracefully");
                    player.down(board);
                }
            } else if (answer.toLowerCase().equals("fight")){
                if (board[player.getFloor()][player.getRoom()] == 5 || board[player.getFloor()][player.getRoom()] == 6){
                    if (player.fight(board)){
                        System.out.println();
                        System.out.println("You successfully shove a tube of penne pasta down the monster's throught and kill them.");
                        if (board[player.getFloor()][player.getRoom()] == 6){
                            board[player.getFloor()][player.getRoom()] = 0;
                            break;
                        }
                        board[player.getFloor()][player.getRoom()] = 0;
                    } else {
                        System.out.println();
                        System.out.println("The monster kills you. Do better next time, loser. How could you lose this games its for like two year olds");
                        alive = false;
                    }
                } else {
                    System.out.println();
                    System.out.println("The only thing you can fight in this room is your shadow and maybe that monster sneeking up behind you! ha! made you look! look who's gullile now");
                }
                player.fight(board);
            } else if (answer.toLowerCase().equals("grab")){
                if (player.grab(board)){
                    if (board[player.getFloor()][player.getRoom()] == 6) {
                        break;
                    } else {
                        System.out.println();
                        System.out.println("You grab the item.");
                    }
                    board[player.getFloor()][player.getRoom()] = 0;
                } else if (board[player.getFloor()][player.getRoom()] == 5){
                    alive = false;
                } else if (board[player.getFloor()][player.getRoom()] == 6){
                    break;
                }
            } else if (answer.toLowerCase().equals("retreat")){
                if (board[player.getFloor()][player.getRoom()] == 5 || board[player.getFloor()][player.getRoom()] == 6){
                    player.retreat(board);
                } else {
                    System.out.println();
                    System.out.println("There is no monster to retreat from. Are you scared of the dark or somthing? Grow up.");
                }
            } else if (answer.toLowerCase().equals("inventory")){
                player.inventory();
            } else if (answer.toLowerCase().equals("help")){
                help();
            } else{
                System.out.println();
                System.out.println("That is not a valid command. Type help for list of valid commands.");
            }
            System.out.println();
        }
        System.out.print("GAME OVER - ");
        if (alive == false){
            System.out.println("YOU LOSE.");
        } else{
            System.out.println("YOU WIN. your prize is some parmsane cheese that makes the penne pasta safe to eat");
        }
    }
    
    public static void help()
    {
        System.out.println("LEFT = MOVE LEFT ONE ROOM");
        System.out.println("RIGHT = MOVE RIGHT ONE ROOM");
        System.out.println("GRAB = GRAB ITEM IN ROOM");
        System.out.println("UP = MOVE UP ONE FLOOR");
        System.out.println("DOWN = MOVE DOWN ONE FLOOR");
        System.out.println("FIGHT = FIGHT MONSTER IN ROOM");
        System.out.println("INVENTORY = LIST OF ITEMS IN YOUR INVENTORY");
        System.out.println("RETREAT = MOVE AWAY FROM MONSTER AND TO YOUR PREVIOUS LOCATION");
        System.out.println();
        System.out.println("Remember- You cannot move past a monster without killing it.");
        System.out.println("Also, strangely Penne Pasta are single-use items. Also please dont eat the Penne Pasta you dont know were its been.");
    }
}
