import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Small order icon shown above a seated customer.
 */
public class OrderIcon extends Actor
{
    public OrderIcon()
    {
        GreenfootImage orderImage = new GreenfootImage("Menu/order.png");
        orderImage.scale(150, 150);
        setImage(orderImage);
    }
}
