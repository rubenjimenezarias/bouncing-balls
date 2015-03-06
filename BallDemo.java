import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

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
        //COMPROBAMOS SI EL VALOR INTRODUCIDO ES MAYOR QUE 1 SINO PONEMOS UNA BOLA
        if(balls < 1)
        {
            balls = 1;
        }
        
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
    
        // crate and show the balls
        Color color;
        Random aleatorio = new Random();
        for (int i = 0; i < balls; i++)
        {
            color = new Color(aleatorio.nextInt(256),aleatorio.nextInt(256),aleatorio.nextInt(256));
            bolas.add(new BouncingBall(aleatorio.nextInt(300), aleatorio.nextInt(400), aleatorio.nextInt(40)+5, color, 400, myCanvas));
            bolas.get(i).draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BouncingBall elemento: bolas)
            {
                elemento.move();
                if(elemento.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
    /**
     * boxBounce
     * dibuja una bola dentro de un cuadrado y se mueve la bola
     */
    public void boxBounce()
    {
        myCanvas.drawLine(100,100,100,400);
        myCanvas.drawLine(500,100,500,400);
        myCanvas.drawLine(100,100,500,100);
        myCanvas.drawLine(100,400,500,400);
    }
}
