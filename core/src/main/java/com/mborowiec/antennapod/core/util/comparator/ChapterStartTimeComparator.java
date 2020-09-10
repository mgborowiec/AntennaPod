package com.mborowiec.antennapod.core.util.comparator;

import java.util.Comparator;

import com.mborowiec.antennapod.core.feed.Chapter;

public class ChapterStartTimeComparator implements Comparator<Chapter> {

	@Override
	public int compare(Chapter lhs, Chapter rhs) {
		return Long.compare(lhs.getStart(), rhs.getStart());
	}

}
