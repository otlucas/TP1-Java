package AlgoChat;

public class Mensaje {
	
	String texto;
	String remitente;
	String destinatario;
	
	public Mensaje(String remitente, String destinatario, String texto) {
		/** Crea una instancia de mensaje y completa sus datos */
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.texto = texto;
	}

	public String devolverDestinatario() {
		/** Devuelve el destinatario del mensaje  */
		return this.destinatario;
	}

	public String devolverTexto() {
		/** Devuelve el texto del mensaje */
		return this.texto;
	}

	public String devolverRemitente() {
		/** Devuelve el remiten del mensaje */
		return this.remitente;
	}

	
}
