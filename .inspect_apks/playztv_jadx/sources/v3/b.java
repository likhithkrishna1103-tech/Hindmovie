package v3;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13235e;
    public final int f;

    public /* synthetic */ b(int i, int i10, int i11, int i12, int i13, int i14) {
        this.f13231a = i;
        this.f13232b = i10;
        this.f13233c = i11;
        this.f13234d = i12;
        this.f13235e = i13;
        this.f = i14;
    }

    public static b a(String str) {
        s1.d.b(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < strArrSplit.length; i14++) {
            String strX = com.bumptech.glide.d.X(strArrSplit[i14].trim());
            strX.getClass();
            switch (strX) {
                case "end":
                    i11 = i14;
                    break;
                case "text":
                    i13 = i14;
                    break;
                case "layer":
                    i = i14;
                    break;
                case "start":
                    i10 = i14;
                    break;
                case "style":
                    i12 = i14;
                    break;
            }
        }
        if (i10 == -1 || i11 == -1 || i13 == -1) {
            return null;
        }
        return new b(i, i10, i11, i12, i13, strArrSplit.length);
    }
}
