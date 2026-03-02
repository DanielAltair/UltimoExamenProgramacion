package servicios;

import controladores.Inicio;

public class SubMenuEmpleadoImplementacion implements MenuInterfaz {

	@Override
	public void mostarMenu() {
		System.out.println("------MENÚ EMPLEADO-----");
		System.out.println("0. Validar cliente");
		System.out.println("1. Borrar cliente");
		System.out.println("2. Mostrar cliente");
		System.out.println("3. Asignar rol");
		System.out.println("4. Volver al menú principal");
		System.out.println("------------------------");
	}

	@Override
	public byte solicitarOpcion() {
		byte opcionUsuario;
		
		System.out.println("Selecciona una opción: ");
		opcionUsuario = Inicio.sc.nextByte();
		
		return opcionUsuario;
	}
	
	public void accionarSubMenuEmpleado() {
		EmpleadoImplementacion ei = new EmpleadoImplementacion();
		
		boolean esCerradoSub = false;
		byte opcionUsuario;
		
		do {
			mostarMenu();
			opcionUsuario = solicitarOpcion();
			switch(opcionUsuario) {
				case 0:
					ei.validarCliente();
					esCerradoSub = true;
					break;
				case 1:
					ei.borrarCliente();
					esCerradoSub = true;
					break;
				case 2: 
					ei.mostrarCliente();
					esCerradoSub = true;
					break;
				case 3:
					ei.asignarRol();
					esCerradoSub = true;
					break;
				case 4:
					System.out.println("Has elegido volver al menú principal.");
					esCerradoSub = true;
					break;
				default:
					System.out.println("Opción inválida.");
					break;
			}
			
		}while(!esCerradoSub);
	
	}

}
