package d6;

import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.PlayerActivity;
import l2.n;
import l2.o;
import v1.g0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements o {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3415v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ l2.f f3416w;

    public /* synthetic */ h(l2.f fVar, int i) {
        this.f3415v = i;
        this.f3416w = fVar;
    }

    @Override // l2.o
    public final n d(g0 g0Var) {
        int i = this.f3415v;
        l2.f fVar = this.f3416w;
        switch (i) {
            default:
                int i10 = PlayerActivity.I0;
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return fVar;
        }
    }
}
