package c4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f2493c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2491a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2492b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2494d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2495e = -3.4028235E38f;
    public int f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2496g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2497h = -3.4028235E38f;
    public int i = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f2498j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2499k = Integer.MIN_VALUE;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final r1.a a() {
        /*
            r14 = this;
            float r0 = r14.f2497h
            r1 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r3 = 0
            r4 = 1056964608(0x3f000000, float:0.5)
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 5
            r7 = 4
            if (r2 == 0) goto L11
            goto L1c
        L11:
            int r0 = r14.f2494d
            if (r0 == r7) goto L1b
            if (r0 == r6) goto L19
            r0 = r4
            goto L1c
        L19:
            r0 = r5
            goto L1c
        L1b:
            r0 = r3
        L1c:
            int r2 = r14.i
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = 3
            r10 = 2
            r11 = 1
            if (r2 == r8) goto L26
            goto L35
        L26:
            int r2 = r14.f2494d
            if (r2 == r11) goto L34
            if (r2 == r9) goto L32
            if (r2 == r7) goto L34
            if (r2 == r6) goto L32
            r2 = r11
            goto L35
        L32:
            r2 = r10
            goto L35
        L34:
            r2 = 0
        L35:
            r1.a r8 = new r1.a
            r8.<init>()
            int r12 = r14.f2494d
            r13 = 0
            if (r12 == r11) goto L56
            if (r12 == r10) goto L53
            if (r12 == r9) goto L50
            if (r12 == r7) goto L56
            if (r12 == r6) goto L50
            java.lang.String r6 = "WebvttCueParser"
            java.lang.String r7 = "Unknown textAlignment: "
            e6.j.p(r12, r7, r6)
            r6 = r13
            goto L58
        L50:
            android.text.Layout$Alignment r6 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            goto L58
        L53:
            android.text.Layout$Alignment r6 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L58
        L56:
            android.text.Layout$Alignment r6 = android.text.Layout.Alignment.ALIGN_NORMAL
        L58:
            r8.f11231c = r6
            float r6 = r14.f2495e
            int r7 = r14.f
            int r9 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r9 == 0) goto L6e
            if (r7 != 0) goto L6e
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 < 0) goto L6c
            int r3 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r3 <= 0) goto L6e
        L6c:
            r1 = r5
            goto L75
        L6e:
            if (r9 == 0) goto L72
            r1 = r6
            goto L75
        L72:
            if (r7 != 0) goto L75
            goto L6c
        L75:
            r8.f11233e = r1
            r8.f = r7
            int r1 = r14.f2496g
            r8.f11234g = r1
            r8.f11235h = r0
            r8.i = r2
            float r1 = r14.f2498j
            if (r2 == 0) goto La0
            if (r2 == r11) goto L94
            if (r2 != r10) goto L8a
            goto La2
        L8a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r0.<init>(r1)
            throw r0
        L94:
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            r3 = 1073741824(0x40000000, float:2.0)
            if (r2 > 0) goto L9c
            float r0 = r0 * r3
            goto La2
        L9c:
            float r5 = r5 - r0
            float r0 = r5 * r3
            goto La2
        La0:
            float r0 = r5 - r0
        La2:
            float r0 = java.lang.Math.min(r1, r0)
            r8.f11238l = r0
            int r0 = r14.f2499k
            r8.f11242p = r0
            java.lang.CharSequence r0 = r14.f2493c
            if (r0 == 0) goto Lb4
            r8.f11229a = r0
            r8.f11230b = r13
        Lb4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.h.a():r1.a");
    }
}
