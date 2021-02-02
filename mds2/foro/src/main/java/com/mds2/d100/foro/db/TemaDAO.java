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
public class TemaDAO {
	public static Tema loadTemaByORMID(long idTema) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadTemaByORMID(session, idTema);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema getTemaByORMID(long idTema) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getTemaByORMID(session, idTema);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema loadTemaByORMID(long idTema, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadTemaByORMID(session, idTema, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema getTemaByORMID(long idTema, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getTemaByORMID(session, idTema, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema loadTemaByORMID(PersistentSession session, long idTema) throws PersistentException {
		try {
			return (Tema) session.load(com.mds2.d100.foro.db.Tema.class, new Long(idTema));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema getTemaByORMID(PersistentSession session, long idTema) throws PersistentException {
		try {
			return (Tema) session.get(com.mds2.d100.foro.db.Tema.class, new Long(idTema));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema loadTemaByORMID(PersistentSession session, long idTema, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			return (Tema) session.load(com.mds2.d100.foro.db.Tema.class, new Long(idTema), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema getTemaByORMID(PersistentSession session, long idTema, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			return (Tema) session.get(com.mds2.d100.foro.db.Tema.class, new Long(idTema), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryTema(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryTema(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryTema(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryTema(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema[] listTemaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listTemaByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema[] listTemaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listTemaByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryTema(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Tema as Tema");
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

	public static List queryTema(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Tema as Tema");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Tema", lockMode);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema[] listTemaByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		try {
			List list = queryTema(session, condition, orderBy);
			return (Tema[]) list.toArray(new Tema[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema[] listTemaByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTema(session, condition, orderBy, lockMode);
			return (Tema[]) list.toArray(new Tema[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema loadTemaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadTemaByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema loadTemaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadTemaByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema loadTemaByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		Tema[] temas = listTemaByQuery(session, condition, orderBy);
		if (temas != null && temas.length > 0)
			return temas[0];
		else
			return null;
	}

	public static Tema loadTemaByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		Tema[] temas = listTemaByQuery(session, condition, orderBy, lockMode);
		if (temas != null && temas.length > 0)
			return temas[0];
		else
			return null;
	}

	public static java.util.Iterator iterateTemaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateTemaByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateTemaByQuery(String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateTemaByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateTemaByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Tema as Tema");
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

	public static java.util.Iterator iterateTemaByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Tema as Tema");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Tema", lockMode);
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema createTema() {
		return new com.mds2.d100.foro.db.Tema();
	}

	public static boolean save(com.mds2.d100.foro.db.Tema tema) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().saveObject(tema);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(com.mds2.d100.foro.db.Tema tema) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().deleteObject(tema);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Tema tema) throws PersistentException {
		try {
			if (tema.getSeccion() != null) {
				tema.getSeccion().temas.remove(tema);
			}

			com.mds2.d100.foro.db.Mensaje[] lMensajesTemas = tema.mensajesTema.toArray();
			for (int i = 0; i < lMensajesTemas.length; i++) {
				lMensajesTemas[i].setPertenece_a(null);
			}
			com.mds2.d100.foro.db.Usuario[] lT_gusta_as = tema.t_gusta_a.toArray();
			for (int i = 0; i < lT_gusta_as.length; i++) {
				lT_gusta_as[i].likesTemas.remove(tema);
			}
			return delete(tema);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Tema tema, org.orm.PersistentSession session)
			throws PersistentException {
		try {
			if (tema.getSeccion() != null) {
				tema.getSeccion().temas.remove(tema);
			}

			com.mds2.d100.foro.db.Mensaje[] lMensajesTemas = tema.mensajesTema.toArray();
			for (int i = 0; i < lMensajesTemas.length; i++) {
				lMensajesTemas[i].setPertenece_a(null);
			}
			com.mds2.d100.foro.db.Usuario[] lT_gusta_as = tema.t_gusta_a.toArray();
			for (int i = 0; i < lT_gusta_as.length; i++) {
				lT_gusta_as[i].likesTemas.remove(tema);
			}
			try {
				session.delete(tema);
				return true;
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean refresh(com.mds2.d100.foro.db.Tema tema) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().refresh(tema);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(com.mds2.d100.foro.db.Tema tema) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().evict(tema);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Tema loadTemaByCriteria(TemaCriteria temaCriteria) {
		Tema[] temas = listTemaByCriteria(temaCriteria);
		if (temas == null || temas.length == 0) {
			return null;
		}
		return temas[0];
	}

	public static Tema[] listTemaByCriteria(TemaCriteria temaCriteria) {
		return temaCriteria.listTema();
	}
}
