package AlgoChat;
import java.util.ArrayList;
import java.util.List;

public class Grupo {
	public List<Usuario> integrantes;
	int cantidadMensajesRecibidos;
	int cantidadMensajesEnviados;
	String nombre;

	public Grupo(String nombredelgrupo){
		/** Crea una instancia de grupo y asigna la cadena pasada por parametro como su nombre */
		this.nombre = nombredelgrupo;
		this.cantidadMensajesRecibidos = 0;
		this.cantidadMensajesEnviados = 0;
		this.integrantes = new ArrayList<Usuario>();
		
	}

	public String devolverNombre() {
		/** Devuelve el nombre del grupo */
		return this.nombre;
	}

	public void agregarContacto(Usuario contacto) throws ContactoYaExisteEnGrupo {
		/** Agrega un contacto a la lista de integrantes del grupo */
		if(this.existeContacto(contacto.devolverNombre())){
			throw new ContactoYaExisteEnGrupo();
		}
		this.integrantes.add(contacto);
	}

	public int cantidadMiembros() {
		/** Devuelve la cantidad de miembros del grupo */
		return this.integrantes.size() + 1;
	}


	public void agregarRecibidoDe(String nombrederemitente) throws ContactoNoExisteEnGrupo {
		/** Agrega mensaje recibido a todos los integrantes del grupo menos al remitente
		 */
		if(!this.existeContacto(nombrederemitente)){
			throw new ContactoNoExisteEnGrupo();
		}
		for(int x = 0; x < this.integrantes.size(); x++){
			if(this.integrantes.get(x).devolverNombre() != nombrederemitente){
				this.integrantes.get(x).agregarRecibido();
			}else{
				this.integrantes.get(x).agregarEnviado();
			}
		}
		this.cantidadMensajesRecibidos++;
	}

	public void agregarEnviado() {
		/** Agrega mensaje recibido a todos los integrantes del grupo
		 */
		for(int x = 0; x < this.integrantes.size(); x++){
			this.integrantes.get(x).agregarRecibido();
		}
		this.cantidadMensajesEnviados++;
	}

	public int devolverCantidadRecibidos() {
		/** Devuelve la cantidad de mensajes recibidos a traves del grupo */
		
		return this.cantidadMensajesRecibidos;
	}

	public int devolverCantidadEnviados() {
		/** Devuelve la cantidad de mensajes enviados a traves del grupo */
		
		return this.cantidadMensajesEnviados;
	}

	public void restarMensajeEnviado() {
		/** Se descuenta un mensaje recibido a todos los integrantes del grupo */
		for(int x = 0; x < this.integrantes.size(); x++){
			this.integrantes.get(x).cantidadmensajesrecibidos--;
			
		}
		this.cantidadMensajesEnviados--;
	}

	public void restarMensajeRecibidoDe(String nombredelRemitente) {
		/** Se le descuenta un mensaje recibido a todos los integrantes del grupo menos al que envio el mensaje */
		for(int x = 0; x < this.integrantes.size(); x++){
			if(this.integrantes.get(x).devolverNombre() != nombredelRemitente){
				this.integrantes.get(x).cantidadmensajesrecibidos--;
				
			}else{
				this.integrantes.get(x).cantidadmensajesenviados--;
				
			
			}
		}
		this.cantidadMensajesRecibidos--;
	}

	public boolean existeContacto(String nombredecontacto) {
		/** Devuelve true si el contacto es integrante del grupo o false en el caso contrario */
		for(int x = 0; x < this.integrantes.size(); x++){
			if(this.integrantes.get(x).devolverNombre() == nombredecontacto){
				return true;
			}
		}
		return false;
	}

}
