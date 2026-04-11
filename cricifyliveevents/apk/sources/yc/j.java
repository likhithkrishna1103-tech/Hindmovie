package yc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f15043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f15044b;

    public j(o oVar, o oVar2) {
        ge.i.e(oVar, "localOverrideSettings");
        ge.i.e(oVar2, "remoteSettings");
        this.f15043a = oVar;
        this.f15044b = oVar2;
    }

    public final double a() {
        Double dB = this.f15043a.b();
        if (dB != null) {
            double dDoubleValue = dB.doubleValue();
            if (0.0d <= dDoubleValue && dDoubleValue <= 1.0d) {
                return dDoubleValue;
            }
        }
        Double dB2 = this.f15044b.b();
        if (dB2 != null) {
            double dDoubleValue2 = dB2.doubleValue();
            if (0.0d <= dDoubleValue2 && dDoubleValue2 <= 1.0d) {
                return dDoubleValue2;
            }
        }
        return 1.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        if (r6.d(r0) == r4) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(xd.c r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof yc.i
            if (r0 == 0) goto L13
            r0 = r6
            yc.i r0 = (yc.i) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            yc.i r0 = new yc.i
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f15042z
            int r1 = r0.B
            r2 = 2
            r3 = 1
            wd.a r4 = wd.a.f14143v
            if (r1 == 0) goto L38
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2a
            com.bumptech.glide.c.C(r6)
            goto L57
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            yc.j r1 = r0.f15041y
            com.bumptech.glide.c.C(r6)
            goto L49
        L38:
            com.bumptech.glide.c.C(r6)
            r0.f15041y = r5
            r0.B = r3
            yc.o r6 = r5.f15043a
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r4) goto L48
            goto L56
        L48:
            r1 = r5
        L49:
            yc.o r6 = r1.f15044b
            r1 = 0
            r0.f15041y = r1
            r0.B = r2
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r4) goto L57
        L56:
            return r4
        L57:
            rd.l r6 = rd.l.f11003a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: yc.j.b(xd.c):java.lang.Object");
    }
}
