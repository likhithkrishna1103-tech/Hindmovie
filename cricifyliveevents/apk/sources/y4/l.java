package y4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends xd.h implements fe.l {
    public final /* synthetic */ String A;
    public final /* synthetic */ fe.l B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ n f14864z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(n nVar, String str, fe.l lVar, vd.c cVar) {
        super(1, cVar);
        this.f14864z = nVar;
        this.A = str;
        this.B = lVar;
    }

    @Override // fe.l
    public final Object a(Object obj) {
        String str = this.A;
        fe.l lVar = this.B;
        return new l(this.f14864z, str, lVar, (vd.c) obj).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final Object o(Object obj) throws Exception {
        com.bumptech.glide.c.C(obj);
        c5.c cVarC0 = this.f14864z.f14867b.c0(this.A);
        try {
            Object objA = this.B.a(cVarC0);
            android.support.v4.media.session.b.d(cVarC0, null);
            return objA;
        } finally {
        }
    }
}
