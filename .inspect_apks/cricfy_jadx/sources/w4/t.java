package w4;

import android.os.Looper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ue.c f13990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f13991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h.o f13992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b0.e f13993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f13994e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13995g;
    public final l7.a f = new l7.a(new s(0, this, t.class, "onClosed", "onClosed()V", 0, 0));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ThreadLocal f13996h = new ThreadLocal();
    public final LinkedHashMap i = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13997j = true;

    public final void a() {
        if (this.f13995g) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        if (!m() || n()) {
            return;
        }
        vd.h hVar = (vd.h) this.f13996h.get();
        if ((hVar != null ? (b0) hVar.C(b0.f13922w) : null) != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public final void c() {
        a();
        a();
        d5.b bVarY = j().Y();
        if (!bVarY.c()) {
            n5.a.J(new r4.a(i(), null, 1));
        }
        if (bVarY.G()) {
            bVarY.P();
        } else {
            bVarY.i();
        }
    }

    public abstract g d();

    public androidx.emoji2.text.h e() {
        throw new rd.e(0);
    }

    public d5.d f(a aVar) {
        ge.i.e(aVar, "config");
        throw new rd.e(0);
    }

    public final void g() {
        j().Y().h();
        if (n()) {
            return;
        }
        g gVarI = i();
        gVarI.f13937b.e(gVarI.f13940e, gVarI.f);
    }

    public List h(LinkedHashMap linkedHashMap) {
        return sd.p.f11669v;
    }

    public final g i() {
        g gVar = this.f13994e;
        if (gVar != null) {
            return gVar;
        }
        ge.i.i("internalTracker");
        throw null;
    }

    public final d5.d j() {
        b0.e eVar = this.f13993d;
        if (eVar == null) {
            ge.i.i("connectionManager");
            throw null;
        }
        d5.d dVar = (d5.d) eVar.f1600g;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalStateException("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
    }

    public Set k() {
        return sd.r.f11671v;
    }

    public Map l() {
        return sd.q.f11670v;
    }

    public final boolean m() {
        b0.e eVar = this.f13993d;
        if (eVar != null) {
            return ((d5.d) eVar.f1600g) != null;
        }
        ge.i.i("connectionManager");
        throw null;
    }

    public final boolean n() {
        return p() && j().Y().c();
    }

    public final void o(c5.a aVar) throws Exception {
        ge.i.e(aVar, "connection");
        g gVarI = i();
        l0 l0Var = gVarI.f13937b;
        l0Var.getClass();
        c5.c cVarC0 = aVar.c0("PRAGMA query_only");
        try {
            cVarC0.V();
            boolean zL = cVarC0.L();
            android.support.v4.media.session.b.d(cVarC0, null);
            if (!zL) {
                android.support.v4.media.session.b.k(aVar, "PRAGMA temp_store = MEMORY");
                android.support.v4.media.session.b.k(aVar, "PRAGMA recursive_triggers = 1");
                android.support.v4.media.session.b.k(aVar, "DROP TABLE IF EXISTS room_table_modification_log");
                if (l0Var.f13964c) {
                    android.support.v4.media.session.b.k(aVar, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                } else {
                    android.support.v4.media.session.b.k(aVar, ne.o.X("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", ""));
                }
                k kVar = l0Var.f13967g;
                ReentrantLock reentrantLock = kVar.f13955a;
                reentrantLock.lock();
                try {
                    kVar.f13958d = true;
                } finally {
                    reentrantLock.unlock();
                }
            }
            synchronized (gVarI.f13941g) {
            }
        } finally {
        }
    }

    public final boolean p() {
        b0.e eVar = this.f13993d;
        if (eVar == null) {
            ge.i.i("connectionManager");
            throw null;
        }
        d5.b bVar = (d5.b) eVar.f1601h;
        if (bVar != null) {
            return bVar.isOpen();
        }
        return false;
    }
}
