package domain;
import java.util.*;
import java.util.Random;

/*No olviden adicionar la documentacion*/
public class Valley{
    static private int SIZE=25;
    private Unit[][] places;
    
    public Valley() {
        places=new Unit[SIZE][SIZE];
        for (int r=0;r<SIZE;r++){
            for (int c=0;c<SIZE;c++){
                places[r][c]=null;
            }
        }
        someUnits();
    }

    public int  getSize(){
        return SIZE;
    }

    public Unit getUnit(int r,int c){
        return places[r][c];
    }

    public void setUnit(int r, int c, Unit e){
        places[r][c]=e;
    }

    public void someUnits(){   
        // Akela en (10,10)
        new Wolf(this, 10, 10);
        
        // Larka en (15,15)
        new Wolf(this, 15, 15);
        
        new Sheep(this, 1, 1);
        
        //Shaun en (15,14)
        new Sheep(this, 2,14);
        
        //Alarm en (0,0)
        new Heno(this, 0,0);
        
        //Alert en (0,24)
        new Heno(this, 0,24);
        
        // Wooly en (4, 2);
        new Sheep(this, 4,2);
        
    }
    
    
    public String hasTypeUnit(int r, int c) {
        if (inValley(r, c) && places[r][c] != null) {
            for (int dr = -1; dr < 2; dr++) {
                for (int dc = -1; dc < 2; dc++) {
                    if ((dr != 0 || dc != 0) && inValley(r + dr, c + dc)) {
                        Unit neighbor = getUnit(r+ dr, c + dc);
                        if (neighbor instanceof Wolf) {
                          return "wolf";
                        }
                        if (neighbor instanceof Sheep){
                          return "sheep";
                        }
                    }
                }
            }
        }
        return "null";
    }
    
    
    
    public int neighborsEquals(int r, int c){
        int num=0;
        if (inValley(r,c) && places[r][c]!=null){
            for(int dr=-1; dr<2;dr++){
                for (int dc=-1; dc<2;dc++){
                    if ((dr!=0 || dc!=0) && inValley(r+dr,c+dc) && 
                    (places[r+dr][c+dc]!=null) &&  (places[r][c].getClass()==places[r+dr][c+dc].getClass())) num++;
                }
            }
        }
        return num;
    }
   

    public boolean isEmpty(int r, int c){
        return (inValley(r,c) && places[r][c]==null);
    }    
        
    private boolean inValley(int r, int c){
        return ((0<=r) && (r<SIZE) && (0<=c) && (c<SIZE));
    }
    
   
    public void ticTac(){
        // Crear una lista temporal para evitar problemas de concurrencia
        ArrayList<Unit> units = new ArrayList<>();
        Random rand = new Random();
        int count = 0;
        // Primero recolectar todas las unidades existentes
        for (int r = 0; r < SIZE; r++){
            for (int c = 0; c < SIZE; c++){
                if (places[r][c] != null){
                    units.add(places[r][c]);
                }
            }
        }

        // Luego hacer que cada unidad actúe
        for (Unit unit : units){
                unit.act();
        }
        
        //Se genera el Heno en posiciones aleatorias
        while (count <= 1){
            int p = rand.nextInt(SIZE);
            int l = rand.nextInt(SIZE);
            
                if (places[p][l] == null){
                    new Heno(this, p,l);
                    count++;
                }
                else{
                    count = count-1;
                }
            
        }
    
        
        
                    
    }

}
