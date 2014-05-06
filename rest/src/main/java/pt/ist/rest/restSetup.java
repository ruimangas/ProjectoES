package pt.ist.rest;



import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import jvstm.Atomic;


import pt.ist.rest.domain.*;

public class restSetup {

    public final static String DBUSER = "rest";
	public final static String DBPASS = "r3st";
	public final static String DBURL = "//localhost:3306/restdb";
	public final static String DMLPATH = "src/main/dml/rest.dml";

    public static void main(String[] args) {
				FenixFramework.initialize(new Config() {{
                dbAlias = DBURL;
                dbUsername = DBUSER;
                dbPassword = DBPASS;
    		    domainModelPath = DMLPATH;
    		    rootClass=Rest.class;
    	}});

    	populateDomain();
    }
    
    @Atomic
    public static void populateDomain() {
		try{
           Rest rest = FenixFramework.getRoot();

           Gestor mng = new Gestor("Passos Lebre","mng","nm8");
           Gestor pp = new Gestor("Paulo Portao","pp","pp");

           Cliente zeze = new Cliente("Ze Ninguem","Lisboa,Portugal","zeze","ze.ninguem@ist.utl.pt","z3z3",new Integer(1111));
           Cliente maria = new Cliente("Maria Silva","Porto,Portugal","mariazinha","maria.silva@ist.utl.pt","****",new Integer(2222));
           Cliente alice = new Cliente("Alice Alves","Aveiro,Portugal","alice","alice.alves@sonet.pt","aaa",new Integer(1001));
           Cliente bruno = new Cliente("Bruno Bento","Beja,Portugal","bruno","bruno.bento@sonet.pt","bbb",new Integer(1002));
           Cliente carlos = new Cliente("Carlos Calado","Coimbra,Portugal","carlos","carlos.calado@sonet.pt","ccc",new Integer(1003));

           Prato bacalhauF = new Prato("Bacalhau com batatas",new Integer(14) ,new Integer(14),rest.incrementaIDPrato());
           Prato bacalhauC = new Prato("Bacalhau com batatas",new Integer(14) ,new Integer(14),rest.incrementaIDPrato());
           Prato bitoque = new Prato("Bitoque",new Integer(14) ,new Integer(14),rest.incrementaIDPrato());
           Prato canja = new Prato("Canja de Galinha",new Integer(14) ,new Integer(14),rest.incrementaIDPrato());
		
           Restaurante cheia = new Restaurante("Barriga Cheia","Lisboa,Portugal");
           Restaurante feliz = new Restaurante("Barriga Feliz","Lisboa,Portugal");

           rest.addRestaurante(cheia);
           rest.addRestaurante(feliz);

           rest.addCliente(zeze);
           rest.addCliente(maria);
           rest.addCliente(alice);
           rest.addCliente(bruno);
           rest.addCliente(carlos);

           cheia.addGestor(mng);
           feliz.addGestor(pp);

           mng.getRestaurante().adicionaPrato(bacalhauC);
           pp.getRestaurante().adicionaPrato(bacalhauF);
           pp.getRestaurante().adicionaPrato(bitoque);
           pp.getRestaurante().adicionaPrato(canja);
        }catch (Exception e){
         System.out.println(e.getMessage());
    	   }
    }
	
}

