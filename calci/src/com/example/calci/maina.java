package com.example.calci;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calci.R;

public class maina extends Activity {
int a=10;
int b=20;
Button c;

TextView display;
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    c=(Button)findViewById(R.id.button1);
    display=(TextView)findViewById(R.id.textView1);
    c.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		
			int f=a+b;
			display.setText("your value is"+f);
			
		}
	});
    

}

}
