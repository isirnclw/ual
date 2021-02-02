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
import org.orm.criteria.ByteExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class UsuarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression idUsuario;
	public final LongExpression fotoPerfilId;
	public final AssociationExpression fotoPerfil;
	public final StringExpression apodo;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final StringExpression contrasena;
	public final StringExpression email;
	public final BooleanExpression perfil_publico;
	public final BooleanExpression conectado;
	public final BooleanExpression notificarAlCorreo;
	public final BooleanExpression notificarRespuestas;
	public final IntegerExpression maxItemsPerfil;
	public final ByteExpression importancia;
	public final BooleanExpression reportado;
	public final CollectionExpression amistados;
	public final CollectionExpression likesMensajes;
	public final CollectionExpression likesTemas;
	public final CollectionExpression amigos;
	public final CollectionExpression mensajes;
	public final CollectionExpression recibe;

	public UsuarioDetachedCriteria() {
		super(com.mds2.d100.foro.db.Usuario.class, com.mds2.d100.foro.db.UsuarioCriteria.class);
		idUsuario = new LongExpression("idUsuario", this.getDetachedCriteria());
		fotoPerfilId = new LongExpression("fotoPerfil.idImagen", this.getDetachedCriteria());
		fotoPerfil = new AssociationExpression("fotoPerfil", this.getDetachedCriteria());
		apodo = new StringExpression("apodo", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		perfil_publico = new BooleanExpression("perfil_publico", this.getDetachedCriteria());
		conectado = new BooleanExpression("conectado", this.getDetachedCriteria());
		notificarAlCorreo = new BooleanExpression("notificarAlCorreo", this.getDetachedCriteria());
		notificarRespuestas = new BooleanExpression("notificarRespuestas", this.getDetachedCriteria());
		maxItemsPerfil = new IntegerExpression("maxItemsPerfil", this.getDetachedCriteria());
		importancia = new ByteExpression("importancia", this.getDetachedCriteria());
		reportado = new BooleanExpression("reportado", this.getDetachedCriteria());
		amistados = new CollectionExpression("ORM_amistados", this.getDetachedCriteria());
		likesMensajes = new CollectionExpression("ORM_likesMensajes", this.getDetachedCriteria());
		likesTemas = new CollectionExpression("ORM_likesTemas", this.getDetachedCriteria());
		amigos = new CollectionExpression("ORM_amigos", this.getDetachedCriteria());
		mensajes = new CollectionExpression("ORM_mensajes", this.getDetachedCriteria());
		recibe = new CollectionExpression("ORM_recibe", this.getDetachedCriteria());
	}

	public UsuarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mds2.d100.foro.db.UsuarioCriteria.class);
		idUsuario = new LongExpression("idUsuario", this.getDetachedCriteria());
		fotoPerfilId = new LongExpression("fotoPerfil.idImagen", this.getDetachedCriteria());
		fotoPerfil = new AssociationExpression("fotoPerfil", this.getDetachedCriteria());
		apodo = new StringExpression("apodo", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		contrasena = new StringExpression("contrasena", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		perfil_publico = new BooleanExpression("perfil_publico", this.getDetachedCriteria());
		conectado = new BooleanExpression("conectado", this.getDetachedCriteria());
		notificarAlCorreo = new BooleanExpression("notificarAlCorreo", this.getDetachedCriteria());
		notificarRespuestas = new BooleanExpression("notificarRespuestas", this.getDetachedCriteria());
		maxItemsPerfil = new IntegerExpression("maxItemsPerfil", this.getDetachedCriteria());
		importancia = new ByteExpression("importancia", this.getDetachedCriteria());
		reportado = new BooleanExpression("reportado", this.getDetachedCriteria());
		amistados = new CollectionExpression("ORM_amistados", this.getDetachedCriteria());
		likesMensajes = new CollectionExpression("ORM_likesMensajes", this.getDetachedCriteria());
		likesTemas = new CollectionExpression("ORM_likesTemas", this.getDetachedCriteria());
		amigos = new CollectionExpression("ORM_amigos", this.getDetachedCriteria());
		mensajes = new CollectionExpression("ORM_mensajes", this.getDetachedCriteria());
		recibe = new CollectionExpression("ORM_recibe", this.getDetachedCriteria());
	}

	public ImagenDetachedCriteria createFotoPerfilCriteria() {
		return new ImagenDetachedCriteria(createCriteria("fotoPerfil"));
	}

	public UsuarioDetachedCriteria createAmistadosCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_amistados"));
	}

	public MensajeDetachedCriteria createLikesMensajesCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_likesMensajes"));
	}

	public TemaDetachedCriteria createLikesTemasCriteria() {
		return new TemaDetachedCriteria(createCriteria("ORM_likesTemas"));
	}

	public UsuarioDetachedCriteria createAmigosCriteria() {
		return new UsuarioDetachedCriteria(createCriteria("ORM_amigos"));
	}

	public MensajeDetachedCriteria createMensajesCriteria() {
		return new MensajeDetachedCriteria(createCriteria("ORM_mensajes"));
	}

	public NotificacionDetachedCriteria createRecibeCriteria() {
		return new NotificacionDetachedCriteria(createCriteria("ORM_recibe"));
	}

	public Usuario uniqueUsuario(PersistentSession session) {
		return (Usuario) super.createExecutableCriteria(session).uniqueResult();
	}

	public Usuario[] listUsuario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Usuario[]) list.toArray(new Usuario[list.size()]);
	}
}
