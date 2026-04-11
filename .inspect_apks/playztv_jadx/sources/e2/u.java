package e2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4368a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4370c;

    public /* synthetic */ u() {
    }

    public boolean equals(Object obj) {
        switch (this.f4368a) {
            case 1:
                if (!(obj instanceof p0.b)) {
                    return false;
                }
                if (this.f4369b != null) {
                    throw null;
                }
                if (this.f4370c == null) {
                    return true;
                }
                throw null;
            default:
                return super.equals(obj);
        }
    }

    public int hashCode() {
        switch (this.f4368a) {
            case 1:
                String str = this.f4369b;
                int iHashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f4370c;
                return iHashCode ^ (str2 != null ? str2.hashCode() : 0);
            default:
                return super.hashCode();
        }
    }

    public final String toString() {
        switch (this.f4368a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f4369b + ", " + this.f4370c;
            default:
                return "Pair{" + ((Object) this.f4369b) + " " + ((Object) this.f4370c) + "}";
        }
    }

    public u(String str, String str2) {
        this.f4369b = str;
        this.f4370c = str2;
    }
}
