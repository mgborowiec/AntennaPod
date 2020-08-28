package com.mborowiec.antennapod.config;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.mborowiec.antennapod.R;
import com.mborowiec.antennapod.activity.MainActivity;
import com.mborowiec.antennapod.activity.VideoplayerActivity;
import com.mborowiec.antennapod.core.PlaybackServiceCallbacks;
import com.mborowiec.antennapod.core.feed.MediaType;

public class PlaybackServiceCallbacksImpl implements PlaybackServiceCallbacks {
    @Override
    public Intent getPlayerActivityIntent(Context context, MediaType mediaType, boolean remotePlayback) {
        if (mediaType == MediaType.AUDIO || remotePlayback) {
            return new Intent(context, MainActivity.class).putExtra(MainActivity.EXTRA_OPEN_PLAYER, true);
        } else {
            Intent i = new Intent(context, VideoplayerActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
            }
            return i;
        }
    }

    @Override
    public boolean useQueue() {
        return true;
    }

}
