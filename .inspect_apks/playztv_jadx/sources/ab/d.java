package ab;

import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o8.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f787e;
    public final ArrayBlockingQueue f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final zc.c f789h;
    public final pb.c i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f791k;

    public d(zc.c cVar, bb.c cVar2, pb.c cVar3) {
        double d10 = cVar2.f1983d;
        double d11 = cVar2.f1984e;
        long j5 = ((long) cVar2.f) * 1000;
        this.f783a = d10;
        this.f784b = d11;
        this.f785c = j5;
        this.f789h = cVar;
        this.i = cVar3;
        this.f786d = SystemClock.elapsedRealtime();
        int i = (int) d10;
        this.f787e = i;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i);
        this.f = arrayBlockingQueue;
        this.f788g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f790j = 0;
        this.f791k = 0L;
    }

    public final int a() {
        if (this.f791k == 0) {
            this.f791k = System.currentTimeMillis();
        }
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f791k) / this.f785c);
        int iMin = this.f.size() == this.f787e ? Math.min(100, this.f790j + iCurrentTimeMillis) : Math.max(0, this.f790j - iCurrentTimeMillis);
        if (this.f790j != iMin) {
            this.f790j = iMin;
            this.f791k = System.currentTimeMillis();
        }
        return iMin;
    }

    public final void b(ta.a aVar, h hVar) {
        String str = "Sending report through Google DataTransport: " + aVar.f12349b;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
        this.f789h.t(new z6.a(aVar.f12348a, z6.d.f14893w, null), new b(this, hVar, SystemClock.elapsedRealtime() - this.f786d < 2000, aVar));
    }
}
