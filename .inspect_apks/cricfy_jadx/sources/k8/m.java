package k8;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import b2.u;
import c2.v;
import j9.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import l4.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements b2.g {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static m f7278z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7279v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f7280w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f7281x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f7282y;

    public m(int i, String str, int i10, ArrayList arrayList, byte[] bArr) {
        this.f7280w = str;
        this.f7279v = i10;
        this.f7281x = arrayList == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList);
        this.f7282y = bArr;
    }

    public static synchronized m d(Context context) {
        try {
            if (f7278z == null) {
                ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new t8.a("MessengerIpcClient")));
                m mVar = new m();
                mVar.f7282y = new k(mVar);
                mVar.f7279v = 1;
                mVar.f7281x = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                mVar.f7280w = context.getApplicationContext();
                f7278z = mVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7278z;
    }

    public int a() {
        int i = this.f7279v;
        if (i != 2) {
            return i != 3 ? 0 : 512;
        }
        return 2048;
    }

    public Looper b() {
        Looper looper;
        synchronized (this.f7280w) {
            try {
                if (((Looper) this.f7281x) == null) {
                    y1.d.g(this.f7279v == 0 && ((HandlerThread) this.f7282y) == null);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    this.f7282y = handlerThread;
                    handlerThread.start();
                    this.f7281x = ((HandlerThread) this.f7282y).getLooper();
                }
                this.f7279v++;
                looper = (Looper) this.f7281x;
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public void c() {
        HandlerThread handlerThread;
        synchronized (this.f7280w) {
            try {
                y1.d.g(this.f7279v > 0);
                int i = this.f7279v - 1;
                this.f7279v = i;
                if (i == 0 && (handlerThread = (HandlerThread) this.f7282y) != null) {
                    handlerThread.quit();
                    this.f7282y = null;
                    this.f7281x = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized p e(l lVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(lVar.toString()));
            }
            if (!((k) this.f7282y).d(lVar)) {
                k kVar = new k(this);
                this.f7282y = kVar;
                kVar.d(lVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return lVar.f7274b.f6688a;
    }

    @Override // b2.g
    public b2.h h() {
        c0 c0Var = (c0) this.f7282y;
        b2.h hVarH = c0Var != null ? c0Var.h() : null;
        int i = this.f7279v;
        v vVar = (v) this.f7280w;
        vVar.getClass();
        return new c2.e(vVar, hVarH, ((u) this.f7281x).h(), hVarH != null ? new c2.d(vVar) : null, i);
    }
}
