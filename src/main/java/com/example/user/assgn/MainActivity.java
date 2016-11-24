package com.example.user.assgn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.Adapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
GridView gridView;
  AnimationAdapter adapter;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    gridView = (GridView) findViewById(R.id.gridView);

    adapter = new AnimationAdapter(MainActivity.this);
    gridView.setAdapter(adapter);
    Animation anim = AnimationUtils.loadAnimation(this,R.anim.up);
    GridLayoutAnimationController controller = new GridLayoutAnimationController(anim,0.15f,0.1f);
    gridView.setLayoutAnimation(controller);
    controller.start();
    controller.setRowDelay(1.0f);
  }
}
