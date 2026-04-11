package l4;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7714c;

    public g0(int i, int i10, String str) {
        this.f7712a = str;
        this.f7713b = i;
        this.f7714c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        int i = g0Var.f7714c;
        String str = g0Var.f7712a;
        int i10 = g0Var.f7713b;
        int i11 = this.f7714c;
        String str2 = this.f7712a;
        int i12 = this.f7713b;
        return (i12 < 0 || i10 < 0) ? TextUtils.equals(str2, str) && i11 == i : TextUtils.equals(str2, str) && i12 == i10 && i11 == i;
    }

    public final int hashCode() {
        return Objects.hash(this.f7712a, Integer.valueOf(this.f7714c));
    }
}
