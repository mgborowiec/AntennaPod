package com.mborowiec.antennapod.config;

import com.mborowiec.antennapod.core.DBTasksCallbacks;
import com.mborowiec.antennapod.core.preferences.UserPreferences;
import com.mborowiec.antennapod.core.storage.APDownloadAlgorithm;
import com.mborowiec.antennapod.core.storage.AutomaticDownloadAlgorithm;
import com.mborowiec.antennapod.core.storage.EpisodeCleanupAlgorithm;

public class DBTasksCallbacksImpl implements DBTasksCallbacks {

    @Override
    public AutomaticDownloadAlgorithm getAutomaticDownloadAlgorithm() {
        return new APDownloadAlgorithm();
    }

    @Override
    public EpisodeCleanupAlgorithm getEpisodeCacheCleanupAlgorithm() {
        return UserPreferences.getEpisodeCleanupAlgorithm();
    }
}
