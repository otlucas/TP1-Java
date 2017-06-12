package fiuba.algo3;
import org.junit.Test;

import AlgoChat.Conversacion;
import AlgoChat.Grupo;
import AlgoChat.Mensaje;
import AlgoChat.Usuario;

import static org.junit.Assert.assertEquals;

public class ConversacionTest {
	
	@Test
    public void testdevolverNombreContacto() {
		
	Usuario usuario = new Usuario("Lucas");

        Conversacion conversacion = new Conversacion(usuario);
        
        assertEquals("Lucas", conversacion.devolverNombreContacto());
        
    }
	
	@Test
    public void testagregarMensaje() {
		
	Usuario usuario = new Usuario("Agustin");

        Conversacion conversacion = new Conversacion(usuario);
        
        Mensaje nuevoMensaje = new Mensaje("Lucas", "Agustin", "texto3");
        Mensaje nuevoMensaje1 = new Mensaje("Lucas", "Agustin", "texto2");
        Mensaje nuevoMensaje2 = new Mensaje("Lucas", "Agustin", "texto1");
        
        conversacion.agregarMensaje(nuevoMensaje);
        conversacion.agregarMensaje(nuevoMensaje1);
        conversacion.agregarMensaje(nuevoMensaje2);
        
        assertEquals(4, conversacion.obtenerConversacion(usuario).size());
        
    }
	
	@Test
    public void testobtenerConversacion() {
		
	Usuario usuario = new Usuario("Agustin");

        Conversacion conversacion = new Conversacion(usuario);
        
        Mensaje nuevoMensaje = new Mensaje("Lucas", "Agustin", "texto3");
        Mensaje nuevoMensaje1 = new Mensaje("Lucas", "Agustin", "texto2");
        Mensaje nuevoMensaje2 = new Mensaje("Lucas", "Agustin", "texto1");
        
        conversacion.agregarMensaje(nuevoMensaje);
        conversacion.agregarMensaje(nuevoMensaje1);
        conversacion.agregarMensaje(nuevoMensaje2);
        
        assertEquals("Lucas: texto1", conversacion.obtenerConversacion(usuario).get(1));
        assertEquals("Lucas: texto2", conversacion.obtenerConversacion(usuario).get(2));
        assertEquals("Lucas: texto3", conversacion.obtenerConversacion(usuario).get(3));
        
    }
	
	@Test
    public void testborrarConversacion() {
		
	Usuario usuario = new Usuario("Agustin");

        Conversacion conversacion = new Conversacion(usuario);
        
        Mensaje nuevoMensaje = new Mensaje("Lucas", "Agustin", "texto3");
        Mensaje nuevoMensaje1 = new Mensaje("Lucas", "Agustin", "texto2");
        Mensaje nuevoMensaje2 = new Mensaje("Lucas", "Agustin", "texto1");
        
        conversacion.agregarMensaje(nuevoMensaje);
        conversacion.agregarMensaje(nuevoMensaje1);
        conversacion.agregarMensaje(nuevoMensaje2);
        
        assertEquals(4, conversacion.obtenerConversacion(usuario).size());
        
        conversacion.borrarConversacion(usuario);
        
        assertEquals(1, conversacion.obtenerConversacion(usuario).size());
        
    }
	
	@Test
    public void testcantidadMensajesEnviados() {
		
	Usuario usuario = new Usuario("Agustin");

        Conversacion conversacion = new Conversacion(usuario);
        
        Mensaje nuevoMensaje = new Mensaje("Lucas", "Agustin", "texto3");
        Mensaje nuevoMensaje1 = new Mensaje("Lucas", "Agustin", "texto2");
        Mensaje nuevoMensaje2 = new Mensaje("Lucas", "Agustin", "texto1");
        
        conversacion.agregarMensaje(nuevoMensaje);
        conversacion.agregarMensaje(nuevoMensaje1);
        conversacion.agregarMensaje(nuevoMensaje2);
        
        assertEquals(3, conversacion.cantidadMensajesEnviados());
        
    }
	
	@Test
    public void testdevolverNombreGrupo() {
		
	Grupo grupo = new Grupo("Mañana");

        Conversacion conversacion = new Conversacion(grupo);
        
        assertEquals("Mañana", conversacion.devolverNombreDeGrupo());
        
    }
}
