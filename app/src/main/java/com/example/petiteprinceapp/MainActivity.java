package com.example.petiteprinceapp;

import static android.app.job.JobInfo.PRIORITY_HIGH;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;


public class MainActivity extends AppCompatActivity {
    private Button btnMorning, btnDay, btnEvening, btnNight;
    private ImageView imgMorning, imgDay, imgEvening, imgNight;
    private ConstraintLayout layoutMorning;

    public static final int notificationMorning = 1;
    public static final int notificationDay = 2;
    public static final int notificationEvening = 3;
    public static final int notificationNight = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMorning = (Button) findViewById(R.id.morningBtn);
        btnDay = (Button) findViewById(R.id.dayBtn);
        btnEvening = (Button) findViewById(R.id.eveningBtn);
        btnNight = (Button) findViewById(R.id.nightBtn);
        imgMorning = (ImageView) findViewById(R.id.imgMorning);
        imgDay = (ImageView) findViewById(R.id.imgDay);
        imgEvening = (ImageView) findViewById(R.id.imgEvening);
        imgNight = (ImageView) findViewById(R.id.imgNight);
        layoutMorning = (androidx.constraintlayout.widget.ConstraintLayout) findViewById(R.id.layoutMorning);
    }


    public void btnMorningClick(View view) {
        layoutMorning.setVisibility(View.VISIBLE);
        imgDay.setVisibility(View.INVISIBLE);
        imgEvening.setVisibility(View.INVISIBLE);
        imgNight.setVisibility(View.INVISIBLE);

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this, "petit_prince_channel")
                        .setSmallIcon(R.drawable.clean)
                        .setContentTitle("Утро")
                        .setContentText("Привести в порядок свою планету")
                        .setAutoCancel(true)
                        .setPriority(PRIORITY_HIGH)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationDay, mBuilder.build());

        Toast morningToast = Toast.makeText(getApplicationContext(),
                "Наступило утро!", Toast.LENGTH_LONG);
        morningToast.setGravity(Gravity.BOTTOM, 0, 0);
        morningToast.show();

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Утро - а значит пора прибраться на планете ")
                .setIcon(R.drawable.sun)
                .setMessage("Не забудьте днем полить розу и захватите ширму!")
                .setCancelable(false)
                .setPositiveButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void btnDayClick(View view) {
        layoutMorning.setVisibility(View.INVISIBLE);
        imgDay.setVisibility(View.VISIBLE);
        imgEvening.setVisibility(View.INVISIBLE);
        imgNight.setVisibility(View.INVISIBLE);

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this, "petit_prince_channel")
                        .setSmallIcon(R.drawable.rose)
                        .setContentTitle("День")
                        .setContentText("Полить розу")
                        .setAutoCancel(true)
                        .setPriority(PRIORITY_HIGH)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationDay, mBuilder.build());

        Toast dayToast = Toast.makeText(getApplicationContext(),
                "Хорошего дня!", Toast.LENGTH_LONG);
        dayToast.setGravity(Gravity.BOTTOM, 0, 0);
        dayToast.show();
    }

    public void btnEveningClick(View view) {
        layoutMorning.setVisibility(View.INVISIBLE);
        imgDay.setVisibility(View.INVISIBLE);
        imgEvening.setVisibility(View.VISIBLE);
        imgNight.setVisibility(View.INVISIBLE);

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this, "petit_prince_channel")
                        .setSmallIcon(R.drawable.cover)
                        .setContentTitle("Вечер")
                        .setContentText("Закрыть розу ширмой")
                        .setAutoCancel(true)
                        .setPriority(PRIORITY_HIGH)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationDay, mBuilder.build());

        Toast eveningToast = Toast.makeText(getApplicationContext(),
                "Доброго вечера!", Toast.LENGTH_LONG);
        eveningToast.setGravity(Gravity.BOTTOM, 0, 0);
        eveningToast.show();
    }

    public void btnNightClick(View view) {
        layoutMorning.setVisibility(View.INVISIBLE);
        imgDay.setVisibility(View.INVISIBLE);
        imgEvening.setVisibility(View.INVISIBLE);
        imgNight.setVisibility(View.VISIBLE);

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this, "petit_prince_channel")
                        .setSmallIcon(R.drawable.sunset)
                        .setContentTitle("Ночь")
                        .setContentText("Полюбоваться закатом")
                        .setAutoCancel(true)
                        .setPriority(PRIORITY_HIGH)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationDay, mBuilder.build());

        Toast nightToast = Toast.makeText(getApplicationContext(),
                "Доброй ночи! Утро вечера мудреннее", Toast.LENGTH_LONG);
        nightToast.setGravity(Gravity.BOTTOM, 0, 0);
        nightToast.show();
    }
}