import java.util.*;

/**
 * Write a description of class SilkRoadContest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SilkRoadContest
{
    /**
     * Resuelve el problema de la maratón - calcula la máxima utilidad diaria
     * @param days matriz con información de cada día
     * @return array con la máxima utilidad para cada día
     */
    
    public static int[] solve(int[][] daysData) {
        
    if (daysData == null) {
        System.out.println("No se ingresó una matriz, o es nula");
        return new int[0];
    }

    int n = daysData[0][0]; // número de días

    // Crear instancia de SilkRoad
    SilkRoad road = new SilkRoad(daysData);

    // Procesar cada día
    road.processAllDays(daysData);

    return road.dailyProfits;
}

    
    
    /**
     * Simula la solución paso a paso
     * @param days matriz con información de cada día
     * @param slow determina la velocidad de simulación
     */
    public static void simulate(int[][] days, boolean slow){
         SilkRoad road = new SilkRoad(days);
        road.makeVisible();
        
        for (int i = 1; i < days[0][0] ;i++) {
            int type = days[i][0];
            int location = days[i][1];
            
            if (type == 1) {
                road.placeRobot(location);
                System.out.println("Día " + i + ": Se colocó un robot en " + location);
            } else if (type == 2 && days[i].length >= 3) {
                int tenges = days[i][2];
                road.placeStore(location, tenges);
                System.out.println("Día " + i + ": Se colocó una tienda en " + location + " con " + tenges + " tenges");
            }
            
            EstadoActual(road);
            
            if (slow) pausa(1000);
            
            // Reset diario
            road.resupplyStores();
            road.returnRobots();
        }
        
        System.out.println("Simulación finalizada. Ganancia total: " + road.profit());
        road.consultProfit();
        road.consultRobotProfits();
    }
        
    
    
    /**
     * Muestra el estado actual de la simulación
     * @param silkRoad la instancia de SilkRoad
     */
    
    private static void EstadoActual(SilkRoad silkRoad){
        System.out.println("Ganancia acumulada: " + silkRoad.profit());
        System.out.println("Tiendas: " + Arrays.deepToString(silkRoad.stores()));
        System.out.println("Robots: " + Arrays.deepToString(silkRoad.robots()));
        System.out.println("---------------------------");
    }
    
    
    
    /**
     * Pausa la simulación por un tiempo determinado
     * @param milisegundos tiempo de pausa en milisegundos
     */
    private static void pausa(int milisegundos){
    try {
        Thread.sleep(milisegundos);
    } catch (Exception e) {
        // ignorar
    }
    }
    
}
