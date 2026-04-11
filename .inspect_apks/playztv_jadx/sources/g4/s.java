package g4;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h4.b0 f5199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f5202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f5203e;

    public s(h4.b0 b0Var, int i, int i10, boolean z2, r rVar, Bundle bundle) {
        this.f5199a = b0Var;
        this.f5200b = i;
        this.f5201c = i10;
        this.f5202d = rVar;
        this.f5203e = bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        s sVar = (s) obj;
        r rVar = sVar.f5202d;
        r rVar2 = this.f5202d;
        return (rVar2 == null && rVar == null) ? this.f5199a.equals(sVar.f5199a) : Objects.equals(rVar2, rVar);
    }

    public final int hashCode() {
        return Objects.hash(this.f5202d, this.f5199a);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ControllerInfo {pkg=");
        h4.b0 b0Var = this.f5199a;
        sb2.append(b0Var.f5792a.f5793a);
        sb2.append(", uid=");
        return x.c.a(sb2, b0Var.f5792a.f5795c, "}");
    }
}
