package de.unix.confinder;

import java.util.Timer;
import java.util.TimerTask;

import de.unix.utils.Utils;

public class Finder {
	private Timer t;
	public Finder() {
		t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if(Utils.isServerEnable) {
					finder();
					this.cancel();
				}
			}
		}, 10, 20*1);
	}
	private void finder() {
		this.t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
			}
		}, 0, 20*1);
	}
}
