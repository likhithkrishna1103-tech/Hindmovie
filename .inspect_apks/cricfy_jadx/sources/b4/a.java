package b4;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1756e;
    public final int f;

    public /* synthetic */ a(int i, int i10, int i11, int i12, int i13, int i14) {
        this.f1752a = i;
        this.f1753b = i10;
        this.f1754c = i11;
        this.f1755d = i12;
        this.f1756e = i13;
        this.f = i14;
    }

    public static a a(String str) {
        y1.d.b(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < strArrSplit.length; i14++) {
            String strO = android.support.v4.media.session.b.O(strArrSplit[i14].trim());
            strO.getClass();
            switch (strO) {
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
        return new a(i, i10, i11, i12, i13, strArrSplit.length);
    }
}
