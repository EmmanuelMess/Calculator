package com.emmanuelmess.modularcalculator;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * @author Emmanuel
 *         on 7/6/2017, at 18:34.
 */

public class Loader {

    private static final String[] MODULES = {"com.emmanuelmess.modularcalculator.modules"};
    private static final String MANIFEST_NAME = "Manifest";

    public static ArrayList<Module> loadAllModules(Context c) {
        ArrayList<Module> modules = new ArrayList<>();

        for (String module : MODULES) {
            Module plugin = loadModule(c, module + "." + MANIFEST_NAME);
            if(plugin != null) modules.add(plugin);
        }

        return modules;
    }

    private static Module loadModule(Context c, final String MODULE) {
        Module plugin = null;

        try {
            Class<?> module = Class.forName(MODULE);
            plugin = (Module) module.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(c, "Loading module failed", Toast.LENGTH_SHORT).show();
        }

        return plugin;
    }

}
