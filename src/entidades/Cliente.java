package entidades;



public class Cliente {
	
	public Cliente() {
		super();
		
	}
	private int idCliente; 
	private String dniCliente;
	private String nombreCompletoCliente;
	private String nombreCliente;
	private String apellido1Cliente;
	private String apellido2Cliente;
	private String emailCliente;
	private String claveCliente;
	private boolean esValidado;
	
	public Cliente(int idCliente, String dniCliente, String nombreCompletoCliente, String nombreCliente,
			String apellido1Cliente, String apellido2Cliente, String emailCliente, String claveCliente,
			boolean esValidado) {
		super();
		this.idCliente = idCliente;
		this.dniCliente = dniCliente;
		this.nombreCompletoCliente = apellido1Cliente + apellido2Cliente + nombreCliente;
		this.nombreCliente = nombreCliente;
		this.apellido1Cliente = apellido1Cliente;
		this.apellido2Cliente = apellido2Cliente;
		this.emailCliente = emailCliente;
		this.claveCliente = claveCliente;
		this.esValidado = esValidado;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int l) {
		this.idCliente = l;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getNombreCompletoCliente() {
		return nombreCompletoCliente;
	}
	public void setNombreCompletoCliente(String nombreCompletoCliente) {
		this.nombreCompletoCliente = nombreCompletoCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellido1Cliente() {
		return apellido1Cliente;
	}
	public void setApellido1Cliente(String apellido1Cliente) {
		this.apellido1Cliente = apellido1Cliente;
	}
	public String getApellido2Cliente() {
		return apellido2Cliente;
	}
	public void setApellido2Cliente(String apellido2Cliente) {
		this.apellido2Cliente = apellido2Cliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getClaveCliente() {
		return claveCliente;
	}
	public void setClaveCliente(String claveCliente) {
		this.claveCliente = claveCliente;
	}
	public boolean isEsValidado() {
		return esValidado;
	}
	public void setEsValidado(boolean esValidado) {
		this.esValidado = esValidado;
	}
	@Override
	public String toString() {
		  String esValidadoBien = (esValidado == true) ? "si"  : "no" ;
		return "DNI: " + dniCliente + "\n"
				+ "NOMBRE: " + nombreCompletoCliente
				+ "\n"
				+ "ESTADO VALIDACIÓN: " + esValidadoBien + "\n"
				+ "%%%%%%%%%%";
	}
	

}
