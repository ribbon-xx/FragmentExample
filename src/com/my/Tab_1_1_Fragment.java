package com.my;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Tab_1_1_Fragment extends Fragment implements OnClickListener {

	private OnButtonPressListener buttonListener;
	private Button tap_1_1_button1;

	public static Tab_1_1_Fragment newInstance(int index) {
		Tab_1_1_Fragment f = new Tab_1_1_Fragment();

		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);
		return f;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			buttonListener = (OnButtonPressListener) getActivity();
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFileSelectedListener");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		Bundle bundle = getArguments();
		String str = bundle.getString("data_temp");

		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View layout = inflater.inflate(R.layout.tab_1_1_fragment, container,
				false);
		tap_1_1_button1 = (Button) layout.findViewById(R.id.tap_1_1_button1);
		tap_1_1_button1.setOnClickListener(this);
		return layout;
	}

	public boolean allowBackPressed(boolean isAllowBackPress) {
		if (isAllowBackPress) {

			Toast.makeText(getActivity(),
					"allowBackPressed   Tap_1_1_Fragment", Toast.LENGTH_LONG)
					.show();
		}

		return true;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tap_1_1_button1:
			buttonListener.onButtonPressed("Data result from Tab_1_1");

			FragmentManager fragmentManager = getFragmentManager();

			Toast.makeText(
					getActivity(),
					"fragmentManager.getBackStackEntryCount() =  "
							+ fragmentManager.getBackStackEntryCount(),
					Toast.LENGTH_LONG).show();

			// FragmentTransaction fragmentTransaction = fragmentManager
			// .beginTransaction();
			// Fragment f = fragmentManager.findFragmentByTag("tap_1_1");
			// fragmentTransaction.remove(this).commit();

			fragmentManager.popBackStack();
			break;

		default:
			break;
		}

	}

}
