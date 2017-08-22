package com.example.gobuslogin;

import com.example.loginwithexternal.SigninActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText uname,pass;
	Button go;TextView display;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		uname=(EditText) findViewById(R.id.editText1);
		pass=(EditText) findViewById(R.id.editText2);
		go=(Button) findViewById(R.id.button1);
		display=(TextView) findViewById(R.id.textView3);
	}
	
	
	   
	   public void loginPost(View view){
	      String username = uname.getText().toString();
	      String password = pass.getText().toString();
	      method.setText("Post Method");
	      new SigninActivity(this,status,role,1).execute(username,password);
	   }

	
}
