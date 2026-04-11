package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class a0 extends a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f7674x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(rd.h hVar, boolean z2, int i) {
        super(hVar, z2);
        this.f7674x = i;
    }

    @Override // ke.d1
    public boolean A(Throwable th) {
        switch (this.f7674x) {
            case 1:
                x.h(th, this.f7673w);
                return true;
            default:
                return super.A(th);
        }
    }
}
