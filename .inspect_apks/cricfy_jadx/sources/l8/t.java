package l8;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f7920e;

    public /* synthetic */ t(p pVar) {
        super(false, null, null);
        this.f7920e = pVar;
    }

    @Override // l8.u
    public final String a() {
        try {
            return (String) this.f7920e.call();
        } catch (Exception e9) {
            throw new RuntimeException(e9);
        }
    }
}
