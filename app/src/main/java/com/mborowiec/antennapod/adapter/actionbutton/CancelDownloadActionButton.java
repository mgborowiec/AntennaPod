package com.mborowiec.antennapod.adapter.actionbutton;

import android.content.Context;
import androidx.annotation.AttrRes;
import androidx.annotation.StringRes;
import android.widget.Toast;

import com.mborowiec.antennapod.R;
import com.mborowiec.antennapod.core.feed.FeedItem;
import com.mborowiec.antennapod.core.feed.FeedMedia;
import com.mborowiec.antennapod.core.preferences.UserPreferences;
import com.mborowiec.antennapod.core.storage.DBWriter;
import com.mborowiec.antennapod.core.storage.DownloadRequester;

public class CancelDownloadActionButton extends ItemActionButton {

    public CancelDownloadActionButton(FeedItem item) {
        super(item);
    }

    @Override
    @StringRes
    public int getLabel() {
        return R.string.cancel_download_label;
    }

    @Override
    @AttrRes
    public int getDrawable() {
        return R.attr.navigation_cancel;
    }

    @Override
    public void onClick(Context context) {
        FeedMedia media = item.getMedia();
        DownloadRequester.getInstance().cancelDownload(context, media);
        if (UserPreferences.isEnableAutodownload()) {
            DBWriter.setFeedItemAutoDownload(media.getItem(), false);
            Toast.makeText(context, R.string.download_canceled_autodownload_enabled_msg, Toast.LENGTH_LONG).show();
        }
    }
}
