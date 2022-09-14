package com.example.mad6;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintains the overall dataset; specifically of course all the different factions.
 */
public class FactionList
{
    private List<Faction> factions = new ArrayList<>();
    private SQLiteDatabase DB;

    public FactionList() {}

    public void load(Context context)
    {
        this.DB = new TableSchemaDBHelper( context.getApplicationContext()).getWritableDatabase();
    }

    public int size()
    {
        return factions.size();
    }

    public Faction get(int i)
    {
        return factions.get(i);
    }

    public int add(Faction newFaction)
    {
        factions.add(newFaction);
        ContentValues cv = new ContentValues();
        cv.put(TableSchema.MadSixSchema.Cols.ID, newFaction.getId());
        cv.put(TableSchema.MadSixSchema.Cols.NAME, newFaction.getName());
        cv.put(TableSchema.MadSixSchema.Cols.RELATIONSHIP, newFaction.getRelationship());
        cv.put(TableSchema.MadSixSchema.Cols.STRENGTH, newFaction.getStrength());
        DB.insert(TableSchema.MadSixSchema.WorkSheet6, null, cv);
        return factions.size() - 1; // Return insertion point
    }

    public void edit(Faction newFaction)
    {
        // ...
    }

    public void remove(Faction rmFaction)
    {
        String[] whereValue = {String.valueOf(rmFaction.getId())};
        DB.delete(TableSchema.MadSixSchema.WorkSheet6, TableSchema.MadSixSchema.Cols.ID + " = ?", whereValue);
        factions.remove(rmFaction);
    }
}
