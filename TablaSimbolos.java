import java.util.*;
//MUY REGULERA COMPLETAR CON CHATGPT
public class TablaSimbolos {

    private HashMap<String, Integer> tabla;

    public TablaSimbolos() {
        this.tabla = new HashMap<>();
    }

    public Variable declararVariable( String nombre, int bloque, boolean mutable, Tipo tipo){
        Objeto otro = buscarObjeto(nombre);
        //if falta
        //lo ultimo lo tienen carlos
    }

// esto esta mal
    public Objeto borrarObjeto(int bloque, String nombre) {
        Map
        Objeto obj = null;
        for (int i = bloque; i >= 0; i--) {
            if (tabla.containsKey(i)) {
                obj = tabla.get(i).get(nombre);
                if (obj != null) {
                    tabla.get(i).remove(nombre);
                    return obj;
                }
            }
        }
        return obj;
    }
//
    public void borrarBloque (int bloque) {
        tabla.remove(bloque);
    }

//
    public void añadirObjeto(Objeto objeto){
        if(objeto==null || objeto.getNombre()==null){
            throw new IllegalArgumentException("Objeto y nombre no pueden ser null");
        }
        tabla.computeIfAbsent(objeto.getBloque(),k->new HashMap<>()).put(objeto.get);
    } 

//    cambiarlo para que busque por bloque mas alto
   public Objeto buscarObjeto(String nombre){
        if(nombre == null){
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        for (Map<String, Objeto> subTabla : tabla.values()) {
            if(subTabla.containsKey(nombre)){
                return subTabla.get(nombre);
            }
        }
        return null;
   }

   //public Objeto buscarObjeto(String nombre){ //inicio de lo de arriba 
    //int mayorB = 0;
    //Objetoult 
}