package ef;

import ag.o;
import com.google.android.gms.internal.measurement.o4;
import f9.c0;
import ff.l;
import ge.i;
import sd.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f3892d = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final da.a f3893a = new da.a(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f3894b = gf.a.f5256a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p6.c f3895c = new p6.c(16);

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        r0.f4599w = r1.length();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ze.a r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "deserializer"
            ge.i.e(r7, r0)
            da.a r0 = r6.f3893a
            r0.getClass()
            ff.m r0 = new ff.m
            r0.<init>(r8)
            ff.k r1 = new ff.k
            ff.o r2 = ff.o.f4605x
            bf.d r3 = r7.d()
            r1.<init>(r6, r2, r0, r3)
            java.lang.Object r7 = r1.o(r7)
            java.lang.Object r1 = r0.f4602z
            java.lang.String r1 = (java.lang.String) r1
            int r2 = r0.f4599w
        L24:
            r3 = -1
            r4 = 10
            if (r2 == r3) goto L4d
            int r3 = r1.length()
            if (r2 >= r3) goto L4d
            int r3 = r2 + 1
            char r2 = r1.charAt(r2)
            r5 = 32
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L4b
            r4 = 13
            if (r2 == r4) goto L4b
            r4 = 9
            if (r2 != r4) goto L44
            goto L4b
        L44:
            r0.f4599w = r3
            byte r4 = ff.i.b(r2)
            goto L53
        L4b:
            r2 = r3
            goto L24
        L4d:
            int r1 = r1.length()
            r0.f4599w = r1
        L53:
            r1 = 10
            if (r4 != r1) goto L58
            return r7
        L58:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r1 = "Expected EOF after parsing, but had "
            r7.<init>(r1)
            int r1 = r0.f4599w
            int r1 = r1 + (-1)
            char r8 = r8.charAt(r1)
            r7.append(r8)
            java.lang.String r8 = " instead"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r8 = 0
            r1 = 6
            ff.m.q(r0, r7, r8, r1)
            r7 = 0
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ef.b.a(ze.a, java.lang.String):java.lang.Object");
    }

    public final String b(ze.a aVar, Object obj) {
        char[] cArr;
        i.e(aVar, "serializer");
        o oVar = new o((char) 0, 1);
        ff.b bVar = ff.b.f4576c;
        synchronized (bVar) {
            h hVar = (h) bVar.f730b;
            cArr = null;
            char[] cArr2 = (char[]) (hVar.isEmpty() ? null : hVar.removeLast());
            if (cArr2 != null) {
                bVar.f729a -= cArr2.length;
                cArr = cArr2;
            }
        }
        if (cArr == null) {
            cArr = new char[128];
        }
        oVar.f455x = cArr;
        try {
            ff.o oVar2 = ff.o.f4605x;
            l[] lVarArr = new l[ff.o.C.a()];
            this.f3893a.getClass();
            new l(new o4(oVar), this, oVar2, lVarArr).i(aVar, obj);
            return oVar.toString();
        } finally {
            oVar.m();
        }
    }
}
