package m2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v1.i0;
import v1.k0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f8141c;

    public t(String str, String str2, List list) {
        this.f8139a = str;
        this.f8140b = str2;
        this.f8141c = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // v1.k0
    public final /* synthetic */ v1.p a() {
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && t.class == obj.getClass()) {
            t tVar = (t) obj;
            if (TextUtils.equals(this.f8139a, tVar.f8139a) && TextUtils.equals(this.f8140b, tVar.f8140b) && this.f8141c.equals(tVar.f8141c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f8139a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8140b;
        return this.f8141c.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        String strQ;
        StringBuilder sb = new StringBuilder("HlsTrackMetadataEntry");
        String str = this.f8139a;
        if (str != null) {
            StringBuilder sb2 = new StringBuilder(" [");
            sb2.append(str);
            sb2.append(", ");
            strQ = q4.a.q(sb2, this.f8140b, "]");
        } else {
            strQ = "";
        }
        sb.append(strQ);
        return sb.toString();
    }

    @Override // v1.k0
    public final /* synthetic */ void c(i0 i0Var) {
    }
}
