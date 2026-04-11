package hc;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.LandscapeActivity;
import com.playz.tv.activities.PlayerActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6030u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ h.j f6031v;

    public /* synthetic */ c(h.j jVar, int i) {
        this.f6030u = i;
        this.f6031v = jVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        int i = this.f6030u;
        h.j jVar = this.f6031v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i10 = LandscapeActivity.f3596a0;
                new Handler(Looper.getMainLooper()).postDelayed(new a2.a(17, (LandscapeActivity) jVar), 20L);
                break;
            default:
                int i11 = PlayerActivity.M0;
                new Handler(Looper.getMainLooper()).postDelayed(new n((PlayerActivity) jVar, 4), 20L);
                break;
        }
    }
}
