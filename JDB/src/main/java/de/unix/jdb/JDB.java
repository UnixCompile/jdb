package de.unix.jdb;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import de.unix.config.Config;
import de.unix.confinder.Finder;
import de.unix.query.Query;
import de.unix.server.JDBServer;
import de.unix.user.User;
import de.unix.utils.Utils;

public class JDB {
	public static void main(String[] args) {
		try {Utils.setMainPath(JDB.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath().toString());}catch(Exception e) {e.printStackTrace();}
		
		Utils.setIsServerEnable(false);
		Utils.setCfg(new Config());
		
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				@SuppressWarnings("resource")
				Scanner s = new Scanner(System.in);
				new Query(s.nextLine());
			}
		}, 0, 50);
		
		
		
		new JDBServer();
		new Finder();
		new User();
	}
}
