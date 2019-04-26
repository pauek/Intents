package info.pauek.intents;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditText edit;
    private String original_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edit = findViewById(R.id.edit);

        Intent intent = getIntent();
        original_text = intent.getStringExtra("text");
        if (original_text != null) {
            edit.setText(original_text);
        }
    }

    public void onSave(View view) {
        Intent data = new Intent();
        data.putExtra("text", edit.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public void onBackPressed() {
        String current_text = edit.getText().toString();
        if (!original_text.equals(current_text)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.confirmation);
            builder.setMessage(R.string.sure_to_go_back);
            builder.setPositiveButton(R.string.discard, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton(android.R.string.cancel, null);
            builder.create().show();
        } else {
            finish();
        }
    }

}
