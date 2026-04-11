package k7;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import f9.c0;
import i2.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import x6.j;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements j {
    public static final c0 f = new c0(14);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b7.c f7206g = new b7.c(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7208b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f7211e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f7210d = f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.c f7209c = f7206g;

    public a(Context context, ArrayList arrayList, a7.b bVar, a7.g gVar) {
        this.f7207a = context.getApplicationContext();
        this.f7208b = arrayList;
        this.f7211e = new k(bVar, gVar);
    }

    public static int d(v6.b bVar, int i, int i10) {
        int iMin = Math.min(bVar.f13470g / i10, bVar.f / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            StringBuilder sbR = q4.a.r(iMax, i, "Downsampling GIF, sampleSize: ", ", target dimens: [", "x");
            sbR.append(i10);
            sbR.append("], actual dimens: [");
            sbR.append(bVar.f);
            sbR.append("x");
            sbR.append(bVar.f13470g);
            sbR.append("]");
            Log.v("BufferGifDecoder", sbR.toString());
        }
        return iMax;
    }

    @Override // x6.j
    public final boolean a(Object obj, x6.h hVar) {
        return !((Boolean) hVar.c(h.f7240b)).booleanValue() && com.bumptech.glide.c.u(this.f7208b, (ByteBuffer) obj) == ImageHeaderParser$ImageType.GIF;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:25:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // x6.j
    public final z6.b0 b(java.lang.Object r8, int r9, int r10, x6.h r11) {
        /*
            r7 = this;
            r2 = r8
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            b7.c r8 = r7.f7209c
            monitor-enter(r8)
            java.util.ArrayDeque r0 = r8.f1824a     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L54
            v6.c r0 = (v6.c) r0     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L15
            v6.c r0 = new v6.c     // Catch: java.lang.Throwable -> L17
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
            r5.f13475b = r0     // Catch: java.lang.Throwable -> L54
            byte[] r0 = r5.f13474a     // Catch: java.lang.Throwable -> L54
            r1 = 0
            java.util.Arrays.fill(r0, r1)     // Catch: java.lang.Throwable -> L54
            v6.b r0 = new v6.b     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            r5.f13476c = r0     // Catch: java.lang.Throwable -> L54
            r5.f13477d = r1     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r2.asReadOnlyBuffer()     // Catch: java.lang.Throwable -> L54
            r5.f13475b = r0     // Catch: java.lang.Throwable -> L54
            r0.position(r1)     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r5.f13475b     // Catch: java.lang.Throwable -> L54
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch: java.lang.Throwable -> L54
            r0.order(r1)     // Catch: java.lang.Throwable -> L54
            monitor-exit(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r11
            i7.b r8 = r1.c(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4c
            b7.c r9 = r1.f7209c
            r9.c(r5)
            return r8
        L4c:
            r0 = move-exception
            r8 = r0
            b7.c r9 = r1.f7209c
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
        throw new UnsupportedOperationException("Method not decompiled: k7.a.b(java.lang.Object, int, int, x6.h):z6.b0");
    }

    public final i7.b c(ByteBuffer byteBuffer, int i, int i10, v6.c cVar, x6.h hVar) {
        StringBuilder sb;
        int i11 = s7.h.f11599b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            v6.b bVarB = cVar.b();
            i7.b bVar = null;
            if (bVarB.f13467c > 0 && bVarB.f13466b == 0) {
                Bitmap.Config config = hVar.c(h.f7239a) == x6.a.f14393w ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int iD = d(bVarB, i, i10);
                c0 c0Var = this.f7210d;
                k kVar = this.f7211e;
                c0Var.getClass();
                v6.d dVar = new v6.d(kVar, bVarB, byteBuffer, iD);
                dVar.c(config);
                dVar.f13486k = (dVar.f13486k + 1) % dVar.f13487l.f13467c;
                Bitmap bitmapB = dVar.b();
                if (bitmapB == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb = new StringBuilder("Decoded GIF from stream in ");
                    }
                    return null;
                }
                bVar = new i7.b(new b(new ba.a(1, new g(com.bumptech.glide.b.a(this.f7207a), dVar, i, i10, bitmapB))), 1);
                if (!Log.isLoggable("BufferGifDecoder", 2)) {
                    return bVar;
                }
                sb = new StringBuilder("Decoded GIF from stream in ");
                sb.append(s7.h.a(jElapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb.toString());
                return bVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                sb = new StringBuilder("Decoded GIF from stream in ");
                sb.append(s7.h.a(jElapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb.toString());
                return bVar;
            }
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + s7.h.a(jElapsedRealtimeNanos));
            }
            throw th;
        }
    }
}
