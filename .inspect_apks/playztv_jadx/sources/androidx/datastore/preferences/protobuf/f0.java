package androidx.datastore.preferences.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class f1042c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    public static List d(int i, long j5, Object obj) {
        List list = (List) s1.f1128d.i(j5, obj);
        if (list.isEmpty()) {
            List d0Var = list instanceof e0 ? new d0(i) : ((list instanceof x0) && (list instanceof y)) ? ((y) list).k(i) : new ArrayList(i);
            s1.o(obj, j5, d0Var);
            return d0Var;
        }
        if (f1042c.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i);
            arrayList.addAll(list);
            s1.o(obj, j5, arrayList);
            return arrayList;
        }
        if (list instanceof n1) {
            d0 d0Var2 = new d0(list.size() + i);
            d0Var2.addAll((n1) list);
            s1.o(obj, j5, d0Var2);
            return d0Var2;
        }
        if ((list instanceof x0) && (list instanceof y)) {
            y yVar = (y) list;
            if (!((b) yVar).f1011u) {
                y yVarK = yVar.k(list.size() + i);
                s1.o(obj, j5, yVarK);
                return yVarK;
            }
        }
        return list;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void a(long j5, Object obj) {
        Object objUnmodifiableList;
        List list = (List) s1.f1128d.i(j5, obj);
        if (list instanceof e0) {
            objUnmodifiableList = ((e0) list).o();
        } else {
            if (f1042c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof x0) && (list instanceof y)) {
                b bVar = (b) ((y) list);
                if (bVar.f1011u) {
                    bVar.f1011u = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        s1.o(obj, j5, objUnmodifiableList);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void b(Object obj, long j5, Object obj2) {
        List list = (List) s1.f1128d.i(j5, obj2);
        List listD = d(list.size(), j5, obj);
        int size = listD.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listD.addAll(list);
        }
        if (size > 0) {
            list = listD;
        }
        s1.o(obj, j5, list);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final List c(long j5, Object obj) {
        return d(10, j5, obj);
    }
}
