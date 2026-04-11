package r5;

import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.PlayerActivity;
import com.google.android.gms.internal.measurement.j4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10871v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f10872w;

    public /* synthetic */ k(PlayerActivity playerActivity, int i) {
        this.f10871v = i;
        this.f10872w = playerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10871v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                PlayerActivity playerActivity = this.f10872w;
                playerActivity.Z.g0(playerActivity.f1516a0.f11513g);
                break;
            case 1:
                PlayerActivity playerActivity2 = this.f10872w;
                playerActivity2.Z.g0(playerActivity2.f1533s0);
                break;
            case 2:
                this.f10872w.f1538x0 = true;
                break;
            case 3:
                PlayerActivity playerActivity3 = this.f10872w;
                if (playerActivity3.A0) {
                    playerActivity3.B();
                }
                break;
            default:
                PlayerActivity playerActivity4 = this.f10872w;
                if (!playerActivity4.f1530p0) {
                    j4.E(playerActivity4);
                } else {
                    j4.t(playerActivity4);
                }
                break;
        }
    }
}
