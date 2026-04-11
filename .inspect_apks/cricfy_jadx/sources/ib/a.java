package ib;

import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f6383e = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f6384a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f6387d;

    public a(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        this.f6385b = str;
        this.f6386c = i;
        this.f6387d = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = f6383e.newThread(new androidx.fragment.app.d(17, this, runnable));
        Locale locale = Locale.ROOT;
        threadNewThread.setName(this.f6385b + " Thread #" + this.f6384a.getAndIncrement());
        return threadNewThread;
    }
}
