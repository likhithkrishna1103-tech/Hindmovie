package vc;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends xd.h implements fe.p {
    public /* synthetic */ Object A;
    public final /* synthetic */ a1 B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f13715z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y0(a1 a1Var, vd.c cVar, int i) {
        super(2, cVar);
        this.f13715z = i;
        this.B = a1Var;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        g0 g0Var = (g0) obj;
        vd.c cVar = (vd.c) obj2;
        switch (this.f13715z) {
        }
        return ((y0) m(g0Var, cVar)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f13715z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                y0 y0Var = new y0(this.B, cVar, 0);
                y0Var.A = obj;
                return y0Var;
            default:
                y0 y0Var2 = new y0(this.B, cVar, 1);
                y0Var2.A = obj;
                return y0Var2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    @Override // xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.y0.o(java.lang.Object):java.lang.Object");
    }
}
