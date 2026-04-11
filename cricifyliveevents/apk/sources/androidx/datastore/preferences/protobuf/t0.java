package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f799d;

    public t0(v vVar, String str, Object[] objArr) {
        this.f796a = vVar;
        this.f797b = str;
        this.f798c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f799d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.f799d = i | (cCharAt2 << i10);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            }
        }
    }

    public final int a() {
        int i = this.f799d;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }
}
