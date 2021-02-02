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
import org.orm.criteria.CharacterExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class TemaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression idTema;
	public final LongExpression seccionId;
	public final AssociationExpression seccion;
	public final LongExpression creado_porId;
	public final AssociationExpression creado_por;
	public final StringExpression titulo;
	public final StringExpression subtitulo;
	public final IntegerExpression num_likes;
	public final LongExpression fecha_ult_mens;
	public final StringExpression autor_ult_mens;
	public final CharacterExpression icono;
	public final LongExpression fecha_creacion;
	public final BooleanExpression oculto;
	public final BooleanExpression eliminado;
	public final CollectionExpression mensajesTema;
	public final CollectionExpression t_gusta_a;

	public TemaDetachedCriteria() {
		super(com.mds2.d100.foro.db.Tema.class, com.mds2.d100.foro.db.TemaCriteria.class);
		idTema = new LongExpression("idTema", this.getDetachedCriteria());
		seccionId = new LongExpression("seccion.idSeccion", this.getDetachedCriteria());
		seccion = new AssociationExpression("seccion", this.getDetachedCriteria());
		creado_porId = new LongExpression("creado_por.idUsuario", this.getDetachedCriteria());
		creado_por = new AssociationExpression("creado_por", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		subtitulo = new StringExpression("subtitulo", this.getDetachedCriteria());
		num_likes = new IntegerExpression("num_likes", this.getDetachedCriteria());
		fecha_ult_mens = new LongExpression("fecha_ult_mens", this.getDetachedCriteria());
		autor_ult_mens = new StringExpression("autor_ult_mens", this.getDetachedCriteria());
		icono = new CharacterExpression("icono", this.getDetachedCriteria());
		fecha_creacion = new LongExpression("fecha_creacion", this.getDetachedCriteria());
		oculto = new BooleanExpression("oculto", this.getDetachedCriteria());
		eliminado = new BooleanExpression("eliminado", this.getDetachedCriteria());
		mensajesTema = new CollectionExpression("ORM_mensajesTema", this.getDetachedCriteria());
		t_gusta_a = new CollectionExpression("ORM_t_gusta_a", this.getDetachedCriteria());
	}

	public TemaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds2.d100.foro.db.TemaCriteria.class);
		idTema = new LongExpression("idTema", this.getDetachedCriteria());
		seccionId = new LongExpression("seccion.idSeccion", this.getDetachedCriteria());
		seccion = new AssociationExpression("seccion", this.getDetachedCriteria());
		creado_porId = new LongExpression("creado_por.idUsuario", this.getDetachedCriteria());
		creado_por = new AssociationExpression("creado_por", this.getDetachedCriteria());
		titulo = new StringExpression("titulo", this.getDetachedCriteria());
		subtitulo = new StringExpression("subtitulo", this.getDetachedCriteria());
		num_likes = new IntegerExpression("num_likes", this.getDetachedCriteria());
		fecha_ult_mens = new LongExpression("fecha_ult_mens", this.getDetachedCriteria());
		autor_ult_mens = new StringExpression("autor_ult_mens", this.getDetachedCriteria());
		icono = new CharacterExpression("icono", this.getDetachedCriteria());
		fecha_creacion = new LongExpression("fecha_creacion", this.getDetachedCriteria());
		oculto = new BooleanExpression("oculto", this.getDetachedCriteria());
		eliminado = new BooleanExpression("eliminado", this.getDetachedCriteria());
		mensajesTema = new CollectionExpression("ORM_mensajesTema", this.getDetachedCriteria());
		t_gusta_a = new CollectionExpression("ORM_t_gusta_a", this.getDetachedCriteria());
	}

	public SeccionDetachedCriteria createSeccionCriteria() {
		return new SeccionDetachedCriteria(createCriteria("seccion"));
	}

	public UsuarioDetachedCriteria createCreado_porCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("creado_por"));
	}

	public MensajeDetachedCriteria createMensajesTemaCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_mensajesTema"));
	}

	public UsuarioDetachedCriteria createT_gusta_aCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_t_gusta_a"));
	}

	public Tema uniqueTema(PersistentSession session) {
		return (Tema) super.createExecutableCriteria(session).uniqueResult();
	}

	public Tema[] listTema(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Tema[]) list.toArray(new Tema[list.size()]);
	}
}
