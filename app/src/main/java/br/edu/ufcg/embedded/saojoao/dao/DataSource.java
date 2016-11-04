package br.edu.ufcg.embedded.saojoao.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.edu.ufcg.embedded.saojoao.utils.AtracoesListItem;

/**
 * Created by Pedro on 18/05/2015.
 */
public class DataSource {

    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public DataSource(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public List<String> getAtracoesDia(Date data) {
        List<String> result = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String timeStamp = dateFormat.format(data);
        Log.i("DBHELPER", "Buscando eventos do dia " + timeStamp);
        String[] nameCollumn = {DbHelper.NOME};
        Cursor cursor = database.query(DbHelper.EVENTO, nameCollumn, "dia='" + timeStamp + "'", null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String atracao = cursor.getString(0);
            result.add(atracao);
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }

    public HashMap<String, List<AtracoesListItem>> getMapaEventosAtracoes() {
        HashMap<String, List<AtracoesListItem>> result = new HashMap<String, List<AtracoesListItem>>();
        String[] nameCollumn = {DbHelper.NOME, DbHelper.DIA};
        Cursor cursor = database.query(DbHelper.EVENTO, nameCollumn, null, null, null, null, null, null);
        cursor.moveToFirst();
        String data = cursor.getString(1);
        List<AtracoesListItem> atracoesListItems = new ArrayList<AtracoesListItem>();
        while (!cursor.isAfterLast()) {
            if (!data.equals(cursor.getString(1))) {
                List<AtracoesListItem> aux = getNewAtracoesListItems();
                for (AtracoesListItem atracoesListItem : atracoesListItems) {
                    aux.add(atracoesListItem);
                }
                result.put(data, aux);
                data = cursor.getString(1);
                atracoesListItems.clear();
            }
            AtracoesListItem newItem = getNewAtracoesListItemZero(cursor);
            newItem.setData(cursor.getString(1));
            atracoesListItems.add(newItem);
            cursor.moveToNext();
        }
        result.put(data, atracoesListItems);
        cursor.close();
        return result;
    }

    private ArrayList<AtracoesListItem> getNewAtracoesListItems() {
        return new ArrayList<AtracoesListItem>();
    }

    private AtracoesListItem getNewAtracoesListItemZero(Cursor cursor) {
        return new AtracoesListItem(cursor.getString(0));
    }

    public void favoritar(String atracao) {
        String[] nameCollumn = {DbHelper.FAVORITO};
        Cursor cursor = database.query(DbHelper.EVENTO, nameCollumn, "nome='" + atracao + "'", null, null, null, null, null);
        cursor.moveToFirst();
        int antigoFavorito = cursor.getInt(0);
        cursor.close();


        ContentValues contentValues = new ContentValues();
        if (antigoFavorito == 0) {
            contentValues.put(DbHelper.FAVORITO, 1);
        } else {
            contentValues.put(DbHelper.FAVORITO, 0);
        }


        database.update(DbHelper.EVENTO, contentValues, "nome='" + atracao + "'", null);

    }

    public boolean checaFavorito(String atracao) {
        String[] nameCollumn = {DbHelper.FAVORITO};
        Cursor cursor = database.query(DbHelper.EVENTO, nameCollumn, "nome='" + atracao + "'", null, null, null, null, null);
        cursor.moveToFirst();
        int bookmarked = cursor.getInt(0);
        cursor.close();
        return bookmarked == 1;
    }

    public List<AtracoesListItem> getListFavoritosDetalhada() {
        List<AtracoesListItem> result = new ArrayList<AtracoesListItem>();
        String[] nameCollumn = {DbHelper.NOME, DbHelper.DIA};
        Cursor cursor = database.query(DbHelper.EVENTO, nameCollumn, "favorito=1", null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String atracao = cursor.getString(0);
            String dia = cursor.getString(1);
            AtracoesListItem novo = getNewAtracoesListItem(atracao);
            novo.setData(dia);
            result.add(novo);
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }

    private AtracoesListItem getNewAtracoesListItem(String atracao) {
        return new AtracoesListItem(atracao);
    }
}
