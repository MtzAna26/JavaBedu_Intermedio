package Reto1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimulacionMisionEspacial{
    public static void main(String[]args){
        System.out.println("Simulación de mision espacial inicial...\n");
        ExecutorService executor = Executors.newFixedThreadPool(4);
        // Enviar tareas
        Future<String> nav = executor.submit(new SistemaNavegacion());
        Future<String> soporte = executor.submit(new SistemaSoporteVital());
        Future<String> termico = executor.submit(new SistemaControlTermico());
        Future<String> comunicaciones = executor.submit(new SistemaComunicaciones());
        try{
            // Para obtener los resultados
            System.out.println(comunicaciones.get());
            System.out.println(soporte.get());
            System.out.println(termico.get());
            System.out.println(nav.get());
            System.out.println("\n Todos los sistemas reportan estado operativo.");
        } catch (InterruptedException | ExecutionException e){
            System.out.println("Error durante la simulacion: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}