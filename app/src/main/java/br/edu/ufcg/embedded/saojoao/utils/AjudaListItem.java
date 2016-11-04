package br.edu.ufcg.embedded.saojoao.utils;

import java.io.Serializable;

/**
 * Created by Lucas on 10/06/2015.
 */
public class AjudaListItem implements Serializable {

    private String label;
    private String data;

    public AjudaListItem(String label) {
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
