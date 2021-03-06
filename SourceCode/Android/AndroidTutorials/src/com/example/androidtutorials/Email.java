package com.example.androidtutorials;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements OnClickListener {

	EditText toEmail;
	EditText ccEmail;
	EditText bccEmail;
	EditText subject;
	EditText message;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVariables();
		Button sendEmail = (Button)findViewById(R.id.sendEmailId);
		sendEmail.setOnClickListener(this);
	}

	private void initializeVariables() {
		toEmail = (EditText) findViewById(R.id.toEmails);
		ccEmail = (EditText) findViewById(R.id.ccEmails);
		bccEmail = (EditText) findViewById(R.id.bccEmails);
		subject = (EditText) findViewById(R.id.subjectId);
		message = (EditText) findViewById(R.id.messageId);
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}

	@Override
	public void onClick(View v) {
		String toAddresses[] = { toEmail.getText().toString() };
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, toAddresses);
		emailIntent.putExtra(android.content.Intent.EXTRA_CC, ccEmail.getText().toString());
		emailIntent.putExtra(android.content.Intent.EXTRA_BCC, bccEmail.getText().toString());
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject.getText().toString());
		
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message.getText().toString());
		startActivity(emailIntent);
	}

}
