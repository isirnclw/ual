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
public class MensajeDAO {
	public static Mensaje loadMensajeByORMID(long idMensaje) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadMensajeByORMID(session, idMensaje);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje getMensajeByORMID(long idMensaje) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getMensajeByORMID(session, idMensaje);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje loadMensajeByORMID(long idMensaje, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadMensajeByORMID(session, idMensaje, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje getMensajeByORMID(long idMensaje, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getMensajeByORMID(session, idMensaje, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje loadMensajeByORMID(PersistentSession session, long idMensaje) throws PersistentException {
		try {
			return (Mensaje) session.load(com.mds2.d100.foro.db.Mensaje.class, new Long(idMensaje));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje getMensajeByORMID(PersistentSession session, long idMensaje) throws PersistentException {
		try {
			return (Mensaje) session.get(com.mds2.d100.foro.db.Mensaje.class, new Long(idMensaje));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje loadMensajeByORMID(PersistentSession session, long idMensaje, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			return (Mensaje) session.load(com.mds2.d100.foro.db.Mensaje.class, new Long(idMensaje), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje getMensajeByORMID(PersistentSession session, long idMensaje, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			return (Mensaje) session.get(com.mds2.d100.foro.db.Mensaje.class, new Long(idMensaje), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryMensaje(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryMensaje(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryMensaje(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryMensaje(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje[] listMensajeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listMensajeByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje[] listMensajeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listMensajeByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryMensaje(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Mensaje as Mensaje");
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

	public static List queryMensaje(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Mensaje as Mensaje");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Mensaje", lockMode);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje[] listMensajeByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		try {
			List list = queryMensaje(session, condition, orderBy);
			return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje[] listMensajeByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryMensaje(session, condition, orderBy, lockMode);
			return (Mensaje[]) list.toArray(new Mensaje[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje loadMensajeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadMensajeByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje loadMensajeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadMensajeByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje loadMensajeByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		Mensaje[] mensajes = listMensajeByQuery(session, condition, orderBy);
		if (mensajes != null && mensajes.length > 0)
			return mensajes[0];
		else
			return null;
	}

	public static Mensaje loadMensajeByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		Mensaje[] mensajes = listMensajeByQuery(session, condition, orderBy, lockMode);
		if (mensajes != null && mensajes.length > 0)
			return mensajes[0];
		else
			return null;
	}

	public static java.util.Iterator iterateMensajeByQuery(String condition, String orderBy)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateMensajeByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateMensajeByQuery(String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateMensajeByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateMensajeByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Mensaje as Mensaje");
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

	public static java.util.Iterator iterateMensajeByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Mensaje as Mensaje");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Mensaje", lockMode);
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje createMensaje() {
		return new com.mds2.d100.foro.db.Mensaje();
	}

	public static boolean save(com.mds2.d100.foro.db.Mensaje mensaje) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().saveObject(mensaje);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(com.mds2.d100.foro.db.Mensaje mensaje) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().deleteObject(mensaje);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Mensaje mensaje) throws PersistentException {
		try {
			if (mensaje.getPertenece_a() != null) {
				mensaje.getPertenece_a().mensajesTema.remove(mensaje);
			}

			if (mensaje.getRespondido() != null) {
				mensaje.getRespondido().respuestas.remove(mensaje);
			}

			if (mensaje.getVideo() != null) {
				mensaje.getVideo().mensaje.remove(mensaje);
			}

			if (mensaje.getPropietario() != null) {
				mensaje.getPropietario().mensajes.remove(mensaje);
			}

			com.mds2.d100.foro.db.Usuario[] lM_gusta_as = mensaje.m_gusta_a.toArray();
			for (int i = 0; i < lM_gusta_as.length; i++) {
				lM_gusta_as[i].likesMensajes.remove(mensaje);
			}
			com.mds2.d100.foro.db.Imagen[] lImageness = mensaje.imagenes.toArray();
			for (int i = 0; i < lImageness.length; i++) {
				lImageness[i].mensaje.remove(mensaje);
			}
			com.mds2.d100.foro.db.Mensaje[] lRespuestass = mensaje.respuestas.toArray();
			for (int i = 0; i < lRespuestass.length; i++) {
				lRespuestass[i].setRespondido(null);
			}
			return delete(mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Mensaje mensaje, org.orm.PersistentSession session)
			throws PersistentException {
		try {
			if (mensaje.getPertenece_a() != null) {
				mensaje.getPertenece_a().mensajesTema.remove(mensaje);
			}

			if (mensaje.getRespondido() != null) {
				mensaje.getRespondido().respuestas.remove(mensaje);
			}

			if (mensaje.getVideo() != null) {
				mensaje.getVideo().mensaje.remove(mensaje);
			}

			if (mensaje.getPropietario() != null) {
				mensaje.getPropietario().mensajes.remove(mensaje);
			}

			com.mds2.d100.foro.db.Usuario[] lM_gusta_as = mensaje.m_gusta_a.toArray();
			for (int i = 0; i < lM_gusta_as.length; i++) {
				lM_gusta_as[i].likesMensajes.remove(mensaje);
			}
			com.mds2.d100.foro.db.Imagen[] lImageness = mensaje.imagenes.toArray();
			for (int i = 0; i < lImageness.length; i++) {
				lImageness[i].mensaje.remove(mensaje);
			}
			com.mds2.d100.foro.db.Mensaje[] lRespuestass = mensaje.respuestas.toArray();
			for (int i = 0; i < lRespuestass.length; i++) {
				lRespuestass[i].setRespondido(null);
			}
			try {
				session.delete(mensaje);
				return true;
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean refresh(com.mds2.d100.foro.db.Mensaje mensaje) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().refresh(mensaje);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(com.mds2.d100.foro.db.Mensaje mensaje) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().evict(mensaje);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Mensaje loadMensajeByCriteria(MensajeCriteria mensajeCriteria) {
		Mensaje[] mensajes = listMensajeByCriteria(mensajeCriteria);
		if (mensajes == null || mensajes.length == 0) {
			return null;
		}
		return mensajes[0];
	}

	public static Mensaje[] listMensajeByCriteria(MensajeCriteria mensajeCriteria) {
		return mensajeCriteria.listMensaje();
	}
}
