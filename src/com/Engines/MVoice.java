package com.Engines;

import com.sun.speech.freetts.VoiceManager;

public class MVoice {
	private static com.sun.speech.freetts.Voice voice;

	public MVoice(String words) {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		voice = VoiceManager.getInstance().getVoice("kevin16");
		if (voice != null) {
			voice.allocate();
			try {
				voice.setRate(190);
				voice.setPitch(150);
				voice.setVolume(3);
				voice.speak(words);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else {
			throw new IllegalStateException("Cannot find voice: kevin16");
		}
	}
}
