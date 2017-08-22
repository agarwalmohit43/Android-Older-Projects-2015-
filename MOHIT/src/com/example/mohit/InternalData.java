package com.example.mohit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {

	

	 EditText sharedata;
	 TextView dataresult;
	 FileOutputStream fs;
	 String filename="myinternal";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedprefs);
		initialise();
	}
	
	private void initialise() {
		// TODO Auto-generated method stub
		Button save=(Button)findViewById(R.id.shsave);
		Button load=(Button)findViewById(R.id.shload);
		sharedata=(EditText)findViewById(R.id.shet);
		dataresult=(TextView)findViewById(R.id.shtv);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		try {
			fs=openFileOutput(filename,Context.MODE_PRIVATE);
			fs.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.shsave:
			String data=sharedata.getText().toString();
			/*File f=new File(filename);
			try {
				fs=new FileOutputStream(f);
				fs.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			try {
			fs=openFileOutput(filename,Context.MODE_PRIVATE);
			
				fs.write(data.getBytes());
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case R.id.shload:
			new loadsomestuff().execute(filename);
			break;
		}
		
	}
	public class loadsomestuff extends AsyncTask<String,Integer,String>{

		ProgressDialog dialog;
		protected void onPreExecute(){
			dialog=new ProgressDialog(InternalData.this);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.show();
		}
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String collected=null;
			FileInputStream fi=null;
			for(int i=0;i<20;i++){
				publishProgress(5);
				try {
					Thread.sleep(88);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			dialog.dismiss();
			try {
				fi=openFileInput(filename);
				byte[] dataarray=new byte[fi.available()];
				while(fi.read(dataarray)!=-1){
					collected=new String(dataarray);
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					fi.close();
					return collected;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}
		 protected void onProgressUpdate(Integer...progress){
			 
			 
			 
		 }
		protected void onPostExecute(String reult){
			dataresult.setText(reult);
		}
		
	}
	
}
