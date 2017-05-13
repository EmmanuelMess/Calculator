package com.emmanuelmess.modularcalculator;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import java.io.File;

import dalvik.system.DexClassLoader;

/**
 * @author Emmanuel
 *         on 12/5/2017, at 21:18.
 */

public class FragmentLoader {

    public static final String PACKAGE = "com.emmanuelmess.modularcalculator.plugins";

    protected void load(Context context, FragmentActivity activity, String name, @IdRes int idPlace)
            throws PackageManager.NameNotFoundException, ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Class<?> requiredClass = null;
        final String apkPath = context.getPackageManager().getApplicationInfo(PACKAGE, 0).sourceDir;
        final File dexTemp = context.getDir("temp_folder", 0);
        final String fullName = PACKAGE + "." + name;
        boolean isLoaded = true;

        // Check if class loaded
        try {
            requiredClass = Class.forName(fullName);
        } catch (ClassNotFoundException e) {
            isLoaded = false;
        }

        if (!isLoaded) {
            final DexClassLoader classLoader = new DexClassLoader(apkPath,
                    dexTemp.getAbsolutePath(),
                    null,
                    context.getApplicationContext().getClassLoader());

            requiredClass = classLoader.loadClass(fullName);
        }

        if (null != requiredClass) {
            // Try to cast to required interface to ensure that it's can be cast
            final FragmentHolder holder = FragmentHolder.class.cast(requiredClass.newInstance());

            if (null != holder) {
                final Fragment fragment = holder.getFragment();

                if (null != fragment) {
                    final FragmentTransaction trans = activity.getSupportFragmentManager().beginTransaction();

                    trans.add(idPlace, fragment, name).commit();
                }
            }
        }
    }

}
