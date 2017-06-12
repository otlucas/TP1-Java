package fiuba.algo3;
import org.junit.Test;

import AlgoChat.AlgoChat;
import AlgoChat.ContactoNoExisteExcepcion;
import AlgoChat.ContactoYaExisteEnGrupo;
import AlgoChat.ContactoYaExisteExcepcion;
import AlgoChat.GrupoNoExisteExcepcion;
import AlgoChat.GrupoYaExisteExcepcion;

public class ContactoNoExisteExcepcionTest {
	
	@Test(expected=ContactoNoExisteExcepcion.class)
    public void testContactoNoExisteExcepcion() throws ContactoYaExisteExcepcion, GrupoYaExisteExcepcion, GrupoNoExisteExcepcion, ContactoNoExisteExcepcion, ContactoYaExisteEnGrupo {
    	
    	
        AlgoChat algoChat = new AlgoChat("Lucas");

		algoChat.recibirMensajeDe("Agustin", "texto");
        
    }

}
