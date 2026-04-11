package f9;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4344v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ i0 f4345w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ s3 f4346x;

    public /* synthetic */ q3(s3 s3Var, i0 i0Var, int i) {
        this.f4344v = i;
        this.f4345w = i0Var;
        this.f4346x = s3Var;
    }

    private final void a() {
        s3 s3Var = this.f4346x;
        synchronized (s3Var) {
            try {
                s3Var.f4400v = false;
                t3 t3Var = s3Var.f4402x;
                if (!t3Var.D1()) {
                    w0 w0Var = ((r1) t3Var.f307w).A;
                    r1.g(w0Var);
                    w0Var.J.a("Connected to service");
                    i0 i0Var = this.f4345w;
                    t3Var.m1();
                    t3Var.f4420z = i0Var;
                    t3Var.z1();
                    t3Var.B1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4344v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                return;
            default:
                s3 s3Var = this.f4346x;
                synchronized (s3Var) {
                    try {
                        s3Var.f4400v = false;
                        t3 t3Var = s3Var.f4402x;
                        if (!t3Var.D1()) {
                            w0 w0Var = ((r1) t3Var.f307w).A;
                            r1.g(w0Var);
                            w0Var.I.a("Connected to remote service");
                            i0 i0Var = this.f4345w;
                            t3Var.m1();
                            t3Var.f4420z = i0Var;
                            t3Var.z1();
                            t3Var.B1();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                t3 t3Var2 = this.f4346x.f4402x;
                ScheduledExecutorService scheduledExecutorService = t3Var2.C;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                    t3Var2.C = null;
                    return;
                }
                return;
        }
    }
}
