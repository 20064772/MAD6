package com.example.mad6;

import android.database.Cursor;
import android.database.CursorWrapper;

public class FactionListDBCursor extends CursorWrapper
{
    public FactionListDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Faction getFaction(){
        int id = getInt(getColumnIndex(TableSchema.MadSixSchema.Cols.ID));
        String name = getString(getColumnIndex(TableSchema.MadSixSchema.Cols.NAME));
        int strength = getInt(getColumnIndex(TableSchema.MadSixSchema.Cols.STRENGTH));
        int relationship = getInt(getColumnIndex(TableSchema.MadSixSchema.Cols.RELATIONSHIP));
        return new Faction(id, name, strength, relationship);
    }
}
