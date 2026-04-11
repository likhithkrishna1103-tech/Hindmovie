package e6;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t6.h f4549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f4550b;

    public p(t6.h hVar, Executor executor) {
        this.f4549a = hVar;
        this.f4550b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f4549a.equals(((p) obj).f4549a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4549a.hashCode();
    }
}
