import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception 
    {
    
    Scanner input = new Scanner(System.in);
    int cate;
    System.out.print("Select category: (Fruits = 0; Animals = 1; Vegetables = 2): ");
    cate = input.nextInt();


    
    Game game = new Game(cate);
    Drawer draw = new Drawer(game);

    System.out.println(game.getWord()); //for testing so i do not actuallly have to guess letter every time
    game.printDash(); 

    while(game.getGuesses() > 0 && !game.wordComCheck())
    {
        game.askLetter();
        game.printDash();
        draw.drawPerson();

    }
    if(game.getGuesses() == 0)
    {
        System.out.println("you lose");
    }
    if(game.wordComCheck()){
        System.out.println("you win!");
    }
    }
}
