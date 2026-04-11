package e8;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements d, f8.c, c {
    public static final u7.c A = new u7.c("proto");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f3841v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final g8.a f3842w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g8.a f3843x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f3844y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final qd.a f3845z;

    public i(g8.a aVar, g8.a aVar2, a aVar3, k kVar, qd.a aVar4) {
        this.f3841v = kVar;
        this.f3842w = aVar;
        this.f3843x = aVar2;
        this.f3844y = aVar3;
        this.f3845z = aVar4;
    }

    public static String C(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((b) it.next()).f3832a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object J(Cursor cursor, g gVar) {
        try {
            return gVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static Long g(SQLiteDatabase sQLiteDatabase, x7.i iVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(iVar.f14434a, String.valueOf(h8.a.a(iVar.f14436c))));
        byte[] bArr = iVar.f14435b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public final Object A(f8.b bVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        g8.a aVar = this.f3843x;
        long jL = aVar.l();
        while (true) {
            try {
                sQLiteDatabaseA.beginTransaction();
                try {
                    Object objG = bVar.g();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return objG;
                } finally {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e9) {
                if (aVar.l() >= ((long) this.f3844y.f3829c) + jL) {
                    throw new f8.a("Timed out while trying to acquire the lock.", e9);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    public final SQLiteDatabase a() {
        k kVar = this.f3841v;
        Objects.requireNonNull(kVar);
        g8.a aVar = this.f3843x;
        long jL = aVar.l();
        while (true) {
            try {
                return kVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e9) {
                if (aVar.l() >= ((long) this.f3844y.f3829c) + jL) {
                    throw new f8.a("Timed out while trying to open db.", e9);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3841v.close();
    }

    public final Object q(g gVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            Object objApply = gVar.apply(sQLiteDatabaseA);
            sQLiteDatabaseA.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    public final ArrayList s(SQLiteDatabase sQLiteDatabase, x7.i iVar, int i) {
        ArrayList arrayList = new ArrayList();
        Long lG = g(sQLiteDatabase, iVar);
        if (lG == null) {
            return arrayList;
        }
        J(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{lG.toString()}, null, null, null, String.valueOf(i)), new c8.b(this, (Object) arrayList, iVar, 2));
        return arrayList;
    }

    public final void z(long j4, a8.c cVar, String str) {
        q(new d8.i(str, cVar, j4));
    }
}
