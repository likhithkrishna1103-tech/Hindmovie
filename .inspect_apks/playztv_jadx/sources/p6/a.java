package p6;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import c6.k;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.google.android.gms.internal.measurement.k4;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import k8.b0;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k {
    public static final b0 f = new b0(21);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g6.c f10207g = new g6.c(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f10209b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k4 f10212e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f10211d = f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g6.c f10210c = f10207g;

    public a(Context context, ArrayList arrayList, f6.a aVar, f6.f fVar) {
        this.f10208a = context.getApplicationContext();
        this.f10209b = arrayList;
        this.f10212e = new k4(aVar, fVar);
    }

    public static int d(a6.b bVar, int i, int i10) {
        int iMin = Math.min(bVar.f585g / i10, bVar.f / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            StringBuilder sbP = l4.a.p(iMax, i, "Downsampling GIF, sampleSize: ", ", target dimens: [", "x");
            sbP.append(i10);
            sbP.append("], actual dimens: [");
            sbP.append(bVar.f);
            sbP.append("x");
            sbP.append(bVar.f585g);
            sbP.append("]");
            Log.v("BufferGifDecoder", sbP.toString());
        }
        return iMax;
    }

    @Override // c6.k
    public final boolean a(Object obj, c6.i iVar) {
        return !((Boolean) iVar.c(h.f10243b)).booleanValue() && t1.q(this.f10209b, (ByteBuffer) obj) == ImageHeaderParser$ImageType.GIF;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:25:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // c6.k
    public final e6.b0 b(java.lang.Object r8, int r9, int r10, c6.i r11) {
        /*
            r7 = this;
            r2 = r8
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            g6.c r8 = r7.f10210c
            monitor-enter(r8)
            java.util.ArrayDeque r0 = r8.f5321a     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L54
            a6.c r0 = (a6.c) r0     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L15
            a6.c r0 = new a6.c     // Catch: java.lang.Throwable -> L17
            r0.<init>()     // Catch: java.lang.Throwable -> L17
        L15:
            r5 = r0
            goto L1b
        L17:
            r0 = move-exception
            r9 = r0
            r1 = r7
            goto L57
        L1b:
            r0 = 0
            r5.f590b = r0     // Catch: java.lang.Throwable -> L54
            byte[] r0 = r5.f589a     // Catch: java.lang.Throwable -> L54
            r1 = 0
            java.util.Arrays.fill(r0, r1)     // Catch: java.lang.Throwable -> L54
            a6.b r0 = new a6.b     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            r5.f591c = r0     // Catch: java.lang.Throwable -> L54
            r5.f592d = r1     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r2.asReadOnlyBuffer()     // Catch: java.lang.Throwable -> L54
            r5.f590b = r0     // Catch: java.lang.Throwable -> L54
            r0.position(r1)     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r5.f590b     // Catch: java.lang.Throwable -> L54
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch: java.lang.Throwable -> L54
            r0.order(r1)     // Catch: java.lang.Throwable -> L54
            monitor-exit(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r11
            n6.b r8 = r1.c(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4c
            g6.c r9 = r1.f10210c
            r9.c(r5)
            return r8
        L4c:
            r0 = move-exception
            r8 = r0
            g6.c r9 = r1.f10210c
            r9.c(r5)
            throw r8
        L54:
            r0 = move-exception
            r1 = r7
        L56:
            r9 = r0
        L57:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L59
            throw r9
        L59:
            r0 = move-exception
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: p6.a.b(java.lang.Object, int, int, c6.i):e6.b0");
    }

    public final n6.b c(ByteBuffer byteBuffer, int i, int i10, a6.c cVar, c6.i iVar) {
        StringBuilder sb2;
        int i11 = x6.h.f14283b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            a6.b bVarB = cVar.b();
            n6.b bVar = null;
            if (bVarB.f582c > 0 && bVarB.f581b == 0) {
                Bitmap.Config config = iVar.c(h.f10242a) == c6.a.f2511v ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int iD = d(bVarB, i, i10);
                b0 b0Var = this.f10211d;
                k4 k4Var = this.f10212e;
                b0Var.getClass();
                a6.d dVar = new a6.d(k4Var, bVarB, byteBuffer, iD);
                dVar.c(config);
                dVar.f601k = (dVar.f601k + 1) % dVar.f602l.f582c;
                Bitmap bitmapB = dVar.b();
                if (bitmapB == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb2 = new StringBuilder("Decoded GIF from stream in ");
                    }
                    return null;
                }
                bVar = new n6.b(new b(new h5.e(2, new g(com.bumptech.glide.b.a(this.f10208a), dVar, i, i10, bitmapB))), 1);
                if (!Log.isLoggable("BufferGifDecoder", 2)) {
                    return bVar;
                }
                sb2 = new StringBuilder("Decoded GIF from stream in ");
                sb2.append(x6.h.a(jElapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb2.toString());
                return bVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                sb2 = new StringBuilder("Decoded GIF from stream in ");
                sb2.append(x6.h.a(jElapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb2.toString());
                return bVar;
            }
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + x6.h.a(jElapsedRealtimeNanos));
            }
            throw th;
        }
    }
}
