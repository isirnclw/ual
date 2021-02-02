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
public class NotificacionDAO {
	public static Notificacion loadNotificacionByORMID(long idNotificacion) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadNotificacionByORMID(session, idNotificacion);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion getNotificacionByORMID(long idNotificacion) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getNotificacionByORMID(session, idNotificacion);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion loadNotificacionByORMID(long idNotificacion, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadNotificacionByORMID(session, idNotificacion, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion getNotificacionByORMID(long idNotificacion, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getNotificacionByORMID(session, idNotificacion, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion loadNotificacionByORMID(PersistentSession session, long idNotificacion)
			throws PersistentException {
		try {
			return (Notificacion) session.load(com.mds2.d100.foro.db.Notificacion.class, new Long(idNotificacion));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion getNotificacionByORMID(PersistentSession session, long idNotificacion)
			throws PersistentException {
		try {
			return (Notificacion) session.get(com.mds2.d100.foro.db.Notificacion.class, new Long(idNotificacion));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion loadNotificacionByORMID(PersistentSession session, long idNotificacion,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Notificacion) session.load(com.mds2.d100.foro.db.Notificacion.class, new Long(idNotificacion),
					lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion getNotificacionByORMID(PersistentSession session, long idNotificacion,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Notificacion) session.get(com.mds2.d100.foro.db.Notificacion.class, new Long(idNotificacion),
					lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryNotificacion(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryNotificacion(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryNotificacion(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryNotificacion(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion[] listNotificacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listNotificacionByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion[] listNotificacionByQuery(String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listNotificacionByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryNotificacion(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Notificacion as Notificacion");
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

	public static List queryNotificacion(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Notificacion as Notificacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Notificacion", lockMode);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion[] listNotificacionByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		try {
			List list = queryNotificacion(session, condition, orderBy);
			return (Notificacion[]) list.toArray(new Notificacion[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion[] listNotificacionByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryNotificacion(session, condition, orderBy, lockMode);
			return (Notificacion[]) list.toArray(new Notificacion[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion loadNotificacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadNotificacionByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion loadNotificacionByQuery(String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadNotificacionByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion loadNotificacionByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		Notificacion[] notificacions = listNotificacionByQuery(session, condition, orderBy);
		if (notificacions != null && notificacions.length > 0)
			return notificacions[0];
		else
			return null;
	}

	public static Notificacion loadNotificacionByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		Notificacion[] notificacions = listNotificacionByQuery(session, condition, orderBy, lockMode);
		if (notificacions != null && notificacions.length > 0)
			return notificacions[0];
		else
			return null;
	}

	public static java.util.Iterator iterateNotificacionByQuery(String condition, String orderBy)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateNotificacionByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateNotificacionByQuery(String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateNotificacionByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateNotificacionByQuery(PersistentSession session, String condition,
			String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Notificacion as Notificacion");
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

	public static java.util.Iterator iterateNotificacionByQuery(PersistentSession session, String condition,
			String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Notificacion as Notificacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Notificacion", lockMode);
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion createNotificacion() {
		return new com.mds2.d100.foro.db.Notificacion();
	}

	public static boolean save(com.mds2.d100.foro.db.Notificacion notificacion) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().saveObject(notificacion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(com.mds2.d100.foro.db.Notificacion notificacion) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().deleteObject(notificacion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Notificacion notificacion)
			throws PersistentException {
		try {
			if (notificacion.getEnviada_a() != null) {
				notificacion.getEnviada_a().recibe.remove(notificacion);
			}

			return delete(notificacion);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Notificacion notificacion,
			org.orm.PersistentSession session) throws PersistentException {
		try {
			if (notificacion.getEnviada_a() != null) {
				notificacion.getEnviada_a().recibe.remove(notificacion);
			}

			try {
				session.delete(notificacion);
				return true;
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean refresh(com.mds2.d100.foro.db.Notificacion notificacion) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().refresh(notificacion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(com.mds2.d100.foro.db.Notificacion notificacion) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().evict(notificacion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Notificacion loadNotificacionByCriteria(NotificacionCriteria notificacionCriteria) {
		Notificacion[] notificacions = listNotificacionByCriteria(notificacionCriteria);
		if (notificacions == null || notificacions.length == 0) {
			return null;
		}
		return notificacions[0];
	}

	public static Notificacion[] listNotificacionByCriteria(NotificacionCriteria notificacionCriteria) {
		return notificacionCriteria.listNotificacion();
	}
}
