package ib;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Executor {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final k f6411v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Handler f6412w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ k[] f6413x;

    static {
        k kVar = new k("INSTANCE", 0);
        f6411v = kVar;
        f6413x = new k[]{kVar};
        f6412w = new Handler(Looper.getMainLooper());
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f6413x.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f6412w.post(runnable);
    }
}
