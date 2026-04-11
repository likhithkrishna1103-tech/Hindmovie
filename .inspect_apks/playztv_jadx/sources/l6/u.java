package l6;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f8001e;
    public static final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final File f8002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile u f8003h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8006c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f8007d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8004a = 20000;

    static {
        int i = Build.VERSION.SDK_INT;
        f8001e = i < 29;
        f = i >= 28;
        f8002g = new File("/proc/self/fd");
    }

    public static u a() {
        if (f8003h == null) {
            synchronized (u.class) {
                try {
                    if (f8003h == null) {
                        f8003h = new u();
                    }
                } finally {
                }
            }
        }
        return f8003h;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT == 28) {
            Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
            while (it.hasNext()) {
                if (Build.MODEL.startsWith((String) it.next())) {
                    return 500;
                }
            }
        }
        return this.f8004a;
    }

    public final boolean c(int i, int i10, boolean z2, boolean z10) {
        boolean z11;
        if (z2) {
            if (f) {
                if (!f8001e || this.f8007d.get()) {
                    if (z10) {
                        if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
                            return false;
                        }
                    } else if (i >= 0 && i10 >= 0) {
                        synchronized (this) {
                            try {
                                int i11 = this.f8005b + 1;
                                this.f8005b = i11;
                                if (i11 >= 50) {
                                    this.f8005b = 0;
                                    int length = f8002g.list().length;
                                    long jB = b();
                                    boolean z12 = ((long) length) < jB;
                                    this.f8006c = z12;
                                    if (!z12 && Log.isLoggable("Downsampler", 5)) {
                                        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jB);
                                    }
                                }
                                z11 = this.f8006c;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z11) {
                            return true;
                        }
                        if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                            return false;
                        }
                    } else if (Log.isLoggable("HardwareConfig", 2)) {
                        Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
                    }
                } else if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed by app state");
                    return false;
                }
            } else if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
                return false;
            }
        } else if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed by caller");
            return false;
        }
        return false;
    }
}
