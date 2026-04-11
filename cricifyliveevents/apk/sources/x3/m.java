package x3;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends e2.h implements g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public g f14311v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f14312w;

    @Override // x3.g
    public final int a(long j4) {
        g gVar = this.f14311v;
        gVar.getClass();
        return gVar.a(j4 - this.f14312w);
    }

    @Override // e2.h, e2.a
    public final void clear() {
        super.clear();
        this.f14311v = null;
    }

    @Override // x3.g
    public final long e(int i) {
        g gVar = this.f14311v;
        gVar.getClass();
        return gVar.e(i) + this.f14312w;
    }

    @Override // x3.g
    public final List i(long j4) {
        g gVar = this.f14311v;
        gVar.getClass();
        return gVar.i(j4 - this.f14312w);
    }

    @Override // x3.g
    public final int j() {
        g gVar = this.f14311v;
        gVar.getClass();
        return gVar.j();
    }
}
