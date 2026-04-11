package o8;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f9688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f9690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f9692e;
    public final /* synthetic */ e f;

    public p(e eVar, int i, Bundle bundle) {
        this.f = eVar;
        Boolean bool = Boolean.TRUE;
        this.f9690c = eVar;
        this.f9688a = bool;
        this.f9689b = false;
        this.f9691d = i;
        this.f9692e = bundle;
    }

    public abstract boolean a();

    public abstract void b(l8.b bVar);

    public final void c() {
        d();
        e eVar = this.f9690c;
        synchronized (eVar.f9630l) {
            eVar.f9630l.remove(this);
        }
    }

    public final void d() {
        synchronized (this) {
            this.f9688a = null;
        }
    }
}
