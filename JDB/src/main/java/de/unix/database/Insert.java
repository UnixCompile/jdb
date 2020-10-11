package de.unix.database;

import java.io.File;
import java.util.HashMap;

import de.unix.configuration.file.YamlConfiguration;
import de.unix.utils.Utils;

public class Insert {
	
	private File f;
	private YamlConfiguration cfg;
	private String key;
	private String db;
	private String values;
	private HashMap<String, String>vs;
	public Insert(String key, String db, String values) {
		this.key = key;
		this.vs = new HashMap<String, String>();
		this.db = db;
		this.values = values;
		this.f = new File(Utils.getMainPath()+"/Databases", this.db+".jdb");
		this.createValues();
	}
	
	private void createValues() {
		String[] args = this.values.split(",");
		for(String s : args) {
			String[] v = s.split("@");
			this.vs.put(v[0], v[1]);
		}
		this.check();
	}
	
	private void check() {
		if(!f.exists()) {System.out.println("Can´t Insert! Databases not Exists!"); return;}
		this.cfg = YamlConfiguration.loadConfiguration(f);
		if(this.cfg.isSet("db."+this.key)) {System.out.println("Can´t Insert! Key exists!"); return;}
		for(String s : this.vs.keySet()) {
			this.cfg.set("db."+this.key+"."+s, this.vs.get(s));
		}
		try {this.cfg.save(f);}catch (Exception e) {e.printStackTrace();}
	}
}
