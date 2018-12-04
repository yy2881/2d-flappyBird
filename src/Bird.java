import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bird {
    int birdPosX;
    int birdPosY;
    BufferedImage bird;

    float v0 = 4;
    float gravity = 1;
    float v = v0 - gravity;

    public Bird() {
        resetBird();
    }

    public void resetBird() {
        birdPosX = 100;
        birdPosY = 100;
        float v;
    }

    public void draw(Graphics g) {

        try {
            bird = ImageIO.read(Stage.class.getResourceAsStream("bird_up.png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bird, birdPosX, birdPosY, null);
    }
    public void update(){
        birdPosY += v0 - gravity;

    }
    public int getBirdPosX(){
        return birdPosX;
    }
    public int getBirdPosY(){
        return birdPosY;
    }
    public void jump(){
        birdPosY -= 35;
    }
}