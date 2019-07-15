package com.google.android.gms.samples.vision.ocrreader;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button filetypepdf__button = (Button) findViewById(R.id.filetypepdf_button);
        Button filetypedocx__button = (Button) findViewById(R.id.filetypedocx_button);
        Button search_button = (Button) findViewById(R.id.basic_search_button);
        Button done_button =  (Button) findViewById(R.id.done_button);
        TextView textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        textView.setText("Text Read: " +  message);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, message);
                    startActivity(intent);
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        });
        filetypepdf__button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "filetype:pdf " + message);
                    startActivity(intent);
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        });
        filetypedocx__button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "filetype:docx " + message );
                    startActivity(intent);
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        });
        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}

