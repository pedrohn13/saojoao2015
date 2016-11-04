package br.edu.ufcg.embedded.saojoao.activity.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import br.edu.ufcg.embedded.saojoao.R;

import java.util.List;

import br.edu.ufcg.embedded.saojoao.activity.MainActivity;
import br.edu.ufcg.embedded.saojoao.utils.AtracaoDataListAdapter;
import br.edu.ufcg.embedded.saojoao.utils.AtracoesListItem;

/**
 * Created by Pedro on 03/06/2015.
 */
public class LembretesFragment extends Fragment {

    private static final String APP_NOTIFY_PREFS = "AppSharedPrefsNotify";
    public static final String NOTIFY = "notify";
    private View rootView;
    private ListView lisFavoritos;
    private Switch notificacao;
    private TextView labelNotificacao;
    private SharedPreferences settings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_lembretes, container, false);
        notificacao = (Switch) rootView.findViewById(R.id.switch_notificacao);
        labelNotificacao = (TextView) rootView.findViewById(R.id.text_lembretes_aviso);
        settings = getActivity().getSharedPreferences(APP_NOTIFY_PREFS, 0);
        final SharedPreferences.Editor editor = settings.edit();
        boolean isPrefNotify = settings.getBoolean(NOTIFY, true);
        editor.putBoolean(NOTIFY, isPrefNotify);
        notificacao.setChecked(isPrefNotify);
        if (isPrefNotify) { //LIGA NOTIFICACAO
            labelNotificacao.setText(getString(R.string.notification_on));
        } else { //DESLIGA NOTIFICACAO
            labelNotificacao.setText(getString(R.string.notification_off));
        }

        notificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (notificacao.isChecked()) { //DESLIGA NOTIFICACAO
                    labelNotificacao.setText(getString(R.string.notification_on));
                    editor.putBoolean(NOTIFY, true);
                } else { //LIGA NOTIFICACAO
                    labelNotificacao.setText(getString(R.string.notification_off));
                    editor.putBoolean(NOTIFY, false);
                }
                editor.commit();
            }
        });
        loadList();
        return rootView;
    }

    public void loadList() {
        lisFavoritos = (ListView) rootView.findViewById(R.id.favoritos_list);
        MainActivity activity = (MainActivity) getActivity();
        List<AtracoesListItem> atracoes = activity.getController().getListFavoritosDetalhada();
        if (atracoes.size() > 0) {
            TextView semBandas = (TextView) rootView.findViewById(R.id.sem_bandas_favoritas);
            semBandas.setText("");
        }
        lisFavoritos.setAdapter(new AtracaoDataListAdapter(getActivity(), atracoes));
    }
}
