package co.uk.mbend.clubmanager;

import android.support.v4.app.Fragment;

public class Menuitems {

	static String[] Activities = { "BowAct", "ArrowAct", "AccAct", "MemberAct",
			"ScoreAct", "CompAct", "InfoAct" };

	//static String[] Fragments = { "BowFrag", "ArrowFrag", "AccFrag", "MemberFrag",
		//	"ScoreFrag", "CompFrag", "InfoFrag" };

	static String[] Names = { "Bows", "Arrows", "Accessories", "Members",
			"Scores", "Competitions", "Information" };
	

	public static Fragment menuFragTest(int position) {
		switch (position) {
		case 0:
			BowFrag bowFrag = new BowFrag();
			return bowFrag;
		case 1:
			ArrowFrag arrowFrag = new ArrowFrag();
			return arrowFrag;
		case 2:
			AccFrag accFrag = new AccFrag();
			return accFrag;
		case 3:
			MemberFrag memberFrag = new MemberFrag();
			return memberFrag;
		case 4:
			ScoreFrag scoreFrag = new ScoreFrag();
			return scoreFrag;
		case 5:
			CompFrag compFrag = new CompFrag();
			return compFrag;
		case 6:
		default:
			InfoFrag infoFrag = new InfoFrag();
			return infoFrag;

		}

	}

}
