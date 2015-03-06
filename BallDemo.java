import java.awt.Color;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> bolas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        bolas = new ArrayList<>();
        loadBalls();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    /**
     * Simulate x bouncing balls
     * @param int balls indica cuantas bolas quieres que aparezcan.
     */
    public void bounceXBalls(int balls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
    
        // crate and show the balls
        int cont = 0;
        while(cont < balls)
        {
            bolas.get(cont).draw();
            cont++;
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            cont = 0;
            while(cont < balls)
            {
                bolas.get(cont).move();
                cont++;
            }
            // stop once ball has travelled a certain distance on x axis
            cont = 0;
            while(cont < balls)
            {    
                if(bolas.get(cont).getXPosition() >= 550) {
                    finished = true;
                }
                cont++;
            }
        }
    }
    
    private void loadBalls()
    {
        bolas.add(new BouncingBall(50, 50, 16, Color.BLUE, 400, myCanvas));
        bolas.add(new BouncingBall(70, 80, 20, Color.RED, 400, myCanvas));        
        bolas.add(new BouncingBall(80, 70, 5, Color.YELLOW, 400, myCanvas));
        bolas.add(new BouncingBall(40, 60, 25, Color.ORANGE, 400, myCanvas));
        bolas.add(new BouncingBall(45, 21, 19, Color.GREEN, 400, myCanvas));
        bolas.add(new BouncingBall(62, 65, 20, Color.BLACK, 400, myCanvas));
        bolas.add(new BouncingBall(52, 31, 15, Color.RED, 400, myCanvas));
        bolas.add(new BouncingBall(32, 59, 3, Color.GREEN, 400, myCanvas));
        bolas.add(new BouncingBall(26, 55, 32, Color.YELLOW, 400, myCanvas));
        bolas.add(new BouncingBall(38, 40, 22, Color.BLUE, 400, myCanvas));
        
    }
}
