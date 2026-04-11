package d1;

import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends xd.h implements fe.p {
    public int A;
    public Object B;
    public final /* synthetic */ Object C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f3221z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(fe.p pVar, d dVar, vd.c cVar) {
        super(2, cVar);
        this.f3221z = 1;
        this.B = (xd.h) pVar;
        this.C = dVar;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        switch (this.f3221z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((e) m((l) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 1:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 2:
                return ((e) m((t0) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 3:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return ((e) m((re.q) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return ((e) m((se.d) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return ((e) m(obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 9:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 10:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 11:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 12:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 13:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 14:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 15:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 16:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 17:
                return ((e) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
            default:
                return ((e) m((JSONObject) obj, (vd.c) obj2)).o(rd.l.f11003a);
        }
    }

    /* JADX WARN: Type inference failed for: r0v29, types: [fe.p, xd.h] */
    /* JADX WARN: Type inference failed for: r0v3, types: [fe.p, xd.h] */
    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f3221z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = new e((List) this.C, cVar, 0);
                eVar.B = obj;
                return eVar;
            case 1:
                return new e((fe.p) this.B, (d) this.C, cVar);
            case 2:
                e eVar2 = new e((h0) this.C, cVar, 2);
                eVar2.B = obj;
                return eVar2;
            case 3:
                return new e((b6.f) this.C, cVar, 3);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return new e((r4.b) this.B, (Uri) this.C, cVar, 4);
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                e eVar3 = new e((re.s) this.C, cVar, 5);
                eVar3.B = obj;
                return eVar3;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                e eVar4 = new e((se.b) this.C, cVar, 6);
                eVar4.B = obj;
                return eVar4;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                e eVar5 = new e((se.b) this.C, cVar, 7);
                eVar5.B = obj;
                return eVar5;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                e eVar6 = new e((se.d) this.C, cVar, 8);
                eVar6.B = obj;
                return eVar6;
            case 9:
                return new e((vc.o) this.B, (vc.u0) this.C, cVar, 9);
            case 10:
                return new e((vc.a1) this.B, (vc.g0) this.C, cVar, 10);
            case 11:
                e eVar7 = new e((fe.l) this.C, cVar, 11);
                eVar7.B = obj;
                return eVar7;
            case 12:
                return new e((w4.l0) this.B, (fe.a) this.C, cVar, 12);
            case 13:
                return new e((xb.c) this.B, (fe.l) this.C, cVar, 13);
            case 14:
                return new e((xb.c) this.B, (h1.e) this.C, cVar, 14);
            case 15:
                return new e((fe.p) this.B, (y4.z) this.C, cVar, 15);
            case 16:
                return new e((fe.p) this.B, (ge.p) this.C, cVar, 16);
            case 17:
                return new e((fe.p) this.B, (y4.n) this.C, cVar);
            default:
                e eVar8 = new e((yc.c) this.C, cVar, 18);
                eVar8.B = obj;
                return eVar8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:196:0x0343, code lost:
    
        if (r4.b(r20) == r8) goto L197;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0628  */
    /* JADX WARN: Type inference failed for: r0v170, types: [fe.p, xd.h] */
    /* JADX WARN: Type inference failed for: r0v8, types: [fe.p, xd.h] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, re.c] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, re.c] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object, re.c] */
    /* JADX WARN: Type inference failed for: r10v5, types: [vc.a1] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [vc.x0] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r4v0, types: [vd.c] */
    /* JADX WARN: Type inference failed for: r4v20, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r6v26, types: [vc.g0] */
    /* JADX WARN: Type inference failed for: r6v27, types: [vc.g0] */
    /* JADX WARN: Type inference failed for: r6v29, types: [pe.v, ue.c] */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:368:0x0615 -> B:369:0x0617). Please report as a decompilation issue!!! */
    @Override // xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.e.o(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(fe.p pVar, y4.n nVar, vd.c cVar) {
        super(2, cVar);
        this.f3221z = 17;
        this.B = (xd.h) pVar;
        this.C = nVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, Object obj2, vd.c cVar, int i) {
        super(2, cVar);
        this.f3221z = i;
        this.B = obj;
        this.C = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, vd.c cVar, int i) {
        super(2, cVar);
        this.f3221z = i;
        this.C = obj;
    }
}
