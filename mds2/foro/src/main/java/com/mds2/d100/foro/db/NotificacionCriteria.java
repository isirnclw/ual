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
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.CharacterExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class NotificacionCriteria extends AbstractORMCriteria {
	public final LongExpression idNotificacion;
	public final LongExpression enviada_aId;
	public final AssociationExpression enviada_a;
	public final StringExpression titulo;
	public final StringExpression descripcion;
	public final CharacterExpression icono;
	public final LongExpression fecha_creacion;

	public NotificacionCriteria(Criteria criteria) {
		super(criteria);
		idNotificacion = new LongExpression("idNotificacion", this);
		enviada_aId = new LongExpression("enviada_a.idUsuario", this);
		enviada_a = new AssociationExpression("enviada_a", this);
		titulo = new StringExpression("titulo", this);
		descripcion = new StringExpression("descripcion", this);
		icono = new CharacterExpression("icono", this);
		fecha_creacion = new LongExpression("fecha_creacion", this);
	}

	public NotificacionCriteria(PersistentSession session) {
		this(session.createCriteria(Notificacion.class));
	}

	public NotificacionCriteria() throws PersistentException {
		this(MDSproyectoPersistentManager.instance().getSession());
	}

	public UsuarioCriteria createEnviada_aCriteria() {
		return new UsuarioCriteria(createCriteria("enviada_a"));
	}

	public Notificacion uniqueNotificacion() {
		return (Notificacion) super.uniqueResult();
	}

	public Notificacion[] listNotificacion() {
		java.util.List list = super.list();
		return (Notificacion[]) list.toArray(new Notificacion[list.size()]);
	}
}
