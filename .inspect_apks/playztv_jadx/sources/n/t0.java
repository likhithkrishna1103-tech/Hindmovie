package n;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8535u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f8536v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ View f8537w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f8538x;

    public t0(TextView textView, Typeface typeface, int i) {
        this.f8537w = textView;
        this.f8538x = typeface;
        this.f8536v = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f8535u;
        int i10 = this.f8536v;
        View view = this.f8537w;
        Object obj = this.f8538x;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((TextView) view).setTypeface((Typeface) obj, i10);
                break;
            default:
                int i11 = BottomSheetBehavior.f3335z0;
                ((BottomSheetBehavior) obj).J(view, i10, false);
                break;
        }
    }

    public t0(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.f8538x = bottomSheetBehavior;
        this.f8537w = view;
        this.f8536v = i;
    }
}
