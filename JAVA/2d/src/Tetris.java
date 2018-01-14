/*
 * Tetris.java
 *
 * Copyright(c) 2002-2005, Particle Corp.
 *
 * Copying and distribution of this entire source code
 * is permitted in any medium, provided this copyright
 * notice is preserved.
 */

import java.applet.*;
import java.awt.*;

/**
 * simple tetris applet
 * (note: specifically made to be compatible with JDK 1.0)
 *
 * Note2: This applet works/looks best if applet size dimension
 * ratios are 10:20 (width:height). On a web page, this means
 * 200x400 is probably best.
 *
 * @author Alex S.
 * @version 0.0.2
 */
public class Tetris extends Applet implements Runnable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Thread thread;

    private int[][] screen;

    private Image doubleImage = null;
    private Graphics doubleGraphics = null;

    // piece fall speed (in milliseconds)
    private int speed;


    // pieces; each piece has 4 'dots', we store model coordinates
    // for those 'dots'. each piece also has 4 'orientations' (actually,
    // some pieces have less, but we're using all 4).
    private static final int[][][][] pieces = {
        {   // ####
            {{0,1},{0,0},{0,-1},{0,-2}},
            {{-1,0},{0,0},{1,0},{2,0}},
            {{0,1},{0,0},{0,-1},{0,-2}},
            {{-1,0},{0,0},{1,0},{2,0}}
        },
        {   // #
            // ##
            // #
            {{-1,0},{0,1},{1,0},{0,0}},
            {{0,1},{1,0},{0,-1},{0,0}},
            {{1,0},{0,-1},{-1,0},{0,0}},
            {{0,-1},{-1,0},{0,1},{0,0}}
        },
        {
            // ##
            // ##
            {{0,0},{0,-1},{1,0},{1,-1}},
            {{0,0},{0,-1},{1,0},{1,-1}},
            {{0,0},{0,-1},{1,0},{1,-1}},
            {{0,0},{0,-1},{1,0},{1,-1}}
        },
        {
            // ##
            //  ##
            {{-1,0},{0,0},{0,1},{1,1}},
            {{1,-1},{1,0},{0,0},{0,1}},
            {{-1,0},{0,0},{0,1},{1,1}},
            {{1,-1},{1,0},{0,0},{0,1}}
        },
        {
            //  ##
            // ##
            {{-1,1},{0,1},{0,0},{1,0}},
            {{0,-1},{0,0},{1,0},{1,1}},
            {{-1,1},{0,1},{0,0},{1,0}},
            {{0,-1},{0,0},{1,0},{1,1}}
        },
        {
            // #
            // ###
            {{-1,-1},{-1,0},{0,0},{1,0}},
            {{-1,1},{0,1},{0,0},{0,-1}},
            {{1,1},{1,0},{0,0},{-1,0}},
            {{1,-1},{0,-1},{0,0},{0,1}}
        },
        {
            //   #
            // ###
            {{-1,1},{-1,0},{0,0},{1,0}},
            {{-1,-1},{0,-1},{0,0},{0,1}},
            {{1,-1},{1,0},{0,0},{-1,0}},
            {{1,1},{0,1},{0,0},{0,-1}}
        }
    };

    // base color for piece
    private static final Color[] colors = {
        new Color(0xBD,0x00,0x00),
        new Color(0x73,0x71,0x73),
        new Color(0x00,0xBE,0xBD),
        new Color(0x00,0xBE,0x00),
        new Color(0x00,0x00,0xBD),
        new Color(0xBD,0x00,0xBD),
        new Color(0xBD,0xBE,0x00)
    };

    // highlight color for piece (upper left corner)
    private static final Color[] lcolors = {
        new Color(0xFF,0x00,0x00),
        new Color(0x9C,0x9A,0x9C),
        new Color(0x00,0xFF,0xFF),
        new Color(0x00,0xFF,0x00),
        new Color(0x00,0x00,0xFF),
        new Color(0xFF,0x00,0xFF),
        new Color(0xFF,0xFF,0x00)
    };

    // dark highlight color for piece (lower right corner)
    private static final Color[] dcolors = {
        new Color(0x84,0x00,0x00),
        new Color(0x4A,0x4D,0x4A),
        new Color(0x00,0x82,0x84),
        new Color(0x84,0x82,0x00),
        new Color(0x00,0x00,0x84),
        new Color(0x84,0x00,0x84),
        new Color(0x84,0x82,0x00)
    };

    // empty location
    private static final int EMPTY = pieces.length + 1;

    // current state of the game
    private int currentPiece;
    private int currentOrientation;
    private int currentX,currentY;

    // flag to indicate that the game is over.
    private boolean gameOver;

    /**
     * constructs a tetris object
     */
    public Tetris(){
        thread = null;
        screen = new int[20][10];
    }

    /**
     * does initialization
     */
    public void init(){
        startGame();

        // create double buffer (prevents flicker)
        doubleImage = createImage(size().width,size().height);
        doubleGraphics = doubleImage.getGraphics();
    }

    /**
     * picks next piece and orientation
     */
    public void pickPiece(){
        currentPiece = (int)(Math.random()*pieces.length);
        currentOrientation = (int)(Math.random()*pieces[currentPiece].length);
        currentX = 5;
        currentY = 2;
    }

    /**
     * repaints the screen
     */
    public void paint(Graphics g){

        int[] xs = new int[3];
        int[] ys = new int[3];

        int w = size().width,h = size().height;
        int s = h / screen.length;
        doubleGraphics.setColor(Color.black);
        doubleGraphics.fillRect(0,0,w,h);

        // paint score
        String score = "["+(1000-speed)+"]";

        doubleGraphics.setColor(Color.gray);
        doubleGraphics.setFont(new Font("Monospaced",Font.PLAIN,10));
        // score is 1000 - speed (since 'speed' decreases with every droping
        // piece, this provides an accurate picture of how quickly the
        // person can think/react to falling pieces.
        doubleGraphics.drawString(score,10,10);

        if(gameOver){

            // if game is over, display "game over" :-)

            doubleGraphics.setColor(Color.yellow);

            score = "Score: "+score;

            Font f = new Font("Monospaced",Font.BOLD,20);
            FontMetrics fm = getFontMetrics(f);
            int x = w/2 - fm.stringWidth(score) / 2;
            doubleGraphics.setFont(f);
            doubleGraphics.drawString(score,x,h/2-30);

            String gameOver = "GAME OVER";
            f = new Font("Monospaced",Font.BOLD,30);
            fm = getFontMetrics(f);
            x = w/2 - fm.stringWidth(gameOver) / 2;
            doubleGraphics.setFont(f);
            doubleGraphics.drawString(gameOver,x,h/2);

            String clickToPlayAgain = "(Click To Play Again)";
            f = new Font("Monospaced",Font.BOLD,12);
            fm = getFontMetrics(f);
            x = w/2 - fm.stringWidth(clickToPlayAgain) / 2;
            doubleGraphics.setFont(f);
            doubleGraphics.drawString(clickToPlayAgain,x,h/2+30);

            doubleGraphics.setColor(Color.lightGray);

            String copyright = "(c) 2002-2005, Particle";
            f = new Font("Monospaced",Font.PLAIN,12);
            fm = getFontMetrics(f);
            x = w/2 - fm.stringWidth(copyright) / 2;
            doubleGraphics.setFont(f);
            doubleGraphics.drawString(copyright,x,h/2+50);

        }else{

            // draw the pieces

            doubleGraphics.setColor(Color.darkGray);
            doubleGraphics.drawLine(0,4*s,w,4*s);

            for (int i=0;i<screen.length;i++)
                for (int j=0;j<screen[i].length;j++) {
                    if (screen[i][j] != EMPTY) {

                        doubleGraphics.setColor(lcolors[screen[i][j]]);
                        doubleGraphics.fillRect(j*s,i*s,s,s);

                        doubleGraphics.setColor(dcolors[screen[i][j]]);
                        xs[0] = j*s;    ys[0] = i*s + s;
                        xs[1] = j*s+s;  ys[1] = i*s;
                        xs[2] = j*s+s;  ys[2] = i*s + s;
                        doubleGraphics.fillPolygon(xs,ys,3);

                        doubleGraphics.setColor(colors[screen[i][j]]);
                        doubleGraphics.fillRect(j*s+3,i*s+3,s-6,s-6);

                        doubleGraphics.setColor(Color.black);
                        doubleGraphics.drawRect(j*s,i*s,s,s);
                    }
                }
        }
        // blit double buffer to frame buffer
        g.drawImage(doubleImage,0,0,null);
    }

    /**
     * updat4; just draw
     */
    public void update(Graphics g){
        paint(g);
    }

    /**
     * start a thread
     */
    public void start(){
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * allow GC to clean up thread
     */
    public void stop(){
        thread = null;
    }

    /**
     * does a piece move; given a vector where to move it
     */
    private synchronized boolean doPieceMove(int nextOr,int x,int y){
        boolean retValue = true;
        int oldOrient = currentOrientation,oldX = currentX,oldY = currentY;
        setPiece(EMPTY);
        if(nextOr > 0){
            currentOrientation = (currentOrientation + 1) % pieces[currentPiece].length;
        }else if(nextOr < 0){
            currentOrientation = (currentOrientation - 1 + pieces[currentPiece].length) % pieces[currentPiece].length;
        }
        currentX += x;
        currentY += y;
        if(collisions()){
            currentOrientation = oldOrient;
            currentX = oldX;
            currentY = oldY;
            retValue = false;
        }
        setPiece(currentPiece);
        return retValue;
    }


    /**
     * end the game
     */
    private void endGame(){
        gameOver = true;
        for (int i=0;i<screen.length;i++)
            for (int j=0;j<screen[i].length;j++)
                screen[i][j] = EMPTY;
    }

    /**
     * start/restart the game
     */
    private void startGame(){
        speed = 1000;
        for (int i=0;i<screen.length;i++)
            for (int j=0;j<screen[i].length;j++)
                screen[i][j] = EMPTY;
        pickPiece();
        gameOver = false;
    }

    /**
     * clear pieces that fill a row
     */
    private void clearPieces(){
        int i,j,k;

        // drop speed by 5 milliseconds (until people fail :-)
        speed -= 5;
        if(speed < 10)
            speed = 10;

        for (i=0;i<screen.length;i++){
            for (j=0;j<screen[i].length;j++){
                if(screen[i][j] == EMPTY)
                    break;
            }
            if(j == screen[i].length){
                for(k=i;k>0;k--)
                    for(j=0;j<screen[k].length;j++){
                        screen[k][j] = screen[k-1][j];
                        screen[k-1][j] = EMPTY;
                    }
                i--;
            }
        }
    }

    /**
     * our thread run method
     */
    public void run(){
        for (;;) {
            if(!gameOver){
                if(!doPieceMove(0,0,1)){
                    clearPieces();
                    pickPiece();
                    if(collisions())
                        endGame();
                    else
                        setPiece(currentPiece);
                }
                repaint();
            }
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {

            }
        }
    }

    /**
     * test for colisions of current piece
     */
    private boolean collisions(){
        int[][] points = pieces[currentPiece][currentOrientation];
        for(int i=0;i<points.length;i++){
            // get 'model' points
            int mx = points[i][0] + currentX;
            int my = points[i][1] + currentY;

            if(mx < 0 || mx >= 10)
                return true;
            if(my < 0 || my >= 20)
                return true;
            if(screen[my][mx] != EMPTY)
                return true;
        }
        return false;
    }

    /**
     * set piece
     */
    private void setPiece(int value){
        int[][] points = pieces[currentPiece][currentOrientation];
        for(int i=0;i<points.length;i++)
            screen[points[i][1] + currentY][points[i][0] + currentX] = value;
    }

    /**
     * a key handler; let users use many keys to play
     */
    public boolean keyDown(Event evt,int key){
        if(gameOver)
            return false;
        if (key == Event.UP || key == 'i' || key == 'I' || key == 'w' || key == 'W') {
            doPieceMove(1,0,0);
        } else if (key == 'e' || key == 'E' || key == 'O' || key == 'o'){
            doPieceMove(-1,0,0);
        } else if (key == Event.DOWN || key == 'k' || key == 'K' || key == 's' || key == 'S') {
            doPieceMove(0,0,1);
        } else if (key == Event.LEFT || key == 'j' || key == 'J' || key == 'a' || key == 'A') {
            doPieceMove(0,-1,0);
        } else if (key == Event.RIGHT || key == 'l' || key == 'L' || key == 'd' || key == 'D') {
            doPieceMove(0,1,0);
        }
        repaint();
        return true;
    }

    /**
     * restart game when mouse is clicked (when game is over)
     */
    public boolean mouseUp(Event evt, int x, int y){
        if(gameOver){
            startGame();
            return true;
        }
        return false;
    }

}

