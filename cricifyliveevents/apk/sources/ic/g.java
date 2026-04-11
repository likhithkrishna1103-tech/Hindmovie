package ic;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.i f6432a;

    public g(j9.i iVar) {
        this.f6432a = iVar;
    }

    @Override // ic.i
    public final boolean a(jc.b bVar) {
        int i = bVar.f6737b;
        if (i != 3 && i != 4 && i != 5) {
            return false;
        }
        this.f6432a.c(bVar.f6736a);
        return true;
    }

    @Override // ic.i
    public final boolean b(Exception exc) {
        return false;
    }
}
