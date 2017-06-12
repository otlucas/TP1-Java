package fiuba.algo3;
import org.junit.Test;

import AlgoChat.AlgoChat;
import AlgoChat.ContactoNoExisteExcepcion;
import AlgoChat.ContactoYaExisteEnGrupo;
import AlgoChat.ContactoYaExisteExcepcion;
import AlgoChat.GrupoNoExisteExcepcion;
import AlgoChat.GrupoYaExisteExcepcion;

public class ContactoYaExisteEnGrupoTest {
	
	@Test(expected=ContactoYaExisteEnGrupo.class)
    public void testContactoYaExisteEnGrupo() throws ContactoYaExisteExcepcion, GrupoYaExisteExcepcion, GrupoNoExisteExcepcion, ContactoNoExisteExcepcion, ContactoYaExisteEnGrupo {
    	
    	
        AlgoChat algoChat = new AlgoChat("Lucas");

		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Tomas");
		
        algoChat.crearGrupo("Mañana");
        algoChat.agregarContactoAGrupo("Agustin", "Mañana");
        algoChat.agregarContactoAGrupo("Agustin", "Mañana");
        
    }

}
