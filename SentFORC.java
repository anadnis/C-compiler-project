import java.text.ParseException;

public class SentFORC extends Instruccion{
    //Ciertas cosas dudosas
    Instruccion cond,act,cuerpo;
    public SentFORC(int linea, Instruccion cond, Instruccion act, Instruccion cuerpo) {
        super(linea);
        this.cond = cond;
        this.act = act;
        this.cuerpo = cuerpo;
    }

    @Override
    public Objeto generarCodigo() throws Exception{
        String etFor = Objeto.newEtiq();
        String etFinal = Objeto.newEtiq();
        Objeto c= cond.generarCodigo();

        if(!(c instanceof Instancia)){
            throw new ParseException("La condición del for debe ser una instancia (literal o variable)", getLinea());
        }

        Instancia iCond=(Instancia) c;

        if(iCond.getTipo() != TipoBool.instancia){
            iCond=(Instancia) iCond.generarCodigoMetodo(Metodos.CAST, new Objeto[]{TipoBool.instancia}, getLinea());
        }

        PLXC.out.println("if ("+iCond.getIDC()+ " == 0) goto"+ etFinal + ";");

        if(cuerpo!=null) cuerpo.generarCodigo();

        if(act!=null) act.generarCodigo();

        PLXC.out.println("goto "+etFor+";");
        PLXC.out.println(etFinal+";");

        return null;
    }
}
