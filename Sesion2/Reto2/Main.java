package Reto2;

//import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[]args){
        System.out.println("Iniciando simulación de acceso al recurso...");
        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugia");
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(new Profesional("Dra. Sanchez", salaCirugia));
        executor.submit(new Profesional("Dr. Gomez", salaCirugia));
        executor.submit(new Profesional("Enfermero López", salaCirugia));
        executor.submit(new Profesional("Dra. Ruiz", salaCirugia));
        executor.shutdown();
    }
}
