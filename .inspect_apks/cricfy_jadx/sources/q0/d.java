package q0;

import android.util.Base64;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10330e;

    public d(String str, String str2, String str3, List list) {
        str.getClass();
        this.f10326a = str;
        str2.getClass();
        this.f10327b = str2;
        this.f10328c = str3;
        list.getClass();
        this.f10329d = list;
        this.f10330e = str + "-" + str2 + "-" + str3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f10326a + ", mProviderPackage: " + this.f10327b + ", mQuery: " + this.f10328c + ", mCertificates:");
        int i = 0;
        while (true) {
            List list = this.f10329d;
            if (i >= list.size()) {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
            sb.append(" [");
            List list2 = (List) list.get(i);
            for (int i10 = 0; i10 < list2.size(); i10++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list2.get(i10), 0));
                sb.append("\"");
            }
            sb.append(" ]");
            i++;
        }
    }
}
