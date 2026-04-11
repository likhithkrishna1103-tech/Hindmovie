package se;

import java.util.concurrent.atomic.AtomicReferenceArray;
import pe.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f11958e;

    public j(long j5, j jVar, int i) {
        super(j5, jVar, i);
        this.f11958e = new AtomicReferenceArray(i.f);
    }

    @Override // pe.r
    public final int f() {
        return i.f;
    }

    @Override // pe.r
    public final void g(int i, rd.h hVar) {
        this.f11958e.set(i, i.f11957e);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f10399c + ", hashCode=" + hashCode() + ']';
    }
}
