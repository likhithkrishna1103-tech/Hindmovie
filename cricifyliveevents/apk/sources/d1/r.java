package d1;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends xd.h implements fe.q {
    public int A;
    public /* synthetic */ Object B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f3294z = 1;

    public /* synthetic */ r(int i, vd.c cVar) {
        super(i, cVar);
    }

    @Override // fe.q
    public final Object g(Object obj, Object obj2, Object obj3) {
        switch (this.f3294z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new r((h0) this.B, (vd.c) obj3).o(rd.l.f11003a);
            default:
                ((Boolean) obj2).getClass();
                r rVar = new r(3, (vd.c) obj3);
                rVar.B = (j0) obj;
                return rVar.o(rd.l.f11003a);
        }
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        switch (this.f3294z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.A;
                if (i == 0) {
                    com.bumptech.glide.c.C(obj);
                    h0 h0Var = (h0) this.B;
                    this.A = 1;
                    Object objC = h0.c(h0Var, this);
                    wd.a aVar = wd.a.f14143v;
                    if (objC == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                }
                return rd.l.f11003a;
            default:
                int i10 = this.A;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                    return obj;
                }
                com.bumptech.glide.c.C(obj);
                j0 j0Var = (j0) this.B;
                this.A = 1;
                j0Var.getClass();
                Object objA = j0.a(j0Var, this);
                wd.a aVar2 = wd.a.f14143v;
                return objA == aVar2 ? aVar2 : objA;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(h0 h0Var, vd.c cVar) {
        super(3, cVar);
        this.B = h0Var;
    }
}
