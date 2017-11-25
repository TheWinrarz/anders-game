package game.Entities;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by Daniel on 11/14/2017.
 */
public class Entity
{

    private static EntityManager manager = EntityManager.getEntityManager();


    int x;
    int y;
    int width;
    int height;
    double orientation;



    public Entity(int _x, int _y, int _width, int _height)
    {
        manager.add(this);

        this.width = _width;
        this.height = _height;

        this.x = _x;
        this.y = _y;

        this.orientation = 0.00;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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

    public void turn(double amount) { orientation = orientation + amount; }

    public void setOrientation(double o) { orientation = o; }

    public void moveForward(int amount)
    {
        x += amount * sin(orientation);
        y += amount * cos(orientation);
    }

    public void action(){}

}