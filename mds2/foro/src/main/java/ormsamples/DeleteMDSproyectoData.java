/**
 * Licensee: Ismael Cruz Bello(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class DeleteMDSproyectoData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance().getSession()
				.beginTransaction();
		try {
			com.mds2.d100.foro.db.Video lcommds2d100forodbVideo = com.mds2.d100.foro.db.VideoDAO.loadVideoByQuery(null,
					null);
			// Delete the persistent object
			com.mds2.d100.foro.db.VideoDAO.delete(lcommds2d100forodbVideo);
			com.mds2.d100.foro.db.Imagen lcommds2d100forodbImagen = com.mds2.d100.foro.db.ImagenDAO
					.loadImagenByQuery(null, null);
			// Delete the persistent object
			com.mds2.d100.foro.db.ImagenDAO.delete(lcommds2d100forodbImagen);
			com.mds2.d100.foro.db.Notificacion lcommds2d100forodbNotificacion = com.mds2.d100.foro.db.NotificacionDAO
					.loadNotificacionByQuery(null, null);
			// Delete the persistent object
			com.mds2.d100.foro.db.NotificacionDAO.delete(lcommds2d100forodbNotificacion);
			com.mds2.d100.foro.db.Usuario lcommds2d100forodbUsuario = com.mds2.d100.foro.db.UsuarioDAO
					.loadUsuarioByQuery(null, null);
			// Delete the persistent object
			com.mds2.d100.foro.db.UsuarioDAO.delete(lcommds2d100forodbUsuario);
			com.mds2.d100.foro.db.Tema lcommds2d100forodbTema = com.mds2.d100.foro.db.TemaDAO.loadTemaByQuery(null,
					null);
			// Delete the persistent object
			com.mds2.d100.foro.db.TemaDAO.delete(lcommds2d100forodbTema);
			com.mds2.d100.foro.db.Seccion lcommds2d100forodbSeccion = com.mds2.d100.foro.db.SeccionDAO
					.loadSeccionByQuery(null, null);
			// Delete the persistent object
			com.mds2.d100.foro.db.SeccionDAO.delete(lcommds2d100forodbSeccion);
			com.mds2.d100.foro.db.Mensaje lcommds2d100forodbMensaje = com.mds2.d100.foro.db.MensajeDAO
					.loadMensajeByQuery(null, null);
			// Delete the persistent object
			com.mds2.d100.foro.db.MensajeDAO.delete(lcommds2d100forodbMensaje);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

	}

	public static void main(String[] args) {
		try {
			DeleteMDSproyectoData deleteMDSproyectoData = new DeleteMDSproyectoData();
			try {
				deleteMDSproyectoData.deleteTestData();
			} finally {
				com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance().disposePersistentManager();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
