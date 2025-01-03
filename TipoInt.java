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
                throw new ParseException("("+p.getNombre()+") dato reque (y algo mas)");
            }
            par=(Instancia) p;
            if(par.getTipo()!=this){
                par=(Instancia) par.generarCodigoMetodo(Metodos.CAST, new Objeto[] /*falta */);
            }
            PLXC.out.println(instancia.getIDC() + " = "+par.getIDC()+"-");
            return para//algo

            case Metodos.CONSTLITERAL:
            PLXC.out.println(instancia.getIDC()+" = "+((Literal) /*algo */));
            return instancia;

            case Metodos.CAST:
            if((param==null) || (; //regular estas dos lineas
            )param.length!=1)|| (!(param[0] instanceof Tipo))){
                //falta
            }
        }
    }  //en la linea de cast, que no se ve en la foto al final, mete como parametro, metodos.CAST ,new Objeto[] {this}
            // en la linea swich case de predefinidos , el ultimo parámetro: (tipo) param[0]

//clase TOCHa son como 180 lineas de codigo . un mega case switch y carlos tiene dos fotos. martes 10 dic

    return v;
    default 


    /
    @Override
    public Objeto generarCodigoMetodo(String metodo, Objeto[] param, int linea) throws Exception{
        return null;
    }
}