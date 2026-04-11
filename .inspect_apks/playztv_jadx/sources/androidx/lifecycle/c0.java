package androidx.lifecycle;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements s {
    public static final c0 C = new c0();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1449u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1450v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Handler f1453y;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1451w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1452x = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final u f1454z = new u(this);
    public final a2.a A = new a2.a(5, this);
    public final rc.b B = new rc.b(3, this);

    public final void b() {
        int i = this.f1450v + 1;
        this.f1450v = i;
        if (i == 1) {
            if (this.f1451w) {
                this.f1454z.d(m.ON_RESUME);
                this.f1451w = false;
            } else {
                Handler handler = this.f1453y;
                be.h.b(handler);
                handler.removeCallbacks(this.A);
            }
        }
    }

    @Override // androidx.lifecycle.s
    public final u f() {
        return this.f1454z;
    }
}
