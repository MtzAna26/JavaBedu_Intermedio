package Reto2;

import java.util.List;

public class ProcesadorEncuestas {
    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
            new Sucursal("Centro", List.of(
                new Encuesta("Ana Maria", "El tiempo de espera fue largo", 2),
                new Encuesta("Luis", null, 5)
            )),
            new Sucursal("Norte", List.of(
                new Encuesta("Marta", "La atención fue buena, pero la limpieza puede mejorar", 3),
                new Encuesta("Pedro", null, 5)
            )),
            new Sucursal("Sur", List.of(
                new Encuesta("Carlos", null, 2),
                new Encuesta("Sofia", "No encontré el medicamento que necesitaba", 1)
            ))
        );

        System.out.println("Seguimiento a pacientes insatisfechos: ");
        sucursales.stream()
            .flatMap(sucursal ->
                sucursal.gEncuestas().stream()
                    .filter(e -> e.getCalificacion() <= 3)
                    .map(encuesta -> new Seguimiento(encuesta, sucursal.getNombre()))
            )
            .filter(seg -> seg.encuesta().getComentario().isPresent())
            .map(seg -> {
                String comentario = seg.encuesta().getComentario().get();
                return "Sucursal " + seg.sucursal() +
                        ": Seguimiento a paciente con comentario: \"" + comentario + "\"";
            })
            .forEach(System.out::println);
    }

    record Seguimiento(Encuesta encuesta, String sucursal) {}
}
