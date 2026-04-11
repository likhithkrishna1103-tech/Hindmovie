package uc;

import android.os.CountDownTimer;
import androidx.media3.decoder.DecoderInputBuffer;
import com.airbnb.lottie.LottieAnimationView;
import ic.j;
import java.util.Locale;
import l5.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f12919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f12920d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(long j5, j jVar, long j8, int i) {
        super(j5, 60000L);
        this.f12917a = i;
        switch (i) {
            case 1:
                this.f12919c = jVar;
                this.f12920d = j8;
                super(j5, 1000L);
                this.f12918b = jVar.F;
                break;
            default:
                this.f12919c = jVar;
                this.f12920d = j8;
                this.f12918b = jVar.F;
                break;
        }
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        switch (this.f12917a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j jVar = this.f12919c;
                if (this.f12918b == jVar.F) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j5 = this.f12920d;
                    new a(j5 - jCurrentTimeMillis, jVar, j5, 1).start();
                }
                break;
            case 1:
                j jVar2 = this.f12919c;
                if (this.f12918b == jVar2.F) {
                    jVar2.A.setVisibility(8);
                    jVar2.B.setVisibility(8);
                    LottieAnimationView lottieAnimationView = jVar2.D;
                    lottieAnimationView.setVisibility(0);
                    lottieAnimationView.H.add(h.f7854z);
                    lottieAnimationView.B.j();
                    new a(jVar2, this.f12920d).start();
                }
                break;
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j5) {
        int i = this.f12917a;
        j jVar = this.f12919c;
        int i10 = this.f12918b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (i10 == jVar.F) {
                    b.x(jVar, j5);
                }
                break;
            case 1:
                if (i10 == jVar.F) {
                    jVar.E.setText(String.format(Locale.getDefault(), "Starts in %02d:%02d", Long.valueOf((j5 / 60000) % 60), Long.valueOf((j5 / 1000) % 60)));
                }
                break;
            default:
                if (i10 == jVar.F) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.f12920d;
                    jVar.E.setText(String.format(Locale.getDefault(), "%02d:%02d:%02d", Long.valueOf((jCurrentTimeMillis / 3600000) % 24), Long.valueOf((jCurrentTimeMillis / 60000) % 60), Long.valueOf((jCurrentTimeMillis / 1000) % 60)));
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(j jVar, long j5) {
        super(Long.MAX_VALUE, 1000L);
        this.f12917a = 2;
        this.f12919c = jVar;
        this.f12920d = j5;
        this.f12918b = jVar.F;
    }

    private final void a() {
    }
}
