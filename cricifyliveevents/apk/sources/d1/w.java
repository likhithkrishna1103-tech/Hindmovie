package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends xd.c {
    public pe.n A;
    public /* synthetic */ Object B;
    public final /* synthetic */ h0 C;
    public int D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f3310y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public h0 f3311z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(h0 h0Var, xd.c cVar) {
        super(cVar);
        this.C = h0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.B = obj;
        this.D |= Integer.MIN_VALUE;
        return h0.d(this.C, null, this);
    }
}
