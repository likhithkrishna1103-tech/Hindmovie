package w4;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f14015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f14016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rd.j f14017c;

    public z(t tVar) {
        ge.i.e(tVar, "database");
        this.f14015a = tVar;
        this.f14016b = new AtomicBoolean(false);
        this.f14017c = new rd.j(new c.d0(10, this));
    }

    public final e5.j a() {
        this.f14015a.a();
        return this.f14016b.compareAndSet(false, true) ? (e5.j) this.f14017c.getValue() : b();
    }

    public final e5.j b() {
        String strC = c();
        t tVar = this.f14015a;
        tVar.getClass();
        tVar.a();
        tVar.b();
        return tVar.j().Y().p(strC);
    }

    public abstract String c();

    public final void d(e5.j jVar) {
        ge.i.e(jVar, "statement");
        if (jVar == ((e5.j) this.f14017c.getValue())) {
            this.f14016b.set(false);
        }
    }
}
