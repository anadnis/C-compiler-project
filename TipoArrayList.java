public class TipoArrayList extends Tipo{
        //faltan lineas
        public Objeto generarCodigoInstancia(Instancia instancia,String metodo, Objeto[] param) throws Exception{
        //faltan lineas
        etiqC=newEtiq();
        etiqF=newEtiq();

        if(this.getTipoBase() instanceof TipoArray){
            aDes=new VariableArray(va.getNombre(), vIndD, va.getBloque()/*algo */);
        }else{
            aDes=new VariableArray(va.getNombre(),vIndD,va.getBloque()/*añgo */, new TipoEArray(newNomObj(),/*algo */));
        }

        PLXC.out.println("if ("+par.getIDC()+" < 0) goto "+ /*algo */);
        PLXC.out.println("if ("+par.getIDC()+" < "+ this.getSize() /*algo */);
        PLXC.out.println("error: ");
        PLXC.out.println("halt: ");
        PLXC.out.println(etiqC+";");
        PLXC.out.println(vIndD+ " = "+va.getVDesplazamiento()+/*algo */);
        vSizeD=(Variable) aDes.getTipo().generarCodigoMetodo(Metodo,/*algo */);
        PLXC.out.println(vDesp+" = "+vSizeD.getIDC()+"algo"/*algo */);
        PLXC.out.println(vIndD+" = "+vIndD+"algo"+vDesp+";");            
        PLXC.out.println("goto "+etiqC+";");
        

        return param[0];
        //faltan lineas
            

    }

        @Override
        public Objeto generarCodigoMetodo(String metodo, Objeto[] param) throws Exception {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'generarCodigoMetodo'");
        }
}
