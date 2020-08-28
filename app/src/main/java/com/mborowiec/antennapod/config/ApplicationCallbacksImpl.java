package com.mborowiec.antennapod.config;


import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.mborowiec.antennapod.PodcastApp;
import com.mborowiec.antennapod.activity.StorageErrorActivity;
import com.mborowiec.antennapod.core.ApplicationCallbacks;

public class ApplicationCallbacksImpl implements ApplicationCallbacks {

    @Override
    public Application getApplicationInstance() {
        return PodcastApp.getInstance();
    }

    @Override
    public Intent getStorageErrorActivity(Context context) {
        return new Intent(context, StorageErrorActivity.class);
    }

}
