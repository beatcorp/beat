package com.beatstreaming.beat.sheet;

import android.content.Context;
import android.content.Intent;

import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.component.sheet.list.ListSheetContext;
import com.beatstreaming.core.component.sheet.list.ListSheetItemContext;
import com.beatstreaming.core.entity.SerializableItemEntity;
import com.beatstreaming.media.player.PlayContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.TrackEntity;

public class GoToContext extends ListSheetItemContext<PlayContext, LibraryItemEntity<TrackEntity>> {
    private final Class<? extends MainActivity> activity;

    public GoToContext(int title, int icon, Class<? extends MainActivity> activity) {
        super(title, icon);

        this.activity = activity;
    }

    @Override
    public void onCall(Context context, ListSheetContext<PlayContext, LibraryItemEntity<TrackEntity>> listSheetContext) {
        MainActivity.mainActivity.startActivity(new Intent(context, this.activity).putExtra("data", SerializableItemEntity.GSON.toJson(this.getItems(listSheetContext))));
    }

    public Object[] getItems(ListSheetContext<PlayContext, LibraryItemEntity<TrackEntity>> listSheetContext) {
        return null;
    }
}
