//faltan cosas

try{
    Reader in =new InputStreamReader(System.in);
    out=System.out;
    if(argv.length>0){
        in=new FileReader(argv [0]);
    }
    if(argv.length>1){
        out=new PrintStream (new FileOutputStream)(argv[1]);
    }
    lex=new Yylex(in);
    //faltan dos lineas que no se ven en la foto
    result.generarCodigo();
}catch(ParseException e){
    System.err.println("Error: "+e.getMessage());
    System.err.println("Linea entrada: "+e.getErrorOffset());
    e.printStackTrace();

    out.println("error analisis");
    out.println("error");
    out.println("halt");
}catch(Exception e){
    System.err.println("Error: "+e.getMessage());
    e.printStackTrace();
    //falta mas
}

//Instruccion result = () p.parse(Instruccion).value;
result.generarCodif//lo tine carlos