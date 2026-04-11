package ue;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f13052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ byte[] f13054c;

    public u(q qVar, int i, byte[] bArr) {
        this.f13052a = qVar;
        this.f13053b = i;
        this.f13054c = bArr;
    }

    @Override // ue.v
    public final long c() {
        return this.f13053b;
    }

    @Override // ue.v
    public final q d() {
        return this.f13052a;
    }

    @Override // ue.v
    public final void n(hf.p pVar) {
        byte[] bArr = this.f13054c;
        be.h.e(bArr, "source");
        if (pVar.f6139w) {
            throw new IllegalStateException("closed");
        }
        pVar.f6138v.g0(this.f13053b, bArr);
        pVar.a();
    }
}
