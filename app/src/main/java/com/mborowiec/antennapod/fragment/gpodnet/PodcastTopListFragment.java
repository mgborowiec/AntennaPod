package com.mborowiec.antennapod.fragment.gpodnet;

import com.mborowiec.antennapod.core.sync.gpoddernet.GpodnetService;
import com.mborowiec.antennapod.core.sync.gpoddernet.GpodnetServiceException;
import com.mborowiec.antennapod.core.sync.gpoddernet.model.GpodnetPodcast;

import java.util.List;

public class PodcastTopListFragment extends PodcastListFragment {
    private static final int PODCAST_COUNT = 50;

    @Override
    protected List<GpodnetPodcast> loadPodcastData(GpodnetService service) throws GpodnetServiceException {
        return service.getPodcastToplist(PODCAST_COUNT);
    }
}
