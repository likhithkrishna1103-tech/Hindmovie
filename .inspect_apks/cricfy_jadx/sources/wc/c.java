package wc;

import ge.i;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14137a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f14138b = Collections.synchronizedMap(new LinkedHashMap());

    public static a a(d dVar) {
        Map map = f14138b;
        i.d(map, "dependencies");
        Object obj = map.get(dVar);
        if (obj != null) {
            return (a) obj;
        }
        throw new IllegalStateException("Cannot get dependency " + dVar + ". Dependencies should be added at class load time.");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7 A[Catch: all -> 0x00c0, TRY_ENTER, TryCatch #0 {all -> 0x00c0, blocks: (B:22:0x0092, B:25:0x00a7, B:26:0x00bf), top: B:31:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0090 -> B:21:0x0091). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(xd.c r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof wc.b
            if (r0 == 0) goto L13
            r0 = r10
            wc.b r0 = (wc.b) r0
            int r1 = r0.G
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.G = r1
            goto L18
        L13:
            wc.b r0 = new wc.b
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.E
            int r1 = r0.G
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r1 = r0.D
            java.util.Map r3 = r0.C
            xe.c r4 = r0.B
            wc.d r5 = r0.A
            java.util.Iterator r6 = r0.f14136z
            java.util.Map r7 = r0.f14135y
            com.bumptech.glide.c.C(r10)
            goto L91
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L39:
            com.bumptech.glide.c.C(r10)
            java.lang.String r10 = "dependencies"
            java.util.Map r1 = wc.c.f14138b
            ge.i.d(r1, r10)
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            int r3 = r1.size()
            int r3 = sd.s.A(r3)
            r10.<init>(r3)
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r3 = r10
            r6 = r1
        L5a:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto Lc5
            java.lang.Object r10 = r6.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r1 = r10.getKey()
            java.lang.Object r4 = r10.getKey()
            r5 = r4
            wc.d r5 = (wc.d) r5
            java.lang.Object r10 = r10.getValue()
            wc.a r10 = (wc.a) r10
            xe.c r4 = r10.f14133a
            r0.f14135y = r3
            r0.f14136z = r6
            r0.A = r5
            r0.B = r4
            r0.C = r3
            r0.D = r1
            r0.G = r2
            java.lang.Object r10 = r4.g(r0)
            wd.a r7 = wd.a.f14143v
            if (r10 != r7) goto L90
            return r7
        L90:
            r7 = r3
        L91:
            r10 = 0
            java.lang.String r8 = "subscriberName"
            ge.i.e(r5, r8)     // Catch: java.lang.Throwable -> Lc0
            wc.a r8 = a(r5)     // Catch: java.lang.Throwable -> Lc0
            nb.i r8 = r8.f14134b     // Catch: java.lang.Throwable -> Lc0
            if (r8 == 0) goto La7
            r4.a(r10)
            r3.put(r1, r8)
            r3 = r7
            goto L5a
        La7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r2 = "Subscriber "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc0
            r1.append(r5)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r2 = " has not been registered."
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc0
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lc0
            throw r0     // Catch: java.lang.Throwable -> Lc0
        Lc0:
            r0 = move-exception
            r4.a(r10)
            throw r0
        Lc5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: wc.c.b(xd.c):java.lang.Object");
    }
}
