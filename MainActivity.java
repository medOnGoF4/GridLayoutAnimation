package com.teclever.test.grid_slides;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity extends AppCompatActivity {

    public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String CAMERA = "android.permission.CAMERA";
    public static final String BLUETOOTH = "android.permission.BLUETOOTH";
    public static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    private static final int PERMISSION_REQUEST_CODE = 200;

    GridView grid;

    String[] str = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"};
    MyAnimationAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        grid = (GridView) findViewById(R.id.gridView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            requestPermission();


        adapter = new MyAnimationAdapter(MainActivity.this, str);
        grid.setAdapter(adapter);


            Animation anim = AnimationUtils.loadAnimation(this,R.anim.anim_slide);
            GridLayoutAnimationController controller = new GridLayoutAnimationController(anim,0.1f,0.1f);
            grid.setLayoutAnimation(controller);
            controller.start();
            controller.setRowDelay(1.0f);


        }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA, WRITE_EXTERNAL_STORAGE, BLUETOOTH, READ_PHONE_STATE},
                PERMISSION_REQUEST_CODE);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {

                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storage = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean blutooth = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                    boolean telecom = grantResults[3] == PackageManager.PERMISSION_GRANTED;

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(CAMERA) || shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)
                                || shouldShowRequestPermissionRationale(BLUETOOTH)
                                || shouldShowRequestPermissionRationale(READ_PHONE_STATE)) {

                            showDailogForUser("You need to allow access to all the permissions");

                            return;
                        }
                    } else {
                        boolean permissionsGiven = true;
                    }
                }

                break;
        }
    }

    private void showDailogForUser(String s) {

        final AlertDialog.Builder myDialog = new AlertDialog.Builder(
                MainActivity.this);
        myDialog.setTitle("Alert");
        myDialog.setMessage("msg");
        myDialog.setCancelable(false);
        myDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{CAMERA, WRITE_EXTERNAL_STORAGE},
                            PERMISSION_REQUEST_CODE);
                }

            }
        });
        myDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

                finish();

            }
        });

        myDialog.show();

    }
}
