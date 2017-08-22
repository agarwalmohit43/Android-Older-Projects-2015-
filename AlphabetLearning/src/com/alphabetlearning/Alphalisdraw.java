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
	public class Alphalisdraw extends Activity implements OnClickListener{
	
	ImageButton b1,b2,b3;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.alphalisdraw);
			b1=(ImageButton)findViewById(R.id.imageButton1);
			b2=(ImageButton)findViewById(R.id.imageButton2);
			b3=(ImageButton)findViewById(R.id.imageButton3);
			
			
			b1.setOnClickListener(this);
			b2.setOnClickListener(this);
			b3.setOnClickListener(this);
			
	}	
			
			@Override
		public void onClick(View v) {
				
				
			
		
			switch(v.getId())
			{
			case R.id.imageButton1: Intent i1=new Intent(getApplicationContext(),Alphabetlearning.class);
			                        startActivity(i1);
			                        break;
			                        
			case R.id.imageButton2: Intent i2=new Intent(getApplicationContext(),Drawandpractice.class);
            						startActivity(i2);
            						break;
            
			case R.id.imageButton3: Intent i3=new Intent(getApplicationContext(),Listenandread.class);
            						startActivity(i3);
            						break;
            
			
		}

	}

}

