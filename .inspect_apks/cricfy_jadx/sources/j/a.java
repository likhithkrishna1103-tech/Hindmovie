package j;

import android.graphics.drawable.Animatable;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Animatable f6453b;

    public /* synthetic */ a(Animatable animatable, int i) {
        this.f6452a = i;
        this.f6453b = animatable;
    }

    @Override // n5.a
    public final void L() {
        switch (this.f6452a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6453b.start();
                break;
            default:
                ((m5.d) this.f6453b).start();
                break;
        }
    }

    @Override // n5.a
    public final void M() {
        switch (this.f6452a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6453b.stop();
                break;
            default:
                ((m5.d) this.f6453b).stop();
                break;
        }
    }
}
