import java.awt.*;
import java.util.Random;

public class Pipes {

    private int pipeWidth = 100;
    private int pipeHorizontalSpacing = 210;
    private int pipeVerticalSpacing = 180;
    private float xVel = -5.0f;
    private float x1,x2,x3;
    private float y1,y2,y3;


    //the pipe that is closest to the bird
    private int currentPipe;
    //an array to hold the pipes' coordinates
    private float [][] pipeCoords = new float[3][2];
    private Random rand;
    public Pipes(){
        rand = new Random();
        resetPipes();
    }

    public void resetPipes(){
        currentPipe = 0;
        x1 = Stage.WIDTH * 1.3f;
        x2 = x1 + pipeWidth + pipeHorizontalSpacing;
        x3 = x2 + pipeWidth + pipeHorizontalSpacing;
        y1 = getRandomY();
        y2 = getRandomY();
        y3 = getRandomY();
    }

    private int getRandomY(){
        return rand.nextInt((int)(Stage.HEIGHT * 0.4f) + (Stage.HEIGHT/10));   // HEIGHT 是static field，可以直接通过CLASS.访问到，不需要实例object;40% pipe的高度是upper bound（能render的管子最大高度）

    }

    //helping methods to get relevant values from this class
    public float[] getCurrentPipe(){
        return pipeCoords[currentPipe];
    }
    public int getCurrentPipeID(){
        return currentPipe;
    }
    public int getPipeHorizontalSpacing(){
        return pipeHorizontalSpacing;
    }
    public int getPipeVerticalSpacing(){
        return pipeVerticalSpacing;
    }
    public int getPipeWidth(){
        return pipeWidth;
    }


    public void update() {
        x1 += xVel;
        x2 += xVel;
        x3 += xVel;

        if(x1 + pipeWidth < 0){
            x1 = Stage.WIDTH;
            y1 = getRandomY();
            currentPipe = 1;
        }
        if(x2 + pipeWidth < 0){
            x2 = Stage.WIDTH;
            y2 = getRandomY();
            currentPipe = 2;
        }
        if(x3 + pipeWidth < 0){
            x3 = Stage.WIDTH;
            y3 = getRandomY();
            currentPipe = 0;
        }


        //update pipes' coordinates
        switch (currentPipe){
            case 0:
                pipeCoords [0][0] = x1;
                pipeCoords [0][1] = y1;
                break;

            case 1:
                pipeCoords [1][0] = x2;
                pipeCoords [1][1] = y2;
                break;

            case 2:
                pipeCoords [2][0] = x3;
                pipeCoords [2][1] = y3;
                break;
        }
    }


    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        //pipe 1
        g.fillRect((int)(x1),0,pipeWidth,(int)y1);
        g.fillRect((int)(x1),(int)(y1 + pipeVerticalSpacing),pipeWidth,Stage.HEIGHT);

        //pipe 2
        g.fillRect((int)(x2),0,pipeWidth,(int)y2);
        g.fillRect((int)(x2),(int)(y2 + pipeVerticalSpacing),pipeWidth,Stage.HEIGHT);

        //pipe3
        g.fillRect((int)(x3),0,pipeWidth,(int)y3);
        g.fillRect((int)(x3),(int)(y3 + pipeVerticalSpacing),pipeWidth,Stage.HEIGHT);
    }
}


