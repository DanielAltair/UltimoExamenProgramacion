package servicios;

import controladores.Inicio;

public class MenuImplementacion implements MenuInterfaz {

	@Override
	public void mostarMenu() {
		System.out.println("-----MENÚ PRINCIPAL-----");
		System.out.println("0. Versión empleado");
		System.out.println("1. Versión cliente");
		System.out.println("2. Cerrar aplicación");
		System.out.println("-------------------------");
	}

	@Override
	public byte solicitarOpcion() {
		byte opcionUsuario;
		System.out.println("Selecciona una opción: ");
		opcionUsuario = Inicio.sc.nextByte();
		return opcionUsuario;
	}

}
