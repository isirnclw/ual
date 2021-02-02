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
import org.orm.criteria.BooleanExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class SeccionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression idSeccion;
	public final LongExpression creado_porId;
	public final AssociationExpression creado_por;
	public final StringExpression titulo;
	public final StringExpression subtitulo;
	public final IntegerExpression num_mensajes;
	public final LongExpression fecha_creacion;
	public final BooleanExpression oculto;
	public final BooleanExpression eliminado;
	public final CollectionExpression temas;

	public SeccionDetachedCriteria() {
		super(com.mds2.d100.foro.db.Seccion.class, com.mds2.d100.foro.db.SeccionCriteria.class);
		idSeccion = new LongExpression("idSeccion", this.getDetachedCriteria());
		creado_porId = new LongExpression("creado_por.idUsuario", this.getDetachedCriteria());
		creado_por = new AssociationExpression("creado_por", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		subtitulo = new StringExpression("subtitulo", this.getDetachedCriteria());
		num_mensajes = new IntegerExpression("num_mensajes", this.getDetachedCriteria());
		fecha_creacion = new LongExpression("fecha_creacion", this.getDetachedCriteria());
		oculto = new BooleanExpression("oculto", this.getDetachedCriteria());
		eliminado = new BooleanExpression("eliminado", this.getDetachedCriteria());
		temas = new CollectionExpression("ORM_temas", this.getDetachedCriteria());
	}

	public SeccionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds2.d100.foro.db.SeccionCriteria.class);
		idSeccion = new LongExpression("idSeccion", this.getDetachedCriteria());
		creado_porId = new LongExpression("creado_por.idUsuario", this.getDetachedCriteria());
		creado_por = new AssociationExpression("creado_por", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		subtitulo = new StringExpression("subtitulo", this.getDetachedCriteria());
		num_mensajes = new IntegerExpression("num_mensajes", this.getDetachedCriteria());
		fecha_creacion = new LongExpression("fecha_creacion", this.getDetachedCriteria());
		oculto = new BooleanExpression("oculto", this.getDetachedCriteria());
		eliminado = new BooleanExpression("eliminado", this.getDetachedCriteria());
		temas = new CollectionExpression("ORM_temas", this.getDetachedCriteria());
	}

	public UsuarioDetachedCriteria createCreado_porCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("creado_por"));
	}

	public TemaDetachedCriteria createTemasCriteria() {
		return new TemaDetachedCriteria(createCriteria("ORM_temas"));
	}

	public Seccion uniqueSeccion(PersistentSession session) {
		return (Seccion) super.createExecutableCriteria(session).uniqueResult();
	}

	public Seccion[] listSeccion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Seccion[]) list.toArray(new Seccion[list.size()]);
	}
}
