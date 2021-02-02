/**
 * Licensee: Ismael Cruz Bello(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class RetrieveAndUpdateMDSproyectoData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance().getSession()
				.beginTransaction();
		try {
			com.mds2.d100.foro.db.Video lcommds2d100forodbVideo = com.mds2.d100.foro.db.VideoDAO.loadVideoByQuery(null,
					null);
			// Update the properties of the persistent object
			com.mds2.d100.foro.db.VideoDAO.save(lcommds2d100forodbVideo);
			com.mds2.d100.foro.db.Imagen lcommds2d100forodbImagen = com.mds2.d100.foro.db.ImagenDAO
					.loadImagenByQuery(null, null);
			// Update the properties of the persistent object
			com.mds2.d100.foro.db.ImagenDAO.save(lcommds2d100forodbImagen);
			com.mds2.d100.foro.db.Notificacion lcommds2d100forodbNotificacion = com.mds2.d100.foro.db.NotificacionDAO
					.loadNotificacionByQuery(null, null);
			// Update the properties of the persistent object
			com.mds2.d100.foro.db.NotificacionDAO.save(lcommds2d100forodbNotificacion);
			com.mds2.d100.foro.db.Usuario lcommds2d100forodbUsuario = com.mds2.d100.foro.db.UsuarioDAO
					.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			com.mds2.d100.foro.db.UsuarioDAO.save(lcommds2d100forodbUsuario);
			com.mds2.d100.foro.db.Tema lcommds2d100forodbTema = com.mds2.d100.foro.db.TemaDAO.loadTemaByQuery(null,
					null);
			// Update the properties of the persistent object
			com.mds2.d100.foro.db.TemaDAO.save(lcommds2d100forodbTema);
			com.mds2.d100.foro.db.Seccion lcommds2d100forodbSeccion = com.mds2.d100.foro.db.SeccionDAO
					.loadSeccionByQuery(null, null);
			// Update the properties of the persistent object
			com.mds2.d100.foro.db.SeccionDAO.save(lcommds2d100forodbSeccion);
			com.mds2.d100.foro.db.Mensaje lcommds2d100forodbMensaje = com.mds2.d100.foro.db.MensajeDAO
					.loadMensajeByQuery(null, null);
			// Update the properties of the persistent object
			com.mds2.d100.foro.db.MensajeDAO.save(lcommds2d100forodbMensaje);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

	}

	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Video by VideoCriteria");
		com.mds2.d100.foro.db.VideoCriteria lcommds2d100forodbVideoCriteria = new com.mds2.d100.foro.db.VideoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbVideoCriteria.idVideo.eq();
		System.out.println(lcommds2d100forodbVideoCriteria.uniqueVideo());

		System.out.println("Retrieving Imagen by ImagenCriteria");
		com.mds2.d100.foro.db.ImagenCriteria lcommds2d100forodbImagenCriteria = new com.mds2.d100.foro.db.ImagenCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbImagenCriteria.idImagen.eq();
		System.out.println(lcommds2d100forodbImagenCriteria.uniqueImagen());

		System.out.println("Retrieving Notificacion by NotificacionCriteria");
		com.mds2.d100.foro.db.NotificacionCriteria lcommds2d100forodbNotificacionCriteria = new com.mds2.d100.foro.db.NotificacionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbNotificacionCriteria.idNotificacion.eq();
		System.out.println(lcommds2d100forodbNotificacionCriteria.uniqueNotificacion());

		System.out.println("Retrieving Usuario by UsuarioCriteria");
		com.mds2.d100.foro.db.UsuarioCriteria lcommds2d100forodbUsuarioCriteria = new com.mds2.d100.foro.db.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbUsuarioCriteria.idUsuario.eq();
		System.out.println(lcommds2d100forodbUsuarioCriteria.uniqueUsuario());

		System.out.println("Retrieving Tema by TemaCriteria");
		com.mds2.d100.foro.db.TemaCriteria lcommds2d100forodbTemaCriteria = new com.mds2.d100.foro.db.TemaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbTemaCriteria.idTema.eq();
		System.out.println(lcommds2d100forodbTemaCriteria.uniqueTema());

		System.out.println("Retrieving Seccion by SeccionCriteria");
		com.mds2.d100.foro.db.SeccionCriteria lcommds2d100forodbSeccionCriteria = new com.mds2.d100.foro.db.SeccionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbSeccionCriteria.idSeccion.eq();
		System.out.println(lcommds2d100forodbSeccionCriteria.uniqueSeccion());

		System.out.println("Retrieving Mensaje by MensajeCriteria");
		com.mds2.d100.foro.db.MensajeCriteria lcommds2d100forodbMensajeCriteria = new com.mds2.d100.foro.db.MensajeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbMensajeCriteria.idMensaje.eq();
		System.out.println(lcommds2d100forodbMensajeCriteria.uniqueMensaje());

	}

	public static void main(String[] args) {
		try {
			RetrieveAndUpdateMDSproyectoData retrieveAndUpdateMDSproyectoData = new RetrieveAndUpdateMDSproyectoData();
			try {
				retrieveAndUpdateMDSproyectoData.retrieveAndUpdateTestData();
				// retrieveAndUpdateMDSproyectoData.retrieveByCriteria();
			} finally {
				com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance().disposePersistentManager();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
