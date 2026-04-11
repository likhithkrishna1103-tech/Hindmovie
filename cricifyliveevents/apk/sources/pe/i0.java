package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements s0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f10239v;

    public i0(boolean z10) {
        this.f10239v = z10;
    }

    @Override // pe.s0
    public final boolean a() {
        return this.f10239v;
    }

    @Override // pe.s0
    public final d1 d() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f10239v ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
