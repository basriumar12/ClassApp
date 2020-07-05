package com.testing.classapp.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class ClassDatabase_Impl extends ClassDatabase {
  private volatile ClassDao _classDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `kelas` (`id_kelas` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nama_kelas` TEXT, `nama_wali` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"e7825f8a70781ab6a26157206a8517bf\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `kelas`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsKelas = new HashMap<String, TableInfo.Column>(3);
        _columnsKelas.put("id_kelas", new TableInfo.Column("id_kelas", "INTEGER", true, 1));
        _columnsKelas.put("nama_kelas", new TableInfo.Column("nama_kelas", "TEXT", false, 0));
        _columnsKelas.put("nama_wali", new TableInfo.Column("nama_wali", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKelas = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKelas = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKelas = new TableInfo("kelas", _columnsKelas, _foreignKeysKelas, _indicesKelas);
        final TableInfo _existingKelas = TableInfo.read(_db, "kelas");
        if (! _infoKelas.equals(_existingKelas)) {
          throw new IllegalStateException("Migration didn't properly handle kelas(com.testing.classapp.model.ClassModel).\n"
                  + " Expected:\n" + _infoKelas + "\n"
                  + " Found:\n" + _existingKelas);
        }
      }
    }, "e7825f8a70781ab6a26157206a8517bf", "64eda2362bcfa03dcaeb79d33b5d951b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "kelas");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `kelas`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ClassDao kelasDao() {
    if (_classDao != null) {
      return _classDao;
    } else {
      synchronized(this) {
        if(_classDao == null) {
          _classDao = new ClassDao_Impl(this);
        }
        return _classDao;
      }
    }
  }
}
