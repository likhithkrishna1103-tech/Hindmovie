package c2;

import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TreeSet f2021c = new TreeSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f2022d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q f2023e;

    public k(int i, String str, q qVar) {
        this.f2019a = i;
        this.f2020b = str;
        this.f2023e = qVar;
    }

    public final boolean a(long j4, long j7) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f2022d;
            if (i >= arrayList.size()) {
                return false;
            }
            j jVar = (j) arrayList.get(i);
            long j10 = jVar.f2017a;
            long j11 = jVar.f2018b;
            if (j11 == -1) {
                if (j4 >= j10) {
                    return true;
                }
            } else if (j7 != -1 && j10 <= j4 && j4 + j7 <= j10 + j11) {
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
            if (this.f2019a == kVar.f2019a && this.f2020b.equals(kVar.f2020b) && this.f2021c.equals(kVar.f2021c) && this.f2023e.equals(kVar.f2023e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2023e.hashCode() + l0.e.e(this.f2019a * 31, 31, this.f2020b);
    }
}
