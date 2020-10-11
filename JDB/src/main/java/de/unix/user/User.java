package de.unix.user;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.unix.configuration.file.YamlConfiguration;
import de.unix.utils.Utils;

public class User {
	private File f;
	private YamlConfiguration cfg;
	public User() {
		this.f = new File(Utils.getMainPath()+"/User");
		if(!f.exists()) {f.mkdirs();}
		this.createRoot();
	}
	
	private void createRoot() {
		this.f = new File(Utils.getMainPath()+"/User","root.usr");
		if(!f.exists()) {
			this.cfg = YamlConfiguration.loadConfiguration(f);
			this.cfg.set("Binde-IP", true);
			this.cfg.set("ReadAndWirteAll", true);
			this.cfg.set("DatabasePermission", "*");
			List<String> databases = new ArrayList<String>();
			databases.add("*");
			this.cfg.set("AllowDatabases",databases);
			try {this.cfg.save(f);}catch(Exception e) {e.printStackTrace();}
		}
	}
}
