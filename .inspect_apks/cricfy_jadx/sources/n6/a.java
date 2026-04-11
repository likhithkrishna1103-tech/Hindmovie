package n6;

import g6.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m6.f f8775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m6.a f8776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f8778e;

    public a(String str, m6.f fVar, m6.a aVar, boolean z10, boolean z11) {
        this.f8774a = str;
        this.f8775b = fVar;
        this.f8776c = aVar;
        this.f8777d = z10;
        this.f8778e = z11;
    }

    @Override // n6.b
    public final i6.d a(w wVar, g6.i iVar, o6.a aVar) {
        return new i6.g(wVar, aVar, this);
    }
}
