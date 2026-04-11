package k4;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l4.e0 f7157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f7160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f7161e;

    public s(l4.e0 e0Var, int i, int i10, boolean z10, r rVar, Bundle bundle) {
        this.f7157a = e0Var;
        this.f7158b = i;
        this.f7159c = i10;
        this.f7160d = rVar;
        this.f7161e = bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        s sVar = (s) obj;
        r rVar = sVar.f7160d;
        r rVar2 = this.f7160d;
        return (rVar2 == null && rVar == null) ? this.f7157a.equals(sVar.f7157a) : Objects.equals(rVar2, rVar);
    }

    public final int hashCode() {
        return Objects.hash(this.f7160d, this.f7157a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ControllerInfo {pkg=");
        l4.e0 e0Var = this.f7157a;
        sb.append(e0Var.f7710a.f7712a);
        sb.append(", uid=");
        return q4.a.o(sb, e0Var.f7710a.f7714c, "}");
    }
}
