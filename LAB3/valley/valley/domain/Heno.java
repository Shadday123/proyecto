package domain;
import java.util.*;
import java.awt.Color;
/**
 * Write a description of class Heno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heno extends Resource

{
    public static ArrayList<Color> colors = new ArrayList<>();
    private static int index = 0;
    
    static {
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
    }
    
    /**
     * Constructor for objects of class Heno
     */
    public Heno(Valley valley, int row, int column)
    {
       super(valley, row, column);
       color = colors.get(index);
       index = (index +1) % colors.size();
    }
      
    public void act(){
        
    }
    
    
}