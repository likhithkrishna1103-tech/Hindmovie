package a2;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p1.q f273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p1.q f274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f276e;

    public i(String str, p1.q qVar, p1.q qVar2, int i, int i10) {
        s1.d.b(i == 0 || i10 == 0);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.f272a = str;
        qVar.getClass();
        this.f273b = qVar;
        qVar2.getClass();
        this.f274c = qVar2;
        this.f275d = i;
        this.f276e = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f275d == iVar.f275d && this.f276e == iVar.f276e && this.f272a.equals(iVar.f272a) && this.f273b.equals(iVar.f273b) && this.f274c.equals(iVar.f274c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f274c.hashCode() + ((this.f273b.hashCode() + e6.j.h((((527 + this.f275d) * 31) + this.f276e) * 31, 31, this.f272a)) * 31);
    }
}
