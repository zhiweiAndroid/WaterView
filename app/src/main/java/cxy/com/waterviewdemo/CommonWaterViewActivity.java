package cxy.com.waterviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import cxy.com.waterviewlib.WaterView;

public class CommonWaterViewActivity extends AppCompatActivity implements View.OnClickListener {

    private WaterView waterView;
    private Button btn_start;
    private Button btn_reset;
    private Button btn_stop;
    private Button btn_recover;
    private Button btn_keep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_water_view);
        initViw();

        waterView.setListener(new WaterView.Listener() {
            @Override
            public void finish() {
                Toast.makeText(CommonWaterViewActivity.this, "已经满了！！！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViw() {

        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_recover = (Button) findViewById(R.id.btn_recover);
        btn_keep= (Button) findViewById(R.id.btn_keep);
        btn_reset.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_recover.setOnClickListener(this);
        btn_keep.setOnClickListener(this);
        waterView = (WaterView) findViewById(R.id.waterview);

    }

    @Override
    protected void onResume() {
        super.onResume();
        waterView.postDelayed(new Runnable() {
            @Override
            public void run() {
                waterView.start();
            }
        },500);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                waterView.start();
                break;
            case R.id.btn_recover:
                waterView.recover();
                break;
            case R.id.btn_stop:
               // waterView.stop();
                startActivity(new Intent(this,Main2Activity.class));
                break;
            case R.id.btn_reset:
                waterView.reset();
                break;
            case R.id.btn_keep:
                waterView.keepHeight();
                break;
        }
    }

}
