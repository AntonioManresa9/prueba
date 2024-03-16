package unidad6.tarea6;

import java.util.ArrayList;

public class Peluqueria {

	private String nombre;
	private String direccion;
	private ArrayList<Cliente> listaClientes;
	

	public Peluqueria() {
		
	}


	public Peluqueria(String nombre, String direccion) {
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaClientes = new ArrayList<>();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}


	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}


	@Override
	public String toString() {
		return "Peluqueria [nombre=" + nombre + ", direccion=" + direccion + ", listaClientes=" + listaClientes + "]";
	}


	
}
