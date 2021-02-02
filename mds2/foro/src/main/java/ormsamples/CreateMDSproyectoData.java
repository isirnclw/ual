/**
 * Licensee: Ismael Cruz Bello(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class CreateMDSproyectoData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance().getSession()
				.beginTransaction();
		try {
			com.mds2.d100.foro.db.Video lcommds2d100forodbVideo = com.mds2.d100.foro.db.VideoDAO.createVideo();
			// Initialize the properties of the persistent object here
			com.mds2.d100.foro.db.VideoDAO.save(lcommds2d100forodbVideo);
			com.mds2.d100.foro.db.Imagen lcommds2d100forodbImagen = com.mds2.d100.foro.db.ImagenDAO.createImagen();
			// TODO Initialize the properties of the persistent object here, the following
			// properties must be initialized before saving : mensaje, usuario
			com.mds2.d100.foro.db.ImagenDAO.save(lcommds2d100forodbImagen);
			com.mds2.d100.foro.db.Notificacion lcommds2d100forodbNotificacion = com.mds2.d100.foro.db.NotificacionDAO
					.createNotificacion();
			// TODO Initialize the properties of the persistent object here, the following
			// properties must be initialized before saving : fecha_creacion, icono,
			// enviada_a
			com.mds2.d100.foro.db.NotificacionDAO.save(lcommds2d100forodbNotificacion);
			com.mds2.d100.foro.db.Usuario lcommds2d100forodbUsuario = com.mds2.d100.foro.db.UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following
			// properties must be initialized before saving : recibe, mensajes, amigos,
			// likesTemas, likesMensajes, amistados, reportado, importancia, maxItemsPerfil,
			// notificarRespuestas, notificarAlCorreo, conectado, perfil_publico, fotoPerfil
			com.mds2.d100.foro.db.UsuarioDAO.save(lcommds2d100forodbUsuario);
			com.mds2.d100.foro.db.Tema lcommds2d100forodbTema = com.mds2.d100.foro.db.TemaDAO.createTema();
			// TODO Initialize the properties of the persistent object here, the following
			// properties must be initialized before saving : t_gusta_a, mensajesTema,
			// eliminado, oculto, fecha_creacion, icono, fecha_ult_mens, num_likes,
			// creado_por, seccion
			com.mds2.d100.foro.db.TemaDAO.save(lcommds2d100forodbTema);
			com.mds2.d100.foro.db.Seccion lcommds2d100forodbSeccion = com.mds2.d100.foro.db.SeccionDAO.createSeccion();
			// TODO Initialize the properties of the persistent object here, the following
			// properties must be initialized before saving : temas, eliminado, oculto,
			// fecha_creacion, num_mensajes, creado_por
			com.mds2.d100.foro.db.SeccionDAO.save(lcommds2d100forodbSeccion);
			com.mds2.d100.foro.db.Mensaje lcommds2d100forodbMensaje = com.mds2.d100.foro.db.MensajeDAO.createMensaje();
			// TODO Initialize the properties of the persistent object here, the following
			// properties must be initialized before saving : imagenes, m_gusta_a,
			// eliminado, oculto, fecha_creacion, num_likes, propietario, pertenece_a
			com.mds2.d100.foro.db.MensajeDAO.save(lcommds2d100forodbMensaje);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

	}

	public static void main(String[] args) {
		try {
			CreateMDSproyectoData createMDSproyectoData = new CreateMDSproyectoData();
			try {
				createMDSproyectoData.createTestData();
			} finally {
				com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance().disposePersistentManager();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
