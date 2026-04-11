package hc;

import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.PlayerActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6051u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f6052v;

    public /* synthetic */ n(PlayerActivity playerActivity, int i) {
        this.f6051u = i;
        this.f6052v = playerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6051u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6052v.f3646z0 = true;
                break;
            case 1:
                PlayerActivity playerActivity = this.f6052v;
                playerActivity.Y.g0(playerActivity.f3640t0);
                break;
            case 2:
                PlayerActivity playerActivity2 = this.f6052v;
                playerActivity2.Y.g0(playerActivity2.Z.f6539g);
                break;
            case 3:
                PlayerActivity playerActivity3 = this.f6052v;
                if (playerActivity3.C0) {
                    playerActivity3.B();
                }
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                PlayerActivity playerActivity4 = this.f6052v;
                if (!playerActivity4.f3637q0) {
                    uc.b.t(playerActivity4);
                } else {
                    uc.b.k(playerActivity4);
                }
                break;
            default:
                this.f6052v.K0.requestFocus();
                break;
        }
    }
}
