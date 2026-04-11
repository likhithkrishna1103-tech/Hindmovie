package r4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends td.g implements ae.p {
    public y A;
    public int B;
    public int C;
    public int D;
    public int E;
    public final /* synthetic */ j[] F;
    public final /* synthetic */ g0 G;
    public final /* synthetic */ y H;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public j[] f11443y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public g0 f11444z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(j[] jVarArr, g0 g0Var, y yVar, rd.c cVar) {
        super(2, cVar);
        this.F = jVarArr;
        this.G = g0Var;
        this.H = yVar;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        return ((f0) m((t4.j) obj, (rd.c) obj2)).o(nd.k.f8990a);
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        return new f0(this.F, this.G, this.H, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        if (r4.g0.c(r6, r5, r11, r10) == r9) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        r4 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0075 -> B:27:0x0076). Please report as a decompilation issue!!! */
    @Override // td.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            int r0 = r10.E
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L22
            if (r0 == r2) goto La
            if (r0 != r1) goto L1a
        La:
            int r0 = r10.D
            int r3 = r10.C
            int r4 = r10.B
            r4.y r5 = r10.A
            r4.g0 r6 = r10.f11444z
            r4.j[] r7 = r10.f11443y
            i5.a.Q(r11)
            goto L58
        L1a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L22:
            i5.a.Q(r11)
            r4.j[] r11 = r10.F
            int r0 = r11.length
            r3 = 0
            r4.g0 r4 = r10.G
            r4.y r5 = r10.H
            r7 = r11
            r11 = r3
            r6 = r4
        L30:
            if (r3 >= r0) goto L78
            r4 = r7[r3]
            int r8 = r11 + 1
            int r4 = r4.ordinal()
            if (r4 == 0) goto L75
            sd.a r9 = sd.a.f11942u
            if (r4 == r2) goto L60
            if (r4 != r1) goto L5a
            r10.f11443y = r7
            r10.f11444z = r6
            r10.A = r5
            r10.B = r8
            r10.C = r3
            r10.D = r0
            r10.E = r1
            java.lang.Object r11 = r4.g0.d(r6, r5, r11, r10)
            if (r11 != r9) goto L57
            goto L74
        L57:
            r4 = r8
        L58:
            r11 = r4
            goto L76
        L5a:
            a2.y0 r11 = new a2.y0
            r11.<init>()
            throw r11
        L60:
            r10.f11443y = r7
            r10.f11444z = r6
            r10.A = r5
            r10.B = r8
            r10.C = r3
            r10.D = r0
            r10.E = r2
            java.lang.Object r11 = r4.g0.c(r6, r5, r11, r10)
            if (r11 != r9) goto L57
        L74:
            return r9
        L75:
            r11 = r8
        L76:
            int r3 = r3 + r2
            goto L30
        L78:
            nd.k r11 = nd.k.f8990a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.f0.o(java.lang.Object):java.lang.Object");
    }
}
