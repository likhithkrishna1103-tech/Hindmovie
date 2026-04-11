package d1;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends xd.h implements fe.p {
    public final /* synthetic */ z0 A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f3309z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v0(z0 z0Var, vd.c cVar, int i) {
        super(2, cVar);
        this.f3309z = i;
        this.A = z0Var;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        pe.v vVar = (pe.v) obj;
        vd.c cVar = (vd.c) obj2;
        switch (this.f3309z) {
        }
        return ((v0) m(vVar, cVar)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f3309z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new v0(this.A, cVar, 0);
            default:
                return new v0(this.A, cVar, 1);
        }
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f3309z;
        com.bumptech.glide.c.C(obj);
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new Integer(g1.f3232b.nativeGetCounterValue(((g1) this.A.i.getValue()).f3233a));
            default:
                return new Integer(g1.f3232b.nativeIncrementAndGetCounterValue(((g1) this.A.i.getValue()).f3233a));
        }
    }
}
