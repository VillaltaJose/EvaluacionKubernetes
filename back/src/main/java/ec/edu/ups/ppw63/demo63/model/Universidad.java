package ec.edu.ups.ppw63.demo63.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Universidad {
	
	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;
	private String pais;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "Universidad [codigo=" + codigo + ", nombre=" + nombre + ", pais=" + pais + "]";
	}
	
	
	
}
