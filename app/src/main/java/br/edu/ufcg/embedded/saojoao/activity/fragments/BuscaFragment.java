package br.edu.ufcg.embedded.saojoao.activity.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import br.edu.ufcg.embedded.saojoao.R;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.embedded.saojoao.utils.AtracaoDataListAdapter;
import br.edu.ufcg.embedded.saojoao.utils.AtracoesListItem;

public class BuscaFragment extends Fragment {

    private View rootView;
    private ListView mListView;
    private TextView ajuda;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_busca, container, false);
        mListView = (ListView) rootView.findViewById(R.id.busca_list);
        ajuda = (TextView) rootView.findViewById(R.id.texto_ajuda_busca);

        List<String> list = new ArrayList<>();
        mListView.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, list));

        return rootView;
    }

    public void updateList(ArrayList<AtracoesListItem> result, String busca) {
        ajuda.setText("");
        if (result.size() > 0) {
            mListView.setAdapter(new AtracaoDataListAdapter(getActivity(), result));
        } else {
            ajuda.setText(getString(R.string.nenhum_resultado));
            List<String> list = new ArrayList<>();
            mListView.setAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, list));
            if (busca.equals("")) {
                ajuda.setText(getString(R.string.ajuda_busca));
            }
        }
    }

}
