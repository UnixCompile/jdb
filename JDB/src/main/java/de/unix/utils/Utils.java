package de.unix.utils;

import java.net.ServerSocket;

import de.unix.config.Config;
import lombok.Getter;
import lombok.Setter;

public class Utils {
	@Getter@Setter
	public static String mainPath;
	@Getter@Setter
	public static Config cfg;
	@Getter@Setter
	public static ServerSocket server;
	@Getter@Setter
	public static Boolean isServerEnable;
}
