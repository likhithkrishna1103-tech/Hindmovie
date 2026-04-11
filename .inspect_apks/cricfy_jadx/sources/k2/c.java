package k2;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import v1.z0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements r2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6835e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f6836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f6837h;
    public final u i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f6838j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Uri f6839k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f6840l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List f6841m;

    public c(long j4, long j7, long j10, boolean z10, long j11, long j12, long j13, long j14, i iVar, u uVar, t tVar, Uri uri, ArrayList arrayList) {
        this.f6831a = j4;
        this.f6832b = j7;
        this.f6833c = j10;
        this.f6834d = z10;
        this.f6835e = j11;
        this.f = j12;
        this.f6836g = j13;
        this.f6837h = j14;
        this.f6840l = iVar;
        this.i = uVar;
        this.f6839k = uri;
        this.f6838j = tVar;
        this.f6841m = arrayList;
    }

    @Override // r2.a
    public final Object a(List list) {
        long j4;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new z0(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j7 = 0;
        int i = 0;
        while (true) {
            if (i >= this.f6841m.size()) {
                break;
            }
            if (((z0) linkedList.peek()).f13064v != i) {
                long jC = c(i);
                if (jC != -9223372036854775807L) {
                    j7 += jC;
                }
            } else {
                h hVarB = b(i);
                List list2 = hVarB.f6861c;
                z0 z0Var = (z0) linkedList.poll();
                int i10 = z0Var.f13064v;
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    int i11 = z0Var.f13065w;
                    a aVar = (a) list2.get(i11);
                    List list3 = aVar.f6824c;
                    ArrayList arrayList3 = new ArrayList();
                    do {
                        arrayList3.add((m) list3.get(z0Var.f13066x));
                        z0Var = (z0) linkedList.poll();
                        if (z0Var.f13064v != i10) {
                            break;
                        }
                    } while (z0Var.f13065w == i11);
                    j4 = j7;
                    arrayList2.add(new a(aVar.f6822a, aVar.f6823b, arrayList3, aVar.f6825d, aVar.f6826e, aVar.f));
                    if (z0Var.f13064v != i10) {
                        break;
                    }
                    j7 = j4;
                }
                linkedList.addFirst(z0Var);
                arrayList.add(new h(hVarB.f6859a, hVarB.f6860b - j4, arrayList2, hVarB.f6862d));
                j7 = j4;
            }
            i++;
        }
        long j10 = j7;
        long j11 = this.f6832b;
        return new c(this.f6831a, j11 != -9223372036854775807L ? j11 - j10 : -9223372036854775807L, this.f6833c, this.f6834d, this.f6835e, this.f, this.f6836g, this.f6837h, this.f6840l, this.i, this.f6838j, this.f6839k, arrayList);
    }

    public final h b(int i) {
        return (h) this.f6841m.get(i);
    }

    public final long c(int i) {
        long j4;
        long j7;
        List list = this.f6841m;
        if (i == list.size() - 1) {
            j4 = this.f6832b;
            if (j4 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j7 = ((h) list.get(i)).f6860b;
        } else {
            j4 = ((h) list.get(i + 1)).f6860b;
            j7 = ((h) list.get(i)).f6860b;
        }
        return j4 - j7;
    }

    public final long d(int i) {
        return a0.O(c(i));
    }
}
