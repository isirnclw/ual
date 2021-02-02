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
public class VideoDAO {
	public static Video loadVideoByORMID(long idVideo) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadVideoByORMID(session, idVideo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video getVideoByORMID(long idVideo) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getVideoByORMID(session, idVideo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video loadVideoByORMID(long idVideo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadVideoByORMID(session, idVideo, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video getVideoByORMID(long idVideo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return getVideoByORMID(session, idVideo, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video loadVideoByORMID(PersistentSession session, long idVideo) throws PersistentException {
		try {
			return (Video) session.load(com.mds2.d100.foro.db.Video.class, new Long(idVideo));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video getVideoByORMID(PersistentSession session, long idVideo) throws PersistentException {
		try {
			return (Video) session.get(com.mds2.d100.foro.db.Video.class, new Long(idVideo));
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video loadVideoByORMID(PersistentSession session, long idVideo, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			return (Video) session.load(com.mds2.d100.foro.db.Video.class, new Long(idVideo), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video getVideoByORMID(PersistentSession session, long idVideo, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			return (Video) session.get(com.mds2.d100.foro.db.Video.class, new Long(idVideo), lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryVideo(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryVideo(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryVideo(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return queryVideo(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video[] listVideoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listVideoByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video[] listVideoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return listVideoByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryVideo(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Video as Video");
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

	public static List queryVideo(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Video as Video");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Video", lockMode);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video[] listVideoByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		try {
			List list = queryVideo(session, condition, orderBy);
			return (Video[]) list.toArray(new Video[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video[] listVideoByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryVideo(session, condition, orderBy, lockMode);
			return (Video[]) list.toArray(new Video[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video loadVideoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadVideoByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video loadVideoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode)
			throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return loadVideoByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video loadVideoByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		Video[] videos = listVideoByQuery(session, condition, orderBy);
		if (videos != null && videos.length > 0)
			return videos[0];
		else
			return null;
	}

	public static Video loadVideoByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		Video[] videos = listVideoByQuery(session, condition, orderBy, lockMode);
		if (videos != null && videos.length > 0)
			return videos[0];
		else
			return null;
	}

	public static java.util.Iterator iterateVideoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateVideoByQuery(session, condition, orderBy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateVideoByQuery(String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = MDSproyectoPersistentManager.instance().getSession();
			return iterateVideoByQuery(session, condition, orderBy, lockMode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateVideoByQuery(PersistentSession session, String condition, String orderBy)
			throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Video as Video");
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

	public static java.util.Iterator iterateVideoByQuery(PersistentSession session, String condition, String orderBy,
			org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mds2.d100.foro.db.Video as Video");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Video", lockMode);
			return query.iterate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video createVideo() {
		return new com.mds2.d100.foro.db.Video();
	}

	public static boolean save(com.mds2.d100.foro.db.Video video) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().saveObject(video);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(com.mds2.d100.foro.db.Video video) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().deleteObject(video);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Video video) throws PersistentException {
		try {
			com.mds2.d100.foro.db.Mensaje[] lMensajes = video.mensaje.toArray();
			for (int i = 0; i < lMensajes.length; i++) {
				lMensajes[i].setVideo(null);
			}
			return delete(video);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(com.mds2.d100.foro.db.Video video, org.orm.PersistentSession session)
			throws PersistentException {
		try {
			com.mds2.d100.foro.db.Mensaje[] lMensajes = video.mensaje.toArray();
			for (int i = 0; i < lMensajes.length; i++) {
				lMensajes[i].setVideo(null);
			}
			try {
				session.delete(video);
				return true;
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean refresh(com.mds2.d100.foro.db.Video video) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().refresh(video);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(com.mds2.d100.foro.db.Video video) throws PersistentException {
		try {
			MDSproyectoPersistentManager.instance().getSession().evict(video);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Video loadVideoByCriteria(VideoCriteria videoCriteria) {
		Video[] videos = listVideoByCriteria(videoCriteria);
		if (videos == null || videos.length == 0) {
			return null;
		}
		return videos[0];
	}

	public static Video[] listVideoByCriteria(VideoCriteria videoCriteria) {
		return videoCriteria.listVideo();
	}
}
