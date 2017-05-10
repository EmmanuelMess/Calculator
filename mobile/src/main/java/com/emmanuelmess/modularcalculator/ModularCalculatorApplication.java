package com.emmanuelmess.modularcalculator;

import android.app.Application;
import android.content.Context;

import com.xlythe.calculator.material.R;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

/**
 * @author Emmanuel
 *         on 10/5/2017, at 15:56.
 */

@ReportsCrashes(
        formUri = "https://emmanuelmess.cloudant.com/acra-modularcalculator/_design/acra-storage/_update/report",
        reportType = org.acra.sender.HttpSender.Type.JSON,
        httpMethod = org.acra.sender.HttpSender.Method.PUT,
        formUriBasicAuthLogin="offordayinfeepeovouspeop",
        formUriBasicAuthPassword="c6c3706e8fe8239235f3d1a740eaad948221c3e2",
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text)
public class ModularCalculatorApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        // The following line triggers the initialization of ACRA
        ACRA.init(this);
    }

}
