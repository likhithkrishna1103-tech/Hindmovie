package c7;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.r0;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import k8.g2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Executor {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2576u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f2577v;

    public /* synthetic */ r(int i, Object obj) {
        this.f2576u = i;
        this.f2577v = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f2576u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((Executor) this.f2577v).execute(new q(runnable, 0));
                return;
            case 1:
                ((g2) this.f2577v).x().y1(runnable);
                return;
            case 2:
                Handler handler = (Handler) this.f2577v;
                runnable.getClass();
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            default:
                ((r0) this.f2577v).post(runnable);
                return;
        }
    }

    public r() {
        this.f2576u = 3;
        r0 r0Var = new r0(Looper.getMainLooper());
        Looper.getMainLooper();
        this.f2577v = r0Var;
    }
}
