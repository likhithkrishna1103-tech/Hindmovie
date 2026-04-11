package g6;

import androidx.media3.decoder.DecoderInputBuffer;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f5081b;

    public h(LottieAnimationView lottieAnimationView, int i) {
        this.f5080a = i;
        switch (i) {
            case 1:
                this.f5081b = new WeakReference(lottieAnimationView);
                break;
            default:
                this.f5081b = new WeakReference(lottieAnimationView);
                break;
        }
    }

    @Override // g6.z
    public final void onResult(Object obj) {
        switch (this.f5080a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Throwable th = (Throwable) obj;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f5081b.get();
                if (lottieAnimationView != null) {
                    int i = lottieAnimationView.B;
                    if (i != 0) {
                        lottieAnimationView.setImageResource(i);
                    }
                    z zVar = lottieAnimationView.A;
                    if (zVar == null) {
                        zVar = LottieAnimationView.L;
                    }
                    zVar.onResult(th);
                    break;
                }
                break;
            default:
                i iVar = (i) obj;
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f5081b.get();
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setComposition(iVar);
                    break;
                }
                break;
        }
    }
}
