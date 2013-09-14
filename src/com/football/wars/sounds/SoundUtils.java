package com.football.wars.sounds;

import android.content.Context;
import android.media.MediaPlayer;
import com.football.wars.R;

public class SoundUtils {

	public static MediaPlayer createButtonClickSound(Context context) {
		return MediaPlayer.create(context, R.raw.button_click);
	}

}
