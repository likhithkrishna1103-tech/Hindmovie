package w4;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f13956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean[] f13957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f13958d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f13955a = new ReentrantLock();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantLock f13959e = new ReentrantLock();

    public k(int i) {
        this.f13956b = new long[i];
        this.f13957c = new boolean[i];
    }
}
