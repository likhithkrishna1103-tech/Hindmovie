package h;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Executor {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5544u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayDeque f5545v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Runnable f5546w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f5547x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Executor f5548y;

    public o(Executor executor) {
        this.f5544u = 1;
        be.h.e(executor, "executor");
        this.f5548y = executor;
        this.f5545v = new ArrayDeque();
        this.f5547x = new Object();
    }

    private final void a(Runnable runnable) {
        synchronized (this.f5547x) {
            try {
                this.f5545v.add(new a2.g0(this, 21, runnable));
                if (this.f5546w == null) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c() {
        synchronized (this.f5547x) {
            try {
                Runnable runnable = (Runnable) this.f5545v.poll();
                this.f5546w = runnable;
                if (runnable != null) {
                    ((p) this.f5548y).execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        switch (this.f5544u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c();
                return;
            default:
                synchronized (this.f5547x) {
                    Object objPoll = this.f5545v.poll();
                    Runnable runnable = (Runnable) objPoll;
                    this.f5546w = runnable;
                    if (objPoll != null) {
                        this.f5548y.execute(runnable);
                    }
                    break;
                }
                return;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f5544u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a(runnable);
                return;
            default:
                be.h.e(runnable, "command");
                synchronized (this.f5547x) {
                    this.f5545v.offer(new o2.i0(runnable, 6, this));
                    if (this.f5546w == null) {
                        b();
                    }
                    break;
                }
                return;
        }
    }

    public o(p pVar) {
        this.f5544u = 0;
        this.f5547x = new Object();
        this.f5545v = new ArrayDeque();
        this.f5548y = pVar;
    }
}
