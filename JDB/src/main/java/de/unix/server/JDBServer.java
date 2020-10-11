package de.unix.server;

import java.net.ServerSocket;

import de.unix.utils.Utils;

public class JDBServer {
	public JDBServer() {
		try {
			Utils.setServer(new ServerSocket(Utils.getCfg().getPort()));
			System.out.println("Server Listinig on " + Utils.getCfg().getPort());
			Utils.setIsServerEnable(true);
		}catch(Exception e) {e.printStackTrace(); Utils.setIsServerEnable(false);}
	}
}
