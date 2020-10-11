package de.unix.config;

import java.io.File;

import de.unix.configuration.file.YamlConfiguration;
import de.unix.utils.Utils;

public class Config {
	private File f;
	private YamlConfiguration cfg;
	private Integer port;
	private String rootUser;
	private String rootPasswort;
	public Config() {
		this.f = new File(Utils.getMainPath()+"/jdb","config.jdb");
		this.cfg = YamlConfiguration.loadConfiguration(f);
		this.setUp();
	}
	
	private void setUp() {
		keySet("Port", 1337);
		keySet("rootUser", "root");
		keySet("rootPassword", "@2sx1cqqy");
		this.load();
	}
	
	private void load() {
		this.port = this.cfg.getInt("Port");
		this.rootUser = this.cfg.getString("rootUser");
		this.rootPasswort = this.cfg.getString("rootPassword");
	}
	
	public String getRootUser() {
		return this.rootUser;
	}
	
	public String getRootPassword() {
		return this.rootPasswort;
	}
	
	public Integer getPort() {
		return this.port;
	}
	
	private void keySet(String path, Object obj) {
		if(!this.cfg.isSet(path)) {
			this.cfg.set(path, obj);
			try {this.cfg.save(f);}catch(Exception e) {e.printStackTrace();}
		}
	}
}
