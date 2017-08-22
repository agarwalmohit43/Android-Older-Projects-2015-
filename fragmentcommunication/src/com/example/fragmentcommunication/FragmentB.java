package com.example.fragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

	TextView tv;
	String datas;

	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragb, container, false);
		
		if (savedInstanceState == null) {
			datas = null;
		} else {
			datas=savedInstanceState.getString("countervalue");
			TextView ttv=(TextView) view.findViewById(R.id.textView1);
			ttv.setText(datas);
		}
		return view;

	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		tv = (TextView) getActivity().findViewById(R.id.textView1);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("countervalue", datas);
	}

	public void changetext(String data) {
		this.datas = data;
		tv.setText(datas);
	}
}
