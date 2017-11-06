package com.example.clicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    ImageButton clickBtn;
    Button resetBtn;
    Button upgradeBtn;
    TextView countTV;
    TextView upgradeCostTV;
    TextView powerTV;
    TextView totalClicksTV;
    int upgradeCount = 1;
    int totalClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickBtn = (ImageButton) findViewById(R.id.click_image_button);
        resetBtn = (Button) findViewById(R.id.reset_button);
        upgradeBtn = (Button) findViewById(R.id.upgrade_button);
        countTV = (TextView) findViewById(R.id.counter);
        upgradeCostTV = (TextView) findViewById(R.id.upgrade_cost_text_view);
        powerTV = (TextView) findViewById(R.id.power_text_view);
        totalClicksTV = (TextView) findViewById(R.id.total_clicks_text_view);

        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countValue = countTV.getText().toString();
                int intCountValue = Integer.parseInt(countValue);
                intCountValue += upgradeCount;
                totalClicks++;
                countTV.setText(String.valueOf(intCountValue));

                totalClicksTV.setText(getString(R.string.total_clicks) + " " + totalClicks);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                countTV.setText(String.valueOf(0));
                upgradeCostTV.setText(String.valueOf(50));
                powerTV.setText(getString(R.string.click_power));
                upgradeCount = 1;
                totalClicks = 0;
                totalClicksTV.setText(getString(R.string.total_clicks) + totalClicks);
            }
        });

        upgradeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countValue = countTV.getText().toString();
                int intCountValue = Integer.parseInt(countValue);
                if (intCountValue >= (50 * upgradeCount)) {
                    countTV.setText(String.valueOf(intCountValue - (50 * upgradeCount)));
                    upgradeCount++;
                    upgradeCostTV.setText(String.valueOf(50 * upgradeCount));
                    powerTV.setText("Сила клика: " + upgradeCount);
                }
            }
        });
    }

}

