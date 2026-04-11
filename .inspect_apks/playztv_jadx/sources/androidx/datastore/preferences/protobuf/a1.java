package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f1003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1004d;

    public a1(w wVar, String str, Object[] objArr) {
        this.f1001a = wVar;
        this.f1002b = str;
        this.f1003c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f1004d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i10 = 13;
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.f1004d = i | (cCharAt2 << i10);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i10;
                i10 += 13;
                i11 = i12;
            }
        }
    }
}
