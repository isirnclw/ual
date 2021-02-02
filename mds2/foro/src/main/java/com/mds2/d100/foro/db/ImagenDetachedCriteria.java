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
import org.orm.criteria.ByteArrayExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class ImagenDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression idImagen;
	public final StringExpression url;
	public final ByteArrayExpression storage;
	public final LongExpression usuarioId;
	public final AssociationExpression usuario;
	public final CollectionExpression mensaje;

	public ImagenDetachedCriteria() {
		super(com.mds2.d100.foro.db.Imagen.class, com.mds2.d100.foro.db.ImagenCriteria.class);
		idImagen = new LongExpression("idImagen", this.getDetachedCriteria());
		url = new StringExpression("url", this.getDetachedCriteria());
		storage = new ByteArrayExpression("storage", this.getDetachedCriteria());
		usuarioId = new LongExpression("usuario.idImagen", this.getDetachedCriteria());
		usuario = new AssociationExpression("usuario", this.getDetachedCriteria());
		mensaje = new CollectionExpression("ORM_mensaje", this.getDetachedCriteria());
	}

	public ImagenDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds2.d100.foro.db.ImagenCriteria.class);
		idImagen = new LongExpression("idImagen", this.getDetachedCriteria());
		url = new StringExpression("url", this.getDetachedCriteria());
		storage = new ByteArrayExpression("storage", this.getDetachedCriteria());
		usuarioId = new LongExpression("usuario.idImagen", this.getDetachedCriteria());
		usuario = new AssociationExpression("usuario", this.getDetachedCriteria());
		mensaje = new CollectionExpression("ORM_mensaje", this.getDetachedCriteria());
	}

	public UsuarioDetachedCriteria createUsuarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("usuario"));
	}

	public MensajeDetachedCriteria createMensajeCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_mensaje"));
	}

	public Imagen uniqueImagen(PersistentSession session) {
		return (Imagen) super.createExecutableCriteria(session).uniqueResult();
	}

	public Imagen[] listImagen(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Imagen[]) list.toArray(new Imagen[list.size()]);
	}
}
