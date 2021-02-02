/**
 * Licensee: Ismael Cruz Bello(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.PersistentException;

public class ListMDSproyectoData {
	private static final int ROW_COUNT = 100;

	public void listTestData() throws PersistentException {
		System.out.println("Listing Video...");
		com.mds2.d100.foro.db.Video[] commds2d100forodbVideos = com.mds2.d100.foro.db.VideoDAO.listVideoByQuery(null,
				null);
		int length = Math.min(commds2d100forodbVideos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbVideos[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Imagen...");
		com.mds2.d100.foro.db.Imagen[] commds2d100forodbImagens = com.mds2.d100.foro.db.ImagenDAO
				.listImagenByQuery(null, null);
		length = Math.min(commds2d100forodbImagens.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbImagens[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Notificacion...");
		com.mds2.d100.foro.db.Notificacion[] commds2d100forodbNotificacions = com.mds2.d100.foro.db.NotificacionDAO
				.listNotificacionByQuery(null, null);
		length = Math.min(commds2d100forodbNotificacions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbNotificacions[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Usuario...");
		com.mds2.d100.foro.db.Usuario[] commds2d100forodbUsuarios = com.mds2.d100.foro.db.UsuarioDAO
				.listUsuarioByQuery(null, null);
		length = Math.min(commds2d100forodbUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbUsuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Tema...");
		com.mds2.d100.foro.db.Tema[] commds2d100forodbTemas = com.mds2.d100.foro.db.TemaDAO.listTemaByQuery(null, null);
		length = Math.min(commds2d100forodbTemas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbTemas[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Seccion...");
		com.mds2.d100.foro.db.Seccion[] commds2d100forodbSeccions = com.mds2.d100.foro.db.SeccionDAO
				.listSeccionByQuery(null, null);
		length = Math.min(commds2d100forodbSeccions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbSeccions[i]);
		}
		System.out.println(length + " record(s) retrieved.");

		System.out.println("Listing Mensaje...");
		com.mds2.d100.foro.db.Mensaje[] commds2d100forodbMensajes = com.mds2.d100.foro.db.MensajeDAO
				.listMensajeByQuery(null, null);
		length = Math.min(commds2d100forodbMensajes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbMensajes[i]);
		}
		System.out.println(length + " record(s) retrieved.");

	}

	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Video by Criteria...");
		com.mds2.d100.foro.db.VideoCriteria lcommds2d100forodbVideoCriteria = new com.mds2.d100.foro.db.VideoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbVideoCriteria.idVideo.eq();
		lcommds2d100forodbVideoCriteria.setMaxResults(ROW_COUNT);
		com.mds2.d100.foro.db.Video[] commds2d100forodbVideos = lcommds2d100forodbVideoCriteria.listVideo();
		int length = commds2d100forodbVideos == null ? 0 : Math.min(commds2d100forodbVideos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbVideos[i]);
		}
		System.out.println(length + " Video record(s) retrieved.");

		System.out.println("Listing Imagen by Criteria...");
		com.mds2.d100.foro.db.ImagenCriteria lcommds2d100forodbImagenCriteria = new com.mds2.d100.foro.db.ImagenCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbImagenCriteria.idImagen.eq();
		lcommds2d100forodbImagenCriteria.setMaxResults(ROW_COUNT);
		com.mds2.d100.foro.db.Imagen[] commds2d100forodbImagens = lcommds2d100forodbImagenCriteria.listImagen();
		length = commds2d100forodbImagens == null ? 0 : Math.min(commds2d100forodbImagens.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbImagens[i]);
		}
		System.out.println(length + " Imagen record(s) retrieved.");

		System.out.println("Listing Notificacion by Criteria...");
		com.mds2.d100.foro.db.NotificacionCriteria lcommds2d100forodbNotificacionCriteria = new com.mds2.d100.foro.db.NotificacionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbNotificacionCriteria.idNotificacion.eq();
		lcommds2d100forodbNotificacionCriteria.setMaxResults(ROW_COUNT);
		com.mds2.d100.foro.db.Notificacion[] commds2d100forodbNotificacions = lcommds2d100forodbNotificacionCriteria
				.listNotificacion();
		length = commds2d100forodbNotificacions == null ? 0
				: Math.min(commds2d100forodbNotificacions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbNotificacions[i]);
		}
		System.out.println(length + " Notificacion record(s) retrieved.");

		System.out.println("Listing Usuario by Criteria...");
		com.mds2.d100.foro.db.UsuarioCriteria lcommds2d100forodbUsuarioCriteria = new com.mds2.d100.foro.db.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbUsuarioCriteria.idUsuario.eq();
		lcommds2d100forodbUsuarioCriteria.setMaxResults(ROW_COUNT);
		com.mds2.d100.foro.db.Usuario[] commds2d100forodbUsuarios = lcommds2d100forodbUsuarioCriteria.listUsuario();
		length = commds2d100forodbUsuarios == null ? 0 : Math.min(commds2d100forodbUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbUsuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved.");

		System.out.println("Listing Tema by Criteria...");
		com.mds2.d100.foro.db.TemaCriteria lcommds2d100forodbTemaCriteria = new com.mds2.d100.foro.db.TemaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbTemaCriteria.idTema.eq();
		lcommds2d100forodbTemaCriteria.setMaxResults(ROW_COUNT);
		com.mds2.d100.foro.db.Tema[] commds2d100forodbTemas = lcommds2d100forodbTemaCriteria.listTema();
		length = commds2d100forodbTemas == null ? 0 : Math.min(commds2d100forodbTemas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbTemas[i]);
		}
		System.out.println(length + " Tema record(s) retrieved.");

		System.out.println("Listing Seccion by Criteria...");
		com.mds2.d100.foro.db.SeccionCriteria lcommds2d100forodbSeccionCriteria = new com.mds2.d100.foro.db.SeccionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbSeccionCriteria.idSeccion.eq();
		lcommds2d100forodbSeccionCriteria.setMaxResults(ROW_COUNT);
		com.mds2.d100.foro.db.Seccion[] commds2d100forodbSeccions = lcommds2d100forodbSeccionCriteria.listSeccion();
		length = commds2d100forodbSeccions == null ? 0 : Math.min(commds2d100forodbSeccions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbSeccions[i]);
		}
		System.out.println(length + " Seccion record(s) retrieved.");

		System.out.println("Listing Mensaje by Criteria...");
		com.mds2.d100.foro.db.MensajeCriteria lcommds2d100forodbMensajeCriteria = new com.mds2.d100.foro.db.MensajeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		// lcommds2d100forodbMensajeCriteria.idMensaje.eq();
		lcommds2d100forodbMensajeCriteria.setMaxResults(ROW_COUNT);
		com.mds2.d100.foro.db.Mensaje[] commds2d100forodbMensajes = lcommds2d100forodbMensajeCriteria.listMensaje();
		length = commds2d100forodbMensajes == null ? 0 : Math.min(commds2d100forodbMensajes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commds2d100forodbMensajes[i]);
		}
		System.out.println(length + " Mensaje record(s) retrieved.");

	}

	public static void main(String[] args) {
		try {
			ListMDSproyectoData listMDSproyectoData = new ListMDSproyectoData();
			try {
				listMDSproyectoData.listTestData();
				// listMDSproyectoData.listByCriteria();
			} finally {
				com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance().disposePersistentManager();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
