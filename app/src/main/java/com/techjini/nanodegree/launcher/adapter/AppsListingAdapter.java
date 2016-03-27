package com.techjini.nanodegree.launcher.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techjini.nanodegree.launcher.R;
import com.techjini.nanodegree.launcher.databinding.AdapterAppsListingBinding;
import com.techjini.nanodegree.launcher.models.AppsByMeModel;
import com.techjini.nanodegree.launcher.utils.CommonUtils;

import java.util.ArrayList;

/**
 * Created by Sanjeev on 3/27/16.
 */
public class AppsListingAdapter extends RecyclerView.Adapter<AppsListingAdapter.AppsListViewHolder> {
    private final ArrayList<AppsByMeModel> mAppsList;

    public AppsListingAdapter(ArrayList<AppsByMeModel> appList) {
        this.mAppsList = appList;
    }

    @Override
    public AppsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AppsListViewHolder((AdapterAppsListingBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_apps_listing, parent, false));
    }

    @Override
    public void onBindViewHolder(AppsListViewHolder holder, int position) {
        holder.binding.setAppModel(mAppsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mAppsList.size();
    }

    public class AppsListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final AdapterAppsListingBinding binding;

        public AppsListViewHolder(AdapterAppsListingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.setHandler(this);
        }

        @Override
        public void onClick(View view) {
            if (CommonUtils.startAppIfExists(view.getContext(), mAppsList.get(getLayoutPosition()).getPackageName())) {
                CommonUtils.showToast(view.getContext(), String.format(view.getContext().getString(R.string.app_start_message)
                        , mAppsList.get(getLayoutPosition()).getName()));
            } else {
                CommonUtils.showToast(view.getContext(), String.format(view.getContext().getString(R.string.app_failed_message)
                        , mAppsList.get(getLayoutPosition()).getName()));
            }
        }
    }
}
