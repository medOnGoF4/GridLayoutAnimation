package com.teclever.test.grid_slides;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by teclever on 24/11/16.
 */
public class MyAnimationAdapter extends BaseAdapter {
    String[] str;
    Activity activity;
    GridView gridid;
    TextView animtext;

    public MyAnimationAdapter(MainActivity activity, String[] str) {

        this.activity = (Activity) activity;
        this.str = str;
    }


    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater = activity.getLayoutInflater();
        ;
        if (view == null) {
            view = inflater.inflate(R.layout.icons, null);
            animtext = (TextView) view.findViewById(R.id.animtext);
            gridid = (GridView) view.findViewById(R.id.gridView);

            animtext.setText(str[i]);

            Animation anim = AnimationUtils.loadAnimation(activity, R.anim.anim_slide);
            animtext.startAnimation(anim);
//            GridLayoutAnimationController obj=new GridLayoutAnimationController(anim,0f,0.1f);
//            obj.setColumnDelay(200);
//


        }
        return view;
    }
}

