import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URISyntaxException;
import com.Engines.DataBaseEngine;
import com.Engines.MVoice;
import com.gui.GUIMichael;
import com.gui.MTray;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Main {
	public static void main(String[] args) throws FontFormatException, IOException, URISyntaxException {
		GUIMichael Michael = new GUIMichael();
		MTray TrayMichael = new MTray();
		Michael.CallMichael();
		TrayMichael.initialize();
		@SuppressWarnings("unused")
		MVoice Hello = new MVoice("Hello, I am Michael. Your windows desktop assistant");
		SpeechRecognition();
	}

	public static void SpeechRecognition() throws IOException, URISyntaxException {

		Configuration configuration = new Configuration();
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath(
				"File:///C:\\Stoyan\\Workspace\\Java\\WindowsDesktopAssistant\\src\\resources\\files\\mspeech.dic");
		configuration.setLanguageModelPath(
				"File:///C:\\Stoyan\\Workspace\\Java\\WindowsDesktopAssistant\\src\\resources\\files\\mspeech.lm");

		LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
		recognizer.startRecognition(true);
		SpeechResult result;

		while ((result = recognizer.getResult()) != null) {
			String command = result.getHypothesis();
			System.out.println(command);

			if (command.contains("MICHAEL")) {
				DataBaseEngine.exectueCommand(command);
			}

		}
	}
}
