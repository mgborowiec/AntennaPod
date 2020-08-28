package com.mborowiec.antennapod.preferences;

import com.mborowiec.antennapod.core.preferences.UserPreferences;
import com.mborowiec.antennapod.fragment.preferences.PlaybackPreferencesFragment;

/**
 * Implements functions from PreferenceController that are flavor dependent.
 */
public class PreferenceControllerFlavorHelper {

    public static void setupFlavoredUI(PlaybackPreferencesFragment ui) {
        ui.findPreference(UserPreferences.PREF_CAST_ENABLED).setEnabled(false);
    }
}
