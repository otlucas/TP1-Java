package fiuba.algo3;
import org.junit.Test;

import AlgoChat.AlgoChat;
import AlgoChat.ContactoNoExisteExcepcion;
import AlgoChat.ContactoYaExisteEnGrupo;
import AlgoChat.ContactoYaExisteExcepcion;
import AlgoChat.GrupoNoExisteExcepcion;
import AlgoChat.GrupoYaExisteExcepcion;

public class ContactoYaExisteExcepcionTest {
	
	@Test(expected=ContactoYaExisteExcepcion.class)
    public void testContactoYaExisteExcepcion() throws ContactoYaExisteExcepcion, GrupoYaExisteExcepcion, GrupoNoExisteExcepcion, ContactoNoExisteExcepcion, ContactoYaExisteEnGrupo {
    	
    	
        AlgoChat algoChat = new AlgoChat("Lucas");

		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Agustin");
        
    }

}
