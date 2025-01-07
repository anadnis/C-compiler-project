import java.text.ParseException;;

public class TipoInt extends Tipo{  //una única instancia de objeto entero en todo el programa
    public static final TipoInt instancia = new TipoInt();

    private TipoInt(){
        super(Predefinidos.ENTERO, 0, false);
    }
//fotos carlos martes 10 dic (2) y 17 diciembre varias   
    @Override
    public Objeto generarCodigoMetodo(String metodo, Objeto[] params, int linea) throws Exception {
        return null;
        //no se si hay algo
    }

    @Override 
    public Objeto generarCodigoInstancia(Instancia instancia,String metodo, Objeto[] param,int linea) throws Exception{
       Instancia par;
       Variable v;
       String et1;

        switch(metodo){
            case Metodos.IMPRIMIR:
                PLXC.out.println("print "+Instancia.getIDC()+";");
                break;

            case Metodos.ASIGNA:
            if(!instancia.getMutable()){
                throw new ParseException("("+instancia.getNombre()+") no se puede reasignar un valor a la constante",linea);
            }

            case Metodos.CONSTRUCTORCOPIA:
            Objeto p=param[0];
            if(!(p instanceof Instancia)){
                throw new ParseException("("+p.getNombre()+") no es una instancia (literal o variable)",linea);
            }
            par=(Instancia) p;
            if(par.getTipo()!=this){
                par=(Instancia) par.generarCodigoMetodo(Metodos.CAST, new Objeto[] {this}, linea);
                //en github tiene esto: throw new ParseException("<" + obj.getNombre() + "> no es de tipo " + getNombre(), linea);
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

                case Predefinidos.CARACTER:
                v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); 
                PLXC.out.println(v.getIDC()+" = "+instancia.getIDC()+";");
                return v;

                case Predefinidos.REAL:
                v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); 
                PLXC.out.println(v.getIDC()+"= (float) "+instancia.getIDC()+";");
                return v;

                case Predefinidos.BOOL:
                v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); 
                et1=newEtiq(); 
                PLXC.out.println(v.getIDC()+"= l: "); // $t0 = 1
                PLXC.out.println("if ("+instancia.getIDC()+" )= 0) goto "+et1+";");
                PLXC.out.println(v.getIDC()+" =0;"); // $t0 = 0
                PLXC.out.println(et1+":"); // L1
                return v;
                
                default:
                throw new ParseException("No se puede convertir un " + getNombre() + " a " + param[0].getNombre(), linea);
            }

            //de aqui
            case Metodos.SUMA:
            case Metodos.RESTA:
            case Metodos.MULT:
            case Metodos.DIVID:
                if(param == null) {
                    throw new ParseException("No se han pasado parámetros para " + metodo, linea);
                }

                Objeto obj = param[0];

                if(!(obj instanceof Instancia)) {
                    throw new ParseException("<" + obj.getNombre() + "> no es una instancia (literal o variable)", linea);
                }

                Objeto tipo = ((Instancia) obj).getTipo();

                switch(tipo.getNombre()) {
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
            //hasta aqui, esta copiado de github porque no lo teniamos
             v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); //en github en vez de (Tipo) param[0] pones this
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
            
            //de aqui
            case Metodos.MODULO:
            obj = param[0];

            if(!(obj instanceof Instancia)) {
                throw new ParseException(obj.getNombre() + " no es una instancia (literal o variable)", linea);
            }

            if(((Instancia) obj).getTipo() != this) {
                obj = obj.generarCodigoMetodo(Metodos.CAST, new Objeto[]{this}, linea);
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
                obj = param[0];

                if(!(obj instanceof Instancia)) {
                    throw new ParseException(obj.getNombre() + " no es una instancia (literal o variable)", linea);
                }

                tipo = ((Instancia) obj).getTipo();
                if(tipo != this && tipo != TipoReal.instancia) {
                    throw new ParseException("Tipo inválido para comparar con " + getNombre(), linea);
                }
            //hasta aqui esta copiado de github porque no lo teniamos

            v=new Variable(newNomObj(), instancia.getBloque(), false, /*algo */);
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
            PLXC.out.println(v.getIDC()+" = 0 ");
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

        default:
        throw new ParseException("Operacion ("+metodo+")"+" no permitido para " + getNombre(), linea);    
        }
        
        return null;
        }
      //en la linea de cast, que no se ve en la foto al final, mete como parametro, metodos.CAST ,new Objeto[] {this}
            // en la linea swich case de predefinidos , el ultimo parámetro: (tipo) param[0]

    //clase TOCHa son como 180 lineas de codigo . un mega case switch y carlos tiene dos fotos. martes 10 dic


    
    @Override
    public Objeto generarCodigoMetodo(String metodo, Objeto[] param, int linea) throws Exception{
        //creo que falta y en github tambien
        return null;
    }
}