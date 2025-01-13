
public class SentFORALL extends Instruccion {

    private Instruccion premisa, cuerpo;

    public SentFORALL(int linea, Instruccion premisa, Instruccion cuerpo){

        super(linea);
        this.premisa = premisa;
        this.cuerpo = cuerpo;
    }

    @Override
    public Objeto generarCodigo() throws Exception {

        Objeto condObj1, condObj2;
        Objeto variable;

        variable = premisa.generarCodigo();

        //VARIABLE FALSE
        PLXC.out.println(variable.getIDC() + " = 0;");
        condObj1 = cuerpo.generarCodigo();

        Etiqueta etq = new Etiqueta(Objeto.newEtiq(), condObj1.getBloque());
        Objeto result = condObj1.generarCodigoMetodo(Metodos.YLOG, new Objeto[]{etq}, getLinea()); // ($t1 = $t0; if($t0 == 0) goto Letq   -> $t1

        //VARIABLE VERDADERA
        PLXC.out.println(variable.getIDC() + " = 1;");
        condObj2 = cuerpo.generarCodigo();

        result.generarCodigoMetodo(Metodos.CONSTRUCTORCOPIA, new Objeto[]{condObj2}, getLinea()); // $t1 = $t2

        etq.generarCodigoMetodo(Metodos.PONERETIQ, null, getLinea()); // L: ...

        return result;
    }
}
    