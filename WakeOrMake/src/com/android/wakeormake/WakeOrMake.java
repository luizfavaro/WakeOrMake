package com.android.wakeormake;

import java.util.ArrayList;
import java.util.Arrays;

import android.R.array;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.database.*;
import android.database.sqlite.*;

public class WakeOrMake extends Activity {

	String NomeBanco = "WakeorMake";
	static SQLiteDatabase Alarmes = null;
	static Cursor cursor;
	public array AlarmesDaTabela;
	Button botaoAdicionar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wake_or_make);
		botaoAdicionar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(WakeOrMake.this, NovoAlarme.class);
				startActivity(intent);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wake_or_make, menu);
		return true;
	}

	public void CriaBanco() {
		try {
			Alarmes = openOrCreateDatabase(NomeBanco, MODE_WORLD_READABLE, null);
			String SQL = "CREATE TABLE IF NOT EXIST tabAlarmes (_id INTEGER PRIMARY KEY, ativo TEXT, hora TEXT, segunda TEXT, terca TEXT, quarta TEXT, quinta TEXT, sexta TEXT, sabado TEXT, domingo TEXT, toque TEXT, titulo TEXT, desbloqueio INTEGER)";
			Alarmes.execSQL(SQL);
		} catch (Exception erro) {
			MsgInfo("Por algum motivo desconhecido não consegui criar as tabelas nescessárias! "
					+ erro, "Erro no Banco de Dados!");
		}
	}

	// S OU N HH:MM S OU N S OU N S OU N S OU N S OU N S OU N S OU N
	// DIRETORIOMUSIC DIGITAR TITLE CODIGO TIPO DESBLOQUEIO -> FAZER CLASSE
	// VERIFICAR ESTE CAMPO E EXECUTAR A VALIDAÇÃO.
	public void GravaBanco(Integer ID, String ativo, String hora,
			String segunda, String terca, String quarta, String quinta,
			String sexta, String sabado, String domingo, String toque,
			String titulo, Integer desbloqueio) {
		try {
			Alarmes = openOrCreateDatabase(NomeBanco, MODE_WORLD_READABLE, null);
			String SQL = "INSERT INTO tabnAlarmes (id, ativo, hora, segunda, terca, quarta, quinta, sexta, sabado, domingo, toque, titulo, desbloqueio) VALUES ( id = "
					+ Integer.toString(ID)
					+ " ativo = '"
					+ ativo
					+ "', hora = '"
					+ hora
					+ "', segunda = '"
					+ segunda
					+ "', terca = '"
					+ terca
					+ "', quarta = '"
					+ quarta
					+ "', quinta = '"
					+ quinta
					+ "', sexta = '"
					+ sexta
					+ "', sabado = '"
					+ sabado
					+ "', domigo = '"
					+ domingo
					+ "', toque = '"
					+ toque
					+ "', titutlo = '"
					+ titulo
					+ "', desbolqueio = " + Integer.toString(desbloqueio) + ")";
			Alarmes.execSQL(SQL);
		} catch (Exception erro) {
			MsgInfo("Por algum motivo desconhecido não consegui criar as tabelas nescessárias! "
					+ erro, "Erro no Banco de Dados!");
		}
	}

	public void AlteraBanco(Integer ID, String ativo, String hora,
			String segunda, String terca, String quarta, String quinta,
			String sexta, String sabado, String domingo, String toque,
			String titulo, Integer desbloqueio) {
		try {
			Alarmes = openOrCreateDatabase(NomeBanco, MODE_WORLD_READABLE, null);
			String SQL = "UPDATE tabnAlarmes SET ativo = '" + ativo
					+ "', hora = '" + hora + "', segunda = '" + segunda
					+ "', terca = '" + terca + "', quarta = '" + quarta
					+ "', quinta = '" + quinta + "', sexta = '" + sexta
					+ "', sabado = '" + sabado + "', domigo = '" + domingo
					+ "', toque = '" + toque + "', titutlo = '" + titulo
					+ "', desbolqueio = " + Integer.toString(desbloqueio)
					+ " WHERE id = " + Integer.toString(ID);
			Alarmes.execSQL(SQL);
		} catch (Exception erro) {
			MsgInfo("Por algum motivo desconhecido não consegui criar as tabelas nescessárias! "
					+ erro, "Erro no Banco de Dados!");
		}
	}

	public ArrayList<Integer> PegaAlarmes() {
		ArrayList<Integer> AlarmesDaTabela = new ArrayList<Integer>();
		cursor = Alarmes.rawQuery("SELECT * FROM tabAlarmes", null);
		cursor.moveToFirst();

		while (!cursor.isAfterLast()) {
			AlarmesDaTabela.add(Integer.parseInt(cursor.getString(0)));
			cursor.moveToNext();
		}
		return AlarmesDaTabela;
	}

	public void MsgInfo(String Mensagem, String Titulo) {
		AlertDialog.Builder Dialog = new AlertDialog.Builder(WakeOrMake.this);
		Dialog.setTitle(Titulo);
		Dialog.setMessage(Mensagem);
		Dialog.setNeutralButton("Ok", null);
		Dialog.show();
	}

}
