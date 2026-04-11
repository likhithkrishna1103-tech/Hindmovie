package r4;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f11509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f11510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nd.i f11511c;

    public w(t tVar) {
        be.h.e(tVar, "database");
        this.f11509a = tVar;
        this.f11510b = new AtomicBoolean(false);
        this.f11511c = new nd.i(new a5.e(5, this));
    }

    public final a5.l a() {
        this.f11509a.a();
        return this.f11510b.compareAndSet(false, true) ? (a5.l) this.f11511c.getValue() : b();
    }

    public final a5.l b() {
        String strC = c();
        t tVar = this.f11509a;
        tVar.getClass();
        tVar.a();
        tVar.b();
        return tVar.h().Z().r(strC);
    }

    public abstract String c();

    public final void d(a5.l lVar) {
        be.h.e(lVar, "statement");
        if (lVar == ((a5.l) this.f11511c.getValue())) {
            this.f11510b.set(false);
        }
    }
}
