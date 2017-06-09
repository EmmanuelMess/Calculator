package com.emmanuelmess.modularcalculator.modules;

import com.emmanuelmess.modularcalculator.Module;

/**
 * @author Emmanuel
 *         on 7/6/2017, at 18:48.
 */

public class Manifest implements Module {

    public Manifest() {

    }

    @Override
    public String getName() {
        return "Normal module";
    }

    @Override
    public String getAuthor() {
        return "Emmanuel";
    }

    @Override
    public String getDescription() {
        return "Basic functionality";
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onShow() {

    }

    @Override
    public void onHide() {

    }

    @Override
    public void onUnload() {

    }
}
