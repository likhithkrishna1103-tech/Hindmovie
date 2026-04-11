package l5;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f7823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f7824b;

    public a0(j jVar) {
        this.f7823a = jVar;
        this.f7824b = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        j jVar = this.f7823a;
        if (jVar != null && jVar.equals(a0Var.f7823a)) {
            return true;
        }
        Throwable th = this.f7824b;
        if (th == null || a0Var.f7824b == null) {
            return false;
        }
        return th.toString().equals(th.toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7823a, this.f7824b});
    }

    public a0(Throwable th) {
        this.f7824b = th;
        this.f7823a = null;
    }
}
