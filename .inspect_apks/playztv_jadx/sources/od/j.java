package od;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends android.support.v4.media.session.b {
    public static int R(List list) {
        be.h.e(list, "<this>");
        return list.size() - 1;
    }

    public static List S(Object... objArr) {
        be.h.e(objArr, "elements");
        return objArr.length > 0 ? h.Q(objArr) : q.f9570u;
    }

    public static final List T(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : android.support.v4.media.session.b.G(list.get(0)) : q.f9570u;
    }
}
