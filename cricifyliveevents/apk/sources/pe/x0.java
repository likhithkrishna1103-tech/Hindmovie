package pe;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class x0 extends c1 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f10289x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(v0 v0Var) {
        super(true);
        boolean z10 = true;
        I(v0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c1.f10227w;
        k kVar = (k) atomicReferenceFieldUpdater.get(this);
        l lVar = kVar instanceof l ? (l) kVar : null;
        if (lVar == null) {
            z10 = false;
            break;
        }
        c1 c1VarJ = lVar.j();
        while (!c1VarJ.D()) {
            k kVar2 = (k) atomicReferenceFieldUpdater.get(c1VarJ);
            l lVar2 = kVar2 instanceof l ? (l) kVar2 : null;
            if (lVar2 == null) {
                z10 = false;
                break;
            }
            c1VarJ = lVar2.j();
        }
        this.f10289x = z10;
    }

    @Override // pe.c1
    public final boolean D() {
        return this.f10289x;
    }

    @Override // pe.c1
    public final boolean E() {
        return true;
    }
}
