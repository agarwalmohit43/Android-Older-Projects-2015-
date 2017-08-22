package com.example.mohit;

import java.util.Random;

import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener{
	ToggleButton pass;
	Button chk;
	EditText in;
	 TextView t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.text);
		 mohit();
		pass.setOnClickListener(this);
		chk.setOnClickListener(this);
	}

	private void mohit() {
		// TODO Auto-generated method stub
		chk=(Button)findViewById(R.id.button1);
		 pass=(ToggleButton)findViewById(R.id.toggleButton1);
		 in=(EditText)findViewById(R.id.et);
		 t=(TextView)findViewById(R.id.textView1);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		
		switch(view.getId()){
		case R.id.button1:
				String check=in.getText().toString();
				t.setText(check);
				if(check.contentEquals("left")){
				t.setGravity(Gravity.LEFT);
					}else if(check.contentEquals("center")){
						t.setGravity(Gravity.CENTER);
					}else if(check.contentEquals("right")){
						t.setGravity(Gravity.RIGHT);
					}else if(check.contentEquals("red")){
						t.setTextColor(Color.RED);
					}else if(check.contentEquals("blue")){
						t.setTextColor(Color.BLUE);
					}else if(check.contentEquals("green")){
						t.setTextColor(Color.GREEN);
					}else if(check.contentEquals("magenta")){
						t.setTextColor(Color.MAGENTA);
					}else if(check.contains("wtf"))
					{
						t.setText("WTF!!");
						Random cheer=new Random();
						t.setTextSize(cheer.nextInt(75));
						t.setTextColor(Color.rgb(cheer.nextInt(265),cheer.nextInt(265),cheer.nextInt(265)));
						switch(cheer.nextInt(3))
							{
								case 0:t.setGravity(Gravity.LEFT);
									break;
								case 1:t.setGravity(Gravity.RIGHT);
									break;
								case 2:t.setGravity(Gravity.CENTER);
									break;
							}	
					}	
					else{
						t.setText("INVALID");
						t.setGravity(Gravity.CENTER);
						}
						break;
						
						
		case R.id.toggleButton1:
						if(pass.isChecked()){
							in.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
						}else{
							in.setInputType(InputType.TYPE_CLASS_TEXT);
						}
						break;
				}
		}
	}	
