package r4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import ke.y0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f11451k = {"INSERT", "UPDATE", "DELETE"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f11452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f11453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y0 f11455d;
    public final String[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a2.c f11457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ne.l f11458h;
    public final AtomicBoolean i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ae.a f11459j = new a5.c(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f11456e = new LinkedHashMap();

    public g0(t tVar, HashMap map, HashMap map2, String[] strArr, boolean z2, y0 y0Var) {
        String lowerCase;
        this.f11452a = tVar;
        this.f11453b = map;
        this.f11454c = z2;
        this.f11455d = y0Var;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            be.h.d(lowerCase2, "toLowerCase(...)");
            this.f11456e.put(lowerCase2, Integer.valueOf(i));
            String str2 = (String) this.f11453b.get(strArr[i]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                be.h.d(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i] = lowerCase2;
        }
        this.f = strArr2;
        for (Map.Entry entry : this.f11453b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = str3.toLowerCase(locale2);
            be.h.d(lowerCase3, "toLowerCase(...)");
            if (this.f11456e.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                be.h.d(lowerCase4, "toLowerCase(...)");
                LinkedHashMap linkedHashMap = this.f11456e;
                be.h.e(linkedHashMap, "<this>");
                Object obj = linkedHashMap.get(lowerCase3);
                if (obj == null && !linkedHashMap.containsKey(lowerCase3)) {
                    throw new NoSuchElementException("Key " + ((Object) lowerCase3) + " is missing in the map.");
                }
                linkedHashMap.put(lowerCase4, obj);
            }
        }
        this.f11457g = new a2.c(this.f.length);
        this.f11458h = new ne.l(this.f.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(r4.g0 r4, r4.l r5, td.c r6) {
        /*
            boolean r0 = r6 instanceof r4.z
            if (r0 == 0) goto L13
            r0 = r6
            r4.z r0 = (r4.z) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            r4.z r0 = new r4.z
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f11516y
            int r6 = r0.A
            r1 = 2
            r2 = 1
            sd.a r3 = sd.a.f11942u
            if (r6 == 0) goto L3e
            if (r6 == r2) goto L36
            if (r6 != r1) goto L2e
            java.lang.Object r5 = r0.f11515x
            java.util.Set r5 = (java.util.Set) r5
            i5.a.Q(r4)
            return r5
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            java.lang.Object r5 = r0.f11515x
            r4.l r5 = (r4.l) r5
            i5.a.Q(r4)
            goto L54
        L3e:
            i5.a.Q(r4)
            c.e0 r4 = new c.e0
            r6 = 3
            r4.<init>(r6)
            r0.f11515x = r5
            r0.A = r2
            java.lang.String r6 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r4 = r5.a(r6, r4, r0)
            if (r4 != r3) goto L54
            goto L68
        L54:
            java.util.Set r4 = (java.util.Set) r4
            boolean r6 = r4.isEmpty()
            if (r6 != 0) goto L69
            r0.f11515x = r4
            r0.A = r1
            java.lang.String r6 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r5 = cf.l.p(r5, r6, r0)
            if (r5 != r3) goto L69
        L68:
            return r3
        L69:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.g0.a(r4.g0, r4.l, td.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008a A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #0 {all -> 0x0095, blocks: (B:34:0x0082, B:36:0x008a, B:20:0x0047, B:24:0x0054, B:28:0x0066, B:30:0x0077, B:42:0x009e, B:43:0x00a3), top: B:47:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(r4.g0 r8, td.c r9) throws java.lang.Throwable {
        /*
            r4.t r0 = r8.f11452a
            boolean r1 = r9 instanceof r4.a0
            if (r1 == 0) goto L15
            r1 = r9
            r4.a0 r1 = (r4.a0) r1
            int r2 = r1.B
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.B = r2
            goto L1a
        L15:
            r4.a0 r1 = new r4.a0
            r1.<init>(r8, r9)
        L1a:
            java.lang.Object r9 = r1.f11426z
            int r2 = r1.B
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            kc.b r8 = r1.f11425y
            r4.g0 r0 = r1.f11424x
            i5.a.Q(r9)     // Catch: java.lang.Throwable -> L2f
            r7 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            goto L82
        L2f:
            r9 = move-exception
            goto La4
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            i5.a.Q(r9)
            kc.b r9 = r0.f
            boolean r2 = r9.k()
            od.s r4 = od.s.f9572u
            if (r2 == 0) goto La8
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.i     // Catch: java.lang.Throwable -> L95
            r5 = 0
            boolean r2 = r2.compareAndSet(r3, r5)     // Catch: java.lang.Throwable -> L95
            if (r2 != 0) goto L54
            r9.J()
            return r4
        L54:
            ae.a r2 = r8.f11459j     // Catch: java.lang.Throwable -> L95
            java.lang.Object r2 = r2.b()     // Catch: java.lang.Throwable -> L95
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L95
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L95
            if (r2 != 0) goto L66
            r9.J()
            return r4
        L66:
            r4.b0 r2 = new r4.b0     // Catch: java.lang.Throwable -> L95
            r4 = 1
            r6 = 0
            r2.<init>(r8, r6, r4)     // Catch: java.lang.Throwable -> L95
            r1.f11424x = r8     // Catch: java.lang.Throwable -> L95
            r1.f11425y = r9     // Catch: java.lang.Throwable -> L95
            r1.B = r3     // Catch: java.lang.Throwable -> L95
            r4.p r0 = r0.f11495d     // Catch: java.lang.Throwable -> L95
            if (r0 == 0) goto L9e
            t4.b r0 = r0.f     // Catch: java.lang.Throwable -> L95
            java.lang.Object r0 = r0.I(r5, r2, r1)     // Catch: java.lang.Throwable -> L95
            sd.a r1 = sd.a.f11942u
            if (r0 != r1) goto L82
            return r1
        L82:
            java.util.Set r0 = (java.util.Set) r0     // Catch: java.lang.Throwable -> L95
            boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> L95
            if (r1 != 0) goto L9a
            ne.l r1 = r8.f11458h     // Catch: java.lang.Throwable -> L95
            r1.a(r0)     // Catch: java.lang.Throwable -> L95
            ke.y0 r8 = r8.f11455d     // Catch: java.lang.Throwable -> L95
            r8.a(r0)     // Catch: java.lang.Throwable -> L95
            goto L9a
        L95:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto La4
        L9a:
            r9.J()
            return r0
        L9e:
            java.lang.String r8 = "connectionManager"
            be.h.i(r8)     // Catch: java.lang.Throwable -> L95
            throw r6     // Catch: java.lang.Throwable -> L95
        La4:
            r8.J()
            throw r9
        La8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.g0.b(r4.g0, td.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        if (r15 == r4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e5, code lost:
    
        if (r15 == r4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e7, code lost:
    
        return r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00e5 -> B:28:0x00e8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(r4.g0 r12, r4.y r13, int r14, td.c r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.g0.c(r4.g0, r4.y, int, td.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008d -> B:19:0x0090). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(r4.g0 r7, r4.y r8, int r9, td.c r10) throws java.lang.Throwable {
        /*
            r7.getClass()
            boolean r0 = r10 instanceof r4.d0
            if (r0 == 0) goto L16
            r0 = r10
            r4.d0 r0 = (r4.d0) r0
            int r1 = r0.E
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.E = r1
            goto L1b
        L16:
            r4.d0 r0 = new r4.d0
            r0.<init>(r7, r10)
        L1b:
            java.lang.Object r10 = r0.C
            int r1 = r0.E
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 != r2) goto L34
            int r7 = r0.B
            int r8 = r0.A
            java.lang.String[] r9 = r0.f11436z
            java.lang.String r1 = r0.f11435y
            r4.l r3 = r0.f11434x
            i5.a.Q(r10)
            r10 = r9
            r9 = r3
            goto L90
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            i5.a.Q(r10)
            java.lang.String[] r7 = r7.f
            r7 = r7[r9]
            java.lang.String[] r9 = r4.g0.f11451k
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
            r0.f11434x = r9
            r0.f11435y = r1
            r0.f11436z = r10
            r0.A = r8
            r0.B = r7
            r0.E = r2
            java.lang.Object r3 = cf.l.p(r9, r3, r0)
            sd.a r4 = sd.a.f11942u
            if (r3 != r4) goto L90
            return r4
        L90:
            int r8 = r8 + r2
            goto L4e
        L92:
            nd.k r7 = nd.k.f8990a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.g0.d(r4.g0, r4.y, int, td.c):java.lang.Object");
    }

    public final void e(ae.a aVar, ae.a aVar2) {
        be.h.e(aVar, "onRefreshScheduled");
        be.h.e(aVar2, "onRefreshCompleted");
        if (this.i.compareAndSet(false, true)) {
            aVar.b();
            pe.c cVar = this.f11452a.f11492a;
            rd.c cVar2 = null;
            if (cVar != null) {
                ke.x.j(cVar, new ke.t(), new cc.e0(this, aVar2, cVar2, 4), 2);
            } else {
                be.h.i("coroutineScope");
                throw null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(td.c r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof r4.e0
            if (r0 == 0) goto L13
            r0 = r7
            r4.e0 r0 = (r4.e0) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            r4.e0 r0 = new r4.e0
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f11439y
            int r1 = r0.A
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kc.b r0 = r0.f11438x
            i5.a.Q(r7)     // Catch: java.lang.Throwable -> L27
            goto L5a
        L27:
            r7 = move-exception
            goto L68
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            i5.a.Q(r7)
            r4.t r7 = r6.f11452a
            kc.b r1 = r7.f
            boolean r3 = r1.k()
            if (r3 == 0) goto L6c
            r4.b0 r3 = new r4.b0     // Catch: java.lang.Throwable -> L66
            r4 = 2
            r5 = 0
            r3.<init>(r6, r5, r4)     // Catch: java.lang.Throwable -> L66
            r0.f11438x = r1     // Catch: java.lang.Throwable -> L66
            r0.A = r2     // Catch: java.lang.Throwable -> L66
            r4.p r7 = r7.f11495d     // Catch: java.lang.Throwable -> L66
            if (r7 == 0) goto L5e
            t4.b r7 = r7.f     // Catch: java.lang.Throwable -> L66
            r2 = 0
            java.lang.Object r7 = r7.I(r2, r3, r0)     // Catch: java.lang.Throwable -> L66
            sd.a r0 = sd.a.f11942u
            if (r7 != r0) goto L59
            return r0
        L59:
            r0 = r1
        L5a:
            r0.J()
            goto L6c
        L5e:
            java.lang.String r7 = "connectionManager"
            be.h.i(r7)     // Catch: java.lang.Throwable -> L66
            throw r5     // Catch: java.lang.Throwable -> L66
        L64:
            r0 = r1
            goto L68
        L66:
            r7 = move-exception
            goto L64
        L68:
            r0.J()
            throw r7
        L6c:
            nd.k r7 = nd.k.f8990a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.g0.f(td.c):java.lang.Object");
    }
}
