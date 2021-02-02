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

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

@SuppressWarnings({ "all", "unchecked" })
public class UsuarioDAO {
	public static Usuario loadUsuarioByORMID(long idUsuario) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadUsuarioByORMID(session, idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario getUsuarioByORMID(long idUsuario) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getUsuarioByORMID(session, idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario loadUsuarioByORMID(long idUsuario, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadUsuarioByORMID(session, idUsuario, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario getUsuarioByORMID(long idUsuario, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getUsuarioByORMID(session, idUsuario, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario loadUsuarioByORMID(PersistentSession session, long idUsuario) throws PersistentException {
		try {
			return (Usuario) session.load(com.mds2.d100.foro.db.Usuario.class, new Long(idUsuario));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario getUsuarioByORMID(PersistentSession session, long idUsuario) throws PersistentException {
		try {
			return (Usuario) session.get(com.mds2.d100.foro.db.Usuario.class, new Long(idUsuario));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario loadUsuarioByORMID(PersistentSession session, long idUsuario, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			return (Usuario) session.load(com.mds2.d100.foro.db.Usuario.class, new Long(idUsuario), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario getUsuarioByORMID(PersistentSession session, long idUsuario, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			return (Usuario) session.get(com.mds2.d100.foro.db.Usuario.class, new Long(idUsuario), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryUsuario(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryUsuario(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryUsuario(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryUsuario(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario[] listUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listUsuarioByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario[] listUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listUsuarioByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryUsuario(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryUsuario(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario", lockMode);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario[] listUsuarioByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		try {
			List list = queryUsuario(session, condition, orderBy);
			return (Usuario[]) list.toArray(new Usuario[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario[] listUsuarioByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUsuario(session, condition, orderBy, lockMode);
			return (Usuario[]) list.toArray(new Usuario[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario loadUsuarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadUsuarioByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario loadUsuarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadUsuarioByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario loadUsuarioByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		Usuario[] usuarios = listUsuarioByQuery(session, condition, orderBy);
		if (usuarios != null && usuarios.length > 0)
			return usuarios[0];
		else
			return null;
	}

	public static Usuario loadUsuarioByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		Usuario[] usuarios = listUsuarioByQuery(session, condition, orderBy, lockMode);
		if (usuarios != null && usuarios.length > 0)
			return usuarios[0];
		else
			return null;
	}

	public static java.util.Iterator iterateUsuarioByQuery(String condition, String orderBy)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateUsuarioByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateUsuarioByQuery(String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateUsuarioByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateUsuarioByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateUsuarioByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Usuario as Usuario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario", lockMode);
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario createUsuario() {
		return new com.mds2.d100.foro.db.Usuario();
	}

	public static boolean save(com.mds2.d100.foro.db.Usuario usuario) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().saveObject(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(com.mds2.d100.foro.db.Usuario usuario) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().deleteObject(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Usuario usuario) throws PersistentException {
		try {
			if (usuario.getFotoPerfil() != null) {
				usuario.getFotoPerfil().setUsuario(null);
			}

			com.mds2.d100.foro.db.Usuario[] lAmistadoss = usuario.amistados.toArray();
			for (int i = 0; i < lAmistadoss.length; i++) {
				lAmistadoss[i].amigos.remove(usuario);
			}
			com.mds2.d100.foro.db.Mensaje[] lLikesMensajess = usuario.likesMensajes.toArray();
			for (int i = 0; i < lLikesMensajess.length; i++) {
				lLikesMensajess[i].m_gusta_a.remove(usuario);
			}
			com.mds2.d100.foro.db.Tema[] lLikesTemass = usuario.likesTemas.toArray();
			for (int i = 0; i < lLikesTemass.length; i++) {
				lLikesTemass[i].t_gusta_a.remove(usuario);
			}
			com.mds2.d100.foro.db.Usuario[] lAmigoss = usuario.amigos.toArray();
			for (int i = 0; i < lAmigoss.length; i++) {
				lAmigoss[i].amistados.remove(usuario);
			}
			com.mds2.d100.foro.db.Mensaje[] lMensajess = usuario.mensajes.toArray();
			for (int i = 0; i < lMensajess.length; i++) {
				lMensajess[i].setPropietario(null);
			}
			com.mds2.d100.foro.db.Notificacion[] lRecibes = usuario.recibe.toArray();
			for (int i = 0; i < lRecibes.length; i++) {
				lRecibes[i].setEnviada_a(null);
			}
			return delete(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Usuario usuario, org.orm.PersistentSession session)
			throws PersistentException {
		try {
			if (usuario.getFotoPerfil() != null) {
				usuario.getFotoPerfil().setUsuario(null);
			}

			com.mds2.d100.foro.db.Usuario[] lAmistadoss = usuario.amistados.toArray();
			for (int i = 0; i < lAmistadoss.length; i++) {
				lAmistadoss[i].amigos.remove(usuario);
			}
			com.mds2.d100.foro.db.Mensaje[] lLikesMensajess = usuario.likesMensajes.toArray();
			for (int i = 0; i < lLikesMensajess.length; i++) {
				lLikesMensajess[i].m_gusta_a.remove(usuario);
			}
			com.mds2.d100.foro.db.Tema[] lLikesTemass = usuario.likesTemas.toArray();
			for (int i = 0; i < lLikesTemass.length; i++) {
				lLikesTemass[i].t_gusta_a.remove(usuario);
			}
			com.mds2.d100.foro.db.Usuario[] lAmigoss = usuario.amigos.toArray();
			for (int i = 0; i < lAmigoss.length; i++) {
				lAmigoss[i].amistados.remove(usuario);
			}
			com.mds2.d100.foro.db.Mensaje[] lMensajess = usuario.mensajes.toArray();
			for (int i = 0; i < lMensajess.length; i++) {
				lMensajess[i].setPropietario(null);
			}
			com.mds2.d100.foro.db.Notificacion[] lRecibes = usuario.recibe.toArray();
			for (int i = 0; i < lRecibes.length; i++) {
				lRecibes[i].setEnviada_a(null);
			}
			try {
				session.delete(usuario);
				return true;
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean refresh(com.mds2.d100.foro.db.Usuario usuario) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().refresh(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(com.mds2.d100.foro.db.Usuario usuario) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().evict(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Usuario loadUsuarioByCriteria(UsuarioCriteria usuarioCriteria) {
		Usuario[] usuarios = listUsuarioByCriteria(usuarioCriteria);
		if (usuarios == null || usuarios.length == 0) {
			return null;
		}
		return usuarios[0];
	}

	public static Usuario[] listUsuarioByCriteria(UsuarioCriteria usuarioCriteria) {
		return usuarioCriteria.listUsuario();
	}
}
