package AlgoChat;

public class Usuario {

	String nombre;
	int cantidadmensajesenviados;
	int cantidadmensajesrecibidos;
	Conversacion conversacion;

	public Usuario(String nombredeusuario) {
		/** Le asigna la cadena pasada por parametro al usuario, como su nombre */
		this.nombre = nombredeusuario;
		this.cantidadmensajesenviados = 0;
		this.cantidadmensajesrecibidos = 0;
		this.conversacion = new Conversacion(this);
		
	}

	public int cantidadDeMensajesEnviados() {
		/** Devuelve la cantidad de mensajes enviados del usuario */
		return this.cantidadmensajesenviados;
	}

	public String devolverNombre() {
		/** Devuelve el nombre del usuario */
		return this.nombre;
	}

	public void agregarEnviado(Mensaje nuevoMensaje) {
		/** Agrega 1 a la cantidad de mensajes enviados y guarda el mensaje en la conversacion*/
		
		this.cantidadmensajesenviados += 1;
		this.conversacion.agregarMensaje(nuevoMensaje);
		
	}

	public void agregarRecibido(Mensaje nuevoMensaje) {
		/** Agrega 1 a la cantidad de mensajes recibidos y guarda el mensaje en la conversacion */
		
		this.cantidadmensajesrecibidos += 1;
		this.conversacion.agregarMensaje(nuevoMensaje);
		
	}
	
	public void agregarRecibidoSinMensaje(){
		/** Agrega 1 a la cantidad de mensajes recibidos */
		this.cantidadmensajesrecibidos += 1;
	}
	
	public void agregarEnviadoSinMensaje(){
		/** Agrega 1 a la cantidad de mensajes recibidos */
		this.cantidadmensajesenviados += 1;
	}

	public int cantidadTotalMensajesRecibidos() {
		/** Devuelve la cantidad de mensajes recibidos del usuario */
		return this.cantidadmensajesrecibidos;
	}

}
