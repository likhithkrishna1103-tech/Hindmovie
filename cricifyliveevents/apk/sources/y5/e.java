package y5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f14927e;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f14928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14929h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f14930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f14931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f14932l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f14933m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f14934n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14935o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14936p;

    public static List b(ArrayList arrayList) {
        if (arrayList.size() < 2) {
            return arrayList;
        }
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            e eVar = (e) arrayList.get(i);
            if (eVar.f14935o == 1 && !eVar.f14936p) {
                map.put(Integer.valueOf(i), eVar);
            } else if (eVar.f14936p) {
                arrayList3.add(eVar);
            } else {
                arrayList2.add(eVar);
            }
        }
        Collections.sort(arrayList2, new g4.d(22));
        Collections.sort(arrayList3, new g4.d(23));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        ArrayList arrayList5 = new ArrayList(arrayList.size());
        int i10 = 0;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            if (map.containsKey(Integer.valueOf(i11))) {
                arrayList5.add((e) map.get(Integer.valueOf(i11)));
            } else {
                arrayList5.add((e) arrayList4.get(i10));
                i10++;
            }
        }
        return arrayList5;
    }

    public final Date a() {
        try {
            return new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss").parse(this.f14930j + "|" + this.i);
        } catch (ParseException unused) {
            return null;
        }
    }
}
