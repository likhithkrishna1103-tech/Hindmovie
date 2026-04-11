package z6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0.c f15329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f15330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15331c;

    public z(Class cls, Class cls2, Class cls3, List list, s0.c cVar) {
        this.f15329a = cVar;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f15330b = list;
        this.f15331c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final b0 a(int i, int i10, ag.o oVar, com.bumptech.glide.load.data.f fVar, x6.h hVar) {
        s0.c cVar = this.f15329a;
        List list = (List) cVar.i();
        s7.f.c(list, "Argument must not be null");
        try {
            List list2 = this.f15330b;
            int size = list2.size();
            b0 b0VarA = null;
            for (int i11 = 0; i11 < size; i11++) {
                try {
                    b0VarA = ((l) list2.get(i11)).a(i, i10, oVar, fVar, hVar);
                } catch (x e9) {
                    list.add(e9);
                }
                if (b0VarA != null) {
                    break;
                }
            }
            if (b0VarA != null) {
                return b0VarA;
            }
            throw new x(this.f15331c, new ArrayList(list));
        } finally {
            cVar.b(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f15330b.toArray()) + '}';
    }
}
