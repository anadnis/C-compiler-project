public abstract clas Intruccion{
    private int linea;

    Instruccion(int linea){
        this.linea = linea;
    }

    public int getLinea(){
        return linea;
    }

    public abstract Objeto generarCodigo() throws Exception;

}