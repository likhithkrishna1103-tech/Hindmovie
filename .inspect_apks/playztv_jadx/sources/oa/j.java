package oa;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Executor {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final j f9477u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Handler f9478v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ j[] f9479w;

    static {
        j jVar = new j("INSTANCE", 0);
        f9477u = jVar;
        f9479w = new j[]{jVar};
        f9478v = new Handler(Looper.getMainLooper());
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f9479w.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f9478v.post(runnable);
    }
}
