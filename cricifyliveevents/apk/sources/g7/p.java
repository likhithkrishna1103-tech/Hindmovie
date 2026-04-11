package g7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public static final x6.g f = x6.g.a(x6.a.f14394x, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x6.g f5203g = new x6.g("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null, x6.g.f14398e);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final x6.g f5204h;
    public static final x6.g i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set f5205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f9.z f5206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ArrayDeque f5207l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.b f5208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f5209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a7.g f5210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f5211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f5212e = w.a();

    static {
        n nVar = n.f5196b;
        Boolean bool = Boolean.FALSE;
        f5204h = x6.g.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        i = x6.g.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        f5205j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f5206k = new f9.z(12);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] cArr = s7.m.f11607a;
        f5207l = new ArrayDeque(0);
    }

    public p(ArrayList arrayList, DisplayMetrics displayMetrics, a7.b bVar, a7.g gVar) {
        this.f5211d = arrayList;
        s7.f.c(displayMetrics, "Argument must not be null");
        this.f5209b = displayMetrics;
        s7.f.c(bVar, "Argument must not be null");
        this.f5208a = bVar;
        s7.f.c(gVar, "Argument must not be null");
        this.f5210c = gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap c(androidx.emoji2.text.v r9, android.graphics.BitmapFactory.Options r10, g7.o r11, a7.b r12) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r10.inJustDecodeBounds
            if (r1 != 0) goto L22
            r11.o()
            int r1 = r9.f887v
            switch(r1) {
                case 16: goto L22;
                case 17: goto Lf;
                default: goto Le;
            }
        Le:
            goto L22
        Lf:
            java.lang.Object r1 = r9.f888w
            com.bumptech.glide.load.data.h r1 = (com.bumptech.glide.load.data.h) r1
            java.lang.Object r1 = r1.f2236w
            g7.x r1 = (g7.x) r1
            monitor-enter(r1)
            byte[] r2 = r1.f5226v     // Catch: java.lang.Throwable -> L1f
            int r2 = r2.length     // Catch: java.lang.Throwable -> L1f
            r1.f5228x = r2     // Catch: java.lang.Throwable -> L1f
            monitor-exit(r1)
            goto L22
        L1f:
            r9 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1f
            throw r9
        L22:
            int r1 = r10.outWidth
            int r2 = r10.outHeight
            java.lang.String r3 = r10.outMimeType
            java.util.concurrent.locks.Lock r4 = g7.z.f5232b
            r4.lock()
            android.graphics.Bitmap r9 = r9.o(r10)     // Catch: java.lang.IllegalArgumentException -> L35 java.lang.Throwable -> L7c
            r4.unlock()
            return r9
        L35:
            r4 = move-exception
            java.io.IOException r5 = new java.io.IOException     // Catch: java.lang.Throwable -> L7c
            java.lang.String r6 = "Exception decoding bitmap, outWidth: "
            java.lang.String r7 = ", outHeight: "
            java.lang.String r8 = ", outMimeType: "
            java.lang.StringBuilder r1 = q4.a.r(r1, r2, r6, r7, r8)     // Catch: java.lang.Throwable -> L7c
            r1.append(r3)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = ", inBitmap: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            android.graphics.Bitmap r2 = r10.inBitmap     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = d(r2)     // Catch: java.lang.Throwable -> L7c
            r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L7c
            r5.<init>(r1, r4)     // Catch: java.lang.Throwable -> L7c
            r1 = 3
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L66
            java.lang.String r1 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r1, r5)     // Catch: java.lang.Throwable -> L7c
        L66:
            android.graphics.Bitmap r0 = r10.inBitmap     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L7b
            r12.d(r0)     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L7c
            r0 = 0
            r10.inBitmap = r0     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L7c
            android.graphics.Bitmap r9 = c(r9, r10, r11, r12)     // Catch: java.io.IOException -> L7a java.lang.Throwable -> L7c
            java.util.concurrent.locks.Lock r10 = g7.z.f5232b
            r10.unlock()
            return r9
        L7a:
            throw r5     // Catch: java.lang.Throwable -> L7c
        L7b:
            throw r5     // Catch: java.lang.Throwable -> L7c
        L7c:
            r9 = move-exception
            java.util.concurrent.locks.Lock r10 = g7.z.f5232b
            r10.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.p.c(androidx.emoji2.text.v, android.graphics.BitmapFactory$Options, g7.o, a7.b):android.graphics.Bitmap");
    }

    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static void e(BitmapFactory.Options options) {
        f(options);
        ArrayDeque arrayDeque = f5207l;
        synchronized (arrayDeque) {
            arrayDeque.offer(options);
        }
    }

    public static void f(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final d a(androidx.emoji2.text.v vVar, int i10, int i11, x6.h hVar, o oVar) {
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.f5210c.d(65536, byte[].class);
        synchronized (p.class) {
            ArrayDeque arrayDeque = f5207l;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                f(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        x6.a aVar = (x6.a) hVar.c(f);
        x6.i iVar = (x6.i) hVar.c(f5203g);
        n nVar = (n) hVar.c(n.f5200g);
        boolean zBooleanValue = ((Boolean) hVar.c(f5204h)).booleanValue();
        x6.g gVar = i;
        try {
            return d.b(this.f5208a, b(vVar, options2, nVar, aVar, iVar, hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue(), i10, i11, zBooleanValue, oVar));
        } finally {
            e(options2);
            this.f5210c.h(bArr);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x040b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x048e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:261:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0155 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0157  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(androidx.emoji2.text.v r43, android.graphics.BitmapFactory.Options r44, g7.n r45, x6.a r46, x6.i r47, boolean r48, int r49, int r50, boolean r51, g7.o r52) {
        /*
            Method dump skipped, instruction units count: 1608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.p.b(androidx.emoji2.text.v, android.graphics.BitmapFactory$Options, g7.n, x6.a, x6.i, boolean, int, int, boolean, g7.o):android.graphics.Bitmap");
    }
}
