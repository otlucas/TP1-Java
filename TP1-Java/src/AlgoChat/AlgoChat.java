package AlgoChat;
import java.util.ArrayList;
import java.util.List;

public class AlgoChat {
	Usuario usuario;
	public List<Grupo> grupos;
	List<Usuario> contactos;
	List<Conversacion> conversaciones;
	List<Conversacion> conversacionesgrupales;


	public AlgoChat (String nombredeusuario){
		/** Inicializa un AlgoChat con su usuario principal*/
		this.usuario = new Usuario(nombredeusuario);
		this.grupos = new ArrayList<Grupo>();
		this.contactos = new ArrayList<Usuario>();
		this.conversaciones = new ArrayList<Conversacion>();
		this.conversacionesgrupales = new ArrayList<Conversacion>();
		
	}

	public void agregarContacto(String nombre) throws ContactoYaExisteExcepcion{
		/**Agrega el contacto pasado por parametro a la lista de contactos*/
		if(this.existeContacto(nombre)){
			throw new ContactoYaExisteExcepcion();
		}
		Usuario nuevoUsuario = new Usuario(nombre);
		this.contactos.add(nuevoUsuario);
		Conversacion conversacion = new Conversacion(nuevoUsuario);
		this.conversaciones.add(conversacion);
		
	}
	
	

	public int cantidadDeChatsIndividuales() {
		/** Devuelve la cantidad de conversaciones con usuarios */
		if(this.conversaciones == null){
			return 0;
		}
		return this.conversaciones.size();
	}

	public int cantidadDeContactos() {
		/** Devuelve la cantidad de contactos almacenados */
		if(this.contactos == null){
			return 0;
		}
		return this.contactos.size();	
	}

	public int cantidadDeChatsGrupales() {
		/** Devuelve la cantidad de conversaciones con grupos */
		if(this.conversacionesgrupales == null){
			return 0;
		}
		
		return this.conversacionesgrupales.size();
	}

	public int cantidadDeGrupos() {
		/** Devuelve la cantidad de grupos almacenados */
		if(this.grupos == null){
			return 0;
		}
		
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
		for(int x = 0; x < this.contactos.size(); x = x + 1) {
			if(this.contactos.get(x).devolverNombre() == nombredeusuario){
				return true;
			}
		}
		return false;

	}

	public void recibirMensajeDe(String nombredecontacto, String texto) throws ContactoNoExisteExcepcion {
		/** Crea un mensaje y lo almacena en la conversacion con el contacto cuyo nombre se paso por parametro */
		if(!this.existeContacto(nombredecontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		int x = 0;
		for(; x < this.contactos.size(); x++) {
			if(this.contactos.get(x).devolverNombre() == nombredecontacto){
				this.contactos.get(x).agregarEnviado();
				break;
			}
		}
		Mensaje nuevoMensaje = new Mensaje(this.contactos.get(x).devolverNombre(), this.usuario.devolverNombre(), texto);
		this.usuario.agregarRecibido();
		for(x = 0; x < this.conversaciones.size(); x++) {
			if(this.conversaciones.get(x).devolverNombreContacto() == nombredecontacto){
				this.conversaciones.get(x).agregarMensaje(nuevoMensaje);
				break;
			}
		}
		
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
		for(int x = 0; x < this.contactos.size(); x++) {
			if(this.contactos.get(x).devolverNombre() == nombredecontacto){
				return this.contactos.get(x).cantidadDeMensajesEnviados();
			}
		}
		return 0;
		
	}

	public void enviarMensajeA(String nombredecontacto, String texto) throws ContactoNoExisteExcepcion {
		/** Crea un mensaje y lo almacena en la conversacion con el contacto cuyo nombre se paso por parametro */
		if(!this.existeContacto(nombredecontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		int x = 0;
		for(; x < this.contactos.size(); x++) {
			if(this.contactos.get(x).devolverNombre() == nombredecontacto){
				this.contactos.get(x).agregarRecibido();
				break;
			}
		}
		Mensaje nuevoMensaje = new Mensaje(this.usuario.devolverNombre(), this.contactos.get(x).devolverNombre(), texto);
		this.usuario.agregarEnviado();
		for(x = 0; x < this.conversaciones.size(); x++) {
			if(this.conversaciones.get(x).devolverNombreContacto() == nombredecontacto){
				this.conversaciones.get(x).agregarMensaje(nuevoMensaje);
				break;
			}
		}
		
	}

	public int cantidadMensajesEnviadosA(String nombredecontacto) throws ContactoNoExisteExcepcion {
		/** Devuelve la cantidad de mensajes que el usuario envio a el contacto cuyo nombre coincide con la cadena pasada por parametro */
		if(!this.existeContacto(nombredecontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		for(int x = 0; x < this.conversaciones.size(); x++) {
			if(this.conversaciones.get(x).devolverNombreContacto() == nombredecontacto){
				return this.conversaciones.get(x).cantidadMensajesEnviados();
			}
		}
		return 0; //excepcion pls
		
	}

	public ArrayList<String> obtenerConversacionCon(String nombredecontacto) throws ContactoNoExisteExcepcion {
		/** Devuelve una lista con los textos de los mensajes desde el ultimo hasta el primero que fueron enviados y recibidos en la conversacion con el contacto */
		if(!this.existeContacto(nombredecontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		for(int x = 0; x < this.conversaciones.size(); x++) {
			if(this.conversaciones.get(x).devolverNombreContacto() == nombredecontacto){
				return this.conversaciones.get(x).obtenerConversacion(this.usuario);
			}
		}
		return null; //excepcion pls
	}
	
	public void crearGrupo(String nombre) throws GrupoYaExisteExcepcion{
		/**Crea y almacena un grupo y le asigna la cadena pasada por parametro como nombre*/
		if(this.existeGrupo(nombre)){
			throw new GrupoYaExisteExcepcion();
		}
		Grupo grupo = new Grupo(nombre);
		this.grupos.add(grupo);
		Conversacion nuevaConversacion = new Conversacion(grupo);
		this.conversacionesgrupales.add(nuevaConversacion);
	}

	public void agregarContactoAGrupo(String nombredecontacto, String nombredelgrupo) throws GrupoNoExisteExcepcion, ContactoNoExisteExcepcion, ContactoYaExisteEnGrupo {
		/** Agrega el contacto cuyo nombre se paso por parametro al grupo cuyo nombre se paso por parametro */
		Boolean encontrado = false;
		Boolean agregado = false;
		for(int x = 0; x < this.grupos.size(); x++){
			if(this.grupos.get(x).devolverNombre() == nombredelgrupo){
				Grupo grupo = this.grupos.get(x);
				encontrado = true;
				for(int i = 0; i < this.contactos.size(); i++){
					if(this.contactos.get(i).devolverNombre() == nombredecontacto){
						agregado = true;
						grupo.agregarContacto(this.contactos.get(i));
					}
				}
				if(agregado == false){
					throw new ContactoNoExisteExcepcion();
				}
			}
		}	
		if(encontrado == false){
			throw new GrupoNoExisteExcepcion();
		}
	}

	public int cantidadMiembrosEnGrupo(String nombredelgrupo) throws GrupoNoExisteExcepcion {
		/** Devuelve la cantidad de integrantes de un grupo cuyo nombre se pasa por parametro*/
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		for(int x = 0; x < this.grupos.size(); x++){
			if(this.grupos.get(x).devolverNombre() == nombredelgrupo){
				return this.grupos.get(x).cantidadMiembros();
			}
		}
		return 0;
	}

	public boolean existeGrupo(String nombredelgrupo) {
		/** Devuelve true si el grupo cuyo nombre se paso por parametro se encuentra en grupos, false en el caso contrario */
		for(int x = 0; x < this.grupos.size(); x++){
			if(this.grupos.get(x).devolverNombre() == nombredelgrupo){
				return true;
			}
		}
		return false;
	}

	public void recibirMensajeDeGrupo(String nombredelgrupo, String nombrederemitente, String texto) throws GrupoNoExisteExcepcion, ContactoNoExisteEnGrupo {
		/** Recibe mensaje de grupo, por lo tanto todos los usuarios lo reciben menos el que lo envi� y ademas se guarda en la conversacion grupal
		 */
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		int x = 0;
		for(; x < this.grupos.size(); x++){
			if(this.grupos.get(x).devolverNombre() == nombredelgrupo){
				this.grupos.get(x).agregarRecibidoDe(nombrederemitente);
				break;
			}
		}
		this.usuario.agregarRecibido();
		Mensaje nuevoMensaje = new Mensaje(nombrederemitente, nombredelgrupo, texto);
		for(x = 0; x < this.conversacionesgrupales.size(); x++) {
			if(this.conversacionesgrupales.get(x).devolverNombreDeGrupo() == nombredelgrupo){
				this.conversacionesgrupales.get(x).agregarMensaje(nuevoMensaje);
				break;
			}
		}
		
		
	}

	public void enviarMensajeAGrupo(String nombredelgrupo, String texto) throws GrupoNoExisteExcepcion {
		/** Envia mensaje al grupo, entonces todos los integrantes lo reciben y ademas se guarda en la conversacion grupal */
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		int x = 0;
		for(; x < this.grupos.size(); x++){
			if(this.grupos.get(x).devolverNombre() == nombredelgrupo){
				this.grupos.get(x).agregarEnviado();
				break;
			}
		}
		this.usuario.agregarEnviado();
		Mensaje nuevoMensaje = new Mensaje(this.usuario.devolverNombre(), nombredelgrupo, texto);
		for(x = 0; x < this.conversacionesgrupales.size(); x++) {
			if(this.conversacionesgrupales.get(x).devolverNombreDeGrupo() == nombredelgrupo){
				this.conversacionesgrupales.get(x).agregarMensaje(nuevoMensaje);
				break;
			}
		}
		
	}

	public int cantidadMensajesRecibidosDelGrupo(String nombredelgrupo) throws GrupoNoExisteExcepcion {
		/** Devuelve la cantidad de mensajes recibidos de la conversacion grupal del grupo cuyo nombre se pasa por parametro*/
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		for(int x = 0; x < this.grupos.size(); x++){
			if(this.grupos.get(x).devolverNombre() == nombredelgrupo){
				return this.grupos.get(x).devolverCantidadRecibidos();
			}
		}
		return 0;
	}

	public int cantidadMensajesEnviadosAlGrupo(String nombredelgrupo) throws GrupoNoExisteExcepcion {
		/** Devuelve la cantidad de mensajes enviados de la conversacion grupal del grupo cuyo nombre se pasa por parametro*/
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		for(int x = 0; x < this.grupos.size(); x++){
			if(this.grupos.get(x).devolverNombre() == nombredelgrupo){
				return this.grupos.get(x).devolverCantidadEnviados();
			}
		}
		return 0;
	}

	public ArrayList<String> obtenerConversacionConGrupo(String nombredelgrupo) throws GrupoNoExisteExcepcion {
		/** Devuelve una lista con los textos de los mensajes desde el ultimo hasta el primero que fueron enviados y recibidos en la conversacion con el grupo */
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		for(int x = 0; x < this.conversacionesgrupales.size(); x++) {
			if(this.conversacionesgrupales.get(x).devolverNombreDeGrupo() == nombredelgrupo){
				return this.conversacionesgrupales.get(x).obtenerConversacion(this.usuario);
			}
		}
		return null;
	}

	public void borrarMensajesDelContacto(String nombredelcontacto) throws ContactoNoExisteExcepcion {
		/**Elimina todos los mensajes que tengan que ver con el contacto cuyo nombre se pasa por parametro */
		if(!this.existeContacto(nombredelcontacto)){
			throw new ContactoNoExisteExcepcion();
		}
		for(int x = 0; x < this.conversaciones.size(); x++){
			if(this.conversaciones.get(x).devolverNombreContacto() == nombredelcontacto){
				this.conversaciones.get(x).borrarConversacion(this.usuario);
			}
		}
		
		
	}

	public void borrarMensajesDelGrupo(String nombredelgrupo) throws GrupoNoExisteExcepcion {
		/**Elimina todos los mensajes que tengan que ver con el grupo cuyo nombre se pasa por parametro */
		if(!this.existeGrupo(nombredelgrupo)){
			throw new GrupoNoExisteExcepcion();
		}
		Grupo grupo = null;
		for(int x = 0; x < this.grupos.size(); x++){
			if(this.grupos.get(x).devolverNombre() == nombredelgrupo){
				grupo = this.grupos.get(x);
			}
		}
		for(int x = 0; x < this.conversacionesgrupales.size(); x++){
			if(this.conversacionesgrupales.get(x).devolverNombreDeGrupo() == nombredelgrupo){
				this.conversacionesgrupales.get(x).borrarConversacionGrupal(this.usuario, grupo);
			}
		}
	}
}
