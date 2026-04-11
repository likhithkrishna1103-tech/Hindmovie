package e2;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import p1.z0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements l2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4303e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4305h;
    public final u i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f4306j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Uri f4307k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f4308l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f4309m;

    public c(long j5, long j8, long j10, boolean z2, long j11, long j12, long j13, long j14, i iVar, u uVar, t tVar, Uri uri, ArrayList arrayList) {
        this.f4299a = j5;
        this.f4300b = j8;
        this.f4301c = j10;
        this.f4302d = z2;
        this.f4303e = j11;
        this.f = j12;
        this.f4304g = j13;
        this.f4305h = j14;
        this.f4308l = iVar;
        this.i = uVar;
        this.f4307k = uri;
        this.f4306j = tVar;
        this.f4309m = arrayList;
    }

    @Override // l2.a
    public final Object a(List list) {
        long j5;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new z0(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j8 = 0;
        int i = 0;
        while (true) {
            if (i >= this.f4309m.size()) {
                break;
            }
            if (((z0) linkedList.peek()).f10123u != i) {
                long jC = c(i);
                if (jC != -9223372036854775807L) {
                    j8 += jC;
                }
            } else {
                h hVarB = b(i);
                List list2 = hVarB.f4330c;
                z0 z0Var = (z0) linkedList.poll();
                int i10 = z0Var.f10123u;
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    int i11 = z0Var.f10124v;
                    a aVar = (a) list2.get(i11);
                    List list3 = aVar.f4292c;
                    ArrayList arrayList3 = new ArrayList();
                    do {
                        arrayList3.add((m) list3.get(z0Var.f10125w));
                        z0Var = (z0) linkedList.poll();
                        if (z0Var.f10123u != i10) {
                            break;
                        }
                    } while (z0Var.f10124v == i11);
                    j5 = j8;
                    arrayList2.add(new a(aVar.f4290a, aVar.f4291b, arrayList3, aVar.f4293d, aVar.f4294e, aVar.f));
                    if (z0Var.f10123u != i10) {
                        break;
                    }
                    j8 = j5;
                }
                linkedList.addFirst(z0Var);
                arrayList.add(new h(hVarB.f4328a, hVarB.f4329b - j5, arrayList2, hVarB.f4331d));
                j8 = j5;
            }
            i++;
        }
        long j10 = j8;
        long j11 = this.f4300b;
        return new c(this.f4299a, j11 != -9223372036854775807L ? j11 - j10 : -9223372036854775807L, this.f4301c, this.f4302d, this.f4303e, this.f, this.f4304g, this.f4305h, this.f4308l, this.i, this.f4306j, this.f4307k, arrayList);
    }

    public final h b(int i) {
        return (h) this.f4309m.get(i);
    }

    public final long c(int i) {
        long j5;
        long j8;
        List list = this.f4309m;
        if (i == list.size() - 1) {
            j5 = this.f4300b;
            if (j5 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j8 = ((h) list.get(i)).f4329b;
        } else {
            j5 = ((h) list.get(i + 1)).f4329b;
            j8 = ((h) list.get(i)).f4329b;
        }
        return j5 - j8;
    }

    public final long d(int i) {
        return b0.O(c(i));
    }
}
