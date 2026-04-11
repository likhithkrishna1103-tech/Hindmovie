package w4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends xd.h implements fe.p {
    public l0 A;
    public d0 B;
    public int C;
    public int D;
    public int E;
    public int F;
    public final /* synthetic */ j[] G;
    public final /* synthetic */ l0 H;
    public final /* synthetic */ d0 I;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public j[] f13960z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(j[] jVarArr, l0 l0Var, d0 d0Var, vd.c cVar) {
        super(2, cVar);
        this.G = jVarArr;
        this.H = l0Var;
        this.I = d0Var;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        return ((k0) m((y4.i) obj, (vd.c) obj2)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        return new k0(this.G, this.H, this.I, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        if (w4.l0.c(r6, r5, r11, r10) == r9) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        r4 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0075 -> B:27:0x0076). Please report as a decompilation issue!!! */
    @Override // xd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            int r0 = r10.F
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L22
            if (r0 == r2) goto La
            if (r0 != r1) goto L1a
        La:
            int r0 = r10.E
            int r3 = r10.D
            int r4 = r10.C
            w4.d0 r5 = r10.B
            w4.l0 r6 = r10.A
            w4.j[] r7 = r10.f13960z
            com.bumptech.glide.c.C(r11)
            goto L58
        L1a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L22:
            com.bumptech.glide.c.C(r11)
            w4.j[] r11 = r10.G
            int r0 = r11.length
            r3 = 0
            w4.l0 r4 = r10.H
            w4.d0 r5 = r10.I
            r7 = r11
            r11 = r3
            r6 = r4
        L30:
            if (r3 >= r0) goto L78
            r4 = r7[r3]
            int r8 = r11 + 1
            int r4 = r4.ordinal()
            if (r4 == 0) goto L75
            wd.a r9 = wd.a.f14143v
            if (r4 == r2) goto L60
            if (r4 != r1) goto L5a
            r10.f13960z = r7
            r10.A = r6
            r10.B = r5
            r10.C = r8
            r10.D = r3
            r10.E = r0
            r10.F = r1
            java.lang.Object r11 = w4.l0.d(r6, r5, r11, r10)
            if (r11 != r9) goto L57
            goto L74
        L57:
            r4 = r8
        L58:
            r11 = r4
            goto L76
        L5a:
            a9.l r11 = new a9.l
            r11.<init>()
            throw r11
        L60:
            r10.f13960z = r7
            r10.A = r6
            r10.B = r5
            r10.C = r8
            r10.D = r3
            r10.E = r0
            r10.F = r2
            java.lang.Object r11 = w4.l0.c(r6, r5, r11, r10)
            if (r11 != r9) goto L57
        L74:
            return r9
        L75:
            r11 = r8
        L76:
            int r3 = r3 + r2
            goto L30
        L78:
            rd.l r11 = rd.l.f11003a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.k0.o(java.lang.Object):java.lang.Object");
    }
}
