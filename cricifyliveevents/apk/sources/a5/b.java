package a5;

import fe.l;
import fe.p;
import w4.c0;
import w4.d0;
import w4.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends xd.h implements p {
    public int A;
    public /* synthetic */ Object B;
    public final /* synthetic */ boolean C;
    public final /* synthetic */ boolean D;
    public final /* synthetic */ t E;
    public final /* synthetic */ l F;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c0 f269z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(l lVar, vd.c cVar, t tVar, boolean z10, boolean z11) {
        super(2, cVar);
        this.C = z10;
        this.D = z11;
        this.E = tVar;
        this.F = lVar;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        return ((b) m((d0) obj, (vd.c) obj2)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        b bVar = new b(this.F, cVar, this.E, this.C, this.D);
        bVar.B = obj;
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5 A[PHI: r0 r11
      0x00a5: PHI (r0v12 w4.d0) = (r0v9 w4.d0), (r0v19 w4.d0) binds: [B:37:0x00a2, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]
      0x00a5: PHI (r11v20 java.lang.Object) = (r11v18 java.lang.Object), (r11v0 java.lang.Object) binds: [B:37:0x00a2, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cb A[RETURN] */
    @Override // xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.b.o(java.lang.Object):java.lang.Object");
    }
}
