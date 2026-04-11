package p7;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import o8.o;
import v1.r;
import w1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements v1.g {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static m f10282y;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10283u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f10284v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f10285w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f10286x;

    public m(int i, String str, int i10, ArrayList arrayList, byte[] bArr) {
        this.f10284v = str;
        this.f10283u = i10;
        this.f10285w = arrayList == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList);
        this.f10286x = bArr;
    }

    public static synchronized m d(Context context) {
        try {
            if (f10282y == null) {
                ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new y7.a("MessengerIpcClient")));
                m mVar = new m();
                mVar.f10286x = new k(mVar);
                mVar.f10283u = 1;
                mVar.f10285w = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                mVar.f10284v = context.getApplicationContext();
                f10282y = mVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f10282y;
    }

    public int a() {
        int i = this.f10283u;
        if (i != 2) {
            return i != 3 ? 0 : 512;
        }
        return 2048;
    }

    public Looper b() {
        Looper looper;
        synchronized (this.f10284v) {
            try {
                if (((Looper) this.f10285w) == null) {
                    s1.d.g(this.f10283u == 0 && ((HandlerThread) this.f10286x) == null);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    this.f10286x = handlerThread;
                    handlerThread.start();
                    this.f10285w = ((HandlerThread) this.f10286x).getLooper();
                }
                this.f10283u++;
                looper = (Looper) this.f10285w;
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public void c() {
        HandlerThread handlerThread;
        synchronized (this.f10284v) {
            try {
                s1.d.g(this.f10283u > 0);
                int i = this.f10283u - 1;
                this.f10283u = i;
                if (i == 0 && (handlerThread = (HandlerThread) this.f10286x) != null) {
                    handlerThread.quit();
                    this.f10286x = null;
                    this.f10285w = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized o e(l lVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(lVar.toString()));
            }
            if (!((k) this.f10286x).d(lVar)) {
                k kVar = new k(this);
                this.f10286x = kVar;
                kVar.d(lVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return lVar.f10278b.f9421a;
    }

    @Override // v1.g
    public v1.h g() {
        pb.c cVar = (pb.c) this.f10286x;
        v1.h hVarG = cVar != null ? cVar.g() : null;
        int i = this.f10283u;
        u uVar = (u) this.f10284v;
        uVar.getClass();
        return new w1.e(uVar, hVarG, ((r) this.f10285w).g(), hVarG != null ? new w1.d(uVar) : null, i);
    }
}
