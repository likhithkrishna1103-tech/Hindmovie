package n6;

import g6.w;
import i6.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m6.a f8833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8834d;

    public n(String str, int i, m6.a aVar, boolean z10) {
        this.f8831a = str;
        this.f8832b = i;
        this.f8833c = aVar;
        this.f8834d = z10;
    }

    @Override // n6.b
    public final i6.d a(w wVar, g6.i iVar, o6.a aVar) {
        return new s(wVar, aVar, this);
    }

    public final String toString() {
        return "ShapePath{name=" + this.f8831a + ", index=" + this.f8832b + '}';
    }
}
