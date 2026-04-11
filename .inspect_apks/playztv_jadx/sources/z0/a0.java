package z0;

import androidx.lifecycle.j0;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import ke.d1;
import ke.v0;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements f {
    public static final LinkedHashSet C = new LinkedHashSet();
    public static final Object D = new Object();
    public List A;
    public final i B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j0 f14744u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final rc.b f14745v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a1 f14746w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f14747x = ".tmp";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final nd.i f14748y = new nd.i(new j0(5, this));

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ne.n f14749z = new ne.n(c0.f14755a);

    public a0(j0 j0Var, List list, rc.b bVar, ke.u uVar) {
        this.f14744u = j0Var;
        this.f14745v = bVar;
        rd.c cVar = null;
        this.f14746w = new a1(new o(this, cVar, 1));
        this.A = od.i.h0(list);
        n nVar = new n(this);
        o oVar = new o(this, cVar, 0);
        i iVar = new i();
        iVar.f14761a = uVar;
        iVar.f14762b = oVar;
        iVar.f14763c = new me.a(Integer.MAX_VALUE);
        iVar.f14764d = new AtomicInteger(0);
        v0 v0Var = (v0) uVar.b().v(ke.s.f7730v);
        if (v0Var != null) {
            ((d1) v0Var).D(true, new ke.i(2, new l4.b(nVar, 1, iVar)));
        }
        this.B = iVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a0, code lost:
    
        if (r8 != r5) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v10, types: [ae.p, td.g] */
    /* JADX WARN: Type inference failed for: r1v3, types: [ae.p, td.g] */
    /* JADX WARN: Type inference failed for: r8v0, types: [z0.a0] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [z0.a0] */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(z0.a0 r8, z0.k r9, td.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.a0.a(z0.a0, z0.k, td.c):java.lang.Object");
    }

    @Override // z0.f
    public final ne.b B() {
        return this.f14746w;
    }

    public final File b() {
        return (File) this.f14748y.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(td.c r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.a0.c(td.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(td.c r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof z0.u
            if (r0 == 0) goto L13
            r0 = r5
            z0.u r0 = (z0.u) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            z0.u r0 = new z0.u
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f14791y
            int r1 = r0.A
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            z0.a0 r0 = r0.f14790x
            i5.a.Q(r5)     // Catch: java.lang.Throwable -> L27
            goto L41
        L27:
            r5 = move-exception
            goto L46
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            i5.a.Q(r5)
            r0.f14790x = r4     // Catch: java.lang.Throwable -> L44
            r0.A = r2     // Catch: java.lang.Throwable -> L44
            java.lang.Object r5 = r4.c(r0)     // Catch: java.lang.Throwable -> L44
            sd.a r0 = sd.a.f11942u
            if (r5 != r0) goto L41
            return r0
        L41:
            nd.k r5 = nd.k.f8990a
            return r5
        L44:
            r5 = move-exception
            r0 = r4
        L46:
            ne.n r0 = r0.f14749z
            z0.h r1 = new z0.h
            r1.<init>(r5)
            r0.getClass()
            r2 = 0
            r0.f(r2, r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.a0.d(td.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(td.c r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof z0.v
            if (r0 == 0) goto L13
            r0 = r5
            z0.v r0 = (z0.v) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            z0.v r0 = new z0.v
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f14794y
            int r1 = r0.A
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            z0.a0 r0 = r0.f14793x
            i5.a.Q(r5)     // Catch: java.lang.Throwable -> L27
            goto L51
        L27:
            r5 = move-exception
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            i5.a.Q(r5)
            r0.f14793x = r4     // Catch: java.lang.Throwable -> L41
            r0.A = r2     // Catch: java.lang.Throwable -> L41
            java.lang.Object r5 = r4.c(r0)     // Catch: java.lang.Throwable -> L41
            sd.a r0 = sd.a.f11942u
            if (r5 != r0) goto L51
            return r0
        L41:
            r5 = move-exception
            r0 = r4
        L43:
            ne.n r0 = r0.f14749z
            z0.h r1 = new z0.h
            r1.<init>(r5)
            r0.getClass()
            r5 = 0
            r0.f(r5, r1)
        L51:
            nd.k r5 = nd.k.f8990a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.a0.e(td.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13, types: [z0.a0] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [z0.w] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [z0.a0] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(td.c r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof z0.w
            if (r0 == 0) goto L13
            r0 = r5
            z0.w r0 = (z0.w) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            z0.w r0 = new z0.w
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f14798z
            int r1 = r0.B
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            java.io.FileInputStream r1 = r0.f14797y
            z0.a0 r0 = r0.f14796x
            i5.a.Q(r5)     // Catch: java.lang.Throwable -> L29
            goto L51
        L29:
            r5 = move-exception
            goto L5a
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            i5.a.Q(r5)
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L60
            java.io.File r5 = r4.b()     // Catch: java.io.FileNotFoundException -> L60
            r1.<init>(r5)     // Catch: java.io.FileNotFoundException -> L60
            c1.g r5 = c1.g.f2237a     // Catch: java.lang.Throwable -> L58
            r0.f14796x = r4     // Catch: java.lang.Throwable -> L58
            r0.f14797y = r1     // Catch: java.lang.Throwable -> L58
            r0.B = r2     // Catch: java.lang.Throwable -> L58
            c1.b r5 = r5.a(r1)     // Catch: java.lang.Throwable -> L58
            sd.a r0 = sd.a.f11942u
            if (r5 != r0) goto L50
            return r0
        L50:
            r0 = r4
        L51:
            r3 = 0
            i5.a.e(r1, r3)     // Catch: java.io.FileNotFoundException -> L56
            return r5
        L56:
            r5 = move-exception
            goto L62
        L58:
            r5 = move-exception
            r0 = r4
        L5a:
            throw r5     // Catch: java.lang.Throwable -> L5b
        L5b:
            r3 = move-exception
            i5.a.e(r1, r5)     // Catch: java.io.FileNotFoundException -> L56
            throw r3     // Catch: java.io.FileNotFoundException -> L56
        L60:
            r5 = move-exception
            r0 = r4
        L62:
            java.io.File r0 = r0.b()
            boolean r0 = r0.exists()
            if (r0 != 0) goto L72
            c1.b r5 = new c1.b
            r5.<init>(r2)
            return r5
        L72:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.a0.f(td.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r3v2, types: [ae.l, be.i] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(td.c r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof z0.x
            if (r0 == 0) goto L13
            r0 = r8
            z0.x r0 = (z0.x) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            z0.x r0 = new z0.x
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f14801z
            int r1 = r0.B
            r2 = 3
            r3 = 2
            r4 = 1
            sd.a r5 = sd.a.f11942u
            if (r1 == 0) goto L53
            if (r1 == r4) goto L49
            if (r1 == r3) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r1 = r0.f14800y
            java.lang.Object r0 = r0.f14799x
            z0.a r0 = (z0.a) r0
            i5.a.Q(r8)     // Catch: java.io.IOException -> L33
            return r1
        L33:
            r8 = move-exception
            goto L8b
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3d:
            java.lang.Object r1 = r0.f14800y
            z0.a r1 = (z0.a) r1
            java.lang.Object r3 = r0.f14799x
            z0.a0 r3 = (z0.a0) r3
            i5.a.Q(r8)
            goto L7b
        L49:
            java.lang.Object r1 = r0.f14799x
            z0.a0 r1 = (z0.a0) r1
            i5.a.Q(r8)     // Catch: z0.a -> L51
            return r8
        L51:
            r8 = move-exception
            goto L64
        L53:
            i5.a.Q(r8)
            r0.f14799x = r7     // Catch: z0.a -> L62
            r0.B = r4     // Catch: z0.a -> L62
            java.lang.Object r8 = r7.f(r0)     // Catch: z0.a -> L62
            if (r8 != r5) goto L61
            goto L87
        L61:
            return r8
        L62:
            r8 = move-exception
            r1 = r7
        L64:
            rc.b r4 = r1.f14745v
            r0.f14799x = r1
            r0.f14800y = r8
            r0.B = r3
            java.lang.Object r3 = r4.f11562v
            be.i r3 = (be.i) r3
            java.lang.Object r3 = r3.a(r8)
            if (r3 != r5) goto L77
            goto L87
        L77:
            r6 = r1
            r1 = r8
            r8 = r3
            r3 = r6
        L7b:
            r0.f14799x = r1     // Catch: java.io.IOException -> L89
            r0.f14800y = r8     // Catch: java.io.IOException -> L89
            r0.B = r2     // Catch: java.io.IOException -> L89
            java.lang.Object r0 = r3.i(r8, r0)     // Catch: java.io.IOException -> L89
            if (r0 != r5) goto L88
        L87:
            return r5
        L88:
            return r8
        L89:
            r8 = move-exception
            r0 = r1
        L8b:
            com.bumptech.glide.d.d(r0, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.a0.g(td.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(ae.p r11, rd.h r12, td.c r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof z0.y
            if (r0 == 0) goto L13
            r0 = r13
            z0.y r0 = (z0.y) r0
            int r1 = r0.C
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.C = r1
            goto L18
        L13:
            z0.y r0 = new z0.y
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.A
            int r1 = r0.C
            java.lang.String r2 = "Data in DataStore was mutated but DataStore is only compatible with Immutable types."
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            sd.a r7 = sd.a.f11942u
            if (r1 == 0) goto L47
            if (r1 == r5) goto L3b
            if (r1 != r4) goto L33
            java.lang.Object r11 = r0.f14803y
            z0.a0 r12 = r0.f14802x
            i5.a.Q(r13)
            goto La2
        L33:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3b:
            java.lang.Object r11 = r0.f14804z
            java.lang.Object r12 = r0.f14803y
            z0.b r12 = (z0.b) r12
            z0.a0 r1 = r0.f14802x
            i5.a.Q(r13)
            goto L7c
        L47:
            i5.a.Q(r13)
            ne.n r13 = r10.f14749z
            java.lang.Object r13 = r13.d()
            z0.b r13 = (z0.b) r13
            java.lang.Object r1 = r13.f14750a
            if (r1 == 0) goto L5b
            int r1 = r1.hashCode()
            goto L5c
        L5b:
            r1 = r3
        L5c:
            int r8 = r13.f14751b
            if (r1 != r8) goto Lbc
            java.lang.Object r1 = r13.f14750a
            cc.e0 r8 = new cc.e0
            r9 = 9
            r8.<init>(r11, r1, r6, r9)
            r0.f14802x = r10
            r0.f14803y = r13
            r0.f14804z = r1
            r0.C = r5
            java.lang.Object r11 = ke.x.q(r8, r12, r0)
            if (r11 != r7) goto L78
            goto L9f
        L78:
            r12 = r13
            r13 = r11
            r11 = r1
            r1 = r10
        L7c:
            java.lang.Object r5 = r12.f14750a
            if (r5 == 0) goto L85
            int r5 = r5.hashCode()
            goto L86
        L85:
            r5 = r3
        L86:
            int r12 = r12.f14751b
            if (r5 != r12) goto Lb6
            boolean r12 = be.h.a(r11, r13)
            if (r12 == 0) goto L91
            return r11
        L91:
            r0.f14802x = r1
            r0.f14803y = r13
            r0.f14804z = r6
            r0.C = r4
            java.lang.Object r11 = r1.i(r13, r0)
            if (r11 != r7) goto La0
        L9f:
            return r7
        La0:
            r11 = r13
            r12 = r1
        La2:
            ne.n r12 = r12.f14749z
            z0.b r13 = new z0.b
            if (r11 == 0) goto Lac
            int r3 = r11.hashCode()
        Lac:
            r13.<init>(r3, r11)
            r12.getClass()
            r12.f(r6, r13)
            return r11
        Lb6:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>(r2)
            throw r11
        Lbc:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>(r2)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.a0.h(ae.p, rd.h, td.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.Object r8, td.c r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.a0.i(java.lang.Object, td.c):java.lang.Object");
    }

    @Override // z0.f
    public final Object r(ae.p pVar, td.c cVar) {
        ke.m mVar = new ke.m(true);
        mVar.C(null);
        this.B.a(new k(pVar, mVar, (b0) this.f14749z.d(), cVar.f()));
        return mVar.X(cVar);
    }
}
