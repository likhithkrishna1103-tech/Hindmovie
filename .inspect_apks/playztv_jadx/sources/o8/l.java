package o8;

import androidx.media3.decoder.DecoderInputBuffer;
import ea.t;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements n, e, d, b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f9431u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Executor f9432v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f9433w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final o f9434x;

    public /* synthetic */ l(Executor executor, a aVar, o oVar, int i) {
        this.f9431u = i;
        this.f9432v = executor;
        this.f9433w = aVar;
        this.f9434x = oVar;
    }

    @Override // o8.n
    public final void a(o oVar) {
        switch (this.f9431u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f9432v.execute(new t(22, this, oVar, false));
                break;
            default:
                this.f9432v.execute(new t(23, this, oVar, false));
                break;
        }
    }

    @Override // o8.e
    public void c(Object obj) {
        this.f9434x.m(obj);
    }

    @Override // o8.b
    public void h() {
        this.f9434x.n();
    }

    @Override // o8.d
    public void t(Exception exc) {
        this.f9434x.l(exc);
    }
}
