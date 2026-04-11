package w1;

import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TreeSet f13537c = new TreeSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f13538d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f13539e;

    public k(int i, String str, p pVar) {
        this.f13535a = i;
        this.f13536b = str;
        this.f13539e = pVar;
    }

    public final boolean a(long j5, long j8) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f13538d;
            if (i >= arrayList.size()) {
                return false;
            }
            j jVar = (j) arrayList.get(i);
            long j10 = jVar.f13533a;
            long j11 = jVar.f13534b;
            if (j11 == -1) {
                if (j5 >= j10) {
                    return true;
                }
            } else if (j8 != -1 && j10 <= j5 && j5 + j8 <= j10 + j11) {
                return true;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            if (this.f13535a == kVar.f13535a && this.f13536b.equals(kVar.f13536b) && this.f13537c.equals(kVar.f13537c) && this.f13539e.equals(kVar.f13539e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13539e.hashCode() + e6.j.h(this.f13535a * 31, 31, this.f13536b);
    }
}
