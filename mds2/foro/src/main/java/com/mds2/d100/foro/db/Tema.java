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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "`Tema`")
@SuppressWarnings({ "all", "unchecked" })
public class Tema implements Serializable {
	public Tema() {
	}

	private java.util.Set this_getSet(int key) {
		if (key == ORMConstants.KEY_TEMA_MENSAJESTEMA) {
			return ORM_mensajesTema;
		} else if (key == ORMConstants.KEY_TEMA_T_GUSTA_A) {
			return ORM_t_gusta_a;
		}

		return null;
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_TEMA_SECCION) {
			this.seccion = (com.mds2.d100.foro.db.Seccion) owner;
		}

		else if (key == ORMConstants.KEY_TEMA_CREADO_POR) {
			this.creado_por = (com.mds2.d100.foro.db.Usuario) owner;
		}
	}

	@Transient
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}

		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}

	};

	@Column(name = "`IdTema`", nullable = false, length = 20)
	@Id
	@GeneratedValue(generator = "COM_MDS2_D100_FORO_DB_TEMA_IDTEMA_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_MDS2_D100_FORO_DB_TEMA_IDTEMA_GENERATOR", strategy = "native")
	private long idTema;

	@ManyToOne(targetEntity = com.mds2.d100.foro.db.Seccion.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "`SeccionIdSeccion`", referencedColumnName = "`IdSeccion`", nullable = false) }, foreignKey = @ForeignKey(name = "FKTema655261"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private com.mds2.d100.foro.db.Seccion seccion;

	@ManyToOne(targetEntity = com.mds2.d100.foro.db.Usuario.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "`UsuarioIdUsuario`", referencedColumnName = "`IdUsuario`", nullable = false) }, foreignKey = @ForeignKey(name = "FKTema394084"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private com.mds2.d100.foro.db.Usuario creado_por;

	@Column(name = "`Titulo`", nullable = true, length = 255)
	private String titulo;

	@Column(name = "`Subtitulo`", nullable = true, length = 255)
	private String subtitulo;

	@Column(name = "`Num_likes`", nullable = false, length = 10)
	private int num_likes;

	@Column(name = "`Fecha_ult_mens`", nullable = false, length = 20)
	private long fecha_ult_mens;

	@Column(name = "`Autor_ult_mens`", nullable = true, length = 255)
	private String autor_ult_mens;

	@Column(name = "`Icono`", nullable = false, length = 1)
	private char icono;

	@Column(name = "`Fecha_creacion`", nullable = false, length = 20)
	private long fecha_creacion;

	@Column(name = "`Oculto`", nullable = false, length = 1)
	private boolean oculto;

	@Column(name = "`Eliminado`", nullable = false, length = 1)
	private boolean eliminado;

	@OneToMany(mappedBy = "pertenece_a", targetEntity = com.mds2.d100.foro.db.Mensaje.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_mensajesTema = new java.util.HashSet();

	@ManyToMany(targetEntity = com.mds2.d100.foro.db.Usuario.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "`Usuario_Tema`", joinColumns = { @JoinColumn(name = "`TemaIdTema`") }, inverseJoinColumns = {
			@JoinColumn(name = "`UsuarioIdUsuario`") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_t_gusta_a = new java.util.HashSet();

	private void setIdTema(long value) {
		this.idTema = value;
	}

	public long getIdTema() {
		return idTema;
	}

	public long getORMID() {
		return getIdTema();
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

	public void setNum_likes(int value) {
		this.num_likes = value;
	}

	public int getNum_likes() {
		return num_likes;
	}

	public void setFecha_ult_mens(long value) {
		this.fecha_ult_mens = value;
	}

	public long getFecha_ult_mens() {
		return fecha_ult_mens;
	}

	public void setAutor_ult_mens(String value) {
		this.autor_ult_mens = value;
	}

	public String getAutor_ult_mens() {
		return autor_ult_mens;
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

	public void setSeccion(com.mds2.d100.foro.db.Seccion value) {
		if (seccion != null) {
			seccion.temas.remove(this);
		}
		if (value != null) {
			value.temas.add(this);
		}
	}

	public com.mds2.d100.foro.db.Seccion getSeccion() {
		return seccion;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Seccion(com.mds2.d100.foro.db.Seccion value) {
		this.seccion = value;
	}

	private com.mds2.d100.foro.db.Seccion getORM_Seccion() {
		return seccion;
	}

	private void setORM_MensajesTema(java.util.Set value) {
		this.ORM_mensajesTema = value;
	}

	private java.util.Set getORM_MensajesTema() {
		return ORM_mensajesTema;
	}

	@Transient
	public final com.mds2.d100.foro.db.MensajeSetCollection mensajesTema = new com.mds2.d100.foro.db.MensajeSetCollection(
			this, _ormAdapter, ORMConstants.KEY_TEMA_MENSAJESTEMA, ORMConstants.KEY_MENSAJE_PERTENECE_A,
			ORMConstants.KEY_MUL_ONE_TO_MANY);

	private void setORM_T_gusta_a(java.util.Set value) {
		this.ORM_t_gusta_a = value;
	}

	private java.util.Set getORM_T_gusta_a() {
		return ORM_t_gusta_a;
	}

	@Transient
	public final com.mds2.d100.foro.db.UsuarioSetCollection t_gusta_a = new com.mds2.d100.foro.db.UsuarioSetCollection(
			this, _ormAdapter, ORMConstants.KEY_TEMA_T_GUSTA_A, ORMConstants.KEY_USUARIO_LIKESTEMAS,
			ORMConstants.KEY_MUL_MANY_TO_MANY);

	public void setCreado_por(com.mds2.d100.foro.db.Usuario value) {
		this.creado_por = value;
	}

	public com.mds2.d100.foro.db.Usuario getCreado_por() {
		return creado_por;
	}

	public String toString() {
		return String.valueOf(getIdTema());
	}

}
