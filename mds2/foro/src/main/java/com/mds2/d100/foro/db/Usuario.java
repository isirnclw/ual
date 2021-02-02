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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "`Usuario`")
@SuppressWarnings({ "all", "unchecked" })
public class Usuario implements Serializable {
	public Usuario() {
	}

	private java.util.Set this_getSet(int key) {
		if (key == ORMConstants.KEY_USUARIO_AMISTADOS) {
			return ORM_amistados;
		} else if (key == ORMConstants.KEY_USUARIO_LIKESMENSAJES) {
			return ORM_likesMensajes;
		} else if (key == ORMConstants.KEY_USUARIO_LIKESTEMAS) {
			return ORM_likesTemas;
		} else if (key == ORMConstants.KEY_USUARIO_AMIGOS) {
			return ORM_amigos;
		} else if (key == ORMConstants.KEY_USUARIO_MENSAJES) {
			return ORM_mensajes;
		} else if (key == ORMConstants.KEY_USUARIO_RECIBE) {
			return ORM_recibe;
		}

		return null;
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_USUARIO_FOTOPERFIL) {
			this.fotoPerfil = (com.mds2.d100.foro.db.Imagen) owner;
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

	@Column(name = "`IdUsuario`", nullable = false, length = 20)
	@Id
	@GeneratedValue(generator = "COM_MDS2_D100_FORO_DB_USUARIO_IDUSUARIO_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_MDS2_D100_FORO_DB_USUARIO_IDUSUARIO_GENERATOR", strategy = "native")
	private long idUsuario;

	@OneToOne(optional = false, targetEntity = com.mds2.d100.foro.db.Imagen.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinColumns(value = {
			@JoinColumn(name = "`ImagenIdImagen`", referencedColumnName = "`IdImagen`", nullable = false) }, foreignKey = @ForeignKey(name = "FKUsuario914266"))
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private com.mds2.d100.foro.db.Imagen fotoPerfil;

	@Column(name = "`Apodo`", nullable = true, length = 255)
	private String apodo;

	@Column(name = "`Nombre`", nullable = true, length = 255)
	private String nombre;

	@Column(name = "`Descripcion`", nullable = true, length = 255)
	private String descripcion;

	@Column(name = "`Contrasena`", nullable = true, length = 255)
	private String contrasena;

	@Column(name = "`Email`", nullable = true, length = 255)
	private String email;

	@Column(name = "`Perfil_publico`", nullable = false, length = 1)
	private boolean perfil_publico;

	@Column(name = "`Conectado`", nullable = false, length = 1)
	private boolean conectado;

	@Column(name = "`NotificarAlCorreo`", nullable = false, length = 1)
	private boolean notificarAlCorreo;

	@Column(name = "`NotificarRespuestas`", nullable = false, length = 1)
	private boolean notificarRespuestas;

	@Column(name = "`MaxItemsPerfil`", nullable = false, length = 10)
	private int maxItemsPerfil;

	@Column(name = "`Importancia`", nullable = false)
	private byte importancia;

	@Column(name = "`Reportado`", nullable = false, length = 1)
	private boolean reportado;

	@ManyToMany(targetEntity = com.mds2.d100.foro.db.Usuario.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@JoinTable(name = "`Usuario_Usuario`", joinColumns = {
			@JoinColumn(name = "`UsuarioIdUsuario2`") }, inverseJoinColumns = {
					@JoinColumn(name = "`UsuarioIdUsuario`") })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_amistados = new java.util.HashSet();

	@ManyToMany(mappedBy = "ORM_m_gusta_a", targetEntity = com.mds2.d100.foro.db.Mensaje.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_likesMensajes = new java.util.HashSet();

	@ManyToMany(mappedBy = "ORM_t_gusta_a", targetEntity = com.mds2.d100.foro.db.Tema.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_likesTemas = new java.util.HashSet();

	@ManyToMany(mappedBy = "ORM_amistados", targetEntity = com.mds2.d100.foro.db.Usuario.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_amigos = new java.util.HashSet();

	@OneToMany(mappedBy = "propietario", targetEntity = com.mds2.d100.foro.db.Mensaje.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_mensajes = new java.util.HashSet();

	@OneToMany(mappedBy = "enviada_a", targetEntity = com.mds2.d100.foro.db.Notificacion.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_recibe = new java.util.HashSet();

	private void setIdUsuario(long value) {
		this.idUsuario = value;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public long getORMID() {
		return getIdUsuario();
	}

	public void setApodo(String value) {
		this.apodo = value;
	}

	public String getApodo() {
		return apodo;
	}

	public void setNombre(String value) {
		this.nombre = value;
	}

	public String getNombre() {
		return nombre;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setContrasena(String value) {
		this.contrasena = value;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public String getEmail() {
		return email;
	}

	public void setPerfil_publico(boolean value) {
		this.perfil_publico = value;
	}

	public boolean getPerfil_publico() {
		return perfil_publico;
	}

	public void setConectado(boolean value) {
		this.conectado = value;
	}

	public boolean getConectado() {
		return conectado;
	}

	public void setNotificarAlCorreo(boolean value) {
		this.notificarAlCorreo = value;
	}

	public boolean getNotificarAlCorreo() {
		return notificarAlCorreo;
	}

	public void setNotificarRespuestas(boolean value) {
		this.notificarRespuestas = value;
	}

	public boolean getNotificarRespuestas() {
		return notificarRespuestas;
	}

	public void setMaxItemsPerfil(int value) {
		this.maxItemsPerfil = value;
	}

	public int getMaxItemsPerfil() {
		return maxItemsPerfil;
	}

	public void setImportancia(byte value) {
		this.importancia = value;
	}

	public byte getImportancia() {
		return importancia;
	}

	public void setReportado(boolean value) {
		this.reportado = value;
	}

	public boolean getReportado() {
		return reportado;
	}

	private void setORM_Amistados(java.util.Set value) {
		this.ORM_amistados = value;
	}

	private java.util.Set getORM_Amistados() {
		return ORM_amistados;
	}

	@Transient
	public final com.mds2.d100.foro.db.UsuarioSetCollection amistados = new com.mds2.d100.foro.db.UsuarioSetCollection(
			this, _ormAdapter, ORMConstants.KEY_USUARIO_AMISTADOS, ORMConstants.KEY_USUARIO_AMIGOS,
			ORMConstants.KEY_MUL_MANY_TO_MANY);

	public void setFotoPerfil(com.mds2.d100.foro.db.Imagen value) {
		if (this.fotoPerfil != value) {
			com.mds2.d100.foro.db.Imagen lfotoPerfil = this.fotoPerfil;
			this.fotoPerfil = value;
			if (value != null) {
				fotoPerfil.setUsuario(this);
			}
			if (lfotoPerfil != null && lfotoPerfil.getUsuario() == this) {
				lfotoPerfil.setUsuario(null);
			}
		}
	}

	public com.mds2.d100.foro.db.Imagen getFotoPerfil() {
		return fotoPerfil;
	}

	private void setORM_LikesMensajes(java.util.Set value) {
		this.ORM_likesMensajes = value;
	}

	private java.util.Set getORM_LikesMensajes() {
		return ORM_likesMensajes;
	}

	@Transient
	public final com.mds2.d100.foro.db.MensajeSetCollection likesMensajes = new com.mds2.d100.foro.db.MensajeSetCollection(
			this, _ormAdapter, ORMConstants.KEY_USUARIO_LIKESMENSAJES, ORMConstants.KEY_MENSAJE_M_GUSTA_A,
			ORMConstants.KEY_MUL_MANY_TO_MANY);

	private void setORM_LikesTemas(java.util.Set value) {
		this.ORM_likesTemas = value;
	}

	private java.util.Set getORM_LikesTemas() {
		return ORM_likesTemas;
	}

	@Transient
	public final com.mds2.d100.foro.db.TemaSetCollection likesTemas = new com.mds2.d100.foro.db.TemaSetCollection(this,
			_ormAdapter, ORMConstants.KEY_USUARIO_LIKESTEMAS, ORMConstants.KEY_TEMA_T_GUSTA_A,
			ORMConstants.KEY_MUL_MANY_TO_MANY);

	private void setORM_Amigos(java.util.Set value) {
		this.ORM_amigos = value;
	}

	private java.util.Set getORM_Amigos() {
		return ORM_amigos;
	}

	@Transient
	public final com.mds2.d100.foro.db.UsuarioSetCollection amigos = new com.mds2.d100.foro.db.UsuarioSetCollection(
			this, _ormAdapter, ORMConstants.KEY_USUARIO_AMIGOS, ORMConstants.KEY_USUARIO_AMISTADOS,
			ORMConstants.KEY_MUL_MANY_TO_MANY);

	private void setORM_Mensajes(java.util.Set value) {
		this.ORM_mensajes = value;
	}

	private java.util.Set getORM_Mensajes() {
		return ORM_mensajes;
	}

	@Transient
	public final com.mds2.d100.foro.db.MensajeSetCollection mensajes = new com.mds2.d100.foro.db.MensajeSetCollection(
			this, _ormAdapter, ORMConstants.KEY_USUARIO_MENSAJES, ORMConstants.KEY_MENSAJE_PROPIETARIO,
			ORMConstants.KEY_MUL_ONE_TO_MANY);

	private void setORM_Recibe(java.util.Set value) {
		this.ORM_recibe = value;
	}

	private java.util.Set getORM_Recibe() {
		return ORM_recibe;
	}

	@Transient
	public final com.mds2.d100.foro.db.NotificacionSetCollection recibe = new com.mds2.d100.foro.db.NotificacionSetCollection(
			this, _ormAdapter, ORMConstants.KEY_USUARIO_RECIBE, ORMConstants.KEY_NOTIFICACION_ENVIADA_A,
			ORMConstants.KEY_MUL_ONE_TO_MANY);

	public String toString() {
		return String.valueOf(getIdUsuario());
	}

}
