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
import org.orm.criteria.ByteExpression;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.LongExpression;
import org.orm.criteria.StringExpression;

@SuppressWarnings({ "all", "unchecked" })
public class UsuarioCriteria extends AbstractORMCriteria {
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

	public UsuarioCriteria(Criteria criteria) {
		super(criteria);
		idUsuario = new LongExpression("idUsuario", this);
		fotoPerfilId = new LongExpression("fotoPerfil.idImagen", this);
		fotoPerfil = new AssociationExpression("fotoPerfil", this);
		apodo = new StringExpression("apodo", this);
		nombre = new StringExpression("nombre", this);
		descripcion = new StringExpression("descripcion", this);
		contrasena = new StringExpression("contrasena", this);
		email = new StringExpression("email", this);
		perfil_publico = new BooleanExpression("perfil_publico", this);
		conectado = new BooleanExpression("conectado", this);
		notificarAlCorreo = new BooleanExpression("notificarAlCorreo", this);
		notificarRespuestas = new BooleanExpression("notificarRespuestas", this);
		maxItemsPerfil = new IntegerExpression("maxItemsPerfil", this);
		importancia = new ByteExpression("importancia", this);
		reportado = new BooleanExpression("reportado", this);
		amistados = new CollectionExpression("ORM_amistados", this);
		likesMensajes = new CollectionExpression("ORM_likesMensajes", this);
		likesTemas = new CollectionExpression("ORM_likesTemas", this);
		amigos = new CollectionExpression("ORM_amigos", this);
		mensajes = new CollectionExpression("ORM_mensajes", this);
		recibe = new CollectionExpression("ORM_recibe", this);
	}

	public UsuarioCriteria(PersistentSession session) {
		this(session.createCriteria(Usuario.class));
	}

	public UsuarioCriteria() throws PersistentException {
		this(MDSproyectoPersistentManager.instance().getSession());
	}

	public ImagenCriteria createFotoPerfilCriteria() {
		return new ImagenCriteria(createCriteria("fotoPerfil"));
	}

	public UsuarioCriteria createAmistadosCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_amistados"));
	}

	public MensajeCriteria createLikesMensajesCriteria() {
		return new MensajeCriteria(createCriteria("ORM_likesMensajes"));
	}

	public TemaCriteria createLikesTemasCriteria() {
		return new TemaCriteria(createCriteria("ORM_likesTemas"));
	}

	public UsuarioCriteria createAmigosCriteria() {
		return new UsuarioCriteria(createCriteria("ORM_amigos"));
	}

	public MensajeCriteria createMensajesCriteria() {
		return new MensajeCriteria(createCriteria("ORM_mensajes"));
	}

	public NotificacionCriteria createRecibeCriteria() {
		return new NotificacionCriteria(createCriteria("ORM_recibe"));
	}

	public Usuario uniqueUsuario() {
		return (Usuario) super.uniqueResult();
	}

	public Usuario[] listUsuario() {
		java.util.List list = super.list();
		return (Usuario[]) list.toArray(new Usuario[list.size()]);
	}
}
