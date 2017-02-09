package com.example.zmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btn1(View v) {
		startActivity(new Intent(MainActivity.this,PhotoActivity.class));
	}

	public void btn2(View v) {
		startActivity(new Intent(MainActivity.this,VideoPlayerActivity.class));
	}

	public void btn3(View v) {
		startActivity(new Intent(MainActivity.this,RecordActivity.class));
	}

}
