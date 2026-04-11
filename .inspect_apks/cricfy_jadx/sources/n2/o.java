package n2;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import v1.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends p {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final o f8715l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f8716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f8717e;
    public final List f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f8718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v1.p f8719h;
    public final List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f8720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f8721k;

    static {
        List list = Collections.EMPTY_LIST;
        f8715l = new o("", list, list, list, list, list, list, null, list, false, Collections.EMPTY_MAP, list);
    }

    public o(String str, List list, List list2, List list3, List list4, List list5, List list6, v1.p pVar, List list7, boolean z10, Map map, List list8) {
        super(str, list, z10);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list2.size(); i++) {
            Uri uri = ((n) list2.get(i)).f8710a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        b(list6, arrayList);
        this.f8716d = Collections.unmodifiableList(arrayList);
        this.f8717e = Collections.unmodifiableList(list2);
        Collections.unmodifiableList(list3);
        this.f = Collections.unmodifiableList(list4);
        this.f8718g = Collections.unmodifiableList(list5);
        Collections.unmodifiableList(list6);
        this.f8719h = pVar;
        this.i = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f8720j = Collections.unmodifiableMap(map);
        this.f8721k = Collections.unmodifiableList(list8);
    }

    public static void b(List list, ArrayList arrayList) {
        for (int i = 0; i < list.size(); i++) {
            Uri uri = ((m) list.get(i)).f8707a;
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
                    if (z0Var.f13065w == i && z0Var.f13066x == i10) {
                        arrayList.add(obj);
                        break;
                    }
                    i11++;
                }
            }
        }
        return arrayList;
    }

    @Override // r2.a
    public final Object a(List list) {
        ArrayList arrayListC = c(this.f8717e, 0, list);
        List list2 = Collections.EMPTY_LIST;
        return new o(this.f8722a, this.f8723b, arrayListC, list2, c(this.f, 1, list), c(this.f8718g, 2, list), list2, this.f8719h, this.i, this.f8724c, this.f8720j, this.f8721k);
    }
}
