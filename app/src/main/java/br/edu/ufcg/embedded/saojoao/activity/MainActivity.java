package br.edu.ufcg.embedded.saojoao.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ufcg.embedded.saojoao.R;
import br.edu.ufcg.embedded.saojoao.activity.fragments.BuscaFragment;
import br.edu.ufcg.embedded.saojoao.activity.fragments.HomeFragment;
import br.edu.ufcg.embedded.saojoao.activity.fragments.LembretesFragment;
import br.edu.ufcg.embedded.saojoao.activity.fragments.MapDialogFragment;
import br.edu.ufcg.embedded.saojoao.activity.fragments.MapsFragment;
import br.edu.ufcg.embedded.saojoao.activity.fragments.VideoDialogFragment;
import br.edu.ufcg.embedded.saojoao.controller.Controller;
import br.edu.ufcg.embedded.saojoao.model.BottomBar;
import br.edu.ufcg.embedded.saojoao.utils.AtracoesListItem;
import br.edu.ufcg.embedded.saojoao.utils.DiaEventoListAdapter;

import static android.view.View.OnClickListener;

public class MainActivity extends BaseActivity {

    public static final String HOME_TAG = "HOME";
    public static final String BUSCA_TAG = "BUSCA_TAG";
    public static final String MAP_TAG = "MAP_TAG";
    public static final String LEMBRETES_TAG = "LEMBRETES_TAG";
    private BottomBar bottomBar;
    private Controller controller;
    private MapDialogFragment dialogFragment;
    private Menu menu;
    private static TextView mToast;

    private Fragment currentFragment;
    private HomeFragment homeFragment;
    private MapsFragment mapsFragment;
    private BuscaFragment buscaFragment;
    private LembretesFragment lembretesFragment;

    private static final int PROGRAMACAO = R.id.bt1;
    private static final int MAPA = R.id.bt2;
    private static final int CAMERA = R.id.bt3;
    private static final int PESQUISA = R.id.bt4;
    private static final int FAVORITOS = R.id.bt5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBar(getString(R.string.programacao) + " 2015");
        bottomBar = (BottomBar) findViewById(R.id.bottonBar);
        controller = Controller.getInstance(getApplicationContext());
        controller.setBdContext(getApplicationContext());
        setUpFragments();

        bottomBar.setSelectedColor(PROGRAMACAO);
        bottomBar.setBtListeners(onBottomBarClick);

        criaNotificacaoFavoritos();
    }

    private void setUpFragments() {
        homeFragment = new HomeFragment();
        mapsFragment = new MapsFragment();
        buscaFragment = new BuscaFragment();
        lembretesFragment = new LembretesFragment();
        currentFragment = homeFragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, homeFragment, HOME_TAG);
        fragmentTransaction.commit();
    }

    private void handleQuery(String string) {
        String query = removerAcentos(string);
        ArrayList<AtracoesListItem> result = new ArrayList<AtracoesListItem>();
        HashMap<String, List<AtracoesListItem>> listHashMap = getController().getMapaEventosAtracoes();
        if (!string.equals("")) {
            for (Map.Entry<String, List<AtracoesListItem>> entry : listHashMap.entrySet()) {
                List<AtracoesListItem> list = entry.getValue();
                for (AtracoesListItem item : list) {
                    String label = removerAcentos(item.getLabel().toLowerCase());
                    if (label.contains(query.toLowerCase())) {
                        result.add(item);
                    }
                }
            }
        }
        buscaFragment.updateList(result, string);
    }

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        dialogFragment = new MapDialogFragment();
        Log.i("--SAOJOAO", currentFragment + " < ");
        if (bottomBar.getActualOn() == CAMERA) {
            goToFragment(PROGRAMACAO);
        } else {
            goToFragment(bottomBar.getActualOn());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        getSupportFragmentManager().beginTransaction().hide(currentFragment).commit();
        setUpFragments();
    }

    private OnClickListener onBottomBarClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            goToFragment(view.getId());

        }

    };

    private void goToFragment(int viewId) {
        bottomBar.setSelectedColor(viewId);
        hideIcons();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (viewId) {
            case PROGRAMACAO:
                getSupportActionBar().setTitle(getString(R.string.programacao) + " 2015");
                if (!fragmentManager.findFragmentByTag(HOME_TAG).isVisible()) {
                    fragmentTransaction.hide(currentFragment).show(homeFragment).commit();
                    homeFragment.loadList();
                }
                currentFragment = homeFragment;
                break;
            case MAPA:
                menu.findItem(R.id.action_location).setVisible(true);
                getSupportActionBar().setTitle(getString(R.string.title_activity_map));
                if (fragmentManager.findFragmentByTag(MAP_TAG) == null) {
                    fragmentTransaction.hide(currentFragment);
                    fragmentTransaction.add(R.id.fragment_container, mapsFragment, MAP_TAG);
                    fragmentTransaction.show(mapsFragment).commit();
                } else if (!fragmentManager.findFragmentByTag(MAP_TAG).isVisible()) {
                    fragmentTransaction.hide(currentFragment).show(mapsFragment).commit();
                }
                currentFragment = mapsFragment;
                dialogFragment.setMapsFragment((MapsFragment) currentFragment);
                break;
            case CAMERA:

                setToast((TextView) findViewById(R.id.toastText));
                getToast().setText(getString(R.string.loading_camera));
                getToast().setVisibility(View.VISIBLE);

                getSupportActionBar().setTitle(getString(R.string.title_activity_camera));
                Intent mIntent = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(mIntent);
                break;
            case PESQUISA:
                getSupportActionBar().setTitle(getString(R.string.title_activity_search));
                MenuItem search = menu.findItem(R.id.action_search);
                search.setVisible(true);
                search.expandActionView();
                createSearchView();
                if (fragmentManager.findFragmentByTag(BUSCA_TAG) == null) {
                    fragmentTransaction.hide(currentFragment);
                    fragmentTransaction.add(R.id.fragment_container, buscaFragment, BUSCA_TAG);
                    fragmentTransaction.show(buscaFragment).commit();
                } else if (!fragmentManager.findFragmentByTag(BUSCA_TAG).isVisible()) {
                    fragmentTransaction.hide(currentFragment).show(buscaFragment).commit();
                }
                currentFragment = buscaFragment;
                break;
            case FAVORITOS:
                getSupportActionBar().setTitle(getString(R.string.title_activity_lembretes));
                if (fragmentManager.findFragmentByTag(LEMBRETES_TAG) == null) {
                    fragmentTransaction.hide(currentFragment);
                    fragmentTransaction.add(R.id.fragment_container, lembretesFragment, LEMBRETES_TAG);
                    fragmentTransaction.show(lembretesFragment).commit();
                } else if (!fragmentManager.findFragmentByTag(LEMBRETES_TAG).isVisible()) {
                    fragmentTransaction.hide(currentFragment).show(lembretesFragment).commit();
                    lembretesFragment.loadList();
                }else {
                    lembretesFragment.loadList();
                }
                currentFragment = lembretesFragment;
                break;
            default:
                break;

        }
    }

    private void hideIcons() {
        if (menu != null) {
            //points.setVisibility(View.GONE);
            //  try {
            MenuItem location = menu.findItem(R.id.action_location);
            location.setVisible(false);

            MenuItem search = menu.findItem(R.id.action_search);
            search.setVisible(false);
            search.collapseActionView();
            // } catch (NullPointerException e) {

        }


    }

    public Controller getController() {
        return controller;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menuAux) {
        getMenuInflater().inflate(R.menu.menu_main, menuAux);
        this.menu = menuAux;
        //hideIcons();
        // Associate searchable configuration with the SearchView
        if (MAPA == bottomBar.getActualOn()) {
            menu.findItem(R.id.action_location).setVisible(true);
        }
        return true;
    }

    private void createSearchView() {
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        /*
        searchView.setOnSearchClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchView.getQuery().toString();
                handleQuery(query);
            }
        });*/
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String string) {
                handleQuery(string);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String string) {

                handleQuery(string);

                return true;
            }
        });
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        Intent intent;
        if (itemId == R.id.action_about) {
            intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.action_help) {
            intent = new Intent(getApplicationContext(), HelpActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.action_share) {
            startActivity(Intent.createChooser(new Intent(Intent.ACTION_SEND).setType("text/plain").putExtra(Intent.EXTRA_TEXT, getString(R.string.share_app_text)
                    + " https://play.google.com/store/apps/details?id=" + getString(R.string.app_id)), "Share via"));
            return true;
        } else if (itemId == R.id.action_rate) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getString(R.string.app_id))));
            return true;
        } else if (itemId == R.id.action_location) {
            if (!dialogFragment.isVisible()) {
                dialogFragment.show(getFragmentManager(), "Pinpoint Menu");
            } else {
                dialogFragment.dismiss();
            }
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        switch (bottomBar.getActualOn()) {
            case PROGRAMACAO:
                super.onBackPressed();
                break;
            case MAPA:
                MapsFragment mapsFragmentAux = (MapsFragment) getSupportFragmentManager().findFragmentByTag(MAP_TAG);
                if (!mapsFragmentAux.isGoingToHome()) {
                    mapsFragmentAux.backPressed();
                } else {
                    goToFragment(PROGRAMACAO);
                }
                break;
            case CAMERA:
                goToFragment(PROGRAMACAO);
                break;
            case PESQUISA:
                goToFragment(PROGRAMACAO);
                break;
            case FAVORITOS:
                goToFragment(PROGRAMACAO);
                break;
            default:
                break;

        }
    }

    private void criaNotificacaoFavoritos() {
        List<AtracoesListItem> favoritos = controller.getListFavoritosDetalhada();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for (AtracoesListItem atracao : favoritos) {
            try {
                Date dataApresentacao = simpleDateFormat.parse(atracao.getData() + " 23:59:59");
                Date hoje = new Date();
                if (dataApresentacao.after(hoje)) {
                    createNotification(atracao.getData());
                }
            } catch (ParseException e) {
                Log.d("SaoJoao", "Parse Data Error na MainActivity");
            }

        }
    }

    private void createNotification(String pDate) {
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(DiaEventoListAdapter.ACTION_ALARM);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        try {
            date = formatter.parse(pDate + " 12:00");
        } catch (ParseException e) {
            Log.d("SaoJoao", "Error ao formatar a data: " + e.getMessage());
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        Log.i("SãoJoão2015", "Criada notificação para: " + calendar.getTime().toString());
    }

    public void setToast(TextView toast) {
        mToast = toast;
    }

    public static TextView getToast() {
        return mToast;
    }

    public void showVideoDialog(String url) {
        VideoDialogFragment dialogFragment = new VideoDialogFragment();
        dialogFragment.setUrl(url);
        dialogFragment.show(getFragmentManager(), "Youtube Video");
    }
}
