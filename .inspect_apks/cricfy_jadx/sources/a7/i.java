package a7;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements b {
    public static final Bitmap.Config E = Bitmap.Config.ARGB_8888;
    public int A;
    public int B;
    public int C;
    public int D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final m f322v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Set f323w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final fc.e f324x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f325y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f326z;

    public i(long j4) {
        m mVar = new m();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f325y = j4;
        this.f322v = mVar;
        this.f323w = setUnmodifiableSet;
        this.f324x = new fc.e(2);
    }

    public final void a() {
        Log.v("LruBitmapPool", "Hits=" + this.A + ", misses=" + this.B + ", puts=" + this.C + ", evictions=" + this.D + ", currentSize=" + this.f326z + ", maxSize=" + this.f325y + "\nStrategy=" + this.f322v);
    }

    @Override // a7.b
    public final Bitmap b(int i, int i10, Bitmap.Config config) {
        Bitmap bitmapF = f(i, i10, config);
        if (bitmapF != null) {
            return bitmapF;
        }
        if (config == null) {
            config = E;
        }
        return Bitmap.createBitmap(i, i10, config);
    }

    @Override // a7.b
    public final Bitmap c(int i, int i10, Bitmap.Config config) {
        Bitmap bitmapF = f(i, i10, config);
        if (bitmapF != null) {
            bitmapF.eraseColor(0);
            return bitmapF;
        }
        if (config == null) {
            config = E;
        }
        return Bitmap.createBitmap(i, i10, config);
    }

    @Override // a7.b
    public final synchronized void d(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.f322v.getClass();
                if (s7.m.c(bitmap) <= this.f325y && this.f323w.contains(bitmap.getConfig())) {
                    this.f322v.getClass();
                    int iC = s7.m.c(bitmap);
                    this.f322v.e(bitmap);
                    this.f324x.getClass();
                    this.C++;
                    this.f326z += (long) iC;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb = new StringBuilder("Put bitmap in pool=");
                        this.f322v.getClass();
                        sb.append(m.c(s7.m.c(bitmap), bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb.toString());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        a();
                    }
                    h(this.f325y);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder("Reject bitmap from pool, bitmap: ");
                this.f322v.getClass();
                sb2.append(m.c(s7.m.c(bitmap), bitmap.getConfig()));
                sb2.append(", is mutable: ");
                sb2.append(bitmap.isMutable());
                sb2.append(", is allowed config: ");
                sb2.append(this.f323w.contains(bitmap.getConfig()));
                Log.v("LruBitmapPool", sb2.toString());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // a7.b
    public final void e(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40 || i >= 20) {
            g();
        } else if (i >= 20 || i == 15) {
            h(this.f325y / 2);
        }
    }

    public final synchronized Bitmap f(int i, int i10, Bitmap.Config config) {
        Bitmap bitmapB;
        try {
            if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
            bitmapB = this.f322v.b(i, i10, config != null ? config : E);
            if (bitmapB == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder("Missing bitmap=");
                    this.f322v.getClass();
                    sb.append(m.c(s7.m.d(config) * i * i10, config));
                    Log.d("LruBitmapPool", sb.toString());
                }
                this.B++;
            } else {
                this.A++;
                long j4 = this.f326z;
                this.f322v.getClass();
                this.f326z = j4 - ((long) s7.m.c(bitmapB));
                this.f324x.getClass();
                bitmapB.setHasAlpha(true);
                bitmapB.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder("Get bitmap=");
                this.f322v.getClass();
                sb2.append(m.c(s7.m.d(config) * i * i10, config));
                Log.v("LruBitmapPool", sb2.toString());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bitmapB;
    }

    @Override // a7.b
    public final void g() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        h(0L);
    }

    public final synchronized void h(long j4) {
        while (this.f326z > j4) {
            try {
                m mVar = this.f322v;
                Bitmap bitmap = (Bitmap) mVar.f336b.V();
                if (bitmap != null) {
                    mVar.a(Integer.valueOf(s7.m.c(bitmap)), bitmap);
                }
                if (bitmap == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        a();
                    }
                    this.f326z = 0L;
                    return;
                }
                this.f324x.getClass();
                long j7 = this.f326z;
                this.f322v.getClass();
                this.f326z = j7 - ((long) s7.m.c(bitmap));
                this.D++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    this.f322v.getClass();
                    sb.append(m.c(s7.m.c(bitmap), bitmap.getConfig()));
                    Log.d("LruBitmapPool", sb.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    a();
                }
                bitmap.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
