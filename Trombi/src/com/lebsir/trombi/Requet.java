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
		
		/*public void supprimer(profil profil){
			BDD.delete(TABLE_NAME, ID + " = ?", new String[] {String.valueOf(profil.getId())});	
		}
		
		
		// option modifier je l'utilise pas 
		/*public void modifier(profil profil){
			ContentValues cv = new ContentValues();
			cv.put(NOM, profil.getNom());
			cv.put(PRENOM, profil.getPrenom());
			cv.put(IMAGE,profil.getImage());
			BDD.update(TABLE_NAME, cv,ID + " = ?", new String[] {String.valueOf(profil.getId())});	
		}*/
		
		/*public profil selectionnerUnProfil(int id){
			 Cursor c = BDD.rawQuery("SELECT "+ID+", "+NOM+", "+PRENOM+","+IMAGE+" FROM "+TABLE_NAME+" WHERE "+ID+"=?;", new String[] {String.valueOf(id)});
			  c.moveToFirst();
			return new Profil(c.getInt(0),c.getString(1),c.getString(2), c.getString(3),c.getString(4));
		}*/
		
		public Cursor tousLesProfils(){
			 Cursor c = BDD.rawQuery("SELECT "+ID+", "+NOM+", "+PRENOM+", "+IMAGE+" FROM "+TABLE_NAME+";", null);
			return c;
		}
		
		

		
		
	}


