package com.stevenschoen.putionew.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.stevenschoen.putionew.PutioUtils;
import com.stevenschoen.putionew.R;

public class FileFinished extends Activity {
	private int mode;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setTheme(R.style.Putio_Dialog);
		setContentView(R.layout.dialog_filefinished);
		
		TextView textTitle = (TextView) findViewById(R.id.dialog_title);
		
		TextView textBody = (TextView) findViewById(R.id.text_downloadfinished_body);
		textBody.setText(String.format(getString(R.string.downloadfinishedbody), getIntent().getExtras().getString("filename")));
		
		mode = getIntent().getExtras().getInt("mode");
		
		Button buttonAction = (Button) findViewById(R.id.button_filefinished_action);
		switch (mode) {
		case PutioUtils.ACTION_OPEN:
			textTitle.setText(getString(R.string.downloadfinishedopentitle));
			buttonAction.setText(getString(R.string.open));
			break;
		}
		buttonAction.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int id = getIntent().getExtras().getInt("id");
				switch (mode) {
				case PutioUtils.ACTION_OPEN:
					PutioUtils.openDownloadedId(id, FileFinished.this);
					break;
				}
	
				finish();
			}
		});

		Button buttonOk = (Button) findViewById(R.id.button_filefinished_ok);
		buttonOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}