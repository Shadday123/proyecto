
package test;

import domain.Valley;
import domain.Sheep;
import domain.Wolf;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SheepTest {

    private Valley valley;

    @BeforeEach
    public void setUp() {
        valley = new Valley();
    }

    @Test
    public void testSheepLosesEnergyAndMovesNorth() {
        // Crear oveja en el centro del valle
        Sheep sheep = new Sheep(valley, 10, 10);
        valley.setUnit(10, 10, sheep);
        int initialEnergy = sheep.getEnergy();

        // Simular un paso (act)
        sheep.act();

        // La oveja debe haber perdido 1 de energía
        assertEquals(initialEnergy - 1, sheep.getEnergy(),
                "La oveja debe perder 1 punto de energía por movimiento");
        
        
        assertEquals(sheep, valley.getUnit(9, 10),
                "La oveja debe moverse una posición hacia el norte");
        
        
    }
    
    
    @Test 
    public void testSheepDies(){
        
        Sheep sheep = new Sheep(valley, 10, 10);
        valley.setUnit(10, 10, sheep);
        int initialEnergy = sheep.getEnergy();
        
        assertEquals(sheep.getEnergy(), 5, "La oveja debe tener 5 de energia");
        
        sheep.act();
        sheep.act();
        sheep.act();
        sheep.act();
        sheep.act();
        
        
        
        assertEquals(0, sheep.getEnergy(), "La oveja no tiene energía");
        
        assertEquals(valley.getUnit(5 ,10),null, "La oveja muere");
        // Debe haberse movido una fila hacia el norte (r - 1)
    }
    
    @Test
    public void testSheepDiesNearWolf() {
        // Crear oveja y lobo vecinos
        Sheep sheep = new Sheep(valley, 10, 10);
        Wolf wolf = new Wolf(valley, 9, 10);

        valley.setUnit(10, 10, sheep);
        valley.setUnit(9, 10, wolf);
        assertEquals(valley.hasTypeUnit(10,10), "wolf", "El lobo se detecta como vecino");

        // Simular el paso
        sheep.act();

        // La oveja debería morir (ser removida del valle)
        assertTrue(valley.isEmpty(8, 10),
                "La oveja debe morir si queda vecina a un lobo");
    }
}


