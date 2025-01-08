public class TipoChar extends Tipo{  
    public static final TipoChar instancia = new TipoChar();

    private TipoChar(){
        super(Predefinidos.CARACTER, 0, false);
    }

    @Override
    public Objeto generarCodigoInstancia (Instancia instancia,String metodo, Objeto[] param,int linea) throws Exception{
        //tambien switch enorme con CONSTLITERAL, CAST, etc pero no se ve un carajo, es muy parecido a los otros tipo
        return null;
    }

    @Override
    public Objeto generarCodigoMetodo (String metodo, Objeto[] param,int linea ) throws Exception{
        return null;
    }
}

//el impirmir le ha puesto un printc el cast ha cambiado la logica, de caractera  acaracter y de caractera  entero, 