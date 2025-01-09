import java.text.ParseException;

public class SentDOWHILE extends Instruccion{
    Instruccion cuerpo,cond;

    public SentDOWHILE(int linea, Instruccion cuerpo, Instruccion cond) {
        super(linea);
        this.cuerpo = cuerpo;
        this.cond = cond;
    }

    @Override
    public Objeto generarCodigo() throws Exception{
        String etWhile=Objeto.newEtiq();
        PLXC.out.println(etWhile+";");        
        cuerpo.generarCodigo();
        
        Objeto c=cond.generarCodigo();
        if(!(c instanceof Instancia)){
            throw new ParseException("La condicion de un while debe ser una instancia (literal o variable)", getLinea());
        }

        Instancia iCond=(Instancia) c;

        if(iCond.getTipo() != TipoBool.instancia){
            iCond=(Instancia) iCond.generarCodigoMetodo(Metodos.CAST, new Objeto[]{TipoBool.instancia}, getLinea());
        }
    
        PLXC.out.println("if ("+iCond.getIDC()+ " == 0) goto"+etWhile+";");
        
        //PLXC.out.println("goto "+etWhile+";");
        //PLXC.out.println(etFinal+" ");
        return null;
    }
}
