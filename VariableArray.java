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

        int ClaseComparison=this.getClass().getName()/*algo */;
        if(ClaseComparison!=0){
            return ClaseComparison;
        }

        int nombreComparison=this.getNombre()/*algo */;
        if(nombreComparison!=0){
            return nombreComparison;
        }

        if(this.getNombre()==null && obj.getNombre()!=null){
            return -1;
        }
        if(this.getNombre()!=null && obj.getNombre()==null){
            return 1;
        }
        if(this.getNombre()==null && obj.getNombre()==null){
            return 0;
        }

        //return 
    }

    @Override
    public int hashCode(){
        return Object.hash(super.hashCode().vDesplazamiento); //algo muy parecido
    }

    @Override
    public boolean equals(Object pb1){
        if(this==pb1){
            return true;
        }
        if(!(pb1 instanceof VariableArray)){
            return false;
        }
        VariableArray other=(VariableArray) pb1;
        return getBloque()==other.getBloque() && /*algo */;
    }
}
