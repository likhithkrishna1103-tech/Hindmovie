package q3;

import w2.g0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f10712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f10714e;

    public s(boolean z2, String str, int i, byte[] bArr, int i10, int i11, byte[] bArr2) {
        int i12 = 1;
        s1.d.b((i == 0) ^ (bArr2 == null));
        this.f10710a = z2;
        this.f10711b = str;
        this.f10713d = i;
        this.f10714e = bArr2;
        if (str != null) {
            switch (str) {
                case "cbc1":
                case "cbcs":
                    i12 = 2;
                    break;
                case "cenc":
                case "cens":
                    break;
                default:
                    s1.b.p("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                    break;
            }
        }
        this.f10712c = new g0(i12, i10, i11, bArr);
    }
}
