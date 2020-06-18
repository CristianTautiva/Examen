package com.web.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="visitante")
public class  Visitante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private long id;
    @Column(name="documento")
	private String documento;
    @Column(name="nombre")
	private String nombre;
	@Column(name="fechanacimiento")
	private Date fechanacimiento;
	@Column(name="eps")
	private int eps;
	@Column(name="genero")
	private String genero;
	@Column(name="empresa")
	private int empresa;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public int getEps() {
		return eps;
	}
	public void setEps(int eps) {
		this.eps = eps;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getEmpresa() {
		return empresa;
	}
	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}
	@Override
	public String toString() {
		return "Visitante [id=" + id + ", documento=" + documento + ", nombre=" + nombre + ", fechanacimiento="
				+ fechanacimiento + ", eps=" + eps + ", genero=" + genero + ", empresa=" + empresa + "]";
	}
	
	
	
	
}
