package s2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends Handler implements Runnable {
    public Thread A;
    public boolean B;
    public volatile boolean C;
    public final /* synthetic */ m D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f11758u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j f11759v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f11760w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public h f11761x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public IOException f11762y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11763z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(m mVar, Looper looper, j jVar, h hVar, int i, long j5) {
        super(looper);
        this.D = mVar;
        this.f11759v = jVar;
        this.f11761x = hVar;
        this.f11758u = i;
        this.f11760w = j5;
    }

    public final void a(boolean z2) {
        this.C = z2;
        this.f11762y = null;
        if (hasMessages(1)) {
            this.B = true;
            removeMessages(1);
            if (!z2) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                try {
                    this.B = true;
                    this.f11759v.c();
                    Thread thread = this.A;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z2) {
            this.D.f11768v = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            h hVar = this.f11761x;
            hVar.getClass();
            hVar.u(this.f11759v, jElapsedRealtime, jElapsedRealtime - this.f11760w, true);
            this.f11761x = null;
        }
    }

    public final void b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = jElapsedRealtime - this.f11760w;
        h hVar = this.f11761x;
        hVar.getClass();
        hVar.k(this.f11759v, jElapsedRealtime, j5, this.f11763z);
        this.f11762y = null;
        m mVar = this.D;
        t2.a aVar = mVar.f11767u;
        i iVar = mVar.f11768v;
        iVar.getClass();
        aVar.execute(iVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.C) {
            return;
        }
        int i = message.what;
        if (i == 1) {
            b();
            return;
        }
        if (i == 4) {
            throw ((Error) message.obj);
        }
        this.D.f11768v = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = jElapsedRealtime - this.f11760w;
        h hVar = this.f11761x;
        hVar.getClass();
        if (this.B) {
            hVar.u(this.f11759v, jElapsedRealtime, j5, false);
            return;
        }
        int i10 = message.what;
        if (i10 == 2) {
            try {
                hVar.d(this.f11759v, jElapsedRealtime, j5);
                return;
            } catch (RuntimeException e10) {
                s1.b.h("LoadTask", "Unexpected exception handling load completed", e10);
                this.D.f11769w = new l(e10);
                return;
            }
        }
        if (i10 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.f11762y = iOException;
        int i11 = this.f11763z + 1;
        this.f11763z = i11;
        e4.f fVarM = hVar.m(this.f11759v, jElapsedRealtime, j5, iOException, i11);
        int i12 = fVarM.f4419a;
        if (i12 == 3) {
            this.D.f11769w = this.f11762y;
            return;
        }
        if (i12 != 2) {
            if (i12 == 1) {
                this.f11763z = 1;
            }
            long jMin = fVarM.f4420b;
            if (jMin == -9223372036854775807L) {
                jMin = Math.min((this.f11763z - 1) * 1000, 5000);
            }
            m mVar = this.D;
            s1.d.g(mVar.f11768v == null);
            mVar.f11768v = this;
            if (jMin > 0) {
                sendEmptyMessageDelayed(1, jMin);
            } else {
                b();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        try {
            synchronized (this) {
                z2 = this.B;
                this.A = Thread.currentThread();
            }
            if (!z2) {
                Trace.beginSection("load:".concat(this.f11759v.getClass().getSimpleName()));
                try {
                    this.f11759v.b();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.A = null;
                Thread.interrupted();
            }
            if (this.C) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e10) {
            if (this.C) {
                return;
            }
            obtainMessage(3, e10).sendToTarget();
        } catch (Exception e11) {
            if (this.C) {
                return;
            }
            s1.b.h("LoadTask", "Unexpected exception loading stream", e11);
            obtainMessage(3, new l(e11)).sendToTarget();
        } catch (OutOfMemoryError e12) {
            if (this.C) {
                return;
            }
            s1.b.h("LoadTask", "OutOfMemory error loading stream", e12);
            obtainMessage(3, new l(e12)).sendToTarget();
        } catch (Error e13) {
            if (!this.C) {
                s1.b.h("LoadTask", "Unexpected error loading stream", e13);
                obtainMessage(4, e13).sendToTarget();
            }
            throw e13;
        }
    }
}
