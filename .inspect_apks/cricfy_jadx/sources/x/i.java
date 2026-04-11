package x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f14201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f14202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f14203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14204d;

    public final void finalize() {
        l lVar;
        k kVar = this.f14202b;
        if (kVar != null) {
            j jVar = kVar.f14206w;
            if (!jVar.isDone()) {
                jVar.k(new b(1, "The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f14201a));
            }
        }
        if (this.f14204d || (lVar = this.f14203c) == null) {
            return;
        }
        lVar.j(null);
    }
}
