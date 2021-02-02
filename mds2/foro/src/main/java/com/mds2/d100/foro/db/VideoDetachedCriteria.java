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

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.ByteArrayExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class VideoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression idVideo;
	public final StringExpression url;
	public final ByteArrayExpression storage;
	public final CollectionExpression mensaje;

	public VideoDetachedCriteria() {
		super(com.mds2.d100.foro.db.Video.class, com.mds2.d100.foro.db.VideoCriteria.class);
		idVideo = new LongExpression("idVideo", this.getDetachedCriteria());
		url = new StringExpression("url", this.getDetachedCriteria());
		storage = new ByteArrayExpression("storage", this.getDetachedCriteria());
		mensaje = new CollectionExpression("ORM_mensaje", this.getDetachedCriteria());
	}

	public VideoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds2.d100.foro.db.VideoCriteria.class);
		idVideo = new LongExpression("idVideo", this.getDetachedCriteria());
		url = new StringExpression("url", this.getDetachedCriteria());
		storage = new ByteArrayExpression("storage", this.getDetachedCriteria());
		mensaje = new CollectionExpression("ORM_mensaje", this.getDetachedCriteria());
	}

	public MensajeDetachedCriteria createMensajeCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_mensaje"));
	}

	public Video uniqueVideo(PersistentSession session) {
		return (Video) super.createExecutableCriteria(session).uniqueResult();
	}

	public Video[] listVideo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Video[]) list.toArray(new Video[list.size()]);
	}
}
