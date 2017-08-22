package com.example.mohit;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener {

	
	Button sqlupdate,sqlview,sqlmodify,sqlgetinfo,sqldelete;
	EditText sqlname,sqlhot,sqlrow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqliteexample);
		
		sqlupdate=(Button)findViewById(R.id.bsqlupdate);
		sqlview=(Button)findViewById(R.id.bsqlopenview);
		sqlmodify=(Button)findViewById(R.id.bsqlmodify);
		sqlgetinfo=(Button)findViewById(R.id.bgetinfo);
		sqldelete=(Button)findViewById(R.id.bsqldelete);


		sqlname=(EditText)findViewById(R.id.etsqlname);
		sqlhot=(EditText)findViewById(R.id.etsqlhottness);
		sqlrow=(EditText)findViewById(R.id.etsqlrowinfo);

		
		
		
		
		sqlmodify.setOnClickListener(this);
		sqlgetinfo.setOnClickListener(this);
		sqldelete.setOnClickListener(this);
		sqlupdate.setOnClickListener(this);
		sqlview.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bsqlupdate:
			boolean diditwork=true;
			try{
			String name=sqlname.getText().toString();
			String hotness=sqlhot.getText().toString();
			
			HotOrNot entry=new HotOrNot(SQLiteExample.this);
			entry.open();
			entry.createEntry(name,hotness);
			entry.close();
			}catch(Exception e){
				 diditwork=false;
				 String error=e.toString();
				 Dialog d=new Dialog(this);
					d.setTitle("DANG IT!");
					TextView tv=new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();
			}finally{
				if(diditwork){
					Dialog d=new Dialog(this);
					d.setTitle("HECK ya!");
					TextView tv=new TextView(this);
					tv.setText("SUCCESS");
					d.setContentView(tv);
					d.show();
				}
			}
			break;
		case R.id.bsqlopenview:
			Intent i=new Intent(SQLiteExample.this,SQLView.class);
			startActivity(i);
			break;
			
		case R.id.bgetinfo:
			try{
			String s=sqlrow.getText().toString();
			long l=Long.parseLong(s);
			HotOrNot hon=new HotOrNot(this);
			hon.open();
			String returnedname=hon.getName(l);
			String returnedhotness=hon.getHot(l);
			sqlname.setText(returnedname);
			sqlhot.setText(returnedhotness);
		}catch(Exception e){
			 
			 String error=e.toString();
			 Dialog d=new Dialog(this);
				d.setTitle("DANG IT!");
				TextView tv=new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
		}
			break;
		case R.id.bsqlmodify:
		try{	String sname=sqlname.getText().toString();
			String shotness=sqlhot.getText().toString();
			String ss=sqlrow.getText().toString();
			long ll=Long.parseLong(ss);
			HotOrNot ex=new HotOrNot(this);
			ex.open();
			ex.updateentry(ll,sname,shotness);
			ex.close();
		}catch(Exception e){
			
			 String error=e.toString();
			 Dialog d=new Dialog(this);
				d.setTitle("DANG IT!");
				TextView tv=new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
		}
			break;
		case R.id.bsqldelete:
		try{	String sss=sqlrow.getText().toString();
			long lll=Long.parseLong(sss);
			HotOrNot eex=new HotOrNot(this);
			eex.open();
			eex.deleteentry(lll);
			eex.close();
		}catch(Exception e){
			
			 String error=e.toString();
			 Dialog d=new Dialog(this);
				d.setTitle("DANG IT!");
				TextView tv=new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
		}
			break;
		}
		
		
		
	}
	
	
	
}
