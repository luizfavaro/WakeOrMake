package com.android.wakeormake;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.*;
import android.widget.*;

public class NovoAlarme extends Activity {
	EditText tituloAlarme;
	EditText horaAlarme;
	CheckBox checkTodos, checkSegunda, checkTerca, checkQuarta, checkQuinta,
			checkSexta, checkSabado, checkDomingo;
	Button botaoGravar;
	char segunda;
	char terca;
	char quarta;
	char quinta;
	char sexta;
	char sabado;
	char domingo;

	@Override
	public void onCreate(Bundle icicle) {

		super.onCreate(icicle);
		setContentView(R.layout.novo_alarme);

		tituloAlarme = (EditText) findViewById(R.id.tituloAlarme);
		horaAlarme = (EditText) findViewById(R.id.horaAlarme);

		checkTodos = (CheckBox) findViewById(R.id.checkTodos);
		checkSegunda = (CheckBox) findViewById(R.id.checkSegunda);
		checkTerca = (CheckBox) findViewById(R.id.checkTerca);
		checkQuarta = (CheckBox) findViewById(R.id.checkQuarta);
		checkQuinta = (CheckBox) findViewById(R.id.checkQuinta);
		checkSexta = (CheckBox) findViewById(R.id.checkSexta);
		checkSabado = (CheckBox) findViewById(R.id.checkSabado);
		checkDomingo = (CheckBox) findViewById(R.id.checkDomingo);

		botaoGravar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {

				if (checkSegunda.isChecked())
					segunda = 'S';
				if (checkTerca.isChecked())
					terca = 'S';
				if (checkQuarta.isChecked())
					quarta = 'S';
				if (checkQuinta.isChecked())
					quinta = 'S';
				if (checkSexta.isChecked())
					sexta = 'S';
				if (checkSabado.isChecked())
					sabado = 'S';
				if (checkDomingo.isChecked())
					domingo = 'S';
				if (checkTodos.isChecked())
					segunda = 'S';
					terca = 'S';
					quarta = 'S';
					quinta = 'S';
					sexta = 'S';
					sabado = 'S';
					domingo = 'S';

				// GravaBanco( null,null,horaAlarme,
				// segunda,terca,quarta,quinta,sexta,sabado,domingo,null,tituloAlarme,null);

			}
		});

	}

}
