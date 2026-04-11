package x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends h {
    public final /* synthetic */ k C;

    public j(k kVar) {
        this.C = kVar;
    }

    @Override // x.h
    public final String g() {
        i iVar = (i) this.C.f14205v.get();
        if (iVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + iVar.f14201a + "]";
    }
}
