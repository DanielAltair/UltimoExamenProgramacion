package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Cliente;
import servicios.ClienteImplementacion;
import servicios.MenuImplementacion;
import servicios.SubMenuClienteImplementacion;
import servicios.SubMenuEmpleadoImplementacion;

public class Inicio {
	public static Scanner sc = new Scanner (System.in);
	public static int ultimoIdCliente = 0;
	public static ArrayList<Cliente> listaClientes = new ArrayList<>();
	public static String sesion = "NL";

	public static void main(String[] args) {
		MenuImplementacion mpi = new MenuImplementacion();
		SubMenuEmpleadoImplementacion smei = new SubMenuEmpleadoImplementacion();
		SubMenuClienteImplementacion smci = new SubMenuClienteImplementacion();
		ClienteImplementacion ci = new ClienteImplementacion();
		
		Cliente nuevoCliente = new Cliente();
		String nombreCompleto = "Manolo Garcia Lopez";
		String[] partes = nombreCompleto.split(" ");
		nuevoCliente.setNombreCliente(partes [0]);
		nuevoCliente.setApellido1Cliente(partes[1]);
		nuevoCliente.setApellido2Cliente(partes [2]);
		nuevoCliente.setNombreCompletoCliente(partes[0] + " " + partes[1] + " "+ partes[2]);
		nuevoCliente.setEmailCliente("manologarcia@gmail.com");
		nuevoCliente.setClaveCliente("manolo");
		nuevoCliente.setDniCliente("29559409-Q");
		nuevoCliente.setEsValidado(true);
		nuevoCliente.setRolCliente("Empleado");
		nuevoCliente.setIdCliente(ci.generarIdCliente());
		listaClientes.add(nuevoCliente);
		
		boolean esCerrado = false; 
		byte opcionUsuario;
		
		do {
			mpi.mostarMenu();
			opcionUsuario = mpi.solicitarOpcion();
			switch(opcionUsuario) {
			case 0:
				boolean esCerradoSub = false;
				do {
				sc.nextLine();
				
				System.out.println("Introduzca su DNI: ");
				String dniValidar = Inicio.sc.nextLine();
				if(ci.validacionDni(dniValidar)) {
					System.out.println("DNI: " + dniValidar + " válido.");
					
					for(Cliente c : Inicio.listaClientes) {
							
								if(c.getDniCliente().equals(dniValidar)) {
									if(c.getRolCliente().equals("Cliente")) {
										System.out.println("Acceso denegado, su rol no es Empleado.");
										esCerradoSub = true;
										break;
									} 
									if(c.getRolCliente().equals("Empleado")){
										System.out.println("Acceso permitido."); 
										smei.accionarSubMenuEmpleado();
										esCerradoSub = true;
										break;
									}
								}else {
									System.out.println("El usuario con DNI: " + dniValidar + " no está registrado.");
									esCerradoSub = true;
									break;
								}
					}
				}else {
					System.out.println("Acceso denegado, DNI inválido."); 
					esCerradoSub = true;
					break;
				}
				}while(!esCerradoSub);
				break;
			case 1: 
				smci.accionarSubMenuCliente();
				break;
			case 2:
				System.out.println("Has elegido cerrar la aplicación.");
				esCerrado = true;
				break;
			default:
				System.out.println("ERROR: opción inválida.");
				break; 
			}
			
		}while(!esCerrado);

	}

}
