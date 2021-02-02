/**
 * Licensee: Ismael Cruz Bello(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.ORMDatabaseInitiator;

public class DropMDSproyectoDatabaseSchema {
	public static void main(String[] args) {
		try {
			System.out.println("Are you sure to drop table(s)? (Y/N)");
			java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
			if (reader.readLine().trim().toUpperCase().equals("Y")) {
				ORMDatabaseInitiator.dropSchema(com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance());
				com.mds2.d100.foro.db.MDSproyectoPersistentManager.instance().disposePersistentManager();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
