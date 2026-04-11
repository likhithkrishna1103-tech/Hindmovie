package androidx.fragment.app;

import android.os.Handler;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z extends ga.b implements androidx.lifecycle.u0, androidx.lifecycle.s, x4.d, r0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h.j f1422u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h.j f1423v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f1424w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final n0 f1425x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ h.j f1426y;

    public z(h.j jVar) {
        this.f1426y = jVar;
        Handler handler = new Handler();
        this.f1425x = new n0();
        this.f1422u = jVar;
        this.f1423v = jVar;
        this.f1424w = handler;
    }

    @Override // x4.d
    public final n.s a() {
        return (n.s) this.f1426y.f2184x.f2861v;
    }

    @Override // androidx.lifecycle.u0
    public final androidx.lifecycle.t0 e() {
        return this.f1426y.e();
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        return this.f1426y.Q;
    }

    @Override // ga.b
    public final View v(int i) {
        return this.f1426y.findViewById(i);
    }

    @Override // ga.b
    public final boolean w() {
        Window window = this.f1426y.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.fragment.app.r0
    public final void b() {
    }
}
