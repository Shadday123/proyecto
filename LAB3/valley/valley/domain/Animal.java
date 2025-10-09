package domain;
import java.awt.Color;


public abstract class Animal{
    
    private int days;
    private int energy;

    /**Create a new animal
     * 
     */
    public Animal(){
        energy=100;
        days=0;
    }


    /**The animal makes one step
     * 
     */
    final boolean step(){
        boolean ok=false;
        if (energy>=1){
            energy-=1;
            ok=true;
        }
        return ok;
    }    
    
    protected void setEnergy(int energy){
        this.energy = energy;
    }
    
    /**The animal eats
     * 
     */
    protected void eat(){
        energy=100;
    }
    
     /**Returns the energy
    @return 
     */   
    public final int getEnergy(){
        return energy;
    }    

    /**It's an animal
     */
    public final boolean isAnimal(){
        return true;
    }  
}
