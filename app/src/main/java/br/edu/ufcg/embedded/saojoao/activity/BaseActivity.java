package br.edu.ufcg.embedded.saojoao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.edu.ufcg.embedded.saojoao.R;

/**
 * Created by Pedro on 23/05/2015.
 */
public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    public void setBar(String title) {
        Toolbar toolbarFromContext = (Toolbar) findViewById(R.id.toolbar);
        if (toolbarFromContext != null) {
            toolbar = toolbarFromContext;
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(title);


    }

    public Toolbar getBar() {
        return this.toolbar;
    }
}
