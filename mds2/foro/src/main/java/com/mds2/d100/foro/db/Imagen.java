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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "`Imagen`")
@SuppressWarnings({ "all", "unchecked" })
public class Imagen implements Serializable {
	public Imagen() {
	}

	private java.util.Set this_getSet(int key) {
		if (key == ORMConstants.KEY_IMAGEN_MENSAJE) {
			return ORM_mensaje;
		}

		return null;
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_IMAGEN_USUARIO) {
			this.usuario = (com.mds2.d100.foro.db.Usuario) owner;
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

	@Column(name = "`IdImagen`", nullable = false, length = 20)
	@Id
	@GeneratedValue(generator = "COM_MDS2_D100_FORO_DB_IMAGEN_IDIMAGEN_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_MDS2_D100_FORO_DB_IMAGEN_IDIMAGEN_GENERATOR", strategy = "native")
	private long idImagen;

	@Column(name = "`Url`", nullable = true, length = 255)
	private String url;

	@Column(name = "`Storage`", nullable = true, length = 255)
	private byte[] storage;

	@OneToOne(mappedBy = "fotoPerfil", targetEntity = com.mds2.d100.foro.db.Usuario.class, fetch = FetchType.LAZY)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
	private com.mds2.d100.foro.db.Usuario usuario;

	@ManyToMany(mappedBy = "ORM_imagenes", targetEntity = com.mds2.d100.foro.db.Mensaje.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_mensaje = new java.util.HashSet();

	private void setIdImagen(long value) {
		this.idImagen = value;
	}

	public long getIdImagen() {
		return idImagen;
	}

	public long getORMID() {
		return getIdImagen();
	}

	public void setUrl(String value) {
		this.url = value;
	}

	public String getUrl() {
		return url;
	}

	public void setStorage(byte[] value) {
		this.storage = value;
	}

	public byte[] getStorage() {
		return storage;
	}

	public void setUsuario(com.mds2.d100.foro.db.Usuario value) {
		if (this.usuario != value) {
			com.mds2.d100.foro.db.Usuario lusuario = this.usuario;
			this.usuario = value;
			if (value != null) {
				usuario.setFotoPerfil(this);
			}
			if (lusuario != null && lusuario.getFotoPerfil() == this) {
				lusuario.setFotoPerfil(null);
			}
		}
	}

	public com.mds2.d100.foro.db.Usuario getUsuario() {
		return usuario;
	}

	private void setORM_Mensaje(java.util.Set value) {
		this.ORM_mensaje = value;
	}

	private java.util.Set getORM_Mensaje() {
		return ORM_mensaje;
	}

	@Transient
	public final com.mds2.d100.foro.db.MensajeSetCollection mensaje = new com.mds2.d100.foro.db.MensajeSetCollection(
			this, _ormAdapter, ORMConstants.KEY_IMAGEN_MENSAJE, ORMConstants.KEY_MENSAJE_IMAGENES,
			ORMConstants.KEY_MUL_MANY_TO_MANY);

	public String toString() {
		return String.valueOf(getIdImagen());
	}

}
