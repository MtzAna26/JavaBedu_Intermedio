public class Video extends MaterialCurso{
    private final int duracion;
    
    public Video(String titulo, String autor, int duracion){
        super(titulo, autor); // se usa super para hacer referencia a la superclase
        this.duracion = duracion;
    }
    public int getDuracion(){
        return duracion;
    }
    @Override
    public void mostrarDetalle(){
        System.out.println("Video: " + getTitulo() + "- Autor" + getAutor() + " - Duración: " + duracion + " min");
    }
}
