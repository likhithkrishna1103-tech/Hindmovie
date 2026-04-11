package e6;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends WeakReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c6.f f4473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f4475c;

    public b(c6.f fVar, v vVar, ReferenceQueue referenceQueue) {
        super(vVar, referenceQueue);
        x6.f.c(fVar, "Argument must not be null");
        this.f4473a = fVar;
        boolean z2 = vVar.f4565u;
        this.f4475c = null;
        this.f4474b = z2;
    }
}
