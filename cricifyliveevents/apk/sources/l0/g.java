package l0;

import android.content.res.Resources;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vf.g f7609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v.j f7610b;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    static {
        /*
            java.lang.String r0 = "TypefaceCompat static init"
            com.bumptech.glide.c.b(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L13
            l0.l r0 = new l0.l
            r0.<init>()
            l0.g.f7609a = r0
            goto L4b
        L13:
            r1 = 28
            if (r0 < r1) goto L1f
            l0.k r0 = new l0.k
            r0.<init>()
            l0.g.f7609a = r0
            goto L4b
        L1f:
            r1 = 26
            if (r0 < r1) goto L2b
            l0.j r0 = new l0.j
            r0.<init>()
            l0.g.f7609a = r0
            goto L4b
        L2b:
            r1 = 24
            if (r0 < r1) goto L44
            java.lang.reflect.Method r0 = l0.i.f7615g
            if (r0 != 0) goto L3a
            java.lang.String r1 = "TypefaceCompatApi24Impl"
            java.lang.String r2 = "Unable to collect necessary private methods.Fallback to legacy implementation."
            android.util.Log.w(r1, r2)
        L3a:
            if (r0 == 0) goto L44
            l0.i r0 = new l0.i
            r0.<init>()
            l0.g.f7609a = r0
            goto L4b
        L44:
            l0.h r0 = new l0.h
            r0.<init>()
            l0.g.f7609a = r0
        L4b:
            v.j r0 = new v.j
            r1 = 16
            r0.<init>(r1)
            l0.g.f7610b = r0
            android.os.Trace.endSection()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.g.<clinit>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r16, k0.d r17, android.content.res.Resources r18, int r19, java.lang.String r20, int r21, int r22, k0.b r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.g.a(android.content.Context, k0.d, android.content.res.Resources, int, java.lang.String, int, int, k0.b, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i, String str, int i10, int i11) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i10 + '-' + i + '-' + i11;
    }
}
