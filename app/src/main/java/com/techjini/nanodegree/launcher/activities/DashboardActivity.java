package com.techjini.nanodegree.launcher.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.techjini.nanodegree.launcher.R;
import com.techjini.nanodegree.launcher.adapter.AppsListingAdapter;
import com.techjini.nanodegree.launcher.databinding.ActivityDashboardBinding;
import com.techjini.nanodegree.launcher.models.AppsByMeModel;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDashboardBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        initialize(binding);
        fillData(binding);
    }

    /**
     * Fill data in layout
     *
     * @param binding: Layout binding
     */
    private void fillData(ActivityDashboardBinding binding) {
        ArrayList<AppsByMeModel> appList = new ArrayList<>();
        fillAppsList(appList);
        binding.appList.setAdapter(new AppsListingAdapter(appList));
    }

    /**
     * Fills list of app by me
     *
     * @param appList: list to fill
     */
    private void fillAppsList(ArrayList<AppsByMeModel> appList) {
        appList.add(new AppsByMeModel("Spotify Streamer", "com.techjini.nanodegree.spotify", "S"));
        appList.add(new AppsByMeModel("Football Score", "com.techjini.nanodegree.football.score", "F"));
        appList.add(new AppsByMeModel("Football Score Library", "com.techjini.nanodegree.football.score.sdk", "L"));
        appList.add(new AppsByMeModel("Build It Bigger", "com.techjini.nanodegree.bigger", "B"));
        appList.add(new AppsByMeModel("XYZ Reader", "com.techjini.nanodegree.reader", "R"));
        appList.add(new AppsByMeModel("Capstone", "com.techjini.nanodegree.capstone", "C"));
    }

    /**
     * initializes layout views
     *
     * @param binding: Layout binding
     */
    private void initialize(ActivityDashboardBinding binding) {
        setTitle("Apps in NanoDegree");
        binding.appList.setLayoutManager(new LinearLayoutManager(this));
    }
}
