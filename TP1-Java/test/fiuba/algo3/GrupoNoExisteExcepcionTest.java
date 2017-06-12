package fiuba.algo3;
import org.junit.Test;

import AlgoChat.AlgoChat;
import AlgoChat.ContactoNoExisteEnGrupo;
import AlgoChat.GrupoNoExisteExcepcion;

public class GrupoNoExisteExcepcionTest {
	
	@Test(expected=GrupoNoExisteExcepcion.class)
    public void testContactoNoExisteEnGrupo() throws GrupoNoExisteExcepcion, ContactoNoExisteEnGrupo {
    	
    	
        AlgoChat algoChat = new AlgoChat("Lucas");
        
        algoChat.recibirMensajeDeGrupo("Mañana","Agustin","Texto");
        
    }

}
