package pe;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends y0 {
    public final Object A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f10241z;

    public /* synthetic */ j(int i, Object obj) {
        this.f10241z = i;
        this.A = obj;
    }

    @Override // pe.y0
    public final boolean k() {
        switch (this.f10241z) {
        }
        return false;
    }

    @Override // pe.y0
    public final void l(Throwable th) {
        switch (this.f10241z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h hVar = (h) this.A;
                Throwable thU = hVar.u(j());
                if (hVar.B()) {
                    ue.f fVar = (ue.f) hVar.f10236y;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ue.f.C;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(fVar);
                        d5.a aVar = ue.a.f12455c;
                        if (ge.i.a(obj, aVar)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, aVar, thU)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != aVar) {
                                }
                                break;
                            }
                        } else if (!(obj instanceof Throwable)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                                }
                            }
                        }
                    }
                }
                hVar.q(thU);
                if (!hVar.B()) {
                    hVar.r();
                }
                break;
            case 1:
                ((h0) this.A).b();
                break;
            case 2:
                ((fe.l) this.A).a(th);
                break;
            default:
                z0 z0Var = (z0) this.A;
                Object obj2 = c1.f10226v.get(j());
                if (!(obj2 instanceof p)) {
                    z0Var.i(x.q(obj2));
                } else {
                    z0Var.i(com.bumptech.glide.c.e(((p) obj2).f10263a));
                }
                break;
        }
    }
}
