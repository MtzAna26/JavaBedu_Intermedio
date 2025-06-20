package Reto1;

//import java.lang.foreign.Linker.Option;
import java.util.Optional;

public class Pedido{
    private final String cliente;
    private final String TipoEntrega; 
    private final String telefono;

    public Pedido(String cliente, String TipoEntrega, String telefono) {
        this.cliente = cliente;
        this.TipoEntrega = TipoEntrega;
        this.telefono = telefono;
    }
    public String getCliente(){
         return cliente;
    }
    public String getTipoEntrega() {
        return TipoEntrega;
    }   
    // para asegurar que telefono sea null metodo
    public Optional<String> getTelefono(){
        return Optional.ofNullable(telefono);
    }
}
