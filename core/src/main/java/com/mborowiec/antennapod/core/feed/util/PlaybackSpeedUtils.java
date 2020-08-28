package com.mborowiec.antennapod.core.feed.util;

import com.mborowiec.antennapod.core.feed.Feed;
import com.mborowiec.antennapod.core.feed.FeedItem;
import com.mborowiec.antennapod.core.feed.FeedMedia;
import com.mborowiec.antennapod.core.feed.MediaType;
import com.mborowiec.antennapod.core.preferences.PlaybackPreferences;
import com.mborowiec.antennapod.core.preferences.UserPreferences;
import com.mborowiec.antennapod.core.util.playback.Playable;

import static com.mborowiec.antennapod.core.feed.FeedPreferences.SPEED_USE_GLOBAL;

/**
 * Utility class to use the appropriate playback speed based on {@link PlaybackPreferences}
 */
public final class PlaybackSpeedUtils {

    private PlaybackSpeedUtils() {
    }

    /**
     * Returns the currently configured playback speed for the specified media.
     */
    public static float getCurrentPlaybackSpeed(Playable media) {
        float playbackSpeed = SPEED_USE_GLOBAL;
        MediaType mediaType = null;

        if (media != null) {
            mediaType = media.getMediaType();
            playbackSpeed = PlaybackPreferences.getCurrentlyPlayingTemporaryPlaybackSpeed();

            if (playbackSpeed == SPEED_USE_GLOBAL && media instanceof FeedMedia) {
                FeedItem item = ((FeedMedia) media).getItem();
                if (item != null) {
                    Feed feed = item.getFeed();
                    if (feed != null) {
                        playbackSpeed = feed.getPreferences().getFeedPlaybackSpeed();
                    }
                }
            }
        }

        if (playbackSpeed == SPEED_USE_GLOBAL) {
            playbackSpeed = UserPreferences.getPlaybackSpeed(mediaType);
        }

        return playbackSpeed;
    }
}
