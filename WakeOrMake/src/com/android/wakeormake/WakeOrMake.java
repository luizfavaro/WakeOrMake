package com.android.wakeormake;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.database.*;
import android.database.sqlite.*;

public class WakeOrMake extends Activity {

	String NomeBanco = "WakeorMake";   
	SQLiteDatabase Alarmes = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wake_or_make);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wake_or_make, menu);
		return true;
	}

	public void CriaBanco(){
		try {
			Alarmes = openOrCreateDatabase(NomeBanco, MODE_WORLD_READABLE, null);
			String SQL = "CREATE TABLE IF NOT EXIST tabAlarmes (_id INTEGER PRIMARY KEY, ativo TEXT, hora TEXT, segunda TEXT, terca TEXT, quarta TEXT, quinta TEXT, sexta TEXT, sabado TEXT, domingo TEXT, toque TEXT, titulo TEXT, desbloqueio INTEGER)";
			Alarmes.execSQL(SQL);    
		} catch (Exception erro) {
		}
	}
	                        //    S OU N       HH:MM           S OU N        S OU N         S OU N         S OU N        S OU N        S OU N           S OU N  DIRETORIOMUSIC  DIGITAR TITLE   CODIGO TIPO DESBLOQUEIO -> FAZER CLASSE VERIFICAR ESTE CAMPO E EXECUTAR A VALIDAÇÃO.
	public void GravaBanco( String ativo, String hora, String segunda, String terca, String quarta, String quinta, String sexta, String sabado, String domingo, String toque, String titulo, Integer desbloqueio  ){
		try {
			Alarmes = openOrCreateDatabase(NomeBanco, MODE_WORLD_READABLE, null);
			String SQL = "INSERT INTO tabnAlarmes (ativo, hora, segunda, terca, quarta, quinta, sexta, sabado, domingo, toque, titulo, desbloqueio) VALUES ( ativo = '" + ativo + "', hora = '" + hora + "', segunda = '" + segunda + "', terca = '" + terca + "', quarta = '" + quarta + "', quinta = '" + quinta + "', sexta = '" + sexta +"', sabado = '" + sabado + "', domigo = '" + domingo + "', toque = '" + toque + "', titutlo = '" + titulo + "', desbolqueio = " + Integer.toString(desbloqueio) + ")";
			Alarmes.execSQL(SQL);
		} catch (Exception erro) {
			// TODO: handle exception
		}
	}
		
}
