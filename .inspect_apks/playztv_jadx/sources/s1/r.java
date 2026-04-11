package s1;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f11694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f11695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f11696c;

    public r(s sVar, s2.f fVar, Executor executor) {
        this.f11696c = sVar;
        this.f11694a = new WeakReference(fVar);
        this.f11695b = executor;
    }
}
