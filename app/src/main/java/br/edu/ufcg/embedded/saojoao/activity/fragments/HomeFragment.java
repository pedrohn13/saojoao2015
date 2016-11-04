package br.edu.ufcg.embedded.saojoao.activity.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import br.edu.ufcg.embedded.saojoao.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.edu.ufcg.embedded.saojoao.activity.MainActivity;
import br.edu.ufcg.embedded.saojoao.dao.DbHelper;
import br.edu.ufcg.embedded.saojoao.utils.AtracoesListItem;
import br.edu.ufcg.embedded.saojoao.utils.DiaEventoListAdapter;

/**
 * Created by Pedro on 02/06/2015.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "Home Fragment";
    private ExpandableListView listview;
    private List<String> listDataHeader;
    private HashMap<String, List<AtracoesListItem>> listDataChild;

    private static final int DIA_UM = 1;
    private static final int DIA_DOIS = 2;
    private static final int DIA_TRES = 3;
    private static final int DIA_QUATRO = 4;
    private static final int DIA_CINCO = 5;
    private static final int DIA_SEIS = 6;
    private static final int DIA_SETE = 7;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_programacao, container, false);
        listview = (ExpandableListView) view.findViewById(R.id.eventos_list);
        loadList();
        return view;
    }

    public void loadList() {
        prepareListData();
        listview.setAdapter(new DiaEventoListAdapter(getActivity(), listDataHeader, listDataChild));
        int todayPosition = getTodayPosition();
        if (todayPosition >= 0) {
            listview.setSelection(todayPosition);
            listview.expandGroup(todayPosition);
        }
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<AtracoesListItem>>();
        HashMap<String, List<AtracoesListItem>> aux =
                ((MainActivity) getActivity()).getController().getMapaEventosAtracoes();

        listDataHeader.add(formatData(DbHelper.CINCO_JUN));
        listDataChild.put(formatData(DbHelper.CINCO_JUN), aux.get(DbHelper.CINCO_JUN));
        listDataHeader.add(formatData(DbHelper.SEIS_JUN));
        listDataChild.put(formatData(DbHelper.SEIS_JUN), aux.get(DbHelper.SEIS_JUN));
        listDataHeader.add(formatData(DbHelper.SETE_JUN));
        listDataChild.put(formatData(DbHelper.SETE_JUN), aux.get(DbHelper.SETE_JUN));
        listDataHeader.add(formatData(DbHelper.OITO_JUN));
        listDataChild.put(formatData(DbHelper.OITO_JUN), aux.get(DbHelper.OITO_JUN));
        listDataHeader.add(formatData(DbHelper.NOVE_JUN));
        listDataChild.put(formatData(DbHelper.NOVE_JUN), aux.get(DbHelper.NOVE_JUN));
        listDataHeader.add(formatData(DbHelper.DEZ_JUN));
        listDataChild.put(formatData(DbHelper.DEZ_JUN), aux.get(DbHelper.DEZ_JUN));
        listDataHeader.add(formatData(DbHelper.ONZE_JUN));
        listDataChild.put(formatData(DbHelper.ONZE_JUN), aux.get(DbHelper.ONZE_JUN));
        listDataHeader.add(formatData(DbHelper.DOZE_JUN));
        listDataChild.put(formatData(DbHelper.DOZE_JUN), aux.get(DbHelper.DOZE_JUN));
        listDataHeader.add(formatData(DbHelper.TREZE_JUN));
        listDataChild.put(formatData(DbHelper.TREZE_JUN), aux.get(DbHelper.TREZE_JUN));
        listDataHeader.add(formatData(DbHelper.QUATORZE_JUN));
        listDataChild.put(formatData(DbHelper.QUATORZE_JUN), aux.get(DbHelper.QUATORZE_JUN));
        listDataHeader.add(formatData(DbHelper.QUINZE_JUN));
        listDataChild.put(formatData(DbHelper.QUINZE_JUN), aux.get(DbHelper.QUINZE_JUN));
        listDataHeader.add(formatData(DbHelper.DEZESEIS_JUN));
        listDataChild.put(formatData(DbHelper.DEZESEIS_JUN), aux.get(DbHelper.DEZESEIS_JUN));
        listDataHeader.add(formatData(DbHelper.DEZESSETE_JUN));
        listDataChild.put(formatData(DbHelper.DEZESSETE_JUN), aux.get(DbHelper.DEZESSETE_JUN));
        listDataHeader.add(formatData(DbHelper.DEZOITO_JUN));
        listDataChild.put(formatData(DbHelper.DEZOITO_JUN), aux.get(DbHelper.DEZOITO_JUN));
        listDataHeader.add(formatData(DbHelper.DEZENOVE_JUN));
        listDataChild.put(formatData(DbHelper.DEZENOVE_JUN), aux.get(DbHelper.DEZENOVE_JUN));
        listDataHeader.add(formatData(DbHelper.VINTE_JUN));
        listDataChild.put(formatData(DbHelper.VINTE_JUN), aux.get(DbHelper.VINTE_JUN));
        listDataHeader.add(formatData(DbHelper.VINTE_UM_JUN));
        listDataChild.put(formatData(DbHelper.VINTE_UM_JUN), aux.get(DbHelper.VINTE_UM_JUN));
        listDataHeader.add(formatData(DbHelper.VINTE_DOIS_JUN));
        listDataChild.put(formatData(DbHelper.VINTE_DOIS_JUN), aux.get(DbHelper.VINTE_DOIS_JUN));
        listDataHeader.add(formatData(DbHelper.VINTE_TRES_JUN));
        listDataChild.put(formatData(DbHelper.VINTE_TRES_JUN), aux.get(DbHelper.VINTE_TRES_JUN));
        listDataHeader.add(formatData(DbHelper.VINTE_QUATRO_JUN));
        listDataChild.put(formatData(DbHelper.VINTE_QUATRO_JUN), aux.get(DbHelper.VINTE_QUATRO_JUN));
        listDataHeader.add(formatData(DbHelper.VINTE_CINCO_JUN));
        listDataChild.put(formatData(DbHelper.VINTE_CINCO_JUN), aux.get(DbHelper.VINTE_CINCO_JUN));
        listDataHeader.add(formatData(DbHelper.VINTE_SEIS_JUN));
        listDataChild.put(formatData(DbHelper.VINTE_SEIS_JUN), aux.get(DbHelper.VINTE_SEIS_JUN));
        listDataHeader.add(formatData(DbHelper.VINTE_SETE_JUN));
        listDataChild.put(formatData(DbHelper.VINTE_SETE_JUN), aux.get(DbHelper.VINTE_SETE_JUN));
        listDataHeader.add(formatData(DbHelper.VINTE_OITO_JUN));
        listDataChild.put(formatData(DbHelper.VINTE_OITO_JUN), aux.get(DbHelper.VINTE_OITO_JUN));
        listDataHeader.add(formatData(DbHelper.VINTE_NOVE_JUN));
        listDataChild.put(formatData(DbHelper.VINTE_NOVE_JUN), aux.get(DbHelper.VINTE_NOVE_JUN));
        listDataHeader.add(formatData(DbHelper.TRINTA_JUN));
        listDataChild.put(formatData(DbHelper.TRINTA_JUN), aux.get(DbHelper.TRINTA_JUN));
        listDataHeader.add(formatData(DbHelper.UM_JUL));
        listDataChild.put(formatData(DbHelper.UM_JUL), aux.get(DbHelper.UM_JUL));
        listDataHeader.add(formatData(DbHelper.DOIS_JUL));
        listDataChild.put(formatData(DbHelper.DOIS_JUL), aux.get(DbHelper.DOIS_JUL));
        listDataHeader.add(formatData(DbHelper.TRES_JUL));
        listDataChild.put(formatData(DbHelper.TRES_JUL), aux.get(DbHelper.TRES_JUL));
        listDataHeader.add(formatData(DbHelper.QUATRO_JUL));
        listDataChild.put(formatData(DbHelper.QUATRO_JUL), aux.get(DbHelper.QUATRO_JUL));
        listDataHeader.add(formatData(DbHelper.CINCO_JUL));
        listDataChild.put(formatData(DbHelper.CINCO_JUL), aux.get(DbHelper.CINCO_JUL));


    }

    private int getTodayPosition() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        return listDataHeader.indexOf(formatData(simpleDateFormat.format(today)));
    }

    private String formatData(String dateLabel) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date day = new Date();
        try {
            day = format.parse(dateLabel);
        } catch (ParseException e) {
            Log.d(TAG,
                    "Error formatting day.");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String sHoje = format.format(new Date());
        String sDateLabel = format.format(day);
        String weekDay;
        if (sHoje.equals(sDateLabel)) {
            weekDay = getString(R.string.hoje);
        } else {
            weekDay = getWeekDay(dayOfWeek);
        }

        return String.format("%s, %s", weekDay, dateLabel);

    }

    private String getWeekDay(int weekDay) {
        switch (weekDay) {
            case DIA_UM:
                return getString(R.string.sun);
            case DIA_DOIS:
                return getString(R.string.mon);
            case DIA_TRES:
                return getString(R.string.tue);
            case DIA_QUATRO:
                return getString(R.string.wed);
            case DIA_CINCO:
                return getString(R.string.thu);
            case DIA_SEIS:
                return getString(R.string.fri);
            case DIA_SETE:
                return getString(R.string.sat);
            default:
        }
        return "";
    }


}
