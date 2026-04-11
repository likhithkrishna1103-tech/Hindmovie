package g2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4899c;

    public s0(r0 r0Var) {
        this.f4897a = r0Var.f4888a;
        this.f4898b = r0Var.f4889b;
        this.f4899c = r0Var.f4890c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return this.f4897a == s0Var.f4897a && this.f4898b == s0Var.f4898b && this.f4899c == s0Var.f4899c;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f4897a), Float.valueOf(this.f4898b), Long.valueOf(this.f4899c));
    }
}
