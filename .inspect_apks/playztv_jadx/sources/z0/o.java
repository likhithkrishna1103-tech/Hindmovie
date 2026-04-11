package z0;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends td.g implements ae.p {
    public /* synthetic */ Object A;
    public final /* synthetic */ a0 B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f14772y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f14773z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(a0 a0Var, rd.c cVar, int i) {
        super(2, cVar);
        this.f14772y = i;
        this.B = a0Var;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        switch (this.f14772y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((o) m((l) obj, (rd.c) obj2)).o(nd.k.f8990a);
            default:
                return ((o) m((ne.c) obj, (rd.c) obj2)).o(nd.k.f8990a);
        }
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        switch (this.f14772y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                o oVar = new o(this.B, cVar, 0);
                oVar.A = obj;
                return oVar;
            default:
                o oVar2 = new o(this.B, cVar, 1);
                oVar2.A = obj;
                return oVar2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // td.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.o.o(java.lang.Object):java.lang.Object");
    }
}
