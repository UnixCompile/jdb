package de.unix.query;

import de.unix.database.CreateDatabase;
import de.unix.database.Insert;
import de.unix.database.Select;
import de.unix.user.CreateUser;

public class Query {
	public Query(String qry) {
		String[] query = qry.split(">>");
		if(query.length == 1) {
			
		}else if(query.length == 2) {
			
		}else if(query.length == 3) {
			if(query[0].equalsIgnoreCase("CREATEDATABASE")) {
				String name = query[1];
				String[] values = query[2].split(",");
				System.out.println("Create Database ->" + name);
				new CreateDatabase(name, values);
			}
		}else if(query.length == 4) {
			if(query[0].equalsIgnoreCase("INSERT")) {
				String[] args = query[1].split("@");
				String key = args[1];
				args = query[2].split("@");
				String db = args[1];
				String values = query[3];
				System.out.println("Insert Data -> " + key + " -> " + db + " -> " + values);
				new Insert(key, db, values);
			}else if(query[0].equalsIgnoreCase("SELECT")) {
				String[] args = query[1].split("@");
				String db = args[1];
				args = query[2].split("@");
				String key = args[1];
				String values = query[3];
				System.out.println("Select -> " + db + " -> " + key + " -> " + values);
				new Select(db, key, values);
			}
		}else if(query.length == 5) {
			
		}else if(query.length == 6) {
			
		}else if(query.length == 7) {
			if(query[0].equalsIgnoreCase("CREATEUSER")) {
				String[] args = query[2].split("@");
				String user = query[1];
				Boolean BindeIP = Boolean.valueOf(args[1]);
				args = query[3].split("@");
				Boolean ReadAndWirte = Boolean.valueOf(args[1]);
				args = query[4].split("@");
				String DataBasePermission = args[1];
				args = query[5].split("@");
				String AllowDatabase = args[1];
				args = query[6].split("@");
				String password = args[1];
				System.out.println("Create User -> " + user + " Binde-IP-> " + BindeIP + " ReadAndWirteAll -> " + ReadAndWirte + " Permission ->" + DataBasePermission + "-> AllowedBases -> " + AllowDatabase + " -> Password -> " + password);
				new CreateUser(user, BindeIP, ReadAndWirte, DataBasePermission,AllowDatabase,password);
			}
		}
	}
}
