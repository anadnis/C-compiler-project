import java.text.ParseException;

public class SentFORC {
        @Override
    public Objeto generarCodigo() throws Exception{
        //falta
    Objeto c= cond.generarCodigo();

    if(!(c instanceof Instancia)){
        throw new ParseException("La condicion de un if ...");
    }

    Instancia iCond=(Instancia) c;

    if(iCond.getTipo() != TipoBool.Instancia){
        iCond=(Instancia) iCond.generarCodigoMetodo(Metodos.CAST/*algo */);
    }

    PLXC.out.println("if ("+iCond.getIDC()+ " == 0) goto" /*algo */);

    if(cuerpo!=null) cuerpo.generarCodigo();

    if(act!=null) act.generarCodigo();

    PLXC.out.println("goto "+etFor+";");
    PLXC.out.println(etFinal+";");

    return null;
    }
}
