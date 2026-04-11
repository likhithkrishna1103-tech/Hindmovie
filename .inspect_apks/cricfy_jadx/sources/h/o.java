package h;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Executor {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5389v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayDeque f5390w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Runnable f5391x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f5392y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Executor f5393z;

    public o(Executor executor) {
        this.f5389v = 1;
        ge.i.e(executor, "executor");
        this.f5393z = executor;
        this.f5390w = new ArrayDeque();
        this.f5392y = new Object();
    }

    private final void a(Runnable runnable) {
        synchronized (this.f5392y) {
            try {
                this.f5390w.add(new androidx.fragment.app.d(6, this, runnable));
                if (this.f5391x == null) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c() {
        synchronized (this.f5392y) {
            try {
                Runnable runnable = (Runnable) this.f5390w.poll();
                this.f5391x = runnable;
                if (runnable != null) {
                    ((eb.d) this.f5393z).execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        switch (this.f5389v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c();
                return;
            default:
                synchronized (this.f5392y) {
                    Object objPoll = this.f5390w.poll();
                    Runnable runnable = (Runnable) objPoll;
                    this.f5391x = runnable;
                    if (objPoll != null) {
                        this.f5393z.execute(runnable);
                    }
                    break;
                }
                return;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f5389v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a(runnable);
                return;
            default:
                ge.i.e(runnable, "command");
                synchronized (this.f5392y) {
                    this.f5390w.offer(new nc.i(11, runnable, this));
                    if (this.f5391x == null) {
                        b();
                    }
                    break;
                }
                return;
        }
    }

    public o(eb.d dVar) {
        this.f5389v = 0;
        this.f5392y = new Object();
        this.f5390w = new ArrayDeque();
        this.f5393z = dVar;
    }
}
