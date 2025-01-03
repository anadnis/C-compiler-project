public class TipoBool extends Tipo{  
    public static final TipoBool instancia = new TipoBool();

    private TipoBool(){
        super(Predefinidos.BOOL, 0, false);
    }

    @Override
    public Objeto generarCodigoInstancia(Instancia instancia,String metodo, Objeto[] param) throws Exception{
        return null;
    }

    @Override
    public Objeto generarCodigoMetodo (String metodo, Objeto[] param) throws Exception{
        return null;
    }
}


// tood igual que enetero incluyendo el cast, lo unico distinto es las operaciones lógicas ylog olog (carlos tiene muchas fotos 17 dic)