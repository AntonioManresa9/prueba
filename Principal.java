package unidad6.tarea6;
/**
 * @author Antonio Manresa
 * 
 * 
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static String menu() {
		
		final String MENU = "\tMENU\n1)CREAR NUEVO CLIENTE\n2)CORTAR PELO A CLIENTE"
				+ "\n3)MOSTRAR CLIENTE CON EL PELO CORTADO\n4)CLIENTE CON EL PELO SIN CORTAR"
				+ "\n5)ELIMINAR CLIENTE PELUQUERIA\n6)SALIR";
	
		return MENU;
	}
	
	public static void datosFicticios(Peluqueria peluqueria) {
		
		Cliente[] clientes = {
				new Cliente("Sofia", 632123456, "largo"),
				new Cliente("Marta", 632187564, "corto"),
				new Cliente("Pedro", 697543464, "graso"),
				new Cliente("Carlos",646745434, "sedoso"),
				new Cliente("Vanesa",617434653, "ondulado"),
				};
				
				for (Cliente cliente : clientes) {
					peluqueria.getListaClientes().add(cliente);
				}
		}
	
public static int corrInt() {
		Scanner scInt = new Scanner(System.in);
		boolean valido = false;
		int num = 0;
		
		do {
			try {
				System.out.println("\nIntroduce un nÃºmero: ");
				num = scInt.nextInt();
				valido = true;
			} catch (InputMismatchException ex) {
				System.err.print("ERROR. No puedes poner letras.");
				scInt.next();
				valido = false;
			}
		} while (!valido);

		return num;
	}

public static long corrLong() {
	Scanner scLong = new Scanner(System.in);
	boolean valido = false;
	long num = 0;
	
	do {
		try {
			System.out.println("\nIntroduce un nÃºmero: ");
			num = scLong.nextLong();
			valido = true;
		} catch (InputMismatchException ex) {
			System.err.print("ERROR. No puedes poner letras.");
			scLong.next();
			valido = false;
		}
	} while (!valido);

	return num;
}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner scNum = new Scanner(System.in);
		int opcion = 0;
		boolean cortado;
		
		Peluqueria mipeluqueria = new Peluqueria("Paqui", "Calle Palomo");
		
		datosFicticios(mipeluqueria);
		
		do {
		System.out.println(menu());
		opcion = corrInt();
		
		switch (opcion) {
		case 1:
			Cliente nuevoCliente = Cliente.crearCliente();
			mipeluqueria.getListaClientes().add(nuevoCliente);
			System.out.println("Cliente: " + nuevoCliente.getNombre() + "\nTelefono: " 
			+ nuevoCliente.getTelefono() + "\nTipo de pelo: " + nuevoCliente.getTipoPelo() 
			+ "\nHa sido añadido con exito.");
			
			break;
		case 2:
			boolean valido = Cliente.cortarPelo(mipeluqueria);
			if(valido) {
				System.out.println("El cliente se acaba de cortar el cabello.");
			}
			break;
		case 3:
			
			Cliente.clientesPeloCortado(mipeluqueria, cortado = true);
			
			break;
		case 4:
			Cliente.clientesPeloCortado(mipeluqueria, cortado = false);
			break;
		case 5:
			Cliente.eliminarCliente(mipeluqueria);
			break;
		case 6:
			System.out.println("Saliendo...");
			break;

		default:
			System.err.println("No ha introducido un número correcto.");
			break;
		}
		}while(opcion != 6);
	}

}
