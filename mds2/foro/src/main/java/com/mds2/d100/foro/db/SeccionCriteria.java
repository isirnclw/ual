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
import org.orm.criteria.BooleanExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class SeccionCriteria extends AbstractORMCriteria {
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

	public SeccionCriteria(Criteria criteria) {
		super(criteria);
		idSeccion = new LongExpression("idSeccion", this);
		creado_porId = new LongExpression("creado_por.idUsuario", this);
		creado_por = new AssociationExpression("creado_por", this);
		titulo = new StringExpression("titulo", this);
		subtitulo = new StringExpression("subtitulo", this);
		num_mensajes = new IntegerExpression("num_mensajes", this);
		fecha_creacion = new LongExpression("fecha_creacion", this);
		oculto = new BooleanExpression("oculto", this);
		eliminado = new BooleanExpression("eliminado", this);
		temas = new CollectionExpression("ORM_temas", this);
	}

	public SeccionCriteria(PersistentSession session) {
		this(session.createCriteria(Seccion.class));
	}

	public SeccionCriteria() throws PersistentException {
		this(MDSproyectoPersistentManager.instance().getSession());
	}

	public UsuarioCriteria createCreado_porCriteria() {
		return new UsuarioCriteria(createCriteria("creado_por"));
	}

	public TemaCriteria createTemasCriteria() {
		return new TemaCriteria(createCriteria("ORM_temas"));
	}

	public Seccion uniqueSeccion() {
		return (Seccion) super.uniqueResult();
	}

	public Seccion[] listSeccion() {
		java.util.List list = super.list();
		return (Seccion[]) list.toArray(new Seccion[list.size()]);
	}
}
