package com.lebsir.trombi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
public abstract class GererBDD {


	
		  protected final static int VERSION = 1;
		

		     
		  protected SQLiteDatabase BDD  = null;
		  protected DatabaseHelper BDHelper = null;
		     
		  public GererBDD(Context pContext) {
		    this.BDHelper = new DatabaseHelper(pContext);
		  }
		     
		 
		  public SQLiteDatabase open() {
		    BDD =BDHelper.getWritableDatabase();
		    return BDD;
		  }
		     
		  
		  public void close() {
		    BDD.close();
		  }
		     
		  public SQLiteDatabase getBDD() {
		    return BDD;
		  }
		}


