package f9;

import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends h0 {
    public int A;
    public String B;
    public String C;
    public long D;
    public final long E;
    public final long F;
    public List G;
    public String H;
    public int I;
    public String J;
    public String K;
    public long L;
    public String M;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f4279y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f4280z;

    public n0(r1 r1Var, long j4, long j7) {
        super(r1Var);
        this.L = 0L;
        this.M = null;
        this.E = j4;
        this.F = j7;
    }

    @Override // f9.h0
    public final boolean p1() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x025d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0257  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.w4 q1(java.lang.String r45) {
        /*
            Method dump skipped, instruction units count: 831
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n0.q1(java.lang.String):f9.w4");
    }

    public final void r1() {
        String str;
        m1();
        r1 r1Var = (r1) this.f307w;
        f1 f1Var = r1Var.f4367z;
        w0 w0Var = r1Var.A;
        r1.e(f1Var);
        if (f1Var.t1().i(f2.f4171x)) {
            byte[] bArr = new byte[16];
            u4 u4Var = r1Var.D;
            r1.e(u4Var);
            u4Var.k2().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            r1.g(w0Var);
            w0Var.I.a("Analytics Storage consent is not granted");
            str = null;
        }
        r1.g(w0Var);
        w0Var.I.a("Resetting session stitching token to ".concat(str == null ? "null" : "not null"));
        this.K = str;
        r1Var.F.getClass();
        this.L = System.currentTimeMillis();
    }

    public final String s1() {
        n1();
        o8.u.g(this.f4279y);
        return this.f4279y;
    }

    public final String t1() {
        m1();
        n1();
        o8.u.g(this.J);
        return this.J;
    }
}
