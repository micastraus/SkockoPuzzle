package skocko;

import javazoom.jl.decoder.JavaLayerException;

public class AudioThread implements Runnable {

	@Override
	public void run() {
		if (MainGame.player != null) {
			MainGame.player.close();
			try {
				MainGame.player.play();
			} catch (JavaLayerException e) {
				e.printStackTrace();
			}
		}
	}
	
}
