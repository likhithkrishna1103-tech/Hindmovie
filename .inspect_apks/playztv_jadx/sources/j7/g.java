package j7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import c7.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements d, k7.c, c {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final z6.c f6819z = new z6.c("proto");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i f6820u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l7.a f6821v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l7.a f6822w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a f6823x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final md.a f6824y;

    public g(l7.a aVar, l7.a aVar2, a aVar3, i iVar, md.a aVar4) {
        this.f6820u = iVar;
        this.f6821v = aVar;
        this.f6822w = aVar2;
        this.f6823x = aVar3;
        this.f6824y = aVar4;
    }

    public static String H(Iterable iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(((b) it.next()).f6814a);
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static Object J(Cursor cursor, e eVar) {
        try {
            return eVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static Long d(SQLiteDatabase sQLiteDatabase, j jVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(jVar.f2560a, String.valueOf(m7.a.a(jVar.f2562c))));
        byte[] bArr = jVar.f2561b;
        if (bArr != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb2.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public final void F(long j5, f7.c cVar, String str) {
        v(new i7.f(str, cVar, j5));
    }

    public final Object G(k7.b bVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        l7.a aVar = this.f6822w;
        long jG = aVar.g();
        while (true) {
            try {
                sQLiteDatabaseA.beginTransaction();
                try {
                    Object objH = bVar.h();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return objH;
                } finally {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e10) {
                if (aVar.g() >= ((long) this.f6823x.f6811c) + jG) {
                    throw new k7.a("Timed out while trying to acquire the lock.", e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    public final SQLiteDatabase a() {
        i iVar = this.f6820u;
        Objects.requireNonNull(iVar);
        l7.a aVar = this.f6822w;
        long jG = aVar.g();
        while (true) {
            try {
                return iVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e10) {
                if (aVar.g() >= ((long) this.f6823x.f6811c) + jG) {
                    throw new k7.a("Timed out while trying to open db.", e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6820u.close();
    }

    public final Object v(e eVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            Object objApply = eVar.apply(sQLiteDatabaseA);
            sQLiteDatabaseA.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    public final ArrayList x(SQLiteDatabase sQLiteDatabase, j jVar, int i) {
        ArrayList arrayList = new ArrayList();
        Long lD = d(sQLiteDatabase, jVar);
        if (lD == null) {
            return arrayList;
        }
        J(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{lD.toString()}, null, null, null, String.valueOf(i)), new dd.e(this, arrayList, jVar, 6));
        return arrayList;
    }
}
