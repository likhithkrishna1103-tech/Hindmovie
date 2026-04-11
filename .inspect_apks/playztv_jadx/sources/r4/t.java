package r4;

import android.os.Looper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pe.c f11492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f11493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h.o f11494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f11495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f11496e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11497g;
    public final kc.b f = new kc.b(new s(0, this, t.class, "onClosed", "onClosed()V", 0, 0));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ThreadLocal f11498h = new ThreadLocal();
    public final LinkedHashMap i = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11499j = true;

    public final void a() {
        if (this.f11497g) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        if (k() && !l() && this.f11498h.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public abstract g c();

    public androidx.emoji2.text.h d() {
        throw new nd.e(0);
    }

    public z4.b e(a aVar) {
        be.h.e(aVar, "config");
        throw new nd.e(0);
    }

    public List f(LinkedHashMap linkedHashMap) {
        return od.q.f9570u;
    }

    public final g g() {
        g gVar = this.f11496e;
        if (gVar != null) {
            return gVar;
        }
        be.h.i("internalTracker");
        throw null;
    }

    public final z4.b h() {
        p pVar = this.f11495d;
        if (pVar == null) {
            be.h.i("connectionManager");
            throw null;
        }
        z4.b bVarC = pVar.c();
        if (bVarC != null) {
            return bVarC;
        }
        throw new IllegalStateException("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
    }

    public Set i() {
        return od.s.f9572u;
    }

    public Map j() {
        return od.r.f9571u;
    }

    public final boolean k() {
        p pVar = this.f11495d;
        if (pVar != null) {
            return pVar.c() != null;
        }
        be.h.i("connectionManager");
        throw null;
    }

    public final boolean l() {
        return o() && h().Z().D();
    }

    public final void m() {
        h().Z().e();
        if (l()) {
            return;
        }
        g gVarG = g();
        gVarG.f11446b.e(gVarG.f11449e, gVarG.f);
    }

    public final void n(y4.a aVar) throws Exception {
        be.h.e(aVar, "connection");
        g gVarG = g();
        g0 g0Var = gVarG.f11446b;
        g0Var.getClass();
        y4.c cVarE0 = aVar.e0("PRAGMA query_only");
        try {
            cVarE0.W();
            boolean zO = cVarE0.O();
            cf.d.g(cVarE0, null);
            if (!zO) {
                android.support.v4.media.session.b.o(aVar, "PRAGMA temp_store = MEMORY");
                android.support.v4.media.session.b.o(aVar, "PRAGMA recursive_triggers = 1");
                android.support.v4.media.session.b.o(aVar, "DROP TABLE IF EXISTS room_table_modification_log");
                if (g0Var.f11454c) {
                    android.support.v4.media.session.b.o(aVar, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                } else {
                    android.support.v4.media.session.b.o(aVar, ie.n.K("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", ""));
                }
                a2.c cVar = g0Var.f11457g;
                ReentrantLock reentrantLock = (ReentrantLock) cVar.f173v;
                reentrantLock.lock();
                try {
                    cVar.f172u = true;
                } finally {
                    reentrantLock.unlock();
                }
            }
            synchronized (gVarG.f11450g) {
            }
        } finally {
        }
    }

    public final boolean o() {
        p pVar = this.f11495d;
        if (pVar == null) {
            be.h.i("connectionManager");
            throw null;
        }
        z4.a aVar = pVar.f11473g;
        if (aVar != null) {
            return aVar.isOpen();
        }
        return false;
    }
}
