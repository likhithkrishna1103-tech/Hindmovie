package n0;

import android.util.Base64;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f8614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8615e;

    public d(String str, String str2, String str3, List list) {
        str.getClass();
        this.f8611a = str;
        str2.getClass();
        this.f8612b = str2;
        this.f8613c = str3;
        list.getClass();
        this.f8614d = list;
        this.f8615e = str + "-" + str2 + "-" + str3;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f8611a + ", mProviderPackage: " + this.f8612b + ", mQuery: " + this.f8613c + ", mCertificates:");
        int i = 0;
        while (true) {
            List list = this.f8614d;
            if (i >= list.size()) {
                sb2.append("}mCertificatesArray: 0");
                return sb2.toString();
            }
            sb2.append(" [");
            List list2 = (List) list.get(i);
            for (int i10 = 0; i10 < list2.size(); i10++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString((byte[]) list2.get(i10), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
            i++;
        }
    }
}
