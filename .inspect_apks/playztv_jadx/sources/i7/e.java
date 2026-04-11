package i7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import b7.s;
import c7.j;
import g4.u0;
import j7.g;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import l5.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements k7.b, oa.f {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6456u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ long f6457v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f6458w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f6459x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f6460y;

    public /* synthetic */ e(s sVar, Iterable iterable, j jVar, long j5) {
        this.f6456u = 0;
        this.f6458w = sVar;
        this.f6459x = iterable;
        this.f6460y = jVar;
        this.f6457v = j5;
    }

    @Override // oa.f
    public ScheduledFuture a(u5.d dVar) {
        switch (this.f6456u) {
            case 1:
                oa.e eVar = (oa.e) this.f6458w;
                Runnable runnable = (Runnable) this.f6459x;
                return eVar.f9468v.schedule(new oa.d(eVar, runnable, dVar, 1), this.f6457v, (TimeUnit) this.f6460y);
            default:
                oa.e eVar2 = (oa.e) this.f6458w;
                Callable callable = (Callable) this.f6459x;
                return eVar2.f9468v.schedule(new k(eVar2, callable, dVar, 2), this.f6457v, (TimeUnit) this.f6460y);
        }
    }

    @Override // k7.b
    public Object h() {
        s sVar = (s) this.f6458w;
        Iterable iterable = (Iterable) this.f6459x;
        j jVar = (j) this.f6460y;
        g gVar = (g) ((j7.d) sVar.f1900c);
        gVar.getClass();
        if (iterable.iterator().hasNext()) {
            String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + g.H(iterable);
            SQLiteDatabase sQLiteDatabaseA = gVar.a();
            sQLiteDatabaseA.beginTransaction();
            try {
                sQLiteDatabaseA.compileStatement(str).execute();
                Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        gVar.F(cursorRawQuery.getInt(0), f7.c.f4799z, cursorRawQuery.getString(1));
                    } catch (Throwable th) {
                        cursorRawQuery.close();
                        throw th;
                    }
                }
                cursorRawQuery.close();
                sQLiteDatabaseA.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseA.endTransaction();
            }
        }
        gVar.v(new u0(((l7.a) sVar.f1903g).g() + this.f6457v, jVar));
        return null;
    }

    public /* synthetic */ e(oa.e eVar, Object obj, long j5, TimeUnit timeUnit, int i) {
        this.f6456u = i;
        this.f6458w = eVar;
        this.f6459x = obj;
        this.f6457v = j5;
        this.f6460y = timeUnit;
    }
}
