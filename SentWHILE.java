import java.lang.classfile.Instruction;
import java.text.ParseException;

public class SentWHILE extends Instruction{
    Instruction cond, cuerpo;

    private SentWHILE(/*algo */linea, Instruction cond,/*algo */ cuerpo){
        super(linea);
        this.cond=cond;
        this.cuerpo=cuerpo;
    }

    @Override
    public Objeto generarCodigo() throws Exception{
        String etWhile=Objeto.newEtiq();
        String etFinal=Objeto.newEtiq();

        PLXC.out.println(etWhile+";");
        Objeto c=cond.generarCodigo();
        if(!(c instanceof Instancia)){
            throw new ParseException("La condicion de un while debe ser ...");
        }

        Instancia iCond=(Instancia) c;

        if(iCond.getTipo() != TipoBool.Instancia){
            iCond=(Instancia) iCond.generarCodigoMetodo(/*algo */);
        }
    
        PLXC.out.println("if ("+iCond.getIDC()+ " == 0) goto"+etWhile);
        cuerpo.generarCodigo();
        
        PLXC.out.println("goto "+etWhile+";");
        PLXC.out.println(etFinal+" ");
    }
}


