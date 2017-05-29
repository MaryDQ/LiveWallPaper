package com.phone.livewallpaper;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheckBox= (CheckBox) findViewById(R.id.checkBox1);

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    VideoLiveWallpaper.voiceSilence(getApplicationContext());
                }else{
                    VideoLiveWallpaper.voiceNormal(getApplicationContext());
                }
            }
        });
    }

    public static void setToWallPaper(Context context){
        final Intent intent=new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(context,VideoLiveWallpaper.class));
        context.startActivity(intent);
    }
}
