package fiuba.algo3;
import org.junit.Test;

import AlgoChat.AlgoChat;
import AlgoChat.ContactoYaExisteExcepcion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlgoChatTest {

	@Test
    public void testagregarContacto() {

        AlgoChat algoChat = new AlgoChat("Lucas");
        
        try {
		algoChat.agregarContacto("Roberto");
	} catch (ContactoYaExisteExcepcion e) {
		e.printStackTrace();
	}

        assertEquals(1, algoChat.cantidadDeContactos());
        assertEquals("Lucas", algoChat.nombreUsuario());
    }

    @Test
    public void testagregarContactoAGrupo() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
			
		assertEquals(1, algoChat.cantidadDeContactos());
		assertEquals(2, algoChat.cantidadMiembrosEnGrupo("Mañana"));
			
	} catch (Exception e) {
	}
    }

    @Test
    public void testborrarMensajesDelContacto() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Marcio");
		
		algoChat.recibirMensajeDe("Marcio", "Estas en tu casa?");
		algoChat.recibirMensajeDe("Marcio", "HOLA?");
		

		assertEquals(2, algoChat.cantidadTotalMensajesRecibidos());
		assertEquals(2, algoChat.cantidadMensajesDe("Marcio"));

		algoChat.borrarMensajesDelContacto("Marcio");
		
		assertEquals(0, algoChat.cantidadTotalMensajesRecibidos());
		assertEquals(0, algoChat.cantidadMensajesDe("Marcio"));
			
	} catch (Exception e) {
	}
    }

    @Test
    public void testobtenerConversacionCon() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
		
		algoChat.recibirMensajeDe("Agustin", "Estas?");
		algoChat.enviarMensajeA("Agustin", "Si.");
		algoChat.enviarMensajeA("Agustin", "Que pasa?");


		assertEquals("Yo: Que pasa?", algoChat.obtenerConversacionCon("Agustin").get(1));
		assertEquals("Yo: Si.", algoChat.obtenerConversacionCon("Agustin").get(2));
		assertEquals("Agustin: Estas?", algoChat.obtenerConversacionCon("Agustin").get(3));
        } catch (Exception e) {
		}
    }

    @Test
    public void testborrarMensajesDelGrupo() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
		
		algoChat.agregarContacto("Tomas");

		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
		algoChat.agregarContactoAGrupo("Tomas", "Mañana");

		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "Hola");
		algoChat.recibirMensajeDeGrupo("Mañana", "Tomas", "Que haces");
		algoChat.enviarMensajeAGrupo("Mañana", "Que haces");

		assertEquals(2, algoChat.cantidadMensajesRecibidosDelGrupo("Mañana"));
		assertEquals(1, algoChat.cantidadMensajesEnviadosAlGrupo("Mañana"));
        
		algoChat.borrarMensajesDelGrupo("Mañana");
			
		assertEquals(0, algoChat.cantidadMensajesRecibidosDelGrupo("Mañana"));
		assertEquals(0, algoChat.cantidadMensajesEnviadosAlGrupo("Mañana"));
			
        } catch (Exception e) {
		}
    }
    
    @Test
    public void testcantidadDeMensajesDe() {
    	
    	AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
		
		algoChat.recibirMensajeDe("Agustin", "Estas?");
		algoChat.enviarMensajeA("Agustin", "Si.");
		algoChat.enviarMensajeA("Agustin", "Que pasa?");
		algoChat.recibirMensajeDe("Agustin", "Nada");
        
		assertEquals(2, algoChat.cantidadMensajesDe("Agustin"));
			
        } catch (Exception e) {
		}
    }
    
    
    @Test
    public void testcantidadDeMensajesEnviadosA() {
    	
    	AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
		
		algoChat.recibirMensajeDe("Agustin", "Estas?");
		algoChat.enviarMensajeA("Agustin", "Si.");
		algoChat.enviarMensajeA("Agustin", "Que pasa?");
        	algoChat.recibirMensajeDe("Agustin", "Nada");
        
        	assertEquals(2, algoChat.cantidadMensajesEnviadosA("Agustin"));
        
        } catch (Exception e) {
	}
    }
    
    @Test
    public void testcantidadMensajesEnviadosAlGrupo() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
	
		algoChat.agregarContacto("Tomas");

		algoChat.crearGrupo("Mañana");
		algoChat.enviarMensajeAGrupo("Mañana", "A");
		algoChat.enviarMensajeAGrupo("Mañana", "A");
		algoChat.enviarMensajeAGrupo("Mañana", "A");

		assertEquals(3, algoChat.cantidadMensajesEnviadosAlGrupo("Mañana"));
			
        } catch (Exception e) {
	}
    }
    
    @Test
    public void testcantidadMensajesRecibidosDelGrupo() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
        	algoChat.agregarContacto("Tomas");

        	algoChat.crearGrupo("Mañana");
        	algoChat.agregarContactoAGrupo("Agustin", "Mañana");
        	algoChat.agregarContactoAGrupo("Tomas", "Mañana");

        	algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "Hola");
        	algoChat.recibirMensajeDeGrupo("Mañana", "Tomas", "Que haces");

        	assertEquals(2, algoChat.cantidadMensajesRecibidosDelGrupo("Mañana"));
        	
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testrecibirMensajeDeGrupo() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
		
		algoChat.agregarContacto("Tomas");

        	algoChat.crearGrupo("Mañana");
        	algoChat.agregarContactoAGrupo("Agustin", "Mañana");
        	algoChat.agregarContactoAGrupo("Tomas", "Mañana");

        	algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "Hola");
        	algoChat.recibirMensajeDeGrupo("Mañana", "Tomas", "Que haces");

        	assertEquals("Agustin: Hola", algoChat.obtenerConversacionConGrupo("Mañana").get(2));
        	assertEquals("Tomas: Que haces", algoChat.obtenerConversacionConGrupo("Mañana").get(1));
        
        } catch (Exception e) {
	}
    }
    
    @Test
    public void testenviarMensajeAGrupo() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
	
		algoChat.agregarContacto("Tomas");

		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
		algoChat.agregarContactoAGrupo("Tomas", "Mañana");

		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "Hola");
		algoChat.recibirMensajeDeGrupo("Mañana", "Tomas", "Que haces");
		algoChat.enviarMensajeAGrupo("Mañana", "A");
		algoChat.enviarMensajeAGrupo("Mañana", "A");

		assertEquals("Yo: A", algoChat.obtenerConversacionConGrupo("Mañana").get(2));
		assertEquals("Yo: A", algoChat.obtenerConversacionConGrupo("Mañana").get(1));
        } catch (Exception e) {
	}
    }
    
    @Test
    public void testexisteGrupo() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
		algoChat.agregarContacto("Tomas");

        	algoChat.crearGrupo("Mañana");

        	assertTrue(algoChat.existeGrupo("Mañana"));
        	
        } catch (Exception e) {
	}
    }
    
    @Test
    public void testenviarMensajeA() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
		
		algoChat.enviarMensajeA("Agustin", "Si.");
        	algoChat.enviarMensajeA("Agustin", "Que pasa?");

        	assertEquals("Yo: Que pasa?", algoChat.obtenerConversacionCon("Agustin").get(1));
        	assertEquals("Yo: Si.", algoChat.obtenerConversacionCon("Agustin").get(2));
        
        } catch (Exception e) {
	}
    }
    
    @Test
    public void testrecibirMensajeDe() {

        AlgoChat algoChat = new AlgoChat("Lucas");

        try {
		algoChat.agregarContacto("Agustin");
		
		algoChat.recibirMensajeDe("Agustin", "Estas?");
        	algoChat.recibirMensajeDe("Agustin", "Estas?");
        
        	assertEquals("Agustin: Estas?", algoChat.obtenerConversacionCon("Agustin").get(1));
        	assertEquals("Agustin: Estas?", algoChat.obtenerConversacionCon("Agustin").get(2));
        
        } catch (Exception e) {
	}
    }
    
    @Test
    public void testcantidadTotalMensajesRecibidos() {

        AlgoChat algoChat = new AlgoChat("Lucas");
        
        try {
		algoChat.agregarContacto("Agustin");
		
		algoChat.agregarContacto("Tomas");

        	algoChat.crearGrupo("Mañana");
        	algoChat.agregarContactoAGrupo("Agustin", "Mañana");
        	algoChat.agregarContactoAGrupo("Tomas", "Mañana");

        	algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "Hola");
        	algoChat.recibirMensajeDeGrupo("Mañana", "Tomas", "Que haces");
        	algoChat.enviarMensajeAGrupo("Mañana", "A");
        	algoChat.enviarMensajeAGrupo("Mañana", "A");

        	algoChat.recibirMensajeDe("Agustin", "Estas?");
        	algoChat.recibirMensajeDe("Agustin", "Estas?");
        
        	assertEquals(4, algoChat.cantidadTotalMensajesRecibidos());
        
        } catch (Exception e) {
	}
    }
    
    @Test
    public void testcantidadDeMensajesEnviados() {

        AlgoChat algoChat = new AlgoChat("Lucas");
        
        try {
		algoChat.agregarContacto("Agustin");
		
		algoChat.agregarContacto("Tomas");

        	algoChat.crearGrupo("Mañana");
        	algoChat.agregarContactoAGrupo("Agustin", "Mañana");
        	algoChat.agregarContactoAGrupo("Tomas", "Mañana");

        	algoChat.enviarMensajeAGrupo("Mañana", "A");
        	algoChat.enviarMensajeAGrupo("Mañana", "A");
        
        	algoChat.enviarMensajeA("Agustin", "Que pasa?");
        	algoChat.enviarMensajeA("Agustin", "Que pasa?");

        
        	assertEquals(4, algoChat.cantidadDeMensajesEnviados());
        
        } catch (Exception e) {
	}
    }   
}
