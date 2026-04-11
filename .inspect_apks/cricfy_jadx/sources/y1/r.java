package y1;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f14599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f14600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f14601c;

    public r(s sVar, w2.f fVar, Executor executor) {
        this.f14601c = sVar;
        this.f14599a = new WeakReference(fVar);
        this.f14600b = executor;
    }
}
