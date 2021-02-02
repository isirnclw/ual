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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "`Seccion`")
@SuppressWarnings({ "all", "unchecked" })
public class Seccion implements Serializable {
	public Seccion() {
	}

	private java.util.Set this_getSet(int key) {
		if (key == ORMConstants.KEY_SECCION_TEMAS) {
			return ORM_temas;
		}

		return null;
	}

	@Transient
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}

	};

	@Column(name = "`IdSeccion`", nullable = false, length = 20)
	@Id
	@GeneratedValue(generator = "COM_MDS2_D100_FORO_DB_SECCION_IDSECCION_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_MDS2_D100_FORO_DB_SECCION_IDSECCION_GENERATOR", strategy = "native")
	private long idSeccion;

	@ManyToOne(targetEntity = com.mds2.d100.foro.db.Usuario.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "`UsuarioIdUsuario`", referencedColumnName = "`IdUsuario`", nullable = false) }, foreignKey = @ForeignKey(name = "FKSeccion788769"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private com.mds2.d100.foro.db.Usuario creado_por;

	@Column(name = "`Titulo`", nullable = true, length = 255)
	private String titulo;

	@Column(name = "`Subtitulo`", nullable = true, length = 255)
	private String subtitulo;

	@Column(name = "`Num_mensajes`", nullable = false, length = 10)
	private int num_mensajes;

	@Column(name = "`Fecha_creacion`", nullable = false, length = 20)
	private long fecha_creacion;

	@Column(name = "`Oculto`", nullable = false, length = 1)
	private boolean oculto;

	@Column(name = "`Eliminado`", nullable = false, length = 1)
	private boolean eliminado;

	@OneToMany(mappedBy = "seccion", targetEntity = com.mds2.d100.foro.db.Tema.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_temas = new java.util.HashSet();

	private void setIdSeccion(long value) {
		this.idSeccion = value;
	}

	public long getIdSeccion() {
		return idSeccion;
	}

	public long getORMID() {
		return getIdSeccion();
	}

	public void setTitulo(String value) {
		this.titulo = value;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setSubtitulo(String value) {
		this.subtitulo = value;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setNum_mensajes(int value) {
		this.num_mensajes = value;
	}

	public int getNum_mensajes() {
		return num_mensajes;
	}

	public void setFecha_creacion(long value) {
		this.fecha_creacion = value;
	}

	public long getFecha_creacion() {
		return fecha_creacion;
	}

	public void setOculto(boolean value) {
		this.oculto = value;
	}

	public boolean getOculto() {
		return oculto;
	}

	public void setEliminado(boolean value) {
		this.eliminado = value;
	}

	public boolean getEliminado() {
		return eliminado;
	}

	public void setCreado_por(com.mds2.d100.foro.db.Usuario value) {
		this.creado_por = value;
	}

	public com.mds2.d100.foro.db.Usuario getCreado_por() {
		return creado_por;
	}

	private void setORM_Temas(java.util.Set value) {
		this.ORM_temas = value;
	}

	private java.util.Set getORM_Temas() {
		return ORM_temas;
	}

	@Transient
	public final com.mds2.d100.foro.db.TemaSetCollection temas = new com.mds2.d100.foro.db.TemaSetCollection(this,
			_ormAdapter, ORMConstants.KEY_SECCION_TEMAS, ORMConstants.KEY_TEMA_SECCION,
			ORMConstants.KEY_MUL_ONE_TO_MANY);

	public String toString() {
		return String.valueOf(getIdSeccion());
	}

}
