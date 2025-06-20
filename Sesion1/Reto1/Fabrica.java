import java.util.ArrayList;
import java.util.List;

public class Fabrica {
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista){
        for (OrdenProduccion orden : lista){
            orden.mostrarResumen();
            System.out.println("-----------------");
        }
    }
    public static void procesarPersonalizadas(List<? super  OrdenPersonalizada> lista, int costoAdicional){
        for (Object obj : lista){
            if (obj instanceof OrdenPersonalizada){
                ((OrdenPersonalizada) obj).agregarCostoAdicional(costoAdicional);
            }
        }
    }
    public static void main(String[] args){
        // crear ordenes de cada tipo
        OrdenMasa o1 = new OrdenMasa("M001", 1000);
        OrdenMasa o2 = new OrdenMasa("M002", 1500);

        OrdenPersonalizada p1 = new OrdenPersonalizada("P001", 200, "Cliente A");
        OrdenPersonalizada p2 = new OrdenPersonalizada("P002", 300, "Cliente B");
        
        OrdenPrototipo pr1 = new OrdenPrototipo("T001", 10, "Fase 1");
        OrdenPrototipo pr2 = new OrdenPrototipo("T002", 5, "Fase 2");
    
        // lista generica de ordenes
        List<OrdenProduccion> listaGeneral = new ArrayList<>();
        listaGeneral.add(o1);
        listaGeneral.add(o2);
        listaGeneral.add(p1);
        listaGeneral.add(p2);
        listaGeneral.add(pr1);
        listaGeneral.add(pr2);
        //mostrar todas las ordenes 
        System.out.println("RESUMEN DE TODAS LAS ORDENES: ");
        mostrarOrdenes(listaGeneral);

        System.out.println("\n PROCESANDO ORDENES PERSONALIZADAS: ");
        procesarPersonalizadas(listaGeneral, 500);
    }
}
