package de.unix.database;

import de.unix.configuration.file.YamlConfiguration;
import de.unix.utils.Utils;

import java.io.File;
import java.util.HashMap;

public class CreateDatabase {
	private File f;
	private YamlConfiguration cfg;
	private String name;
	private String[] args;
	private HashMap<String, String>values;
	public CreateDatabase(String name, String[] values) {
		this.name = name;
		this.args = values;
		this.values = new HashMap<String, String>();
		this.f = new File(Utils.getMainPath()+"/Databases",this.name+".jdb");
		this.createValues();
	}
	
	private void createValues() {
		for(String s : this.args) {
			String[] sub = s.split("@");
			this.values.put(sub[1], sub[0]);
		}
		this.check();
	}
	
	private void check() {
		if(this.f.exists()) {System.out.println("Can´t Create Database! Database Exists!"); return;}
		this.cfg = YamlConfiguration.loadConfiguration(f);
		for(String s : this.values.keySet()) {
			if(!this.cfg.isSet(s)) {
				this.cfg.set(s, this.values.get(s));
			}else {System.out.println("Double Value found ->" + s);}
		}
		try {this.cfg.save(f);}catch(Exception e) {e.printStackTrace();}
	}
}
