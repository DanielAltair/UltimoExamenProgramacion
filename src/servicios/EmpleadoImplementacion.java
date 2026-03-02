package servicios;

import java.util.ArrayList;
import java.util.Comparator;

import controladores.Inicio;
import entidades.Cliente;

public class EmpleadoImplementacion {
	
	public void validarCliente() {
		Inicio.sc.nextLine();
		for(Cliente c : Inicio.listaClientes) {
			if(c.isEsValidado()== false) {
				System.out.println("Clientes no validados: ");
				System.out.println(c.toString());
				
				boolean dniValidado = false;
				
				do {
					
					System.out.println("Indica el dni del cliente a validar: ");
					String dni = Inicio.sc.nextLine();
					
					if(c.getDniCliente().equals(dni)) {
						System.out.println("DNI correcto, validando cliente...");
						c.setEsValidado(true);
						System.out.println("cliente con DNI" + dni + " ha sido validado");
						dniValidado = true;
						
					}else {
						
					System.out.println("DNI incorrecto, vuelva a introducirlo.");
					
					}
				}while(!dniValidado);
			}
		}
		System.out.println("Todos los clientes están validados.");
	}
	
	
	public void borrarCliente() {
		ClienteImplementacion ci = new ClienteImplementacion();
		
		boolean dniValidado = false;
		Cliente clienteBorrar = null;
		boolean dniEncontrado = false;
		
		
		do {
			Inicio.sc.nextLine();
			
			System.out.println("Introduzca el DNI del cliente a borrar: ");
			String dniBorrar = Inicio.sc.nextLine();
			if(ci.validacionDni(dniBorrar)) {
				System.out.println("DNI: " + dniBorrar + " válido.");
				
				for(Cliente c : Inicio.listaClientes) {
						
							if(c.getDniCliente().equals(dniBorrar)) {
								clienteBorrar = c;
								dniValidado = true;
								dniEncontrado = true;
								break;
							}
				}
				if(!dniEncontrado) {
					System.out.println("No existe ningún cliente con el DNI: "+ dniBorrar);
				}
				if(dniEncontrado) {
					
				Inicio.listaClientes.remove(clienteBorrar);
				System.out.println("El cliente: " + clienteBorrar + "\nha sido eliminado correctamente.");
				}
				
			}else {
				System.out.println("DNI inválido.");
			}
			
		}while(!dniValidado);
		
		
	}
	
	
	public void mostrarCliente() {
		
		Inicio.sc.nextLine();
		
		boolean esCerrado = false;
		byte opcion;
		
		System.out.println("----------MENÚ ORDENAR-----------");
		System.out.println("0. Mostrar de forma descendente");
		System.out.println("1. Mostrar de forma ascendente");
		System.out.println("---------------------------------");
		
		System.out.println("Elija una opción:");
		opcion = Inicio.sc.nextByte();
		
		do
			
			switch(opcion) {
				case 0:
					System.out.println("Has elegido mostrar de forma descendente: ");
					ordenarDescendente();
					esCerrado = true;
					break;
				case 1:
					System.out.println("Has elegido mostrar de forma ascendente: ");
					ordenarAscendente();
					esCerrado = true;
					break;
				default:
					System.out.println("Opión inválida.");
					break;
			}while(!esCerrado);
		
	}
		
		/**Inicio.sc.nextLine();
		for(Cliente c : Inicio.listaClientes) {
			if(c.isEsValidado()== true) {
				System.out.println("Clientes validados: ");
				System.out.println(c.toString());
			}
			else {
				System.out.println("Los clientes no están validados.");
			}
		}
	}**/
	
	
	public void ordenarDescendente() {
		ArrayList<Cliente> copiaLista = new ArrayList<>(Inicio.listaClientes);
		
		Inicio.sc.nextLine();
		
		copiaLista.sort(Comparator.comparing(Cliente::getNombreCliente).reversed());
		
		for (Cliente c : copiaLista) {
			System.out.println(c.toString());
		}
	}
	
	
	public ArrayList<Cliente>  ordenarAscendente() {
		ArrayList<Cliente> copiaLista = new ArrayList<>(Inicio.listaClientes);
		
		int n = copiaLista.size();
		
		for (int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(copiaLista.get(j).getApellido1Cliente().compareToIgnoreCase(copiaLista.get(j + 1).getApellido1Cliente())> 0) {
					
					Cliente temp = copiaLista.get(j);
	                copiaLista.set(j, copiaLista.get(j + 1));
	                copiaLista.set(j + 1, temp);
				}
			}
		
		}
		System.out.println(copiaLista.toString());
		return copiaLista;

	}
	public void asignarRol() {
		ClienteImplementacion ci = new ClienteImplementacion();

		boolean dniValidado = false;
		
		do {
			Inicio.sc.nextLine();
			
			System.out.println("Introduzca el DNI del usuario para asignarle el rol: ");
			String dniRol = Inicio.sc.nextLine();
			if(ci.validacionDni(dniRol)) {
				System.out.println("DNI: " + dniRol + " válido.");
				
				for(Cliente c : Inicio.listaClientes) {
						
							if(c.getDniCliente().equals(dniRol)) {
								
								dniValidado = true;
								
								System.out.println("Qué rol quieres asignarle (Empleado o Cliente): ");
								String rolCliente = Inicio.sc.nextLine();
								
								c.setRolCliente(rolCliente);
								
								System.out.println("Se le ha asignado correctamente el rol " + rolCliente + " al usuario con DNI " + dniRol + ".");
								break;
							}
				}
				
			}else {
				System.out.println("DNI inválido.");
			}
			
		}while(!dniValidado);
	}
}
