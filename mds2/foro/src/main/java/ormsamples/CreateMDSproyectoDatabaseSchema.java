/**
 * Licensee: Ismael Cruz Bello(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.ORMDatabaseInitiator;

public class CreateMDSproyectoDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance());
			com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance().disposePersistentManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
