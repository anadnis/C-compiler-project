import java.text.ParseException;

public class TipoChar extends Tipo{  
    public static final TipoChar instancia = new TipoChar();

    private TipoChar(){
        super(Predefinidos.CARACTER, 0, false);
    }

    @Override
    public Objeto generarCodigoMetodo (String metodo, Objeto[] param,int linea ) throws Exception{
        return null;
    }
//el impirmir le ha puesto un printc el cast ha cambiado la logica, de caractera  acaracter y de caractera  entero,   

    @Override 
    public Objeto generarCodigoInstancia(Instancia instancia,String metodo, Objeto[] param,int linea) throws Exception{
       Instancia par;
       Variable v;
       String et1;

        switch(metodo){
            case Metodos.IMPRIMIR:
                PLXC.out.println("printc "+instancia.getIDC()+";");
                break;

            case Metodos.ASIGNA:
                if (((Instancia) param[0]).getTipo().getNombre() == Predefinidos.REAL || ((Instancia) param[0]).getTipo().getNombre() == Predefinidos.ENTERO) {
                    PLXC.out.println("error;");
                    break;
                }
                if(!instancia.getMutable()){
                    throw new ParseException("("+instancia.getNombre()+") no se puede reasignar un valor a la constante",linea);
                }

            case Metodos.CONSTRUCTORCOPIA:
                Objeto p=param[0];
                if(!(p instanceof Instancia)){
                    throw new ParseException("("+p.getNombre()+") dato requerido a la derecha",linea);
                }
                par=(Instancia) p;
                if(par.getTipo()!=this){
                    par=(Instancia) par.generarCodigoMetodo(Metodos.CAST, new Objeto[] {this}, linea);
                }
                PLXC.out.println(instancia.getIDC() + " = "+par.getIDC()+";");
                return param[0];

            case Metodos.CONSTLITERAL:
                PLXC.out.println(instancia.getIDC()+" = "+((Literal) instancia).getValor()+";");
                return instancia;

            case Metodos.CAST:
                if((param==null) || (param.length!=1) || (!(param[0] instanceof Tipo))){
                    throw new ParseException("La conversión de tipos necesita un tipo", linea);
                }

            switch (param[0].getNombre()){
                case Predefinidos.ENTERO:               
                    v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); 
                    PLXC.out.println(v.getIDC()+" = "+instancia.getIDC()+";");
                    return v;
                case Predefinidos.CARACTER:
                    v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); 
                    PLXC.out.println(v.getIDC()+" = "+instancia.getIDC()+";");
                    return v;
                case Predefinidos.REAL:
                    v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); 
                    PLXC.out.println(v.getIDC()+"= (float) "+instancia.getIDC()+";");
                    return v;
                case Predefinidos.BOOL:
                    v=new Variable(newNomObj(),instancia.getBloque(),false,TipoBool.instancia); 
                    et1=newEtiq(); 
                    PLXC.out.println(v.getIDC()+"= 1; "); // $t0 = 1
                    PLXC.out.println("if ("+instancia.getIDC()+" != 0) goto "+et1+";");
                    PLXC.out.println(v.getIDC()+" = 0;"); // $t0 = 0
                    PLXC.out.println(et1+":"); // L1
                    return v;               
                default:
                throw new ParseException("No se puede convertir un " + getNombre() + " a " + param[0].getNombre(), linea);
            }

            //de aqui
            case Metodos.SUMA:
            case Metodos.RESTA:

                if(param == null) {
                    throw new ParseException("No se han pasado parámetros para " + metodo, linea);
                }
                p = param[0];
                if(!(p instanceof Instancia)) {
                    throw new ParseException("<" + p.getNombre() + "> no es una instancia (literal o variable)", linea);
                } 

                v = (Variable) instancia.generarCodigoMetodo(Metodos.CAST, new Objeto[]{TipoInt.instancia}, linea);
                return v.generarCodigoMetodo(metodo, param, linea);

                /*                           
                par= (Instancia) p;
                switch(par.getTipo().getNombre()) {
                    case Predefinidos.REAL:
                        // Si el operando es un real, me convierto a real y dejo a la clase TipoFloat que haga la operación
                        v = (Variable) instancia.generarCodigoMetodo(Metodos.CAST, new Objeto[]{TipoReal.instancia}, linea);
                        return v.generarCodigoMetodo(metodo, param, linea);
                    case Predefinidos.CARACTER:
                        if(!metodo.equals(Metodos.SUMA) && !metodo.equals(Metodos.RESTA)) {
                            throw new ParseException("Método " + metodo + " no aplicable entre " + getNombre() + " y " + Predefinidos.CARACTER, linea);
                        }
                    case Predefinidos.ENTERO:
                        break;
                    default:
                        throw new ParseException("Tipo inválido para operar con " + getNombre(), linea);
                }           
                //hasta aquí, esta copiado de github porque no lo teníamos
                //v=new Variable(newNomObj(),instancia.getBloque(),false,this); //en github en vez de (Tipo) param[0] pones this
                // PLXC.out.print(v.getIDC()+" = "+instancia.getIDC());
                switch (metodo) {
                    case Metodos.SUMA:
                        PLXC.out.print(" + ");
                        break;
                    case Metodos.RESTA:
                        PLXC.out.print(" - ");
                        break;
                    case Metodos.MULT:
                        PLXC.out.print(" * ");
                        break;
                    case Metodos.DIVID:
                        PLXC.out.print(" / ");
                        break;
                }
             PLXC.out.println(par.getIDC()+";");
             return v;*/
                       
            case Metodos.RESTO:
                p = param[0];
                if(!(p instanceof Instancia)) {
                    throw new ParseException(p.getNombre() + " no es una instancia (literal o variable)", linea);
                }
                if(((Instancia) p).getTipo() != this) {
                    p = p.generarCodigoMetodo(Metodos.CAST, new Objeto[]{this}, linea);
           }
            Objeto cociente = instancia.generarCodigoMetodo(Metodos.DIVID, param, linea); // $t0 = a / b;
            Objeto mult = cociente.generarCodigoMetodo(Metodos.MULT, param, linea); // $t1 = $t0 * b;
            return instancia.generarCodigoMetodo(Metodos.RESTA, new Objeto[]{mult}, linea); // $t2 = a - $t1
            // Relacionales
            case Metodos.IGUAL:
            case Metodos.DIFERENTE:
            case Metodos.MENOR:
            case Metodos.MENORIG:
            case Metodos.MAYOR:
            case Metodos.MAYORIG:
                p = param[0];
                if(!(p instanceof Instancia)) {
                    throw new ParseException(p.getNombre() + " no es una instancia (literal o variable)", linea);
                }
                par=(Instancia) p;
                if(par.getTipo() != this && par.getTipo() != TipoReal.instancia) {
                    throw new ParseException("Tipo inválido para comparar con " + getNombre(), linea);
                }
            v=new Variable(newNomObj(), instancia.getBloque(), false, TipoBool.instancia);
            et1=newEtiq();
            PLXC.out.println(v.getIDC()+" = 1;");
                
            switch(metodo){
                case Metodos.IGUAL: 
                PLXC.out.println("if ("+instancia.getIDC()+" == "+par.getIDC()+ ") goto " + et1 + ";"); 
                break;

                case Metodos.DIFERENTE:
                PLXC.out.println("if ("+instancia.getIDC()+ " != " +par.getIDC()+ ") goto " + et1 + ";");
                break; 

                case Metodos.MAYOR: 
                PLXC.out.println("if ("+par.getIDC()+" < "+instancia.getIDC() + ") goto " + et1 + ";");
                break;

                case Metodos.MENOR:
                PLXC.out.println("if ("+instancia.getIDC()+" < "+par.getIDC()+ ") goto " + et1 + ";");
                break; 

                case Metodos.MAYORIG:
                PLXC.out.println("if ("+instancia.getIDC()+" == "+par.getIDC()+") goto " + et1 + ";"); 
                PLXC.out.println("if ("+par.getIDC()+" < "+instancia.getIDC()+") goto " + et1 + ";");
                break; 

                case Metodos.MENORIG:
                PLXC.out.println("if ("+instancia.getIDC()+" == "+par.getIDC()+ ") goto " + et1 + ";"); 
                PLXC.out.println("if ("+instancia.getIDC()+" < "+par.getIDC() + ") goto " + et1 + ";");
                break; 
            }
        PLXC.out.println(v.getIDC()+" = 0 ;");
        PLXC.out.println(et1 + ":");
        return v;

        case Metodos.OPUESTO:
            v=new Variable(newNomObj(), instancia.getBloque(),false,this);
            PLXC.out.println(v.getIDC()+" = 0 - "+instancia.getIDC()+";");
            return v;

        case Metodos.SIGUIENTE:
            PLXC.out.println(instancia.getIDC()+" = "+instancia.getIDC()+";");
            return instancia;

        case Metodos.ANTERIOR:
            PLXC.out.println(instancia.getIDC()+" = "+instancia.getIDC()+";");
            return instancia;

        case Metodos.NLOG:                 
            v=new Variable(newNomObj(), instancia.getBloque(), false, TipoBool.instancia);
            et1=newEtiq();
            PLXC.out.println(v.getIDC()+" = 1;");                
            PLXC.out.println("if ("+instancia.getIDC()+" == 0) goto "+et1+";"); 
            PLXC.out.println(v.getIDC()+" = 0;"); //linea 107
            PLXC.out.println(et1 + ": ");
            return v;
        case Metodos.YLOG:    
        case Metodos.OLOG:
            Etiqueta et;
            if((param==null) || (param.length!=1) /*|| (!(param[0] instanceof Tipo))*/)  {
                throw new ParseException("La operacion "+metodo+ "necesita una etiqueta como parametro",linea);
            }
            et=(Etiqueta) param[0];

            v=new Variable(newNomObj(), instancia.getBloque(), false, TipoBool.instancia);
            PLXC.out.println(v.getIDC()+" = "+instancia.getIDC()+";");

            switch (metodo) {
                case Metodos.YLOG: 
                    PLXC.out.println("if ("+instancia.getIDC()+" ==0) goto "+et.getIDC()+";"); 
                    break;
                case Metodos.OLOG: 
                    PLXC.out.println("if ("+instancia.getIDC()+" ==1) goto "+et.getIDC()+";"); 
                    break;//linea 128
            }
            return v;
        default:
        throw new ParseException("Operacion ("+metodo+")"+" no permitido para " + getNombre(), linea);    
        }        
        return null;
        }
}