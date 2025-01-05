import java.text.ParseException;;

public class TipoInt extends Tipo{  //una única instancia de objeto entero en todo el programa
    public static final TipoInt instancia = new TipoInt();

    private TipoInt(){
        super(Predefinidos.ENTERO, 0, false);
    }
//fotos carlos martes 10 dic (2) y 17 diciembre varias   

    @Override 
    public Objeto generarCodigoInstancia(Instancia instancia,String metodo, Objeto[] param) throws Exception{
       Instancia par;
       Variable v;
       String et1;
        swich(metodo){
            case Metodos.IMPRIMIR:
            PLXC.out.println("print "+Instancia.getIDC()+";");
            break;
            case Metodos.ASIGNA:
            if(!instancia.getMutable()){
                throw new ParseException("("+instancia.getNombre()+") no es una variable");
            }

            case Metodos.CONSTRUCTORCOPIA:
            Objeto p=param[0];
            if(!(p instanceof Instancia)){
                throw new ParseException("("+p.getNombre()+") dato requerido al derecha (y algo mas)");
            }
            par=(Instancia) p;
            if(par.getTipo()!=this){
                par=(Instancia) par.generarCodigoMetodo(Metodos.CAST, new Objeto[] /*falta */);
            }
            PLXC.out.println(instancia.getIDC() + " = "+par.getIDC()+"-");
            return param[0];

            case Metodos.CONSTLITERAL:
            PLXC.out.println(instancia.getIDC()+" = "+((Literal) instancia).getValor());
            return instancia;

            case Metodos.CAST:
            if((param==null) || (param.length!=1) || (!(param[0] instanceof Tipo))){
                throw new ParseException("La conversión de tipos necesita un tipo", /*algo */)
            }
            switch (param[0].getNombre()){
                case Predefinidos.ENTERO:
                return instancia;

                case Predefinidos.CARACTER:
                v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); //no estpy seguro si es param[0]
                PLXC.out.println(v.getIDC()+" = "+instancia.getIDC()+";");
                return v;

                case Predefinidos.REAL:
                v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); //no estpy seguro si es param[0]
                PLXC.out.println(v.getIDC()+"= (float) "+instancia.getIDC()+";");
                return v;

                case Predefinidos.BOOL:
                v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); //no estpy seguro si es param[0]
                et1=new(tigt); //no estpy seguro si es tigt
                PLXC.out.println(v.getIDC()+"= l: ");
                PLXC.out.println("if ("+instancia.getIDC()+" )= 0) goto "+et1+";");
                PLXC.out.println(v.getIDC()+" =0;");
                PLXC.out.println(et1+":");
                return v;
                
                default:
                throw new ParseException("No se puede convertir "+instancia /*algo*/);
            }
             //faltan como 15 lineas aqui
             v=new Variable(newNomObj(),instancia.getBloque(),false,(Tipo) param[0]); //no estpy seguro si es param[0]
             PLXC.out.println(v.getIDC()+" = "+instancia.getIDC()+";");
             switch (p) {
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

            Metodos.ANTERIOR:
            PLXC.out.println(instancia.getIDC()+" = "+instancia.getIDC()+";");
            return instancia;
            
            //faltan lineas 

            v=new Variable(newNomObj(), instancia.getBloque(), false, /*algo */);
            et1=newEtiq();
            PLXC.out.println(v.getIDC()+" = 1;");

            switch(metodo){
                case Metodos.IGUAL: 
                PLXC.out.println("if ("+instancia.getIDC()+" == "+par.getIDC() /*algo */); 
                break;

                case Metodos.DIFERENTE:
                PLXC.out.println("if ("+instancia.getIDC()+ /*algo */par.getIDC());
                break; 

                case Metodos.MAYOR: 
                PLXC.out.println("if ("+par.getIDC()+" < "+instancia.getIDC /*algo */);
                break;

                case Metodos.MENOR:
                PLXC.out.println("if ("+instancia.getIDC()+" < "+par.getIDC()/*algo */);
                break; 

                case Metodos.MAYORIG:
                PLXC.out.println("if ("+instancia.getIDC()+" == "+par.getIDC() /*algo */); 
                PLXC.out.println("if ("+par.getIDC()+" < "+instancia.getIDC /*algo */);
                break; 

                case Metodos.MENORIG:
                PLXC.out.println("if ("+instancia.getIDC()+" == "+par.getIDC() /*algo */); 
                PLXC.out.println("if ("+instancia.getIDC()+" < "+par.getIDC /*algo */);
                break; 
            }
            PLXC.out.println(v.getIDC()+" = 0 ");
            PLXC.out.println(et1 + " ");

            return v;

        default:
        throw new ParseException("Operacion ("+metodo /*algo */);    
        }
        
        return null;
        /*no va exactamente aqui pero por algun lado por aqui 
            if((param==null) || (param.length!=1) || algo  ){
                throw new ParseException("La operacion "algo );
            }
        */
        }
    }  //en la linea de cast, que no se ve en la foto al final, mete como parametro, metodos.CAST ,new Objeto[] {this}
            // en la linea swich case de predefinidos , el ultimo parámetro: (tipo) param[0]

//clase TOCHa son como 180 lineas de codigo . un mega case switch y carlos tiene dos fotos. martes 10 dic


    
    @Override
    public Objeto generarCodigoMetodo(String metodo, Objeto[] param, int linea) throws Exception{
        return null;
    }
}