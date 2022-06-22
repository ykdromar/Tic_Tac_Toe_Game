import java.util.*;

public class ticTacToe {
    
    private player player1,player2;
    private board board;

    public static void main(String [] args){
        ticTacToe t=new ticTacToe();
        t.startGame();
    }
    public void startGame(){
        Scanner s=new Scanner(System.in);
        player1=takePlayerInput(1);
        player2=takePlayerInput(2);
        while(player1.getSymbol()==player2.getSymbol()){
            System.out.println("Symbol already taken! Try entering another symbol:");
            char symbol=s.next().charAt(0);
            player2.setSymbol(symbol);
        }
        board=new board(player1.getSymbol(),player2.getSymbol());
        boolean player1turn=true;
        int status=board.INCOMPLETE;
        while(status==board.INCOMPLETE|| status==board.INVALID ){
            if(player1turn){
                System.out.println(player1.getName()+" turn");
                System.out.println("Enter x: ");
                int x=s.nextInt();
                System.out.println("Enter y: ");
                int y=s.nextInt();
                status =board.move(player1.getSymbol(),x,y);
                if(status!=board.INVALID){
                    player1turn=false;
                    board.print();
                }else{
                    System.out.println("Invalid Move ! Please Try again !!");
                }
            }else{
                System.out.println(player2.getName()+" turn");
                System.out.println("Enter x: ");
                int x=s.nextInt();
                System.out.println("Enter y: ");
                int y=s.nextInt();
                status =board.move(player2.getSymbol(),x,y);
                if(status!=board.INVALID){
                    player1turn=true;
                    board.print();
                }else{
                    System.out.println("Invalid Move ! Please Try again !!");
                }
            }
        }
        if(status==board.PLAYER1_WINS){
            System.out.println("Player 1 "+player1.getName()+" Win !!");
        }else if(status==board.PLAYER2_WINS){
            System.out.println("Player 2 "+player2.getName()+" Win !!");
        }else{
            System.out.println("Match Draw !!");
        }
    }
    private player takePlayerInput(int num){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Player "+num+" Name:");
        String name=s.nextLine();
        System.out.println("Enter Player "+num+" Symbol:");
        char symbol=s.next().charAt(0);
        player p=new player(name,symbol);
        return p;
    }
}
