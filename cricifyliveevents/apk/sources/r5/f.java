package r5;

import android.widget.FrameLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10861v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10862w;

    public /* synthetic */ f(MainActivity mainActivity, int i) {
        this.f10861v = i;
        this.f10862w = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10861v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f10862w.f1509t0 = false;
                break;
            default:
                MainActivity mainActivity = this.f10862w;
                mainActivity.W.J = ((FrameLayout) mainActivity.X.f2036c).getHeight();
                break;
        }
    }
}
