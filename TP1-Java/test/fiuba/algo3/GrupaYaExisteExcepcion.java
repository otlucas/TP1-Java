package fiuba.algo3;
import org.junit.Test;

import AlgoChat.AlgoChat;
import AlgoChat.ContactoYaExisteExcepcion;
import AlgoChat.GrupoYaExisteExcepcion;

public class GrupaYaExisteExcepcion {
	
	@Test(expected=GrupoYaExisteExcepcion.class)
    public void testGrupoYaExisteExcepcion() throws ContactoYaExisteExcepcion, GrupoYaExisteExcepcion {
    	
    	
        AlgoChat algoChat = new AlgoChat("Lucas");

		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Tomas");
		
        algoChat.crearGrupo("Mañana");
        algoChat.crearGrupo("Mañana");
        
        
    }

}
