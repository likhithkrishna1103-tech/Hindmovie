package hc;

import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.PlayerActivity;
import p1.g0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements f2.o {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6049u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ f2.f f6050v;

    public /* synthetic */ m(f2.f fVar, int i) {
        this.f6049u = i;
        this.f6050v = fVar;
    }

    @Override // f2.o
    public final f2.n b(g0 g0Var) {
        int i = this.f6049u;
        f2.f fVar = this.f6050v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i10 = PlayerActivity.M0;
                break;
        }
        return fVar;
    }
}
