package com.techjini.nanodegree.launcher.models;

/**
 * Created by Sanjeev on 3/27/16.
 */
public class AppsByMeModel {
    private String name;
    private String packageName;
    private String appIcon;

    public AppsByMeModel(String name, String packageName, String appIcon) {
        this.name = name;
        this.packageName = packageName;
        this.appIcon = appIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }
}
