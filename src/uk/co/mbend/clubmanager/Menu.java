package uk.co.mbend.clubmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class Menu extends FragmentActivity implements
		MenuFrag.OnMenuSelectListener {
	
	int lastposition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.i("oncreate", "called");

		Fragment test0 = getSupportFragmentManager().findFragmentById(
				R.id.fragment_container);
		if (test0 == null) {
			if (findViewById(R.id.fragment_container) != null) { // Makes sure
																	// fragment_container
																	// is in
																	// layout(i.e.
																	// using
																	// R.layout.main)
				Log.i("creating", "menufragment");
				MenuFrag newFragment = new MenuFrag();
				getSupportFragmentManager().beginTransaction()
						.add(R.id.fragment_container, newFragment).commit(); // Starts
																				// Menu
																				// Fragment
			}
		}
	}

	public void onMenuItemSelected(int position) {

		if (findViewById(R.id.details) != null) // Makes sure fragment_container
												// is in layout (i.e. using
												// R.layout.main)
		{

			Fragment currentlyrunningfragment = getSupportFragmentManager()
					.findFragmentById(R.id.details);
			if (currentlyrunningfragment == null) // if no fragment is running,
													// open selected
			{
				getSupportFragmentManager().beginTransaction()
						.add(R.id.details, uk.co.mbend.clubmanager.Menuitems.menuFragTest(position)).commit();
			} else if (position != lastposition) // If
													// a
													// different
													// fragment
													// is
													// elected,
													// destroy
													// the
													// currently
													// running
													// one,
													// then
													// open
													// selected
			{
				getSupportFragmentManager().beginTransaction()
						.remove(currentlyrunningfragment).commit();
				getSupportFragmentManager().beginTransaction()
						.add(R.id.details, uk.co.mbend.clubmanager.Menuitems.menuFragTest(position)).commit();
				Log.i("destroying", "fragment");
			} // if the same fragment is selected, do nothing

			lastposition = position;
		}

		else {
			Log.i("fragcontainer", "nothing");

			String menupos = uk.co.mbend.clubmanager.Menuitems.Activities[position];
			try {
				Class<?> ourClass = Class.forName("co.uk.mbend.clubmanager."
						+ menupos);
				Intent ourIntent = new Intent(Menu.this, ourClass);
				startActivity(ourIntent); // Starts Activity corresponding to
											// menu selection
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.FragmentActivity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		// SharedPreferences settings =
		// PreferenceManager.getDefaultSharedPreferences();
		// String pasttab = settings.getString("ScoreTab", "7th Tab");
		// Log.i("last tab", pasttab);
	}

}
