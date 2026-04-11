package h2;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p1.z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends p {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final o f5740l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f5742e;
    public final List f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f5743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p1.q f5744h;
    public final List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f5745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f5746k;

    static {
        List list = Collections.EMPTY_LIST;
        f5740l = new o("", list, list, list, list, list, list, null, list, false, Collections.EMPTY_MAP, list);
    }

    public o(String str, List list, List list2, List list3, List list4, List list5, List list6, p1.q qVar, List list7, boolean z2, Map map, List list8) {
        super(str, list, z2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list2.size(); i++) {
            Uri uri = ((n) list2.get(i)).f5735a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        b(list6, arrayList);
        this.f5741d = Collections.unmodifiableList(arrayList);
        this.f5742e = Collections.unmodifiableList(list2);
        Collections.unmodifiableList(list3);
        this.f = Collections.unmodifiableList(list4);
        this.f5743g = Collections.unmodifiableList(list5);
        Collections.unmodifiableList(list6);
        this.f5744h = qVar;
        this.i = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f5745j = Collections.unmodifiableMap(map);
        this.f5746k = Collections.unmodifiableList(list8);
    }

    public static void b(List list, ArrayList arrayList) {
        for (int i = 0; i < list.size(); i++) {
            Uri uri = ((m) list.get(i)).f5732a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
    }

    public static ArrayList c(List list, int i, List list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            Object obj = list.get(i10);
            int i11 = 0;
            while (true) {
                if (i11 < list2.size()) {
                    z0 z0Var = (z0) list2.get(i11);
                    if (z0Var.f10124v == i && z0Var.f10125w == i10) {
                        arrayList.add(obj);
                        break;
                    }
                    i11++;
                }
            }
        }
        return arrayList;
    }

    @Override // l2.a
    public final Object a(List list) {
        ArrayList arrayListC = c(this.f5742e, 0, list);
        List list2 = Collections.EMPTY_LIST;
        return new o(this.f5747a, this.f5748b, arrayListC, list2, c(this.f, 1, list), c(this.f5743g, 2, list), list2, this.f5744h, this.i, this.f5749c, this.f5745j, this.f5746k);
    }
}
