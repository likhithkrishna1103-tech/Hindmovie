package k8;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends y0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final m f7253x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7254y;

    public j0(k1 k1Var) {
        super(k1Var);
        this.f7253x = new m(this, ((k1) this.f2454v).f7282u);
    }

    public static long w1(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return -1L;
            }
            long j5 = cursorQuery.getLong(0);
            cursorQuery.close();
            return j5;
        } finally {
        }
    }

    public final SQLiteDatabase A1() {
        if (this.f7254y) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f7253x.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f7254y = true;
        return null;
    }

    @Override // k8.y0
    public final boolean v1() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x1(int r18, byte[] r19) {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.j0.x1(int, byte[]):boolean");
    }

    public final void y1() {
        int iDelete;
        p1();
        try {
            SQLiteDatabase sQLiteDatabaseA1 = A1();
            if (sQLiteDatabaseA1 == null || (iDelete = sQLiteDatabaseA1.delete("messages", null, null)) <= 0) {
                return;
            }
            g().I.c(Integer.valueOf(iDelete), "Reset local analytics data. records");
        } catch (SQLiteException e10) {
            g().A.c(e10, "Error resetting local analytics data. error");
        }
    }

    public final boolean z1() {
        p1();
        if (!this.f7254y && ((k1) this.f2454v).f7282u.getDatabasePath("google_app_measurement_local.db").exists()) {
            int i = 5;
            for (int i10 = 0; i10 < 5; i10++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        try {
                            SQLiteDatabase sQLiteDatabaseA1 = A1();
                            if (sQLiteDatabaseA1 != null) {
                                sQLiteDatabaseA1.beginTransaction();
                                sQLiteDatabaseA1.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                                sQLiteDatabaseA1.setTransactionSuccessful();
                                sQLiteDatabaseA1.endTransaction();
                                sQLiteDatabaseA1.close();
                                return true;
                            }
                            this.f7254y = true;
                            if (sQLiteDatabaseA1 != null) {
                                sQLiteDatabaseA1.close();
                            }
                        } catch (SQLiteException e10) {
                            if (0 != 0) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th) {
                                    if (0 != 0) {
                                        sQLiteDatabase.close();
                                    }
                                    throw th;
                                }
                            }
                            g().A.c(e10, "Error deleting app launch break from local database");
                            this.f7254y = true;
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                        }
                    } catch (SQLiteDatabaseLockedException unused) {
                        SystemClock.sleep(i);
                        i += 20;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (SQLiteFullException e11) {
                    g().A.c(e11, "Error deleting app launch break from local database");
                    this.f7254y = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            g().D.d("Error deleting app launch break from local database in reasonable time");
            return false;
        }
        return false;
    }
}
