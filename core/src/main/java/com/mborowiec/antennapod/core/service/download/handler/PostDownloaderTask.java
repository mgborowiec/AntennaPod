package com.mborowiec.antennapod.core.service.download.handler;

import com.mborowiec.antennapod.core.event.DownloadEvent;
import com.mborowiec.antennapod.core.service.download.Downloader;
import com.mborowiec.antennapod.core.storage.DownloadRequester;
import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostDownloaderTask implements Runnable {
    private List<Downloader> downloads;

    public PostDownloaderTask(List<Downloader> downloads) {
        this.downloads = downloads;
    }

    @Override
    public void run() {
        List<Downloader> runningDownloads = new ArrayList<>();
        for (Downloader downloader : downloads) {
            if (!downloader.cancelled) {
                runningDownloads.add(downloader);
            }
        }
        DownloadRequester.getInstance().updateProgress(downloads);
        List<Downloader> list = Collections.unmodifiableList(runningDownloads);
        EventBus.getDefault().postSticky(DownloadEvent.refresh(list));
    }
}
