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
public class MensajeCriteria extends AbstractORMCriteria {
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

	public MensajeCriteria(Criteria criteria) {
		super(criteria);
		idMensaje = new LongExpression("idMensaje", this);
		pertenece_aId = new LongExpression("pertenece_a.idTema", this);
		pertenece_a = new AssociationExpression("pertenece_a", this);
		respondidoId = new LongExpression("respondido.idMensaje", this);
		respondido = new AssociationExpression("respondido", this);
		videoId = new LongExpression("video.idVideo", this);
		video = new AssociationExpression("video", this);
		propietarioId = new LongExpression("propietario.idUsuario", this);
		propietario = new AssociationExpression("propietario", this);
		texto = new StringExpression("texto", this);
		num_likes = new IntegerExpression("num_likes", this);
		fecha_creacion = new LongExpression("fecha_creacion", this);
		oculto = new BooleanExpression("oculto", this);
		eliminado = new BooleanExpression("eliminado", this);
		videoMultimediaUrl = new StringExpression("videoMultimediaUrl", this);
		m_gusta_a = new CollectionExpression("ORM_m_gusta_a", this);
		imagenes = new CollectionExpression("ORM_imagenes", this);
		respuestas = new CollectionExpression("ORM_respuestas", this);
	}

	public MensajeCriteria(PersistentSession session) {
		this(session.createCriteria(Mensaje.class));
	}

	public MensajeCriteria() throws PersistentException {
		this(MDSproyectoPersistentManager.instance().getSession());
	}

	public TemaCriteria createPertenece_aCriteria() {
		return new TemaCriteria(createCriteria("pertenece_a"));
	}

	public MensajeCriteria createRespondidoCriteria() {
		return new MensajeCriteria(createCriteria("respondido"));
	}

	public VideoCriteria createVideoCriteria() {
		return new VideoCriteria(createCriteria("video"));
	}

	public UsuarioCriteria createPropietarioCriteria() {
		return new UsuarioCriteria(createCriteria("propietario"));
	}

	public UsuarioCriteria createM_gusta_aCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_m_gusta_a"));
	}

	public ImagenCriteria createImagenesCriteria() {
		return new ImagenCriteria(createCriteria("ORM_imagenes"));
	}

	public MensajeCriteria createRespuestasCriteria() {
		return new MensajeCriteria(createCriteria("ORM_respuestas"));
	}

	public Mensaje uniqueMensaje() {
		return (Mensaje) super.uniqueResult();
	}

	public Mensaje[] listMensaje() {
		java.util.List list = super.list();
		return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
	}
}
