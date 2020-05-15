import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
/**
 *
 */
public class SpaceInvaders extends JFrame implements Runnable {
    

   JFrame window;
   Container con;
   JPanel titleNamePanel, startButtonPanel, helpButtonPanel, namePanel, helpPanel, controlPanel, backButtonPanel;
   JLabel titleNameLabel, nameLabel, helpLabel, controlLabel;
   Font titleFont = new Font("Superstar", Font.BOLD, 65);
   Font buttonFont = new Font("Superstar", Font.PLAIN, 40);
   Font nameFont = new Font("Superstar", Font.PLAIN, 20);
   Font helpFont = new Font("Superstar", Font.BOLD, 55);
   JButton startButton, helpButton, backButton;
   JTextArea mainTextArea;
   
   TitleScreenHandler tsHandler = new TitleScreenHandler();
   TitleScreenHandler2 tsHandler2 = new TitleScreenHandler2();
   TitleScreenHandler3 tsHandler3 = new TitleScreenHandler3();
   
   public static void main(String[] args) {
   
      new SpaceInvaders();
      
   }


   public SpaceInvaders() {
      
      window = new JFrame();
      window.setSize(800, 600);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.getContentPane().setBackground(Color.black);
      window.setLayout(null);
      window.setVisible(true);
      con = window.getContentPane();

      
      titleNamePanel = new JPanel();
      titleNamePanel.setBounds(100, 100, 600, 100);
      titleNamePanel.setBackground(Color.black);
      titleNameLabel = new JLabel("SPACE INVADERS");
      titleNameLabel.setForeground(Color.green);
      titleNameLabel.setFont(titleFont);
      namePanel = new JPanel();
      namePanel.setBounds(150, 200, 500, 50);
      namePanel.setBackground(Color.black);
      nameLabel = new JLabel("Created by Ethan Zhang, Benoy Sen, and Jordan Lee");
      nameLabel.setForeground(Color.green);
      nameLabel.setFont(nameFont);
      startButtonPanel = new JPanel();
      startButtonPanel.setBounds(325, 275, 150, 75);
      startButtonPanel.setBackground(Color.black);
      startButton = new JButton("START");
      startButton.setBackground(Color.black);
      startButton.setForeground(Color.green);
      startButton.setFont(buttonFont);
      startButton.addActionListener(tsHandler);
      helpButtonPanel = new JPanel();
      helpButtonPanel.setBounds(325, 350, 150, 75);
      helpButtonPanel.setBackground(Color.black);
      helpButton = new JButton("HELP");
      helpButton.setBackground(Color.black);
      helpButton.setForeground(Color.green);
      helpButton.setFont(buttonFont);
      helpButton.addActionListener(tsHandler2);
      
      titleNamePanel.add(titleNameLabel);
      startButtonPanel.add(startButton);
      helpButtonPanel.add(helpButton);
      namePanel.add(nameLabel);
      con.add(titleNamePanel);
      con.add(startButtonPanel);
      con.add(helpButtonPanel);
      con.add(namePanel);
     }
   
   
   public void createHelpScreen() {
      
      titleNamePanel.setVisible(false);
      startButtonPanel.setVisible(false);
      namePanel.setVisible(false);
      helpButtonPanel.setVisible(false);
      
      helpPanel = new JPanel();
      helpPanel.setBounds(100, 100, 600, 100);
      helpPanel.setBackground(Color.black);
      helpLabel = new JLabel("HOW TO PLAY");
      helpLabel.setForeground(Color.green);
      helpLabel.setFont(helpFont);
      controlPanel = new JPanel();
      controlPanel.setBounds(50, 300, 700, 100);
      controlPanel.setBackground(Color.black);
      controlLabel = new JLabel("use mouse to move left and right and use left mouse button to shoot");
      controlLabel.setForeground(Color.green);
      controlLabel.setFont(nameFont);
      backButtonPanel = new JPanel();
      backButtonPanel.setBounds(325, 350, 150, 75);
      backButtonPanel.setBackground(Color.black);
      backButton = new JButton("BACK");
      backButton.setBackground(Color.black);
      backButton.setForeground(Color.green);
      backButton.setFont(buttonFont);
      backButton.addActionListener(tsHandler3);
      
      
      helpPanel.add(helpLabel);
      controlPanel.add(controlLabel);
      backButtonPanel.add(backButton);
      con.add(helpPanel);
      con.add(controlPanel);
      con.add(backButtonPanel);
   }    
      
      
   
   
   public class TitleScreenHandler implements ActionListener {
      public void actionPerformed(ActionEvent event){
         SpaceInvaders invaders = new SpaceInvaders("Space Invaders");
         window.setVisible(false);

   }
   }
   public class TitleScreenHandler2 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         createHelpScreen();
      }   
   }
   public class TitleScreenHandler3 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         titleNamePanel.setVisible(true);
         startButtonPanel.setVisible(true);
         namePanel.setVisible(true);
         helpButtonPanel.setVisible(true);
         helpPanel.setVisible(false);
         controlPanel.setVisible(false);
         backButtonPanel.setVisible(false);
      
         }
   }
  public static int WIDTH = 700;//The width of the frame
  public static int HEIGHT = 750;//The height of the frame


  private int gameSpeed = 100000000;//the lower the faster
   

    AlienArmy army = null;

    Ship ship = null;

    private boolean paused = false;

    private int score = 0;

    Graphics offscreen_high;
     BufferedImage offscreen;

    Image backGroundImage = null;
     Image alienImage = null; 


    /**
      * This is called a constructor. 
      */
     public SpaceInvaders(String frameTitle) {
         super(frameTitle);

// Exit the program if the window is closed
		 this.addWindowListener (new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
      
		System.exit(0);
	}});
    

		 

        backGroundImage = new javax.swing.ImageIcon("back3.jpg").getImage();

        Image alienImage = new javax.swing.ImageIcon("alien10.png").getImage();
        Image alienImage2 = new javax.swing.ImageIcon ("alien20.png").getImage();
        Image alienImage3 = new javax.swing.ImageIcon ("alien30.png").getImage();
        
        Image shipImage = new javax.swing.ImageIcon("ship.png").getImage();

        //Create the ship to fight off the invading army!
         ship = new Ship(this, shipImage);

        //Create the alien army
         army = new AlienArmy(ship, this, alienImage, alienImage2, alienImage3);

        //The ship will be controlled by the mouse
         addMouseListener(ship);
         //We also want mouse movement not just mouse clicks
         addMouseMotionListener(ship);

        offscreen = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
         offscreen_high = offscreen.createGraphics();

        setBackground(Color.black);
         setSize(WIDTH, HEIGHT);
         setVisible(true);
         startGame();
     }

    /**
      * As you move your mouse on and off the screen we want to pause
      * the game.
      */
     public void pauseGame(boolean state) {
        paused = state;
     }

    /**
      * Kill an alien and get 5 points!
      */
     public void hitAlienScore() { 
         //Add 5 to the score
        score += 5;
         System.out.println("Current Score = "+score);
     }

    /**
      * Get shot and loose 20 points!
      */
     public void shotShip() {
        score -= 20;
         System.out.println("Current Score = "+score);
     }

    /**
      *
      */
     public void startGame() {
        //These two lines may look confusing but basically they start the 
         //game process, i.e. update the display screen every 100ms.
        Thread thread = new Thread(this);
         thread.start();
     }

    /**
      *
      */
     public void paint(Graphics g) {
         offscreen_high.setColor(Color.black);
         offscreen_high.fillRect(0,0, WIDTH, HEIGHT);
         //offscreen_high.drawImage(backGroundImage, 0, 0, this);  //makes the background of game a picture
         army.drawArmy(offscreen_high);

        ship.drawShip(offscreen_high);

        g.drawImage(offscreen,0,0,this); 
     }

    public void update(Graphics g) {
         paint(g);
     } 

    /**
      *
      */
     public void moveAliens() {
         army.moveArmy();
     }

    /**
      *
      */
     public void run() {
         int count = 0;
         
         
         while(true) {
             try {
                 TimeUnit.NANOSECONDS.sleep(gameSpeed);
                 gameSpeed = gameSpeed-75000;
                 if (gameSpeed <= 15000000) {
                     gameSpeed = 15000000;
                 }


             } catch(InterruptedException ie) {
                //Ignore this exception
                
             }
            //If the game is currently running, move the aliens
             if (!paused) {
                 if (count >= 5) {
                     moveAliens();
                     count = 0;
                 }
             }
             repaint();//Update the screen
             count ++;

        }
     }

    /**
      * Get a reference to the alien army
      */
     public AlienArmy getAlienArmy() {
         return army;
     }

}