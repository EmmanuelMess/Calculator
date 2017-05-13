package com.emmanuelmess.modularcalculator;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlugInFragment extends Fragment implements FragmentHolder {

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {

        // Note that loading of resources is not the same as usual, because it loaded actually from another apk
        final XmlResourceParser parser = container.getContext().getPackageManager()
                .getXml(FragmentLoader.PACKAGE, R.layout.fragment_layout, null);

        return inflater.inflate(parser, container, false);
    }

    @Override
    public Fragment getFragment() {
        return this;
    }
}