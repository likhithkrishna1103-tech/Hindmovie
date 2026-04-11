package m4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f8267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v f8268c;

    public /* synthetic */ u(v vVar, q qVar, int i) {
        this.f8266a = i;
        this.f8268c = vVar;
        this.f8267b = qVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f8266a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                v vVar = this.f8268c;
                vVar.i(1);
                if (vVar.B) {
                    this.f8267b.post(vVar.f8285s);
                    vVar.B = false;
                }
                break;
            case 1:
                v vVar2 = this.f8268c;
                vVar2.i(2);
                if (vVar2.B) {
                    this.f8267b.post(vVar2.f8285s);
                    vVar2.B = false;
                }
                break;
            default:
                v vVar3 = this.f8268c;
                vVar3.i(2);
                if (vVar3.B) {
                    this.f8267b.post(vVar3.f8285s);
                    vVar3.B = false;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f8266a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f8268c.i(3);
                break;
            case 1:
                this.f8268c.i(3);
                break;
            default:
                this.f8268c.i(3);
                break;
        }
    }
}
