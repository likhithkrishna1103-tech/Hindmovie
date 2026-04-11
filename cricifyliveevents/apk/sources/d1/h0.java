package d1;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f3235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1.a f3236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pe.v f3237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l4.a f3238d;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public pe.a0 f3240g;
    public final nc.p i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final rd.j f3242j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final rd.j f3243k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b6.f f3244l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xe.c f3239e = xe.d.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p6.d f3241h = new p6.d(6);

    public h0(l0 l0Var, List list, e1.a aVar, pe.v vVar) {
        this.f3235a = l0Var;
        this.f3236b = aVar;
        this.f3237c = vVar;
        vd.c cVar = null;
        this.f3238d = new l4.a((fe.p) new u(this, cVar, 0));
        nc.p pVar = new nc.p();
        pVar.f9072d = this;
        pVar.f9069a = xe.d.a();
        pVar.f9070b = pe.x.a();
        pVar.f9071c = sd.j.r0(list);
        this.i = pVar;
        this.f3242j = new rd.j(new n(this, 1));
        this.f3243k = new rd.j(new n(this, 0));
        this.f3244l = new b6.f(vVar, new e0(0, this), new e(this, cVar, 2));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(d1.h0 r4, xd.c r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof d1.v
            if (r0 == 0) goto L13
            r0 = r5
            d1.v r0 = (d1.v) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            d1.v r0 = new d1.v
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.A
            int r1 = r0.C
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            xe.c r4 = r0.f3308z
            d1.h0 r0 = r0.f3307y
            com.bumptech.glide.c.C(r5)
            r5 = r4
            r4 = r0
            goto L47
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            com.bumptech.glide.c.C(r5)
            xe.c r5 = r4.f3239e
            r0.f3307y = r4
            r0.f3308z = r5
            r0.C = r2
            java.lang.Object r0 = r5.g(r0)
            wd.a r1 = wd.a.f14143v
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = 0
            int r1 = r4.f     // Catch: java.lang.Throwable -> L58
            int r1 = r1 + (-1)
            r4.f = r1     // Catch: java.lang.Throwable -> L58
            if (r1 != 0) goto L5c
            pe.a0 r1 = r4.f3240g     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L5a
            r1.g(r0)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r4 = move-exception
            goto L62
        L5a:
            r4.f3240g = r0     // Catch: java.lang.Throwable -> L58
        L5c:
            r5.a(r0)
            rd.l r4 = rd.l.f11003a
            return r4
        L62:
            r5.a(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.h0.c(d1.h0, xd.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:4|(1:6)(1:7))(0)|8|(8:68|(1:(1:(2:18|19))(3:20|21|22))|13|14|62|(1:64)(1:65)|66|67)(5:23|73|24|(3:26|71|27)(3:37|(1:39)(1:40)|(2:42|(2:44|(1:46))(2:53|54))(2:55|(2:57|58)(2:59|60)))|50)|47|69|48) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        if (r9 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        r8 = r11;
        r11 = r9;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b5, code lost:
    
        if (r9 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b8, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v3, types: [fe.p, xd.h] */
    /* JADX WARN: Type inference failed for: r1v9, types: [fe.p, xd.h] */
    /* JADX WARN: Type inference failed for: r9v0, types: [d1.h0] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6, types: [d1.h0] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(d1.h0 r9, d1.t0 r10, xd.c r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.h0.d(d1.h0, d1.t0, xd.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(d1.h0 r4, xd.c r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof d1.x
            if (r0 == 0) goto L13
            r0 = r5
            d1.x r0 = (d1.x) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            d1.x r0 = new d1.x
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.A
            int r1 = r0.C
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            xe.c r4 = r0.f3315z
            d1.h0 r0 = r0.f3314y
            com.bumptech.glide.c.C(r5)
            r5 = r4
            r4 = r0
            goto L47
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            com.bumptech.glide.c.C(r5)
            xe.c r5 = r4.f3239e
            r0.f3314y = r4
            r0.f3315z = r5
            r0.C = r2
            java.lang.Object r0 = r5.g(r0)
            wd.a r1 = wd.a.f14143v
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = 0
            int r1 = r4.f     // Catch: java.lang.Throwable -> L5f
            int r1 = r1 + r2
            r4.f = r1     // Catch: java.lang.Throwable -> L5f
            if (r1 != r2) goto L61
            pe.v r1 = r4.f3237c     // Catch: java.lang.Throwable -> L5f
            d1.o r2 = new d1.o     // Catch: java.lang.Throwable -> L5f
            r3 = 1
            r2.<init>(r4, r0, r3)     // Catch: java.lang.Throwable -> L5f
            r3 = 3
            pe.a0 r1 = pe.x.k(r1, r0, r2, r3)     // Catch: java.lang.Throwable -> L5f
            r4.f3240g = r1     // Catch: java.lang.Throwable -> L5f
            goto L61
        L5f:
            r4 = move-exception
            goto L67
        L61:
            r5.a(r0)
            rd.l r4 = rd.l.f11003a
            return r4
        L67:
            r5.a(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.h0.e(d1.h0, xd.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(d1.h0 r8, boolean r9, vd.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.h0.f(d1.h0, boolean, vd.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009f A[Catch: c -> 0x005f, TryCatch #1 {c -> 0x005f, blocks: (B:19:0x005a, B:54:0x00ff, B:24:0x0068, B:51:0x00e0, B:32:0x0085, B:40:0x009f, B:42:0x00a5, B:36:0x008e, B:48:0x00cd), top: B:80:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013e A[Catch: all -> 0x016b, TryCatch #2 {all -> 0x016b, blocks: (B:61:0x012c, B:63:0x013e, B:64:0x0146), top: B:81:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0146 A[Catch: all -> 0x016b, TRY_LEAVE, TryCatch #2 {all -> 0x016b, blocks: (B:61:0x012c, B:63:0x013e, B:64:0x0146), top: B:81:0x012c }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(d1.h0 r9, boolean r10, xd.c r11) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.h0.g(d1.h0, boolean, xd.c):java.lang.Object");
    }

    @Override // d1.i
    public final Object a(fe.p pVar, xd.c cVar) {
        p1 p1Var = (p1) cVar.h().C(o1.f3287v);
        if (p1Var != null) {
            p1Var.b(this);
        }
        return pe.x.s(new p1(p1Var, this), new u(this, pVar, (vd.c) null), cVar);
    }

    @Override // d1.i
    public final se.c b() {
        return this.f3238d;
    }

    public final s0 h() {
        return (s0) this.f3243k.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        if (r3.z(r0) == r4) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(xd.c r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof d1.y
            if (r0 == 0) goto L13
            r0 = r7
            d1.y r0 = (d1.y) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            d1.y r0 = new d1.y
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.A
            int r1 = r0.C
            r2 = 2
            r3 = 1
            wd.a r4 = wd.a.f14143v
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L38
            if (r1 != r2) goto L30
            int r1 = r0.f3319z
            d1.h0 r0 = r0.f3318y
            com.bumptech.glide.c.C(r7)     // Catch: java.lang.Throwable -> L2e
            goto L66
        L2e:
            r7 = move-exception
            goto L6e
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L38:
            d1.h0 r1 = r0.f3318y
            com.bumptech.glide.c.C(r7)
            goto L51
        L3e:
            com.bumptech.glide.c.C(r7)
            d1.s0 r7 = r6.h()
            r0.f3318y = r6
            r0.C = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r4) goto L50
            goto L65
        L50:
            r1 = r6
        L51:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            nc.p r3 = r1.i     // Catch: java.lang.Throwable -> L69
            r0.f3318y = r1     // Catch: java.lang.Throwable -> L69
            r0.f3319z = r7     // Catch: java.lang.Throwable -> L69
            r0.C = r2     // Catch: java.lang.Throwable -> L69
            java.lang.Object r7 = r3.z(r0)     // Catch: java.lang.Throwable -> L69
            if (r7 != r4) goto L66
        L65:
            return r4
        L66:
            rd.l r7 = rd.l.f11003a
            return r7
        L69:
            r0 = move-exception
            r5 = r1
            r1 = r7
            r7 = r0
            r0 = r5
        L6e:
            p6.d r0 = r0.f3241h
            d1.d1 r2 = new d1.d1
            r2.<init>(r7, r1)
            r0.v(r2)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.h0.i(xd.c):java.lang.Object");
    }

    public final Object j(xd.c cVar) {
        return ((o0) this.f3242j.getValue()).a(new r(3, (vd.c) null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r10, boolean r11, xd.c r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof d1.f0
            if (r0 == 0) goto L13
            r0 = r12
            d1.f0 r0 = (d1.f0) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            d1.f0 r0 = new d1.f0
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.f3229z
            int r1 = r0.B
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            ge.o r10 = r0.f3228y
            com.bumptech.glide.c.C(r12)
            goto L56
        L27:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L2f:
            com.bumptech.glide.c.C(r12)
            ge.o r4 = new ge.o
            r4.<init>()
            rd.j r12 = r9.f3242j
            java.lang.Object r12 = r12.getValue()
            d1.o0 r12 = (d1.o0) r12
            d1.g0 r3 = new d1.g0
            r8 = 0
            r5 = r9
            r6 = r10
            r7 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r0.f3228y = r4
            r0.B = r2
            java.lang.Object r10 = r12.b(r3, r0)
            wd.a r11 = wd.a.f14143v
            if (r10 != r11) goto L55
            return r11
        L55:
            r10 = r4
        L56:
            int r10 = r10.f5253v
            java.lang.Integer r11 = new java.lang.Integer
            r11.<init>(r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.h0.k(java.lang.Object, boolean, xd.c):java.lang.Object");
    }
}
