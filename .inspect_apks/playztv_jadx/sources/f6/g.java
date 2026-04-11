package f6;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import x6.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements a {
    public static final Bitmap.Config D = Bitmap.Config.ARGB_8888;
    public int A;
    public int B;
    public int C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k f4772u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Set f4773v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final lb.e f4774w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f4775x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f4776y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4777z;

    public g(long j5) {
        k kVar = new k();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f4775x = j5;
        this.f4772u = kVar;
        this.f4773v = setUnmodifiableSet;
        this.f4774w = new lb.e(11);
    }

    public final void a() {
        Log.v("LruBitmapPool", "Hits=" + this.f4777z + ", misses=" + this.A + ", puts=" + this.B + ", evictions=" + this.C + ", currentSize=" + this.f4776y + ", maxSize=" + this.f4775x + "\nStrategy=" + this.f4772u);
    }

    public final synchronized Bitmap b(int i, int i10, Bitmap.Config config) {
        Bitmap bitmapB;
        try {
            if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
            bitmapB = this.f4772u.b(i, i10, config != null ? config : D);
            if (bitmapB == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb2 = new StringBuilder("Missing bitmap=");
                    this.f4772u.getClass();
                    sb2.append(k.c(m.d(config) * i * i10, config));
                    Log.d("LruBitmapPool", sb2.toString());
                }
                this.A++;
            } else {
                this.f4777z++;
                long j5 = this.f4776y;
                this.f4772u.getClass();
                this.f4776y = j5 - ((long) m.c(bitmapB));
                this.f4774w.getClass();
                bitmapB.setHasAlpha(true);
                bitmapB.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb3 = new StringBuilder("Get bitmap=");
                this.f4772u.getClass();
                sb3.append(k.c(m.d(config) * i * i10, config));
                Log.v("LruBitmapPool", sb3.toString());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bitmapB;
    }

    public final synchronized void c(long j5) {
        while (this.f4776y > j5) {
            try {
                k kVar = this.f4772u;
                Bitmap bitmap = (Bitmap) kVar.f4787b.i0();
                if (bitmap != null) {
                    kVar.a(Integer.valueOf(m.c(bitmap)), bitmap);
                }
                if (bitmap == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        a();
                    }
                    this.f4776y = 0L;
                    return;
                }
                this.f4774w.getClass();
                long j8 = this.f4776y;
                this.f4772u.getClass();
                this.f4776y = j8 - ((long) m.c(bitmap));
                this.C++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Evicting bitmap=");
                    this.f4772u.getClass();
                    sb2.append(k.c(m.c(bitmap), bitmap.getConfig()));
                    Log.d("LruBitmapPool", sb2.toString());
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

    @Override // f6.a
    public final Bitmap d(int i, int i10, Bitmap.Config config) {
        Bitmap bitmapB = b(i, i10, config);
        if (bitmapB != null) {
            return bitmapB;
        }
        if (config == null) {
            config = D;
        }
        return Bitmap.createBitmap(i, i10, config);
    }

    @Override // f6.a
    public final Bitmap e(int i, int i10, Bitmap.Config config) {
        Bitmap bitmapB = b(i, i10, config);
        if (bitmapB != null) {
            bitmapB.eraseColor(0);
            return bitmapB;
        }
        if (config == null) {
            config = D;
        }
        return Bitmap.createBitmap(i, i10, config);
    }

    @Override // f6.a
    public final synchronized void f(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.f4772u.getClass();
                if (m.c(bitmap) <= this.f4775x && this.f4773v.contains(bitmap.getConfig())) {
                    this.f4772u.getClass();
                    int iC = m.c(bitmap);
                    this.f4772u.e(bitmap);
                    this.f4774w.getClass();
                    this.B++;
                    this.f4776y += (long) iC;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb2 = new StringBuilder("Put bitmap in pool=");
                        this.f4772u.getClass();
                        sb2.append(k.c(m.c(bitmap), bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb2.toString());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        a();
                    }
                    c(this.f4775x);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb3 = new StringBuilder("Reject bitmap from pool, bitmap: ");
                this.f4772u.getClass();
                sb3.append(k.c(m.c(bitmap), bitmap.getConfig()));
                sb3.append(", is mutable: ");
                sb3.append(bitmap.isMutable());
                sb3.append(", is allowed config: ");
                sb3.append(this.f4773v.contains(bitmap.getConfig()));
                Log.v("LruBitmapPool", sb3.toString());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // f6.a
    public final void j(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40 || i >= 20) {
            m();
        } else if (i >= 20 || i == 15) {
            c(this.f4775x / 2);
        }
    }

    @Override // f6.a
    public final void m() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        c(0L);
    }
}
