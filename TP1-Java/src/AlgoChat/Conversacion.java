package AlgoChat;
import java.util.ArrayList;
import java.util.List;

public class Conversacion {
	
	Usuario contacto;
	List<Mensaje> mensajes;
	Grupo grupo;
	
	public Conversacion(Usuario contacto){
		/** Crea una conversacion con una lista de mensajes vacia y un contacto */
		this.contacto = contacto;
		this.mensajes = new ArrayList<Mensaje>();
	}
	
	public Conversacion(Grupo grupo){
		/** Crea una conversacion con una lista de mensajes vacia y un contacto */
		this.grupo = grupo;
		this.mensajes = new ArrayList<Mensaje>();
	}

	public String devolverNombreContacto() {
		/** Devuelve el nombre del contacto con el que se tiene la conversacion */
		return this.contacto.devolverNombre();
	}

	public void agregarMensaje(Mensaje nuevoMensaje) {
		/** Agrega un mensaje a la lista de mensajes */
		
		this.mensajes.add(nuevoMensaje);
		
	}

	public int cantidadMensajesEnviados() {
		/** Devuelve la cantidad de mensajes en la lista de mensajes que tengan como destinatario al contacto */
		int contadordemensajes = 0;
		for(int x = 0; x < this.mensajes.size(); x++){
			if(this.mensajes.get(x).devolverDestinatario() == this.contacto.devolverNombre()){
				contadordemensajes++;
			}
		}
		return contadordemensajes;
	}

	public ArrayList<String> obtenerConversacion(Usuario usuarioprincipal) {
		/** Devuelve una lista con los textos de los mensajes ordenados desde el ultimo hasta el primero */
		ArrayList<String> listaDeMensajes = new ArrayList<String>();
		for(int x = this.mensajes.size() - 1; x > -1; x--){
			if(this.mensajes.get(x).devolverRemitente() == usuarioprincipal.devolverNombre()){
				listaDeMensajes.add(String.format("Yo: %s", this.mensajes.get(x).devolverTexto()));
			}else{
					listaDeMensajes.add(String.format("%s: %s",this.mensajes.get(x).devolverRemitente(), this.mensajes.get(x).devolverTexto()));
			}
		}
		listaDeMensajes.add(0, "");
		return listaDeMensajes;
		
	}
		

	public String devolverNombreDeGrupo() {
		/** Devuelve el nombre del grupo con el cual se tiene la conversacion */
		return this.grupo.devolverNombre();
	}

	public void borrarConversacion(Usuario usuarioprincipal) {
		/** Vacia la conversacion y elimina la cantidad de mensajes enviados y recibidos */
		for(int x = 0; x < this.mensajes.size(); x++){
			if(this.mensajes.get(x).devolverDestinatario() == usuarioprincipal.devolverNombre()){
				usuarioprincipal.cantidadmensajesrecibidos--;
				this.contacto.cantidadmensajesenviados--;
			}else{
				usuarioprincipal.cantidadmensajesenviados--;
				this.contacto.cantidadmensajesrecibidos--;
			}
		
		}
		this.mensajes = new ArrayList<Mensaje>();
			
		
	}

	public void borrarConversacionGrupal(Usuario usuarioprincipal, Grupo grupo) {
		/** Vacia la conversacion y elimina la cantidad de mensajes enviados y recibidos para todos los integrantes */
		for(int x = 0; x < this.mensajes.size(); x++){
			if(this.mensajes.get(x).devolverRemitente() == usuarioprincipal.devolverNombre()){
				usuarioprincipal.cantidadmensajesenviados--;
				grupo.restarMensajeEnviado();
			}else{
				usuarioprincipal.cantidadmensajesrecibidos--;
				grupo.restarMensajeRecibidoDe(this.mensajes.get(x).devolverRemitente());
			}
		
		}
		this.mensajes = new ArrayList<Mensaje>();
		
	}	

}











