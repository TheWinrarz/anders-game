import java.lang.Math;
import java.util.ArrayList;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by Daniel on 11/14/2017.
 */
public class Entity
{
    public int x;
    public int y;
    public double orientation;

    public static ArrayList<Entity> entities = new ArrayList<>(10);

    public Entity(int _x, int _y)
    {
        this.x = _x;
        this.y = _y;
        this.orientation = 0.00;
        entities.add(this);
    }

    public void moveUp(int amount)
    {
        y = y - amount;
    }

    public void moveDown(int amount)
    {
        y = y + amount;
    }

    public void moveRight(int amount)
    {
        x = x + amount;
    }

    public void moveLeft(int amount)
    {
        x = x - amount;
    }

    public void moveForward()
    {
        x += 2 * sin(orientation);
        y += 2 * cos(orientation);
    }

    public void action(){}

}