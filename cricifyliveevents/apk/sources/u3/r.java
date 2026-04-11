package u3;

import a3.h0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f12187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f12189e;

    public r(boolean z10, String str, int i, byte[] bArr, int i10, int i11, byte[] bArr2) {
        int i12 = 1;
        y1.d.b((i == 0) ^ (bArr2 == null));
        this.f12185a = z10;
        this.f12186b = str;
        this.f12188d = i;
        this.f12189e = bArr2;
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
                    y1.b.p("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                    break;
            }
        }
        this.f12187c = new h0(i12, i10, i11, bArr);
    }
}
