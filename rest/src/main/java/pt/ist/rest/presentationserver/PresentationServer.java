package pt.ist.rest.presentationserver;

import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import jvstm.Atomic;
import pt.ist.rest.domain.*;
import pt.ist.rest.exception.*;



public class PresentationServer {

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
		
		

    	registaBarrigaCheia();
		imprimeUtilizadores();
		imprimeRestaurantes();
		adicionaBitoque();	
		escreveClassificacao();
		gostarPratos();
		gostarPratos2();
		escreveClassificacao2();

   }
	
	@Atomic
	public static void registaBarrigaCheia() {			
		Rest rest = FenixFramework.getRoot();
		Restaurante restaurante = new Restaurante("Barriga Cheia","Porto,Portugal");
		try{
			rest.addRestaurante(restaurante, "pp");
		}catch(RestaurantAlreadyExistsException e){
			System.out.println(e.toString());
		}catch(ManagerNotFoundException e){
			System.out.println(e.toString());
		}catch(BusyManagerException e){
			System.out.println(e.toString());
		}
		
	}
   
    @Atomic
	public static void imprimeUtilizadores(){
		Rest rest = FenixFramework.getRoot();
		rest.imprimeUtilizadores();	
	}
	
	@Atomic
	public static void imprimeRestaurantes(){
		Rest rest = FenixFramework.getRoot();
		rest.imprimeRestaurantes();
	}
	
	
    @Atomic
	public static void adicionaBitoque(){
		Rest rest = FenixFramework.getRoot();
		
		try{
			rest.adicionaPratoRestaurante("pp", "Barriga Cheia", 
											new Prato("Bitoque",new Integer(14) ,new Integer(14),rest.incrementaIDPrato()));
		}catch (RestaurantNotFoundException e){
			System.out.println(e.toString());

		}catch (DishesNumberExceedException e){
			System.out.println(e.toString());
			
		}catch (ManagerNotFoundException e){
			System.out.println(e.toString());
			
		}catch (ManagerHasNoAccessException e){
			System.out.println(e.toString());
		}
	}
	
	@Atomic
	public static void escreveClassificacao(){
		Rest rest = FenixFramework.getRoot();
		final int classificacaoCheia;
		final int classificacaoFeliz;
		
		try{
			classificacaoCheia = rest.calculaClassificacao("Barriga Cheia");
			classificacaoFeliz = rest.calculaClassificacao("Barriga Feliz");
			
			System.out.println("Classificacao do restaurante barrigaCheia:"+classificacaoCheia);
			System.out.println("Classificacao do restaurante barrigaFeliz:"+classificacaoFeliz);
       }catch (RestaurantNotFoundException e){
			System.out.println(e.toString());
	   }
	
	}
	
	@Atomic
	public static void gostarPratos(){
		Rest rest = FenixFramework.getRoot();
		
		try{
			rest.clienteGostaDePrato("zeze","Barriga Feliz","Bacalhau com batatas");
			rest.clienteGostaDePrato("zeze","Barriga Feliz","Canja de galinha");
			rest.clienteGostaDePrato("zeze","Barriga Feliz","Bitoque");
			
		}catch (RestaurantNotFoundException e){
			System.out.println(e.toString());
			
		}catch (ManagerNotFoundException e){
			System.out.println(e.toString());
			
		}catch (DishNotFoundException e){
			System.out.println(e.toString());
			
		}catch (ClientAlreadyLikesDishException e){
			System.out.println(e.toString());
			
		}catch (ClientNotFoundException e){
			System.out.println(e.toString());
			
		}catch (LikesNumberExceedException e){
			System.out.println(e.toString());
		}
	}
	
	@Atomic
	public static void gostarPratos2(){
		Rest rest = FenixFramework.getRoot();
		try{
			rest.clienteGostaDePrato("mariazinha","Barriga Feliz","Canja de galinha");
		
		}catch (RestaurantNotFoundException e){
			System.out.println(e.toString());
				
		}catch (DishNotFoundException e){
			System.out.println(e.toString());
			
		}catch (ClientAlreadyLikesDishException e){
			System.out.println(e.toString());
			
		}catch (ClientNotFoundException e){
			System.out.println(e.toString());
			
		}catch (LikesNumberExceedException e){
			System.out.println(e.toString());
		}
	}
	
	@Atomic
	public static void escreveClassificacao2(){
		Rest rest = FenixFramework.getRoot();
		final int classificacaoCheia;
		final int classificacaoFeliz;
		
		try{
			classificacaoCheia = rest.calculaClassificacao("Barriga Cheia");
			classificacaoFeliz = rest.calculaClassificacao("Barriga Feliz");
			
			System.out.println("Classificacao do restaurante barrigaCheia:"+classificacaoCheia);
			System.out.println("Classificacao do restaurante barrigaFeliz:"+classificacaoFeliz);
       }catch (RestaurantNotFoundException e){
			System.out.println(e.toString());
	   }  
    
	
	}
}



    			
 
