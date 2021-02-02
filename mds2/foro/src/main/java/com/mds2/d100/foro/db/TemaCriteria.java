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
import org.orm.criteria.CharacterExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class TemaCriteria extends AbstractORMCriteria {
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

	public TemaCriteria(Criteria criteria) {
		super(criteria);
		idTema = new LongExpression("idTema", this);
		seccionId = new LongExpression("seccion.idSeccion", this);
		seccion = new AssociationExpression("seccion", this);
		creado_porId = new LongExpression("creado_por.idUsuario", this);
		creado_por = new AssociationExpression("creado_por", this);
		titulo = new StringExpression("titulo", this);
		subtitulo = new StringExpression("subtitulo", this);
		num_likes = new IntegerExpression("num_likes", this);
		fecha_ult_mens = new LongExpression("fecha_ult_mens", this);
		autor_ult_mens = new StringExpression("autor_ult_mens", this);
		icono = new CharacterExpression("icono", this);
		fecha_creacion = new LongExpression("fecha_creacion", this);
		oculto = new BooleanExpression("oculto", this);
		eliminado = new BooleanExpression("eliminado", this);
		mensajesTema = new CollectionExpression("ORM_mensajesTema", this);
		t_gusta_a = new CollectionExpression("ORM_t_gusta_a", this);
	}

	public TemaCriteria(PersistentSession session) {
		this(session.createCriteria(Tema.class));
	}

	public TemaCriteria() throws PersistentException {
		this(MDSproyectoPersistentManager.instance().getSession());
	}

	public SeccionCriteria createSeccionCriteria() {
		return new SeccionCriteria(createCriteria("seccion"));
	}

	public UsuarioCriteria createCreado_porCriteria() {
		return new UsuarioCriteria(createCriteria("creado_por"));
	}

	public MensajeCriteria createMensajesTemaCriteria() {
		return new MensajeCriteria(createCriteria("ORM_mensajesTema"));
	}

	public UsuarioCriteria createT_gusta_aCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_t_gusta_a"));
	}

	public Tema uniqueTema() {
		return (Tema) super.uniqueResult();
	}

	public Tema[] listTema() {
		java.util.List list = super.list();
		return (Tema[]) list.toArray(new Tema[list.size()]);
	}
}
