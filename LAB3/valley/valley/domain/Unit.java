package domain;
import java.awt.Color;


/*No olviden adicionar la documentacion*/
public interface Unit{
  public static final int SQUARE = 2;
  public static final int ROUND = 1;
    
   
  public void act();
  
  public default int shape(){
      return SQUARE;
  }
  
  public default Color getColor(){
      return Color.black;}
  
  public default boolean isResource(){
      return true;
  }
  
  public default boolean isAnimal(){
      return false;
  }    
}
