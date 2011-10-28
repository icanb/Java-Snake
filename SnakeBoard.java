import javax.swing.*;
import java.awt.*;
import java.util.*;



public class SnakeBoard
{

public SnakeBoard()
{//creates a board that is 2 cell bigger than the actual one, so that it can be manipulated without any problem.
  length=3;
  Y = new int[3];
  X = new int[3];
  X[0]=3;
  Y[0]=4;
  X[1]=4;
  Y[1]=4;
  X[2]=5;
  Y[2]=4;
  direction="Right";

  createfeed();
  
}

public void createfeed()
{
  Random randomizer=new Random();
    
   feedx= randomizer.nextInt(30);
   feedy= randomizer.nextInt(30);
 
}




public void eat()
{
  length++;
   int[]Yalt= new int[length];
   int[]Xalt = new int[length];
   Yalt[0]=feedy;
   Xalt[0]=feedx;
   
   for(int i=1; i<length; i++)
   {
      Yalt[i]=Y[i-1];
      Xalt[i]=X[i-1];
   }
  
   Y = new int[length];
   X = new int[length];
   
    for(int i=0; i<length; i++)
   {
      X[i]=Xalt[i];
      Y[i]=Yalt[i];
   }
   
    createfeed();
      
}


public void Move()
{
  try
  {
    if(direction.equals("Left"))
  {
    if((X[0]-1)==feedx&&(Y[0])==feedy)
    {
      eat();
    }
    else
    {
      for(int i=length-1; i>0; i--)
      {
        X[i]=X[i-1];
        Y[i]=Y[i-1];
      }
      
      X[0]=X[0]-1;
    }
  }
  
  if(direction.equals("Right"))
  {
    if((X[0]+1)==feedx&&(Y[0])==feedy)
    {
      eat();
    }
    else
    {
      
      for(int i=length-1; i>0; i--)
      {
        X[i]=X[i-1];
        Y[i]=Y[i-1];
      }
      
      X[0]=X[0]+1;
    }
  }
  
  
  if(direction.equals("Down"))
  {if((X[0])==feedx&&(Y[0]+1)==feedy)
    {
    eat();
  }
  else
  {
    
    for(int i=length-1; i>0; i--)
    {
      X[i]=X[i-1];
      Y[i]=Y[i-1];
    }
    
    Y[0]=Y[0]+1;
  }
  }
  
  if(direction.equals("Up"))
  {if((X[0])==feedx&&(Y[0]-1)==feedy)
    {
    eat();
  }
  else
  {
    for(int i=length-1; i>0; i--)
    {
      X[i]=X[i-1];
      Y[i]=Y[i-1];
    }
    
    Y[0]=Y[0]-1;
  }
  }
  }
  catch(Exception e)
  {
   System.out.print("ABCDE"); 
  }
}


   

public void nextMovement(String directioninput)
{
  if((direction.equals("Up")||direction.equals("Down"))&&directioninput.equals("Left"))
    {
    direction="Left";
  }
  
   if((direction.equals("Up")||direction.equals("Down"))&&directioninput.equals("Right"))
    {direction="Right";
  }
     
     
   if((direction.equals("Right")||direction.equals("Left"))&&directioninput.equals("Down"))
   {direction="Down";
  }
   
   if((direction.equals("Right")||direction.equals("Left"))&&directioninput.equals("Up"))
   {
     direction="Up";
  }
          
}


  public int[]Y;
  public int[]X;
  public int length;
  private String direction;
  public int feedx;
  public int feedy;
}
