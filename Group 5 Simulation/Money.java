import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Money here.
 * 
 * @author (animation - Jennifer)
 * Credit: 
 *  Pinterest "16 Bit Video Game Images - Browse 9332 Stock Photos, Vectors, and Video"
 *  coinSound - zapsplat.com Retro 80s style game sound, coin collect, classic arcade
 */
public class Money extends Actor
{
    // Track index of the coin
    private int coinIndex = 0;
    
    // Make the animation slower / more precise
    private int counter = 0;
    
    // Speed of the coin
    private int speed = 2;
    private int animationSpeed;
    
    private GreenfootImage[] coins;
    
    private int timer = 120; // 2 secs
    
    //for stat bar
    private boolean isLeftTeam;
    
    private GreenfootSound[] coinSound;
    private int coinSoundIndex = 0;
    
    public Money(){
        coins = new GreenfootImage[7];
        for(int i = 0; i < coins.length; i++){
            coins[i] = new GreenfootImage("images/Coin/coin" + i + ".png");
            coins[i].scale(45, 45);
            if(i == 0 || i == 6){
                coins[i].scale(15, 45);
            }
        }
        setImage(coins[3]);
        
        coinSound = new GreenfootSound[10]; // 10 instances for multiple rapid plays
        for (int i = 0; i < coinSound.length; i++) {
            coinSound[i] = new GreenfootSound("coin.wav");
            coinSound[i].setVolume(65);
        }
    }
    
    public void act(){
        timer--;
        if(timer <= 0){
            giveCoins();
            getWorld().removeObject(this);
            
            coinSound[coinSoundIndex].play();
            coinSoundIndex++;
            if (coinSoundIndex >= coinSound.length) {
                coinSoundIndex = 0;
            }
        }else{
            counter++;
            animationSpeed = 25;
            if(counter % animationSpeed == 0){
                setImage(coins[coinIndex]);
                coinIndex = (coinIndex + 1) % coins.length;
            }
        }
    }
    
    //for stat bar
    public void setTeam(boolean isLeftTeam) {
        this.isLeftTeam = isLeftTeam;
    }
    
    private void giveCoins()
    {
        RestaurantWorld world = (RestaurantWorld)getWorld();
        boolean isLeftTeam = getX() < world.getWidth() / 2;
        world.addCoins(isLeftTeam, 1);
    }
}
