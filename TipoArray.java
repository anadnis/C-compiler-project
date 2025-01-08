/* 
import java.text.ParseException;

public class TipoArray extends Tipo{
    private Tipo tipoBase;
    private int size;

    public TipoArray(String nombre, int bloque, boolean mutable, Tipo tipoBase,int size){
        super(nombre, bloque, mutable);
        this.tipoBase=tipoBase;
        this.size=size;
    }
    public Tipo getTipoBase(){
        return tipoBase;
    }

    public int getSize(){
        return size;
    }
    
    @Override 
    public Objeto generarCodigoInstancia(Instancia instancia,String metodo, Objeto[] param,int linea) throws Exception{
       Instancia par;
       Variable vSizeo,vSizeD;
       String vIndD,vIndO,etiqC,etiqF,vCont,vDesp;

       if(!(instancia instanceof VariableArray)){
            throw new ParseException("("+instancia.getNombre()+"algo",linea);
       }

        VariableArray va=(VariableArray) instancia;
        VariableArray aOrig,aDes;
        Objeto p;
        switch(metodo){
            case Metodos.ASIGNA:
            if(!instancia.getMutable()){
                throw new ParseException("("+instancia.getNombre()+") no es una variable",linea);
            }

            case Metodos.CONSTRUCTORCOPIA:
            p=param[0];
            if(!(p instanceof Instancia)){
                throw new ParseException("("+p.getNombre()+") dato requerido al derecha (y algo mas)",linea);
            }
            par=(Instancia) p;

            if(!Compatible(par.getTipo())){
                PLXC.out.println(" = Error "algoooo);
                PLXC.out.println("error; ");
                throw new ParseException("Array de tipo"algoooo,linea);
            }
            vIndD=newNomObj();
            vCont=newNomObj();
            etiqC=newEtiq();
            etiqF=newEtiq();

            if(((TipoArray) par.getTipo()).getTipoBase()){
                aOrig=new VariableArray(par.getNombre(), vIndD);
            }else{
                aOrig=new VariableArray(par.getNombre()mascosasss);
            }

            aDes=new VariableArray(va.getNombre(),vIndD algoooo);

            PLXC.out.println(vIndD+ " = "+ ((VariableArray algoooo)));
            PLXC.out.println(vIndD+" = "+va.getvDesplazamiento()algoooo);
            PLXC.out.println(vCont+ " =0;");
            PLXC.out.println(etiqC+";");
            PLXC.out.println("if ("+vCont+" == "+algoooo);
            PLXC.out.println("if ("+((TipoArray)algoooo));
            vDesp.generarCodigoMetodo(metodo, new Objeto()algoooo );
            vSizeo=(Variable) aOrig.getTipo().generarCodigoMetodoalgoooo;
            PLXC.out.println(vIndD+ " = "+ vIndDalgoooo);
            vSizeD=(Variable) aDes.getTipo().generaralgoooo;
            PLXC.out.println(vIndD+ " = "+ vIndDalgoooo);
            PLXC.out.println(vCont+ " = "+ vContalgoooo);            
            PLXC.out.println("goto "+etiqC+";");
            PLXC.out.println(etiqF+";");

            return param[0];
            case Metodos.IMPRIMIR:
            vIndD=newNomObj();
            vCont=newNomObj();
            etiqC=newEtiq();
            etiqF=newEtiq();
            if(this.getTipoBase() instanceof TipoArray){
                aDes=new VariableArray(va.getNombre(), vIndD, va.getBloque()algoooo);
            }else{
                aDes=new VariableArray(va.getNombre(),vIndD,va.getBloque()algoo, new TipoEArray(newNomObj(),algoooo));
            }
            PLXC.out.println(vIndD+" = "+va.getvDesplazamiento()algoooo);
            PLXC.out.println(vCont+ " =0;");
            PLXC.out.println(etiqC+";");
            PLXC.out.println("if ("+vCont+" == "+thisalgoooo);
            PLXC.out.println("if ("+this.getSize()+" < "algoooo);
            aDes.generarCodigoMetodo(metodo, null, linea);
            vSizeD=(Variable) aDES.getTipo().generarCodigoMetodo algoooo  ;
            PLXC.out.println(vIndD+ " = "+ vIndD+" + "+vSizeDalgoooo);
            PLXC.out.println(vCont+ " = "+ vCont+"algo ;"/);            
            PLXC.out.println("goto "+etiqC+";");
        }
    }

    @Override
    public Objeto generarCodigoMetodo(String metodo, Objeto[] param, int linea) throws Exception{
        Variable v;
        Instancia s;
        switch(metodo){
            case Metodos.SIZEOF:
            s=(Instancia) tipoalgoooo.generarCodigoMetodo(metodo algoooo);
            v=new Variable(newNomObj(),this.getBloque(), false, Tipoalgoooo)
            PLXC.out.println(v.getIDC()+" = "+size+ "="+s.getIDC()+";");
            return v;

            default:
            throw new ParseException("Operacion ("+metodo+") algo",linea);
        }
    }
}
*/
