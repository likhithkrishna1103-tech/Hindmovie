package q5;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends androidx.fragment.app.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s5.i f10367c;

    public c(s5.i iVar) {
        this.f10367c = iVar;
    }

    @Override // androidx.fragment.app.h
    public final int j(int i) {
        s5.i iVar = this.f10367c;
        return (i == iVar.i && iVar.i()) ? 3 : 1;
    }
}
