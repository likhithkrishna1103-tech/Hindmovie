package ub;

import android.os.SystemClock;
import android.util.Log;
import j9.i;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import nb.w;
import u7.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f12425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f12426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12429e;
    public final ArrayBlockingQueue f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f12430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final dd.c f12431h;
    public final w i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12432j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f12433k;

    public c(dd.c cVar, vb.a aVar, w wVar) {
        double d10 = aVar.f13548d;
        double d11 = aVar.f13549e;
        long j4 = ((long) aVar.f) * 1000;
        this.f12425a = d10;
        this.f12426b = d11;
        this.f12427c = j4;
        this.f12431h = cVar;
        this.i = wVar;
        this.f12428d = SystemClock.elapsedRealtime();
        int i = (int) d10;
        this.f12429e = i;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i);
        this.f = arrayBlockingQueue;
        this.f12430g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f12432j = 0;
        this.f12433k = 0L;
    }

    public final int a() {
        if (this.f12433k == 0) {
            this.f12433k = System.currentTimeMillis();
        }
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f12433k) / this.f12427c);
        int iMin = this.f.size() == this.f12429e ? Math.min(100, this.f12432j + iCurrentTimeMillis) : Math.max(0, this.f12432j - iCurrentTimeMillis);
        if (this.f12432j != iMin) {
            this.f12432j = iMin;
            this.f12433k = System.currentTimeMillis();
        }
        return iMin;
    }

    public final void b(nb.a aVar, i iVar) {
        String str = "Sending report through Google DataTransport: " + aVar.f8923b;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
        this.f12431h.s(new u7.a(aVar.f8922a, d.f12283x, null), new b(SystemClock.elapsedRealtime() - this.f12428d < 2000, this, iVar, aVar));
    }
}
