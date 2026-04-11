package z6;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o7.h f15302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f15303b;

    public p(o7.h hVar, Executor executor) {
        this.f15302a = hVar;
        this.f15303b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f15302a.equals(((p) obj).f15302a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f15302a.hashCode();
    }
}
