package ic;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f6430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j9.i f6431b;

    public f(j jVar, j9.i iVar) {
        this.f6430a = jVar;
        this.f6431b = iVar;
    }

    @Override // ic.i
    public final boolean a(jc.b bVar) {
        if (bVar.f6737b != 4 || this.f6430a.a(bVar)) {
            return false;
        }
        String str = bVar.f6738c;
        if (str == null) {
            throw new NullPointerException("Null token");
        }
        long j4 = bVar.f6740e;
        long j7 = bVar.f;
        byte b8 = (byte) (((byte) 1) | 2);
        if (b8 == 3) {
            this.f6431b.a(new a(j4, j7, str));
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if ((b8 & 1) == 0) {
            sb.append(" tokenExpirationTimestamp");
        }
        if ((b8 & 2) == 0) {
            sb.append(" tokenCreationTimestamp");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }

    @Override // ic.i
    public final boolean b(Exception exc) {
        this.f6431b.b(exc);
        return true;
    }
}
