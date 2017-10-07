package programmer.box.utilityhelper;

import android.app.Activity;
import android.app.MediaRouteActionProvider;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v7.graphics.Palette;
import android.support.v7.media.MediaControlIntent;
import android.support.v7.media.MediaRouteSelector;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Jacob on 10/5/17.
 */

public class UtilMedia {

    public static MediaRouteSelector mediaRouter() {
        // Create a route selector for the type of routes your app supports.
        MediaRouteSelector mSelector = new MediaRouteSelector.Builder()
                // These are the framework-supported intents
                .addControlCategory(MediaControlIntent.CATEGORY_REMOTE_PLAYBACK)
                .build();
        return mSelector;
    }

    public static void textToSpeech(Context context, final String textToSpeak) {

        final TextToSpeech tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

        new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.getDefault());
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "This Language is not supported");
                    }
                    tts.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null, null);

                } else {
                    Log.e("TTS", "Initilization Failed!");
                }
            }
        });

    }

    public static void speechToText(Context context, final SpeechListener speechListener) {

        final SpeechRecognizer sr = SpeechRecognizer.createSpeechRecognizer(context);

        sr.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {
                //sr.stopListening();
            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {
                String str = new String();
                UtilLog.d("onResults " + results);
                ArrayList data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                for (int i = 0; i < data.size(); i++) {
                    UtilLog.d("result " + data.get(i));
                    str += data.get(i);
                }
                speechListener.getResult(str);
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say your text...");

        sr.startListening(intent);
    }

    public interface SpeechListener {

        public void getResult(String text);

    }


}
