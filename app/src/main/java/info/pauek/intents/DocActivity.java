package info.pauek.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DocActivity extends AppCompatActivity {

    public static final int EDIT_TITLE = 1;
    public static final int EDIT_TEXT = 2;

    private String stitle;
    private String stext;
    private TextView title;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        stitle = getString(R.string.title_demo);
        stext = getString(R.string.text_demo);

        title = findViewById(R.id.title);
        text = findViewById(R.id.text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.edit_text:
            editText();
            break;
        case R.id.edit_title:
            editTitle();
            break;
        }
        return true;
    }

    private void editTitle() {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("text", stitle);
        startActivityForResult(intent, EDIT_TITLE);
    }

    private void editText() {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("text", stext);
        startActivityForResult(intent, EDIT_TEXT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
        case EDIT_TEXT:
            if (resultCode == RESULT_OK) {
                stext = data.getStringExtra("text");
                text.setText(stext);
            }
            break;
        case EDIT_TITLE:
            if (resultCode == RESULT_OK) {
                stitle = data.getStringExtra("text");
                title.setText(stitle);
            }
            break;
        }
    }
}
