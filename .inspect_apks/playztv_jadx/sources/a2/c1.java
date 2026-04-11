package a2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f180c;

    public c1(b1 b1Var) {
        this.f178a = b1Var.f164a;
        this.f179b = b1Var.f165b;
        this.f180c = b1Var.f166c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return this.f178a == c1Var.f178a && this.f179b == c1Var.f179b && this.f180c == c1Var.f180c;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f178a), Float.valueOf(this.f179b), Long.valueOf(this.f180c));
    }
}
