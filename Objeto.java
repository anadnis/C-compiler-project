import java.util.Objects; // se supone que tiene que tener newEtiq definido. 

public abstract class Objeto implements Comparable<Objeto> {
    private String nombre;
    private int bloque;
    private boolean mutable;

    private static int numObj = 0;

    public static String newNomObj() {
        String n = new String("$t"+Integer.toString(numObj));
        numObj++;
        return n;
    }

    public Objeto (String nombre, int bloque, boolean mutable){
        this.nombre=nombre;
        this.bloque=bloque;
        this.mutable=mutable;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getBloque(){
        return bloque;
    }
    
    public boolean getMutable(){
        return mutable;
    }

    public String getIDC(){   //sirve para cuando tengamos una variable que se llama igual pero en dos bloques distintos, para no cargarnos la primera.
        return nombre + "$" + Integer.toString(bloque);
    }

    public abstract Objeto generarCodigoMetodo(String metodo, Objeto[] param) throws Exception;
    
    public int compareTo(Objeto o) {
        if(o == null) {
            throw new NullPointerException("El objeto a comparar no puede ser nulo");
        } 

        int bloqueComparison=Integer.compare(this.bloque, o.bloque);

        if(bloqueComparison!=0){
        return bloqueComparison;
        }
        //return
    }

    //y falta el hascode y el equals

}

//alguna estructura de control nueva que no se haya visto en clase, quizas algún tipo o array.