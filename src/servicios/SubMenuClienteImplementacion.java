package servicios;

import controladores.Inicio;

public class SubMenuClienteImplementacion implements MenuInterfaz {

	@Override
	public void mostarMenu() {
		System.out.println("-----MENÚ CLIENTE----");
		System.out.println("0. Registro cliente");
		System.out.println("1. Acceso cliente");
		System.out.println("2. Volver al menú principal");
		System.out.println("--------------------");

	}

	@Override
	public byte solicitarOpcion() {
		byte opcionUsuario;
		System.out.println("Selecciona una opción: ");
		opcionUsuario = Inicio.sc.nextByte();
		return opcionUsuario;
	}
	
	public void accionarSubMenuCliente() {
		ClienteImplementacion ci = new ClienteImplementacion();
		
		boolean esCerradoSubMenu = false;
		byte opcionUsuario;
		do {
			
			mostarMenu();
			opcionUsuario = solicitarOpcion();
			
			switch(opcionUsuario){
				case 0:
					System.out.println("Has elegido registrar un cliente.");
					ci.nuevoCliente();
					esCerradoSubMenu=true;
					break;
				case 1:
					System.out.println("Has elegido acceder a un cliente.");
					ci.accederCliente();
					esCerradoSubMenu=true;
					break;
				case 2:
					System.out.println("Has elegido volver al menú principal.");
					esCerradoSubMenu = true;
					break; 
				default:
					System.out.println("ERROR: opición inválida.");
					break;
			}
			
		}while(!esCerradoSubMenu);
	}

}
