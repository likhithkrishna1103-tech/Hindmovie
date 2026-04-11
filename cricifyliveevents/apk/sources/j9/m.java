package j9;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executor;
import ya.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements o, f, e, c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6698v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Executor f6699w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a f6700x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final p f6701y;

    public /* synthetic */ m(Executor executor, a aVar, p pVar, int i) {
        this.f6698v = i;
        this.f6699w = executor;
        this.f6700x = aVar;
        this.f6701y = pVar;
    }

    @Override // j9.f
    public void a(Object obj) {
        this.f6701y.l(obj);
    }

    @Override // j9.c
    public void b() {
        this.f6701y.o();
    }

    @Override // j9.o
    public final void c(p pVar) {
        switch (this.f6698v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6699w.execute(new s(22, this, pVar, false));
                break;
            default:
                this.f6699w.execute(new s(23, this, pVar, false));
                break;
        }
    }

    @Override // j9.e
    public void y(Exception exc) {
        this.f6701y.n(exc);
    }
}
