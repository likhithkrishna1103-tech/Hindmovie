package d8;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements f8.b, ib.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3543v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f3544w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f3545x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f3546y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f3547z;

    public /* synthetic */ h(j jVar, Iterable iterable, x7.i iVar, long j4) {
        this.f3543v = 0;
        this.f3545x = jVar;
        this.f3546y = iterable;
        this.f3547z = iVar;
        this.f3544w = j4;
    }

    @Override // ib.f
    public ScheduledFuture a(p6.c cVar) {
        switch (this.f3543v) {
            case 1:
                ib.e eVar = (ib.e) this.f3545x;
                Runnable runnable = (Runnable) this.f3546y;
                return eVar.f6401w.schedule(new ib.d(eVar, runnable, cVar, 1), this.f3544w, (TimeUnit) this.f3547z);
            default:
                ib.e eVar2 = (ib.e) this.f3545x;
                Callable callable = (Callable) this.f3546y;
                return eVar2.f6401w.schedule(new g6.j(eVar2, callable, cVar, 2), this.f3544w, (TimeUnit) this.f3547z);
        }
    }

    @Override // f8.b
    public Object g() {
        j jVar = (j) this.f3545x;
        Iterable iterable = (Iterable) this.f3546y;
        x7.i iVar = (x7.i) this.f3547z;
        e8.i iVar2 = (e8.i) ((e8.d) jVar.f3553c);
        iVar2.getClass();
        if (iterable.iterator().hasNext()) {
            String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + e8.i.C(iterable);
            SQLiteDatabase sQLiteDatabaseA = iVar2.a();
            sQLiteDatabaseA.beginTransaction();
            try {
                sQLiteDatabaseA.compileStatement(str).execute();
                Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        iVar2.z(cursorRawQuery.getInt(0), a8.c.A, cursorRawQuery.getString(1));
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
        iVar2.q(new e8.f(((g8.a) jVar.f3556g).l() + this.f3544w, iVar));
        return null;
    }

    public /* synthetic */ h(ib.e eVar, Object obj, long j4, TimeUnit timeUnit, int i) {
        this.f3543v = i;
        this.f3545x = eVar;
        this.f3546y = obj;
        this.f3544w = j4;
        this.f3547z = timeUnit;
    }
}
