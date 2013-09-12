package com.football.wars.activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.football.wars.R;

public class OptionsActivity extends Activity {

	private MediaPlayer buttonClick;

	private final static String SOUNDS_BUTTON_STATE = "soundsButtonState";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options_menu);

		buttonClick = MediaPlayer.create(this, R.raw.button_click);
		Switch disableSoundSwitch = getSoundSwitch();
		Button test = (Button) findViewById(R.id.test);

		if (savedInstanceState != null) {
			boolean soundsState = savedInstanceState.getBoolean(SOUNDS_BUTTON_STATE);
			disableSoundSwitch.setChecked(soundsState);
		}

		test.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				buttonClick.start();
			}
		});

		disableSoundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				buttonClick.start();
				disableSounds(buttonView, isChecked);
			}
		});
	}

	public void disableSounds(View view, boolean isChecked) {
		view.setSoundEffectsEnabled(isChecked);
	}

	private Switch getSoundSwitch() {
		return (Switch) findViewById(R.id.soundOnOff);
	}

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		Switch disableSoundSwitch = getSoundSwitch();
		savedInstanceState.putBoolean(SOUNDS_BUTTON_STATE, disableSoundSwitch.isChecked());

		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}


}
