import java.text.ParseException;

public class SentWHILE extends Instruccion{
    Instruccion cond, cuerpo;

    public SentWHILE(int linea, Instruccion cond, Instruccion cuerpo){
        super(linea);
        this.cond=cond;
        this.cuerpo=cuerpo;
    }

    @Override
    public Objeto generarCodigo() throws Exception{
        String etWhile=Objeto.newEtiq();
        String etFinal=Objeto.newEtiq();

        PLXC.out.println(etWhile+":");
        Objeto c=cond.generarCodigo();
        if(!(c instanceof Instancia)){
            throw new ParseException("La expresión del while debe ser una instancia (literal o variable)", getLinea());
        }

        Instancia iCond=(Instancia) c;

        if(iCond.getTipo() != TipoBool.instancia){
            iCond=(Instancia) iCond.generarCodigoMetodo(Metodos.CAST, new Objeto[]{TipoBool.instancia}, getLinea());
        }
    
        PLXC.out.println("if ("+iCond.getIDC()+ " == 0) goto"+etFinal); //no se si es etWhile o etFinal
        cuerpo.generarCodigo();
        
        PLXC.out.println("goto "+etWhile+";");
        PLXC.out.println(etFinal+" ");

        return null;
    }
}


