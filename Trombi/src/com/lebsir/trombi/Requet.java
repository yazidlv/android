package com.lebsir.trombi;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;


public class Requet extends GererBDD{
	
	
	public Requet(Context pContext) {
		super(pContext);
	}

	
	
	
		
		public static final String ID="id";
		public static final String NOM="nom";
		public static final String PRENOM="prenom";
		static final String IMAGE="IMAGE";

		
		public static final String TABLE_NAME="Profils";
		public static final String PROFIL_TABLE_CREATE=
				"CREATE TABLE " + TABLE_NAME + "(" +
				ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
				NOM + " TEXT," +
				PRENOM + " TEXT, " +
				IMAGE + " TEXT" +
				");";

		public static final String PROFIL_TABLE_DROP="DROP TABLE IF EXISTS "+TABLE_NAME+";";
		
		public void ajouter(profil profil){
			ContentValues cv = new ContentValues();
			cv.put(NOM, profil.getNom());
			cv.put(PRENOM, profil.getPrenom());
			cv.put(IMAGE, profil.getImage());
			BDD.insert(Requet.TABLE_NAME, null, cv);
		}

		public Cursor tousLesProfils(){
			 Cursor c = BDD.rawQuery("SELECT "+ID+", "+NOM+", "+PRENOM+", "+IMAGE+" FROM "+TABLE_NAME+";", null);
			return c;
		}
		
		

		
		
	}


