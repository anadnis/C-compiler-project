
public class SentINTFORALL extends Instruccion {

    private Instruccion premisa;  // Contiene la variable que será iterada (x en este caso)
    private Instruccion cuerpo;   // Contiene la condición a evaluar
    private int inicio;           // Valor inicial del rango (0)
    private int fin;              // Valor final del rango (10)
    private int paso;             // Incremento en cada iteración (2)

    public SentINTFORALL(int linea, Instruccion premisa, Instruccion cuerpo, int inicio, int fin, int paso) {
        super(linea);
        this.premisa = premisa;
        this.cuerpo = cuerpo;
        this.inicio = inicio;
        this.fin = fin;
        this.paso = paso;
    }

    @Override
    public Objeto generarCodigo() throws Exception {
       /*  Objeto v;
        Objeto variable;
        Objeto condObj1;
        Objeto condObj;

        // Inicializamos la variable (x = 0)
        variable = premisa.generarCodigo(); // -> $t0 
        PLXC.out.println(variable.getIDC() + " = " + inicio + ";");  // x = 0;

        // Etiqueta del bucle (L0)
        Etiqueta etqBucle = new Etiqueta(Objeto.newEtiq(), variable.getBloque());  // L0
        PLXC.out.println(etqBucle.getIDC() + ":");

        // Condición para salir del bucle si x > fin (if (10 < x) goto L1)
        Etiqueta etqExito = new Etiqueta(Objeto.newEtiq(), variable.getBloque());  // L1: Fin exitoso
        PLXC.out.println("if (" + fin + " < " + variable.getIDC() + ") goto " + etqExito.getIDC() + ";");

        // Generamos la operación cuerpo: $t0 = x / 2; $t1 = 2 * $t0; $t2 = x - $t1;
        condObj1 = cuerpo.generarCodigo();
        // Comprobamos si el resultado de la operación es 0: if ($t2 == 0) goto L2;
        Etiqueta etqSiguienteIteracion = new Etiqueta(Objeto.newEtiq(), condObj1.getBloque());  // L2
        PLXC.out.println("if (" + condObj1.getIDC() + " == 0) goto " + etqSiguienteIteracion.getIDC() + ";");
        private String newNomObj() {
            // Implement the logic to generate a new object name
            // Return the generated object name
        }

        Objeto result = condObj1.generarCodigoMetodo(Metodos.YLOG, new Objeto[]{etq}, getLinea()); // ($t1 = $t0; if($t0 == 0) goto Letq   -> $t1

        // Si no es 0, saltamos a la etiqueta L3 (fallo) y terminamos devolviendo falso
        Etiqueta etqFallo = new Etiqueta(Objeto.newEtiq(), condObj1.getBloque());  // L3
        PLXC.out.println("goto " + etqFallo.getIDC() + ";");

        // Etiqueta L2: Si la condición es verdadera, incrementamos x en el paso (x = x + 2) y repetimos
        PLXC.out.println(etqSiguienteIteracion.getIDC() + ":");

        v = new Variable(newNomObj(), variable.getBloque(), false, TipoBool.instancia);
        PLXC.out.println(v.getIDC() + " = " + variable.getIDC() + ";");

        return v;*/
        return null;
    }
}
