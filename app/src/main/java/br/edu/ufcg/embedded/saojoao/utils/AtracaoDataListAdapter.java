package br.edu.ufcg.embedded.saojoao.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ufcg.embedded.saojoao.R;
import br.edu.ufcg.embedded.saojoao.controller.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Pedro on 04/06/2015.
 */
public class AtracaoDataListAdapter extends BaseAdapter {

    private static final String TAG = "Atrações List Adapter";
    private Context context;
    private List<AtracoesListItem> data;
    private static LayoutInflater inflater;
    private Controller controller;

    private static final int DIA_UM = 1;
    private static final int DIA_DOIS = 2;
    private static final int DIA_TRES = 3;
    private static final int DIA_QUATRO = 4;
    private static final int DIA_CINCO = 5;
    private static final int DIA_SEIS = 6;
    private static final int DIA_SETE = 7;


    public AtracaoDataListAdapter(Context context, List<AtracoesListItem> atracoes) {
        this.context = context;
        this.data = atracoes;
        setInflater((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        controller = Controller.getInstance(context);
    }

    public static LayoutInflater getInflater() {
        return inflater;
    }

    public static void setInflater(LayoutInflater inflater) {
        AtracaoDataListAdapter.inflater = inflater;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public AtracoesListItem getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = getInflater().inflate(R.layout.atracao_data_list_item, parent, false);
        }
        final AtracoesListItem atracoesListItem = getItem(position);

        final ImageView likeButton = (ImageView) view.findViewById(R.id.like_atracao_button);
        if (controller.checaFavorito(atracoesListItem.getLabel())) {
            likeButton.setImageResource(R.drawable.ic_list_favorite_on);
        } else {
            likeButton.setImageResource(R.drawable.ic_list_favorite_off);
        }
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (controller.checaFavorito(atracoesListItem.getLabel())) {
                    likeButton.setImageResource(R.drawable.ic_list_favorite_off);
                    controller.favoritaAtracao(atracoesListItem.getLabel());
                } else {
                    likeButton.setImageResource(R.drawable.ic_list_favorite_on);
                    controller.favoritaAtracao(atracoesListItem.getLabel());
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                try {
                    Date dataApresentacao = simpleDateFormat.parse(atracoesListItem.getData() + " 23:59:59");
                    Date hoje = new Date();
                    if (dataApresentacao.after(hoje)) {
                        createNotification(atracoesListItem.getData());
                    } else {
                        Toast.makeText(context, context.getString(R.string.ja_se_apresentou),
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (ParseException e) {
                    Log.d(TAG, "Error durante o like: " + e.getMessage());
                }
            }

        });
        TextView atracaoLabel = (TextView) view.findViewById(R.id.atracao_label);
        atracaoLabel.setText(atracoesListItem.getLabel());
        TextView dataLabel = (TextView) view.findViewById(R.id.data_label);
        dataLabel.setText(formatData(atracoesListItem.getData()));

        final ImageView videoButton = (ImageView) view.findViewById(R.id.video_link);



        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String label = atracoesListItem.getLabel().replaceAll(" ", "+");
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/results?search_query=" + label));
                context.startActivity(intent);
            }
        });


        return view;
    }

    private String formatData(String dateLabel) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date day = new Date();
        try {
            day = format.parse(dateLabel);
        } catch (ParseException e) {
            Log.d(TAG, "Error aqo formatar a data: " + e.getMessage());
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String sHoje = format.format(new Date());
        String sDateLabel = format.format(day);
        String weekDay;
        if (sHoje.equals(sDateLabel)) {
            weekDay = context.getString(R.string.hoje);
        } else {
            weekDay = getWeekDay(dayOfWeek);
        }

        return String.format("%s, %s", weekDay, dateLabel);

    }

    private String getWeekDay(int weekDay) {
        switch (weekDay) {
            case DIA_UM:
                return context.getString(R.string.sun);
            case DIA_DOIS:
                return context.getString(R.string.mon);
            case DIA_TRES:
                return context.getString(R.string.tue);
            case DIA_QUATRO:
                return context.getString(R.string.wed);
            case DIA_CINCO:
                return context.getString(R.string.thu);
            case DIA_SEIS:
                return context.getString(R.string.fri);
            case DIA_SETE:
                return context.getString(R.string.sat);
            default:
        }
        return "";
    }

    private void createNotification(String pDate) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(DiaEventoListAdapter.ACTION_ALARM);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        try {
            date = formatter.parse(pDate + " 12:00");
        } catch (ParseException e) {
            Log.d(TAG, "Error ao formatar a data: " + e.getMessage());
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        Log.i("SãoJoão", "Criada notificação para: " + calendar.getTime().toString());
    }

}
