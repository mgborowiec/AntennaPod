package com.mborowiec.antennapod.menuhandler;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import com.mborowiec.antennapod.R;
import com.mborowiec.antennapod.activity.MainActivity;
import com.mborowiec.antennapod.core.preferences.UserPreferences;
import com.mborowiec.antennapod.fragment.SearchFragment;

/**
 * Utilities for menu items
 */
public class MenuItemUtils extends com.mborowiec.antennapod.core.menuhandler.MenuItemUtils {

    @SuppressWarnings("ResourceType")
    public static void refreshLockItem(Context context, Menu menu) {
        final MenuItem queueLock = menu.findItem(com.mborowiec.antennapod.R.id.queue_lock);
        int[] lockIcons = new int[] { com.mborowiec.antennapod.R.attr.ic_lock_open, com.mborowiec.antennapod.R.attr.ic_lock_closed };
        TypedArray ta = context.obtainStyledAttributes(lockIcons);
        if (UserPreferences.isQueueLocked()) {
            queueLock.setTitle(com.mborowiec.antennapod.R.string.unlock_queue);
            queueLock.setIcon(ta.getDrawable(0));
        } else {
            queueLock.setTitle(com.mborowiec.antennapod.R.string.lock_queue);
            queueLock.setIcon(ta.getDrawable(1));
        }
        ta.recycle();
    }

    public static void setupSearchItem(Menu menu, MainActivity activity, long feedId) {
        MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView sv = (SearchView) searchItem.getActionView();
        sv.setQueryHint(activity.getString(R.string.search_label));
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                sv.clearFocus();
                activity.loadChildFragment(SearchFragment.newInstance(s, feedId));
                searchItem.collapseActionView();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                for (int i = 0; i < menu.size(); i++) {
                    if (menu.getItem(i).getItemId() != searchItem.getItemId()) {
                        menu.getItem(i).setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
                    }
                }
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                activity.invalidateOptionsMenu();
                return true;
            }
        });
    }
}
