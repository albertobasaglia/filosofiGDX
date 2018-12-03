package com.filosofi.gui.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.filosofi.gui.FilosofiGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		int n;
		if(arg.length>0) {
			try{
				n = Integer.parseInt(arg[0]);
				if(n>1 && n<12) {
					System.out.printf("Avvio con %d filosofi.",n);
				} else {
					System.out.println("Numero non valido. DEFAULT 5");
					n = 5;
				}
			} catch (NumberFormatException e) {
				System.out.println("Formato non valido. DEFAULT 5");
				n = 5;
			}
		} else {
			n = 5;
		}
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.height = 800;
		config.width = 800;
		new LwjglApplication(new FilosofiGame(n), config);
	}
}
