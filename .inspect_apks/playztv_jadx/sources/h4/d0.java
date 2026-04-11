package h4;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5795c;

    public d0(int i, int i10, String str) {
        this.f5793a = str;
        this.f5794b = i;
        this.f5795c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        int i = d0Var.f5795c;
        String str = d0Var.f5793a;
        int i10 = d0Var.f5794b;
        int i11 = this.f5795c;
        String str2 = this.f5793a;
        int i12 = this.f5794b;
        return (i12 < 0 || i10 < 0) ? TextUtils.equals(str2, str) && i11 == i : TextUtils.equals(str2, str) && i12 == i10 && i11 == i;
    }

    public final int hashCode() {
        return Objects.hash(this.f5793a, Integer.valueOf(this.f5795c));
    }
}
