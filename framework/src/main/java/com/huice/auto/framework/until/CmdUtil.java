package com.huice.auto.framework.until;

import com.sun.jna.Platform;

public class CmdUtil {
	private static void exeCommand(String command) {
		if (Platform.isWindows()) {
			try {
				Runtime rt = Runtime.getRuntime();
				rt.exec(command);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void exeCmdCommand(String command) {
		exeCommand("cmd.exe /c " + command);
	}

	public static void killProcerss(String process) {

		exeCommand("taskkill /F /IM  " + process);

	}
}
