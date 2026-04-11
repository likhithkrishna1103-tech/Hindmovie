package cc;

import android.net.Uri;
import android.view.InputEvent;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends td.g implements ae.p {
    public Object A;
    public final /* synthetic */ Object B;
    public final /* synthetic */ Object C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f2670y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2671z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(be.n nVar, t4.h hVar, rd.c cVar) {
        super(2, cVar);
        this.f2670y = 2;
        this.B = nVar;
        this.C = hVar;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        ke.u uVar = (ke.u) obj;
        rd.c cVar = (rd.c) obj2;
        switch (this.f2670y) {
        }
        return ((l) m(uVar, cVar)).o(nd.k.f8990a);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [ae.p, td.g] */
    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        switch (this.f2670y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new l((m) this.A, (rd.h) this.B, (u0) this.C, cVar, 0);
            case 1:
                return new l((m4.a) this.A, (Uri) this.B, (InputEvent) this.C, cVar, 1);
            case 2:
                return new l((be.n) this.B, (t4.h) this.C, cVar);
            default:
                l lVar = new l((ke.m) this.B, (ae.p) this.C, cVar);
                lVar.A = obj;
                return lVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0134 A[PHI: r10
      0x0134: PHI (r10v20 java.lang.Boolean) = (r10v11 java.lang.Boolean), (r10v13 java.lang.Boolean) binds: [B:73:0x0132, B:76:0x013f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014c  */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r2v20, types: [ae.p, td.g] */
    @Override // td.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.l.o(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(Object obj, Object obj2, Object obj3, rd.c cVar, int i) {
        super(2, cVar);
        this.f2670y = i;
        this.A = obj;
        this.B = obj2;
        this.C = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public l(ke.m mVar, ae.p pVar, rd.c cVar) {
        super(2, cVar);
        this.f2670y = 3;
        this.B = mVar;
        this.C = (td.g) pVar;
    }
}
