package com.my;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainFragmentActivity extends FragmentActivity implements
		OnClickListener, OnButtonPressListener {

	private Button tap1;
	private Button tap2;
	private static boolean isPortTrait = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tap1 = (Button) findViewById(R.id.tap1);
		tap1.setOnClickListener(this);
		tap2 = (Button) findViewById(R.id.tap2);
		tap2.setOnClickListener(this);

		if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			if (isPortTrait == true) {
				isPortTrait = false;
				addFragment("tap_1");
			}
			// code to do for Portrait Mode
		} else {
			// code to do for Landscape Mode
		}
	}

	private void addFragment(String tag) {

		// Add fragment 1 without XML
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		Tab_1_Fragment fragment1 = Tab_1_Fragment.newInstance(0);

		fragmentTransaction.add(R.id.root_fragment, fragment1, tag);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();

	}

	private void removeFragment() {

		// Add fragment 1 without XML
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		Fragment f = fragmentManager.findFragmentByTag("tap_1");

		// FragmentExample fragment1 = FragmentExample.newInstance(0);

		fragmentTransaction.remove(f);
		// fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();

	}

	public void replaceFragment() {

		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		Fragment replace = Tab_1_1_Fragment.newInstance(1);
		transaction.replace(R.id.root_fragment, replace);
		// transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		// transaction.add(fragmentManager.findFragmentById(R.id.the_frag),
		// replace, "fragment1");
		transaction.addToBackStack(null);
		transaction.commit();

	}

	boolean isAddFragment = false;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tap1:
			FragmentManager fragmentManagerTab1 = getSupportFragmentManager();

			int fragmentManagerSize = fragmentManagerTab1
					.getBackStackEntryCount();

			for (int i = 0; i < fragmentManagerSize; i++) {
				fragmentManagerTab1.popBackStack();
			}

			Tab_2_Fragment tap_2_temp = (Tab_2_Fragment) getSupportFragmentManager()
					.findFragmentByTag("tab_2_0");
			if (tap_2_temp != null) {
				FragmentTransaction fragmentTransaction = fragmentManagerTab1
						.beginTransaction();
				fragmentTransaction.remove(tap_2_temp).commit();
			}

			addFragment("tap_1");

			break;
		case R.id.tap2:

			FragmentManager fragmentManager = getSupportFragmentManager();
			int fragmentManagerSize2 = fragmentManager.getBackStackEntryCount();
			Toast.makeText(this,
					"fragmentManagerSize2 = " + fragmentManagerSize2,
					Toast.LENGTH_LONG).show();

			for (int i = 0; i < fragmentManagerSize2; i++) {
				fragmentManager.popBackStack();
			}

			// remove parrent fragment
			Tab_1_Fragment tap_1 = (Tab_1_Fragment) getSupportFragmentManager()
					.findFragmentByTag("tap_1");
			if (tap_1 != null) {
				FragmentTransaction fragmentTransaction2_1 = fragmentManager
						.beginTransaction();
				fragmentTransaction2_1.remove(tap_1).commit();
			}

			FragmentTransaction fragmentTransaction2 = fragmentManager
					.beginTransaction();
			Tab_2_Fragment tab_2 = Tab_2_Fragment.newInstance(0);
			fragmentTransaction2.add(R.id.root_fragment, tab_2, "tab_2_0");
			fragmentTransaction2.commit();

			break;

		default:
			break;
		}
	}

	@Override
	public void onBackPressed() {
		Toast.makeText(this, "onBackPressed", Toast.LENGTH_LONG).show();
		try {
			Tab_1_1_Fragment tap_1_1 = (Tab_1_1_Fragment) getSupportFragmentManager()
					.findFragmentByTag("tap_1_1");

			if (tap_1_1.allowBackPressed(true)) {
				// and then you define a method allowBackPressed with the logic
				// to allow back pressed or not super.onBackPressed();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Tab_1_Fragment tap_1 = (Tab_1_Fragment) getSupportFragmentManager()
					.findFragmentByTag("tap_1");
			if (tap_1.allowBackPressed(true)) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.onBackPressed();
	}

	@Override
	public void onButtonPressed(String msg) {

		Tab_1_Fragment Obj = (Tab_1_Fragment) getSupportFragmentManager()
				.findFragmentByTag("tap_1");
		Obj.setMessage(msg);
	}
}