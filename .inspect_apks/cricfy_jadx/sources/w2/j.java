package w2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends Handler implements Runnable {
    public int A;
    public Thread B;
    public boolean C;
    public volatile boolean D;
    public final /* synthetic */ o E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f13875v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final k f13876w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f13877x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public i f13878y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public IOException f13879z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(o oVar, Looper looper, k kVar, i iVar, int i, long j4) {
        super(looper);
        this.E = oVar;
        this.f13876w = kVar;
        this.f13878y = iVar;
        this.f13875v = i;
        this.f13877x = j4;
    }

    public final void a(boolean z10) {
        this.D = z10;
        this.f13879z = null;
        if (hasMessages(1)) {
            this.C = true;
            removeMessages(1);
            if (!z10) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                try {
                    this.C = true;
                    this.f13876w.d();
                    Thread thread = this.B;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z10) {
            this.E.f13885b = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            i iVar = this.f13878y;
            iVar.getClass();
            iVar.n(this.f13876w, jElapsedRealtime, jElapsedRealtime - this.f13877x, true);
            this.f13878y = null;
        }
    }

    public final void b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j4 = jElapsedRealtime - this.f13877x;
        i iVar = this.f13878y;
        iVar.getClass();
        iVar.B(this.f13876w, jElapsedRealtime, j4, this.A);
        this.f13879z = null;
        o oVar = this.E;
        x2.a aVar = oVar.f13884a;
        j jVar = oVar.f13885b;
        jVar.getClass();
        aVar.execute(jVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.D) {
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
        this.E.f13885b = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j4 = jElapsedRealtime - this.f13877x;
        i iVar = this.f13878y;
        iVar.getClass();
        if (this.C) {
            iVar.n(this.f13876w, jElapsedRealtime, j4, false);
            return;
        }
        int i10 = message.what;
        if (i10 == 2) {
            try {
                iVar.k(this.f13876w, jElapsedRealtime, j4);
                return;
            } catch (RuntimeException e9) {
                y1.b.h("LoadTask", "Unexpected exception handling load completed", e9);
                this.E.f13886c = new n(e9);
                return;
            }
        }
        if (i10 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.f13879z = iOException;
        int i11 = this.A + 1;
        this.A = i11;
        i4.e eVarG = iVar.g(this.f13876w, jElapsedRealtime, j4, iOException, i11);
        int i12 = eVarG.f6206a;
        if (i12 == 3) {
            this.E.f13886c = this.f13879z;
            return;
        }
        if (i12 != 2) {
            if (i12 == 1) {
                this.A = 1;
            }
            long jMin = eVarG.f6207b;
            if (jMin == -9223372036854775807L) {
                jMin = Math.min((this.A - 1) * 1000, 5000);
            }
            o oVar = this.E;
            y1.d.g(oVar.f13885b == null);
            oVar.f13885b = this;
            if (jMin > 0) {
                sendEmptyMessageDelayed(1, jMin);
            } else {
                b();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        try {
            synchronized (this) {
                z10 = this.C;
                this.B = Thread.currentThread();
            }
            if (!z10) {
                Trace.beginSection("load:".concat(this.f13876w.getClass().getSimpleName()));
                try {
                    this.f13876w.a();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.B = null;
                Thread.interrupted();
            }
            if (this.D) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e9) {
            if (this.D) {
                return;
            }
            obtainMessage(3, e9).sendToTarget();
        } catch (Exception e10) {
            if (this.D) {
                return;
            }
            y1.b.h("LoadTask", "Unexpected exception loading stream", e10);
            obtainMessage(3, new n(e10)).sendToTarget();
        } catch (OutOfMemoryError e11) {
            if (this.D) {
                return;
            }
            y1.b.h("LoadTask", "OutOfMemory error loading stream", e11);
            obtainMessage(3, new n(e11)).sendToTarget();
        } catch (Error e12) {
            if (!this.D) {
                y1.b.h("LoadTask", "Unexpected error loading stream", e12);
                obtainMessage(4, e12).sendToTarget();
            }
            throw e12;
        }
    }
}
