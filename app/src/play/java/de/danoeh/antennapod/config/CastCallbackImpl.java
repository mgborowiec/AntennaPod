package com.mborowiec.antennapod.config;

import androidx.annotation.NonNull;
import androidx.mediarouter.app.MediaRouteControllerDialogFragment;
import androidx.mediarouter.app.MediaRouteDialogFactory;

import com.mborowiec.antennapod.core.CastCallbacks;
import com.mborowiec.antennapod.fragment.CustomMRControllerDialogFragment;

public class CastCallbackImpl implements CastCallbacks {
    @Override
    public MediaRouteDialogFactory getMediaRouterDialogFactory() {
        return new MediaRouteDialogFactory() {
            @NonNull
            @Override
            public MediaRouteControllerDialogFragment onCreateControllerDialogFragment() {
                return new CustomMRControllerDialogFragment();
            }
        };
    }
}
