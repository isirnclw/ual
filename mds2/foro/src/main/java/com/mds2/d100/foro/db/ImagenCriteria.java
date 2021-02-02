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
import org.orm.criteria.ByteArrayExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class ImagenCriteria extends AbstractORMCriteria {
	public final LongExpression idImagen;
	public final StringExpression url;
	public final ByteArrayExpression storage;
	public final LongExpression usuarioId;
	public final AssociationExpression usuario;
	public final CollectionExpression mensaje;

	public ImagenCriteria(Criteria criteria) {
		super(criteria);
		idImagen = new LongExpression("idImagen", this);
		url = new StringExpression("url", this);
		storage = new ByteArrayExpression("storage", this);
		usuarioId = new LongExpression("usuario.idImagen", this);
		usuario = new AssociationExpression("usuario", this);
		mensaje = new CollectionExpression("ORM_mensaje", this);
	}

	public ImagenCriteria(PersistentSession session) {
		this(session.createCriteria(Imagen.class));
	}

	public ImagenCriteria() throws PersistentException {
		this(MDSproyectoPersistentManager.instance().getSession());
	}

	public UsuarioCriteria createUsuarioCriteria() {
		return new UsuarioCriteria(createCriteria("usuario"));
	}

	public MensajeCriteria createMensajeCriteria() {
		return new MensajeCriteria(createCriteria("ORM_mensaje"));
	}

	public Imagen uniqueImagen() {
		return (Imagen) super.uniqueResult();
	}

	public Imagen[] listImagen() {
		java.util.List list = super.list();
		return (Imagen[]) list.toArray(new Imagen[list.size()]);
	}
}
