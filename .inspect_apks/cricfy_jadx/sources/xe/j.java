package xe;

import java.util.concurrent.atomic.AtomicReferenceArray;
import ue.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f14502e;

    public j(long j4, j jVar, int i) {
        super(j4, jVar, i);
        this.f14502e = new AtomicReferenceArray(i.f);
    }

    @Override // ue.r
    public final int f() {
        return i.f;
    }

    @Override // ue.r
    public final void g(int i, vd.h hVar) {
        this.f14502e.set(i, i.f14501e);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f12485c + ", hashCode=" + hashCode() + ']';
    }
}
