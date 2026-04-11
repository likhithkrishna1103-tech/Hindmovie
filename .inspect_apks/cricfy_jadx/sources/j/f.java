package j;

import android.graphics.drawable.Drawable;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Drawable.Callback {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6488v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f6489w;

    public /* synthetic */ f() {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.f6488v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                ((m5.d) this.f6489w).invalidateSelf();
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        switch (this.f6488v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Drawable.Callback callback = (Drawable.Callback) this.f6489w;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j4);
                }
                break;
            default:
                ((m5.d) this.f6489w).scheduleSelf(runnable, j4);
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.f6488v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Drawable.Callback callback = (Drawable.Callback) this.f6489w;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                }
                break;
            default:
                ((m5.d) this.f6489w).unscheduleSelf(runnable);
                break;
        }
    }

    public f(m5.d dVar) {
        this.f6489w = dVar;
    }

    private final void a(Drawable drawable) {
    }
}
