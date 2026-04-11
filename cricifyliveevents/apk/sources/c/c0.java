package c;

import androidx.fragment.app.i0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f1941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.s f1942b;

    public c0(i0 i0Var, androidx.lifecycle.s sVar) {
        ge.i.e(i0Var, "callback");
        this.f1941a = i0Var;
        this.f1942b = sVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return ge.i.a(this.f1941a, c0Var.f1941a) && ge.i.a(this.f1942b, c0Var.f1942b);
    }

    public final int hashCode() {
        int iHashCode = this.f1941a.hashCode() * 31;
        androidx.lifecycle.s sVar = this.f1942b;
        return iHashCode + (sVar == null ? 0 : sVar.hashCode());
    }

    public final String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.f1941a + ", owner=" + this.f1942b + ')';
    }
}
