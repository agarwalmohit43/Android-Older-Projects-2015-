package com.alphabetlearning;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
	
	
	
import android.view.View.OnClickListener;
	public class Alphabetlearning extends Activity implements OnClickListener{
	
	ImageButton b1,b2;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.alphabetlearning);
			b1=(ImageButton)findViewById(R.id.alphabet);
			b2=(ImageButton)findViewById(R.id.number);
			
			
			
			b1.setOnClickListener(this);
			b2.setOnClickListener(this);
			
			
	}	
			
			@Override
		public void onClick(View v) {
				
				
			
		
			switch(v.getId())
			{
			case R.id.alphabet: Intent i1=new Intent(getApplicationContext(),Alphabetlearning.class);
			                        startActivity(i1);
			                        break;
			                        
			case R.id.number: Intent i2=new Intent(getApplicationContext(),Alphabetlearning.class);
            						startActivity(i2);
            						break;
            
			
			
		}

	}

}

