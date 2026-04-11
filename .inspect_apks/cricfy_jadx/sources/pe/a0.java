package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class a0 extends a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f10216y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(vd.h hVar, boolean z10, int i) {
        super(hVar, z10);
        this.f10216y = i;
    }

    @Override // pe.c1
    public boolean G(Throwable th) {
        switch (this.f10216y) {
            case 1:
                x.i(th, this.f10215x);
                return true;
            default:
                return super.G(th);
        }
    }
}
