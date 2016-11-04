package br.edu.ufcg.embedded.saojoao.controller;

import android.content.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import br.edu.ufcg.embedded.saojoao.dao.DataSource;
import br.edu.ufcg.embedded.saojoao.utils.AtracoesListItem;

/**
 * Created by Pedro on 27/04/2015.
 */
public final class Controller {

    private static Controller instance;
    private DataSource dataSource;

    private Controller(Context context) {
        dataSource = new DataSource(context);
    }

    public static Controller getInstance(Context context) {
        if (instance == null) {
            instance = new Controller(context);
        }
        return instance;
    }

    public void setBdContext(Context context) {
        dataSource = new DataSource(context);
        openBD();
    }

    public void openBD() {
        dataSource.open();
    }

    public List<String> getEventoDia(Date date) {
        List<String> atracoes = dataSource.getAtracoesDia(date);
        if (atracoes.size() > 0) {
            return atracoes;
        }
        return null;
    }

    public HashMap<String, List<AtracoesListItem>> getMapaEventosAtracoes() {
        HashMap<String, List<AtracoesListItem>> atracoes = dataSource.getMapaEventosAtracoes();
        if (atracoes.size() > 0) {
            return atracoes;
        }
        return null;
    }

    public void favoritaAtracao(String atracao) {
        dataSource.favoritar(atracao);
    }

    public boolean checaFavorito(String atracao) {
        return dataSource.checaFavorito(atracao);
    }

    public List<AtracoesListItem> getListFavoritosDetalhada() {
        return dataSource.getListFavoritosDetalhada();
    }
}
