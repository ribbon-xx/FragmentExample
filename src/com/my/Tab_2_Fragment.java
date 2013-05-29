package com.my;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab_2_Fragment extends Fragment {

	public static Tab_2_Fragment newInstance(int index) {
		Tab_2_Fragment f = new Tab_2_Fragment();

		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View layout = inflater.inflate(R.layout.tab_2_fragment, container,
				false);

		return layout;
	}
}
