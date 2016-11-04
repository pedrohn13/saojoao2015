package br.edu.ufcg.embedded.saojoao.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.edu.ufcg.embedded.saojoao.R;
import br.edu.ufcg.embedded.saojoao.activity.MainActivity;
import br.edu.ufcg.embedded.saojoao.controller.Controller;

/**
 * Created by Pedro on 02/06/2015.
 */
public class DiaEventoListAdapter extends BaseExpandableListAdapter {

    public static final String ACTION_ALARM = "br.edu.ufcg.embedded.saojoao.utils.AlarmReceiver";
    private static final String TAG = "Dia evento adapter";
    private Context mContext;
    private List<String> mListDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<AtracoesListItem>> mListDataChild;
    private Controller controller;

    public DiaEventoListAdapter(Context context, List<String> listDataHeader,
                                HashMap<String, List<AtracoesListItem>> listChildData) {
        this.mContext = context;
        this.mListDataHeader = listDataHeader;
        this.mListDataChild = listChildData;
        controller = Controller.getInstance(context);
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.mListDataChild.get(this.mListDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final AtracoesListItem child = (AtracoesListItem) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.atracao_list_item, parent, false);
        }
        final ImageView likeButton = (ImageView) convertView.findViewById(R.id.like_atracao_button);
        if (controller.checaFavorito(child.getLabel())) {
            likeButton.setImageResource(R.drawable.ic_list_favorite_on);
        } else {
            likeButton.setImageResource(R.drawable.ic_list_favorite_off);
        }
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (controller.checaFavorito(child.getLabel())) {
                    likeButton.setImageResource(R.drawable.ic_list_favorite_off);
                } else {
                    likeButton.setImageResource(R.drawable.ic_list_favorite_on);
                }
                controller.favoritaAtracao(child.getLabel());
                criaAlarme(child);

            }
        });

        TextView atracaoLabel = (TextView) convertView
                .findViewById(R.id.atracao_label);
        atracaoLabel.setText(child.getLabel());

        final ImageView videoButton = (ImageView) convertView.findViewById(R.id.video_link);
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String label = child.getLabel().replaceAll(" ", "+");
                ((MainActivity) mContext).showVideoDialog("https://www.youtube.com/results?search_query=" + label);

            }
        });

        if (child.getLabel().equals("")) {
            atracaoLabel.setText(mContext.getString(R.string.no_show));
            videoButton.setVisibility(View.INVISIBLE);
            likeButton.setVisibility(View.INVISIBLE);
        } else {
            videoButton.setVisibility(View.VISIBLE);
            likeButton.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    private void criaAlarme(AtracoesListItem child) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            Date dataApresentacao = simpleDateFormat.parse(child.getData() + " 23:59:59");
            Date hoje = new Date();
            if (dataApresentacao.after(hoje)) {
                createNotification(child.getData());
            } else {
                Toast.makeText(mContext, mContext.getString(R.string.ja_se_apresentou),
                        Toast.LENGTH_SHORT).show();
            }
        } catch (ParseException e) {
            Log.d(TAG, "Error ao formatar a data: " + e.getMessage());
        }
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.mListDataChild.get(this.mListDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.mListDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.mListDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.evento_list_item, parent, false);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.date_label);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    private void createNotification(String pDate) {
        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(ACTION_ALARM);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(mContext, 0, intent, 0);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        try {
            date = formatter.parse(pDate + " 12:00");
        } catch (ParseException e) {
            Log.d(TAG, "Error aqo formatar a data: " + e.getMessage());
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);
        Log.i("SãoJoão", "Criada notificação para: " + calendar.getTime().toString());
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
