package g7;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f5219e;
    public static final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final File f5220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile w f5221h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5224c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f5225d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5222a = 20000;

    static {
        int i = Build.VERSION.SDK_INT;
        f5219e = i < 29;
        f = i >= 28;
        f5220g = new File("/proc/self/fd");
    }

    public static w a() {
        if (f5221h == null) {
            synchronized (w.class) {
                try {
                    if (f5221h == null) {
                        f5221h = new w();
                    }
                } finally {
                }
            }
        }
        return f5221h;
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
        return this.f5222a;
    }

    public final boolean c(int i, int i10, boolean z10, boolean z11) {
        boolean z12;
        if (z10) {
            if (f) {
                if (!f5219e || this.f5225d.get()) {
                    if (z11) {
                        if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
                            return false;
                        }
                    } else if (i >= 0 && i10 >= 0) {
                        synchronized (this) {
                            try {
                                int i11 = this.f5223b + 1;
                                this.f5223b = i11;
                                if (i11 >= 50) {
                                    this.f5223b = 0;
                                    int length = f5220g.list().length;
                                    long jB = b();
                                    boolean z13 = ((long) length) < jB;
                                    this.f5224c = z13;
                                    if (!z13 && Log.isLoggable("Downsampler", 5)) {
                                        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jB);
                                    }
                                }
                                z12 = this.f5224c;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z12) {
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
