import java.util.Objects;

public class VariableArray extends Variable{
    String vDesplazamiento;

    public VariableArray(String nombre, String vDesplazamiento, int bloque, boolean mutable, Tipo tipo){
        super(nombre, bloque,mutable, tipo);
        this.vDesplazamiento=vDesplazamiento;
    }

    public String getvDesplazamiento(){
        return vDesplazamiento;
    }

    public String getIDC() {
        return super.getIDC()+"["+vDesplazamiento+"]";
    }

    @Override
        public int compareTo(Objeto o){
            if(o==null){
                throw new NullPointerException("El objeto a comparar no puede ser nulo");
            }

            //comparar primero por bloque
            int bloqueComparison=Integer.compare(this.getBloque(), o.bloque);
            if(bloqueComparison!=0){
                return bloqueComparison;
            }
        }
}
