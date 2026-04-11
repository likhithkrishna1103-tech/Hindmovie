package f9;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends h0 {
    public static final String[] A = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final m f4319y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f4320z;

    public p0(r1 r1Var) {
        super(r1Var);
        this.f4319y = new m(this, ((r1) this.f307w).f4363v);
    }

    @Override // f9.h0
    public final boolean p1() {
        return false;
    }

    public final void q1() {
        int iDelete;
        r1 r1Var = (r1) this.f307w;
        m1();
        try {
            SQLiteDatabase sQLiteDatabaseS1 = s1();
            if (sQLiteDatabaseS1 == null || (iDelete = sQLiteDatabaseS1.delete("messages", null, null)) <= 0) {
                return;
            }
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.J.b(Integer.valueOf(iDelete), "Reset local analytics data. records");
        } catch (SQLiteException e9) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.B.b(e9, "Error resetting local analytics data. error");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0070 A[PHI: r5
      0x0070: PHI (r5v4 int) = (r5v1 int), (r5v2 int), (r5v1 int) binds: [B:32:0x0081, B:28:0x006e, B:25:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r1() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            java.lang.Object r1 = r11.f307w
            f9.r1 r1 = (f9.r1) r1
            r11.m1()
            boolean r2 = r11.f4320z
            r3 = 0
            if (r2 == 0) goto L10
            goto L99
        L10:
            android.content.Context r2 = r1.f4363v
            java.lang.String r4 = "google_app_measurement_local.db"
            java.io.File r2 = r2.getDatabasePath(r4)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L99
            r2 = 5
            r5 = r2
            r4 = r3
        L21:
            if (r4 >= r2) goto L8d
            r6 = 0
            r7 = 1
            android.database.sqlite.SQLiteDatabase r6 = r11.s1()     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4d android.database.sqlite.SQLiteDatabaseLockedException -> L68 android.database.sqlite.SQLiteFullException -> L74
            if (r6 != 0) goto L2e
            r11.f4320z = r7     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4d android.database.sqlite.SQLiteDatabaseLockedException -> L68 android.database.sqlite.SQLiteFullException -> L74
            goto L99
        L2e:
            r6.beginTransaction()     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4d android.database.sqlite.SQLiteDatabaseLockedException -> L68 android.database.sqlite.SQLiteFullException -> L74
            java.lang.String r8 = "messages"
            java.lang.String r9 = "type == ?"
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4d android.database.sqlite.SQLiteDatabaseLockedException -> L68 android.database.sqlite.SQLiteFullException -> L74
            java.lang.String[] r10 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4d android.database.sqlite.SQLiteDatabaseLockedException -> L68 android.database.sqlite.SQLiteFullException -> L74
            r6.delete(r8, r9, r10)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4d android.database.sqlite.SQLiteDatabaseLockedException -> L68 android.database.sqlite.SQLiteFullException -> L74
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4d android.database.sqlite.SQLiteDatabaseLockedException -> L68 android.database.sqlite.SQLiteFullException -> L74
            r6.endTransaction()     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4d android.database.sqlite.SQLiteDatabaseLockedException -> L68 android.database.sqlite.SQLiteFullException -> L74
            r6.close()
            return r7
        L4b:
            r0 = move-exception
            goto L87
        L4d:
            r8 = move-exception
            if (r6 == 0) goto L59
            boolean r9 = r6.inTransaction()     // Catch: java.lang.Throwable -> L4b
            if (r9 == 0) goto L59
            r6.endTransaction()     // Catch: java.lang.Throwable -> L4b
        L59:
            f9.w0 r9 = r1.A     // Catch: java.lang.Throwable -> L4b
            f9.r1.g(r9)     // Catch: java.lang.Throwable -> L4b
            f9.u0 r9 = r9.B     // Catch: java.lang.Throwable -> L4b
            r9.b(r8, r0)     // Catch: java.lang.Throwable -> L4b
            r11.f4320z = r7     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L84
            goto L70
        L68:
            long r7 = (long) r5     // Catch: java.lang.Throwable -> L4b
            android.os.SystemClock.sleep(r7)     // Catch: java.lang.Throwable -> L4b
            int r5 = r5 + 20
            if (r6 == 0) goto L84
        L70:
            r6.close()
            goto L84
        L74:
            r8 = move-exception
            f9.w0 r9 = r1.A     // Catch: java.lang.Throwable -> L4b
            f9.r1.g(r9)     // Catch: java.lang.Throwable -> L4b
            f9.u0 r9 = r9.B     // Catch: java.lang.Throwable -> L4b
            r9.b(r8, r0)     // Catch: java.lang.Throwable -> L4b
            r11.f4320z = r7     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L84
            goto L70
        L84:
            int r4 = r4 + 1
            goto L21
        L87:
            if (r6 == 0) goto L8c
            r6.close()
        L8c:
            throw r0
        L8d:
            f9.w0 r0 = r1.A
            f9.r1.g(r0)
            f9.u0 r0 = r0.E
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.a(r1)
        L99:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.p0.r1():boolean");
    }

    public final SQLiteDatabase s1() {
        if (this.f4320z) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f4319y.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f4320z = true;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae A[Catch: SQLiteException -> 0x0093, SQLiteDatabaseLockedException -> 0x009a, SQLiteFullException -> 0x009e, all -> 0x0154, TRY_ENTER, TryCatch #10 {all -> 0x0154, blocks: (B:30:0x0088, B:32:0x008e, B:43:0x00ae, B:45:0x00cf, B:47:0x00d8, B:49:0x00de, B:59:0x00f8, B:73:0x0120, B:75:0x0126, B:76:0x0129, B:93:0x015b, B:83:0x0144), top: B:109:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0120 A[Catch: all -> 0x0154, TRY_ENTER, TryCatch #10 {all -> 0x0154, blocks: (B:30:0x0088, B:32:0x008e, B:43:0x00ae, B:45:0x00cf, B:47:0x00d8, B:49:0x00de, B:59:0x00f8, B:73:0x0120, B:75:0x0126, B:76:0x0129, B:93:0x015b, B:83:0x0144), top: B:109:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0150 A[PHI: r8 r10 r17
      0x0150: PHI (r8v5 int) = (r8v3 int), (r8v3 int), (r8v6 int) binds: [B:79:0x013c, B:96:0x016d, B:87:0x014e] A[DONT_GENERATE, DONT_INLINE]
      0x0150: PHI (r10v7 android.database.sqlite.SQLiteDatabase) = 
      (r10v5 android.database.sqlite.SQLiteDatabase)
      (r10v6 android.database.sqlite.SQLiteDatabase)
      (r10v8 android.database.sqlite.SQLiteDatabase)
     binds: [B:79:0x013c, B:96:0x016d, B:87:0x014e] A[DONT_GENERATE, DONT_INLINE]
      0x0150: PHI (r17v7 boolean) = (r17v4 boolean), (r17v5 boolean), (r17v8 boolean) binds: [B:79:0x013c, B:96:0x016d, B:87:0x014e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t1(int r19, byte[] r20) {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.p0.t1(int, byte[]):boolean");
    }
}
