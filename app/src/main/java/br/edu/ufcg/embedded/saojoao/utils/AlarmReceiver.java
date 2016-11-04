package br.edu.ufcg.embedded.saojoao.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import br.edu.ufcg.embedded.saojoao.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.edu.ufcg.embedded.saojoao.activity.MainActivity;
import br.edu.ufcg.embedded.saojoao.controller.Controller;

/**
 * Created by Pedro on 05/06/2015.
 */
public class AlarmReceiver extends BroadcastReceiver {
    private static final String APP_NOTIFY_PREFS = "AppSharedPrefsNotify";
    private static final String TAG = "Alarme Receiver";
    private SharedPreferences settings;
    public static final String NOTIFY = "notify";
    private Context mContext;
    private Controller controller;
    private List<String> atracoes;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(DiaEventoListAdapter.ACTION_ALARM)) {
            this.mContext = context;
            this.controller = Controller.getInstance(mContext);
            controller.setBdContext(mContext);
            settings = mContext.getSharedPreferences(APP_NOTIFY_PREFS, 0);
            boolean isPrefNotify = settings.getBoolean(NOTIFY, true);
            if (isPrefNotify) {
                checaFavoritos();
            }
        }
    }

    private void checaFavoritos() {
        Date data = new Date();
        data.setTime(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(data);
        try {
            atracoes = controller.getEventoDia(formatter.parse(date));
        } catch (ParseException e) {
            Log.d(TAG, "Error in Alarm: " + e.getMessage());
        }
        buildTextNotification();
    }

    private void buildTextNotification() {
        String bandas = "";
        int count = 0;
        for (String atracao : atracoes) {
            if (controller.checaFavorito(atracao)) {
                count++;
                bandas = bandas.concat(String.format("- %s\n", atracao));
            }
        }
        String prefixo = mContext.getString(R.string.present_today_single) + ":\n";
        if (count > 1) {
            prefixo = mContext.getString(R.string.present_today_plural) + ":\n";
        }
        if (count > 0) {
            launchNotification(prefixo.concat(bandas));
        }
    }

    private void launchNotification(String atracao) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(mContext)
                        .setSmallIcon(R.drawable.laucher)
                        .setContentTitle(mContext.getString(R.string.its_today))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(atracao))
                        .setContentText(atracao);
        Intent resultIntent = new Intent(mContext, MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(mContext);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) mContext.getSystemService(mContext.NOTIFICATION_SERVICE);
        int mId = 1;
        mNotificationManager.notify(mId, mBuilder.build());
    }
}
