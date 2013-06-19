package com.lebsir.trombi;




import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

public class view_list extends Activity{



		private Requet BDD;
		private profil profil;
		private GridView listeProfils;

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.view_list);

			listeProfils = (GridView) findViewById(R.id.ListeProfils);

			ArrayList<HashMap<String, Object>> listeElemProfils = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> malist = new HashMap<String, Object>();

			
			profil.setImage(null);
			BDD = new Requet(this);
			BDD.open();
			Cursor cursor =BDD.tousLesProfils();
			cursor.moveToFirst();
			if (!cursor.isAfterLast()) {		
			do {
				malist = new HashMap<String, Object>();
				malist.put("image", cursor.getString(4));
				listeElemProfils.add(malist);
				} 
			while (cursor.moveToNext());
				cursor.close();
			}
		}
}