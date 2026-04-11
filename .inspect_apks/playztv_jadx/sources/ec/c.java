package ec;

import ae.p;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.Serializable;
import java.util.LinkedHashMap;
import ke.u;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends td.g implements p {
    public Object A;
    public Serializable B;
    public /* synthetic */ Object C;
    public final /* synthetic */ Object D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f4644y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4645z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a7.b bVar, LinkedHashMap linkedHashMap, c cVar, d dVar, rd.c cVar2) {
        super(2, cVar2);
        this.A = bVar;
        this.B = linkedHashMap;
        this.C = cVar;
        this.D = dVar;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        switch (this.f4644y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((c) m((JSONObject) obj, (rd.c) obj2)).o(nd.k.f8990a);
            default:
                return ((c) m((u) obj, (rd.c) obj2)).o(nd.k.f8990a);
        }
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        switch (this.f4644y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c cVar2 = new c((e) this.D, cVar);
                cVar2.C = obj;
                return cVar2;
            default:
                return new c((a7.b) this.A, (LinkedHashMap) this.B, (c) this.C, (d) this.D, cVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x024f, code lost:
    
        if (r0 == r10) goto L122;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0230 A[PHI: r0
      0x0230: PHI (r0v20 be.n) = (r0v17 be.n), (r0v17 be.n), (r0v28 be.n) binds: [B:93:0x020f, B:98:0x022c, B:47:0x0118] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020b A[PHI: r0 r2
      0x020b: PHI (r0v17 be.n) = (r0v13 be.n), (r0v13 be.n), (r0v19 be.n) binds: [B:85:0x01ea, B:90:0x0207, B:48:0x0121] A[DONT_GENERATE, DONT_INLINE]
      0x020b: PHI (r2v14 be.n) = (r2v9 be.n), (r2v9 be.n), (r2v21 be.n) binds: [B:85:0x01ea, B:90:0x0207, B:48:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0211  */
    @Override // td.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ec.c.o(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, rd.c cVar) {
        super(2, cVar);
        this.D = eVar;
    }
}
