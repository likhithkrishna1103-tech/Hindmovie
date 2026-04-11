package k8;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f3 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7176u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ h0 f7177v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ g3 f7178w;

    public /* synthetic */ f3(g3 g3Var, h0 h0Var, int i) {
        this.f7176u = i;
        this.f7177v = h0Var;
        this.f7178w = g3Var;
    }

    private final void a() {
        synchronized (this.f7178w) {
            try {
                this.f7178w.f7215u = false;
                if (!this.f7178w.f7217w.D1()) {
                    this.f7178w.f7217w.g().I.d("Connected to service");
                    z2 z2Var = this.f7178w.f7217w;
                    h0 h0Var = this.f7177v;
                    z2Var.p1();
                    z2Var.f7573y = h0Var;
                    z2Var.H1();
                    z2Var.G1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7176u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                return;
            default:
                synchronized (this.f7178w) {
                    try {
                        this.f7178w.f7215u = false;
                        if (!this.f7178w.f7217w.D1()) {
                            this.f7178w.f7217w.g().H.d("Connected to remote service");
                            z2 z2Var = this.f7178w.f7217w;
                            h0 h0Var = this.f7177v;
                            z2Var.p1();
                            z2Var.f7573y = h0Var;
                            z2Var.H1();
                            z2Var.G1();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
        }
    }
}
