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
public class ImagenDAO {
	public static Imagen loadImagenByORMID(long idImagen) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadImagenByORMID(session, idImagen);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen getImagenByORMID(long idImagen) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getImagenByORMID(session, idImagen);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen loadImagenByORMID(long idImagen, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadImagenByORMID(session, idImagen, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen getImagenByORMID(long idImagen, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getImagenByORMID(session, idImagen, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen loadImagenByORMID(PersistentSession session, long idImagen) throws PersistentException {
		try {
			return (Imagen) session.load(com.mds2.d100.foro.db.Imagen.class, new Long(idImagen));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen getImagenByORMID(PersistentSession session, long idImagen) throws PersistentException {
		try {
			return (Imagen) session.get(com.mds2.d100.foro.db.Imagen.class, new Long(idImagen));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen loadImagenByORMID(PersistentSession session, long idImagen, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			return (Imagen) session.load(com.mds2.d100.foro.db.Imagen.class, new Long(idImagen), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen getImagenByORMID(PersistentSession session, long idImagen, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			return (Imagen) session.get(com.mds2.d100.foro.db.Imagen.class, new Long(idImagen), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryImagen(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryImagen(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryImagen(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryImagen(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen[] listImagenByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listImagenByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen[] listImagenByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listImagenByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryImagen(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Imagen as Imagen");
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

	public static List queryImagen(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Imagen as Imagen");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Imagen", lockMode);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen[] listImagenByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		try {
			List list = queryImagen(session, condition, orderBy);
			return (Imagen[]) list.toArray(new Imagen[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen[] listImagenByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryImagen(session, condition, orderBy, lockMode);
			return (Imagen[]) list.toArray(new Imagen[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen loadImagenByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadImagenByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen loadImagenByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadImagenByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen loadImagenByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		Imagen[] imagens = listImagenByQuery(session, condition, orderBy);
		if (imagens != null && imagens.length > 0)
			return imagens[0];
		else
			return null;
	}

	public static Imagen loadImagenByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		Imagen[] imagens = listImagenByQuery(session, condition, orderBy, lockMode);
		if (imagens != null && imagens.length > 0)
			return imagens[0];
		else
			return null;
	}

	public static java.util.Iterator iterateImagenByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateImagenByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateImagenByQuery(String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateImagenByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateImagenByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Imagen as Imagen");
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

	public static java.util.Iterator iterateImagenByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Imagen as Imagen");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Imagen", lockMode);
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen createImagen() {
		return new com.mds2.d100.foro.db.Imagen();
	}

	public static boolean save(com.mds2.d100.foro.db.Imagen imagen) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().saveObject(imagen);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(com.mds2.d100.foro.db.Imagen imagen) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().deleteObject(imagen);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Imagen imagen) throws PersistentException {
		try {
			if (imagen.getUsuario() != null) {
				imagen.getUsuario().setFotoPerfil(null);
			}

			com.mds2.d100.foro.db.Mensaje[] lMensajes = imagen.mensaje.toArray();
			for (int i = 0; i < lMensajes.length; i++) {
				lMensajes[i].imagenes.remove(imagen);
			}
			return delete(imagen);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Imagen imagen, org.orm.PersistentSession session)
			throws PersistentException {
		try {
			if (imagen.getUsuario() != null) {
				imagen.getUsuario().setFotoPerfil(null);
			}

			com.mds2.d100.foro.db.Mensaje[] lMensajes = imagen.mensaje.toArray();
			for (int i = 0; i < lMensajes.length; i++) {
				lMensajes[i].imagenes.remove(imagen);
			}
			try {
				session.delete(imagen);
				return true;
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean refresh(com.mds2.d100.foro.db.Imagen imagen) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().refresh(imagen);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(com.mds2.d100.foro.db.Imagen imagen) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().evict(imagen);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Imagen loadImagenByCriteria(ImagenCriteria imagenCriteria) {
		Imagen[] imagens = listImagenByCriteria(imagenCriteria);
		if (imagens == null || imagens.length == 0) {
			return null;
		}
		return imagens[0];
	}

	public static Imagen[] listImagenByCriteria(ImagenCriteria imagenCriteria) {
		return imagenCriteria.listImagen();
	}
}
