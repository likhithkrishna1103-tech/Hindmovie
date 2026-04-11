package f9;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m2 implements Executor {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4270v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f4271w;

    public /* synthetic */ m2(int i, Object obj) {
        this.f4270v = i;
        this.f4271w = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f4270v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p1 p1Var = ((r1) ((x2) this.f4271w).f307w).B;
                r1.g(p1Var);
                p1Var.v1(runnable);
                return;
            case 1:
                ((a9.k) this.f4271w).post(runnable);
                return;
            case 2:
                Handler handler = (Handler) this.f4271w;
                runnable.getClass();
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            default:
                ((Executor) this.f4271w).execute(new ib.i(runnable, 2));
                return;
        }
    }

    public m2() {
        this.f4270v = 1;
        a9.k kVar = new a9.k(Looper.getMainLooper());
        Looper.getMainLooper();
        this.f4271w = kVar;
    }
}
