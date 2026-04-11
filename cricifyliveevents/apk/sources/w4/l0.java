package w4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f13961k = {"INSERT", "UPDATE", "DELETE"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f13962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f13963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hf.h f13965d;
    public final String[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f13967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l4.a f13968h;
    public final AtomicBoolean i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public fe.a f13969j = new c.x(5);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f13966e = new LinkedHashMap();

    public l0(t tVar, HashMap map, HashMap map2, String[] strArr, boolean z10, hf.h hVar) {
        String lowerCase;
        this.f13962a = tVar;
        this.f13963b = map;
        this.f13964c = z10;
        this.f13965d = hVar;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            ge.i.d(lowerCase2, "toLowerCase(...)");
            this.f13966e.put(lowerCase2, Integer.valueOf(i));
            String str2 = (String) this.f13963b.get(strArr[i]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                ge.i.d(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i] = lowerCase2;
        }
        this.f = strArr2;
        for (Map.Entry entry : this.f13963b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = str3.toLowerCase(locale2);
            ge.i.d(lowerCase3, "toLowerCase(...)");
            if (this.f13966e.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                ge.i.d(lowerCase4, "toLowerCase(...)");
                LinkedHashMap linkedHashMap = this.f13966e;
                linkedHashMap.put(lowerCase4, sd.s.z(linkedHashMap, lowerCase3));
            }
        }
        this.f13967g = new k(this.f.length);
        int length2 = this.f.length;
        l4.a aVar = new l4.a();
        aVar.f7697v = new se.x(new int[length2]);
        this.f13968h = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(w4.l0 r4, w4.m r5, xd.c r6) {
        /*
            boolean r0 = r6 instanceof w4.e0
            if (r0 == 0) goto L13
            r0 = r6
            w4.e0 r0 = (w4.e0) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            w4.e0 r0 = new w4.e0
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f13931z
            int r6 = r0.B
            r1 = 2
            r2 = 1
            wd.a r3 = wd.a.f14143v
            if (r6 == 0) goto L3e
            if (r6 == r2) goto L36
            if (r6 != r1) goto L2e
            java.lang.Object r5 = r0.f13930y
            java.util.Set r5 = (java.util.Set) r5
            com.bumptech.glide.c.C(r4)
            return r5
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            java.lang.Object r5 = r0.f13930y
            w4.m r5 = (w4.m) r5
            com.bumptech.glide.c.C(r4)
            goto L55
        L3e:
            com.bumptech.glide.c.C(r4)
            b6.a r4 = new b6.a
            r6 = 8
            r4.<init>(r6)
            r0.f13930y = r5
            r0.B = r2
            java.lang.String r6 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r4 = r5.c(r6, r4, r0)
            if (r4 != r3) goto L55
            goto L69
        L55:
            java.util.Set r4 = (java.util.Set) r4
            boolean r6 = r4.isEmpty()
            if (r6 != 0) goto L6a
            r0.f13930y = r4
            r0.B = r1
            java.lang.String r6 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r5 = com.bumptech.glide.e.f(r5, r6, r0)
            if (r5 != r3) goto L6a
        L69:
            return r3
        L6a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.l0.a(w4.l0, w4.m, xd.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(w4.l0 r8, xd.c r9) throws java.lang.Throwable {
        /*
            w4.t r0 = r8.f13962a
            boolean r1 = r9 instanceof w4.f0
            if (r1 == 0) goto L15
            r1 = r9
            w4.f0 r1 = (w4.f0) r1
            int r2 = r1.B
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.B = r2
            goto L1a
        L15:
            w4.f0 r1 = new w4.f0
            r1.<init>(r8, r9)
        L1a:
            java.lang.Object r9 = r1.f13935z
            int r2 = r1.B
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            l7.a r0 = r1.f13934y
            com.bumptech.glide.c.C(r9)     // Catch: java.lang.Throwable -> L29
            goto L7f
        L29:
            r8 = move-exception
            goto L9f
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            com.bumptech.glide.c.C(r9)
            l7.a r9 = r0.f
            boolean r2 = r9.l()
            sd.r r4 = sd.r.f11671v
            if (r2 == 0) goto La3
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.i     // Catch: java.lang.Throwable -> L9d
            r5 = 0
            boolean r2 = r2.compareAndSet(r3, r5)     // Catch: java.lang.Throwable -> L9d
            if (r2 != 0) goto L4e
            r9.K()
            return r4
        L4e:
            fe.a r2 = r8.f13969j     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r2 = r2.b()     // Catch: java.lang.Throwable -> L9d
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L9d
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L9d
            if (r2 != 0) goto L60
            r9.K()
            return r4
        L60:
            w4.g0 r2 = new w4.g0     // Catch: java.lang.Throwable -> L9d
            r4 = 1
            r6 = 0
            r2.<init>(r8, r6, r4)     // Catch: java.lang.Throwable -> L9d
            r1.f13934y = r9     // Catch: java.lang.Throwable -> L9d
            r1.B = r3     // Catch: java.lang.Throwable -> L9d
            b0.e r0 = r0.f13993d     // Catch: java.lang.Throwable -> L9d
            if (r0 == 0) goto L95
            java.lang.Object r0 = r0.f     // Catch: java.lang.Throwable -> L9d
            y4.b r0 = (y4.b) r0     // Catch: java.lang.Throwable -> L9d
            java.lang.Object r0 = r0.T(r5, r2, r1)     // Catch: java.lang.Throwable -> L9d
            wd.a r1 = wd.a.f14143v
            if (r0 != r1) goto L7c
            return r1
        L7c:
            r7 = r0
            r0 = r9
            r9 = r7
        L7f:
            java.util.Set r9 = (java.util.Set) r9     // Catch: java.lang.Throwable -> L29
            boolean r1 = r9.isEmpty()     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L91
            l4.a r1 = r8.f13968h     // Catch: java.lang.Throwable -> L29
            r1.w(r9)     // Catch: java.lang.Throwable -> L29
            hf.h r8 = r8.f13965d     // Catch: java.lang.Throwable -> L29
            r8.a(r9)     // Catch: java.lang.Throwable -> L29
        L91:
            r0.K()
            return r9
        L95:
            java.lang.String r8 = "connectionManager"
            ge.i.i(r8)     // Catch: java.lang.Throwable -> L9d
            throw r6     // Catch: java.lang.Throwable -> L9d
        L9b:
            r0 = r9
            goto L9f
        L9d:
            r8 = move-exception
            goto L9b
        L9f:
            r0.K()
            throw r8
        La3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.l0.b(w4.l0, xd.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
    
        if (r15 == r4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00df, code lost:
    
        if (r15 == r4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e1, code lost:
    
        return r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00df -> B:28:0x00e2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(w4.l0 r12, w4.d0 r13, int r14, xd.c r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.l0.c(w4.l0, w4.d0, int, xd.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008d -> B:19:0x0090). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(w4.l0 r7, w4.d0 r8, int r9, xd.c r10) throws java.lang.Throwable {
        /*
            r7.getClass()
            boolean r0 = r10 instanceof w4.i0
            if (r0 == 0) goto L16
            r0 = r10
            w4.i0 r0 = (w4.i0) r0
            int r1 = r0.F
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.F = r1
            goto L1b
        L16:
            w4.i0 r0 = new w4.i0
            r0.<init>(r7, r10)
        L1b:
            java.lang.Object r10 = r0.D
            int r1 = r0.F
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 != r2) goto L34
            int r7 = r0.C
            int r8 = r0.B
            java.lang.String[] r9 = r0.A
            java.lang.String r1 = r0.f13948z
            w4.m r3 = r0.f13947y
            com.bumptech.glide.c.C(r10)
            r10 = r9
            r9 = r3
            goto L90
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            com.bumptech.glide.c.C(r10)
            java.lang.String[] r7 = r7.f
            r7 = r7[r9]
            java.lang.String[] r9 = w4.l0.f13961k
            r10 = 0
            r1 = 3
            r6 = r1
            r1 = r7
            r7 = r6
            r6 = r9
            r9 = r8
            r8 = r10
            r10 = r6
        L4e:
            if (r8 >= r7) goto L92
            r3 = r10[r8]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "room_table_modification_trigger_"
            r4.<init>(r5)
            r4.append(r1)
            r5 = 95
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "DROP TRIGGER IF EXISTS `"
            r4.<init>(r5)
            r4.append(r3)
            r3 = 96
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r0.f13947y = r9
            r0.f13948z = r1
            r0.A = r10
            r0.B = r8
            r0.C = r7
            r0.F = r2
            java.lang.Object r3 = com.bumptech.glide.e.f(r9, r3, r0)
            wd.a r4 = wd.a.f14143v
            if (r3 != r4) goto L90
            return r4
        L90:
            int r8 = r8 + r2
            goto L4e
        L92:
            rd.l r7 = rd.l.f11003a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.l0.d(w4.l0, w4.d0, int, xd.c):java.lang.Object");
    }

    public final void e(fe.a aVar, fe.a aVar2) {
        ge.i.e(aVar, "onRefreshScheduled");
        ge.i.e(aVar2, "onRefreshCompleted");
        if (this.i.compareAndSet(false, true)) {
            aVar.b();
            ue.c cVar = this.f13962a.f13990a;
            vd.c cVar2 = null;
            if (cVar != null) {
                pe.x.k(cVar, new pe.u(), new d1.e(this, aVar2, cVar2, 12), 2);
            } else {
                ge.i.i("coroutineScope");
                throw null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(xd.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof w4.j0
            if (r0 == 0) goto L13
            r0 = r7
            w4.j0 r0 = (w4.j0) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            w4.j0 r0 = new w4.j0
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f13954z
            int r1 = r0.B
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            l7.a r0 = r0.f13953y
            com.bumptech.glide.c.C(r7)     // Catch: java.lang.Throwable -> L27
            goto L5c
        L27:
            r7 = move-exception
            goto L6a
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            com.bumptech.glide.c.C(r7)
            w4.t r7 = r6.f13962a
            l7.a r1 = r7.f
            boolean r3 = r1.l()
            if (r3 == 0) goto L6e
            d1.u r3 = new d1.u     // Catch: java.lang.Throwable -> L68
            r4 = 5
            r5 = 0
            r3.<init>(r6, r5, r4)     // Catch: java.lang.Throwable -> L68
            r0.f13953y = r1     // Catch: java.lang.Throwable -> L68
            r0.B = r2     // Catch: java.lang.Throwable -> L68
            b0.e r7 = r7.f13993d     // Catch: java.lang.Throwable -> L68
            if (r7 == 0) goto L60
            java.lang.Object r7 = r7.f     // Catch: java.lang.Throwable -> L68
            y4.b r7 = (y4.b) r7     // Catch: java.lang.Throwable -> L68
            r2 = 0
            java.lang.Object r7 = r7.T(r2, r3, r0)     // Catch: java.lang.Throwable -> L68
            wd.a r0 = wd.a.f14143v
            if (r7 != r0) goto L5b
            return r0
        L5b:
            r0 = r1
        L5c:
            r0.K()
            goto L6e
        L60:
            java.lang.String r7 = "connectionManager"
            ge.i.i(r7)     // Catch: java.lang.Throwable -> L68
            throw r5     // Catch: java.lang.Throwable -> L68
        L66:
            r0 = r1
            goto L6a
        L68:
            r7 = move-exception
            goto L66
        L6a:
            r0.K()
            throw r7
        L6e:
            rd.l r7 = rd.l.f11003a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.l0.f(xd.c):java.lang.Object");
    }
}
