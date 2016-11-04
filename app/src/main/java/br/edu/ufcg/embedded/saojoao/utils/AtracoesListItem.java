package br.edu.ufcg.embedded.saojoao.utils;

import java.io.Serializable;

/**
 * Created by projeto-aoc on 02/06/15.
 */
public class AtracoesListItem implements Serializable {

    private String label;
    private String data;

    public AtracoesListItem(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
