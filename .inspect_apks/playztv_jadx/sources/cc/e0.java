package cc;

import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends td.g implements ae.p {
    public Object A;
    public final /* synthetic */ Object B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f2626y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2627z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(Object obj, Object obj2, rd.c cVar, int i) {
        super(2, cVar);
        this.f2626y = i;
        this.A = obj;
        this.B = obj2;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        switch (this.f2626y) {
        }
        return ((e0) m((ke.u) obj, (rd.c) obj2)).o(nd.k.f8990a);
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        switch (this.f2626y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new e0((f0) this.A, (String) this.B, cVar, 0);
            case 1:
                return new e0((ub.o) this.A, (ArrayList) this.B, cVar, 1);
            case 2:
                return new e0((ec.m) this.B, cVar, 2);
            case 3:
                return new e0((m4.a) this.A, (Uri) this.B, cVar, 3);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return new e0((r4.g0) this.A, (ae.a) this.B, cVar, 4);
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return new e0((ae.p) this.A, (t4.p) this.B, cVar, 5);
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return new e0((ae.p) this.A, (be.n) this.B, cVar, 6);
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                e0 e0Var = new e0((List) this.B, cVar, 7);
                e0Var.A = obj;
                return e0Var;
            case 8:
                return new e0((z0.i) this.B, cVar, 8);
            default:
                return new e0((ae.p) this.A, this.B, cVar, 9);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01e4, code lost:
    
        if (r3.i(r0, r21) != r8) goto L104;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, me.a] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object, me.a] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object, me.a] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v26, types: [me.a] */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x01e4 -> B:104:0x01e8). Please report as a decompilation issue!!! */
    @Override // td.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1190
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cc.e0.o(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(Object obj, rd.c cVar, int i) {
        super(2, cVar);
        this.f2626y = i;
        this.B = obj;
    }
}
