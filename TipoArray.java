public class TipoArray extends Tipo{
    @Override 
    public Objeto generarCodigoInstancia(Instancia instancia,String metodo, Objeto[] param) throws Exception{
       Instancia par;
       Variable v;

        swich(metodo){
            case Metodos.SIZEOF:
            s=(Instancia) tipo/*algo */.generarCodigoMetodo(metodo /*algo */);
            v=new Variable(newNomObj(),this.getBloque(), /*algo */)
            PLXC.out.println(v.getIDC()+" = "+size+ /*algo */);
            return v;

            default:
            throw new ParseException("Operacion ("+/*algo */);
        }
    }
}
