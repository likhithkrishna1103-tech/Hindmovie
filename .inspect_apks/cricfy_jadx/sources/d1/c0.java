package d1;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends xd.c {
    public Serializable A;
    public ge.p B;
    public boolean C;
    public int D;
    public /* synthetic */ Object E;
    public final /* synthetic */ h0 F;
    public int G;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f3212y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f3213z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(h0 h0Var, xd.c cVar) {
        super(cVar);
        this.F = h0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.E = obj;
        this.G |= Integer.MIN_VALUE;
        return h0.g(this.F, false, this);
    }
}
