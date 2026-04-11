package ke;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends z0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f7697y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f7698z;

    public /* synthetic */ i(int i, Object obj) {
        this.f7697y = i;
        this.f7698z = obj;
    }

    @Override // ke.z0
    public final boolean k() {
        switch (this.f7697y) {
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [ae.l, java.lang.Object] */
    @Override // ke.z0
    public final void l(Throwable th) {
        switch (this.f7697y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g gVar = (g) this.f7698z;
                Throwable thT = gVar.t(j());
                if (gVar.z()) {
                    pe.f fVar = (pe.f) gVar.f7693x;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pe.f.B;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(fVar);
                        i4.o0 o0Var = pe.a.f10367c;
                        if (be.h.a(obj, o0Var)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, o0Var, thT)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != o0Var) {
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
                gVar.q(thT);
                if (!gVar.z()) {
                    gVar.r();
                }
                break;
            case 1:
                ((h0) this.f7698z).b();
                break;
            case 2:
                this.f7698z.a(th);
                break;
            default:
                a1 a1Var = (a1) this.f7698z;
                Object obj2 = d1.f7686u.get(j());
                if (!(obj2 instanceof o)) {
                    a1Var.g(x.o(obj2));
                } else {
                    a1Var.g(i5.a.h(((o) obj2).f7717a));
                }
                break;
        }
    }
}
