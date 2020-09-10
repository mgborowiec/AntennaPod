package com.mborowiec.antennapod.adapter.actionbutton;

import android.content.Context;
import androidx.annotation.AttrRes;
import androidx.annotation.StringRes;
import com.mborowiec.antennapod.R;
import com.mborowiec.antennapod.core.feed.FeedItem;
import com.mborowiec.antennapod.core.feed.FeedMedia;
import com.mborowiec.antennapod.core.feed.MediaType;
import com.mborowiec.antennapod.core.service.playback.PlaybackService;
import com.mborowiec.antennapod.core.storage.DBTasks;
import com.mborowiec.antennapod.core.util.playback.PlaybackServiceStarter;

public class PlayActionButton extends ItemActionButton {

    public PlayActionButton(FeedItem item) {
        super(item);
    }

    @Override
    @StringRes
    public int getLabel() {
        return R.string.play_label;
    }

    @Override
    @AttrRes
    public int getDrawable() {
        return R.attr.av_play;
    }

    @Override
    public void onClick(Context context) {
        FeedMedia media = item.getMedia();
        if (media == null) {
            return;
        }
        if (!media.fileExists()) {
            DBTasks.notifyMissingFeedMediaFile(context, media);
            return;
        }
        new PlaybackServiceStarter(context, media)
                .callEvenIfRunning(true)
                .startWhenPrepared(true)
                .shouldStream(false)
                .start();

        if (media.getMediaType() == MediaType.VIDEO) {
            context.startActivity(PlaybackService.getPlayerActivityIntent(context, media));
        }
    }
}
