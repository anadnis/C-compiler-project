public class TipoChar extends Tipo{  
    public static final TipoChar instancia = new TipoChar();

    private TipoChar(){
        super(Predefinidos.CARACTER, 0, false);
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

//el impirmir le ha puesto un printc el cast ha cambiado la logica, de caractera  acaracter y de caractera  entero, 