package com.example.asus.myyouku;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import Utils.AnimationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout rl_level1;
    private RelativeLayout rl_level2;
    private RelativeLayout rl_level3;
    boolean isLevel3Display = true;
    boolean isLevel2Display = true;
    boolean isLevel1Display = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.bt_menu).setOnClickListener(this);
        findViewById(R.id.bt_home).setOnClickListener(this);
        rl_level1 = (RelativeLayout) findViewById(R.id.rl_level1);
        rl_level2 = (RelativeLayout) findViewById(R.id.rl_level2);
        rl_level3 = (RelativeLayout) findViewById(R.id.rl_level3);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(isLevel1Display){
                AnimationUtils.rotaOutAnimation(rl_level1);
                isLevel1Display = !isLevel1Display;
                if(isLevel2Display){
                    AnimationUtils.rotaOutAnimation(rl_level2);
                    isLevel2Display = !isLevel2Display;
                    if(isLevel3Display){
                        AnimationUtils.rotaOutAnimation(rl_level3);
                        isLevel3Display = !isLevel3Display;
                    }
                }
            }else{
                AnimationUtils.rotaIntAnimation(rl_level1);
                isLevel1Display = true;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt_home:
                if(isLevel2Display &&isLevel3Display){
                    AnimationUtils.rotaOutAnimation(rl_level2);
                    AnimationUtils.rotaOutAnimation(rl_level3);
                    isLevel2Display = !isLevel2Display;
                    isLevel3Display = !isLevel3Display;

                }else if(isLevel2Display){
                    AnimationUtils.rotaOutAnimation(rl_level2);
                    isLevel2Display = !isLevel2Display;
                }
                else{
                    AnimationUtils.rotaIntAnimation(rl_level2);
                    isLevel2Display = true;
                }

                break;
            case  R.id.bt_menu:
                Log.e("tag", "被点击了" );
                    if(isLevel3Display){
                        //没翻转，进入翻转界面
                        AnimationUtils.rotaOutAnimation(rl_level3);
                        isLevel3Display = false;
                    }else{
                        //翻转回来
                        AnimationUtils.rotaIntAnimation(rl_level3);
                        isLevel3Display = true;
                    }
                break;
            default:
                break;
        }
    }
}
