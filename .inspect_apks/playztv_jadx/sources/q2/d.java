package q2;

import aa.c1;
import aa.h0;
import aa.j0;
import aa.q;
import be.h;
import java.util.ArrayList;
import ue.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f10591a;

    public d(int i) {
        switch (i) {
            case 1:
                this.f10591a = new ArrayList();
                break;
            case 2:
                this.f10591a = new ArrayList(20);
                break;
            default:
                this.f10591a = new ArrayList();
                break;
        }
    }

    @Override // q2.a
    public j0 a(long j5) {
        int iH = h(j5);
        if (iH == 0) {
            h0 h0Var = j0.f690v;
            return c1.f650y;
        }
        t3.a aVar = (t3.a) this.f10591a.get(iH - 1);
        long j8 = aVar.f12074d;
        if (j8 == -9223372036854775807L || j5 < j8) {
            return aVar.f12071a;
        }
        h0 h0Var2 = j0.f690v;
        return c1.f650y;
    }

    @Override // q2.a
    public long b(long j5) {
        ArrayList arrayList = this.f10591a;
        if (arrayList.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j5 < ((t3.a) arrayList.get(0)).f12072b) {
            return ((t3.a) arrayList.get(0)).f12072b;
        }
        for (int i = 1; i < arrayList.size(); i++) {
            t3.a aVar = (t3.a) arrayList.get(i);
            long j8 = aVar.f12072b;
            long j10 = aVar.f12072b;
            if (j5 < j8) {
                long j11 = ((t3.a) arrayList.get(i - 1)).f12074d;
                return (j11 == -9223372036854775807L || j11 <= j5 || j11 >= j10) ? j10 : j11;
            }
        }
        long j12 = ((t3.a) q.k(arrayList)).f12074d;
        if (j12 == -9223372036854775807L || j5 >= j12) {
            return Long.MIN_VALUE;
        }
        return j12;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    @Override // q2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(t3.a r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.f12072b
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 0
            r6 = 1
            if (r4 == 0) goto Lf
            r4 = r6
            goto L10
        Lf:
            r4 = r5
        L10:
            s1.d.b(r4)
            int r4 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r4 > 0) goto L23
            long r7 = r10.f12074d
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 == 0) goto L21
            int r2 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r2 >= 0) goto L23
        L21:
            r2 = r6
            goto L24
        L23:
            r2 = r5
        L24:
            java.util.ArrayList r3 = r9.f10591a
            int r4 = r3.size()
            int r4 = r4 - r6
        L2b:
            if (r4 < 0) goto L4e
            java.lang.Object r7 = r3.get(r4)
            t3.a r7 = (t3.a) r7
            long r7 = r7.f12072b
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 < 0) goto L3e
            int r4 = r4 + r6
            r3.add(r4, r10)
            return r2
        L3e:
            java.lang.Object r7 = r3.get(r4)
            t3.a r7 = (t3.a) r7
            long r7 = r7.f12072b
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 > 0) goto L4b
            r2 = r5
        L4b:
            int r4 = r4 + (-1)
            goto L2b
        L4e:
            r3.add(r5, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.d.c(t3.a, long):boolean");
    }

    @Override // q2.a
    public void clear() {
        this.f10591a.clear();
    }

    @Override // q2.a
    public long d(long j5) {
        ArrayList arrayList = this.f10591a;
        if (arrayList.isEmpty() || j5 < ((t3.a) arrayList.get(0)).f12072b) {
            return -9223372036854775807L;
        }
        for (int i = 1; i < arrayList.size(); i++) {
            long j8 = ((t3.a) arrayList.get(i)).f12072b;
            if (j5 == j8) {
                return j8;
            }
            if (j5 < j8) {
                t3.a aVar = (t3.a) arrayList.get(i - 1);
                long j10 = aVar.f12074d;
                return (j10 == -9223372036854775807L || j10 > j5) ? aVar.f12072b : j10;
            }
        }
        t3.a aVar2 = (t3.a) q.k(arrayList);
        long j11 = aVar2.f12074d;
        return (j11 == -9223372036854775807L || j5 < j11) ? aVar2.f12072b : j11;
    }

    @Override // q2.a
    public void e(long j5) {
        int iH = h(j5);
        if (iH == 0) {
            return;
        }
        ArrayList arrayList = this.f10591a;
        long j8 = ((t3.a) arrayList.get(iH - 1)).f12074d;
        if (j8 == -9223372036854775807L || j8 >= j5) {
            iH--;
        }
        arrayList.subList(0, iH).clear();
    }

    public void f(String str, String str2) {
        h.e(str, "name");
        h.e(str2, "value");
        ArrayList arrayList = this.f10591a;
        arrayList.add(str);
        arrayList.add(ie.e.b0(str2).toString());
    }

    public m g() {
        return new m((String[]) this.f10591a.toArray(new String[0]));
    }

    public int h(long j5) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f10591a;
            if (i >= arrayList.size()) {
                return arrayList.size();
            }
            if (j5 < ((t3.a) arrayList.get(i)).f12072b) {
                return i;
            }
            i++;
        }
    }

    public void i(String str) {
        h.e(str, "name");
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f10591a;
            if (i >= arrayList.size()) {
                return;
            }
            if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                arrayList.remove(i);
                arrayList.remove(i);
                i -= 2;
            }
            i += 2;
        }
    }
}
