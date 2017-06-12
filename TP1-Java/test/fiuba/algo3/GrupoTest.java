package fiuba.algo3;
import org.junit.Test;

import AlgoChat.AlgoChat;

import static org.junit.Assert.assertEquals;


public class GrupoTest {
	
	@Test
    public void testagregarContacto() throws Exception {

		AlgoChat algoChat = new AlgoChat("Lucas");
		
		algoChat.agregarContacto("Agustin");
		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
		
		assertEquals(2, algoChat.grupos.get(0).cantidadMiembros());
		
        
    }
	
	@Test
    public void testagregarEnviado() throws Exception {

		AlgoChat algoChat = new AlgoChat("Lucas");
		
		algoChat.agregarContacto("Agustin");
		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
		algoChat.enviarMensajeAGrupo("Mañana", "Que haces");
		
		assertEquals(1, algoChat.grupos.get(0).integrantes.get(0).cantidadTotalMensajesRecibidos());
		assertEquals(1, algoChat.grupos.get(0).devolverCantidadEnviados());
		
        
    }
	
	@Test
    public void testagregarRecibidoDe() throws Exception {

		AlgoChat algoChat = new AlgoChat("Lucas");
		
		algoChat.agregarContacto("Agustin");
		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "texto");
		
		assertEquals(1, algoChat.grupos.get(0).integrantes.get(0).cantidadDeMensajesEnviados());
		assertEquals(1, algoChat.grupos.get(0).devolverCantidadRecibidos());
		
        
    }
	
	@Test
    public void testcantidadMiembros() throws Exception {

		AlgoChat algoChat = new AlgoChat("Lucas");
		
		algoChat.agregarContacto("Agustin");
		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
		algoChat.agregarContacto("Agustin1");
		algoChat.agregarContacto("Agustin2");
		algoChat.agregarContacto("Agustin3");
		algoChat.agregarContacto("Agustin4");
		algoChat.agregarContactoAGrupo("Agustin1", "Mañana");
		algoChat.agregarContactoAGrupo("Agustin2", "Mañana");
		algoChat.agregarContactoAGrupo("Agustin3", "Mañana");
		algoChat.agregarContactoAGrupo("Agustin4", "Mañana");
		
		assertEquals(6, algoChat.grupos.get(0).cantidadMiembros());
		
        
    }
	
	@Test
    public void testdevolverCantidadEnviados() throws Exception {

		AlgoChat algoChat = new AlgoChat("Lucas");
		
		algoChat.agregarContacto("Agustin");
		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
		algoChat.enviarMensajeAGrupo("Mañana", "Que haces");
		algoChat.enviarMensajeAGrupo("Mañana", "Que haces");
		algoChat.enviarMensajeAGrupo("Mañana", "Que haces");
		algoChat.enviarMensajeAGrupo("Mañana", "Que haces");
		
		
		assertEquals(4, algoChat.grupos.get(0).devolverCantidadEnviados());
		
        
    }
	
	@Test
    public void testdevolverCantidadRecibidos() throws Exception {

		AlgoChat algoChat = new AlgoChat("Lucas");
		
		algoChat.agregarContacto("Agustin");
		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "texto");
		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "texto");
		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "texto");
		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "texto");
		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "texto");
		
		assertEquals(5, algoChat.grupos.get(0).devolverCantidadRecibidos());
		
        
    }
	
	@Test
    public void testrestarMensajeEnviado() throws Exception {

		AlgoChat algoChat = new AlgoChat("Lucas");
		
		algoChat.agregarContacto("Agustin");
		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
		algoChat.enviarMensajeAGrupo("Mañana", "Que haces");
		algoChat.enviarMensajeAGrupo("Mañana", "Que haces");
		algoChat.enviarMensajeAGrupo("Mañana", "Que haces");
		
		assertEquals(3, algoChat.grupos.get(0).integrantes.get(0).cantidadTotalMensajesRecibidos());
		assertEquals(3, algoChat.grupos.get(0).devolverCantidadEnviados());
		
		algoChat.grupos.get(0).restarMensajeEnviado();
		
		assertEquals(2, algoChat.grupos.get(0).integrantes.get(0).cantidadTotalMensajesRecibidos());
		assertEquals(2, algoChat.grupos.get(0).devolverCantidadEnviados());
		
		algoChat.grupos.get(0).restarMensajeEnviado();
		
		assertEquals(1, algoChat.grupos.get(0).integrantes.get(0).cantidadTotalMensajesRecibidos());
		assertEquals(1, algoChat.grupos.get(0).devolverCantidadEnviados());
		
        
    }
	
	@Test
    public void testRestarMensajeRecibidoDe() throws Exception {

		AlgoChat algoChat = new AlgoChat("Lucas");
		
		algoChat.agregarContacto("Agustin");
		algoChat.crearGrupo("Mañana");
		algoChat.agregarContactoAGrupo("Agustin", "Mañana");
		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "texto");
		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "texto");
		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "texto");
		algoChat.recibirMensajeDeGrupo("Mañana", "Agustin", "texto");
		
		assertEquals(4, algoChat.grupos.get(0).integrantes.get(0).cantidadDeMensajesEnviados());
		assertEquals(4, algoChat.grupos.get(0).devolverCantidadRecibidos());
		
		algoChat.grupos.get(0).restarMensajeRecibidoDe("Agustin");
		
		assertEquals(3, algoChat.grupos.get(0).integrantes.get(0).cantidadDeMensajesEnviados());
		assertEquals(3, algoChat.grupos.get(0).devolverCantidadRecibidos());
		
		algoChat.grupos.get(0).restarMensajeRecibidoDe("Agustin");
		
		assertEquals(2, algoChat.grupos.get(0).integrantes.get(0).cantidadDeMensajesEnviados());
		assertEquals(2, algoChat.grupos.get(0).devolverCantidadRecibidos());
        
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
