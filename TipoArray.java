import java.text.ParseException;

public class TipoArray extends Tipo{
    private Tipo tipoBase;
    private int size;

    public TipoArray(String nombre, int bloque, boolean mutable, Tipo tipoBase,int size){
        super(nombre, bloque y mutable);
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
    public Objeto generarCodigoInstancia(Instancia instancia,String metodo, Objeto[] param) throws Exception{
       Instancia par;
       Variable vSizeo,vSizeD;
       String vIndD,vIndO,etiqC,etiqF,vCont,vDesp;

       if(!(instancia instanceof VariableArray)){
            throw new ParseException("("+instancia.getNombre()+"algo");
       }

        VariableArray va=(VariableArray) instancia;
        VariableArray aOrig,aDes;
        Objeto p;
        switch(metodo){
            case Metodos.ASIGNA:
            if(!instancia.getMutable()){
                throw new ParseException("("+instancia.getNombre()+") no es una variable");
            }

            case Metodos.CONSTRUCTORCOPIA:
            p=param[0];
            if(!(p instanceof Instancia)){
                throw new ParseException("("+p.getNombre()+") dato requerido al derecha (y algo mas)");
            }
            par=(Instancia) p;

            if(!Compatible(par.getTipo())){
                PLXC.out.println(" = Error "/*algo */);
                PLXC.out.println("error; ");
                throw new ParseException("Array de tipo"/*algo */);
            }
            vInd=newNomObj();
            vCont=newNomObj();
            etiqC=newEtiq();
            etiqF=newEtiq();

            if(((TipoArray) par.getTipo()).getTipoBase()){
                aOrig=new VariableArray(par.getNombre(), vInd);
            }else{
                aOrig=new VariableArray(par.getNombre(),/*cosas */);
            }

            aDes=new VariableArray(va.getNombre(),vInd, /*algo */);

            PLXC.out.println(vInd+ " = "+ ((VariableArray /*algo */)));
            PLXC.out.println(vInd+" = "+va.getvDesplac/*algo */);
            PLXC.out.println(vCont+ " =0;");
            PLXC.out.println(etiqC+";");
            PLXC.out.println("if ("+vCont+" == "+/*algo */);
            PLXC.out.println("if ("+((TipoArray)/*algo */));
            vDes.generarCodigoMetodo(metodo, new Objeto()/*algo */ );
            vSizeO=(Variable) aOrig.getTipo().generarCodigoMetodo/*algo */;
            PLXC.out.println(vInd+ " = "+ vInd+/*algo */);
            vSizeD=(Variable) aDes.getTipo().generar/*algo */;
            PLXC.out.println(vInd+ " = "+ vInd+/*algo */);
            PLXC.out.println(vCont+ " = "+ vCont+/*algo */);            
            PLXC.out.println("goto "+etiqC+";");
            PLXC.out.println(etiqF+";");

            return param[0];
            case Metodos.IMPRIMIR:
            vInd=newNomObj();
            vCont=newNomObj();
            etiqC=newEtiq();
            etiqF=newEtiq();
            if(this.getTipoBase() instanceof TipoArray){
                aDes=new VariableArray(va.getNombre(), vInd/*algo */);
            }else{
                aDes=new VariableArray(va.getNombre(),vInd/*añgo */, new TipoEArray(/*algo */));
            }
            PLXC.out.println(vInd+" = "+va.getvDesplac/*algo */);
            PLXC.out.println(vCont+ " =0;");
            PLXC.out.println(etiqC+";");
            PLXC.out.println("if ("+vCont+" == "+/*algo */);
            PLXC.out.println("if ("+this.getSize()+/*algo */);
            aDes.generarCodigoMetodo(metodo, new Objeto() /*algo */  );
            vSizeD=(Variable) aDES.getTipo().generarCodigoMetodo /*algo */  ;
            PLXC.out.println(vInd+ " = "+ vInd+/*algo */);
            PLXC.out.println(vCont+ " = "+ vCont+/*algo */);            
            PLXC.out.println("goto "+etiqC+";");
        }
    }

    @Override
    public Objeto generarCodigoMetodo(String metodo, Objeto[] param, int linea) throws Exception{
        Variable v;
        Instancia s;
        switch(metodo){
            case Metodos.SIZEOF:
            s=(Instancia) tipo/*algo */.generarCodigoMetodo(metodo /*algo */);
            v=new Variable(newNomObj(),this.getBloque(), false, Tipo/*algo */)
            PLXC.out.println(v.getIDC()+" = "+size+ "="+s.getIDC()+";");
            return v;

            default:
            throw new ParseException("Operacion ("+metodo+") algo");
        }
    }
}
