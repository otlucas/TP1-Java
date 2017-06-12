package fiuba.algo3;
import org.junit.Test;

import AlgoChat.Mensaje;

import static org.junit.Assert.assertEquals;


public class MensajeTest {
	
	@Test
    public void testdevolverRemitente() {

		Mensaje mensaje = new Mensaje("Lucas", "Agustin", "Texto");
		
		assertEquals("Lucas", mensaje.devolverRemitente());
    }
	
	@Test
    public void testdevolverDestinatario() {

		Mensaje mensaje = new Mensaje("Lucas", "Agustin", "Texto");
		
		assertEquals("Agustin", mensaje.devolverDestinatario());
    }
	
	@Test
    public void testdevolverTexto() {

		Mensaje mensaje = new Mensaje("Lucas", "Agustin", "Texto");
		
		assertEquals("Texto", mensaje.devolverTexto());   
    }
}
