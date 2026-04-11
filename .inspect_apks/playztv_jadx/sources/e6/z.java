package e6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0.c f4579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f4580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4581c;

    public z(Class cls, Class cls2, Class cls3, List list, p0.c cVar) {
        this.f4579a = cVar;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f4580b = list;
        this.f4581c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final b0 a(int i, int i10, c6.i iVar, com.bumptech.glide.load.data.g gVar, i iVar2) {
        p0.c cVar = this.f4579a;
        Object objI = cVar.i();
        x6.f.c(objI, "Argument must not be null");
        List list = (List) objI;
        try {
            List list2 = this.f4580b;
            int size = list2.size();
            b0 b0VarA = null;
            for (int i11 = 0; i11 < size; i11++) {
                try {
                    b0VarA = ((l) list2.get(i11)).a(i, i10, iVar, gVar, iVar2);
                } catch (x e10) {
                    list.add(e10);
                }
                if (b0VarA != null) {
                    break;
                }
            }
            if (b0VarA != null) {
                return b0VarA;
            }
            throw new x(this.f4581c, new ArrayList(list));
        } finally {
            cVar.b(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f4580b.toArray()) + '}';
    }
}
