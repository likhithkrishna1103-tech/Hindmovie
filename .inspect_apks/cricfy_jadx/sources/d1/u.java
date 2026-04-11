package d1;

import android.net.Uri;
import android.view.InputEvent;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends xd.h implements fe.p {
    public int A;
    public /* synthetic */ Object B;
    public final /* synthetic */ Object C;
    public Object D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f3304z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public u(h0 h0Var, fe.p pVar, vd.c cVar) {
        super(2, cVar);
        this.f3304z = 1;
        this.C = h0Var;
        this.D = (xd.h) pVar;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        switch (this.f3304z) {
        }
        return ((u) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [fe.p, xd.h] */
    /* JADX WARN: Type inference failed for: r2v2, types: [fe.p, xd.h] */
    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f3304z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = new u((h0) this.C, cVar, 0);
                uVar.B = obj;
                return uVar;
            case 1:
                u uVar2 = new u((h0) this.C, (fe.p) this.D, cVar);
                uVar2.B = obj;
                return uVar2;
            case 2:
                u uVar3 = new u((File) this.C, cVar, 2);
                uVar3.B = obj;
                return uVar3;
            case 3:
                return new u((r4.b) this.D, (Uri) this.B, (InputEvent) this.C, cVar, 3);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                u uVar4 = new u((se.d) this.D, (se.b) this.C, cVar);
                uVar4.B = obj;
                return uVar4;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                u uVar5 = new u((w4.l0) this.C, cVar, 5);
                uVar5.B = obj;
                return uVar5;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return new u((xb.c) this.D, (h1.e) this.B, (Long) this.C, cVar, 6);
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return new u((ge.p) this.B, (y4.s) this.C, cVar);
            default:
                u uVar6 = new u((pe.n) this.D, (fe.p) this.C, cVar);
                uVar6.B = obj;
                return uVar6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v7, types: [fe.p, xd.h] */
    /* JADX WARN: Type inference failed for: r9v9, types: [fe.p, xd.h] */
    @Override // xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1132
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.u.o(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(ge.p pVar, y4.s sVar, vd.c cVar) {
        super(2, cVar);
        this.f3304z = 7;
        this.B = pVar;
        this.C = sVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(Object obj, Object obj2, Object obj3, vd.c cVar, int i) {
        super(2, cVar);
        this.f3304z = i;
        this.D = obj;
        this.B = obj2;
        this.C = obj3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(Object obj, vd.c cVar, int i) {
        super(2, cVar);
        this.f3304z = i;
        this.C = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public u(pe.n nVar, fe.p pVar, vd.c cVar) {
        super(2, cVar);
        this.f3304z = 8;
        this.D = nVar;
        this.C = (xd.h) pVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(se.d dVar, se.b bVar, vd.c cVar) {
        super(2, cVar);
        this.f3304z = 4;
        this.D = dVar;
        this.C = bVar;
    }
}
