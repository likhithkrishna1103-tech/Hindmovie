package n5;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements m, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f8760a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f8761b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f8762c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f8763d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s5.g f8764e;

    public l(s5.g gVar) {
        this.f8764e = gVar;
    }

    public final void b(Path.Op op) {
        Path path = this.f8761b;
        path.reset();
        Path path2 = this.f8760a;
        path2.reset();
        ArrayList arrayList = this.f8763d;
        for (int size = arrayList.size() - 1; size >= 1; size--) {
            m mVar = (m) arrayList.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                ArrayList arrayList2 = (ArrayList) dVar.d();
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Path pathF = ((m) arrayList2.get(size2)).f();
                    Matrix matrixE = dVar.f8707c;
                    o5.q qVar = dVar.f8713k;
                    if (qVar != null) {
                        matrixE = qVar.e();
                    } else {
                        matrixE.reset();
                    }
                    pathF.transform(matrixE);
                    path.addPath(pathF);
                }
            } else {
                path.addPath(mVar.f());
            }
        }
        int i = 0;
        m mVar2 = (m) arrayList.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List listD = dVar2.d();
            while (true) {
                ArrayList arrayList3 = (ArrayList) listD;
                if (i >= arrayList3.size()) {
                    break;
                }
                Path pathF2 = ((m) arrayList3.get(i)).f();
                Matrix matrixE2 = dVar2.f8707c;
                o5.q qVar2 = dVar2.f8713k;
                if (qVar2 != null) {
                    matrixE2 = qVar2.e();
                } else {
                    matrixE2.reset();
                }
                pathF2.transform(matrixE2);
                path2.addPath(pathF2);
                i++;
            }
        } else {
            path2.set(mVar2.f());
        }
        this.f8762c.op(path2, path, op);
    }

    @Override // n5.c
    public final void c(List list, List list2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f8763d;
            if (i >= arrayList.size()) {
                return;
            }
            ((m) arrayList.get(i)).c(list, list2);
            i++;
        }
    }

    @Override // n5.j
    public final void d(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar instanceof m) {
                this.f8763d.add((m) cVar);
                listIterator.remove();
            }
        }
    }

    @Override // n5.m
    public final Path f() {
        Path path = this.f8762c;
        path.reset();
        s5.g gVar = this.f8764e;
        if (!gVar.f11820b) {
            int iC = v.e.c(gVar.f11819a);
            if (iC == 0) {
                int i = 0;
                while (true) {
                    ArrayList arrayList = this.f8763d;
                    if (i >= arrayList.size()) {
                        break;
                    }
                    path.addPath(((m) arrayList.get(i)).f());
                    i++;
                }
            } else {
                if (iC == 1) {
                    b(Path.Op.UNION);
                    return path;
                }
                if (iC == 2) {
                    b(Path.Op.REVERSE_DIFFERENCE);
                    return path;
                }
                if (iC == 3) {
                    b(Path.Op.INTERSECT);
                    return path;
                }
                if (iC == 4) {
                    b(Path.Op.XOR);
                    return path;
                }
            }
        }
        return path;
    }
}
