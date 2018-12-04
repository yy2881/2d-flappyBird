
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Stage extends JPanel implements ActionListener, KeyListener {
    public static int WIDTH = 800,HEIGHT = 600;
    private  boolean play = false;
    private Timer timer;
    private int score = 0;
    private int scoredPipe = 0;

    Pipes p = new Pipes();
    Bird b = new Bird();


    private enum STATE{
        MENU,
        PLAY
    };
    private STATE state = STATE.MENU;




    //constructor
    public Stage(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(20, this);
        timer.start();
    }

    public void paint(Graphics g){
        if(state == STATE.PLAY) {

            //draw 'bird'
            b.draw((Graphics) g);

            //draw pipes
            p.draw((Graphics) g);
            g.setColor(Color.red);
            g.setFont(new Font("Ariel", Font.BOLD, 30));
            g.drawString("Score: " + score, 20, 50);


            //collision detection
            float[] pipeCoords = p.getCurrentPipe();
            float pipeX = pipeCoords[0];
            float pipeY = pipeCoords[1];
            if ((b.getBirdPosX() >= pipeX && b.getBirdPosX() <= pipeX + p.getPipeWidth() && (b.getBirdPosY() <= pipeY || b.getBirdPosY() >= pipeY + p.getPipeVerticalSpacing())) || b.getBirdPosY() >= Stage.HEIGHT) { play = false;
                {
                    timer.stop();   // if collided, game over
                    g.setColor(Color.red);
                    g.setFont(new Font("Ariel", Font.BOLD, 30));
                    g.drawString("Game Over", 328, 300);
                    g.setFont(new Font("Ariel", Font.BOLD, 20));
                    g.drawString("Press Enter to Restart", 305, 350);
                    score = 0;
                }

            } else{
                int currentPipeId = p.getCurrentPipeID();     //if not collided, gain score
                score = (scoredPipe == currentPipeId - 1) ? score + 1 : score;
                scoredPipe = currentPipeId;
            }

        }else if(state == STATE.MENU){
            Menu.paint((Graphics) g);
        }
        //free memory
        g.dispose();

    }

    @Override

    public void actionPerformed (ActionEvent e){
        timer.start();
        repaint();
        b.update();
        p.update();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            play = true;
            b.jump();
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            timer.start();
            if(!play){
                play = true;
                p.resetPipes();
                b.resetBird();
                score = 0;
                state = STATE.PLAY;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }


}

