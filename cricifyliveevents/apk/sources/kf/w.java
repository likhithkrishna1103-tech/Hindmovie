package kf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f7577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ byte[] f7579d;

    public w(s sVar, int i, byte[] bArr) {
        this.f7577b = sVar;
        this.f7578c = i;
        this.f7579d = bArr;
    }

    @Override // kf.x
    public final long a() {
        return this.f7578c;
    }

    @Override // kf.x
    public final s b() {
        return this.f7577b;
    }

    @Override // kf.x
    public final void d(ag.p pVar) {
        byte[] bArr = this.f7579d;
        ge.i.e(bArr, "source");
        if (pVar.f458x) {
            throw new IllegalStateException("closed");
        }
        pVar.f457w.e0(this.f7578c, bArr);
        pVar.a();
    }
}
