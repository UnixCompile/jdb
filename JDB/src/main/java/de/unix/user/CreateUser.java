package de.unix.user;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.unix.configuration.file.YamlConfiguration;
import de.unix.utils.Utils;

public class CreateUser {
	private File f;
	private YamlConfiguration cfg;
	private String name;
	private Boolean binde;
	private Boolean ReadWirte;
	private String DBPerms;
	private String AllowBases;
	private String Password;
	public CreateUser(String name, Boolean binde, boolean ReadAndWirteAll, String DatabasePermission, String AllowBases, String Password) {
		this.name = name;
		this.binde = binde;
		this.ReadWirte = ReadAndWirteAll;
		this.DBPerms = DatabasePermission;
		this.AllowBases = AllowBases;
		this.Password = Password;
		this.f = new File(Utils.getMainPath()+"/User",this.name+".usr");
		this.check();
	}
	
	private void check() {
		if(f.exists()) {System.out.println("-> Can´t Create User! User Exists"); return;}
		this.cfg = YamlConfiguration.loadConfiguration(f);
		this.cfg.set("Password", this.Password);
		this.cfg.set("Binde-IP", this.binde);
		this.cfg.set("ReadAndWirteAll", this.ReadWirte);
		this.cfg.set("DatabasePermission", this.DBPerms);
		
		String[] allowDBs = this.AllowBases.split(",");
		List<String> dbs = new ArrayList<String>();
		for(String s : allowDBs) {
			dbs.add(s);
		}
		this.cfg.set("AllowDatabases", dbs);
		try {this.cfg.save(f);}catch(Exception e) {e.printStackTrace();}
	}
}
