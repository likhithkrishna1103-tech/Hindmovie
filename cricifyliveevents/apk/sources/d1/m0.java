package d1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends xd.c {
    public boolean A;
    public /* synthetic */ Object B;
    public final /* synthetic */ o0 C;
    public int D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public o0 f3273y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public j0 f3274z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(o0 o0Var, xd.c cVar) {
        super(cVar);
        this.C = o0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.B = obj;
        this.D |= Integer.MIN_VALUE;
        return this.C.a(null, this);
    }
}
