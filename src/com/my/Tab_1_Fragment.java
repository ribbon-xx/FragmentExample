package com.my;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tab_1_Fragment extends Fragment implements OnClickListener {

	private TextView tap_1_text;

	public static Tab_1_Fragment newInstance(int index) {
		Tab_1_Fragment f = new Tab_1_Fragment();

		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);

		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View layout = inflater.inflate(R.layout.tab_1_fragment, container,
				false);
		tap_1_text = (TextView) layout.findViewById(R.id.tap_1_text);
		Button f1_button1 = (Button) layout.findViewById(R.id.f1_button1);
		Toast.makeText(getActivity(), "onCreateView ph = ", Toast.LENGTH_LONG)
				.show();
		f1_button1.setOnClickListener(this);
		if (msg != null) {
			tap_1_text.setText(msg);
		}
		return layout;
	}

	public void addFragment() {

		Tab_1_1_Fragment replace = Tab_1_1_Fragment.newInstance(0);
		FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();
		transaction.add(R.id.root_fragment, replace, "tap_1_1");
		transaction.addToBackStack(null);
		// commit the transaction
		transaction.commit();
		// transaction.show(videoFragment);
	}

	public void replaceFragment() {

		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();

		// send data via fragment
		Bundle arguments = new Bundle();
		arguments.putString("data_temp", "phuongnv");

		Fragment replace = Tab_1_1_Fragment.newInstance(1);
		replace.setArguments(arguments);
		transaction.replace(R.id.root_fragment, replace, "tap_1_1");

		transaction.addToBackStack(null);
		transaction.commit();

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.f1_button1:
//			 addFragment();
			replaceFragment();

			// //
			// //
			// //
			// getChildFragmentManager().beginTransaction().hide(this).commit();
			// //
			// FragmentManager fragmentManager = getFragmentManager();
			// FragmentTransaction fragmentTransaction = fragmentManager
			// .beginTransaction();
			// Fragment f = fragmentManager.findFragmentByTag("fragment1");
			// fragmentTransaction.remove(f).commit();
			// // fragmentTransaction.hide(f).commit();
		}
	}

	@Override
	public void onDestroy() {
		Toast.makeText(getActivity(), "onDestroy Tap1Fragment ",
				Toast.LENGTH_LONG).show();
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		Toast.makeText(getActivity(), "onDetach Tap1Fragment ",
				Toast.LENGTH_LONG).show();
		super.onDetach();
	}

	public boolean allowBackPressed(boolean isAllowBackPress) {
		if (isAllowBackPress) {
			Toast.makeText(getActivity(), "allowBackPressed  Tap_1_Fragment",
					Toast.LENGTH_LONG).show();
		}

		return true;
	}

	String msg = null;

	public void setMessage(String msg) {
		Toast.makeText(getActivity(), "onButtonPressed ph = " + msg,
				Toast.LENGTH_LONG).show();
		tap_1_text.setText(msg);
		this.msg = msg;
	}
}
