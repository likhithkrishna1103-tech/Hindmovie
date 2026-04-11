package g6;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5133v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ w f5134w;

    public /* synthetic */ t(w wVar, int i) {
        this.f5133v = i;
        this.f5134w = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5133v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Drawable drawable = this.f5134w;
                Drawable.Callback callback = drawable.getCallback();
                if (callback != null) {
                    callback.invalidateDrawable(drawable);
                    return;
                }
                return;
            default:
                w wVar = this.f5134w;
                Semaphore semaphore = wVar.f5146h0;
                o6.b bVar = wVar.J;
                if (bVar == null) {
                    return;
                }
                try {
                    semaphore.acquire();
                    bVar.r(wVar.f5153w.a());
                    if (w.f5137n0 && wVar.f5144f0) {
                        if (wVar.f5147i0 == null) {
                            wVar.f5147i0 = new Handler(Looper.getMainLooper());
                            wVar.f5148j0 = new t(wVar, 0);
                        }
                        wVar.f5147i0.post(wVar.f5148j0);
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
