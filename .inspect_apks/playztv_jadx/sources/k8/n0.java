package k8;

import android.content.Context;
import android.os.SystemClock;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static n0 f7324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Duration f7325e = Duration.ofMinutes(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f7326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v7.c f7327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f7328c = new AtomicLong(-1);

    public n0(Context context, k1 k1Var) {
        this.f7327b = new v7.c(context, v7.c.i, new t7.m("measurement:api"), r7.b.f11529b);
        this.f7326a = k1Var;
    }

    public final synchronized void a(int i, int i10, long j5, long j8) {
        this.f7326a.H.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f7328c.get() != -1 && jElapsedRealtime - this.f7328c.get() <= f7325e.toMillis()) {
            return;
        }
        o8.o oVarA = this.f7327b.a(new t7.l(0, Arrays.asList(new t7.i(36301, i, 0, j5, j8, null, null, 0, i10))));
        af.a aVar = new af.a(5);
        aVar.f797w = this;
        aVar.f796v = jElapsedRealtime;
        oVarA.getClass();
        oVarA.c(o8.i.f9422a, aVar);
    }
}
