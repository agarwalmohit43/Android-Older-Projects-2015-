package com.example.mohit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {

	Button st,stfr;
	EditText et;
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.get);
		initialise();
		
		
	}

	private void initialise() {
		// TODO Auto-generated method stub
		st=(Button)findViewById(R.id.bsa);
		stfr=(Button)findViewById(R.id.bsafr);
		et=(EditText)findViewById(R.id.etsend);
		tv=(TextView)findViewById(R.id.tvGot);
		st.setOnClickListener(this);
		stfr.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bsa:
			String bread=et.getText().toString();
			Bundle basket=new Bundle();
			basket.putString("key", bread);
			Intent a=new Intent(Data.this,OpenendClass.class);
			a.putExtras(basket);
			startActivityForResult(a,0);
			break;
		case	R.id.bsafr:
			
			Intent i=new Intent(Data.this,OpenendClass.class);
			startActivityForResult(i,0);
			break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Bundle basket=data.getExtras();
			String s=basket.getString("answers");
			tv.setText(s);
		}
		
	}

	
}
