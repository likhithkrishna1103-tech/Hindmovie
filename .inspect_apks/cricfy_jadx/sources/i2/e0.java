package i2;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends AudioTrack$StreamEventCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ androidx.emoji2.text.v f5991a;

    public e0(androidx.emoji2.text.v vVar) {
        this.f5991a = vVar;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        f0 f0Var;
        p pVar;
        if (audioTrack.equals(((f0) this.f5991a.f890y).f6035w) && (pVar = (f0Var = (f0) this.f5991a.f890y).f6031s) != null && f0Var.W) {
            pVar.F();
        }
    }

    public final void onPresentationEnded(AudioTrack audioTrack) {
        if (audioTrack.equals(((f0) this.f5991a.f890y).f6035w)) {
            ((f0) this.f5991a.f890y).V = true;
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        f0 f0Var;
        p pVar;
        if (audioTrack.equals(((f0) this.f5991a.f890y).f6035w) && (pVar = (f0Var = (f0) this.f5991a.f890y).f6031s) != null && f0Var.W) {
            pVar.F();
        }
    }
}
