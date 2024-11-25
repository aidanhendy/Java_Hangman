public class Drawer
{
    private Game game;

    public Drawer(Game g)
    {
        this.game = g;
    }

    public void drawPerson()
    {
       switch (game.getGuesses()) {
         case 0:
            System.out.println(" 0\n |\n |\n/ \\");
            break;
         case 1:
            System.out.println(" 0\n |\n |\n/");
            break;
         case 2:
            System.out.println(" 0\n |\n |");
            break;
         case 3:
            System.out.println(" 0\n |");
            break;
         case 4:
            System.out.println(" 0");
            break;
         default:
            System.out.println(":)");
    }
}
}
