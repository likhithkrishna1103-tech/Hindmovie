package l5;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7783a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f7784b;

    public d(ViewGroup viewGroup) {
        this.f7784b = viewGroup;
    }

    @Override // l5.o, l5.l
    public final void a(n nVar) {
        ab.b.E(this.f7784b, false);
        this.f7783a = true;
    }

    @Override // l5.l
    public final void b(n nVar) {
        if (!this.f7783a) {
            ab.b.E(this.f7784b, false);
        }
        nVar.x(this);
    }

    @Override // l5.o, l5.l
    public final void c() {
        ab.b.E(this.f7784b, false);
    }

    @Override // l5.o, l5.l
    public final void f() {
        ab.b.E(this.f7784b, true);
    }
}
