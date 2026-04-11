package r5;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.LandscapeActivity;
import app.cricfy.tv.activities.PlayerActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10855v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h.j f10856w;

    public /* synthetic */ b(h.j jVar, int i) {
        this.f10855v = i;
        this.f10856w = jVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        int i = this.f10855v;
        h.j jVar = this.f10856w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i10 = LandscapeActivity.f1490a0;
                new Handler(Looper.getMainLooper()).postDelayed(new pa.c(4, (LandscapeActivity) jVar), 20L);
                break;
            default:
                int i11 = PlayerActivity.I0;
                new Handler(Looper.getMainLooper()).postDelayed(new k((PlayerActivity) jVar, 4), 20L);
                break;
        }
    }
}
