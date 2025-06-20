package Reto1;
import java.util.*;
import java.util.stream.*;

public class ProcesadorPedidos {
    public static void main(String[] args) {
       List<Pedido> pedidos = Arrays.asList(
            new Pedido("Ani", "domicilio", "555-1234"),
            new Pedido("Luis", "local", null),
            new Pedido("Maya", "domicilio", "555-5678"),
            new Pedido("Tania", "domicilio", null)
        );
        System.out.println("Procesando pedidos...\n");
        pedidos.stream()
        .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
        .map(Pedido::getTelefono)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .map(tel -> "Confirmación enviada al número: " + tel)
        .forEach(System.out::println);
    }
}
