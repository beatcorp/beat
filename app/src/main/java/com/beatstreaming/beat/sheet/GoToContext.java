package com.beatstreaming.beat.sheet;

import android.content.Context;
import android.content.Intent;

import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.component.sheet.list.ListSheetContext;
import com.beatstreaming.core.component.sheet.list.ListSheetItemContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.google.gson.Gson;

public class GoToContext extends ListSheetItemContext<LibraryItemEntity<TrackEntity>> {
    private final Class<? extends MainActivity> activity;

    public GoToContext(int title, int icon, Class<? extends MainActivity> activity) {
        super(title, icon);

        this.activity = activity;
    }

    @Override
    public void onCall(Context context, ListSheetContext<LibraryItemEntity<TrackEntity>> listSheetContext) {
        MainActivity.mainActivity.startActivity(new Intent(context, this.activity).putExtra("data", new Gson().toJson(this.getItems(listSheetContext))));
    }

    public Object[] getItems(ListSheetContext<LibraryItemEntity<TrackEntity>> listSheetContext) {
        return null;
    }
}
