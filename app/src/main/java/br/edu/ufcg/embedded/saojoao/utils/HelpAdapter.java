package br.edu.ufcg.embedded.saojoao.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.ufcg.embedded.saojoao.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Lucas on 10/06/2015.
 */
public class HelpAdapter extends BaseExpandableListAdapter {

    private static final int ZERO = 0;
    private static final int UM_HELP = 1;
    private static final int DOIS = 2;
    private static final int TRES = 3;
    private static final int QUATRO = 4;
    private static final int CINCO = 5;
    private static final int SEIS = 6;
    private static final int SETE = 7;
    private static final int OITO = 8;
    private static final int NOVE = 9;
    private static final int DEZ = 10;


    private Context mContext;
    private List<String> mListDataHeader; // header titles
    private HashMap<String, List<AjudaListItem>> mListDataChild;

    public HelpAdapter(Context mContext, List<String> mListDataHeader, HashMap<String, List<AjudaListItem>> mListDataChild) {
        this.mContext = mContext;
        this.mListDataHeader = mListDataHeader;
        this.mListDataChild = mListDataChild;
    }

    @Override
    public int getGroupCount() {
        return this.mListDataHeader.size();
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
    public Object getChild(int groupPosition, int child) {
        return this.mListDataChild.get(this.mListDataHeader.get(groupPosition)).get(child);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.ajuda_list_item, parent, false);
        }
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.ajuda_label);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ajuda_image);
        lblListHeader.setText(headerTitle);
        imageView.setImageResource(getResource(groupPosition));
        return convertView;
    }

    private int getResource(int groupPosition) {
        switch (groupPosition) {
            case ZERO:
                return R.drawable.ic_nav_programming;
            case UM_HELP:
                return R.drawable.ic_list_favorite_off;
            case DOIS:
                return R.drawable.ic_list_video_collection;
            case TRES:
                return R.drawable.ic_nav_map;
            case QUATRO:
                return R.drawable.ic_menu_locations;
            case CINCO:
                return R.drawable.ic_nav_camera;
            case SEIS:
                return R.drawable.ic_capture_cam1_help;
            case SETE:
                return R.drawable.ic_capture_cam2_help;
            case OITO:
                return R.drawable.ic_campture_download;
            case NOVE:
                return R.drawable.ic_nav_search;
            case DEZ:
                return R.drawable.ic_nav_alerts;
            default:
                return 0;
        }

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final AjudaListItem child = (AjudaListItem) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.ajuda_down_list_item, parent, false);
        }
        TextView ajudaDownLabel = (TextView) convertView
                .findViewById(R.id.ajuda_down_label);
        ajudaDownLabel.setText(child.getLabel());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
