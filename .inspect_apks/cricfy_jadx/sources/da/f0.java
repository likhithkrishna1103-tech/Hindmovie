package da;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3617v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ View f3618w;

    public /* synthetic */ f0(View view, int i) {
        this.f3617v = i;
        this.f3618w = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3617v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                View view = this.f3618w;
                ((InputMethodManager) view.getContext().getSystemService(InputMethodManager.class)).showSoftInput(view, 1);
                break;
            default:
                View view2 = this.f3618w;
                ((InputMethodManager) view2.getContext().getSystemService("input_method")).showSoftInput(view2, 0);
                break;
        }
    }
}
