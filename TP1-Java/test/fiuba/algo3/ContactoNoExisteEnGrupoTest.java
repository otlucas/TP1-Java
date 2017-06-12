package fiuba.algo3;

import org.junit.Test;

import AlgoChat.AlgoChat;
import AlgoChat.ContactoNoExisteEnGrupo;
import AlgoChat.GrupoNoExisteExcepcion;
import AlgoChat.GrupoYaExisteExcepcion;

public class ContactoNoExisteEnGrupoTest {
	
	@Test(expected=ContactoNoExisteEnGrupo.class)
    public void testContactoNoExisteEnGrupo() throws GrupoYaExisteExcepcion, GrupoNoExisteExcepcion, ContactoNoExisteEnGrupo{
    	
    	
        AlgoChat algoChat = new AlgoChat("Lucas");
		
        algoChat.crearGrupo("Mañana");
        
        algoChat.recibirMensajeDeGrupo("Mañana","Agustin","Texto");
        
    }

}
