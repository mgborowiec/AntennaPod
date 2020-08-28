package com.mborowiec.antennapod.config;

import com.mborowiec.antennapod.BuildConfig;
import com.mborowiec.antennapod.core.ClientConfig;

/**
 * Configures the ClientConfig class of the core package.
 */
class ClientConfigurator {

    private ClientConfigurator(){}

    static {
        ClientConfig.USER_AGENT = "AntennaPod/" + BuildConfig.VERSION_NAME;
        ClientConfig.applicationCallbacks = new ApplicationCallbacksImpl();
        ClientConfig.downloadServiceCallbacks = new DownloadServiceCallbacksImpl();
        ClientConfig.playbackServiceCallbacks = new PlaybackServiceCallbacksImpl();
        ClientConfig.dbTasksCallbacks = new DBTasksCallbacksImpl();
        ClientConfig.castCallbacks = new CastCallbackImpl();
    }
}
