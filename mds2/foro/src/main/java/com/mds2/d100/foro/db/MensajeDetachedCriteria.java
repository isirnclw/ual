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
public class MensajeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression idMensaje;
	public final LongExpression pertenece_aId;
	public final AssociationExpression pertenece_a;
	public final LongExpression respondidoId;
	public final AssociationExpression respondido;
	public final LongExpression videoId;
	public final AssociationExpression video;
	public final LongExpression propietarioId;
	public final AssociationExpression propietario;
	public final StringExpression texto;
	public final IntegerExpression num_likes;
	public final LongExpression fecha_creacion;
	public final BooleanExpression oculto;
	public final BooleanExpression eliminado;
	public final StringExpression videoMultimediaUrl;
	public final CollectionExpression m_gusta_a;
	public final CollectionExpression imagenes;
	public final CollectionExpression respuestas;

	public MensajeDetachedCriteria() {
		super(com.mds2.d100.foro.db.Mensaje.class, com.mds2.d100.foro.db.MensajeCriteria.class);
		idMensaje = new LongExpression("idMensaje", this.getDetachedCriteria());
		pertenece_aId = new LongExpression("pertenece_a.idTema", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		respondidoId = new LongExpression("respondido.idMensaje", this.getDetachedCriteria());
		respondido = new AssociationExpression("respondido", this.getDetachedCriteria());
		videoId = new LongExpression("video.idVideo", this.getDetachedCriteria());
		video = new AssociationExpression("video", this.getDetachedCriteria());
		propietarioId = new LongExpression("propietario.idUsuario", this.getDetachedCriteria());
		propietario = new AssociationExpression("propietario", this.getDetachedCriteria());
		texto = new StringExpression("texto", this.getDetachedCriteria());
		num_likes = new IntegerExpression("num_likes", this.getDetachedCriteria());
		fecha_creacion = new LongExpression("fecha_creacion", this.getDetachedCriteria());
		oculto = new BooleanExpression("oculto", this.getDetachedCriteria());
		eliminado = new BooleanExpression("eliminado", this.getDetachedCriteria());
		videoMultimediaUrl = new StringExpression("videoMultimediaUrl", this.getDetachedCriteria());
		m_gusta_a = new CollectionExpression("ORM_m_gusta_a", this.getDetachedCriteria());
		imagenes = new CollectionExpression("ORM_imagenes", this.getDetachedCriteria());
		respuestas = new CollectionExpression("ORM_respuestas", this.getDetachedCriteria());
	}

	public MensajeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds2.d100.foro.db.MensajeCriteria.class);
		idMensaje = new LongExpression("idMensaje", this.getDetachedCriteria());
		pertenece_aId = new LongExpression("pertenece_a.idTema", this.getDetachedCriteria());
		pertenece_a = new AssociationExpression("pertenece_a", this.getDetachedCriteria());
		respondidoId = new LongExpression("respondido.idMensaje", this.getDetachedCriteria());
		respondido = new AssociationExpression("respondido", this.getDetachedCriteria());
		videoId = new LongExpression("video.idVideo", this.getDetachedCriteria());
		video = new AssociationExpression("video", this.getDetachedCriteria());
		propietarioId = new LongExpression("propietario.idUsuario", this.getDetachedCriteria());
		propietario = new AssociationExpression("propietario", this.getDetachedCriteria());
		texto = new StringExpression("texto", this.getDetachedCriteria());
		num_likes = new IntegerExpression("num_likes", this.getDetachedCriteria());
		fecha_creacion = new LongExpression("fecha_creacion", this.getDetachedCriteria());
		oculto = new BooleanExpression("oculto", this.getDetachedCriteria());
		eliminado = new BooleanExpression("eliminado", this.getDetachedCriteria());
		videoMultimediaUrl = new StringExpression("videoMultimediaUrl", this.getDetachedCriteria());
		m_gusta_a = new CollectionExpression("ORM_m_gusta_a", this.getDetachedCriteria());
		imagenes = new CollectionExpression("ORM_imagenes", this.getDetachedCriteria());
		respuestas = new CollectionExpression("ORM_respuestas", this.getDetachedCriteria());
	}

	public TemaDetachedCriteria createPertenece_aCriteria() {
		return new TemaDetachedCriteria(createCriteria("pertenece_a"));
	}

	public MensajeDetachedCriteria createRespondidoCriteria() {
		return new MensajeDetachedCriteria(createCriteria("respondido"));
	}

	public VideoDetachedCriteria createVideoCriteria() {
		return new VideoDetachedCriteria(createCriteria("video"));
	}

	public UsuarioDetachedCriteria createPropietarioCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("propietario"));
	}

	public UsuarioDetachedCriteria createM_gusta_aCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_m_gusta_a"));
	}

	public ImagenDetachedCriteria createImagenesCriteria() {
		return new ImagenDetachedCriteria(createCriteria("ORM_imagenes"));
	}

	public MensajeDetachedCriteria createRespuestasCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_respuestas"));
	}

	public Mensaje uniqueMensaje(PersistentSession session) {
		return (Mensaje) super.createExecutableCriteria(session).uniqueResult();
	}

	public Mensaje[] listMensaje(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
	}
}
