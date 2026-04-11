package o3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9449e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i[] f9450g;

    public c(String str, int i, int i10, long j4, long j7, i[] iVarArr) {
        super("CHAP");
        this.f9446b = str;
        this.f9447c = i;
        this.f9448d = i10;
        this.f9449e = j4;
        this.f = j7;
        this.f9450g = iVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f9447c == cVar.f9447c && this.f9448d == cVar.f9448d && this.f9449e == cVar.f9449e && this.f == cVar.f && Objects.equals(this.f9446b, cVar.f9446b) && Arrays.equals(this.f9450g, cVar.f9450g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((((527 + this.f9447c) * 31) + this.f9448d) * 31) + ((int) this.f9449e)) * 31) + ((int) this.f)) * 31;
        String str = this.f9446b;
        return i + (str != null ? str.hashCode() : 0);
    }
}
