package d1;

import java.io.FileInputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 extends xd.c {
    public /* synthetic */ Object A;
    public final /* synthetic */ j0 B;
    public int C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f3247y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public FileInputStream f3248z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(j0 j0Var, xd.c cVar) {
        super(cVar);
        this.B = j0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.A = obj;
        this.C |= Integer.MIN_VALUE;
        return j0.a(this.B, this);
    }
}
