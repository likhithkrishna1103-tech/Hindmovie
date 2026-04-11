package i6;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements n, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f6287a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f6288b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f6289c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f6290d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n6.g f6291e;

    public m(n6.g gVar) {
        this.f6291e = gVar;
    }

    public final void b(Path.Op op) {
        Path path = this.f6288b;
        path.reset();
        Path path2 = this.f6287a;
        path2.reset();
        ArrayList arrayList = this.f6290d;
        for (int size = arrayList.size() - 1; size >= 1; size--) {
            n nVar = (n) arrayList.get(size);
            if (nVar instanceof e) {
                e eVar = (e) nVar;
                ArrayList arrayList2 = (ArrayList) eVar.d();
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Path pathF = ((n) arrayList2.get(size2)).f();
                    Matrix matrixE = eVar.f6235d;
                    j6.r rVar = eVar.f6241l;
                    if (rVar != null) {
                        matrixE = rVar.e();
                    } else {
                        matrixE.reset();
                    }
                    pathF.transform(matrixE);
                    path.addPath(pathF);
                }
            } else {
                path.addPath(nVar.f());
            }
        }
        int i = 0;
        n nVar2 = (n) arrayList.get(0);
        if (nVar2 instanceof e) {
            e eVar2 = (e) nVar2;
            List listD = eVar2.d();
            while (true) {
                ArrayList arrayList3 = (ArrayList) listD;
                if (i >= arrayList3.size()) {
                    break;
                }
                Path pathF2 = ((n) arrayList3.get(i)).f();
                Matrix matrixE2 = eVar2.f6235d;
                j6.r rVar2 = eVar2.f6241l;
                if (rVar2 != null) {
                    matrixE2 = rVar2.e();
                } else {
                    matrixE2.reset();
                }
                pathF2.transform(matrixE2);
                path2.addPath(pathF2);
                i++;
            }
        } else {
            path2.set(nVar2.f());
        }
        this.f6289c.op(path2, path, op);
    }

    @Override // i6.d
    public final void c(List list, List list2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f6290d;
            if (i >= arrayList.size()) {
                return;
            }
            ((n) arrayList.get(i)).c(list, list2);
            i++;
        }
    }

    @Override // i6.k
    public final void d(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            d dVar = (d) listIterator.previous();
            if (dVar instanceof n) {
                this.f6290d.add((n) dVar);
                listIterator.remove();
            }
        }
    }

    @Override // i6.n
    public final Path f() {
        Path path = this.f6289c;
        path.reset();
        n6.g gVar = this.f6291e;
        if (!gVar.f8804b) {
            int iC = y.e.c(gVar.f8803a);
            if (iC == 0) {
                int i = 0;
                while (true) {
                    ArrayList arrayList = this.f6290d;
                    if (i >= arrayList.size()) {
                        break;
                    }
                    path.addPath(((n) arrayList.get(i)).f());
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
