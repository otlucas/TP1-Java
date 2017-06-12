package fiuba.algo3;
import org.junit.Test;

import AlgoChat.Usuario;

import static org.junit.Assert.assertEquals;


public class UsuarioTest {
	
	@Test
    public void testagregarEnviado() {

		Usuario usuario = new Usuario("Lucas");
		
		assertEquals(0, usuario.cantidadDeMensajesEnviados());
		
		usuario.agregarEnviado();
		
		assertEquals(1, usuario.cantidadDeMensajesEnviados());
		
		usuario.agregarEnviado();
		
		assertEquals(2, usuario.cantidadDeMensajesEnviados());
    }
	
	@Test
    public void testagregarRecibido() {

		Usuario usuario = new Usuario("Lucas");
		
		assertEquals(0, usuario.cantidadTotalMensajesRecibidos());
		
		usuario.agregarRecibido();
		
		assertEquals(1, usuario.cantidadTotalMensajesRecibidos());
		
		usuario.agregarRecibido();
		
		assertEquals(2, usuario.cantidadTotalMensajesRecibidos());
    }
	
	@Test
    public void testdevolverNombre() {

		Usuario usuario = new Usuario("Lucas");
		
		assertEquals("Lucas", usuario.devolverNombre());
		
    }

}
