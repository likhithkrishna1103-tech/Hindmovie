package ke;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class x0 extends d1 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f7748w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(v0 v0Var) {
        super(true);
        boolean z2 = true;
        C(v0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d1.f7687v;
        j jVar = (j) atomicReferenceFieldUpdater.get(this);
        k kVar = jVar instanceof k ? (k) jVar : null;
        if (kVar == null) {
            z2 = false;
            break;
        }
        d1 d1VarJ = kVar.j();
        while (!d1VarJ.w()) {
            j jVar2 = (j) atomicReferenceFieldUpdater.get(d1VarJ);
            k kVar2 = jVar2 instanceof k ? (k) jVar2 : null;
            if (kVar2 == null) {
                z2 = false;
                break;
            }
            d1VarJ = kVar2.j();
        }
        this.f7748w = z2;
    }

    @Override // ke.d1
    public final boolean w() {
        return this.f7748w;
    }

    @Override // ke.d1
    public final boolean y() {
        return true;
    }
}
