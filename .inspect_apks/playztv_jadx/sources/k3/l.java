package k3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f7009e;
    public final int[] f;

    public l(int i, int i10, int i11, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f7006b = i;
        this.f7007c = i10;
        this.f7008d = i11;
        this.f7009e = iArr;
        this.f = iArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (this.f7006b == lVar.f7006b && this.f7007c == lVar.f7007c && this.f7008d == lVar.f7008d && Arrays.equals(this.f7009e, lVar.f7009e) && Arrays.equals(this.f, lVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f) + ((Arrays.hashCode(this.f7009e) + ((((((527 + this.f7006b) * 31) + this.f7007c) * 31) + this.f7008d) * 31)) * 31);
    }
}
