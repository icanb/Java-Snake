import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Integer;



public class FrameCreator extends JFrame
{
 public int size;
 private SnakePainter firstgame;
 private double timer=150;
 private Timer t;
  
   public FrameCreator(int s)
   {
     
     final SnakeBoard board= new SnakeBoard();
     JButton nextBut = new JButton("Next Generation!");
    
     
     //draws the board
     firstgame=new SnakePainter(board);
     
     //creates the frame and makes the layout
     final JFrame frame = new JFrame();
     final JPanel panel1 = new JPanel();
     final JPanel panel2 = new JPanel();
     final JPanel panelall = new JPanel();
     final JLabel point=new JLabel();
      
     //adjusts the size of the board according to the size of the game
     frame.setSize(30*20+10,(30*20)+40);
     frame.setTitle("The Mighty Game of SNAKE!");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     point.setText(String.valueOf(firstgame.getPoint()));
     //makes the layout
     panel1.setLayout(new BorderLayout());
     panel1.add(point);
    // panel2.setLayout(new GridLayout(1,1));
     panelall.setLayout(new BorderLayout());
    
     panel2.add(firstgame, BorderLayout.CENTER);
    
     panelall.add(panel1, BorderLayout.NORTH);
     panelall.add(firstgame, BorderLayout.CENTER);
    
     frame.add(panelall);
     frame.setResizable(false);
     frame.setVisible(true);
     
   
     
    
     
     //the commends that will be implied when the button is pressed
       
    
    
  
  
       
     
   
  class TimerListener implements ActionListener
      {
      public void actionPerformed(ActionEvent event)
      {
        firstgame.moveconstant();
         point.setText(String.valueOf(firstgame.getPoint()));
         t.setDelay((int)timer-(firstgame.getPoint()-3)*10);
        
      }
    }

  ActionListener listener6 = new TimerListener();
   
   t = new Timer((int)timer, listener6);    
    
     KeyboardFocusManager manager;
      
      manager = KeyboardFocusManager.
                getCurrentKeyboardFocusManager();
      
        manager.addKeyEventPostProcessor(
                            new PostProcessor());
  
  t.start();
  }



     class PostProcessor
                implements KeyEventPostProcessor{

  public boolean postProcessKeyEvent(KeyEvent e){
    
    if(e.getKeyChar()=='8'||e.getKeyChar()=='w')
        firstgame.nexMove("Up");
    if(e.getKeyChar()=='6'||e.getKeyChar()=='d')
        firstgame.nexMove("Right");
    if(e.getKeyChar()=='4'||e.getKeyChar()=='a')
        firstgame.nexMove("Left");
    if(e.getKeyChar()=='5'||e.getKeyChar()=='s')
        firstgame.nexMove("Down");

    return true;
  }//end postProcessKeyEvent
//---------------------------------------------//

String getEventType(int ID){
  if(ID == KeyEvent.KEY_PRESSED){
    return "keyPressed";
  }else if(ID == KeyEvent.KEY_RELEASED){
    return "keyReleased";
  }else if(ID == KeyEvent.KEY_TYPED){
    return "keyTyped";
  }else{
    return "Unknown event type";
  }
    
}
     
    
   }




  

   
    private String direction;

}
