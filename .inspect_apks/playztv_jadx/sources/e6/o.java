package e6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4546u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final t6.h f4547v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ r f4548w;

    public /* synthetic */ o(r rVar, t6.h hVar, int i) {
        this.f4546u = i;
        this.f4548w = rVar;
        this.f4547v = hVar;
    }

    private final void a() {
        t6.h hVar = this.f4547v;
        hVar.f12220b.a();
        synchronized (hVar.f12221c) {
            synchronized (this.f4548w) {
                try {
                    if (this.f4548w.f4552u.f4551u.contains(new p(this.f4547v, x6.f.f14281b))) {
                        r rVar = this.f4548w;
                        try {
                            this.f4547v.g(rVar.K, 5);
                        } catch (Throwable th) {
                            throw new c(th);
                        }
                    }
                    this.f4548w.d();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4546u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                return;
            default:
                t6.h hVar = this.f4547v;
                hVar.f12220b.a();
                synchronized (hVar.f12221c) {
                    synchronized (this.f4548w) {
                        try {
                            if (this.f4548w.f4552u.f4551u.contains(new p(this.f4547v, x6.f.f14281b))) {
                                this.f4548w.M.a();
                                r rVar = this.f4548w;
                                try {
                                    this.f4547v.j(rVar.M, rVar.I, rVar.P);
                                    this.f4548w.j(this.f4547v);
                                } catch (Throwable th) {
                                    throw new c(th);
                                }
                            }
                            this.f4548w.d();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
        }
    }
}
