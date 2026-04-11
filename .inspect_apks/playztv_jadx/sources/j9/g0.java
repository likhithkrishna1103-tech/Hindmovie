package j9;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g0 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6885u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ View f6886v;

    public /* synthetic */ g0(View view, int i) {
        this.f6885u = i;
        this.f6886v = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6885u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                View view = this.f6886v;
                ((InputMethodManager) view.getContext().getSystemService(InputMethodManager.class)).showSoftInput(view, 1);
                break;
            default:
                View view2 = this.f6886v;
                ((InputMethodManager) view2.getContext().getSystemService("input_method")).showSoftInput(view2, 0);
                break;
        }
    }
}
