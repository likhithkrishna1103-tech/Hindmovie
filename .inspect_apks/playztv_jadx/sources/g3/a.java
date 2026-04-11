package g3;

import p1.i0;
import p1.k0;
import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4946b;

    public a(String str, int i) {
        this.f4945a = i;
        this.f4946b = str;
    }

    @Override // p1.k0
    public final /* synthetic */ q b() {
        return null;
    }

    @Override // p1.k0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Ait(controlCode=");
        sb2.append(this.f4945a);
        sb2.append(",url=");
        return l4.a.o(sb2, this.f4946b, ")");
    }

    @Override // p1.k0
    public final /* synthetic */ void a(i0 i0Var) {
    }
}
