package i4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f6321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f6322c;

    public /* synthetic */ w(x xVar, s sVar, int i) {
        this.f6320a = i;
        this.f6322c = xVar;
        this.f6321b = sVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f6320a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x xVar = this.f6322c;
                xVar.i(1);
                if (xVar.B) {
                    this.f6321b.post(xVar.f6341s);
                    xVar.B = false;
                }
                break;
            case 1:
                x xVar2 = this.f6322c;
                xVar2.i(2);
                if (xVar2.B) {
                    this.f6321b.post(xVar2.f6341s);
                    xVar2.B = false;
                }
                break;
            default:
                x xVar3 = this.f6322c;
                xVar3.i(2);
                if (xVar3.B) {
                    this.f6321b.post(xVar3.f6341s);
                    xVar3.B = false;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f6320a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6322c.i(3);
                break;
            case 1:
                this.f6322c.i(3);
                break;
            default:
                this.f6322c.i(3);
                break;
        }
    }
}
