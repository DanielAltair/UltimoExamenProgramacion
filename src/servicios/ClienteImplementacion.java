package servicios;


import controladores.Inicio;
import entidades.Cliente;

public class ClienteImplementacion {
	public void nuevoCliente(){
		Cliente nuevoCliente = new Cliente();
		
		System.out.println("---REGISRO CLIENTE---");
		
		Inicio.sc.nextLine();		
		
		System.out.println("Introduzca el nombre completo: ");
		String nombreCompleto = Inicio.sc.nextLine();
		
		String[] partes = nombreCompleto.split(" ");
		nuevoCliente.setNombreCliente(partes [0]);
		nuevoCliente.setApellido1Cliente(partes[1]);
		nuevoCliente.setApellido2Cliente(partes [2]);
		nuevoCliente.setNombreCompletoCliente(partes[0] + " " + partes[1] + " "+ partes[2]);		
		System.out.println("Introduzca el email:  (formato pepito@gmail.com)");
		nuevoCliente.setEmailCliente(Inicio.sc.nextLine());
		
		System.out.println("Introduzca la contraseña: ");
		nuevoCliente.setClaveCliente(Inicio.sc.nextLine());
		
		String dni;
		boolean dniValido = false;
		do{
			System.out.println("Introduzca el DNI: (Utiliza el siguiente formato: 123456789-Q)");
			dni = Inicio.sc.nextLine();
			
			boolean resultadoValidacionDni = validacionDni(dni);
			
			if(resultadoValidacionDni == true) {
				System.out.println("DNI correcto.");
				nuevoCliente.setDniCliente(dni);
				dniValido = true;
			}else {
				System.out.println("DNI Incorrecto.");
				dniValido = false;
			}
			
		}while(!dniValido);
		
		nuevoCliente.setIdCliente(generarIdCliente());
		
		Inicio.listaClientes.add(nuevoCliente);
	}
	
	 
	public void accederCliente() {
		
		boolean esValidado = false;
		int contadorIntentos = 0;
		
		do {
			contadorIntentos++;
			Inicio.sc.nextLine();
			
			System.out.println("Introduzca el email del usuario: ");
			String email = Inicio.sc.nextLine();
			
			System.out.println("Introduzca la contraseña del usuario: ");
			String clave = Inicio.sc.nextLine();
			
				
				for(Cliente c : Inicio.listaClientes) {
					if(email.equals(c.getEmailCliente()) && clave.equals(c.getClaveCliente())) {
					
						esValidado = true;
						break;
						
					}
				}

				if(esValidado == true){
					
					System.out.println("INCIO DE SESIÓN CORRECTO.");
					contadorIntentos = 4;
					
				}else {
					
					System.out.println("Email o contraseña incorrectas, intento "+ contadorIntentos );
				}
				
				
			
		}while(contadorIntentos < 3);
		
	}
	
	
	private int  generarIdCliente() {
		if(Inicio.listaClientes.isEmpty()) {
			return 1;
		}else {
			int idUltimo = Inicio.listaClientes.getLast().getIdCliente();
			return idUltimo + 1; 
		}
		
	}
	
	public boolean validacionDni(String dni) {
		String[] partesDni = dni.split("-");
		
		String numeroDni = partesDni [0];
		String letraDni = partesDni[1];
		
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int numero = Integer.parseInt(numeroDni);
		
		char letraCorrecta = letras.charAt(numero % 23);
		
		if(letraDni.equals(String.valueOf(letraCorrecta))) {
			return true;
		}
		return false; 
	}
	

}
