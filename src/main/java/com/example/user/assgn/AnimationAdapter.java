package com.example.user.assgn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by USER on 11/24/2016.
 */

public class AnimationAdapter extends BaseAdapter{

  MainActivity mainActivity;
  GridView gridid;
  ImageView imageView;
  public AnimationAdapter(MainActivity activity) {

    this.mainActivity = (MainActivity) activity;
  }


  @Override
  public int getCount() {
    return 21;
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
    LayoutInflater inflater = mainActivity.getLayoutInflater();
    if (view == null) {
      view = inflater.inflate(R.layout.icons, null);
      imageView = (ImageView) view.findViewById(R.id.view);
      gridid = (GridView) view.findViewById(R.id.gridView);
      imageView.setImageResource(R.drawable.ic_launcher);
      Animation anim = AnimationUtils.loadAnimation(mainActivity, R.anim.up);
      imageView.startAnimation(anim);
    }
    return view;
  }
}
