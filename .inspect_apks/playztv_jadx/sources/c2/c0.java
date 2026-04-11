package c2;

import android.os.Handler;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c0 implements Executor {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2252u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f2253v;

    public /* synthetic */ c0(int i, Object obj) {
        this.f2252u = i;
        this.f2253v = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f2252u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((Handler) this.f2253v).post(runnable);
                break;
            default:
                s1.b0.S(((g4.b0) this.f2253v).f4965l, runnable);
                break;
        }
    }
}
