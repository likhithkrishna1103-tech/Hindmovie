package o;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9338v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f9339w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ View f9340x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f9341y;

    public r0(TextView textView, Typeface typeface, int i) {
        this.f9340x = textView;
        this.f9341y = typeface;
        this.f9339w = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f9338v;
        int i10 = this.f9339w;
        View view = this.f9340x;
        Object obj = this.f9341y;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((TextView) view).setTypeface((Typeface) obj, i10);
                break;
            default:
                int i11 = BottomSheetBehavior.C0;
                ((BottomSheetBehavior) obj).J(view, i10, false);
                break;
        }
    }

    public r0(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.f9341y = bottomSheetBehavior;
        this.f9340x = view;
        this.f9339w = i;
    }
}
