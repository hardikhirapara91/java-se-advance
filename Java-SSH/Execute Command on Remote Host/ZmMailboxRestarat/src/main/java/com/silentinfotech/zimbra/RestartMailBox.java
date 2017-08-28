package com.silentinfotech.zimbra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * Restart Mailbox
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class RestartMailBox {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "silent";
	private static final String HOST_NAME = "10.10.3.203";
	private static final Integer PORT = 22;

	public static void main(String[] args) {

		try {
			JSch jsch = new JSch();

			// Create session
			Session session = jsch.getSession(USERNAME, HOST_NAME, PORT);
			System.out.println("session created.");

			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(PASSWORD);
			session.connect();

			// Execute command channel
			ChannelExec channel = (ChannelExec) session.openChannel("exec");
			BufferedReader in = new BufferedReader(new InputStreamReader(channel.getInputStream()));
			// channel.setCommand("sudo su - zimbra -c \"zmmailboxdctl
			// restart\";");
			channel.setCommand("sudo su - zimbra -c \"/opt/zimbra/bin/zmmailboxdctl restart\";");
			channel.connect();

			String msg = null;
			List<String> lines = new ArrayList<String>();
			while ((msg = in.readLine()) != null) {
				System.out.println(msg);
				lines.add(msg);
			}

			channel.disconnect();
			session.disconnect();

			System.out.println("Command executed successfully.");
		} catch (Exception ex) {
			System.out.println("Exception | RestartMailbox.main() | while execute command on remote host: " + ex);
		}
	}
}
