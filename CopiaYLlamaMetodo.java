import java.util.Vector;
//metodo para el exp masmas exp menos menos pq decuelve el exp antes de hacerle el masmas o menos menos

public class LlamadaMetodo extends Instruccion {

    private Instruccion e1, param[];
    private String metodo;

    public LlamadaMetodo(int linea, Instruccion e1, String metodo, Instruccion param[]) {
        super(linea);
        this.e1 = e1;
        this.metodo = metodo;
        this.param = param;

    }
    
    @Override
    public Objeto generarCodigo() throws Exception{
        Objeto oParam[] = null;
        Objeto r;
        Variable o1 = (Variable) e1.generarCodigo();
        r = new Variable(Objeto.newNomObj(), o1.getBloque(), true , o1.getTipo());
        r = r.generarCodigoMetodo(Metodos.CONSTRUCTORCOPIA, new Objeto[]{o1}, getLinea());
    
        if(param!=null){
            oParam=new Objeto[param.lenght];
    
            for(int k=0;k<param.lenght;k++){
                oParam[k]=param[k].generarCodigo(); 
            }
        }
        o1.generarCodigoMetodo(metodo,oParam, getLinea());
        return r;
    }
}