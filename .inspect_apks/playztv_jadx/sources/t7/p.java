package t7;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f12328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f12330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f12332e;
    public final /* synthetic */ e f;

    public p(e eVar, int i, Bundle bundle) {
        this.f = eVar;
        Boolean bool = Boolean.TRUE;
        this.f12330c = eVar;
        this.f12328a = bool;
        this.f12329b = false;
        this.f12331d = i;
        this.f12332e = bundle;
    }

    public abstract void a(q7.b bVar);

    public abstract boolean b();

    public final void c() {
        synchronized (this) {
            this.f12328a = null;
        }
    }

    public final void d() {
        c();
        synchronized (this.f12330c.f12275l) {
            this.f12330c.f12275l.remove(this);
        }
    }
}
