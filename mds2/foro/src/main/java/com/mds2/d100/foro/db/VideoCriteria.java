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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.ByteArrayExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class VideoCriteria extends AbstractORMCriteria {
	public final LongExpression idVideo;
	public final StringExpression url;
	public final ByteArrayExpression storage;
	public final CollectionExpression mensaje;

	public VideoCriteria(Criteria criteria) {
		super(criteria);
		idVideo = new LongExpression("idVideo", this);
		url = new StringExpression("url", this);
		storage = new ByteArrayExpression("storage", this);
		mensaje = new CollectionExpression("ORM_mensaje", this);
	}

	public VideoCriteria(PersistentSession session) {
		this(session.createCriteria(Video.class));
	}

	public VideoCriteria() throws PersistentException {
		this(MDSproyectoPersistentManager.instance().getSession());
	}

	public MensajeCriteria createMensajeCriteria() {
		return new MensajeCriteria(createCriteria("ORM_mensaje"));
	}

	public Video uniqueVideo() {
		return (Video) super.uniqueResult();
	}

	public Video[] listVideo() {
		java.util.List list = super.list();
		return (Video[]) list.toArray(new Video[list.size()]);
	}
}
