package c7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import com.google.android.gms.internal.measurement.k4;
import h4.z;
import n.q3;
import p1.m0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements x6.g, j2.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Context f2563u;

    public /* synthetic */ k(Context context) {
        this.f2563u = context;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 26) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007a, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 34) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(p1.q r5) {
        /*
            java.lang.String r0 = r5.f10023n
            r1 = 0
            if (r0 == 0) goto L86
            boolean r0 = p1.m0.m(r0)
            if (r0 != 0) goto Ld
            goto L86
        Ld:
            java.lang.String r5 = r5.f10023n
            int r0 = s1.b0.f11647a
            r5.getClass()
            int r0 = r5.hashCode()
            r2 = 4
            r3 = 1
            r4 = -1
            switch(r0) {
                case -1487656890: goto L61;
                case -1487464693: goto L56;
                case -1487464690: goto L4b;
                case -1487394660: goto L40;
                case -1487018032: goto L35;
                case -879272239: goto L2a;
                case -879258763: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L6b
        L1f:
            java.lang.String r0 = "image/png"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L28
            goto L6b
        L28:
            r4 = 6
            goto L6b
        L2a:
            java.lang.String r0 = "image/bmp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L33
            goto L6b
        L33:
            r4 = 5
            goto L6b
        L35:
            java.lang.String r0 = "image/webp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L3e
            goto L6b
        L3e:
            r4 = r2
            goto L6b
        L40:
            java.lang.String r0 = "image/jpeg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L49
            goto L6b
        L49:
            r4 = 3
            goto L6b
        L4b:
            java.lang.String r0 = "image/heif"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L54
            goto L6b
        L54:
            r4 = 2
            goto L6b
        L56:
            java.lang.String r0 = "image/heic"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L5f
            goto L6b
        L5f:
            r4 = r3
            goto L6b
        L61:
            java.lang.String r0 = "image/avif"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L6a
            goto L6b
        L6a:
            r4 = r1
        L6b:
            switch(r4) {
                case 0: goto L76;
                case 1: goto L6f;
                case 2: goto L6f;
                case 3: goto L7c;
                case 4: goto L7c;
                case 5: goto L7c;
                case 6: goto L7c;
                default: goto L6e;
            }
        L6e:
            goto L81
        L6f:
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r5 < r0) goto L81
            goto L7c
        L76:
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 34
            if (r5 < r0) goto L81
        L7c:
            int r5 = l4.a.g(r2, r1, r1, r1)
            return r5
        L81:
            int r5 = l4.a.g(r3, r1, r1, r1)
            return r5
        L86:
            int r5 = l4.a.g(r1, r1, r1, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c7.k.b(p1.q):int");
    }

    public l a() {
        Context context = this.f2563u;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        l lVar = new l();
        lVar.f2564u = e7.a.a(o.f2572a);
        e7.c cVar = new e7.c(context);
        lVar.f2565v = cVar;
        lVar.f2566w = e7.a.a(new z(cVar, 12, new wb.c(10, cVar)));
        e7.c cVar2 = lVar.f2565v;
        lVar.f2567x = new wb.c(19, cVar2);
        md.a aVarA = e7.a.a(new k4(lVar.f2567x, e7.a.a(new u5.d(18, cVar2))));
        lVar.f2568y = aVarA;
        t7.j jVar = new t7.j(13);
        e7.c cVar3 = lVar.f2565v;
        a7.b bVar = new a7.b(cVar3, aVarA, jVar, 23);
        md.a aVar = lVar.f2564u;
        md.a aVar2 = lVar.f2566w;
        lVar.f2569z = e7.a.a(new a7.b(new zc.c(aVar, aVar2, bVar, aVarA, aVarA), new q3(cVar3, aVar2, aVarA, bVar, aVar, aVarA, aVarA), new ub.o(aVar, aVarA, bVar, aVarA, 16), 8));
        return lVar;
    }

    @Override // x6.g
    public Object get() {
        return (ConnectivityManager) this.f2563u.getSystemService("connectivity");
    }

    @Override // j2.l
    public j2.m j(b2.g gVar) {
        Context context;
        int i = Build.VERSION.SDK_INT;
        if (i < 31 && ((context = this.f2563u) == null || i < 28 || !context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen"))) {
            return new lb.e(15).j(gVar);
        }
        int i10 = m0.i(((p1.q) gVar.f1739d).f10023n);
        s1.b.k("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + b0.E(i10));
        return new k4(new j2.c(i10, 0), new j2.c(i10, 1)).j(gVar);
    }
}
