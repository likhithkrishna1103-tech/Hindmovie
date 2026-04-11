package m6;

import j6.j;
import j6.m;
import java.util.ArrayList;
import java.util.List;
import ua.g0;
import ua.i0;
import ua.q;
import ua.z0;
import x6.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements f, u2.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f8373v;

    public c(int i) {
        switch (i) {
            case 2:
                this.f8373v = new ArrayList();
                break;
            default:
                this.f8373v = new ArrayList();
                break;
        }
    }

    @Override // m6.f
    public j6.e D0() {
        ArrayList arrayList = this.f8373v;
        return ((t6.a) arrayList.get(0)).c() ? new j(1, arrayList) : new m(arrayList);
    }

    @Override // m6.f
    public List U0() {
        return this.f8373v;
    }

    @Override // m6.f
    public boolean Y0() {
        ArrayList arrayList = this.f8373v;
        return arrayList.size() == 1 && ((t6.a) arrayList.get(0)).c();
    }

    @Override // u2.a
    public i0 a(long j4) {
        int iG = g(j4);
        if (iG == 0) {
            g0 g0Var = i0.f12341w;
            return z0.f12413z;
        }
        x3.c cVar = (x3.c) this.f8373v.get(iG - 1);
        long j7 = cVar.f14295d;
        if (j7 == -9223372036854775807L || j4 < j7) {
            return cVar.f14292a;
        }
        g0 g0Var2 = i0.f12341w;
        return z0.f12413z;
    }

    @Override // u2.a
    public long b(long j4) {
        ArrayList arrayList = this.f8373v;
        if (arrayList.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j4 < ((x3.c) arrayList.get(0)).f14293b) {
            return ((x3.c) arrayList.get(0)).f14293b;
        }
        for (int i = 1; i < arrayList.size(); i++) {
            x3.c cVar = (x3.c) arrayList.get(i);
            long j7 = cVar.f14293b;
            long j10 = cVar.f14293b;
            if (j4 < j7) {
                long j11 = ((x3.c) arrayList.get(i - 1)).f14295d;
                return (j11 == -9223372036854775807L || j11 <= j4 || j11 >= j10) ? j10 : j11;
            }
        }
        long j12 = ((x3.c) q.l(arrayList)).f14295d;
        if (j12 == -9223372036854775807L || j4 >= j12) {
            return Long.MIN_VALUE;
        }
        return j12;
    }

    @Override // u2.a
    public long c(long j4) {
        ArrayList arrayList = this.f8373v;
        if (arrayList.isEmpty() || j4 < ((x3.c) arrayList.get(0)).f14293b) {
            return -9223372036854775807L;
        }
        for (int i = 1; i < arrayList.size(); i++) {
            long j7 = ((x3.c) arrayList.get(i)).f14293b;
            if (j4 == j7) {
                return j7;
            }
            if (j4 < j7) {
                x3.c cVar = (x3.c) arrayList.get(i - 1);
                long j10 = cVar.f14295d;
                return (j10 == -9223372036854775807L || j10 > j4) ? cVar.f14293b : j10;
            }
        }
        x3.c cVar2 = (x3.c) q.l(arrayList);
        long j11 = cVar2.f14295d;
        return (j11 == -9223372036854775807L || j4 < j11) ? cVar2.f14293b : j11;
    }

    @Override // u2.a
    public void clear() {
        this.f8373v.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    @Override // u2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(x3.c r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.f14293b
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
            y1.d.b(r4)
            int r4 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r4 > 0) goto L23
            long r7 = r10.f14295d
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
            java.util.ArrayList r3 = r9.f8373v
            int r4 = r3.size()
            int r4 = r4 - r6
        L2b:
            if (r4 < 0) goto L4e
            java.lang.Object r7 = r3.get(r4)
            x3.c r7 = (x3.c) r7
            long r7 = r7.f14293b
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 < 0) goto L3e
            int r4 = r4 + r6
            r3.add(r4, r10)
            return r2
        L3e:
            java.lang.Object r7 = r3.get(r4)
            x3.c r7 = (x3.c) r7
            long r7 = r7.f14293b
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
        throw new UnsupportedOperationException("Method not decompiled: m6.c.d(x3.c, long):boolean");
    }

    @Override // u2.a
    public void e(long j4) {
        int iG = g(j4);
        if (iG == 0) {
            return;
        }
        ArrayList arrayList = this.f8373v;
        long j7 = ((x3.c) arrayList.get(iG - 1)).f14295d;
        if (j7 == -9223372036854775807L || j7 >= j4) {
            iG--;
        }
        arrayList.subList(0, iG).clear();
    }

    public synchronized k f(Class cls) {
        int size = this.f8373v.size();
        for (int i = 0; i < size; i++) {
            n7.d dVar = (n7.d) this.f8373v.get(i);
            if (dVar.f8856a.isAssignableFrom(cls)) {
                return dVar.f8857b;
            }
        }
        return null;
    }

    public int g(long j4) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f8373v;
            if (i >= arrayList.size()) {
                return arrayList.size();
            }
            if (j4 < ((x3.c) arrayList.get(i)).f14293b) {
                return i;
            }
            i++;
        }
    }

    public c(ArrayList arrayList) {
        this.f8373v = arrayList;
    }
}
