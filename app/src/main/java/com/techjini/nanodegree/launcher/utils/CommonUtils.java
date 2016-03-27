package com.techjini.nanodegree.launcher.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

/**
 * Created by Sanjeev on 3/27/16.
 */
public class CommonUtils {
    private static Toast sToast;

    /**
     * Displays toast
     *
     * @param context: Context
     * @param message: Message to display
     */
    public static void showToast(Context context, String message) {
        if (sToast != null) {
            sToast.cancel();
        }
        sToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        sToast.show();
    }

    /**
     * Checks if app is installed
     *
     * @param context:     Context
     * @param packageName: Package name to check
     * @return true, if installed. False otherwise
     */
    public static boolean startAppIfExists(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        boolean isAppInstalled;
        try {
            Intent intent = pm.getLaunchIntentForPackage(packageName);
            if (intent != null) {
                context.startActivity(intent);
                isAppInstalled = true;
            } else {
                isAppInstalled = false;
            }
        } catch (Exception e) {
            isAppInstalled = false;
        }
        return isAppInstalled;
    }
}
