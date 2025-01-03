import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

public class Etiqueta extends Objeto{
    private boolean puesta;

    public Etiqueta (String nombre , int bloque){
        super(nombre,bloque,false);
        puesta = false;
    }

    @Override
    public String getIDC(){
        return getNombre();
    }

    @Override
    public Objeto generarCodigoMetodo (String metodo, Objecto[] param, /*int algo mas*/ ){
        switch(metodo){
            case Metodos.PONERETIQ:
            if(puesta){
                throw new ParseException("las etiquetas solo se pueden ...");
            }
            puesta=true;
            PLXC.out.println(getIDC() + " ");
            break;
            case Metodos.SALTARETIQ:
            PLXC.out.println("goto "+getIDC()+ ";");
            break;
            default:
            throw new ParserConfigurationException("Metodo "+metodo+"...");
        }
        return null;
    }





}






