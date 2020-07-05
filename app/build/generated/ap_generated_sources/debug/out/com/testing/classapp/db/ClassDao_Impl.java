package com.testing.classapp.db;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.testing.classapp.model.ClassModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class ClassDao_Impl implements ClassDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfClassModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfClassModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfClassModel;

  public ClassDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClassModel = new EntityInsertionAdapter<ClassModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `kelas`(`id_kelas`,`nama_kelas`,`nama_wali`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ClassModel value) {
        stmt.bindLong(1, value.getId_kelas());
        if (value.getNama_kelas() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama_kelas());
        }
        if (value.getNama_wali() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNama_wali());
        }
      }
    };
    this.__deletionAdapterOfClassModel = new EntityDeletionOrUpdateAdapter<ClassModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `kelas` WHERE `id_kelas` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ClassModel value) {
        stmt.bindLong(1, value.getId_kelas());
      }
    };
    this.__updateAdapterOfClassModel = new EntityDeletionOrUpdateAdapter<ClassModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `kelas` SET `id_kelas` = ?,`nama_kelas` = ?,`nama_wali` = ? WHERE `id_kelas` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ClassModel value) {
        stmt.bindLong(1, value.getId_kelas());
        if (value.getNama_kelas() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama_kelas());
        }
        if (value.getNama_wali() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNama_wali());
        }
        stmt.bindLong(4, value.getId_kelas());
      }
    };
  }

  @Override
  public void insert(ClassModel classModel) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfClassModel.insert(classModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(ClassModel classModel) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfClassModel.handle(classModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(ClassModel classModel) {
    __db.beginTransaction();
    try {
      __updateAdapterOfClassModel.handle(classModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ClassModel> select() {
    final String _sql = "SELECT * FROM KELAS ORDER BY nama_kelas ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdKelas = _cursor.getColumnIndexOrThrow("id_kelas");
      final int _cursorIndexOfNamaKelas = _cursor.getColumnIndexOrThrow("nama_kelas");
      final int _cursorIndexOfNamaWali = _cursor.getColumnIndexOrThrow("nama_wali");
      final List<ClassModel> _result = new ArrayList<ClassModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ClassModel _item;
        _item = new ClassModel();
        final int _tmpId_kelas;
        _tmpId_kelas = _cursor.getInt(_cursorIndexOfIdKelas);
        _item.setId_kelas(_tmpId_kelas);
        final String _tmpNama_kelas;
        _tmpNama_kelas = _cursor.getString(_cursorIndexOfNamaKelas);
        _item.setNama_kelas(_tmpNama_kelas);
        final String _tmpNama_wali;
        _tmpNama_wali = _cursor.getString(_cursorIndexOfNamaWali);
        _item.setNama_wali(_tmpNama_wali);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
