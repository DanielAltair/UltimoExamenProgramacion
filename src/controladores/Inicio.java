package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Cliente;
import servicios.MenuImplementacion;
import servicios.SubMenuClienteImplementacion;
import servicios.SubMenuEmpleadoImplementacion;

public class Inicio {
	public static Scanner sc = new Scanner (System.in);
	public static int ultimoIdCliente = 0;
	public static ArrayList<Cliente> listaClientes = new ArrayList<>();

	public static void main(String[] args) {
		MenuImplementacion mpi = new MenuImplementacion();
		SubMenuEmpleadoImplementacion smei = new SubMenuEmpleadoImplementacion();
		SubMenuClienteImplementacion smci = new SubMenuClienteImplementacion();
		
		boolean esCerrado = false; 
		byte opcionUsuario;
		
		do {
			mpi.mostarMenu();
			opcionUsuario = mpi.solicitarOpcion();
			switch(opcionUsuario) {
			case 0:
				smei.accionarSubMenuEmpleado();
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
