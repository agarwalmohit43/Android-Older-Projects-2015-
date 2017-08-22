package com.example.loginexternaldb;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
 
    Button login;
    EditText uname,pass;
    String name="",passd="";
    TextView tv;
    byte[] data;
    HttpPost httppost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    InputStream inputStream;
    SharedPreferences app_preferences ;
    List<NameValuePair> nameValuePairs;
    CheckBox check;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        uname = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        check = (CheckBox) findViewById(R.id.check);
 
        String Str_user = app_preferences.getString("uname","0" );
        String Str_pass = app_preferences.getString("pass", "0");
        String Str_check = app_preferences.getString("checked", "no");
        if(Str_check.equals("yes"))
        {
                uname.setText(Str_user);
                pass.setText(Str_pass);
                check.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                name = uname.getText().toString();
                passd = pass.getText().toString();
                String Str_check2 = app_preferences.getString("checked", "no");
                if(Str_check2.equals("yes"))
                {
                    SharedPreferences.Editor editor = app_preferences.edit();
                    editor.putString("uname", name);
                    editor.putString("pass", passd);
                     editor.commit();
                }
                if(name.equals("") || pass.equals(""))
                {
                     Toast.makeText(MainActivity.this, "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
                }
                else
                {
 
 
                try {
                    httpclient = new DefaultHttpClient();
                    httppost = new HttpPost("http://mohit.gobusnepal.com/android/logintestandroid.php");
                    // Add your data
                    nameValuePairs = new ArrayList<NameValuePair>(2);
                   nameValuePairs.add(new BasicNameValuePair("uname", name.trim()));
                    nameValuePairs.add(new BasicNameValuePair("pass", passd.trim()));
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
                    // Execute HTTP Post Request
                    response = httpclient.execute(httppost);
                    inputStream = response.getEntity().getContent();
 
                    data = new byte[256];
 
                    buffer = new StringBuffer();
                    int len = 0;
                    while (-1 != (len = inputStream.read(data)) )
                    {
                        buffer.append(new String(data, 0, len));
                    }
 
                    inputStream.close();
                }
 
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "error"+e.toString(), Toast.LENGTH_LONG).show();
                }
                if(buffer.charAt(0)=='Y')
                {
                    Toast.makeText(MainActivity.this, "login successfull", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid Username or password", Toast.LENGTH_LONG).show();
                }
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                // Perform action on clicks, depending on whether it's now checked
                SharedPreferences.Editor editor = app_preferences.edit();
                if (((CheckBox) v).isChecked())
                {
 
 
                     editor.putString("checked", "yes");
                     editor.commit();
                }
                else
                {
                     editor.putString("checked", "no");
                     editor.commit();
                }
            }
        });
    }
        public void Move_to_next()
        {
 
        //  startActivity(new Intent(this, zzz.class));
        }
}
