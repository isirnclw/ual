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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "`Video`")
@SuppressWarnings({ "all", "unchecked" })
public class Video implements Serializable {
	public Video() {
	}

	private java.util.Set this_getSet(int key) {
		if (key == ORMConstants.KEY_VIDEO_MENSAJE) {
			return ORM_mensaje;
		}

		return null;
	}

	@Transient
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}

	};

	@Column(name = "`IdVideo`", nullable = false, length = 20)
	@Id
	@GeneratedValue(generator = "COM_MDS2_D100_FORO_DB_VIDEO_IDVIDEO_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name = "COM_MDS2_D100_FORO_DB_VIDEO_IDVIDEO_GENERATOR", strategy = "native")
	private long idVideo;

	@Column(name = "`Url`", nullable = true, length = 255)
	private String url;

	@Column(name = "`Storage`", nullable = true, length = 255)
	private byte[] storage;

	@OneToMany(mappedBy = "video", targetEntity = com.mds2.d100.foro.db.Mensaje.class)
	@org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.LOCK })
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
	private java.util.Set ORM_mensaje = new java.util.HashSet();

	private void setIdVideo(long value) {
		this.idVideo = value;
	}

	public long getIdVideo() {
		return idVideo;
	}

	public long getORMID() {
		return getIdVideo();
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

	private void setORM_Mensaje(java.util.Set value) {
		this.ORM_mensaje = value;
	}

	private java.util.Set getORM_Mensaje() {
		return ORM_mensaje;
	}

	@Transient
	public final com.mds2.d100.foro.db.MensajeSetCollection mensaje = new com.mds2.d100.foro.db.MensajeSetCollection(
			this, _ormAdapter, ORMConstants.KEY_VIDEO_MENSAJE, ORMConstants.KEY_MENSAJE_VIDEO,
			ORMConstants.KEY_MUL_ONE_TO_MANY);

	public String toString() {
		return String.valueOf(getIdVideo());
	}

}
