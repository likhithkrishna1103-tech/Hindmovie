package f9;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements Runnable {
    public final Object A;
    public final /* synthetic */ a7.a B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4507v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final URL f4508w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final byte[] f4509x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f4510y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Map f4511z;

    public z0(a1 a1Var, String str, URL url, byte[] bArr, Map map, y0 y0Var) {
        Objects.requireNonNull(a1Var);
        this.B = a1Var;
        o8.u.d(str);
        o8.u.g(url);
        this.f4508w = url;
        this.f4509x = bArr;
        this.A = y0Var;
        this.f4510y = str;
        this.f4511z = map;
    }

    public void a(int i, IOException iOException, byte[] bArr, Map map) {
        p1 p1Var = ((r1) ((b3) this.B).f307w).B;
        r1.g(p1Var);
        p1Var.v1(new a3(this, i, iOException, bArr, map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0285: MOVE (r11 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:646), block:B:141:0x0283 */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0288: MOVE (r12 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:649), block:B:142:0x0287 */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0176  */
    /* JADX WARN: Type inference failed for: r14v0, types: [f9.z0] */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v48 */
    /* JADX WARN: Type inference failed for: r9v21, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v22, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v37 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.z0.run():void");
    }

    public z0(b3 b3Var, String str, URL url, byte[] bArr, HashMap map, z2 z2Var) {
        Objects.requireNonNull(b3Var);
        this.B = b3Var;
        o8.u.d(str);
        this.f4508w = url;
        this.f4509x = bArr;
        this.A = z2Var;
        this.f4510y = str;
        this.f4511z = map;
    }
}
