
package domain;
import java.awt.Color;

/**
 * Write a description of class Sheep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sheep extends Mammal{
    // instance variables - replace the example below with your own
    private boolean north = true;
    
    /**
     * Constructor for objects of class Sheep
     */
    public Sheep(Valley valley,int row, int column){
        super(valley,row, column);
        setEnergy(5);
        color=Color.gray;
    }

    public int getShape(){
        return Unit.SQUARE;
    }
    
    
    public void eat(){
        setEnergy(5);
    }
    
    public void act(){
        int sameTypeNeighbors= getValley().neighborsEquals(row, column);
        Valley valley = super.getValley();
        move(row, column);
        
        if (valley.hasTypeUnit(row, column) == "wolf"|| getEnergy() == 0){
            valley.setUnit(row, column,null);;
        }
        
        if (sameTypeNeighbors >= 1){
            setEnergy(getEnergy()+1);
        }
        
        }
    
        

        
   @Override
public boolean move(int r, int c) {
    boolean ok = false;
    Valley valley = super.getValley();

    // Si norte es true, intentamos mover hacia arriba
    if (north) {
        if (valley.isEmpty(row - 1, column)) {
            if (super.move(row -1, column)){
                ok = true;
            }
        }   else {
                super.move(row +1, column);
                eat();      // recuperar energía al tope norte
                north = false; // cambia dirección hacia el sur
        }
    } 
    // Si norte es false, intentamos mover hacia abajo
    else {
        if (valley.isEmpty(row + 1, column)) {
            if (super.move(row +1, column)){
            ok = true;
        }
        }   else {
                super.move(row -1, column);
                north = true; // cambia dirección hacia el norte si no puede bajar
        }
    }

    return ok;
}
    }   

        
        
    
    

