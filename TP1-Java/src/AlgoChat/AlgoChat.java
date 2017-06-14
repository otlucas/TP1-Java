package AlgoChat;
import java.util.ArrayList;
import java.util.HashMap;

public class AlgoChat {
	Usuario usuario;
	public HashMap<String, Grupo> grupos;
	HashMap<String, Usuario> contactos;

	public AlgoChat (String nombredeusuario){
		/** Inicializa un AlgoChat con su usuario principal*/
		this.usuario = new Usuario(nombredeusuario);
		this.grupos = new HashMap<String, Grupo>();
		this.contactos = new HashMap<String, Usuario>();
	}

	public void agregarContacto(String nombre) throws ContactoYaExisteExcepcion{
		/**Agrega el contacto pasado por parametro a la lista de contactos*/
		if(this.existeContacto(nombre)){
			throw new ContactoYaExisteExcepcion();
		}
		Usuario nuevoUsuario = new Usuario(nombre);
		this.contactos.put(nuevoUsuario.devolverNombre(), nuevoUsuario);
	}
	
	public int cantidadDeChatsIndividuales() {
		/** Devuelve la cantidad de conversaciones con usuarios */
		return this.contactos.size();
	}

	public int cantidadDeContactos() {
		/** Devuelve la cantidad de contactos almacenados */
		return this.contactos.size();	
	}

	public int cantidadDeChatsGrupales() {
		/** Devuelve la cantidad de conversaciones con grupos */
		return this.grupos.size();
	}

	public int cantidadDeGrupos() {
		/** Devuelve la cantidad de grupos almacenados */
		return this.grupos.size();
	}

	public int cantidadDeMensajesEnviados() {
		/** Devuelve la cantidad de mensajes enviados por el usuario principal */
		
		return this.usuario.cantidadDeMensajesEnviados();
	}

	public String nombreUsuario() {
		/** Devuelve el nombre del usuario principal */
		return this.usuario.devolverNombre();
		
	}

	public boolean existeContacto(String nombredeusuario) {
		/** Devuelve true si existe un contacto cuyo nombre coincide con la cadena pasada por parametro, false en el caso contrario */
		return this.contactos.containsKey(nombredeusuario);

	}

	public void recibirMensajeDe(String nombredecontacto, String texto) throws ContactoNoExisteExcepcion {
		/** Crea un mensaje y lo almacena en la conversacion con el contacto cuyo nombre se paso por parametro */
		if(!this.existeContacto(nombredecontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		Mensaje nuevoMensaje = new Mensaje(nombredecontacto, this.usuario.devolverNombre(), texto);
		this.contactos.get(nombredecontacto).agregarEnviado(nuevoMensaje);
		this.usuario.agregarRecibidoSinMensaje();
		
	}

	public int cantidadTotalMensajesRecibidos() {
		/** Devuelve la cantidad de mensajes recibidos por el usuario principal */
		return this.usuario.cantidadTotalMensajesRecibidos();
	}

	public int cantidadMensajesDe(String nombredecontacto) throws ContactoNoExisteExcepcion {
		/** Devuelve la cantidad de mensajes enviados por el usuario cuyo nombre coincide con el nombre pasado por parametro*/
		if(!this.existeContacto(nombredecontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		return this.contactos.get(nombredecontacto).cantidadmensajesenviados;
		
	}

	public void enviarMensajeA(String nombredecontacto, String texto) throws ContactoNoExisteExcepcion {
		/** Crea un mensaje y lo almacena en la conversacion con el contacto cuyo nombre se paso por parametro */
		if(!this.existeContacto(nombredecontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		Mensaje nuevoMensaje = new Mensaje(this.usuario.devolverNombre(), nombredecontacto, texto);
		this.contactos.get(nombredecontacto).agregarRecibido(nuevoMensaje);
		this.usuario.agregarEnviadoSinMensaje();
	}

	public int cantidadMensajesEnviadosA(String nombredecontacto) throws ContactoNoExisteExcepcion {
		/** Devuelve la cantidad de mensajes que el usuario envio a el contacto cuyo nombre coincide con la cadena pasada por parametro */
		if(!this.existeContacto(nombredecontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		return this.contactos.get(nombredecontacto).conversacion.cantidadMensajesEnviados();
		
	}

	public ArrayList<String> obtenerConversacionCon(String nombredecontacto) throws ContactoNoExisteExcepcion {
		/** Devuelve una lista con los textos de los mensajes desde el ultimo hasta el primero que fueron enviados y recibidos en la conversacion con el contacto */
		if(!this.existeContacto(nombredecontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		return this.contactos.get(nombredecontacto).conversacion.obtenerConversacion(this.usuario);
	}
	
	public void crearGrupo(String nombre) throws GrupoYaExisteExcepcion{
		/**Crea y almacena un grupo y le asigna la cadena pasada por parametro como nombre*/
		if(this.existeGrupo(nombre)){
			throw new GrupoYaExisteExcepcion();
		}
		Grupo grupo = new Grupo(nombre);
		this.grupos.put(nombre, grupo);
	}

	public void agregarContactoAGrupo(String nombredecontacto, String nombredelgrupo) throws GrupoNoExisteExcepcion, ContactoNoExisteExcepcion, ContactoYaExisteEnGrupo {
		/** Agrega el contacto cuyo nombre se paso por parametro al grupo cuyo nombre se paso por parametro */
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		if(!this.existeContacto(nombredecontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		this.grupos.get(nombredelgrupo).agregarContacto(this.contactos.get(nombredecontacto));
	}

	public int cantidadMiembrosEnGrupo(String nombredelgrupo) throws GrupoNoExisteExcepcion {
		/** Devuelve la cantidad de integrantes de un grupo cuyo nombre se pasa por parametro*/
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		return this.grupos.get(nombredelgrupo).cantidadMiembros();
	}

	public boolean existeGrupo(String nombredelgrupo) {
		/** Devuelve true si el grupo cuyo nombre se paso por parametro se encuentra en grupos, false en el caso contrario */
		return this.grupos.containsKey(nombredelgrupo);
	}

	public void recibirMensajeDeGrupo(String nombredelgrupo, String nombrederemitente, String texto) throws GrupoNoExisteExcepcion, ContactoNoExisteEnGrupo {
		/** Recibe mensaje de grupo, por lo tanto todos los usuarios lo reciben menos el que lo envi� y ademas se guarda en la conversacion grupal
		 */
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		Mensaje nuevoMensaje = new Mensaje(nombrederemitente, nombredelgrupo, texto);
		this.grupos.get(nombredelgrupo).agregarRecibidoDe(nombrederemitente, nuevoMensaje);
		this.usuario.agregarRecibidoSinMensaje();
	}

	public void enviarMensajeAGrupo(String nombredelgrupo, String texto) throws GrupoNoExisteExcepcion {
		/** Envia mensaje al grupo, entonces todos los integrantes lo reciben y ademas se guarda en la conversacion grupal */
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		Mensaje nuevoMensaje = new Mensaje(this.usuario.devolverNombre(), nombredelgrupo, texto);
		this.grupos.get(nombredelgrupo).agregarEnviado(nuevoMensaje);
		this.usuario.agregarEnviadoSinMensaje();
	}

	public int cantidadMensajesRecibidosDelGrupo(String nombredelgrupo) throws GrupoNoExisteExcepcion {
		/** Devuelve la cantidad de mensajes recibidos de la conversacion grupal del grupo cuyo nombre se pasa por parametro*/
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		return this.grupos.get(nombredelgrupo).devolverCantidadRecibidos();
	}

	public int cantidadMensajesEnviadosAlGrupo(String nombredelgrupo) throws GrupoNoExisteExcepcion {
		/** Devuelve la cantidad de mensajes enviados de la conversacion grupal del grupo cuyo nombre se pasa por parametro*/
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		return this.grupos.get(nombredelgrupo).devolverCantidadEnviados();
	}

	public ArrayList<String> obtenerConversacionConGrupo(String nombredelgrupo) throws GrupoNoExisteExcepcion {
		/** Devuelve una lista con los textos de los mensajes desde el ultimo hasta el primero que fueron enviados y recibidos en la conversacion con el grupo */
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		return this.grupos.get(nombredelgrupo).conversacion.obtenerConversacion(this.usuario);
	}

	public void borrarMensajesDelContacto(String nombredelcontacto) throws ContactoNoExisteExcepcion {
		/**Elimina todos los mensajes que tengan que ver con el contacto cuyo nombre se pasa por parametro */
		if(!this.existeContacto(nombredelcontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		this.contactos.get(nombredelcontacto).conversacion.borrarConversacion(this.usuario);
	}

	public void borrarMensajesDelGrupo(String nombredelgrupo) throws GrupoNoExisteExcepcion {
		/**Elimina todos los mensajes que tengan que ver con el grupo cuyo nombre se pasa por parametro */
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		this.grupos.get(nombredelgrupo).conversacion.borrarConversacionGrupal(this.usuario, this.grupos.get(nombredelgrupo));
	}
}
