package j2;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6758c;

    public u(String str, boolean z2, boolean z10) {
        this.f6756a = str;
        this.f6757b = z2;
        this.f6758c = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == u.class) {
            u uVar = (u) obj;
            if (TextUtils.equals(this.f6756a, uVar.f6756a) && this.f6757b == uVar.f6757b && this.f6758c == uVar.f6758c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((e6.j.h(31, 31, this.f6756a) + (this.f6757b ? 1231 : 1237)) * 31) + (this.f6758c ? 1231 : 1237);
    }
}
