package a2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d2 f186c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f188b;

    static {
        d2 d2Var = new d2(0L, 0L);
        new d2(Long.MAX_VALUE, Long.MAX_VALUE);
        new d2(Long.MAX_VALUE, 0L);
        new d2(0L, Long.MAX_VALUE);
        f186c = d2Var;
    }

    public d2(long j5, long j8) {
        s1.d.b(j5 >= 0);
        s1.d.b(j8 >= 0);
        this.f187a = j5;
        this.f188b = j8;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(long r12, long r14, long r16) {
        /*
            r11 = this;
            long r0 = r11.f187a
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            long r5 = r11.f188b
            if (r4 != 0) goto Lf
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 != 0) goto Lf
            return r12
        Lf:
            int r4 = s1.b0.f11647a
            long r7 = r12 - r0
            long r0 = r0 ^ r12
            long r9 = r12 ^ r7
            long r0 = r0 & r9
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L1d
            r7 = -9223372036854775808
        L1d:
            long r0 = r12 + r5
            long r9 = r12 ^ r0
            long r5 = r5 ^ r0
            long r5 = r5 & r9
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 >= 0) goto L2c
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L2c:
            int r2 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r2 > 0) goto L38
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 > 0) goto L38
            r2 = r4
            goto L39
        L38:
            r2 = r3
        L39:
            int r5 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r5 > 0) goto L42
            int r0 = (r16 > r0 ? 1 : (r16 == r0 ? 0 : -1))
            if (r0 > 0) goto L42
            r3 = r4
        L42:
            if (r2 == 0) goto L57
            if (r3 == 0) goto L57
            long r0 = r14 - r12
            long r0 = java.lang.Math.abs(r0)
            long r12 = r16 - r12
            long r12 = java.lang.Math.abs(r12)
            int r12 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r12 > 0) goto L5c
            goto L59
        L57:
            if (r2 == 0) goto L5a
        L59:
            return r14
        L5a:
            if (r3 == 0) goto L5d
        L5c:
            return r16
        L5d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.d2.a(long, long, long):long");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d2.class == obj.getClass()) {
            d2 d2Var = (d2) obj;
            if (this.f187a == d2Var.f187a && this.f188b == d2Var.f188b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f187a) * 31) + ((int) this.f188b);
    }
}
