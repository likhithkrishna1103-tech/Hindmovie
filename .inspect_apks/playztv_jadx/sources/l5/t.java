package l5;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7902u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ w f7903v;

    public /* synthetic */ t(w wVar, int i) {
        this.f7902u = i;
        this.f7903v = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7902u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Drawable drawable = this.f7903v;
                Drawable.Callback callback = drawable.getCallback();
                if (callback != null) {
                    callback.invalidateDrawable(drawable);
                    return;
                }
                return;
            default:
                w wVar = this.f7903v;
                Semaphore semaphore = wVar.f7912e0;
                t5.c cVar = wVar.I;
                if (cVar == null) {
                    return;
                }
                try {
                    semaphore.acquire();
                    cVar.s(wVar.f7919v.a());
                    if (w.f7906k0 && wVar.f7910c0) {
                        if (wVar.f7913f0 == null) {
                            wVar.f7913f0 = new Handler(Looper.getMainLooper());
                            wVar.f7914g0 = new t(wVar, 0);
                        }
                        wVar.f7913f0.post(wVar.f7914g0);
                    }
                    break;
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    semaphore.release();
                    throw th;
                }
                semaphore.release();
                return;
        }
    }
}
