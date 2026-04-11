package n6;

import g6.w;
import i6.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m6.b f8844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m6.b f8845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m6.b f8846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f8847e;

    public p(String str, int i, m6.b bVar, m6.b bVar2, m6.b bVar3, boolean z10) {
        this.f8843a = i;
        this.f8844b = bVar;
        this.f8845c = bVar2;
        this.f8846d = bVar3;
        this.f8847e = z10;
    }

    @Override // n6.b
    public final i6.d a(w wVar, g6.i iVar, o6.a aVar) {
        return new u(aVar, this);
    }

    public final String toString() {
        return "Trim Path: {start: " + this.f8844b + ", end: " + this.f8845c + ", offset: " + this.f8846d + "}";
    }
}
