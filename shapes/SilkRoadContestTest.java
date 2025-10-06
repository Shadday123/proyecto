
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SilkRoadContestTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SilkRoadContestTest
{   
    // Prueba: Caso básico con colocación de robot y tienda
    // Verifica que solve maneje correctamente operaciones básicas
    @Test
    public void testSolveCustomCase() {
        int[][] days = {
            {6},          // Número de días
            {1, 20},      // Día 1: robot en ubicación 20
            {2, 15, 15},  // Día 2: tienda en ubicación 15 con 15 tenges
            {2, 40, 50},  // Día 3: tienda en ubicación 40 con 50 tenges
            {1, 50},      // Día 4: robot en ubicación 50
            {2, 80, 20},  // Día 5: tienda en ubicación 80 con 20 tenges
            {2, 70, 30}   // Día 6: tienda en ubicación 70 con 30 tenges
        };

        int[] result = SilkRoadContest.solve(days);
        assertNotNull(result);
        assertEquals(6, result.length); // debería devolver ganancias de los 6 días
    
    }
    @Test
    public void testSolveEmpty() {
        // Caso sin días
        int[][] days = {{0}};
        int[] result = SilkRoadContest.solve(days);
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    // Prueba: Entrada nula
    // Verifica que solve no falle con entrada nula y retorne arreglo vacío
    @Test
    public void testSolveNull() {
        // Caso nulo
        int[] result = SilkRoadContest.solve(null);
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    // Prueba: Múltiples tiendas en diferentes ubicaciones
    // Verifica el cálculo con barias tiendas 
    @Test
    public void testSimulateBasic() {
        // Prueba de simulación básica
        int[][] days = {
            {6},
            {1, 20},
            {2, 15, 15},
            {2, 40, 50},
            {1,50},
            {2, 80, 20},
            {2, 70,30}
        };
        
        // Ejecutar simulación en modo rápido
        SilkRoadContest.simulate(days, false);
        // No hay assertions porque es principalmente visual
    }
    
    
    
    @Test
    public void testSolveFullCase() {
        int[][] days = {
            {6},
            {1, 20},
            {2, 15, 15},
            {2, 40, 50},
            {1, 50},
            {2, 80, 20},
            {2, 70, 30}
        };

        int[] expected = {0, 10, 35, 50, 50, 60};
        int[] result = SilkRoadContest.solve(days);
        assertEquals(expected.length, result.length);
        assertEquals(expected, result);
    
    }
}
    
    

