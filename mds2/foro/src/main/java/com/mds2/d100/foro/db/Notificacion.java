/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Ismael Cruz Bello(University of Almeria)
 * License Type: Academic
 */
package com.mds2.d100.foro.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "`Notificacion`")
@SuppressWarnings({ "all", "unchecked" })
public class Notificacion implements Serializable {
	public Notificacion() {
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_NOTIFICACION_ENVIADA_A) {
			this.enviada_a = (com.mds2.d100.foro.db.Usuario) owner;
		}
	}

	@Transient
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}

	};

	@Column(name = "`IdNotificacion`", nullable = false, length = 20)
	@Id
	@GeneratedValue(generator = "COM_MDS2_D100_FORO_DB_NOTIFICACION_IDNOTIFICACION_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_MDS2_D100_FORO_DB_NOTIFICACION_IDNOTIFICACION_GENERATOR", strategy = "native")
	private long idNotificacion;

	@ManyToOne(targetEntity = com.mds2.d100.foro.db.Usuario.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "`UsuarioIdUsuario2`", referencedColumnName = "`IdUsuario`", nullable = false) }, foreignKey = @ForeignKey(name = "FKNotificaci18328"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private com.mds2.d100.foro.db.Usuario enviada_a;

	@Column(name = "`Titulo`", nullable = true, length = 255)
	private String titulo;

	@Column(name = "`Descripcion`", nullable = true, length = 255)
	private String descripcion;

	@Column(name = "`Icono`", nullable = false, length = 1)
	private char icono;

	@Column(name = "`Fecha_creacion`", nullable = false, length = 20)
	private long fecha_creacion;

	private void setIdNotificacion(long value) {
		this.idNotificacion = value;
	}

	public long getIdNotificacion() {
		return idNotificacion;
	}

	public long getORMID() {
		return getIdNotificacion();
	}

	public void setTitulo(String value) {
		this.titulo = value;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setIcono(char value) {
		this.icono = value;
	}

	public char getIcono() {
		return icono;
	}

	public void setFecha_creacion(long value) {
		this.fecha_creacion = value;
	}

	public long getFecha_creacion() {
		return fecha_creacion;
	}

	public void setEnviada_a(com.mds2.d100.foro.db.Usuario value) {
		if (enviada_a != null) {
			enviada_a.recibe.remove(this);
		}
		if (value != null) {
			value.recibe.add(this);
		}
	}

	public com.mds2.d100.foro.db.Usuario getEnviada_a() {
		return enviada_a;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Enviada_a(com.mds2.d100.foro.db.Usuario value) {
		this.enviada_a = value;
	}

	private com.mds2.d100.foro.db.Usuario getORM_Enviada_a() {
		return enviada_a;
	}

	public String toString() {
		return String.valueOf(getIdNotificacion());
	}

}
