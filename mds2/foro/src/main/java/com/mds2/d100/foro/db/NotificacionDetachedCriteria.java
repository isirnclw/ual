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
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.CharacterExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class NotificacionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression idNotificacion;
	public final LongExpression enviada_aId;
	public final AssociationExpression enviada_a;
	public final StringExpression titulo;
	public final StringExpression descripcion;
	public final CharacterExpression icono;
	public final LongExpression fecha_creacion;

	public NotificacionDetachedCriteria() {
		super(com.mds2.d100.foro.db.Notificacion.class, com.mds2.d100.foro.db.NotificacionCriteria.class);
		idNotificacion = new LongExpression("idNotificacion", this.getDetachedCriteria());
		enviada_aId = new LongExpression("enviada_a.idUsuario", this.getDetachedCriteria());
		enviada_a = new AssociationExpression("enviada_a", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		icono = new CharacterExpression("icono", this.getDetachedCriteria());
		fecha_creacion = new LongExpression("fecha_creacion", this.getDetachedCriteria());
	}

	public NotificacionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds2.d100.foro.db.NotificacionCriteria.class);
		idNotificacion = new LongExpression("idNotificacion", this.getDetachedCriteria());
		enviada_aId = new LongExpression("enviada_a.idUsuario", this.getDetachedCriteria());
		enviada_a = new AssociationExpression("enviada_a", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		icono = new CharacterExpression("icono", this.getDetachedCriteria());
		fecha_creacion = new LongExpression("fecha_creacion", this.getDetachedCriteria());
	}

	public UsuarioDetachedCriteria createEnviada_aCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("enviada_a"));
	}

	public Notificacion uniqueNotificacion(PersistentSession session) {
		return (Notificacion) super.createExecutableCriteria(session).uniqueResult();
	}

	public Notificacion[] listNotificacion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Notificacion[]) list.toArray(new Notificacion[list.size()]);
	}
}
