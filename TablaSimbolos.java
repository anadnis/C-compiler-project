import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class TablaSimbolos {
    // Bloque <Integer> -> (NombreObj <String> -> Obj <Objeto>)

    private Map<Integer, Map<String, Objeto>> tabla;

    public TablaSimbolos() {
        tabla = new HashMap<>();
    }

    public void insertarObjeto(Objeto obj) {
        Integer bloque = Integer.valueOf(obj.getBloque());
        Map<String, Objeto> subtabla = tabla.get(bloque);
        if(subtabla == null) {
            Map<String, Objeto> st = new HashMap<>();
            st.put(obj.getNombre(), obj);
            tabla.put(bloque, st);
        } else {
            subtabla.put(obj.getNombre(), obj);
        }
    }

    public Objeto buscar(String nombre) {
        int mayor = 0;
        Objeto obj = null;
        for(var entry : tabla.entrySet()) {
            if(entry.getKey() >= mayor && entry.getValue().containsKey(nombre)) {
                mayor = entry.getKey();
                obj = entry.getValue().get(nombre);
            }
        }

        return obj;
    }

    public void eliminarBloque(int bloque) {
        tabla.remove(bloque);
    }

    public Variable declararVariable(int linea, String nombre, Integer bloque, boolean mutable, Tipo tipo) throws Exception {
        Objeto obj = buscar(nombre);

        if(obj != null && obj.getBloque() == bloque) {
            throw new ParseException("Variable <" + nombre + "> ya declarada en el mismo bloque", linea);
        }

        Variable v = new Variable(nombre, bloque, mutable, tipo);
        insertarObjeto(v);

        return v;
    }

    @Override
    public String toString() {
        return tabla.toString();
    }
}
/*LO QUE TENIAMOS NOSOTROS:
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
}*/