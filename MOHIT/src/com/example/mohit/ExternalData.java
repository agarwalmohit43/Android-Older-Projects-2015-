package com.example.mohit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ExternalData extends Activity implements OnItemSelectedListener, OnClickListener {
	
	private TextView canread,canwrite;
	private String state;
	boolean canW,canR;
	Spinner sp;
	String[] paths={"Music","Pictures","Download"};
	File path=null;
	File file=null;
	EditText savefile;
	Button confirm,save;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);
		canread=(TextView)findViewById(R.id.tvcanread);
		canwrite=(TextView)findViewById(R.id.tvcanwrite);
		sp=(Spinner)findViewById(R.id.spinner1);
		confirm=(Button)findViewById(R.id.bconfirm);
		save=(Button)findViewById(R.id.bsave);
		confirm.setOnClickListener(this);
		save.setOnClickListener(this);
		savefile=(EditText)findViewById(R.id.etsaveas);
		checkstate();
		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(ExternalData.this,android.R.layout.simple_spinner_item,paths);
		sp.setAdapter(adapter);
		sp.setOnItemSelectedListener(this);
	}
	private void checkstate() {
		// TODO Auto-generated method stub
		state=Environment.getExternalStorageState();
		if(state.equals(Environment.MEDIA_MOUNTED)){
			//red and write
			canread.setText("true");
			canwrite.setText("true");
			canW=canR=true;
		}else if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
			//read only
			canread.setText("true");
			canwrite.setText("false");
			canW=false;
			canR=true;
		}else{
			canread.setText("false");
			canwrite.setText("false");
			canW=canR=false;

		}
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		int positions=sp.getSelectedItemPosition();
		switch(positions){
		case 0:
			path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;
		case 1:
			path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;
		case 2:
			path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			break;
		}
	}
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bsave:
			String f=savefile.getText().toString();
			file=new File(path,f+".jpg");
			checkstate();
			if(canW==canR==true){
				
				path.mkdirs();
				
				try {
					InputStream is=getResources().openRawResource(R.drawable.mi);
					OutputStream os=new FileOutputStream(file);
					byte[] data=new byte[is.available()];
					is.read(data);
					os.write(data);
					is.close();
					os.close();
					Toast t=Toast.makeText(ExternalData.this,"FILE SAVED",Toast.LENGTH_LONG);
					t.show();
					
					MediaScannerConnection.scanFile(ExternalData.this,new String[] {file.toString()},null,new MediaScannerConnection.OnScanCompletedListener() {
						
						@Override
						public void onScanCompleted(String path, Uri uri) {
							// TODO Auto-generated method stub
							Toast t=Toast.makeText(ExternalData.this,"FILE SCANNED",Toast.LENGTH_LONG);
							t.show();
						}
					});
						
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		case R.id.bconfirm:
			save.setVisibility(View.VISIBLE);
			break;
		}
	}

	
}
