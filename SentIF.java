import java.text.ParseException;

public class SentIF extends Instruccion{



//hay un metodo de dos lineas aqui inicializando pTrue, pFalse, etc pero no lo veo

@Override
public Objeto generarCodigo() throws Exception{
    Objeto c= cond.generarCodigo();
    String etFalse=Objeto.newEtiq();
    String etFinal=Objeto.newEtiq();

    if(!(c instanceof Instancia)){
        throw new ParseException("La condicion de un if ...");
    }

    Instancia iCond=(Instancia) c;

    if(iCond.getTipo() != TipoBool.Instancia){
        iCond=(Instancia) iCond.generarCodigoMetodo(Metodos.CAST/*algo */);
    }

    PLXC.out.println("if ("+iCond.getIDC()+ " == 0) goto" /*algo */);
    pTrue.generarCodigo();

    PLXC.out.println("goto "+etFinal+";");
    PLXC.out.println(etFalse+";");

    if(pFalse!=/*algo */) {pFalse.generarCodigo() /*algo */}
}
}