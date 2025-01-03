//import java.text.ParseException;

public class Literal extends Instancia {
    private Object valor;

    public Literal(int bloque, Tipo tipo, Object valor) {
        super(newNomObj(), bloque, false, tipo);
        this.valor = valor;
    }

    public Object getValor() {
        return valor;
    }

    
    public Objeto generarCodigoMetodo (String metodo, Objeto[] param, int linea) throws Exception{
//        if(!metodo.equals(Metodos.CONSTLITERAL)&& (!metodo.equals(Metodos.CAST))) {
//            throw new ParseException("las consntantes noa admiten metodos", PLXC.lex.getLine());
//        }
//        if(param!=null){
//            throw new ParseException("", PLXC.lex.getLine());
//        }
        return getTipo().generarCodigoInstancia(this, metodo,param, linea);
    }

}