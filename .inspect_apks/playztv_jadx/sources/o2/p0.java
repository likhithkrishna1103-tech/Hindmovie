package o2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p0 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f9190u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ u0 f9191v;

    public /* synthetic */ p0(u0 u0Var, int i) {
        this.f9190u = i;
        this.f9191v = u0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9190u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f9191v.f9222d0 = true;
                break;
            case 1:
                this.f9191v.A();
                break;
            default:
                u0 u0Var = this.f9191v;
                if (!u0Var.f9228j0) {
                    a0 a0Var = u0Var.M;
                    a0Var.getClass();
                    a0Var.d(u0Var);
                }
                break;
        }
    }
}
