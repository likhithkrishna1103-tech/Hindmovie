package z6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f15299v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final o7.h f15300w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ r f15301x;

    public /* synthetic */ o(r rVar, o7.h hVar, int i) {
        this.f15299v = i;
        this.f15301x = rVar;
        this.f15300w = hVar;
    }

    private final void a() {
        o7.h hVar = this.f15300w;
        hVar.f9580b.a();
        synchronized (hVar.f9581c) {
            synchronized (this.f15301x) {
                try {
                    if (this.f15301x.f15305v.f15304v.contains(new p(this.f15300w, s7.f.f11597b))) {
                        r rVar = this.f15301x;
                        try {
                            this.f15300w.i(rVar.L, 5);
                        } catch (Throwable th) {
                            throw new b(th);
                        }
                    }
                    this.f15301x.d();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15299v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                return;
            default:
                o7.h hVar = this.f15300w;
                hVar.f9580b.a();
                synchronized (hVar.f9581c) {
                    synchronized (this.f15301x) {
                        try {
                            if (this.f15301x.f15305v.f15304v.contains(new p(this.f15300w, s7.f.f11597b))) {
                                this.f15301x.N.a();
                                r rVar = this.f15301x;
                                try {
                                    this.f15300w.k(rVar.N, rVar.J, rVar.Q);
                                    this.f15301x.j(this.f15300w);
                                } catch (Throwable th) {
                                    throw new b(th);
                                }
                            }
                            this.f15301x.d();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
        }
    }
}
