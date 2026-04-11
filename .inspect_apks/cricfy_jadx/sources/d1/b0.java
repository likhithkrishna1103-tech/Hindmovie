package d1;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends xd.h implements fe.p {
    public int A;
    public /* synthetic */ boolean B;
    public final /* synthetic */ h0 C;
    public final /* synthetic */ int D;
    public Object E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f3208z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(h0 h0Var, int i, vd.c cVar, int i10) {
        super(2, cVar);
        this.f3208z = i10;
        this.C = h0Var;
        this.D = i;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        int i = this.f3208z;
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        vd.c cVar = (vd.c) obj2;
        switch (i) {
        }
        return ((b0) m(bool, cVar)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f3208z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = new b0(this.C, this.D, cVar, 0);
                b0Var.B = ((Boolean) obj).booleanValue();
                return b0Var;
            default:
                b0 b0Var2 = new b0(this.C, this.D, cVar, 1);
                b0Var2.B = ((Boolean) obj).booleanValue();
                return b0Var2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.b0.o(java.lang.Object):java.lang.Object");
    }
}
