public class TipoReal extends Tipo{  
    public static final TipoChar instancia = new TipoReal();

    private TipoReal(){
        super(Predefinidos.REAL, 0, false);
    }

    @Override
    public Objeto generarCodigoInstancia (Instancia instancia,String metodo, Objeto[] param) throws Exception{
        return null;
    }

    @Override
    public Objeto generarCodigoMetodo (String metodo, Objeto[] param) throws Exception{
        return null;
    }
}


//de tipo int casi igual pero cambiar cast , el plxc . out tinee un +r, -r, 