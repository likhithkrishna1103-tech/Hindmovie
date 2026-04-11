package k2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6830d;

    public b(int i, int i10, String str, String str2) {
        this.f6827a = str;
        this.f6828b = str2;
        this.f6829c = i;
        this.f6830d = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6829c == bVar.f6829c && this.f6830d == bVar.f6830d && Objects.equals(this.f6827a, bVar.f6827a) && Objects.equals(this.f6828b, bVar.f6828b);
    }

    public final int hashCode() {
        return Objects.hash(this.f6827a, this.f6828b, Integer.valueOf(this.f6829c), Integer.valueOf(this.f6830d));
    }
}
