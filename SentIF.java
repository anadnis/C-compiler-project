import java.text.ParseException;

public class SentIF extends Instruccion{
    Instruccion cond, pTrue, pFalse;
    public SentIF(int linea, Instruccion cond, Instruccion pTrue, Instruccion pFalse) {
        super(linea);
        this.cond = cond;
        this.pTrue = pTrue;
        this.pFalse = pFalse;
    }

@Override
public Objeto generarCodigo() throws Exception{
    Objeto c= cond.generarCodigo();
    String etFalse=Objeto.newEtiq();
    String etFinal=Objeto.newEtiq();

    if(!(c instanceof Instancia)){
        throw new ParseException("La expresión del if debe ser una instancia (literal o variable)", getLinea());
    }

    Instancia iCond=(Instancia) c;

    if(iCond.getTipo() != TipoBool.instancia){
        iCond=(Instancia) iCond.generarCodigoMetodo(Metodos.CAST, new Objeto[]{TipoBool.instancia}, getLinea());
    }

    PLXC.out.println("if ("+iCond.getIDC()+ " == 0) goto" + etFalse + ";");
    pTrue.generarCodigo();

    PLXC.out.println("goto "+etFinal+";");
    PLXC.out.println(etFalse+";");

    if(pFalse!=null) {pFalse.generarCodigo();}
    return null;
}
}