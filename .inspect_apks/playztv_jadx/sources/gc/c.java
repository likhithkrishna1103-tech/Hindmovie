package gc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends androidx.fragment.app.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ic.k f5372c;

    public c(ic.k kVar) {
        this.f5372c = kVar;
    }

    @Override // androidx.fragment.app.h
    public final int j(int i) {
        ic.k kVar = this.f5372c;
        return (i == kVar.i && kVar.h()) ? 3 : 1;
    }
}
