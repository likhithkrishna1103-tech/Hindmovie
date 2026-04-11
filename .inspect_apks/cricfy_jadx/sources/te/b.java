package te;

import rd.l;
import se.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public z[] f12017v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12018w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12019x;

    public abstract z a();

    public abstract z[] b();

    public final void c(z zVar) {
        int i;
        vd.c[] cVarArr;
        synchronized (this) {
            try {
                int i10 = this.f12018w - 1;
                this.f12018w = i10;
                if (i10 == 0) {
                    this.f12019x = 0;
                }
                ge.i.c(zVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                zVar.getClass();
                zVar.f11722a.set(null);
                cVarArr = c.f12020a;
            } catch (Throwable th) {
                throw th;
            }
        }
        for (vd.c cVar : cVarArr) {
            if (cVar != null) {
                cVar.i(l.f11003a);
            }
        }
    }
}
