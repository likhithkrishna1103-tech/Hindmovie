package q2;

import aa.c1;
import aa.g0;
import aa.h0;
import aa.j0;
import aa.p;
import aa.z;
import aa.z0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f10589b = new z(new p(new ia.b(26), z0.f767v), new p(new ia.b(27), z0.f768w));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f10590a = new ArrayList();

    @Override // q2.a
    public final j0 a(long j5) {
        ArrayList arrayList = this.f10590a;
        if (!arrayList.isEmpty()) {
            if (j5 >= ((t3.a) arrayList.get(0)).f12072b) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    t3.a aVar = (t3.a) arrayList.get(i);
                    if (j5 >= aVar.f12072b && j5 < aVar.f12074d) {
                        arrayList2.add(aVar);
                    }
                    if (j5 < aVar.f12072b) {
                        break;
                    }
                }
                c1 c1VarX = j0.x(f10589b, arrayList2);
                g0 g0VarN = j0.n();
                for (int i10 = 0; i10 < c1VarX.f652x; i10++) {
                    g0VarN.d(((t3.a) c1VarX.get(i10)).f12071a);
                }
                return g0VarN.g();
            }
        }
        h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // q2.a
    public final long b(long j5) {
        int i = 0;
        long jMin = -9223372036854775807L;
        while (true) {
            ArrayList arrayList = this.f10590a;
            if (i >= arrayList.size()) {
                break;
            }
            long j8 = ((t3.a) arrayList.get(i)).f12072b;
            long j10 = ((t3.a) arrayList.get(i)).f12074d;
            if (j5 < j8) {
                jMin = jMin == -9223372036854775807L ? j8 : Math.min(jMin, j8);
            } else {
                if (j5 < j10) {
                    jMin = jMin == -9223372036854775807L ? j10 : Math.min(jMin, j10);
                }
                i++;
            }
        }
        if (jMin != -9223372036854775807L) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override // q2.a
    public final boolean c(t3.a aVar, long j5) {
        long j8 = aVar.f12072b;
        s1.d.b(j8 != -9223372036854775807L);
        s1.d.b(aVar.f12073c != -9223372036854775807L);
        boolean z2 = j8 <= j5 && j5 < aVar.f12074d;
        ArrayList arrayList = this.f10590a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (j8 >= ((t3.a) arrayList.get(size)).f12072b) {
                arrayList.add(size + 1, aVar);
                return z2;
            }
        }
        arrayList.add(0, aVar);
        return z2;
    }

    @Override // q2.a
    public final void clear() {
        this.f10590a.clear();
    }

    @Override // q2.a
    public final long d(long j5) {
        ArrayList arrayList = this.f10590a;
        if (arrayList.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j5 < ((t3.a) arrayList.get(0)).f12072b) {
            return -9223372036854775807L;
        }
        long jMax = ((t3.a) arrayList.get(0)).f12072b;
        for (int i = 0; i < arrayList.size(); i++) {
            long j8 = ((t3.a) arrayList.get(i)).f12072b;
            long j10 = ((t3.a) arrayList.get(i)).f12074d;
            if (j10 > j5) {
                if (j8 > j5) {
                    break;
                }
                jMax = Math.max(jMax, j8);
            } else {
                jMax = Math.max(jMax, j10);
            }
        }
        return jMax;
    }

    @Override // q2.a
    public final void e(long j5) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f10590a;
            if (i >= arrayList.size()) {
                return;
            }
            long j8 = ((t3.a) arrayList.get(i)).f12072b;
            if (j5 > j8 && j5 > ((t3.a) arrayList.get(i)).f12074d) {
                arrayList.remove(i);
                i--;
            } else if (j5 < j8) {
                return;
            }
            i++;
        }
    }
}
