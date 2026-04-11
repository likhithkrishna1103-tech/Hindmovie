package o3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f9474e;
    public final int[] f;

    public l(int i, int i10, int i11, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f9471b = i;
        this.f9472c = i10;
        this.f9473d = i11;
        this.f9474e = iArr;
        this.f = iArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (this.f9471b == lVar.f9471b && this.f9472c == lVar.f9472c && this.f9473d == lVar.f9473d && Arrays.equals(this.f9474e, lVar.f9474e) && Arrays.equals(this.f, lVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f) + ((Arrays.hashCode(this.f9474e) + ((((((527 + this.f9471b) * 31) + this.f9472c) * 31) + this.f9473d) * 31)) * 31);
    }
}
