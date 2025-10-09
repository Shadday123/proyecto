
package domain;
import java.awt.Color;

public class Wolf extends Mammal{
    
    public Wolf(Valley valley,int row, int column){
        super(valley,row, column);
        color=Color.black;
    }
    
    public int getShape(){
        return Unit.ROUND;
    }
    
    public void act(){
        if (getEnergy()==0){
            die();
        }else{
           if (! move(row+ (int)(Math.random() * 3) - 1,column+ (int)(Math.random() * 3) - 1)){
              move(row+ (int)(Math.random() * 3) - 1,column+ (int)(Math.random() * 3) - 1); 
           }    
        }
    }
}
