package co.uk.mbend.clubmanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;

public class Menu extends FragmentActivity implements MenuFrag.OnMenuSelectListener 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		if (findViewById(R.id.fragment_container) != null) { // Makes sure fragment_container is in layout(i.e. using R.layout.main)
	
			MenuFrag newFragment = new MenuFrag();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragment_container, newFragment).commit(); // Starts
																			// Menu
																			// Fragment
		}
	}

	public void onMenuItemSelected(int position) {

		if (findViewById(R.id.fragment_container) != null) // Makes sure fragment_container is in layout (i.e. using R.layout.main)
		{ 
		
			switch (position) 
			{
				case 4:
					Log.i("menu", "selected");
					Fragment test4 = getSupportFragmentManager().findFragmentById(R.id.details);
					//ScoresFrag scorefrag = (ScoresFrag) getSupportFragmentManager().findFragmentById(R.id.details);
					Log.i("menu", "selected");
					if (test4 == null) 
					{
						Log.i("scoresfrag", "not present, starting. . .");

						ScoresFrag scoreFragment = new ScoresFrag();
						getSupportFragmentManager().beginTransaction().add(R.id.details, scoreFragment).commit(); // Starts Info Fragment
					}
					else
					{
						Log.i("fragment", "occupied");
						getSupportFragmentManager().beginTransaction().remove(test4).commit();

						ScoresFrag scoreFragment = new ScoresFrag();
						getSupportFragmentManager().beginTransaction().add(R.id.details, scoreFragment).commit(); // Starts Info Fragment
					}
					break;
				case 5:
					//InfoFrag infofrag = (InfoFrag) getSupportFragmentManager().findFragmentById(R.id.details);
					Fragment test5 = getSupportFragmentManager().findFragmentById(R.id.details);
					if (test5 == null) 
					{
						Log.i("infofrag", "not present, starting. . .");

						InfoFrag infoFragment = new InfoFrag();
						getSupportFragmentManager().beginTransaction().add(R.id.details, infoFragment).commit(); // Starts Info Fragment
					}
					else
					{
						getSupportFragmentManager().beginTransaction().remove(test5).commit();

						InfoFrag infoFragment = new InfoFrag();
						getSupportFragmentManager().beginTransaction().add(R.id.details, infoFragment).commit(); // Starts Info Fragment
					}
					break;
				
				default:
					Log.i("item selected", "id:" + position);
					break;
			}
		} else 
		{
			Log.i("fragcontainer", "nothing");
		}

		
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences();
		//String pasttab = settings.getString("ScoreTab", "7th Tab");
		//Log.i("last tab", pasttab);
	}

}
