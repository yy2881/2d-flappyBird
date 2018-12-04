import java.awt.*;


public class Menu  {

    public static void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,800,600);
        g.setColor(Color.white);
        g.setFont(new Font("Ariel", Font.BOLD, 50));
        g.drawString("FLAPPY BIRD",230,200);
        g.setFont(new Font("Ariel", Font.BOLD, 20));
        g.drawString("Press Enter to start",290,350);

    }


}
