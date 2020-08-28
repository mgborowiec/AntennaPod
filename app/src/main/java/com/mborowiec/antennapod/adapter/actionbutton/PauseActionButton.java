package com.mborowiec.antennapod.adapter.actionbutton;

import android.content.Context;
import androidx.annotation.AttrRes;
import androidx.annotation.StringRes;
import com.mborowiec.antennapod.R;
import com.mborowiec.antennapod.core.feed.FeedItem;
import com.mborowiec.antennapod.core.feed.FeedMedia;
import com.mborowiec.antennapod.core.util.IntentUtils;

import static com.mborowiec.antennapod.core.service.playback.PlaybackService.ACTION_PAUSE_PLAY_CURRENT_EPISODE;

public class PauseActionButton extends ItemActionButton {

    public PauseActionButton(FeedItem item) {
        super(item);
    }

    @Override
    @StringRes
    public int getLabel() {
        return R.string.pause_label;
    }

    @Override
    @AttrRes
    public int getDrawable() {
        return R.attr.av_pause;
    }

    @Override
    public void onClick(Context context) {
        FeedMedia media = item.getMedia();
        if (media == null) {
            return;
        }

        if (media.isCurrentlyPlaying()) {
            IntentUtils.sendLocalBroadcast(context, ACTION_PAUSE_PLAY_CURRENT_EPISODE);
        }
    }
}
