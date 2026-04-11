package oa;

import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import o2.i0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f9449e = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f9450a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f9453d;

    public a(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        this.f9451b = str;
        this.f9452c = i;
        this.f9453d = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = f9449e.newThread(new i0(this, 2, runnable));
        Locale locale = Locale.ROOT;
        threadNewThread.setName(this.f9451b + " Thread #" + this.f9450a.getAndIncrement());
        return threadNewThread;
    }
}
