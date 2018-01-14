/*
 * pTicTacToe.java
 *
 * Copyright(c) 2001, Particle Corp.
 */

/*
 * NOTE: This program intentionally uses only JDK 1.0 libs,
 * in order to be compatible with all java enabled browsers.
 * (yes, even Netscape3!)
 */

import java.lang.Thread;
import java.applet.Applet;
import java.awt.*;
import java.util.Vector;

/**
 * the main game class. represents the board, has
 * alpha-beta proc, etc.
 *
 * @version 0.0.1
 * @author Alex S.
 */
class pTicTacToeBoard {

    // some useful statics
    public static final int EMPTY = 0;
    public static final int X = 1;
    public static final int O = 2;
    public static final int DRAW = 3;

    // helper for toString method
    public static char[] to_string = {'#','X','O'};

    // board
    private int[][] board;

    private int best_i;
    private int best_j;

    /*
     * each winning line gets a bit
     */
    private static int[][] board_mask = {
        {1|8|64,2|8,4|8|128},
        {1|16,2|16|64|128,4|16},
        {1|32|128,2|32,4|32|64},
    };

    /*
     * each winning line gets an unset bit, all else
     * is set. (makes for easier masking later on)
     */
    static {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                board_mask[i][j] = ~board_mask[i][j];
    }

    /**
     * default constructor; allocate mem, and
     * init the board to empty
     */
    public pTicTacToeBoard(){
        board = new int[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                board[i][j] = EMPTY;
    }

    /**
     * copy constructor; allocate mem, and
     * init the board to the passed board.
     */
    public pTicTacToeBoard(pTicTacToeBoard b){
        board = new int[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                board[i][j] = b.board[i][j];
    }

    /**
     * get number of winning lines for a specific player
     *
     * @param l Either pTicTacToeBoard.X or pTicTacToeBoard.O
     * @return number of possible winning lines for l
     */
    public int getWinLinesForPlayer(int l){
        int masked = 0xFF;
        int otherplayer = l == X ? O:X;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i][j] == otherplayer)
                    masked &= board_mask[i][j]; //mask out win lines
        int c=0;
        for(int i=1;i<0x100;i<<=1)  //count win lines left
            if((masked & i) != 0)
                c++;
        return c;
    }

    /**
     * evaluate board to a specific player
     * (this is just a diff of player's open win lines)
     */
    public int getBoardEval(int l){
        return getWinLinesForPlayer(l) -
            getWinLinesForPlayer(l == X ? O:X);
    }

    /**
     * set value at a specific board location
     */
    public void setValOnBoard(int row,int col,int val){
        board[row][col] = val;
    }

    /**
     * get value at a specific board location.
     */
    public int getValOnBoard(int row,int col){
        return board[row][col];
    }

    // enable quicker end-game check
    private static int[][][] wingamechecks = {
        { {0,0},{0,1},{0,2} },
        { {0,0},{1,0},{2,0} },
        { {0,0},{1,1},{2,2} },
        { {0,1},{1,1},{2,1} },
        { {0,2},{1,2},{2,2} },
        { {1,0},{1,1},{1,2} },
        { {2,0},{2,1},{2,2} },
        { {2,0},{1,1},{0,2} }
    };


    /**
     * see if game is over. returns 0 if not, else returns
     * winner, or DRAW if game ended in draw.
     */
    public int getGameWinner(){
        // check for actual winner
        for(int i=0;i<8;i++){
            int a = board[wingamechecks[i][0][0]][wingamechecks[i][0][1]];
            int b = board[wingamechecks[i][1][0]][wingamechecks[i][1][1]];
            int c = board[wingamechecks[i][2][0]][wingamechecks[i][2][1]];
            if(a != EMPTY && a == b && b == c){
                return a;
            }
        }
        // no winner, but maybe a draw
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i][j] == EMPTY)
                    return 0;
        // draw ... (no spaces left for a move)
        return DRAW;
    }

    /**
     * alpha beta procedure
     */
    public static int alphaBeta(int l,int ply,int alpha,int beta,pTicTacToeBoard board){
        int winner = board.getGameWinner();
        if(winner != 0){
            if(winner == DRAW)
                alpha = 0;
            else
                alpha = winner == l ? 100:-100;
//            System.out.println("winner spoted:"+winner+"; alpha:"+alpha+"; depth:"+ply);
        }else if(ply <= 0){
            alpha = board.getBoardEval(l);
        }else{
            board.best_i = -1;
            board.best_j = -1;

            // for all children
            L1: for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board.getValOnBoard(i,j) == EMPTY){
                        // make move, and recursively eval it
                        pTicTacToeBoard moveboard = new pTicTacToeBoard(board);
                        moveboard.setValOnBoard(i,j,l);
                        // our negated beta becomes the other guy's alpha, etc.
                        int val = alphaBeta(l == X ? O:X,ply-1,-beta,-alpha,moveboard);

                        // make sure that we always have a move...
                        if(board.best_i == -1){
                            board.best_i = i;
                            board.best_j = j;
                        }

                        // is this a better move?
                        if(val > alpha){
                            alpha = val;
                            board.best_i = i;
                            board.best_j = j;
                        }
                        if(alpha >= beta)
                            break L1;  // cutoff
                    }
                }
            }
        }
        return -alpha;
    }

    public int makeMove(int l,int skill){
        int val = alphaBeta(l,skill,-100,100,this);
//        System.out.println("val: "+val+" ("+best_i+","+best_j+")");
        setValOnBoard(best_i,best_j,l);
        return getGameWinner();
    }

    /**
     * return str representation of the board
     */
    public String toString(){
        StringBuffer s = new StringBuffer();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                s.append(to_string[board[i][j]]);
            s.append('\n');
        }
        return s.toString();
    }

}

/**
 * Applet helper class. doesn't have any real logic in it,
 * (leaving all the game stuff to the board class).
 * Provides UI for the game.
 *
 * <p>August 15th, 2001 - Fixed image download problem. Images
 * would not be donwloaded until they were being displayed. On
 * a slow connection, there was a noticable delay abetween the
 * time you clicked a mouse, and the time an image would appear.
 * Fix involved invoking a MediaTracker to download the images
 * in a seperate thread.
 *
 * @version 0.0.1
 * @author Alex S.
 */
public class pTicTacToe extends Applet implements Runnable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image imageX,imageO,imageXWins,imageOWins,imageXODraw;
    private pTicTacToeBoard board;

    // track loading of images
    private MediaTracker tracker;

    private Thread m_thread;

    private int skill = 9;

    public void init(){

        // initialize media tracker
        tracker = new MediaTracker(this);

        setBackground(Color.white);
        imageO = getImage(getCodeBase(), "pTicTacToe_O.gif");
        imageX = getImage(getCodeBase(), "pTicTacToe_X.gif");
        imageXWins = getImage(getCodeBase(),"pTicTacToe_XWins.gif");
        imageOWins = getImage(getCodeBase(),"pTicTacToe_OWins.gif");
        imageXODraw = getImage(getCodeBase(),"pTicTacToe_Draw.gif");

        // track image
        tracker.addImage(imageO,0);
        tracker.addImage(imageX,1);
        tracker.addImage(imageXWins,2);
        tracker.addImage(imageOWins,3);
        tracker.addImage(imageXODraw,4);

        board = new pTicTacToeBoard();

        try{
            skill = Integer.parseInt(getParameter("skill"));
        }catch(Throwable e){
            System.out.println(e.toString());
            skill = 9;
        }
    }

    /**
     * start image download thread
     */
    public void start(){
        m_thread = new Thread(this);
        m_thread.start();
    }

    public void stop(){
        m_thread = null;
    }

    /**
     * download all images while the player makes a move...
     */
    public void run(){
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        Dimension d = size();
        int xoff = d.width / 3;
        int yoff = d.height / 3;
        g.drawLine(xoff, 0, xoff, d.height);
        g.drawLine(2*xoff, 0, 2*xoff, d.height);
        g.drawLine(0, yoff, d.width, yoff);
        g.drawLine(0, 2*yoff, d.width, 2*yoff);
        for (int r = 0 ; r < 3 ; r++) {
            for (int c = 0 ; c < 3 ; c++) {
                int t = board.getValOnBoard(r,c);
                if (t == pTicTacToeBoard.O){
                    g.drawImage(imageO, c*xoff + 1, r*yoff + 1, this);
                } else if (t == pTicTacToeBoard.X) {
                    g.drawImage(imageX, c*xoff + 1, r*yoff + 1, this);
                }
            }
        }
        int winner = board.getGameWinner();
        if(winner != 0){
            if(winner == pTicTacToeBoard.DRAW){
                g.drawImage(imageXODraw,0,30, this);
            }else if(winner == pTicTacToeBoard.X){
                g.drawImage(imageXWins,0,30, this);
            }else if(winner == pTicTacToeBoard.O){
                g.drawImage(imageOWins,0,30, this);
            }
        }
    }


    public boolean mouseUp(Event evt, int x, int y) {
        // if there was a winner...
        if(board.getGameWinner() != 0){
            board = new pTicTacToeBoard();
            repaint();
        }else{
            Dimension d = size();
            // Figure out the row/column
            int c = (x * 3) / d.width;
            int r = (y * 3) / d.height;
            if(board.getValOnBoard (r,c) == pTicTacToeBoard.EMPTY){
                board.setValOnBoard (r,c,pTicTacToeBoard.X);
                repaint();
                int winner = board.getGameWinner();
                // if there was a winner...
                if(winner == 0){
                    board.makeMove(pTicTacToeBoard.O,skill);
                    repaint();
                }
            }
        }
        return true;
    }

}

