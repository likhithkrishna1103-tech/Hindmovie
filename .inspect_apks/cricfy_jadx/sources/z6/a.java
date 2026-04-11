package z6;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends WeakReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x6.e f15224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f15226c;

    public a(x6.e eVar, v vVar, ReferenceQueue referenceQueue) {
        super(vVar, referenceQueue);
        s7.f.c(eVar, "Argument must not be null");
        this.f15224a = eVar;
        boolean z10 = vVar.f15317v;
        this.f15226c = null;
        this.f15225b = z10;
    }
}
