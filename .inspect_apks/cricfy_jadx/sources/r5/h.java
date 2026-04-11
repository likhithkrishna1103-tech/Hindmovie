package r5;

import android.content.DialogInterface;
import android.widget.Spinner;
import androidx.appcompat.widget.SwitchCompat;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.TvActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10865v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ l7.a f10866w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ h.j f10867x;

    public /* synthetic */ h(h.j jVar, l7.a aVar, int i) {
        this.f10865v = i;
        this.f10867x = jVar;
        this.f10866w = aVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        int i = this.f10865v;
        l7.a aVar = this.f10866w;
        h.j jVar = this.f10867x;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                MainActivity mainActivity = (MainActivity) jVar;
                int i10 = MainActivity.B0;
                com.bumptech.glide.d.t(mainActivity).edit().putInt("floatings", (((SwitchCompat) aVar.f7867x).isChecked() ? ((Spinner) aVar.f7868y).getSelectedItemPosition() : -1) + 1).apply();
                break;
            default:
                TvActivity tvActivity = (TvActivity) jVar;
                int i11 = TvActivity.f1550s0;
                com.bumptech.glide.d.t(tvActivity).edit().putInt("floatings", (((SwitchCompat) aVar.f7867x).isChecked() ? ((Spinner) aVar.f7868y).getSelectedItemPosition() : -1) + 1).apply();
                break;
        }
    }
}
