public class Literal extends Instancia {
	private Object valor;
	
	public Literal (int bloque, Tipo tipo, Object valor) {
		super(newNomObj(), bloque, false, tipo);
		this.valor = valor;
	}
	
	public Object getValor() {
		return valor;
	}

    @Override
    public Objeto generarCodigoMetodo(String metodo, Objeto[] param,int linea) throws Exception {
        return getTipo().generarCodigoInstancia(this,metodo,param,linea);
    }

}