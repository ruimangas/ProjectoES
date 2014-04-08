package pt.ist.rest.service;

import java.util.ArrayList;
import java.util.List;

import pt.ist.rest.domain.Cliente;
import pt.ist.rest.domain.Prato;
import pt.ist.rest.domain.Rest;
import pt.ist.rest.domain.Item;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.DishNotFoundException;
import pt.ist.rest.exception.RestaurantNotFoundException;
import pt.ist.rest.service.dto.*;
import pt.ist.fenixframework.FenixFramework;

public class ListaTabuleiroService extends RestService {

	private ClienteDto cliDto;	
	
	public ListaTabuleiroService(ClienteDto cliDto){
		this.cliDto = cliDto;
	}
	
	
	private TabuleiroDto result;
	
	public final void dispatch(){

		Rest rest = FenixFramework.getRoot();
		final Cliente cliente = rest.procuraClientePorNome(cliDto.getUser());
	    
		List<ItemDto> items = new ArrayList<ItemDto>();
		
		for(Item i: cliente.getCompraAberta().getItem()){
			
			ItemDto item = new ItemDto(i.getPrato().getNome(),i.getPrato().getPreco(),i.getPrato().getIDPrato(),i.getQuantidade());
			items.add(item);
			
		}
		
		result = new TabuleiroDto(cliente.getSaldo(),cliente.getCompraAberta().getCusto(),items);
     }
	
	public TabuleiroDto getResult(){
		return result;
	}
}