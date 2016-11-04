package br.edu.ufcg.embedded.saojoao.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import br.edu.ufcg.embedded.saojoao.R;

/**
 * Created by Victor on 5/31/2015.
 */
public class BottomBarButton extends LinearLayout {

    private ImageView imageView;

    public BottomBarButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.bottom_bar_button, this);
        imageView = (ImageView) findViewById(R.id.image);
    }

    public void setImageView(Drawable image) {
        this.imageView.setImageDrawable(image);
    }
}


