package br.edu.ufcg.embedded.saojoao.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import br.edu.ufcg.embedded.saojoao.R;

/**
 * Created by Victor on 5/31/2015.
 */
public class BottomBar extends RelativeLayout {

    public static final String TAG_BOTTOM_BAR = "BottomBar";
    private BottomBarButton bt1;
    private BottomBarButton bt2;
    private BottomBarButton bt3;
    private BottomBarButton bt4;
    private BottomBarButton bt5;
    private int actualOn;

    public BottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.bottom_bar, this);
        bt1 = (BottomBarButton) findViewById(R.id.bt1);
        bt2 = (BottomBarButton) findViewById(R.id.bt2);
        bt3 = (BottomBarButton) findViewById(R.id.bt3);
        bt4 = (BottomBarButton) findViewById(R.id.bt4);
        bt5 = (BottomBarButton) findViewById(R.id.bt5);

        setDefaultValues();

    }

    public void setDefaultValues() {
        actualOn = 1;
        bt1.setImageView(getResources().getDrawable(R.drawable.ic_nav_programming));
        bt2.setImageView(getResources().getDrawable(R.drawable.ic_nav_map));
        bt3.setImageView(getResources().getDrawable(R.drawable.ic_nav_camera));
        bt4.setImageView(getResources().getDrawable(R.drawable.ic_nav_search));
        bt5.setImageView(getResources().getDrawable(R.drawable.ic_nav_alerts));
    }

    public void setBtListeners(OnClickListener listener) {
        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
        bt3.setOnClickListener(listener);
        bt4.setOnClickListener(listener);
        bt5.setOnClickListener(listener);
    }


    public void setSelectedColor(int btNum) {

        bt1.setBackgroundColor(getResources().getColor(R.color.mostarda));
        bt2.setBackgroundColor(getResources().getColor(R.color.mostarda));
        bt3.setBackgroundColor(getResources().getColor(R.color.mostarda));
        bt4.setBackgroundColor(getResources().getColor(R.color.mostarda));
        bt5.setBackgroundColor(getResources().getColor(R.color.mostarda));
        actualOn = btNum;

        switch (btNum) {
            case R.id.bt1:
                bt1.setBackgroundColor(getResources().getColor(R.color.mostarda_escuro));
                break;
            case R.id.bt2:
                bt2.setBackgroundColor(getResources().getColor(R.color.mostarda_escuro));
                break;
            case R.id.bt3:
                bt3.setBackgroundColor(getResources().getColor(R.color.mostarda_escuro));
                break;
            case R.id.bt4:
                bt4.setBackgroundColor(getResources().getColor(R.color.mostarda_escuro));
                break;
            case R.id.bt5:
                bt5.setBackgroundColor(getResources().getColor(R.color.mostarda_escuro));
                break;
            default:
                break;

        }
    }

    public int getActualOn() {
        return actualOn;
    }

}


