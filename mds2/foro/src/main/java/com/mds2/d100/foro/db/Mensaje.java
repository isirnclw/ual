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
@Table(name = "`Mensaje`")
@SuppressWarnings({ "all", "unchecked" })
public class Mensaje implements Serializable {
	public Mensaje() {
	}

	private java.util.Set this_getSet(int key) {
		if (key == ORMConstants.KEY_MENSAJE_M_GUSTA_A) {
			return ORM_m_gusta_a;
		} else if (key == ORMConstants.KEY_MENSAJE_IMAGENES) {
			return ORM_imagenes;
		} else if (key == ORMConstants.KEY_MENSAJE_RESPUESTAS) {
			return ORM_respuestas;
		}

		return null;
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_MENSAJE_RESPONDIDO) {
			this.respondido = (com.mds2.d100.foro.db.Mensaje) owner;
		}

		else if (key == ORMConstants.KEY_MENSAJE_PROPIETARIO) {
			this.propietario = (com.mds2.d100.foro.db.Usuario) owner;
		}

		else if (key == ORMConstants.KEY_MENSAJE_VIDEO) {
			this.video = (com.mds2.d100.foro.db.Video) owner;
		}

		else if (key == ORMConstants.KEY_MENSAJE_PERTENECE_A) {
			this.pertenece_a = (com.mds2.d100.foro.db.Tema) owner;
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

	@Column(name = "`IdMensaje`", nullable = false, length = 20)
	@Id
	@GeneratedValue(generator = "COM_MDS2_D100_FORO_DB_MENSAJE_IDMENSAJE_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_MDS2_D100_FORO_DB_MENSAJE_IDMENSAJE_GENERATOR", strategy = "native")
	private long idMensaje;

	@ManyToOne(targetEntity = com.mds2.d100.foro.db.Tema.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "`TemaIdTema`", referencedColumnName = "`IdTema`", nullable = false) }, foreignKey = @ForeignKey(name = "FKMensaje869428"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private com.mds2.d100.foro.db.Tema pertenece_a;

	@ManyToOne(targetEntity = com.mds2.d100.foro.db.Mensaje.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "`MensajeIdMensaje`", referencedColumnName = "`IdMensaje`") }, foreignKey = @ForeignKey(name = "FKMensaje909498"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private com.mds2.d100.foro.db.Mensaje respondido;

	@ManyToOne(targetEntity = com.mds2.d100.foro.db.Video.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "`VideoIdVideo`", referencedColumnName = "`IdVideo`") }, foreignKey = @ForeignKey(name = "FKMensaje164539"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private com.mds2.d100.foro.db.Video video;

	@ManyToOne(targetEntity = com.mds2.d100.foro.db.Usuario.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "`UsuarioIdUsuario`", referencedColumnName = "`IdUsuario`", nullable = false) }, foreignKey = @ForeignKey(name = "FKMensaje217044"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private com.mds2.d100.foro.db.Usuario propietario;

	@Column(name = "`Texto`", nullable = true, length = 255)
	private String texto;

	@Column(name = "`Num_likes`", nullable = false, length = 10)
	private int num_likes = 0;

	@Column(name = "`Fecha_creacion`", nullable = false, length = 20)
	private long fecha_creacion;

	@Column(name = "`Oculto`", nullable = false, length = 1)
	private boolean oculto;

	@Column(name = "`Eliminado`", nullable = false, length = 1)
	private boolean eliminado;

	@Column(name = "`VideoMultimediaUrl`", nullable = true, length = 255)
	private String videoMultimediaUrl;

	@ManyToMany(targetEntity = com.mds2.d100.foro.db.Usuario.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "`Usuario_Mensaje`", joinColumns = {
			@JoinColumn(name = "`MensajeIdMensaje`") }, inverseJoinColumns = {
					@JoinColumn(name = "`UsuarioIdUsuario`") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_m_gusta_a = new java.util.HashSet();

	@ManyToMany(targetEntity = com.mds2.d100.foro.db.Imagen.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "`Imagen_Mensaje`", joinColumns = {
			@JoinColumn(name = "`MensajeIdMensaje`") }, inverseJoinColumns = { @JoinColumn(name = "`ImagenIdImagen`") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_imagenes = new java.util.HashSet();

	@OneToMany(mappedBy = "respondido", targetEntity = com.mds2.d100.foro.db.Mensaje.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_respuestas = new java.util.HashSet();

	private void setIdMensaje(long value) {
		this.idMensaje = value;
	}

	public long getIdMensaje() {
		return idMensaje;
	}

	public long getORMID() {
		return getIdMensaje();
	}

	public void setTexto(String value) {
		this.texto = value;
	}

	public String getTexto() {
		return texto;
	}

	public void setNum_likes(int value) {
		this.num_likes = value;
	}

	public int getNum_likes() {
		return num_likes;
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

	public void setVideoMultimediaUrl(String value) {
		this.videoMultimediaUrl = value;
	}

	public String getVideoMultimediaUrl() {
		return videoMultimediaUrl;
	}

	public void setRespondido(com.mds2.d100.foro.db.Mensaje value) {
		if (respondido != null) {
			respondido.respuestas.remove(this);
		}
		if (value != null) {
			value.respuestas.add(this);
		}
	}

	public com.mds2.d100.foro.db.Mensaje getRespondido() {
		return respondido;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Respondido(com.mds2.d100.foro.db.Mensaje value) {
		this.respondido = value;
	}

	private com.mds2.d100.foro.db.Mensaje getORM_Respondido() {
		return respondido;
	}

	public void setPropietario(com.mds2.d100.foro.db.Usuario value) {
		if (propietario != null) {
			propietario.mensajes.remove(this);
		}
		if (value != null) {
			value.mensajes.add(this);
		}
	}

	public com.mds2.d100.foro.db.Usuario getPropietario() {
		return propietario;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Propietario(com.mds2.d100.foro.db.Usuario value) {
		this.propietario = value;
	}

	private com.mds2.d100.foro.db.Usuario getORM_Propietario() {
		return propietario;
	}

	private void setORM_M_gusta_a(java.util.Set value) {
		this.ORM_m_gusta_a = value;
	}

	private java.util.Set getORM_M_gusta_a() {
		return ORM_m_gusta_a;
	}

	@Transient
	public final com.mds2.d100.foro.db.UsuarioSetCollection m_gusta_a = new com.mds2.d100.foro.db.UsuarioSetCollection(
			this, _ormAdapter, ORMConstants.KEY_MENSAJE_M_GUSTA_A, ORMConstants.KEY_USUARIO_LIKESMENSAJES,
			ORMConstants.KEY_MUL_MANY_TO_MANY);

	public void setVideo(com.mds2.d100.foro.db.Video value) {
		if (video != null) {
			video.mensaje.remove(this);
		}
		if (value != null) {
			value.mensaje.add(this);
		}
	}

	public com.mds2.d100.foro.db.Video getVideo() {
		return video;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Video(com.mds2.d100.foro.db.Video value) {
		this.video = value;
	}

	private com.mds2.d100.foro.db.Video getORM_Video() {
		return video;
	}

	private void setORM_Imagenes(java.util.Set value) {
		this.ORM_imagenes = value;
	}

	private java.util.Set getORM_Imagenes() {
		return ORM_imagenes;
	}

	@Transient
	public final com.mds2.d100.foro.db.ImagenSetCollection imagenes = new com.mds2.d100.foro.db.ImagenSetCollection(
			this, _ormAdapter, ORMConstants.KEY_MENSAJE_IMAGENES, ORMConstants.KEY_IMAGEN_MENSAJE,
			ORMConstants.KEY_MUL_MANY_TO_MANY);

	public void setPertenece_a(com.mds2.d100.foro.db.Tema value) {
		if (pertenece_a != null) {
			pertenece_a.mensajesTema.remove(this);
		}
		if (value != null) {
			value.mensajesTema.add(this);
		}
	}

	public com.mds2.d100.foro.db.Tema getPertenece_a() {
		return pertenece_a;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Pertenece_a(com.mds2.d100.foro.db.Tema value) {
		this.pertenece_a = value;
	}

	private com.mds2.d100.foro.db.Tema getORM_Pertenece_a() {
		return pertenece_a;
	}

	private void setORM_Respuestas(java.util.Set value) {
		this.ORM_respuestas = value;
	}

	private java.util.Set getORM_Respuestas() {
		return ORM_respuestas;
	}

	@Transient
	public final com.mds2.d100.foro.db.MensajeSetCollection respuestas = new com.mds2.d100.foro.db.MensajeSetCollection(
			this, _ormAdapter, ORMConstants.KEY_MENSAJE_RESPUESTAS, ORMConstants.KEY_MENSAJE_RESPONDIDO,
			ORMConstants.KEY_MUL_ONE_TO_MANY);

	public String toString() {
		return String.valueOf(getIdMensaje());
	}

}
