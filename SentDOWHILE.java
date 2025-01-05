import java.text.ParseException;

public class SentDOWHILE {
    public Objeto generarCodigo() throws Exception{
        String etWhile=Objeto.newEtiq();
        PLXC.out.println(etWhile+";");        
        cuerpo.generarCodigo();
        
        Objeto c=cond.generarCodigo();
        if(!(c instanceof Instancia)){
            throw new ParseException("La condicion de un while debe ser ...");
        }

        Instancia iCond=(Instancia) c;

        if(iCond.getTipo() != TipoBool.Instancia){
            iCond=(Instancia) iCond.generarCodigoMetodo(Metodos /*algo */);
        }
    
        PLXC.out.println("if ("+iCond.getIDC()+ " == 0) goto"+etWhile);
        
        PLXC.out.println("goto "+etWhile+";");
        PLXC.out.println(etFinal+" ");
    }
}
