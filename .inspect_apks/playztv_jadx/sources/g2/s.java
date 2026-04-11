package g2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p1.i0;
import p1.k0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f4936c;

    public s(String str, String str2, List list) {
        this.f4934a = str;
        this.f4935b = str2;
        this.f4936c = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // p1.k0
    public final /* synthetic */ p1.q b() {
        return null;
    }

    @Override // p1.k0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && s.class == obj.getClass()) {
            s sVar = (s) obj;
            if (TextUtils.equals(this.f4934a, sVar.f4934a) && TextUtils.equals(this.f4935b, sVar.f4935b) && this.f4936c.equals(sVar.f4936c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f4934a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f4935b;
        return this.f4936c.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        String strO;
        StringBuilder sb2 = new StringBuilder("HlsTrackMetadataEntry");
        String str = this.f4934a;
        if (str != null) {
            StringBuilder sb3 = new StringBuilder(" [");
            sb3.append(str);
            sb3.append(", ");
            strO = l4.a.o(sb3, this.f4935b, "]");
        } else {
            strO = "";
        }
        sb2.append(strO);
        return sb2.toString();
    }

    @Override // p1.k0
    public final /* synthetic */ void a(i0 i0Var) {
    }
}
