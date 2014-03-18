package pt.ist.rest.domain;

public class Utilizador extends Utilizador_Base {
    
    public  Utilizador() {
        super();
    }
    
    protected void init(String user, String pass){
    	setUsername(user);
    	setPassword(pass);
    	
    }
	
	public boolean equals(Utilizador u){
		return this.getUsername().equals(u.getUsername());
	}
    
}
