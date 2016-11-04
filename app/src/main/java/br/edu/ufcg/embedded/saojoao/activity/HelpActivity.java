package br.edu.ufcg.embedded.saojoao.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.ufcg.embedded.saojoao.R;
import br.edu.ufcg.embedded.saojoao.utils.AjudaListItem;
import br.edu.ufcg.embedded.saojoao.utils.HelpAdapter;

public class HelpActivity extends BaseActivity {

    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String, List<AjudaListItem>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setBar(getString(R.string.help));
        listView = (ExpandableListView) findViewById(R.id.ajuda_list);
        prepareListData();
        listView.setAdapter(new HelpAdapter(this, listDataHeader, listDataChild));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_back);

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        String programacao = getString(R.string.programacao);
        AjudaListItem programacaoListItem = new AjudaListItem(getString(R.string.programacao_descricao));
        List<AjudaListItem> list = new ArrayList<>();
        list.add(programacaoListItem);
        listDataHeader.add(programacao);
        listDataChild.put(programacao, list);

        String estrela = getString(R.string.bookmark);
        AjudaListItem estrelaListItem = new AjudaListItem(getString(R.string.bookmark_descricao));
        list = new ArrayList<>();
        list.add(estrelaListItem);
        listDataHeader.add(estrela);
        listDataChild.put(estrela, list);

        String youtube = getString(R.string.youtube);
        AjudaListItem youtubeListItem = new AjudaListItem(getString(R.string.youtube_descricao));
        list = new ArrayList<>();
        list.add(youtubeListItem);
        listDataHeader.add(youtube);
        listDataChild.put(youtube, list);

        String mapa = getString(R.string.title_activity_map);
        AjudaListItem mapaListItem = new AjudaListItem(getString(R.string.mapa_descricao));
        list = new ArrayList<>();
        list.add(mapaListItem);
        listDataHeader.add(mapa);
        listDataChild.put(mapa, list);

        String marcador = getString(R.string.mark);
        AjudaListItem marcadorListItem = new AjudaListItem(getString(R.string.marker_decricao));
        list = new ArrayList<>();
        list.add(marcadorListItem);
        listDataHeader.add(marcador);
        listDataChild.put(marcador, list);

        String camera = getString(R.string.photo);
        AjudaListItem cameralist = new AjudaListItem(getString(R.string.camera_descricao));
        list = new ArrayList<>();
        list.add(cameralist);
        listDataHeader.add(camera);
        listDataChild.put(camera, list);

        String mainCamera = getString(R.string.main_camera);
        AjudaListItem mainCameraList = new AjudaListItem(getString(R.string.main_camera_descricao));
        list = new ArrayList<>();
        list.add(mainCameraList);
        listDataHeader.add(mainCamera);
        listDataChild.put(mainCamera, list);

        String selfie = getString(R.string.selfie);
        AjudaListItem selfieList = new AjudaListItem(getString(R.string.selfie_descricao));
        list = new ArrayList<>();
        list.add(selfieList);
        listDataHeader.add(selfie);
        listDataChild.put(selfie, list);

        String download = getString(R.string.download);
        AjudaListItem downloadList = new AjudaListItem(getString(R.string.download_descricao));
        list = new ArrayList<>();
        list.add(downloadList);
        listDataHeader.add(download);
        listDataChild.put(download, list);

        String busca = getString(R.string.title_activity_search);
        AjudaListItem buscaList = new AjudaListItem(getString(R.string.search_descricao));
        list = new ArrayList<>();
        list.add(buscaList);
        listDataHeader.add(busca);
        listDataChild.put(busca, list);

        String lemb = getString(R.string.title_activity_lembretes);
        AjudaListItem lembList = new AjudaListItem(getString(R.string.lembrete_descricao));
        list = new ArrayList<>();
        list.add(lembList);
        listDataHeader.add(lemb);
        listDataChild.put(lemb, list);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        Intent intent;
        if (itemId == android.R.id.home) {
            finish();
        } else if (itemId == R.id.action_about) {
            intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.action_share) {
            startActivity(Intent.createChooser(new Intent(Intent.ACTION_SEND).setType("text/plain").putExtra(Intent.EXTRA_TEXT, getString(R.string.share_app_text)
                    + " https://play.google.com/store/apps/details?id=" + getString(R.string.app_id)), "Share via"));
            return true;
        } else if (itemId == R.id.action_rate) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getString(R.string.app_id))));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
