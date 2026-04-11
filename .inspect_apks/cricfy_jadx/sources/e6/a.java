package e6;

import android.os.CountDownTimer;
import androidx.media3.decoder.DecoderInputBuffer;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.f;
import g6.g;
import java.util.Locale;
import s5.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f3810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f3811d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(long j4, h hVar, long j7, int i) {
        super(j4, 60000L);
        this.f3808a = i;
        switch (i) {
            case 1:
                this.f3810c = hVar;
                this.f3811d = j7;
                super(j4, 1000L);
                this.f3809b = hVar.G;
                break;
            default:
                this.f3810c = hVar;
                this.f3811d = j7;
                this.f3809b = hVar.G;
                break;
        }
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        switch (this.f3808a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h hVar = this.f3810c;
                if (this.f3809b == hVar.G) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j4 = this.f3811d;
                    new a(j4 - jCurrentTimeMillis, hVar, j4, 1).start();
                }
                break;
            case 1:
                h hVar2 = this.f3810c;
                if (this.f3809b == hVar2.G) {
                    hVar2.A.setVisibility(8);
                    hVar2.B.setVisibility(8);
                    LottieAnimationView lottieAnimationView = hVar2.E;
                    lottieAnimationView.setVisibility(0);
                    lottieAnimationView.I.add(g.A);
                    lottieAnimationView.C.l();
                    new a(hVar2, this.f3811d).start();
                }
                break;
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j4) {
        int i = this.f3808a;
        h hVar = this.f3810c;
        int i10 = this.f3809b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (i10 == hVar.G) {
                    f.L(hVar, j4);
                }
                break;
            case 1:
                if (i10 == hVar.G) {
                    hVar.F.setText(String.format(Locale.getDefault(), "Starts in %02d:%02d", Long.valueOf((j4 / 60000) % 60), Long.valueOf((j4 / 1000) % 60)));
                }
                break;
            default:
                if (i10 == hVar.G) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.f3811d;
                    hVar.F.setText(String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf((jCurrentTimeMillis / 3600000) % 24), Long.valueOf((jCurrentTimeMillis / 60000) % 60), Long.valueOf((jCurrentTimeMillis / 1000) % 60)));
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(h hVar, long j4) {
        super(Long.MAX_VALUE, 1000L);
        this.f3808a = 2;
        this.f3810c = hVar;
        this.f3811d = j4;
        this.f3809b = hVar.G;
    }

    private final void a() {
    }
}
