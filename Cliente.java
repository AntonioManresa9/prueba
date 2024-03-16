package unidad6.tarea6;

import java.util.Scanner;

public class Cliente {

	private String nombre;
	private long telefono;
	private String tipoPelo;
	private boolean peloCortado;

	public Cliente(String nombre, long telefono, String tipoPelo) {

		this.nombre = nombre;
		this.telefono = telefono;
		this.tipoPelo = tipoPelo;
		this.peloCortado = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(String tipoPelo) {
		this.tipoPelo = tipoPelo;
	}

	public boolean isPeloCortado() {
		return peloCortado;
	}

	public void setPeloCortado(boolean peloCortado) {
		this.peloCortado = peloCortado;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", telefono=" + telefono + ", tipoPelo=" + tipoPelo + ", peloCortado="
				+ peloCortado + "]";
	}

	public static Cliente crearCliente() {
		Scanner sc = new Scanner(System.in);
		Scanner scNum = new Scanner(System.in);
		boolean encontrado = false;
		long telefono = 0;

		
		
		System.out.println("Introduce el nombre del nuevo cliente: ");
		String nombre = sc.nextLine().trim().toLowerCase();
		do {
			System.out.println("Tienes que introducir el numero de telefono del nuevo cliente. ");
			telefono = Principal.corrLong();
			encontrado = comprobarTlf(telefono);

		} while (!encontrado);

		do {
			System.out.println("Introduce el tipo de pelo del nuevo cliente(ondulado/rizado/liso): ");
			String tipoPelo = sc.nextLine().trim().toLowerCase();

			if (validarTipoPelo(tipoPelo) == true) {
				encontrado = true;
				Cliente nuevoCliente = new Cliente(nombre, telefono, tipoPelo);
				return nuevoCliente;
			} else {
				System.out.println("No ha seleccionado un tipo de pelo correcto.");
				encontrado = false;
			}
		} while (!encontrado);

		return null;
	}

	public static boolean validarTipoPelo(String tipoPelo) {
		boolean valido = false;

		if (tipoPelo.equalsIgnoreCase("ondulado") || tipoPelo.equalsIgnoreCase("rizado")
				|| tipoPelo.equalsIgnoreCase("liso")) {
			valido = true;
		} else {
			valido = false;
		}

		return valido;
	}

	public static boolean cortarPelo(Peluqueria peluqueria) {
		Scanner scNum = new Scanner(System.in);
		boolean encontrado = false;
		boolean valido = false;
		long telefono = 0;

		do {
			System.out.println("Tienes que introducir el numero de telefono del nuevo cliente. ");
			telefono = Principal.corrInt();
			encontrado = comprobarTlf(telefono);

		} while (!encontrado);

		for (Cliente clientes : peluqueria.getListaClientes()) {
			if (clientes.getTelefono() == telefono) {
				clientes.setPeloCortado(true);
				valido = true;
			}

		}
		if (!valido) {
			System.out.println("El cliente introducido no existe.");
		}

		return valido;
	}

	public static boolean comprobarTlf(long telefono) {

		if (telefono > 99999999 && telefono < 999999999) {
			// System.out.println("El numero tiene 9 dig");
			return true;

		} else {
			System.err.println("Tienes que introducir num de 9 digitos.");
			return false;
		}
	}

	public static void clientesPeloCortado(Peluqueria peluqueria, boolean cortado) {

		for (Cliente peloCortado : peluqueria.getListaClientes()) {

			if (cortado) {
				if (peloCortado.isPeloCortado()) {
					System.out.println("\nCliente: " + peloCortado.getNombre() + "\nTelefono: "
							+ peloCortado.getTelefono() + "\nTipo de pelo: " + peloCortado.getTipoPelo());
				}
			}
			if (!cortado) {
				if (!peloCortado.isPeloCortado()) {
					System.out.println("\nCliente: " + peloCortado.getNombre() + "\nTelefono: "
							+ peloCortado.getTelefono() + "\nTipo de pelo: " + peloCortado.getTipoPelo());
				}
			}
		}
	}

	public static Cliente eliminarCliente(Peluqueria peluqueria) {
		long telefono = 0;
		boolean encontrado = false;
		Cliente clienteN = null;

		do {
			System.out.println("Tienes que introducir el numero de telefono del nuevo cliente. ");
			telefono = Principal.corrLong();
			encontrado = comprobarTlf(telefono);

		} while (!encontrado);

		for (Cliente cliente : peluqueria.getListaClientes()) {
			if (telefono == cliente.getTelefono()) {
				peluqueria.getListaClientes().remove(cliente);
				System.out.println("Se ha eliminado al cliente: " + cliente.getNombre());
				clienteN = cliente;
				return cliente;
			}
		}
		if (clienteN == null) {
			System.out.println("No existe ningun usuario con ese numero de telefono.");
		}

		return null;
	}
}
