package Reto1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

    // Simula el cálculo de la ruta
    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int delay = ThreadLocalRandom.current().nextInt(2000, 3000); // 2-3 segundos
                TimeUnit.MILLISECONDS.sleep(delay);
                return "Centro -> Norte";
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular ruta");
            }
        });
    }

    // Simula la estimación de la tarifa
    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                int delay = ThreadLocalRandom.current().nextInt(1000, 2000); // 1-2 segundos
                TimeUnit.MILLISECONDS.sleep(delay);
                
                // Simula error aleatorio (opcional)
                if (ThreadLocalRandom.current().nextBoolean()) {
                    throw new RuntimeException("Error al estimar tarifa");
                }
                
                return 75.50;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error durante la estimación");
            }
        });
    }

    // Combina ambas tareas y muestra el resultado
    public void procesarSolicitud() {
        System.out.println("🚕 Procesando solicitud de viaje...\n");

        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) -> {
            return "🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa;
        })
        .exceptionally(ex -> {
            return "❌ Ocurrió un error en el procesamiento: " + ex.getMessage();
        })
        .thenAccept(System.out::println); // Mostrar resultado final
    }

    public static void main(String[] args) throws InterruptedException {
        MovilidadApp app = new MovilidadApp();
        app.procesarSolicitud();

        // Esperar para que las tareas asíncronas terminen antes de cerrar el programa
        Thread.sleep(4000);
    }
}
