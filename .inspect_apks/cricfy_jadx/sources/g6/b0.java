package g6;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f5057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f5058b;

    public b0(i iVar) {
        this.f5057a = iVar;
        this.f5058b = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        i iVar = this.f5057a;
        if (iVar != null && iVar.equals(b0Var.f5057a)) {
            return true;
        }
        Throwable th = this.f5058b;
        if (th == null || b0Var.f5058b == null) {
            return false;
        }
        return th.toString().equals(th.toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5057a, this.f5058b});
    }

    public b0(Throwable th) {
        this.f5058b = th;
        this.f5057a = null;
    }
}
