package com.emmanuelmess.modularcalculator;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * @author Emmanuel
 *         on 7/6/2017, at 19:25.
 */

public class LoaderActivity extends Activity {

    private ArrayList<Module> modules = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        modules = Loader.loadAllModules(this);
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

}
