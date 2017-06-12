package AlgoChat;

public class Usuario {

	String nombre;
	int cantidadmensajesenviados;
	int cantidadmensajesrecibidos;

	public Usuario(String nombredeusuario) {
		/** Le asigna la cadena pasada por parametro al usuario, como su nombre */
		this.nombre = nombredeusuario;
		this.cantidadmensajesenviados = 0;
		this.cantidadmensajesrecibidos = 0;
		
	}

	public int cantidadDeMensajesEnviados() {
		/** Devuelve la cantidad de mensajes enviados del usuario */
		return this.cantidadmensajesenviados;
	}

	public String devolverNombre() {
		/** Devuelve el nombre del usuario */
		return this.nombre;
	}

	public void agregarEnviado() {
		/** Agrega 1 a la cantidad de mensajes enviados */
		
		this.cantidadmensajesenviados += 1;
		
	}

	public void agregarRecibido() {
		/** Agrega 1 a la cantidad de mensajes recibidos */
		
		this.cantidadmensajesrecibidos += 1;
		
	}

	public int cantidadTotalMensajesRecibidos() {
		/** Devuelve la cantidad de mensajes recibidos del usuario */
		return this.cantidadmensajesrecibidos;
	}

}
