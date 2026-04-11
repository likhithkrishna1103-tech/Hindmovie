package o3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f9454e;
    public final i[] f;

    public d(String str, boolean z10, boolean z11, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.f9451b = str;
        this.f9452c = z10;
        this.f9453d = z11;
        this.f9454e = strArr;
        this.f = iVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f9452c == dVar.f9452c && this.f9453d == dVar.f9453d && Objects.equals(this.f9451b, dVar.f9451b) && Arrays.equals(this.f9454e, dVar.f9454e) && Arrays.equals(this.f, dVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((527 + (this.f9452c ? 1 : 0)) * 31) + (this.f9453d ? 1 : 0)) * 31;
        String str = this.f9451b;
        return i + (str != null ? str.hashCode() : 0);
    }
}
