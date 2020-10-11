package de.unix.database;

import java.io.File;
import java.util.ArrayList;

import de.unix.configuration.file.YamlConfiguration;
import de.unix.utils.Utils;

public class Select {
	private File f;
	private YamlConfiguration cfg;
	String db;
	String key;
	String Values;
	ArrayList<String> selects;
	public Select(String db, String key, String values) {
		this.db = db;
		this.key = key;
		this.Values = values;
		this.selects = new ArrayList<String>();
		this.f = new File(Utils.getMainPath()+"/Databases",this.db+".jdb");
		this.createSelects();
	}
	
	private void createSelects() {
		String[] args = this.Values.split(",");
		for(String s : args) {
			this.selects.add(s);
		}
		this.check();
	}
	
	private void check() {
		String result = "Result@Query";
		this.cfg = YamlConfiguration.loadConfiguration(f);
		if(!this.f.exists()) {System.out.println("Can´t select! Database not Exists!"); return;}
		if(!this.cfg.isSet("db."+this.key)) {System.out.println("Can´t Select Key! Key not Set!");return;}
		for(String s : this.selects) {
			if(!this.cfg.isSet("db." + this.key+"."+s)){System.out.println("Error on Value " + s + " not Set!");return;}
			result = result+","+this.cfg.getString(s)+"@"+this.cfg.getString("db."+this.key+"."+s);
		}
		System.out.println(result);
	}
	
}
