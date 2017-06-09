package com.emmanuelmess.modularcalculator;

/**
 * @author Emmanuel
 *         on 12/5/2017, at 21:35.
 */

public interface Module {

    String getName();

    String getAuthor();

    String getDescription();

    void onLoad();

    void onShow();

    void onHide();

    void onUnload();
}
