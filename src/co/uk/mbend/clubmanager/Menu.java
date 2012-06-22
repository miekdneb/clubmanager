package co.uk.mbend.clubmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class Menu extends FragmentActivity implements
		MenuFrag.OnMenuSelectListener {
	String classes[] = { "BowAct", "ArrowAct", "AccAct", "MemberAct",
			"ScoreAct", "CompAct", "InfoAct" };

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

			switch (position) {

			case 6:
				// InfoFrag infofrag = (InfoFrag)
				// getSupportFragmentManager().findFragmentById(R.id.details);
				Fragment test5 = getSupportFragmentManager().findFragmentById(
						R.id.details);
				if (test5 == null) {
					Log.i("infofrag", "not present, starting. . .");

					InfoFrag infoFragment = new InfoFrag();
					getSupportFragmentManager().beginTransaction()
							.add(R.id.details, infoFragment).commit(); // Starts
																		// Info
																		// Fragment
				} else {
					getSupportFragmentManager().beginTransaction()
							.remove(test5).commit();

					InfoFrag infoFragment = new InfoFrag();
					getSupportFragmentManager().beginTransaction()
							.add(R.id.details, infoFragment).commit(); // Starts
																		// Info
																		// Fragment
				}
				break;

			default:
				Log.i("item selected", "id:" + position);
				break;
			}
		} else {
			Log.i("fragcontainer", "nothing");

			String menupos = classes[position];
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
