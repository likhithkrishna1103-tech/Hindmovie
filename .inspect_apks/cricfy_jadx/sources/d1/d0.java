package d1;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends xd.h implements fe.l {
    public int A;
    public final /* synthetic */ h0 B;
    public Object C;
    public final /* synthetic */ Object D;
    public final /* synthetic */ Serializable E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f3219z = 1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d0(h0 h0Var, vd.h hVar, fe.p pVar, vd.c cVar) {
        super(1, cVar);
        this.B = h0Var;
        this.D = hVar;
        this.E = (xd.h) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [fe.p, xd.h] */
    @Override // fe.l
    public final Object a(Object obj) {
        vd.c cVar = (vd.c) obj;
        switch (this.f3219z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new d0((ge.p) this.D, this.B, (ge.o) this.E, cVar).o(rd.l.f11003a);
            default:
                return new d0(this.B, (vd.h) this.D, (fe.p) this.E, cVar).o(rd.l.f11003a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARN: Type inference failed for: r7v3, types: [fe.p, xd.h] */
    @Override // xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.d0.o(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(ge.p pVar, h0 h0Var, ge.o oVar, vd.c cVar) {
        super(1, cVar);
        this.D = pVar;
        this.B = h0Var;
        this.E = oVar;
    }
}
