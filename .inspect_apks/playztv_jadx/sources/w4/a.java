package w4;

import ae.l;
import ae.p;
import nd.k;
import r4.t;
import r4.x;
import r4.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends td.g implements p {
    public /* synthetic */ Object A;
    public final /* synthetic */ boolean B;
    public final /* synthetic */ boolean C;
    public final /* synthetic */ t D;
    public final /* synthetic */ l E;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public x f13711y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13712z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(l lVar, t tVar, rd.c cVar, boolean z2, boolean z10) {
        super(2, cVar);
        this.B = z2;
        this.C = z10;
        this.D = tVar;
        this.E = lVar;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        return ((a) m((y) obj, (rd.c) obj2)).o(k.f8990a);
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        a aVar = new a(this.E, this.D, cVar, this.B, this.C);
        aVar.A = obj;
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5 A[PHI: r0 r12
      0x00b5: PHI (r0v12 r4.y) = (r0v9 r4.y), (r0v19 r4.y) binds: [B:42:0x00b2, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]
      0x00b5: PHI (r12v20 java.lang.Object) = (r12v18 java.lang.Object), (r12v0 java.lang.Object) binds: [B:42:0x00b2, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00db A[RETURN] */
    @Override // td.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.a.o(java.lang.Object):java.lang.Object");
    }
}
