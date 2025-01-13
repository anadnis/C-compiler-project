import java.text.ParseException;

public class TipoBool extends Tipo{  
    public static final TipoBool instancia = new TipoBool();

    private TipoBool(){
        super(Predefinidos.BOOL, 0, false);
    }

    @Override 
    public Objeto generarCodigoInstancia(Instancia instancia,String metodo, Objeto[] param, int linea) throws Exception{
       Instancia par;
       Variable v;
       String et1;
       Etiqueta et;
       
        switch(metodo){
            case Metodos.IMPRIMIR:
            et1=newEtiq();
            String etFin=newEtiq();
            PLXC.out.println("if ("+instancia.getIDC()+" == 0 ) goto " + et1 + ";"); 
            PLXC.out.println("writec 116;");
            PLXC.out.println("writec 114;");
            PLXC.out.println("writec 117;");
            PLXC.out.println("writec 101;");
            PLXC.out.println("writec 10;");
            PLXC.out.println("goto "+etFin+";");
            PLXC.out.println(et1 + ":");
            PLXC.out.println("writec 102;");
            PLXC.out.println("writec 97;");
            PLXC.out.println("writec 108;");
            PLXC.out.println("writec 115;");
            PLXC.out.println("writec 101;");
            PLXC.out.println("writec 10;");
            PLXC.out.println(etFin+":");
            break;            
            
            case Metodos.ASIGNA:
                if(!instancia.getMutable()){
                    throw new ParseException("("+instancia.getNombre()+") no es una variable",linea);
                }
            //esta bien 25:
            case Metodos.CONSTRUCTORCOPIA:
                Objeto p=param[0];
                if(!(p instanceof Instancia)){
                    throw new ParseException("("+p.getNombre()+") dato requerido al derecha",linea);
                }
                par=(Instancia) p;
                if(par.getTipo()!=this){
                    par=(Instancia) par.generarCodigoMetodo(Metodos.CAST, new Objeto[] {this}, linea);
                }
                PLXC.out.println(instancia.getIDC() + " = "+par.getIDC()+";");
                return param[0];

            case Metodos.CONSTLITERAL:
                PLXC.out.println(instancia.getIDC()+" = "+((Literal) instancia).getValor());
                return instancia;

            case Metodos.CAST:
                if((param==null) || (param.length!=1) || (!(param[0] instanceof Tipo))){
                    throw new ParseException("La conversión de tipos necesita un tipo", linea);
                }
                switch (param[0].getNombre()){
                    case Predefinidos.ENTERO:
                    return instancia;

                    case Predefinidos.REAL:
                        v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); //no estpy seguro si es param[0]
                        PLXC.out.println(v.getIDC()+"= (float) "+instancia.getIDC()+";");
                        return v;
                    default :
                        throw new ParseException("No se puede convertir "+instancia, linea);
                    //aqui 53
                    /* 
                    case Predefinidos.CARACTER:
                        v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); 
                        PLXC.out.println(v.getIDC()+" = "+instancia.getIDC()+";");
                        return v;

                    
                    */
                }
                /* 
                case Metodos.SUMA:
                case Metodos.RESTA:
                case Metodos.MULT:
                case Metodos.DIVID:
                    if(param == null) {
                        throw new ParseException("No se han pasado parámetros para " + metodo, linea);
                    }

                    p = param[0];

                    if(!(p instanceof Instancia)) {
                        throw new ParseException("<" + p.getNombre() + "> no es una instancia (literal o variable)", linea);
                    }

                    par=(Instancia) p;
                //de aqui
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
                v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); //no estpy seguro si es param[0]
                PLXC.out.println(v.getIDC()+" = "+instancia.getIDC()+";");
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

                //de tipoint:
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
                // Relacionales */
                case Metodos.IGUAL:
                case Metodos.DIFERENTE: //aqui 56
                case Metodos.MENOR:
                case Metodos.MENORIG:
                case Metodos.MAYOR:
                case Metodos.MAYORIG:
                    /*p = param[0];

                    if(!(p instanceof Instancia)) {
                        throw new ParseException(p.getNombre() + " no es una instancia (literal o variable)", linea);
                    }
                    par=(Instancia) p;
                    if(par.getTipo() != this && par.getTipo() != TipoReal.instancia) {
                        throw new ParseException("Tipo inválido para comparar con " + getNombre(), linea);
                    }

                //lo anterior de tipoint
                    */
                    if((param==null) || (param.length!=1) || (!(param[0] instanceof Tipo))){
                        throw new ParseException("La operacion "+metodo+ "necesita una etiqueta como parametro",linea);
                    }
                    par=(Instancia) param[0];
                    if(this != par.getTipo()) {
                        par=(Instancia) par.generarCodigoMetodo(Metodos.CAST, new Objeto[] {this}, linea);
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
                        PLXC.out.println(v.getIDC()+" = 0 ");
                        PLXC.out.println(et1 + " ");
                        break;
                } //linea 96    
                PLXC.out.println(v.getIDC()+" = 0;"); //linea 98
                PLXC.out.println(et1+";");

                return v; //linea 101

                /*v=new Variable(newNomObj(), instancia.getBloque(), false, TipoBool.instancia);
                et1=newEtiq();
                PLXC.out.println(v.getIDC()+" = 1;");

                switch(metodo){
                    case Metodos.IGUAL: 
                    PLXC.out.println("if ("+instancia.getIDC()+" == "+par.getIDC() algoooo ); 
                    break;

                    case Metodos.DIFERENTE:
                    PLXC.out.println("if ("+instancia.getIDC()+ algoooo par.getIDC());
                    break; 

                    case Metodos.MAYOR: 
                    PLXC.out.println("if ("+par.getIDC()+" < "+instancia.getIDC() algoooo );
                    break;

                    case Metodos.MENOR:
                    PLXC.out.println("if ("+instancia.getIDC()+" < "+par.getIDC()algoooo );
                    break; 

                    case Metodos.MAYORIG:
                    PLXC.out.println("if ("+instancia.getIDC()+" == "+par.getIDC() algoooo ); 
                    PLXC.out.println("if ("+par.getIDC()+" < "+instancia.getIDC() algoooo );
                    break; 

                    case Metodos.MENORIG:
                    PLXC.out.println(v.getIDC()+" = 0 ");
                    PLXC.out.println(et1 + " ");
                    break;
                }
                    return v;  */
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
                    if((param==null) || (param.length!=1) /*|| (!(param[0] instanceof Tipo))*/)  {
                        throw new ParseException("La operacion "+metodo+ "necesita una etiqueta como parametro",linea);
                    }
                    et=(Etiqueta) param[0];

                    v=new Variable(newNomObj(),instancia.getBloque(), false, TipoBool.instancia);
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
                throw new ParseException("Operacion ("+metodo+"... no implementada para el tipo "+getNombre(),linea);    
            }
            return null; //linea 134
        
        //en la linea de cast, que no se ve en la foto al final, mete como parametro, metodos.CAST ,new Objeto[] {this}
    }       // en la linea swich case de predefinidos , el ultimo parámetro: (tipo) param[0]

   
    @Override
    public Objeto generarCodigoMetodo(String metodo, Objeto[] param, int linea) throws Exception{
        return null;
    }
}


// tood igual que enetero incluyendo el cast, lo unico distinto es las operaciones lógicas ylog olog 