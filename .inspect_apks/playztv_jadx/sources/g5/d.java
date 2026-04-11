package g5;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5260a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f5261b;

    public d(ViewGroup viewGroup) {
        this.f5261b = viewGroup;
    }

    @Override // g5.q, g5.n
    public final void b(p pVar) {
        b8.h.F(this.f5261b, false);
        this.f5260a = true;
    }

    @Override // g5.q, g5.n
    public final void c() {
        b8.h.F(this.f5261b, false);
    }

    @Override // g5.q, g5.n
    public final void d() {
        b8.h.F(this.f5261b, true);
    }

    @Override // g5.n
    public final void e(p pVar) {
        if (!this.f5260a) {
            b8.h.F(this.f5261b, false);
        }
        pVar.x(this);
    }
}
