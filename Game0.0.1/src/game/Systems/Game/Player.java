package game.Systems.Game;

import game.Systems.Entities.Entity;
import game.Systems.Messaging.InputMessage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;


/**
 * Created by Daniel on 11/18/2017.
 */
public class Player extends Entity {

    static Player player;

    private int speed = 1;


    public Image sprite;
    public ImageObserver imageObserver;

    private Player(int x, int y)
    {
        super(x, y, 19, 29);

        try
        {
            String workingDir = java.lang.System.getProperty("user.dir");
            sprite = ImageIO.read(new File(workingDir + "\\Game0.0.1\\src\\game\\player_sprite.jpg"));
            imageObserver = new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            };
        } catch (IOException e)
        {
            String workingDir = java.lang.System.getProperty("user.dir");
            java.lang.System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }
        this.width = sprite.getWidth(imageObserver);
        this.height = sprite.getHeight(imageObserver);

    }

    public static Player getPlayer()
    {
        if (player == null)
        {
            player = new Player(200, 300);

        }
        return player;
    }


    public void action(InputMessage e)
    {
        if (e.keysPressed[KeyEvent.VK_W])
            moveUp(speed);

        if (e.keysPressed[KeyEvent.VK_A])
            moveLeft(speed);

        if (e.keysPressed[KeyEvent.VK_S])
            moveDown(speed);


        if (e.keysPressed[KeyEvent.VK_D])
            moveRight(speed);

        if (e.keysPressed[KeyEvent.VK_SPACE])
            shoot();
    }

    public void shoot()
    {
        Bullet b = new Bullet(getX(), getY());
        b.setOrientation(this.orientation);
    }

    public void kill()
    {
        super.kill();
        player = null;
    }

}
